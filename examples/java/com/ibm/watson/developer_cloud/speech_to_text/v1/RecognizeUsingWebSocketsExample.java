package com.ibm.watson.developer_cloud.speech_to_text.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

/**
 * Recognize using WebSockets a sample wav file and print the transcript into the console output.
 */
public class RecognizeUsingWebSocketsExample {
  private static CountDownLatch lock = new CountDownLatch(1);

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("<username>", "<password>");

    FileInputStream audio = new FileInputStream("src/test/resources/speech_to_text/sample1.wav");

    RecognizeOptions options = new RecognizeOptions.Builder()
        .continuous(true)
        .interimResults(true)
        .contentType(HttpMediaType.AUDIO_WAV)
        .build();

    service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
      @Override
      public void onTranscription(SpeechResults speechResults) {
        System.out.println(speechResults);
        if (speechResults.isFinal())
          lock.countDown();
      }
    });

    lock.await(1, TimeUnit.MINUTES);
  }
}
