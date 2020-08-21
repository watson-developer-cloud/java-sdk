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

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Recognize a sample wav file and print the transcript into the console output. Make sure you are
 * using UTF-8 to print messages; otherwise, you will see question marks.
 */
public class SpeechToTextExample {

  public static void main(String[] args) throws FileNotFoundException {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    SpeechToText service = new SpeechToText(authenticator);

    File audio = new File("src/test/resources/speech_to_text/sample1.wav");
    RecognizeOptions options =
        new RecognizeOptions.Builder()
            .audio(audio)
            .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
            .build();
    SpeechRecognitionResults transcript = service.recognize(options).execute().getResult();

    System.out.println(transcript);
  }
}
