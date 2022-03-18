/*
 * (C) Copyright IBM Corp. 2019, 2021.
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
package com.ibm.watson.text_to_speech.v1;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CustomModel;
import com.ibm.watson.text_to_speech.v1.model.CustomModels;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Translation;
import com.ibm.watson.text_to_speech.v1.model.UpdateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.Word;
import com.ibm.watson.text_to_speech.v1.model.Words;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class CustomizationExample {

  public static void main(String[] args) throws IOException {
    Authenticator authenticator = new IamAuthenticator("<iam_api_key>");
    TextToSpeech service = new TextToSpeech(authenticator);

    // create custom voice model.
    CreateCustomModelOptions createOptions =
        new CreateCustomModelOptions.Builder()
            .name("my model")
            .language("en-US")
            .description("the model for testing")
            .build();
    CustomModel customVoiceModel = service.createCustomModel(createOptions).execute().getResult();
    System.out.println(customVoiceModel);

    // list custom voice models for US English.
    ListCustomModelsOptions listOptions =
        new ListCustomModelsOptions.Builder().language("en-US").build();
    CustomModels customVoiceModels = service.listCustomModels(listOptions).execute().getResult();
    System.out.println(customVoiceModels);

    // update custom voice model.
    String newName = "my updated model";
    UpdateCustomModelOptions updateOptions =
        new UpdateCustomModelOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .name(newName)
            .description("the updated model for testing")
            .build();
    service.updateCustomModel(updateOptions).execute();

    // list custom voice models regardless of language.
    customVoiceModels = service.listCustomModels().execute().getResult();
    System.out.println(customVoiceModels);

    // create multiple custom word translations
    Word word1 = new Word.Builder().word("hodor").translation("hold the door").build();
    Word word2 = new Word.Builder().word("plz").translation("please").build();
    List<Word> words = Arrays.asList(word1, word2);
    AddWordsOptions addOptions =
        new AddWordsOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .words(words)
            .build();
    service.addWords(addOptions).execute();

    // create a single custom word translation
    AddWordOptions addWordOptions =
        new AddWordOptions.Builder()
            .word("nat")
            .translation("and that")
            .customizationId(customVoiceModel.getCustomizationId())
            .build();
    service.addWord(addWordOptions).execute();

    // get custom word translations
    ListWordsOptions listWordsOptions =
        new ListWordsOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .build();
    Words customWords = service.listWords(listWordsOptions).execute().getResult();
    System.out.println(customWords);

    // get custom word translation
    GetWordOptions getOptions =
        new GetWordOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .word("hodor")
            .build();
    Translation translation = service.getWord(getOptions).execute().getResult();
    System.out.println(translation);

    // synthesize with custom voice model
    String text = "plz hodor";
    SynthesizeOptions synthesizeOptions =
        new SynthesizeOptions.Builder()
            .text(text)
            .voice(SynthesizeOptions.Voice.EN_US_MICHAELVOICE)
            .accept(HttpMediaType.AUDIO_WAV)
            .customizationId(customVoiceModel.getCustomizationId())
            .build();
    InputStream in = service.synthesize(synthesizeOptions).execute().getResult();
    writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));

    // delete custom words with object and string
    DeleteWordOptions deleteOptions1 =
        new DeleteWordOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .word(word1.word())
            .build();
    service.deleteWord(deleteOptions1).execute();
    DeleteWordOptions deleteOptions2 =
        new DeleteWordOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .word(word2.word())
            .build();
    service.deleteWord(deleteOptions2).execute();

    // delete custom voice model
    DeleteCustomModelOptions deleteOptions =
        new DeleteCustomModelOptions.Builder()
            .customizationId(customVoiceModel.getCustomizationId())
            .build();
    service.deleteCustomModel(deleteOptions).execute();

    // list custom voice models regardless of language.
    customVoiceModels = service.listCustomModels().execute().getResult();
    System.out.println(customVoiceModels);
  }

  private static void writeToFile(InputStream in, File file) {
    try {
      OutputStream out = new FileOutputStream(file);
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
