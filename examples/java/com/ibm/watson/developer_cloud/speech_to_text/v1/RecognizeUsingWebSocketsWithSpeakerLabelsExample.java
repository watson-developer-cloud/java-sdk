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

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.*;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Recognize using WebSockets a sample wav file and print the transcript into the console output.
 */
public class RecognizeUsingWebSocketsWithSpeakerLabelsExample {
  static class RecoToken {
    private double startTime;
    private double endTime;
    private int speaker;
    private String word;
    private boolean spLabelIsFinal;

    RecoToken(SpeechTimestamp speechTimestamp) {
      startTime = speechTimestamp.getStartTime();
      endTime = speechTimestamp.getEndTime();
      word = speechTimestamp.getWord();
    }
    RecoToken(SpeakerLabel speakerLabel) {
      startTime = speakerLabel.getFrom();
      endTime = speakerLabel.getTo();
      speaker = speakerLabel.getSpeaker();
    }
    void updateFrom(SpeechTimestamp speechTimestamp) {
      word = speechTimestamp.getWord();
    }
    void updateFrom(SpeakerLabel speakerLabel) {
      speaker = speakerLabel.getSpeaker();
    }
  }

  static class RecoTokens {
    Map<Double, RecoToken> recoTokenMap = new LinkedHashMap<>();

    public void add(SpeechResults speechResults) {
      if (speechResults.getResults() != null)
        for (int i = 0; i < speechResults.getResults().size(); i++) {
          Transcript transcript = speechResults.getResults().get(i);
          if (transcript.isFinal()) {
            SpeechAlternative speechAlternative = transcript.getAlternatives().get(0);

            for (int ts = 0; ts < speechAlternative.getTimestamps().size(); ts++) {
              SpeechTimestamp speechTimestamp = speechAlternative.getTimestamps().get(ts);
              add(speechTimestamp);
            }
          }
        }
      if (speechResults.getSpeaker_labels() != null)
        for (int i = 0; i < speechResults.getSpeaker_labels().size(); i++) {
          add(speechResults.getSpeaker_labels().get(i));
        }

    }

    public void add(SpeechTimestamp speechTimestamp) {
      RecoToken recoToken = recoTokenMap.get(speechTimestamp.getStartTime());
      if (recoToken == null) {
        recoToken = new RecoToken(speechTimestamp);
        recoTokenMap.put(speechTimestamp.getStartTime(), recoToken);
      }
      else
        recoToken.updateFrom(speechTimestamp);
    }

    public void add(SpeakerLabel speakerLabel) {
      RecoToken recoToken = recoTokenMap.get(speakerLabel.getFrom());
      if (recoToken == null) {
        recoToken = new RecoToken(speakerLabel);
        recoTokenMap.put(speakerLabel.getFrom(), recoToken);
      }
      else
        recoToken.updateFrom(speakerLabel);

      if (speakerLabel.isFfinal()) {
        markTokensBeforeAsFinal(speakerLabel);
        reportFinal();
        cleanFinal();
      }
    }

    private void markTokensBeforeAsFinal(SpeakerLabel speakerLabel) {
      Map<Double, RecoToken> recoTokenMap = new LinkedHashMap<>();

      for (RecoToken rt: recoTokenMap.values()) {
        if (rt.startTime <= speakerLabel.getFrom())
          rt.spLabelIsFinal = true;
      }
    }

    private void reportFinal() {
      int currentSpeaker = -1;
      String currentTranscript = "";

      for (RecoToken rt: recoTokenMap.values()) {
        if (currentSpeaker != rt.speaker) {
          System.out.println(currentTranscript);
          currentSpeaker = rt.speaker;
          currentTranscript = "";
          currentTranscript = "Speaker " + currentSpeaker + " ";
        }
        currentTranscript = currentTranscript + rt.word + " ";
      }
    }

    private void cleanFinal() {
      Set<Map.Entry<Double,RecoToken>> set = recoTokenMap.entrySet();
      for(Map.Entry<Double, RecoToken> e : set){
        if(e.getValue().spLabelIsFinal){
          recoTokenMap.remove(e.getKey());
        }
      }
    }


    public String toString() {
      return recoTokenMap.toString();
    }
  }


  private static CountDownLatch lock = new CountDownLatch(1);

  public static void main1(String[] args) throws FileNotFoundException, InterruptedException {
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

    final RecoTokens recoTokens = new RecoTokens();
    service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
      @Override
      public void onTranscription(SpeechResults speechResults) {
        for (Transcript t: speechResults.getResults())
       //   recoTokens.add(speechResults);
          System.out.println(speechResults);
      }

      @Override
      public void onDisconnected() {
        lock.countDown();
      }
    });

    lock.await(1, TimeUnit.MINUTES);
  }

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    SpeechToText service = new SpeechToText();

    String URL = "https://stream-s.watsonplatform.net/speech-to-text/api";
    service.setUsernameAndPassword("c9122908-2741-4610-93b9-f33a731ba920", "74jxojn8LV9i");
    service.setEndPoint(URL);

    FileInputStream audio = new FileInputStream("/Users/afaisman/dev/data/8khz/Us_English_Narrowband_Sample_1.wav");

    RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).interimResults(true)
            .speakerLabels(true)
            .model("en-US_NarrowbandModel")
            .contentType(HttpMediaType.AUDIO_WAV).build();

    final RecoTokens recoTokens = new RecoTokens();
    service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
      @Override
      public void onTranscription(SpeechResults speechResults) {
        recoTokens.add(speechResults);
      }

      @Override
      public void onDisconnected() {
        lock.countDown();
      }
    });

    lock.await(1, TimeUnit.MINUTES);
  }

}
