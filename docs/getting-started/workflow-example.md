---
title: Example
tags: ["Workflow Engine","DMN","Camunda"]
---
# Example

## Policy Process

### BPMN

**Business Process Model and Notation (BPMN 2.0)** was developed as a **graphical notation** to **represent complex processes** and address these challenges. The visual nature of BPMN enables **greater collaboration** between different teams.

The [policy process](process-dmn.bpmn) is a more complex BPMN process that consist on several **User Tasks**, **Script Tasks**, **Call Activity** (subprocess) and multiple **Gateways** and **boundary events**.

![workflow-engine](../assets/getting-started-camunda-example-bpmn.png)

### DMN

**DMN stands for Decision Model and Notation**. It is a **standard** administered by the **Object Management Group (OMG)** and has been widely adopted across various industries. Businesses leverage **DMN** to design **decision models** that are used for **automation** of the **decision-making** processes. DMN serves as a common language to **align business and IT** on repeatable **business rules** and **decision management**. The notation enhances business efficiency, reduces the risk of human error, and ensures that decision models are interchangeable across the organization.

Core elements of DMN include:

* **Decision tables**: Simple and intuitive **representation** of decisions consisting of **input**, **condition**, and **output**.
* **Friendly Enough Expression Language (FEEL)**: Used to **express conditions** in the decision tables so they can be executed.
* **Decision Requirements Diagrams (DRD)**: Created when a decision **can not be described in just one simple table**. For example, when there are dependencies between intermediate decisions output from which serve as an input for the final decision to be made.

The example [process dmn](process-dmn.dmn) consist in **one decision** table and **two inputs**, there is no additional **DRD** or **functions**.

![workflow-engine](../assets/getting-started-camunda-example-dmn.png){ width="500" }

=== "Decision Table"

    ![workflow-engine](../assets/getting-started-camunda-example-dmn-decision.png){ width="250" align=left }

    A **decision table** represents **decision logic** which can be depicted as a table in **DMN**. It consists of **inputs**, **outputs** and **rules**. Decision Tables can be **chained** by creating a **Decision Requirements Diagrams (DRD)**

    ![workflow-engine](../assets/getting-started-camunda-example-dmn-drd.png){ width="400" }

    In the configuration tab **Name** and ID must be specified for the **DMN**.

=== "Inputs"

    ![workflow-engine](../assets/getting-started-camunda-example-dmn-input-type.png){ width="250" align=left }
    ![workflow-engine](../assets/getting-started-camunda-example-dmn-input-age.png){ width="250" align=left }

    Inputs must be **named** in the **same way** as the variables from the **process** (i.e `type`, `age`).

    Later these **inputs** can be **referenced** in the Decision Table as an **Expressions**. This way it makes more **explicit** the **inputs** used for each Decision Table from the **DMN**

A **decision table** consists of **several rules**, typically represented as **rows**. When reading such a row, we look at certain **input values** and **deduct** a certain **result** represented by **output values**.

**Hit policies** describe different ways (standardized by DMN) to **evaluate** the rules contained in a decision table. **Different** hit policies do not only **lead** to **different results**, but typically also **require** different modes of thinking and reason about the meaning of the entire table. For example, When using the simplest hit policy "unique" or "first", such rules **do not overlap**: only a **single rule** must match.

![workflow-engine](../assets/getting-started-camunda-example-dmn-decision-table.png)

=== "Inputs"

    ![workflow-engine](../assets/getting-started-camunda-example-dmn-decision-input.png){ width="250" align=left }  

    Depending if you are defining de **inputs** in the **DRD**, you can use an **Expression** or use **Input Variable** instead.

    ![workflow-engine](../assets/getting-started-camunda-example-dmn.png){ width="350" }

    So, if you already have an **input data** named `type` you can use the **same value** for the **expression**. However if you **don't have** defined any **input data** to your ** **, then you must use **Input Variable** with the variable `type`.
    
    !!! note
    
        It's **best practice** to use **inputs** from **expressions** rather than **row inputs**, since you can watch all inputs be seeing the **DRD**.

    Using `string` types you can define **predefined values** (aka *enumerations*) in order to restrict possible values to choose from.

=== "Edit"

    ![workflow-engine](../assets/getting-started-camunda-example-dmn-decision-edit-enum.png){ width="250" align=left }
    ![workflow-engine](../assets/getting-started-camunda-example-dmn-decision-edit-number.png){ width="250" align=left }

    Depending on  you input **types** you can select the **condition** to evaluate (`Match one`, `Comparison`) and the values to **compare with** (`CAR`,`< 30`). 

=== "Outputs"

    ![workflow-engine](../assets/getting-started-camunda-example-dmn-decision-output.png){ width="250" align=left }

    For the out put you must decide the **type** of the output and the **value** for each row. 
    
    You can have **multiple** outputs returned in the final result.

The final **result** from the **DMN** will be used by flow and for the [validation process](workflow-example.md#validation-process) with the following `json` format.

```json
{
  "result": true,
  "risk": "MID"
}
```

## Validation Process

The [validation process](process-validation.bpmn) consist in one automatic task (`Script Task`) that checks whether the **result** from previous operation was **successful**. Otherwise, it will **throw an exception** that terminates the subprocess with an **error**. This error will be **caught** by the **parent process** in order to perform an action.

Following is the structure of the **result** from the [DMN Task](workflow-example.md#dmn)

```json
{
  "result": true,
  "risk": "MID"
}
```

The **BPMN model** of the validation process is the **following**.

!!! note

    The process bellow have a **Debug** User Task so it will be **easier** to debug and **watch** variables, since it will stop the flow at that stage. **You will need to remove it at the end**.

![workflow-engine](../assets/getting-started-camunda-example-subprocess.png){ width="700" }

=== "Process"

    ![workflow-engine](../assets/getting-started-camunda-example-subprocess-process.png){ width="250" align=left }

    In the **Process** tab you will have to configure the **Name** and **ID** of the process.

    !!! note

        Yoy will have to select in an **empty area** of the **Camunda Modeler** to get the process properties.

    This process can be used as **standalone** or **invoked** by other processes as **Call Activity** (subprocess). In this case the **ID** of the process will be used to be referenced from other processes. 

    Another important configuration if the _**Historical Time to live (HTTL)**_, the _**Candidate starter groups**_ and _**Candidate starter users**_ that will be able to interact with this process.

=== "Validate Task"

    ![workflow-engine](../assets/getting-started-camunda-example-subprocess-script-validate.png){ width="250" align=left }

    This is an **automatic task** that support scripting. There are several [scripting languages](https://docs.camunda.org/manual/7.22/user-guide/process-engine/scripting/) supported by Camunda. You would need to add dependencies to support various languages into the Camunda project.

    In order to support **groovy** scripting language to will need to add following dependency into `pom.xml` file.

    ```xml
      <dependency>
          <groupId>org.codehaus.groovy</groupId>
          <artifactId>groovy-jsr223</artifactId>
          <version>${groovy-jsr.version}</version>
          <scope>compile</scope>
      </dependency>
    ```

    In order to properly configure a Script Task you will need to select:

    * **Format**: The format of your scripting language: `groovy`, `javascript`, `python`, etc..
    * **Type**: There are two options `Inline script` or `External Resource`
    * **Script/External Resource**: Depending on the `Type` selected you must put down your script or reference an external file.

    Following **groovy** script will throw an **exception** if the result from a process variable (input of the process) is `false`.

    ```groovy
    var result = execution.getVariable("result");
    println result;
    if(result.result==false){
      throw new org.camunda.bpm.engine.delegate.BpmnError("validationError");
    }
    ```

    The exception will **trigger** the **Error Boundary**, so it will **exit** the **normal** path of the flow.

=== "Error Boundary"

    ![workflow-engine](../assets/getting-started-camunda-example-subprocess-error-boundary.png){ width="250" align=left }

    **Boundary events** provide a way to model what should happen if an event occurs while an activity is still **active**.

    A **boundary event** must be an **intermediate** catch event, and can be either **interrupting** or **non-interrupting**. **Interrupting** means that once triggered, before taking any outgoing sequence flow the activity the event is attached to is terminated. This allows modeling timeouts where we can prune certain execution paths if something happens (e.g. the process takes too long).

    You can add as many as needed **Boundary events** to a Task (Service Task, User Task, Script Task, etc..).

    There are multiple [options supported](https://docs.camunda.io/docs/components/modeler/bpmn/events/) in BPMN like **Message Events**, **Signal Events**, **Timer Events**, **Error Events**, **Escalation Events**, etc..

    In BPMN, errors define possible errors that can occur. Error events are elements in the process referring to defined errors. An error can be referenced by one or more error events.

    An error must define an `errorCode`. The value of this `errorCode` is used to determine which catch event can catch the thrown error.

    For error throw events, it is possible to define the `errorCode` as an expression or a static value. If an `errorCode` expression is configured then it will be evaluated once the event is reached, and used to throw error.

    For error catch events `errorCode` must be a static value. Alternatively an error catch event may omit the error reference all together. In this case it catches all thrown errors.

    !!! note

        In the example this Error Boundary Event will catch any error thrown by the Task, so it won't take into consideration the `errorCode` of the exception so it catches **all thrown errors**.

=== "Validation Error"

    ![workflow-engine](../assets/getting-started-camunda-example-subprocess-script-error.png){ width="250" align=left } 

    This is a **Script Task** will only prints an **output log** into the **console**.

    ```groovy
    println "The Policy has been cancelled"
    ```

    You can also get the **error code** or **message** thrown by previous *error boundary event*.

=== "Error Event"

    ![workflow-engine](../assets/getting-started-camunda-example-subprocess-error-event.png){ width="250" align=left }

    In a process you can define **End Events** that will be used later by the parent process and caught by the corresponding **Boundary Events**. Similar when an exception is thrown by the system or a task, you can throw a **typed exception** at the end of the process using **Error End Events**.

    Following an example of a **Call Activity** that will catch an exception from a subprocess and **react** accordingly.

    ![workflow-engine](../assets/getting-started-camunda-example-subprocess-error-event-catch.png){ width="350" }

    The common parameters to be configured using ***Error End Event*** are:

    * **Global error reference**: The reference of the error to be thrown. You can create a new one if it does not exist.
    * **Name**: The `name` of the error.
    * **Code**: The `errorCode` of the exception to be caught by a **Boundary Event**
    * **Message**: Message of the exception to be thrown.
