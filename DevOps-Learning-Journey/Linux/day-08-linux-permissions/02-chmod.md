# chmod: set file permissions

**Module:** Linux

**Topic:** Linux permissions

## What is chmod?

`chmod` changes a file or directory’s mode: the permissions assigned to owner, group, and others. It does not change ownership.

Ownership names the person responsible for a room. `chmod` sets what the room’s different keys allow people to do.

## Why does this matter in DevOps?

Give a deployment script execute permission, keep an application configuration private, or remove unnecessary group access.

## Simple practice

```bash
mkdir -p ~/devops-practice/day08
cd ~/devops-practice/day08
printf "sample configuration\n" > chmod-demo.conf
chmod 640 chmod-demo.conf
ls -l chmod-demo.conf
chmod g+w chmod-demo.conf
ls -l chmod-demo.conf
```

Numeric digits are owner, group, others. Read is 4, write is 2, execute is 1, so 6 means 4+2. `640` grants owner read/write, group read, others none. Symbolic `g+w` adds group write without replacing every permission.

**What you should see:**

```text
First:  -rw-r-----
Second: -rw-rw----
```

## Real scenario: A script is present but running `./deploy.sh` gives “Permission denied”.

Check its mode and parent-directory access. If execution is intended and you own it, `chmod u+x deploy.sh` adds owner execute permission. Also check the interpreter path and whether the filesystem is mounted with `noexec`.

## Important detail

Write numeric permissions together: `chmod 744 file`, not `chmod 7 44 file`. `777` gives all three classes full mode permissions and is usually broader than needed; it does not bypass every security control. A directory’s execute bit means traversal, not “run this folder”.

## What to remember

**chmod sets access; chown changes the owner.**

## Further reading

[Linux command reference](https://www.gnu.org/software/coreutils/manual/html_node/chmod-invocation.html)

[Previous: rwx: read, write, and execute](01-rwx.md) | [Next: chown: change who owns a file](03-chown.md)
