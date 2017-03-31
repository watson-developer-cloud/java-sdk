# Conversation

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>conversation</artifactId>
	<version>3.7.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:conversation:3.7.1'
```

## Usage

Use the [Conversation][conversation] service to identify intents, entities, and conduct conversations.

```java
ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_07_11);
service.setUsernameAndPassword("<username>", "<password>");

MessageRequest newMessage = new MessageRequest.Builder().inputText("Hi").build();
MessageResponse response = service.message("<workspace-id>", newMessage).execute();
System.out.println(response);
```

[conversation]: https://www.ibm.com/watson/developercloud/doc/conversation/