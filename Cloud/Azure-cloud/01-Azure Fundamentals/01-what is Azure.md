# ☁️ What is Microsoft Azure?

> **Learning Path:** Cloud → Azure  
> **Level:** Beginner  
> **Status:** 📚 Learning

---

## 1. What is Azure?

**Microsoft Azure** is a cloud computing platform provided by Microsoft.

It provides a collection of cloud services that organizations can use to:

- Build applications
- Host applications
- Store data
- Run virtual machines
- Create networks
- Manage identities
- Secure applications
- Deploy software
- Monitor applications
- Scale applications based on demand

### In simple words

> **Azure allows organizations to use computing infrastructure and services over the internet instead of purchasing and maintaining all the physical infrastructure themselves.**

---

## 2. What is Cloud Computing?

Before understanding Azure, we need to understand **Cloud Computing**.

Traditionally, if an organization wanted to run an application, it had to purchase and maintain:

- Physical servers
- Storage
- Networking equipment
- Data-center infrastructure
- Power and cooling
- Operating systems
- Hardware

A simplified traditional environment looks like:

```text
Physical Hardware
       ↓
Operating System
       ↓
Application
       ↓
Users
```

With cloud computing, organizations can consume infrastructure and services from a cloud provider.

```text
Cloud Provider
      ↓
Compute
Storage
Networking
Databases
Security
      ↓
Application
      ↓
Users
```

---

## 3. Why Do We Need Cloud Computing?

Cloud computing provides organizations with several advantages:

- **Scalability** – resources can be increased or decreased based on demand
- **Flexibility** – infrastructure can be provisioned based on requirements
- **Faster provisioning** – resources can be created much faster than traditional hardware procurement
- **Global availability** – applications can be deployed closer to users
- **Automation** – infrastructure and deployments can be automated
- **Managed services** – cloud providers manage many underlying components
- **Pay-as-you-use** – organizations can consume resources based on their requirements

### Simple example

```text
Normal Traffic
      ↓
Small Infrastructure

High Traffic
      ↓
More Resources Required
      ↓
Scale Infrastructure
```

---

## 4. Major Cloud Providers

| Company | Cloud Platform |
|---|---|
| Microsoft | Microsoft Azure |
| Amazon | Amazon Web Services (AWS) |
| Google | Google Cloud |

My cloud learning journey includes exposure to both:

- **Microsoft Azure**
- **Amazon Web Services (AWS)**

---

## 5. Why Azure?

Azure provides services across many technology areas.

| Requirement | Example Azure Service |
|---|---|
| Virtual Machines | Azure Virtual Machines |
| Web Applications | Azure App Service |
| Serverless Applications | Azure Functions |
| Object Storage | Azure Blob Storage |
| Database | Azure SQL Database |
| Networking | Azure Virtual Network |
| Identity | Microsoft Entra ID |
| Secrets | Azure Key Vault |
| Containers | Azure Container Instances / AKS |
| Monitoring | Azure Monitor |
| DevOps | Azure DevOps |

Therefore:

> **Azure is not a single service. It is an ecosystem of cloud services.**

---

## 6. Azure and My .NET Background

My primary background is **.NET application development**.

From an application-development perspective, I usually think about:

```text
.NET Code
    ↓
Build
    ↓
Test
    ↓
Application
```

As I move toward Cloud and DevOps, I am expanding my understanding beyond the application itself:

```text
Source Code
    ↓
Git
    ↓
Build
    ↓
Test
    ↓
Package
    ↓
Deploy
    ↓
Cloud Infrastructure
    ↓
Application
    ↓
Monitoring
```

This helps me understand the complete lifecycle of an application rather than focusing only on development.

---

## 7. Azure vs Azure DevOps

These two concepts are related but different.

### Microsoft Azure

**Azure is the cloud platform.**

It provides services for:

- Compute
- Storage
- Networking
- Databases
- Identity
- Security
- Monitoring

### Azure DevOps

**Azure DevOps provides tools that support the software development and delivery lifecycle.**

Some important Azure DevOps services are:

- Azure Repos
- Azure Pipelines
- Azure Boards
- Azure Test Plans
- Azure Artifacts

### Easy way to remember

```text
Azure
  ↓
Cloud Platform

Azure DevOps
  ↓
Development + Collaboration + CI/CD
```

---

## 8. Cloud Service Models

Cloud services are commonly discussed using three major service models:

- IaaS
- PaaS
- SaaS

### IaaS — Infrastructure as a Service

With IaaS, the cloud provider manages the underlying physical infrastructure while we manage more of the software stack.

Example:

**Azure Virtual Machines**

```text
Cloud Provider
    ↓
Physical Hardware
Networking
Virtualization

We Manage
    ↓
Operating System
Runtime
Application
Data
```

### PaaS — Platform as a Service

With PaaS, the cloud provider manages more of the underlying infrastructure and platform.

Example:

**Azure App Service**

```text
Cloud Provider
    ↓
Infrastructure
Operating System
Platform
Runtime

We Mainly Focus On
    ↓
Application
Configuration
Data
```

### SaaS — Software as a Service

With SaaS, the cloud provider delivers a complete software application to the user.

```text
Cloud Provider
      ↓
Infrastructure
Platform
Application
      ↓
User
```

### Easy way to remember

```text
IaaS → Manage more infrastructure

PaaS → Focus more on the application

SaaS → Use the finished software
```

---

## 9. Real-World .NET Example

Imagine we have a .NET web application.

### Traditional approach

```text
.NET Application
      ↓
Physical Server
      ↓
Company Data Center
      ↓
Internet
      ↓
Users
```

### Cloud approach

```text
.NET Application
      ↓
Azure App Service
      ↓
Azure Networking
      ↓
Internet
      ↓
Users
```

Additional Azure services could support the application:

```text
                Application
                     ↓
                App Service
                /    |     \
               /     |      \
          Azure SQL  Key Vault  Storage
                           |
                     Azure Monitor
```

This gives us a basic idea of how a real application can use multiple cloud services together.

---

## 10. Azure and DevOps

Cloud and DevOps are closely connected.

A simplified application delivery flow can look like:

```text
Developer
    ↓
Git Repository
    ↓
CI/CD Pipeline
    ↓
Build
    ↓
Test
    ↓
Package
    ↓
Deploy
    ↓
Azure
    ↓
Monitor
```

This is where my Azure learning connects with my DevOps journey.

Instead of only understanding:

> "How do I develop the application?"

I am learning to understand:

> "How is the application built, deployed, hosted, scaled and monitored?"

---


# 🧠 Quick Revision

### What is Azure?

> Microsoft Azure is Microsoft's cloud computing platform that provides services for computing, storage, networking, databases, identity, security, monitoring and application hosting.

### Is Azure a cloud platform?

> Yes. Azure is a public cloud computing platform provided by Microsoft.

### What is the difference between Azure and Azure DevOps?

> Azure is the cloud platform, while Azure DevOps provides tools for software development, collaboration and software delivery.

### What are the three major cloud service models?

> IaaS, PaaS and SaaS.

### Give examples of Azure services.

> Azure Virtual Machines, Azure App Service, Azure Functions, Azure SQL Database, Azure Blob Storage, Azure Virtual Network, Microsoft Entra ID and Azure Monitor.

### Why is Azure important for DevOps?

> Azure provides the cloud infrastructure and services where applications can be deployed, scaled, secured and monitored, while DevOps practices help automate and improve the software delivery lifecycle.

---

# 🎯 My Learning Takeaway

> **Azure is more than a place to host an application. It is a complete cloud platform that provides services for compute, storage, networking, databases, identity, security, monitoring and application delivery.**

---


