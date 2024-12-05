# Discovery

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>discovery</artifactId>
  <version>14.0.0</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:discovery:14.0.0'
```

## Usage

This SDK supports the Discovery v2 APIs.

Otherwise, the APIs are fairly similar, offering the ability to manage collections of documents and query them for insights. You can learn more about the Discovery service [here](https://cloud.ibm.com/apidocs/discovery-data).

### Using Discovery v2

```java
// Make sure to use the Discovery v2 import!
Authenticator authenticator = new BearerTokenAuthenticator("<bearer_token>");
Discovery discovery = new Discovery("2019-11-22", authenticator);

// Build an empty query on an existing project.
String projectId = "<project_id>";
QueryOptions queryOptions = new QueryOptions.Builder()
  .projectId(projectId)
  .build();
QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();
```
