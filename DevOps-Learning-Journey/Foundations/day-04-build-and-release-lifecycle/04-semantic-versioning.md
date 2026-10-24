# Semantic versioning

**Module:** Foundations

**Topic:** Build and release lifecycle

## What is versioning?

Versioning gives a release an identifier so we can tell it apart from other releases.

For example, `shopping-app-2.3.1.zip` identifies one application release.

## What does semantic mean?

**Semantic means related to meaning.**

In semantic versioning, each part of the version number tells us something about the change.

```text
MAJOR.MINOR.PATCH
   2 . 3 . 1
```

## PATCH: a compatible bug fix

```text
2.3.1 -> 2.3.2
```

**Example:** Fix an incorrect total without changing how existing users or applications use the software.

## MINOR: a compatible addition

```text
2.3.2 -> 2.4.0
```

**Example:** Add a new library function while keeping existing functions working.

## MAJOR: a breaking change

```text
2.4.0 -> 3.0.0
```

**Example:** Remove a library function that another application calls. That application may need changes before it can use the new release.

A breaking change means existing usage may no longer work as before.

## Real example: an update breaks the application

The team updates a library to a new major version. A function the application uses is no longer available.

**What to do:** Read the release notes, identify the required code changes, and test before deploying the update.

These version meanings apply when the project follows semantic versioning. Not every project does.

## Why does this matter in DevOps?

Knowing the deployed version helps the team investigate changes and select a previous release if returning to it is safe.

Avoid replacing different release contents under the same identifier. Keep a record of the source commit, build, and package used.

## What to remember

**Patch fixes. Minor adds. Major breaks compatibility.**

## Further reading

[Semantic Versioning](https://semver.org/)

[Back to Day 4](README.md) | [Next: Environments](05-application-environments.md)
