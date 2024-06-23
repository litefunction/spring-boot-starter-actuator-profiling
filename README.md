# Spring Boot Profiling Application

This application provides a profiling mechanism for monitoring method execution times in a Spring Boot application. It
leverages Spring Boot Actuator to expose profiling data through custom endpoints.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)

## Introduction

The profiling application is designed to help developers monitor and analyze the execution times of methods annotated
with a custom `@ActuatorProfiling` annotation. The profiling data is exposed through Spring Boot Actuator endpoints.

## Features

- Profiling of method execution times.
- Customizable profiling settings.
- Exposed endpoints for retrieving profiling data.
- Thread-safe handling of profiling data.

## Getting Started

### Maven dependency

```maven
<dependency>
    <groupId>io.github.litefunction</groupId>
    <artifactId>spring-boot-starter-actuator-profiling</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Prerequisites

- Java 11 or higher
- Maven or Gradle

## Configuration

The application can be configured using properties in `application.properties` or `application.yml`.

### Default Configuration

```properties
profiling.actuator.maxCountList=100
profiling.actuator.enabler=true
```

### Usage

Adding Profiling to Methods

To profile a method, simply annotate it with @ActuatorProfiling and optionally provide a name:

```java
import com.lite.function.profiling.ActuatorProfiling;

public class ExampleService {

    @ActuatorProfiling(name = "exampleMethod")
    public void exampleMethod() {
        // method logic
    }
}
```

### Accessing Profiling Data

Profiling data can be accessed through the provided Actuator endpoints.

### Endpoints

#### List of Profiling Data

Endpoint: /actuator/actuatorProfiling

```json{
  "executingProfilingMethod": {
    "exampleMethod": 403
  }
```

exampleMethod - name from @ActuatorProfiling

403 - what happens during the execution of the last call

#### Detailed Profiling Data

Endpoint: /actuator/actuatorProfilingDetail/{name}

```json
{
  "name": "exampleMethod",
  "executingProfilingMethodVals": [
    {
      "delta": 506,
      "localDateTime": "2024-06-23T14:28:39.523107"
    },
    {
      "delta": 103,
      "localDateTime": "2024-06-23T14:28:43.101866"
    },
    {
      "delta": 904,
      "localDateTime": "2024-06-23T14:28:44.564218"
    },
    {
      "delta": 403,
      "localDateTime": "2024-06-23T14:28:47.180746"
    }
  ]
}
```