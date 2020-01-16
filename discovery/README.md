# Discovery

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>discovery</artifactId>
  <version>8.2.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:discovery:8.2.0'
```

## Usage
This SDK supports both the Discovery v1 and v2 APIs. Please note that the Discovery v2 API is accessible **only** on Cloud Pak for Data.

Otherwise, the APIs are fairly similar, offering the ability to manage collections of documents and query them for insights. You can learn more about the Discovery service [here](https://cloud.ibm.com/docs/services/discovery?topic=discovery-gs-api).

### Using Discovery v1

```java
// Make sure to use the Discovery v1 import!
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
Discovery discovery = new Discovery("2019-04-30", authenticator);

//Build an empty query on an existing environment/collection
String environmentId = "<environment_id>";
String collectionId = "<collection_id>";
QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();
```

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
