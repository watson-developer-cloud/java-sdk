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

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

/**
 * Translate from English to Spanish and synthesize that as a WAV file.
 */
public class TranslateAndSynthesizeExample {

  public static void main(String[] args) throws IOException {
    LanguageTranslation translator = new LanguageTranslation();
    translator.setUsernameAndPassword("username", "password");

    TextToSpeech synthesizer = new TextToSpeech();
    synthesizer.setUsernameAndPassword("username", "password");

    String text = "Greetings from Watson Developer Cloudl";

    // translate
    TranslationResult translationResult = translator.translate(text, Language.ENGLISH, Language.SPANISH).execute();
    String translation = translationResult.getTranslations().get(0).getTranslation();

    // synthesize
    InputStream in = synthesizer.synthesize(translation, Voice.ES_LAURA, AudioFormat.WAV).execute();
    writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));
  }

  /**
   * Write the input stream to a file.
   */
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
