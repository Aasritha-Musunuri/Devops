# Day 2: OS basics

**Module:** Foundations

Week 1 - Foundations. These six topics follow the order in the DevOps preparation plan.

An operating system (OS) manages a computer's resources and provides the environment where applications run. Understanding these basics helps you investigate slow servers, failed processes, memory pressure, and storage problems.

## Topics

1. [Kernel](01-kernel.md)
2. [Processes vs. threads](02-processes-vs-threads.md)
3. [RAM vs. disk](03-ram-vs-disk.md)
4. [Database vs. storage disk vs. cloud storage](04-database-vs-disk-vs-cloud-storage.md)
5. [CPU scheduling](05-cpu-scheduling.md)
6. [File system tree](06-file-system-tree.md)

## How to use these notes

Start with the question and short explanation. Read the interview answer, then work through the detailed explanation and practical example. Finish by answering the revision questions without looking at the notes.

Examples are learning scenarios, not claims of personal work experience. Connect them to your own practice when preparing an interview answer.

## Command environment

- Run `bash` examples in a Linux terminal, such as Ubuntu in WSL. They assume common GNU/Linux tools; minimal containers may not include them.
- Run `powershell` examples in Windows PowerShell or PowerShell on Windows.
- Output depends on the machine. Sample output is illustrative.
- Commands in these lessons inspect resources. No cloud account or running database is required.

## Revision goals

- Explain how an application uses the kernel to access resources.
- Distinguish a process from its threads.
- Choose the right checks for memory pressure and a full disk.
- Explain how databases use storage and how object storage differs from an attached disk.
- Describe CPU scheduling and context switching.
- Locate configuration, logs, application data, and process information in Linux.

## Writing reference

The question, short answer, detailed explanation, and practical scenario format is inspired by [Abhishek Veeramalla's DevOps and Cloud Interview Guide](https://github.com/iam-veeramalla/devops-cloud-interview-guide). These lessons use original explanations and examples aligned with this preparation plan. Each topic links to technical documentation for further reading.

[Learning journey](../../README.md) | [Day 1: How computers talk](../day-01-how-computers-talk/README.md)
