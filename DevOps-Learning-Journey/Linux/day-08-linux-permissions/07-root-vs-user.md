# Root and ordinary users

**Module:** Linux

**Topic:** Linux permissions

## What is Root and ordinary users?

Root is the account with user ID 0 and broad administrative power. Ordinary users operate within their assigned permissions and privileges.

A building manager may change the access system. A resident should not need that authority just to read their own notes.

## Why does this matter in DevOps?

Run applications under dedicated service accounts so an application bug has less power over the rest of the server. Use administrator privileges only for the tasks that require them.

## Simple practice

```bash
whoami
id
id -u
printf "%s\n" "$HOME"
```

The username is a readable label. The numeric UID is the key identity used for many filesystem ownership checks. A root shell reports UID 0, regardless of what you assumed from its prompt colour or name.

**What you should see:**

```text
Your account name, user/group IDs, numeric user ID, and home path. Ordinary users normally have a nonzero UID.
```

## Real scenario: An application runs as root because it could not write its log folder.

Identify the intended service user and provision the correct log-directory ownership and access. Then run the application under that identity. Administrative power should not be the workaround for an ordinary directory problem.

## Important detail

A username shared by two laptops does not automatically mean the same identity or shared files. Root inside a container is also not identical to unrestricted host root in every setup; namespaces, capabilities, and other controls affect its power. Separate home folders are not automatically private: directory permissions still matter.

## What to remember

**Check the actual UID and permissions, not just the account’s name.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man7/credentials.7.html)

[Previous: sudo: run an allowed command as another user](06-sudo.md) | [Next: setuid: a program with a different effective owner](08-setuid-basics.md)
