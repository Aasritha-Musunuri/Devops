# Mapping the lifecycle to CI/CD stages

**Module:** Foundations

**Topic:** Build and release lifecycle

## What is a pipeline?

A pipeline is an automated sequence of tasks, such as getting code, building it, testing it, and deploying it.

A stage is a named group of work. Different tools organize the work differently; the task matters more than its name.

## Example: releasing the shopping application

### 1. Checkout: get the source

Get the selected Git commit so the pipeline starts with the intended code.

### 2. Restore: get dependencies

Obtain the packages the project needs, such as a PDF library.

### 3. Build: create application output

Compile the code. A compilation error should stop a release that depends on that build.

### 4. Test: check behavior

Run automated tests, such as checking the discount calculation.

### 5. Publish and package: prepare delivery

Prepare the files needed to run the application, then put them in a suitable delivery format, such as a ZIP or container image.

In .NET, publishing prepares application files; it does not automatically send them to production.

### 6. Store: keep the artifact

Save the package with an identifiable version so the team knows which result was tested.

### 7. Deploy: deliver and configure

Put that package in the target environment and supply its settings. Starting or restarting the application may be part of this work.

### 8. Verify: check the application

Check health and important actions. If a check fails, investigate and use the planned recovery approach.

For example, a working home page does not prove checkout works. A check of checkout in a suitable test setup can reveal a payment-service problem that the home page misses.

## What do CI and CD mean?

**Continuous Integration (CI):** Regularly combine code changes and automatically build and test them.

**Continuous Delivery:** Keep checked changes ready to release. Production deployment can still need approval.

**Continuous Deployment:** Automatically deploy to production when the required checks pass.

## Real example: tests failed, but deployment happened

**Possible cause:** Deployment was not required to wait for successful tests, or a failure was ignored.

**What to do:** Check the pipeline's task order and failure rules. Required tests must pass before the release continues.

## Must every pipeline use these exact stages?

No. Teams can combine or rename them. Some commands do several tasks, and later jobs may need to download files saved by earlier jobs.

## What to remember

**Get code -> get dependencies -> build -> test -> package -> store -> deploy -> verify.**

## Further reading

[GitHub Actions workflows](https://docs.github.com/en/actions/concepts/workflows-and-actions/workflows)

[Back to Day 4](README.md) | [Learning journey](../../README.md)
