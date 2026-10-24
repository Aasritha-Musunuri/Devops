# Database vs. storage disk vs. cloud storage

**Module:** Foundations

**Topic:** OS basics

## Question

How do a database, a storage disk, and cloud storage differ? Where would you store application records and uploaded files?

## Short explanation

These terms describe different parts of a system. A database manages and queries data. A disk stores bytes. Cloud storage provides storage through a cloud service and can offer block, file, or object access.

## Answer

A **database** organizes data and provides operations such as queries, updates, indexes, and, depending on the system, transactions. A **storage disk** provides storage capacity that an operating system can use for files. **Cloud storage** delivers storage as a service.

They work together: a database can store its files on a cloud disk, while an application stores uploaded images in cloud object storage and their metadata in the database.

## Detailed explanation

### Database

For example, an orders database can answer: "Which orders belong to customer 42?" A relational database such as PostgreSQL or SQL Server manages tables, indexes, and transactional changes.

The database still needs memory, compute, and storage underneath it. Saving a database backup file is different from running a database that can answer queries.

### Disk and filesystem

An SSD, HDD, or virtual block volume provides storage. A filesystem organizes that storage into files and directories. The OS can mount a filesystem at a path such as `/data`.

Disk capacity alone does not provide a database query engine. Applications must decide how to structure and access stored data.

### Types of cloud storage

- **Block storage:** a volume presented to a machine as a block device. Examples include AWS EBS and Azure Managed Disks.
- **File storage:** shared files and directories accessed through filesystem protocols. Examples include AWS EFS and Azure Files.
- **Object storage:** objects addressed by keys through an API. Examples include Amazon S3 and Azure Blob Storage.

An S3 object key may contain slashes, such as `uploads/photo.jpg`, but that does not make the bucket a normal mounted disk filesystem. Tools can provide filesystem-like access with different behavior and limitations.

## Practical example: an upload service

An illustrative design is:

```text
User uploads photo
        |
        v
Application stores photo bytes in object storage
        |
        v
Database stores owner ID, object key, and upload metadata
```

The database lets the application search and update metadata. Object storage holds the file content. A failed upload needs handling so the database does not incorrectly report that a missing object is available.

No cloud resources need to be created to understand this example. As a local exercise, identify which parts of this repository are files on disk and explain why reading a Markdown file is different from querying a database.

## DevOps scenario: database data disappears after deployment

An application runs a database in a container and stores files only in that container's writable layer. Removing the container and creating a replacement can discard those files.

Use appropriately persistent storage and configure the database data path correctly. Stopping and starting the **same** container normally preserves its writable layer; removing and replacing it is the crucial distinction. Persistent storage also needs backups and a tested recovery process.

## Quick revision

- **Is cloud storage always object storage?** No. Cloud providers also offer block and file storage.
- **Does a database use disks?** Commonly yes, along with RAM and compute.
- **Is a persistent volume a backup?** No. Persistence and recovery copies solve different problems.

## References

- [Amazon S3 object storage](https://docs.aws.amazon.com/AmazonS3/latest/userguide/Welcome.html)
- [Amazon EBS block storage](https://docs.aws.amazon.com/ebs/latest/userguide/what-is-ebs.html)
- [Docker volumes](https://docs.docker.com/engine/storage/volumes/)

[Back to Day 2](README.md) | [Next: CPU scheduling](05-cpu-scheduling.md)
