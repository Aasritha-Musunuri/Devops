# Source to a running application

**Module:** Foundations

**Topic:** Build and release lifecycle

## What are these steps?

These steps describe how code written by a developer reaches the people using an application.

Think of preparing and delivering a cake.

## 1. Source: the recipe

Source code is the application's instructions, written by developers.

For a C# application, these instructions are usually in `.cs` files. Git keeps a record of changes to those files.

**Example:** A developer changes the shopping application's discount calculation.

## 2. Build: prepare the cake

A build turns source code into application files that can be prepared for deployment.

For C#, the compiler translates the code and checks language rules.

**Example:** If the developer puts text where a number is required, compilation can fail. Correct the code and build again.

A successful build does not prove everything works. A wrong database password might only cause a problem when the application runs.

## 3. Artifact: keep the result

An artifact is an output saved for later use. A deployable artifact might be application files, a ZIP file, or a container image.

A container image is a bundle used to start an application in a container. We will cover containers later.

**Build is the activity. Artifact is the result.**

Save the result with an identifiable version, such as `shopping-app-1.2.0.zip`, so the team knows what was tested and deployed.

## 4. Package: prepare it for delivery

Packaging puts the application and required files into a suitable delivery format, such as a ZIP.

Like a lunchbox, it should contain what is needed for the meal. If a required library is left out, the application may fail after delivery.

**The resulting package is also an artifact.** These are not always separate pipeline steps.

Keep production passwords outside the package and provide them securely where the application runs.

## 5. Deploy: deliver and set up

Deployment puts an application version in its target environment: the setup where it will run.

For example, download the ZIP, put the files in place, supply the correct settings, and start the application. A deployment tool may automate all of this.

## 6. Run: execute the application

Running means the application is executing as a process and using CPU and memory.

A website normally stays running to answer requests. A report program may finish its work and exit normally.

## Real example: deployment passed, but the website is down

**Possible cause:** The files arrived, but the application could not start because a required setting was missing.

**What to check:** Read the startup error, correct the setting, and restart as needed. Then check the website and an important action, such as opening an order.

A running process alone does not prove that every feature works.

## What to remember

**Build creates the output. Packaging prepares it. Deployment delivers it. Running executes it. Verification checks that it works.**

Prefer testing one identifiable package and deploying that same package to production with the correct settings.

## Further reading

[Preparing a .NET application for deployment](https://learn.microsoft.com/en-us/dotnet/core/tools/dotnet-publish)

[Back to Day 4](README.md) | [Next: Dependencies](02-dependencies.md)
