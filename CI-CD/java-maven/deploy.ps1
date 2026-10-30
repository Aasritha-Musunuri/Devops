param(
    [Parameter(Mandatory = $true)][string]$ArtifactDirectory,
    [Parameter(Mandatory = $true)][ValidatePattern('^[a-zA-Z0-9][a-zA-Z0-9_.-]{0,100}$')][string]$ImageTag
)

$ErrorActionPreference = 'Stop'
$docker = (Get-Command docker -ErrorAction SilentlyContinue).Source
if (-not $docker) {
    $docker = 'C:\Program Files\Docker\Docker\resources\bin\docker.exe'
}
if (-not (Test-Path -LiteralPath $docker)) { throw 'Docker Desktop is not installed.' }
$artifact = (Resolve-Path -LiteralPath $ArtifactDirectory).Path
if (-not (Test-Path -LiteralPath (Join-Path $artifact 'shipping-quote-1.0.0.jar'))) {
    throw 'The tested JAR is missing from the downloaded artifact.'
}

function Invoke-Docker {
    param([string[]]$DockerArgs)
    & $docker @DockerArgs
    if ($LASTEXITCODE -ne 0) { throw "Docker command failed: $($DockerArgs[0])" }
}

$engine = Invoke-Docker -DockerArgs @('info', '--format', '{{.OSType}}')
if ($engine -ne 'linux') { throw 'Start Docker Desktop with Linux containers.' }
$image = "shipping-quote:$ImageTag"
Invoke-Docker -DockerArgs @('build', '--label', "org.opencontainers.image.revision=$ImageTag", '-f', (Join-Path $PSScriptRoot 'Dockerfile.deploy'), '-t', $image, $artifact)

$container = 'shipping-quote'
$backup = "shipping-quote-previous-$ImageTag"
$existing = Invoke-Docker -DockerArgs @('ps', '-aq', '--filter', "name=^/$container$")
$hasBackup = $false
$created = $false
try {
    if ($existing) {
        Invoke-Docker -DockerArgs @('rename', $container, $backup)
        $hasBackup = $true
        Invoke-Docker -DockerArgs @('stop', $backup)
    }
    $created = $true
    Invoke-Docker -DockerArgs @('run', '-d', '--name', $container, '--restart', 'unless-stopped', '-p', '127.0.0.1:8082:8080', $image)
    $healthy = $false
    for ($attempt = 0; $attempt -lt 30; $attempt++) {
        try {
            $response = Invoke-RestMethod -Uri 'http://127.0.0.1:8082/health' -TimeoutSec 2
            if ($response.status -eq 'ok') { $healthy = $true; break }
        } catch { }
        Start-Sleep -Seconds 1
    }
    if (-not $healthy) { throw 'The new container did not pass its health check.' }
    $quote = Invoke-RestMethod -Uri 'http://127.0.0.1:8082/api/shipping?amount=499' -TimeoutSec 5
    if ($quote.shipping -ne 50 -or $quote.total -ne 549) { throw 'The deployed calculator returned an incorrect quote.' }
    $page = Invoke-WebRequest -UseBasicParsing -Uri 'http://127.0.0.1:8082/' -TimeoutSec 5
    if ($page.Content -notmatch 'id="quote-form"') { throw 'The deployed webpage is missing.' }
} catch {
    $failure = $_
    $failedContainer = & $docker ps -aq --filter "name=^/$container$"
    if ($created -and $failedContainer) { & $docker logs $container; & $docker rm -f $container }
    if ($hasBackup) {
        & $docker rename $backup $container
        & $docker start $container
        Write-Warning 'Restored the previous container after deployment failed.'
    }
    throw $failure
}
if ($hasBackup) { Invoke-Docker -DockerArgs @('rm', $backup) }
Write-Output "Deployed $image at http://localhost:8082"
