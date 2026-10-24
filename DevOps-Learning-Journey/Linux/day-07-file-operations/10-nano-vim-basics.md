# nano and vim: edit text in a terminal

**Module:** Linux

**Topic:** File operations

## What is nano and vim?

`nano` and `vim` are terminal text editors. They change file contents, unlike viewers such as `cat` or `less`.

A viewer lets you read the notebook. An editor gives you the pen as well.

## Why does this matter in DevOps?

Make a small configuration change over SSH when there is no desktop editor. Saving the file is only one step; the application may need validation and a controlled reload.

## Simple practice

Use Ubuntu or another Linux shell. These examples create clearly named sample files under `~/devops-practice/day07`. `printf ... > filename` creates or replaces only that named sample file.

```bash
mkdir -p ~/devops-practice/day07
cd ~/devops-practice/day07
printf "port=8080\n" > editor-demo.conf
cp -i editor-demo.conf editor-demo.conf.backup
nano editor-demo.conf
```

In nano, Ctrl+O writes the file; press Enter to confirm the name, then Ctrl+X to exit. Verify with `cat editor-demo.conf`. In vim, run `vim editor-demo.conf`, press `i` to insert text, Esc to leave insert mode, then type `:wq` and Enter to save and exit.

**What you should see:**

```text
The editor opens with port=8080. Change it to port=9090, save, and exit.
```

## Real scenario: A configuration was saved, but the application still uses the old value.

Confirm the application reads that file. Validate its configuration with the application’s own check command, then follow its documented reload or restart procedure. A saved file does not guarantee a valid or active configuration.

## Important detail

In vim, `:q!` exits without saving your edits. If an editor is missing, choose an available one; do not install extra tools into a running production container just to make a quick change. Prefer changing the managed configuration and redeploying when appropriate.

## What to remember

**Read with a viewer. Change with an editor. Validate before applying.**

## Further reading

[Command reference](https://www.nano-editor.org/dist/latest/nano.html)

[Previous: tail: read recent lines and follow a log](09-tail.md) | [Next: find: search the filesystem](11-find.md)
