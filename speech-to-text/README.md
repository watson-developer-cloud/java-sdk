# Speech to Text

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson</groupId>
  <artifactId>speech-to-text</artifactId>
  <version>7.3.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson:speech-to-text:7.3.1'
```

## Usage
Use the [Speech to Text][speech_to_text] service to recognize the text from a .wav file.

```java
SpeechToText service = new SpeechToText();
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

File audio = new File("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
  .audio(audio)
  .contentType(HttpMediaType.AUDIO_WAV)
  .build();

SpeechRecognitionResults transcript = service.recognize(options).execute().getResult();
System.out.println(transcript);
```

#### WebSocket support

Speech to Text supports WebSocket, the url is: `wss://stream.watsonplatform.net/speech-to-text/api/v1/recognize`

```java
SpeechToText service = new SpeechToText();
IamOptions options = new IamOptions.Builder()
  .apiKey("<iam_api_key>")
  .build();
service.setIamCredentials(options);

InputStream audio = new FileInputStream("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
  .audio(audio)
  .contentType(HttpMediaType.AUDIO_WAV)
  .interimResults(true)
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

[speech_to_text]: https://cloud.ibm.com/docs/services/speech-to-text?topic=speech-to-text-about
