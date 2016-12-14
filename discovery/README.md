# Discovery

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>discovery</artifactId>
  <version>3.5.3</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:discovery:3.5.3'
```

## Usage
The [Discovery][discovery] wraps the environment, collection, configuration, document, and query operations of the Discovery service.

```java
Discovery service = new Discovery("2016-12-15");
service.setEndpoint("https://gateway.watsonplatform.net/discovery/api/");
service.setUsernameAndPassword("<username>", "<password>");

//TODO add service
```

[discovery]: http://www.ibm.com/watson/developercloud/doc/discovery/
