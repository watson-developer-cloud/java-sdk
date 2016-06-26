/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class CustomizationExample {

  public static void main(String[] args) throws IOException {
    TextToSpeech service = new TextToSpeech("<username>", "<password>");

    //create custom voice model.
    CustomVoiceModel model = new CustomVoiceModel();
    model.setName("my model");
    model.setLanguage("en-us");
    model.setDescription("the model for testing");
    CustomVoiceModel customVoiceModel = service.saveCustomVoiceModel(model).execute();
    System.out.println(customVoiceModel);

    //list custom voice models
    List<CustomVoiceModel> customVoiceModels = service.getCustomVoiceModels("en-us").execute();
    System.out.println(customVoiceModels);

    //create custom word translations
    CustomTranslation customTranslation1 = new CustomTranslation("hodor", "hold the door");
    CustomTranslation customTranslation2 = new CustomTranslation("plz", "please");
    service.saveWords(customVoiceModel, customTranslation1, customTranslation2).execute();

    //get custom word translations
    List<CustomTranslation> words = service.getWords(customVoiceModel).execute();
    System.out.println(words);

    //synthesize with custom voice model
    String text = "plz hodor";
    InputStream in = service.synthesize(text, Voice.EN_MICHAEL, AudioFormat.WAV, customVoiceModel.getId()).execute();
    writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));
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
