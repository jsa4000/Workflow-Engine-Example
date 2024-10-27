---
title: Getting Started
tags: ["Workflow Engine"]
---
# Getting Started

## Installation

This section describe how to install the basic **components** and **tools** to start developing using **Camunda Workflow Engine**.

### Create Project

In order to create a camunda project, there are **multiple** options to choose from. The simplest options are by using **initializers** that creates java projects with the main **dependencies** and **configuration**.

#### Spring Initializer

[Spring Initializr](https://start.spring.io/) provides an extensible API to **generate** JVM-based projects with implementations for several common components and dependencies.

![workflow-engine](../assets/getting-started-spring-initializer.png)

!!! note

    The **recommendation** is to use **spring initializer** as a base for the project and start adding **Camunda** dependencies on top.

#### Camunda Initializer

Go to camunda initializer [website](https://start.camunda.com/), that allows you to create a **Spring Boot application** with the main dependencies and configuration to start working with Camunda very quickly.

![workflow-engine](../assets/getting-started-camunda-initializer.png)

The description of the modules are:

* **REST API**: The goal of the **REST API** is to expose and provide access to all relevant **interfaces** of the engine.
* **WebApps (Cockpit)**: It provides access to **deployed** BPMN processes and DMN decisions, allows **searching** though running and ended **instances** and **performing operations** on these.
* **Spin (XML & JSON)**: Camunda **Spin** is a library for simple XML and JSON processing on the JVM (Java Virtual Machine), targeting Java and JVM-based scripting languages such as Groovy, JRuby, Jython, JavaScript and Java Expression Language. It provides a comprehensible **fluent API** for working with different data formats through lightweight wrapper objects.

### Camunda Modeler

An integrated modeling solution for BPMN, DMN, and Forms based on [bpmn.io](https://bpmn.io/).

![workflow-engine](../assets/getting-started-camunda-modeler.png)

You can download the [Open Source Desktop Modeler](https://github.com/camunda/camunda-modeler) from this [url](https://camunda.com/download/modeler/), by selecting the proper O.S.

!!! warning

    You would need to select the proper version from Camunda to start designing the BPMN or DMN models. The current version used in this case is `7.22`.

![workflow-engine](../assets/getting-started-camunda-modeler-version.png)

### IntelliJ

#### Enable Auto-save

Enable following **auto-save** options within **IntelliJ**, to enable auto-formatting and removing unused dependencies when saving.

![workflow-engine](../assets/getting-started-intellij-autosave.png)

## Run

### Camunda WebApps

Run the application and go to **Camunda WebApps** at [http://localhost:8080](http://localhost:8080)

![workflow-engine](../assets/getting-started-camunda-webapps.png)

For specific webapp use following links:

* [Cockpit Dashboard](http://localhost:8080/camunda/app/cockpit/default/#/dashboard)
* [TaskList Dashboard](http://localhost:8080/camunda/app/tasklist/default/)

#### Tasklist

To manually start a process go to [TaskList Dashboard](http://localhost:8080/camunda/app/tasklist/default/).

Click to **Start process** button on the top-right corner of the screen.

![workflow-engine](../assets/getting-started-tasklist-start-process.png)

**Select** the workflow (`Process Simple`) to be started among the deployed ones.

![workflow-engine](../assets/getting-started-tasklist-select-process.png)

Set a **Business Key** to identify the process and finally click **Start**.

![workflow-engine](../assets/getting-started-tasklist-start-process-start.png)

*This will start a **process instance**. Since it's a simple process with an *User Task*, this will be listed in the tasklist, so press `F12` or reload the page to **refresh** the current webpage. You **cannot complete** it until the task will be **assigned** to an user or **claimed**.

![workflow-engine](../assets/getting-started-tasklist-process-task.png)

Once you (claim) or somebody else have been assigned to the task, it can be **completed**.

![workflow-engine](../assets/getting-started-tasklist-process-claim.png)

#### Cockpit

**Cockpit** gives you a *real-time* view of BPMN processes and DMN decision tables as they run, so you can monitor their status and quickly identify technical incidents that slow down or stop workflows.

!!! note

    Cockpit will **only** show the **current** process instances being running, for the historical processes you must **upgrade** to the Enterprise Camunda version.

From the previous example, the process is still running and the *User Task* is still pending to be completed. You can visualize this information within the cockpit.

![workflow-engine](../assets/getting-started-cockpit-start-process.png)

In the **Running Process Instances** options, you can see the definition version, definition key and name, history time to live (HTTL), process instances (Current Step, start time, Business Key), incidents, job definitions.

![workflow-engine](../assets/getting-started-cockpit-process-instances.png)

In process instances you can take a look closer to the process running, variables, user tasks, etc..

![workflow-engine](../assets/getting-started-cockpit-process-instance.png)

In the **Open Human Tasks** options, you can visualize a resume for all **assignments** by type and group for all processes.

![workflow-engine](../assets/getting-started-cockpit-human-tasks.png)

