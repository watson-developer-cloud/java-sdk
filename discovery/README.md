# Discovery

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>discovery</artifactId>
  <version>3.8.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:discovery:3.8.0'
```

## Usage
The [Discovery][discovery] wraps the environment, collection, configuration, document, and query operations of the Discovery service.

```java
Discovery discovery = new Discovery("2016-12-15");
discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api/");
discovery.setUsernameAndPassword("<username>", "<password>");

//Build an empty query on an existing environment/collection
String environmentId = "<environmentId>";
String collectionId = "<collectionId";
QueryRequest queryRequest = new QueryRequest.Builder(environmentId, collectionId).build();

QueryResponse queryResponse = discovery.query(queryRequest).execute();
```

[discovery]: http://www.ibm.com/watson/developercloud/doc/discovery/
