# Assistant

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>assistant</artifactId>
  <version>6.12.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:assistant:6.12.0'
```

## Usage
Use the [Assistant][assistant] service to identify intents, entities, and conduct conversations.

### Using Assistant v1
```java
// make sure to use the Assistant v1 import!
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;

Assistant service = new Assistant("2018-02-16");
service.setUsernameAndPassword("<username>", "<password>");

InputData input = new InputData.Builder("Hi").build();
MessageOptions options = new MessageOptions.Builder(workspaceId)
  .input(input)
  .build();
MessageResponse response = service.message(options).execute();
System.out.println(response);
```

Maintaining context across messages:
```java
// make sure to use the Assistant v1 import!
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;

Context context = null;

// first message
MessageOptions newMessageOptions = new MessageOptions.Builder()
  .workspaceId("<workspace-id>")
  .input(new InputData.Builder("First message").build())
  .context(context)
  .build();

MessageResponse response = service.message(newMessageOptions).execute();
context = response.getContext();

// second message
newMessageOptions = new MessageOptions.Builder()
  .workspaceId("<workspace-id>")
  .input(new InputData.Builder("Second message").build())
  .context(context) // using context from the first message
  .build();

response = service.message(newMessageOptions).execute();

System.out.println(response);
```

---

### Using Assistant v2
```java
// make sure to use the Assistant v2 import!
import com.ibm.watson.developer_cloud.assistant.v2.Assistant;

Assistant service = new Assistant("2018-09-20");
service.setUsernameAndPassword("<username>", "<password>");

MessageInput input = new MessageInput.Builder()
  .text("Hi")
  .build();
MessageOptions messageOptions = new MessageOptions.Builder()
  .assistantId("<assistant_id>")
  .sessionId("<session_id>")
  .input(input)
  .build();
MessageResponse messageResponse = service.message(messageOptions).execute();

System.out.println(messageResponse);
```

Maintaining context across messages:
```java
// make sure to use the Assistant v2 import!
import com.ibm.watson.developer_cloud.assistant.v2.Assistant;

MessageContext context = new MessageContext();

// first message
MessageInput input = new MessageInput.Builder()
  .text("First message")
  .build();
MessageOptions messageOptions = new MessageOptions.Builder()
  .assistantId(assistantId)
  .sessionId(sessionId)
  .input(input)
  .context(context)
  .build();

MessageResponse messageResponse = service.message(messageOptions).execute();
context = messageResponse.getContext();

// second message
input = new MessageInput.Builder()
  .text("Second message")
  .build();
messageOptions = new MessageOptions.Builder()
  .assistantId(assistantId)
  .sessionId(sessionId)
  .input(input)
  .context(context) // using context from first message
  .build();

messageResponse = service.message(messageOptions).execute();

System.out.println(messageResponse);
```
[assistant]: https://console.bluemix.net/docs/services/assistant/index.html
