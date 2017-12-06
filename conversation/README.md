# Conversation

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>conversation</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:conversation:4.1.0'
```

## Usage

Use the [Conversation][conversation] service to identify intents, entities, and conduct conversations.

```java
Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
service.setUsernameAndPassword("<username>", "<password>");

InputData input = new InputData.Builder("Hi").build();
MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
MessageResponse response = service.message(options).execute();
System.out.println(response);
```

Moving from Node 1 to Node 2.

```java
Context context = null;

// first message
MessageOptions newMessageOptions = new MessageOptions.Builder()
    .workspaceId("<workspace-id>")
    .input(new InputData.Builder("First message").build())
    .context(context)
    .build();

MessageResponse response = service.message(newMessageOptions).execute();

// second message
newMessageOptions = new MessageOptions.Builder()
    .workspaceId("<workspace-id>")
    .input(new InputData.Builder("Second message").build())
    .context(response.getContext()) // output context from the first message
    .build();

response = service.message(newMessageOptions).execute();

System.out.println(response);
```

[conversation]: https://console.bluemix.net/docs/services/conversation/index.html
