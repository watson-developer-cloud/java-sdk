/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
import java.util.List;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Corpus.Status;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Customization;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Word;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.WordData;

/**
 * Example of how to create and use a customization model.
 */
public class CustomizationExample {

  private static final String AUDIO_FILE = "speech-to-text/src/test/resources/speech_to_text/cap047.wav";
  private static final String CORPUS_FILE = "speech-to-text/src/test/resources/speech_to_text/corpus1.txt";

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws InterruptedException {
    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("<username>", "<password>");

    // Create customization
    Customization myCustomization =
        service.createCustomization("IEEE-permanent", SpeechModel.EN_US_BROADBANDMODEL, "My customization").execute();
    String id = myCustomization.getId();

    try {
      // Add a corpus file to the model:
        service.addCorpus(id, "corpus-1", new File(CORPUS_FILE), false).execute();

      // Get corpus status
      for (int x = 0; x < 30 && (service.getCorpus(id, "corpus-1").execute()).getStatus() != Status.ANALYZED; x++) {
        Thread.sleep(5000);
      }

      // Get all corpora
      List<Corpus> corpora = service.getCorpora(id).execute();
      System.out.println(corpora);

      // Get specific corpus
      Corpus corpus = service.getCorpus(id, "corpus-1").execute();
      System.out.println(corpus);

      // Now add some user words to the custom model
      service.addWord(id, new Word("IEEE", "IEEE", "I. triple E.")).execute();
      service.addWord(id, new Word("hhonors", "IEEE", "H. honors", "Hilton honors")).execute();

      // Display all words in the words resource (OOVs from the corpus and
      // new words just added) in ascending alphabetical order
      List<WordData> result = service.getWords(id, Word.Type.ALL).execute();
      System.out.println("\nASCENDING ALPHABETICAL ORDER:");
      System.out.println(result);

      // Then display all words in the words resource in descending order
      // by count
      result = service.getWords(id, Word.Type.ALL, Word.Sort.MINUS_COUNT).execute();
      System.out.println("\nDESCENDING ORDER BY COUNT:");
      System.out.println(result);

      // Now start training of the model
      service.trainCustomization(id, Customization.WordTypeToAdd.ALL).execute();

      for (int x = 0; x < 30 && myCustomization.getStatus() != Customization.Status.AVAILABLE; x++) {
        myCustomization = service.getCustomization(id).execute();
        Thread.sleep(10000);
      }

      File audio = new File(AUDIO_FILE);
      RecognizeOptions options = new RecognizeOptions.Builder().continuous(true)
          .model(SpeechModel.EN_US_BROADBANDMODEL.getName()).customizationId(id).build();

      // First decode WITHOUT the custom model
      SpeechResults transcript = service.recognize(audio).execute();
      System.out.println(transcript);

      // Now decode with the custom model
      transcript = service.recognize(audio, options).execute();
      System.out.println(transcript);
    } finally {
      service.deleteCustomization(id);
    }

  }

}
