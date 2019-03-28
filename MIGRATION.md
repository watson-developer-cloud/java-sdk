# v7.0.0
Hello! If you're reading this, you're probably upgrading to **v7.0.0** of the Watson Java SDK. If that's the case, this guide will help you transition smoothly to get on board with the latest Watson API features in your Java code. Let's get started!

## **Big** things
### New library name
For this release, we've changed package managers and decided to change the name along with it. Be sure to change this when upgrading by looking at the installation instructions in the README: https://github.com/watson-developer-cloud/java-sdk#installation

### Response formats
For a while now, we've had three main methods to execute an API call: `execute()`, `enqueue()`, and `rx()`. In our `v5.3.0` release, we added some variations of those methods to return not only the basic response model, but some added HTTP information like response headers.

In this release, we've dropped those variants and instead have modified the base methods to always return the extra information. In addition, we've replaced `rx()` with `reactiveRequest()`, which lets you leverage [RxJava](https://github.com/ReactiveX/RxJava) to do some reactive programming if that's your thing.

In short, the general structure of responses is different and you can read more about that [here](https://github.com/watson-developer-cloud/java-sdk#parsing-responses). If you're looking for making asynchronous API calls, you can read the details about that and the new `reactiveRequest()` method [here](https://github.com/watson-developer-cloud/java-sdk#making-asynchronous-api-calls).

## Everything else
Along with the major changes above, there have been more detailed breaking changes across services with API changes and updates to the SDK design. You can find these nitty-gritty details in the [release notes](https://github.com/watson-developer-cloud/java-sdk/releases/tag/java-sdk-7.0.0), along with the changes that are non-breaking.

---

# 4.0

## Conversation

- No old version dates -- just current
- All methods now take options objects, e.g.:

    ```java
    MessageRequest request = new MessageRequest.Builder()
      .inputText(message)
      .build();
    service.message(workspaceId, request).execute();
    ```
  is now:

    ```java
    MessageOptions messageOptions = new MessageOptions.Builder()
      .workspaceId(workspaceId)
      .input(new InputData.Builder(message).build())
      .build();
    service.message(messageOptions).execute();
    ```
- `Context` is now a formal class that extends map.
- Many classes have been renamed - mostly dropping "Response" from classnames.
  - `EntityResponse` is now `Entity`
  - `ExampleResponse` is now `Example`
  - `IntentResponse` is now Intent
  - `WorkspaceResponse` is now `Workspace`

  _This renaming was done for simplicity and to improve consistency across SDKs going forward._

- Counterexample now has its own classes no longer overloaded on Example

## Tone Analyzer

- The method `getTone()` was replaced with: `tone()`.

  For example:

  ```java
  public ServiceCall<ToneAnalysis> getTone(String text, ToneOptions options)
  ```

  Is now:
  ```java
  public ServiceCall<ToneAnalysis> tone(ToneOptions options)
  ```

  `tone()` example:
  ```java
  ToneOptions toneOptions = new ToneOptions.Builder()
    .text(text)
    .build();
  ToneAnalysis tone = service.tone(toneOptions).execute();
  ```

- The method `getToneChat()` was replaced with: `toneChat()`.

  For example:

  ```java
  public ServiceCall<ToneAnalysis> getChatTone(ToneChatRequest options)
  ```

  Is now:

  ```java
  public ServiceCall<UtteranceAnalyses> chatTone(ToneChatOptions options) {

  ```

  `chatTone()` example:
  ```java
  String[] texts = {
    "My charger isn't working.",
    "Thanks for reaching out. Can you give me some more detail about the issue?",
    "I put my charger in my tablet to charge it up last night and it keeps saying it isn't"
        + " charging. The charging icon comes on, but it stays on even when I take the charger out. "
        + "Which is ridiculous, it's brand new.",
    "I'm sorry you're having issues with charging. What kind of charger are you using?"
  };

  List<Utterance> utterances = new ArrayList<>();
  for (int i = 0; i < texts.length; i++) {
    Utterance utterance = new Utterance.Builder()
      .text(texts[i])
      .user(users[i])
      .build();
    utterances.add(utterance);
  }
  ToneChatOptions toneChatOptions = new ToneChatOptions.Builder()
    .utterances(utterances)
    .build();

  // Call the service
  UtteranceAnalyses utterancesTone = service.toneChat(toneChatOptions).execute();
  ```