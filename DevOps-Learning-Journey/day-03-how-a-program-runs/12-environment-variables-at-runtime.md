# Environment variables at runtime

## What is an environment variable?

An environment variable is a named string value available to a process. Programs can read these values to obtain settings without changing their source code.

For example, an application might read `APP_ENVIRONMENT=staging` to select its environment. The application must be written to recognize that name; it is not a universal setting.

## What does “at runtime” mean?

It means while the application is executing. An application can read environment variables during startup or later, depending on how it handles configuration.

A newly started child process normally inherits an environment from its parent. Changing a value in one terminal does not automatically change an already-running service or another terminal.

The application also decides which configuration source takes precedence when the same setting exists in several places.

## Practical example

In PowerShell, use a temporary, non-secret value:

```powershell
$env:DEVOPS_DAY3_DEMO = 'learning'
$env:DEVOPS_DAY3_DEMO
Remove-Item Env:DEVOPS_DAY3_DEMO
```

The second command prints `learning`. The last command removes the demo variable. This changes the current PowerShell process environment, not permanent machine settings.

The name is an example; it does not configure an application automatically.

## DevOps scenario: configuration changed, behavior did not

A service still connects to an old endpoint after a variable is changed elsewhere. Confirm where the service gets its environment, whether it has been restarted or redeployed, and whether another configuration source overrides the setting. Application-specific refresh behavior matters.

Never print all environment variables indiscriminately into pipeline logs: they can contain credentials. Environment variables are a configuration delivery mechanism, not inherently a secret store.

## Quick revision

- **Does a variable in my terminal update every process?** No.
- **Will an application recognize any variable name?** No; it must read that setting.
- **Are environment-variable values automatically encrypted?** No.

## Reference

[PowerShell environment variables](https://learn.microsoft.com/en-us/powershell/module/microsoft.powershell.core/about/about_environment_variables)

[Back to Day 3](README.md) | [Learning journey](../README.md)
