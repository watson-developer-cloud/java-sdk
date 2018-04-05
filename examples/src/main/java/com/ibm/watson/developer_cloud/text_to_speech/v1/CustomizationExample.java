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
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import java.util.Arrays;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CreateVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.DeleteVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListVoiceModelsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Translation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.UpdateVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModels;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Word;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Words;

public class CustomizationExample {

  public static void main(String[] args) throws IOException {
    TextToSpeech service = new TextToSpeech("<username>", "<password>");

    // create custom voice model.
    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name("my model")
        .language("en-US")
        .description("the model for testing")
        .build();
    VoiceModel customVoiceModel = service.createVoiceModel(createOptions).execute();
    System.out.println(customVoiceModel);

    // list custom voice models for US English.
    ListVoiceModelsOptions listOptions = new ListVoiceModelsOptions.Builder()
        .language("en-US")
        .build();
    VoiceModels customVoiceModels = service.listVoiceModels(listOptions);
    System.out.println(customVoiceModels);

    // update custom voice model.
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .name(newName)
        .description("the updated model for testing")
        .build();
    service.updateVoiceModel(updateOptions).execute();

    // list custom voice models regardless of language.
    customVoiceModels = service.listVoiceModels().execute();
    System.out.println(customVoiceModels);

    // create multiple custom word translations
    Word word1 = new Word();
    word1.setWord("hodor");
    word1.setTranslation("hold the door");
    Word word2 = new Word();
    word2.setWord("plz");
    word2.setTranslation("please");
    List<Word> words = Arrays.asList(word1, word2);
    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .words(words)
        .build();
    service.addWords(addOptions).execute();

    // create a single custom word translation
    AddWordOptions addOptions = new AddWordOptions.Builder()
        .word("nat")
        .translation("and that")
        .customizationId(customVoiceModel.getCustomizationId())
        .build();
    service.addWord(addOptions).execute();

    // get custom word translations
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .build();
    Words words = service.listWords(listOptions).execute();
    System.out.println(words);

    // get custom word translation
    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .word("hodor")
        .build();
    Translation translation = service.getWord(getOptions).execute();
    System.out.println(translation);

    // synthesize with custom voice model
    String text = "plz hodor";
    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(text)
        .voice(SynthesizeOptions.Voice.EN_US_MICHAELVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_WAV)
        .customizationId(customVoiceModel.getCustomizationId())
        .build();
    InputStream in = service.synthesize(synthesizeOptions).execute();
    writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));

    // delete custom words with object and string
    DeleteWordOptions deleteOptions1 = new DeleteWordOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .word(word1.getWord())
        .build();
    service.deleteWord(deleteOptions1).execute();
    DeleteWordOptions deleteOptions2 = new DeleteWordOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .word(word2.getWord())
        .build();
    service.deleteWord(deleteOptions2).execute();

    // delete custom voice model
    DeleteVoiceModelOptions deleteOptions = new DeleteVoiceModelOptions.Builder()
        .customizationId(customVoiceModel.getCustomizationId())
        .build();
    service.deleteVoiceModel(deleteOptions).execute();

    // list custom voice models regardless of language.
    customVoiceModels = service.listVoiceModels().execute();
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
