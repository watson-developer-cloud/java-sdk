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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.*;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecognizeUsingWebSocketsWithSpeakerLabelsExample {
  static class RecoToken {
    private double startTime;
    private double endTime;
    private Integer speaker;
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

  static class Utterance {
    private Integer speaker;
    private String transcript = "";

    public Utterance(int speaker, String transcript) {
      this.speaker = speaker;
      this.transcript = transcript;
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
      if (speechResults.getSpeakerLabels() != null)
        for (int i = 0; i < speechResults.getSpeakerLabels().size(); i++) {
          add(speechResults.getSpeakerLabels().get(i));
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

      if (speakerLabel.isFinal()) {
        markTokensBeforeAsFinal(speakerLabel.getFrom());
        report();
        cleanFinal();
      }
    }

    private void markTokensBeforeAsFinal(Double from) {
      Map<Double, RecoToken> recoTokenMap = new LinkedHashMap<>();

      for (RecoToken rt: recoTokenMap.values()) {
        if (rt.startTime <= from)
          rt.spLabelIsFinal = true;
      }
    }

    public void report() {
      List<Utterance> uttterances = new ArrayList<Utterance>();
      Utterance currentUtterance = new Utterance(0, "");

      for (RecoToken rt: recoTokenMap.values()) {
        if (currentUtterance.speaker != rt.speaker) {
          uttterances.add(currentUtterance);
          currentUtterance = new Utterance(rt.speaker, "");
        }
        currentUtterance.transcript = currentUtterance.transcript + rt.word + " ";
      }
      uttterances.add(currentUtterance);
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String json = gson.toJson(uttterances);
      System.out.println(json);
    }

    private void cleanFinal() {
      Set<Map.Entry<Double,RecoToken>> set = recoTokenMap.entrySet();
      for(Map.Entry<Double, RecoToken> e : set){
        if(e.getValue().spLabelIsFinal){
          recoTokenMap.remove(e.getKey());
        }
      }
    }

  }


  private static CountDownLatch lock = new CountDownLatch(1);

  /*
  Notes:
  - At this point (Dec 2016) the speaker labeling feature us supported only with en-US_NarrowbandModel.

  - The flow of this example is defined by the way the speaker labelling feature works. When it turned on,
  some of the SpeechResults instances arriving in onTranscription message, contain the  List<SpeakerLabel> speakerLabels in parallel with  the regular List<Transcript> results
  SpeakerLabel class conains the timing information, and a boolen flag is final. The stream of speaker labels looks like non-final, non-final, ..., not-final, final.
  Non-final labels can owerwrite each other, when the labeling algorithm "changes it's mind" about some of the previuous speaker labels. Arrival of a final speaker
  label means that the algorithm made its mid about the previous speech fragment and that the previously collected labels won't to be changed in future.

  In this example the arrival of final is the moment when the code prints the collected results. The results collected in a hashmap where the timing is used as key.

  - Accuracy. The speaker labeling algorythms can make mistakes depending on the noise, speakers,manner of peach etc. However it can be very useful im many situations.
  For example, you can use it to annotate a meeting, a long phone call or a presidential debate and use the annotation to navigate quickly to the  part of the audio when
  a given speaker was talking.
   */

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    SpeechToText service = new SpeechToText();
    FileInputStream audio = new FileInputStream("src/test/resources/speech_to_text/twospeakers.wav");

    // begin - remove when the speaker labeling is released
    service.setUsernameAndPassword("<username>", "<password>");
    service.setUsernameAndPassword("c9122908-2741-4610-93b9-f33a731ba920", "74jxojn8LV9i");
    String URL = "https://stream-s.watsonplatform.net/speech-to-text/api";
    service.setEndPoint(URL);
    //FileInputStream audio = new FileInputStream("/Users/afaisman/dev/data/twospeakers.wav");
    // end - remove when the speaker labeling is released

    RecognizeOptions options = new RecognizeOptions.Builder().continuous(true).interimResults(true)
            .speakerLabels(true).model("en-US_NarrowbandModel")
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
