# Speech to Text

## Installation

##### Maven
```xml
<dependency>
	<groupId>com.ibm.watson.developer_cloud</groupId>
	<artifactId>speech-to-text</artifactId>
	<version>4.1.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:speech-to-text:4.1.0'
```

## Usage
Use the [Speech to Text][speech_to_text] service to recognize the text from a .wav file.

```java
SpeechToText service = new SpeechToText();
service.setUsernameAndPassword("<username>", "<password>");

File audio = new File("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
    .contentType(HttpMediaType.AUDIO_WAV)
    .build();

SpeechResults transcript = service.recognize(audio, options).execute();
System.out.println(transcript);
```

#### WebSocket support

Speech to Text supports WebSocket, the url is:
  `wss://stream.watsonplatform.net/speech-to-text/api/v1/recognize`

  ```java
SpeechToText service = new SpeechToText();
service.setUsernameAndPassword("<username>", "<password>");

InputStream audio = new FileInputStream("src/test/resources/sample1.wav");

RecognizeOptions options = new RecognizeOptions.Builder()
    .interimResults(true)
    .contentType(HttpMediaType.AUDIO_WAV)
    .build();

service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
  @Override
  public void onTranscription(SpeechResults speechResults) {
    System.out.println(speechResults);
  }
});

// wait 20 seconds for the asynchronous response
Thread.sleep(20000);
```
#### Microphone example
Use your microphone to recognize audio for 30 seconds.

```java
SpeechToText service = new SpeechToText();
service.setUsernameAndPassword("<username>", "<password>");

// Signed PCM AudioFormat with 16kHz, 16 bit sample size, mono
int sampleRate = 16000;
AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, false);
DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

if (!AudioSystem.isLineSupported(info)) {
  System.out.println("Line not supported");
  System.exit(0);
}

TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
line.open(format);
line.start();

AudioInputStream audio = new AudioInputStream(line);

RecognizeOptions options = new RecognizeOptions.Builder()
  .continuous(true)
  .interimResults(true)
//.inactivityTimeout(5) // use this to stop listening when the speaker pauses, i.e. for 5s
  .contentType(HttpMediaType.AUDIO_RAW + "; rate=" + sampleRate)
  .build();

service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
  @Override
  public void onTranscription(SpeechResults speechResults) {
    System.out.println(speechResults);
  }
});

System.out.println("Listening to your voice for the next 30s...");
Thread.sleep(30 * 1000);

// closing the WebSockets underlying InputStream will close the WebSocket itself.
line.stop();
line.close();

System.out.println("Fin.");
```

[speech_to_text]: https://console.bluemix.net/docs/services/speech-to-text/index.html
