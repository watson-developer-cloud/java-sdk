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
import com.ibm.watson.speech_to_text.v1.model.AddCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.AddWordOptions;
import com.ibm.watson.speech_to_text.v1.model.Corpora;
import com.ibm.watson.speech_to_text.v1.model.Corpus;
import com.ibm.watson.speech_to_text.v1.model.CreateLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.DeleteLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.GetCorpusOptions;
import com.ibm.watson.speech_to_text.v1.model.GetLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.LanguageModel;
import com.ibm.watson.speech_to_text.v1.model.ListCorporaOptions;
import com.ibm.watson.speech_to_text.v1.model.ListWordsOptions;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.speech_to_text.v1.model.TrainLanguageModelOptions;
import com.ibm.watson.speech_to_text.v1.model.Words;
import java.io.File;
import java.io.FileNotFoundException;

/** Example of how to create and use a custom language model. */
public class CustomizationExample {

  private static final String AUDIO_FILE =
      "speech-to-text/src/test/resources/speech_to_text/cap047.wav";
  private static final String CORPUS_FILE =
      "speech-to-text/src/test/resources/speech_to_text/corpus1.txt";

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws InterruptedException the interrupted exception
   */
  public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    SpeechToText service = new SpeechToText(authenticator);

    // Create language model
    CreateLanguageModelOptions createOptions =
        new CreateLanguageModelOptions.Builder()
            .name("IEEE-permanent")
            .baseModelName("en-US_BroadbandModel")
            .description("My customization")
            .build();
    LanguageModel myModel = service.createLanguageModel(createOptions).execute().getResult();
    String id = myModel.getCustomizationId();

    try {
      // Add a corpus file to the model
      AddCorpusOptions addOptions =
          new AddCorpusOptions.Builder()
              .customizationId(id)
              .corpusName("corpus-1")
              .corpusFile(new File(CORPUS_FILE))
              .allowOverwrite(false)
              .build();
      service.addCorpus(addOptions).execute().getResult();

      // Get corpus status
      GetCorpusOptions getOptions =
          new GetCorpusOptions.Builder().customizationId(id).corpusName("corpus-1").build();
      for (int x = 0;
          x < 30
              && !service
                  .getCorpus(getOptions)
                  .execute()
                  .getResult()
                  .getStatus()
                  .equals(Corpus.Status.ANALYZED);
          x++) {
        Thread.sleep(5000);
      }

      // Get all corpora
      ListCorporaOptions listCorporaOptions =
          new ListCorporaOptions.Builder().customizationId(id).build();
      Corpora corpora = service.listCorpora(listCorporaOptions).execute().getResult();
      System.out.println(corpora);

      // Get specific corpus
      Corpus corpus = service.getCorpus(getOptions).execute().getResult();
      System.out.println(corpus);

      // Now add some user words to the custom model
      service
          .addWord(
              new AddWordOptions.Builder()
                  .customizationId(id)
                  .wordName("IEEE")
                  .word("IEEE")
                  .displayAs("IEEE")
                  .addSoundsLike("I. triple E.")
                  .build())
          .execute();
      service
          .addWord(
              new AddWordOptions.Builder()
                  .customizationId(id)
                  .wordName("hhonors")
                  .word("hhonors")
                  .displayAs("IEEE")
                  .addSoundsLike("H. honors")
                  .addSoundsLike("Hilton honors")
                  .build())
          .execute();

      // Display all words in the words resource (OOVs from the corpus and
      // new words just added) in ascending alphabetical order
      ListWordsOptions listWordsAlphabeticalOptions =
          new ListWordsOptions.Builder()
              .customizationId(id)
              .wordType(ListWordsOptions.WordType.ALL)
              .build();
      Words words = service.listWords(listWordsAlphabeticalOptions).execute().getResult();
      System.out.println("\nASCENDING ALPHABETICAL ORDER:");
      System.out.println(words);

      // Then display all words in the words resource in descending order
      // by count
      ListWordsOptions listWordsCountOptions =
          new ListWordsOptions.Builder()
              .customizationId(id)
              .wordType(ListWordsOptions.WordType.ALL)
              .sort("-" + ListWordsOptions.Sort.COUNT)
              .build();
      words = service.listWords(listWordsCountOptions).execute().getResult();
      System.out.println("\nDESCENDING ORDER BY COUNT:");
      System.out.println(words);

      // Now start training of the model
      TrainLanguageModelOptions trainOptions =
          new TrainLanguageModelOptions.Builder()
              .customizationId(id)
              .wordTypeToAdd(TrainLanguageModelOptions.WordTypeToAdd.ALL)
              .build();
      service.trainLanguageModel(trainOptions).execute();

      for (int x = 0; x < 30 && !myModel.getStatus().equals(LanguageModel.Status.AVAILABLE); x++) {
        GetLanguageModelOptions getLanguageModelOptions =
            new GetLanguageModelOptions.Builder().customizationId(id).build();
        myModel = service.getLanguageModel(getLanguageModelOptions).execute().getResult();
        Thread.sleep(10000);
      }

      File audio = new File(AUDIO_FILE);
      RecognizeOptions recognizeOptionsWithModel =
          new RecognizeOptions.Builder()
              .model(RecognizeOptions.Model.EN_US_BROADBANDMODEL)
              .customizationId(id)
              .audio(audio)
              .contentType(HttpMediaType.AUDIO_WAV)
              .build();
      RecognizeOptions recognizeOptionsWithoutModel =
          new RecognizeOptions.Builder()
              .model(RecognizeOptions.Model.EN_US_BROADBANDMODEL)
              .audio(audio)
              .contentType(HttpMediaType.AUDIO_WAV)
              .build();

      // First decode WITHOUT the custom model
      SpeechRecognitionResults transcript =
          service.recognize(recognizeOptionsWithoutModel).execute().getResult();
      System.out.println(transcript);

      // Now decode with the custom model
      transcript = service.recognize(recognizeOptionsWithModel).execute().getResult();
      System.out.println(transcript);
    } finally {
      DeleteLanguageModelOptions deleteOptions =
          new DeleteLanguageModelOptions.Builder().customizationId(id).build();
      service.deleteLanguageModel(deleteOptions).execute();
    }
  }
}
