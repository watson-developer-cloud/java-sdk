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