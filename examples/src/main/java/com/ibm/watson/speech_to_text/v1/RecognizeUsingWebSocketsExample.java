/*
 * (C) Copyright IBM Corp. 2019, 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.speech_to_text.v1;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.speech_to_text.v1.websocket.BaseRecognizeCallback;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Recognize using WebSockets a sample wav file and print the transcript into the console output.
 */
public class RecognizeUsingWebSocketsExample {
  private static CountDownLatch lock = new CountDownLatch(1);

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    SpeechToText service = new SpeechToText(authenticator);

    FileInputStream audio = new FileInputStream("src/test/resources/speech_to_text/sample1.wav");

    RecognizeOptions options =
        new RecognizeOptions.Builder()
            .audio(audio)
            .interimResults(true)
            .contentType(HttpMediaType.AUDIO_WAV)
            .build();

    service.recognizeUsingWebSocket(
        options,
        new BaseRecognizeCallback() {
          @Override
          public void onTranscription(SpeechRecognitionResults speechResults) {
            System.out.println(speechResults);
          }

          @Override
          public void onDisconnected() {
            lock.countDown();
          }
        });

    lock.await(1, TimeUnit.MINUTES);
  }
}
