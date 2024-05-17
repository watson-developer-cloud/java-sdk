# Speech to Text

## Installation

##### Maven

```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>speech-to-text</artifactId>
  <version>12.0.1</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.watson:speech-to-text:12.0.1'
```

## Usage

Use the [Speech to Text][speech_to_text] service to recognize the text from a .wav file.

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
SpeechToText service = new SpeechToText(authenticator);

File audio = new File("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
  .audio(audio)
  .contentType(HttpMediaType.AUDIO_WAV)
  .build();

SpeechRecognitionResults transcript = service.recognize(options).execute().getResult();
System.out.println(transcript);
```

#### WebSocket support

Speech to Text supports WebSocket, the url is: `wss://api.us-south.speech-to-text.watson.cloud.ibm.com/v1/recognize`

```java
Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
SpeechToText service = new SpeechToText(authenticator);

InputStream audio = new FileInputStream("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
  .audio(audio)
  .contentType(HttpMediaType.AUDIO_WAV)
  .build();

service.recognizeUsingWebSocket(options, new BaseRecognizeCallback() {
  @Override
  public void onTranscription(Response<SpeechRecognitionResults> speechResults) {
    System.out.println(speechResults);
  }
});

// wait 20 seconds for the asynchronous response
Thread.sleep(20000);
```

[speech_to_text]: https://cloud.ibm.com/docs/speech-to-text?topic=speech-to-text-about
