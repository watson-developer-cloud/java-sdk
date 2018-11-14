# Text to Speech

## Installation

##### Maven
```xml
<dependency>
  <groupId>com.ibm.watson.developer_cloud</groupId>
  <artifactId>text-to-speech</artifactId>
  <version>6.9.2</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.watson.developer_cloud:text-to-speech:6.9.2'
```

## Usage
Use the [Text to Speech][text_to_speech] service to get the available voices to synthesize.

```java
TextToSpeech service = new TextToSpeech();
service.setUsernameAndPassword("<username>", "<password>");

Voices voices = service.listVoices().execute();
System.out.println(voices);
```

[text_to_speech]: https://console.bluemix.net/docs/services/text-to-speech/index.html
