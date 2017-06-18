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
ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_05_26);
service.setUsernameAndPassword("<username>", "<password>");

InputData input = new InputData.Builder("Hi").build();
MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
MessageResponse response = service.message(options).execute();
System.out.println(response);
```

Moving from Node 1 to Node 2.

```java

Map<String, Object> context = new HashMap<String, Object>();

// first message
MessageRequest newMessage = new MessageRequest.Builder()
	.input(new InputData.Builder("First message").build())
	.context(context)
	.build();

MessageResponse response = service.message("<workspace-id>", newMessage).execute();

// second message
newMessage = new MessageRequest.Builder()
	.input(new InputData.Builder("Second message").build())
	.context(response.getContext()) // output context from the first message
	.build();

response = service.message("<workspace-id>", newMessage).execute();

System.out.println(response);
```

[conversation]: https://www.ibm.com/watson/developercloud/doc/conversation/
