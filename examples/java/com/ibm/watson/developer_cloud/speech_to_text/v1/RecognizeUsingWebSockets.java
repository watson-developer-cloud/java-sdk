package com.ibm.watson.developer_cloud.speech_to_text.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeDelegate;

/**
 * Recognize using WebSockets a sample wav file and print the transcript into the console output.
 */
public class RecognizeUsingWebSockets {
  public static void main(String[] args) throws FileNotFoundException {
    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("<username>", "<password>");

    FileInputStream audio = new FileInputStream("src/test/resources/speech_to_text/sample1.wav");

    RecognizeOptions options =
        new RecognizeOptions().continuous(true).interimResults(true)
            .contentType(HttpMediaType.AUDIO_WAV);

    service.recognizeUsingWebSockets(audio, options, new BaseRecognizeDelegate() {

      @Override
      public void onMessage(SpeechResults speechResults) {
        System.out.println(speechResults);
      }
    });
  }
}
