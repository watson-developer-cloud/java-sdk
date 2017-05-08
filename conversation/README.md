# Conversation

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>conversation</artifactId>
	<version>3.8.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:conversation:3.8.0'
```

## Usage

Use the [Conversation][conversation] service to identify intents, entities, and conduct conversations.

```java
ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_03_02);
service.setUsernameAndPassword("<username>", "<password>");

MessageRequest newMessage = new MessageRequest.Builder().inputText("Hi").build();
MessageResponse response = service.message("<workspace-id>", newMessage).execute();
System.out.println(response);
```

[conversation]: https://www.ibm.com/watson/developercloud/doc/conversation/
