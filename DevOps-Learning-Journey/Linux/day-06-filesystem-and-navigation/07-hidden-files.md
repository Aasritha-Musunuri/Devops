# Hidden files

**Module:** Linux

**Topic:** Filesystem and navigation

## What is a hidden file in Linux?

A filename starting with a dot is normally omitted from the default `ls` listing. This convention also applies to directories.

Examples include `.bashrc`, `.git`, and `.env`.

Think of putting everyday settings in a separate drawer to keep the main workspace tidy. The drawer is still there; it has not been locked.

## How do we see them?

In Linux:

```bash
ls -a
```

This includes hidden names. `ls -la` also shows details.

The special entries `.` and `..` refer to the current and parent directories. They are not ordinary files to edit.

## Where does this appear in DevOps?

- `.git` stores a Git repository's internal data in a normal working copy.
- `.bashrc` can contain settings for interactive Bash sessions.
- `.env` is commonly used by tools to read settings, but support depends on the application or tool. Linux does not automatically load every `.env` file.

## Real example: the application lost its settings after packaging

A packaging command selected only names matched by `*`. In common default Bash settings, that pattern leaves out names starting with a dot.

**What to check:** Inspect the package contents and the application's required files. Explicitly include required non-secret files. Do not copy every hidden file blindly: `.env` may contain secrets, and `.git` is usually not needed in a deployment package.

## Does hidden mean secure?

No. The name does not encrypt the contents or control who can read them. Access permissions and proper secret handling still matter.

## What to remember

**Hidden means omitted from ordinary listings, not protected.**

## Further reading

[ls and hidden names - GNU Coreutils](https://www.gnu.org/software/coreutils/manual/html_node/ls-invocation.html)

[Back to Day 6](README.md) | [Learning journey](../../README.md)
