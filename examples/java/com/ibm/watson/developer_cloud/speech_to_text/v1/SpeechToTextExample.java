/**
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

import java.io.File;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;


/**
 * Recognize a sample wav file and print the transcript into the console output. Make sure you are using UTF-8 to print
 * messages; otherwise, you will see question marks.
 */
public class SpeechToTextExample {

  public static void main(String[] args) {
    SpeechToText service = new SpeechToText();
    //service.setUsernameAndPassword("<username>", "<password>");

    // staging
    //https://stream-s.watsonplatform.net/speech-to-text/api
    //var username = 'c9122908-2741-4610-93b9-f33a731ba920';
    //var password = '74jxojn8LV9i';
    String URL = "https://stream-s.watsonplatform.net/speech-to-text/api";
    service.setUsernameAndPassword("c9122908-2741-4610-93b9-f33a731ba920", "74jxojn8LV9i");
    service.setEndPoint(URL);

    int sampleRate = 8000;
    RecognizeOptions options =
            new RecognizeOptions.Builder().
                    continuous(true).
                    interimResults(true).
                    timestamps(true).
                    wordConfidence(true).
                    speakerLabels(true).
                    model("en-US_NarrowbandModel")
                    // .inactivityTimeout(5) // use this to stop listening when the speaker pauses, i.e. for 5s
                    .contentType(HttpMediaType.AUDIO_RAW + "; rate=" + sampleRate).build();



    File audio = new File("/Users/afaisman/dev/projects/adding-diarization-to-sdk/java-sdk/tests/src/test/resources/speech_to_text/twospeakers.wav");
    SpeechResults transcript = service.recognize(audio, options).execute();

    System.out.println(transcript);
  }
}
