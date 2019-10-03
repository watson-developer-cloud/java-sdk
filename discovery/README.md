# Discovery

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>discovery</artifactId>
  <version>7.4.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:discovery:7.4.1'
```

## Usage
The [Discovery][discovery] wraps the environment, collection, configuration, document, and query operations of the Discovery service.

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
Discovery discovery = new Discovery("2019-04-30", authenticator);

//Build an empty query on an existing environment/collection
String environmentId = "<environmentId>";
String collectionId = "<collectionId>";
QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();
```

[discovery]: https://cloud.ibm.com/docs/services/discovery?topic=discovery-gs-api
