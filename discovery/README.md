# Discovery

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>discovery</artifactId>
  <version>7.4.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:discovery:7.4.0'
```

## Usage
The [Discovery][discovery] wraps the environment, collection, configuration, document, and query operations of the Discovery service.

```java
Discovery discovery = new Discovery("2017-11-07");
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

//Build an empty query on an existing environment/collection
String environmentId = "<environmentId>";
String collectionId = "<collectionId>";
QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
QueryResponse queryResponse = discovery.query(queryOptions).execute().getResult();
```

[discovery]: https://cloud.ibm.com/docs/services/discovery?topic=discovery-gs-api
