# /etc/shadow: protected password information

**Module:** Linux

**Topic:** Users and groups

## What is /etc/shadow?

`/etc/shadow` stores local account password hashes and password-age information on systems using shadow passwords. It is protected from ordinary users.

The account address book is readable, but the authentication records stay in a restricted cabinet.

## Why does this matter in DevOps?

Understand why a password login may fail because it is locked or expired. Troubleshooting should check the relevant status rather than printing sensitive password records.

## Simple practice

```bash
passwd -S "$(id -un)"
```

Typical status codes include `P` for a usable password, `L` for locked, and `NP` for no password. The command reports status without exposing a stored password hash. Some systems may restrict this inspection.

**What you should see:**

```text
On Ubuntu, this reports your password status and related dates. The exact output depends on your account and system policy.
```

## Real scenario: “The password is locked, so the account can never access the machine again, right?”

Not necessarily. Locking the password normally blocks that password authentication method. SSH keys or other authentication mechanisms may still allow access according to their policies. Offboarding requires checking all authorised access paths.

## Important detail

Password hashes are not plaintext passwords and are not simply decrypted during login. They are still sensitive because an attacker may try offline guesses. Never paste real shadow entries into notes, terminal recordings, or tickets. These notes intentionally use status commands instead of displaying the file.

## What to remember

**passwd describes accounts. shadow protects local password authentication data.**

## Further reading

[Linux command reference](https://man7.org/linux/man-pages/man5/shadow.5.html)

[Previous: /etc/passwd: the local account directory](01-etc-passwd.md) | [Next: useradd: create a local account](03-useradd.md)
