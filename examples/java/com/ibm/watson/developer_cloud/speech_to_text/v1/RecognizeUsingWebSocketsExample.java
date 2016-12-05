/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
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
  class RecoToken {
    Map<String, Object> values = new HashMap<>();
  }

  private static CountDownLatch lock = new CountDownLatch(1);

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    SpeechToText service = new SpeechToText();
    //service.setUsernameAndPassword("<username>", "<password>");
    // staging
    //https://stream-s.watsonplatform.net/speech-to-text/api
    //var username = 'c9122908-2741-4610-93b9-f33a731ba920';
    //var password = '74jxojn8LV9i';
    String URL = "https://stream-s.watsonplatform.net/speech-to-text/api";
    service.setUsernameAndPassword("c9122908-2741-4610-93b9-f33a731ba920", "74jxojn8LV9i");
    service.setEndPoint(URL);

    FileInputStream audio = new FileInputStream("/Users/afaisman/dev/data/8khz/voicemaill_20s_8khz.wav");

    RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).interimResults(true).speakerLabels(true)
            .model("en-US_NarrowbandModel")
        .contentType(HttpMediaType.AUDIO_WAV).build();

    service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
      @Override
      public void onTranscription(SpeechResults speechResults) {
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
