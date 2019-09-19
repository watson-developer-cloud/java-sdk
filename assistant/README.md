# Assistant

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>assistant</artifactId>
  <version>7.4.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:assistant:7.4.1'
```

## Usage
Use the [Assistant][assistant] service to identify intents, entities, and conduct conversations.

### Using Assistant v1
```java
// make sure to use the Assistant v1 import!
import com.ibm.watson.assistant.v1.Assistant;

Assistant service = new Assistant("2018-02-16");
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

MessageInput input = new MessageInput();
input.setText("Hi");
MessageOptions options = new MessageOptions.Builder(workspaceId)
  .input(input)
  .build();
MessageResponse response = service.message(options).execute().getResult();
System.out.println(response);
```

Maintaining context across messages:
```java
// make sure to use the Assistant v1 import!
import com.ibm.watson.assistant.v1.Assistant;

Context context = null;
MessageInput input = new MessageInput();

// first message
input.setText("First message");
MessageOptions newMessageOptions = new MessageOptions.Builder()
  .workspaceId("<workspace-id>")
  .input(input)
  .context(context)
  .build();

MessageResponse response = service.message(newMessageOptions).execute().getResult();
context = response.getContext();

// second message
input.setText("Second message");
newMessageOptions = new MessageOptions.Builder()
  .workspaceId("<workspace-id>")
  .input(input)
  .context(context) // using context from the first message
  .build();

response = service.message(newMessageOptions).execute().getResult();

System.out.println(response);
```

---

### Using Assistant v2
```java
// make sure to use the Assistant v2 import!
import com.ibm.watson.assistant.v2.Assistant;

Assistant service = new Assistant("2018-09-20");
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

MessageInput input = new MessageInput.Builder()
  .text("Hi")
  .build();
MessageOptions messageOptions = new MessageOptions.Builder()
  .assistantId("<assistant_id>")
  .sessionId("<session_id>")
  .input(input)
  .build();
MessageResponse messageResponse = service.message(messageOptions).execute().getResult();

System.out.println(messageResponse);
```

Maintaining context across messages:
```java
// make sure to use the Assistant v2 import!
import com.ibm.watson.assistant.v2.Assistant;

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

MessageResponse messageResponse = service.message(messageOptions).execute().getResult();
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

messageResponse = service.message(messageOptions).execute().getResult();

System.out.println(messageResponse);
```
[assistant]: https://cloud.ibm.com/docs/services/assistant?topic=assistant-index
