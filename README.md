# Oncotree Mappings
This repository hosts the source code for Oncotree Mappings.

@author: Iker Huerga

## Introduction
The Oncotree Mappings Service provides mappings from Controlled Vocabularies such as ICD9, ICD10 or SNOMEDCT to [*Oncotree*](http://oncotree.mskcc.org/oncotree/)

Let's take the following example

In the Controlled Vocabulary [*ICD10CM*](http://www.cdc.gov/nchs/icd/icd10cm.htm)
 
```
Code C92 - Acute Myeloid Leukemia

```

This service will return the equivalent code within the Oncotree Controlled Vocabulary

```
Code AML - Acute Myeloid Leukemia

```


## Installation

Oncotree Mappings is a simple [*Spring Boot*](http://projects.spring.io/spring-boot/) Application

You have two ways of deploying it

1- Within an existing Servlet Container, such as Tomcat 7. Just execute the command below and copy the war file in your container's webapp directory

```
mvn clean package

```

Then your service will be available [*here*](http://localhost:8080/mappings) 


2- Using Spring Boot's Embedded Servlet Container. Just execute the following command

```
mvn spring-boot:run

```

Then your service will be available [*here*](http://localhost:8080/mappings) 
