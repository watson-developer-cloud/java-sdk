# Discovery

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>discovery</artifactId>
  <version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:discovery:4.1.0'
```

## Usage
The [Discovery][discovery] wraps the environment, collection, configuration, document, and query operations of the Discovery service.

```java
Discovery discovery = new Discovery("2017-09-01");
discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api/");
discovery.setUsernameAndPassword("<username>", "<password>");

//Build an empty query on an existing environment/collection
String environmentId = "<environmentId>";
String collectionId = "<collectionId>";
QueryOptions queryOptions = new QueryOptions.Builder(environmentId, collectionId).build();
QueryResponse queryResponse = discovery.query(queryOptions).execute();
```

[discovery]: http://www.ibm.com/watson/developercloud/doc/discovery/
