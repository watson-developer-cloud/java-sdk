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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class CustomizationExample {

  public static void main(String[] args) throws IOException {
    TextToSpeech service = new TextToSpeech("<username>", "<password>");

    // create custom voice model.
    CustomVoiceModel customVoiceModel = service.createCustomVoiceModel("my model", "en-US", "the model for testing")
      .execute();
    System.out.println(customVoiceModel);

    // list custom voice models for US English.
    List<CustomVoiceModel> customVoiceModels = service.getCustomVoiceModels("en-US").execute();
    System.out.println(customVoiceModels);

    // update custom voice model.
    customVoiceModel.setName("my updated model");
    customVoiceModel.setDescription("the updated model for testing");
    service.updateCustomVoiceModel(customVoiceModel).execute();

    // list custom voice models regardless of language.
    customVoiceModels = service.getCustomVoiceModels(null).execute();
    System.out.println(customVoiceModels);

    // create multiple custom word translations
    CustomTranslation customTranslation1 = new CustomTranslation("hodor", "hold the door");
    CustomTranslation customTranslation2 = new CustomTranslation("plz", "please");
    service.addWords(customVoiceModel, customTranslation1, customTranslation2).execute();

    // create a single custom word translation
    service.addWord(customVoiceModel, new CustomTranslation("nat", "and that")).execute();

    // get custom word translations
    List<CustomTranslation> words = service.getWords(customVoiceModel).execute();
    System.out.println(words);

    // get custom word translation
    CustomTranslation translation = service.getWord(customVoiceModel, "hodor").execute();
    System.out.println(translation);

    // synthesize with custom voice model
    String text = "plz hodor";
    InputStream in = service.synthesize(text, Voice.EN_MICHAEL, AudioFormat.WAV, customVoiceModel.getId()).execute();
    writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));

    // delete custom words with object and string
    service.deleteWord(customVoiceModel, customTranslation1);
    service.deleteWord(customVoiceModel, customTranslation2.getWord());

    // delete custom voice model
    service.deleteCustomVoiceModel(customVoiceModel).execute();

    // list custom voice models regardless of language.
    customVoiceModels = service.getCustomVoiceModels(null).execute();
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
