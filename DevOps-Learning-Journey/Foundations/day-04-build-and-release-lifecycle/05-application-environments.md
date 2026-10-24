# Development, test, staging, and production

**Module:** Foundations

**Topic:** Build and release lifecycle

## What is an environment?

An environment is a setup where an application runs. It includes the settings and connected systems the application uses.

Think of preparing a school play.

## Development: practice

Developers write and try changes here.

**Example:** Add a discount calculation and check it while developing the shopping application.

## Test: check the work

Testers and automated tests look for problems.

**Example:** Check whether the discount is correct for normal orders, empty orders, and invalid inputs.

## Staging: dress rehearsal

Staging is used to try the release in a setup resembling production where it matters.

**Example:** Check that deployment, application settings, and connected systems work together before the release reaches customers.

## Production: live performance

Production serves real users or business work.

**Example:** Customers place orders and make payments.

Teams may use different names or combine some environments.

## Real example: testing changed real customer orders

**Possible cause:** The test application was connected to the production database.

**What to do:** Stop the unintended changes, investigate affected records, and follow the team's recovery process.

Use separate test databases and credentials. Restrict test access so a wrong database address does not accidentally give a test application permission to change production data.

## If staging passed, will production definitely work?

No. Production can have different traffic, data, permissions, or settings.

Staging reduces risk, but it cannot recreate every production condition.

## What to remember

**Development: try. Test: check. Staging: rehearse. Production: serve real users.**

## Further reading

[Deployment environments in GitHub](https://docs.github.com/en/actions/how-tos/deploy/configure-and-manage-deployments/manage-environments)

[Back to Day 4](README.md) | [Next: Configuration](06-configuration-per-environment.md)
