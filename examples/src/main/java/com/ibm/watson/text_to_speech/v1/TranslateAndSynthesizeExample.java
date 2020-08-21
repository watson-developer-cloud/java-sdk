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
package com.ibm.watson.text_to_speech.v1;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.language_translator.v2.LanguageTranslator;
import com.ibm.watson.language_translator.v2.model.TranslateOptions;
import com.ibm.watson.language_translator.v2.model.TranslationResult;
import com.ibm.watson.language_translator.v2.util.Language;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** Translate from English to Spanish and synthesize that as a WAV file. */
public class TranslateAndSynthesizeExample {

  public static void main(String[] args) throws IOException {
    Authenticator ltAuthenticator = new IamAuthenticator("<iam_api_key>");
    LanguageTranslator translator = new LanguageTranslator(ltAuthenticator);

    Authenticator ttsAuthenticator = new IamAuthenticator("<iam_api_key>");
    TextToSpeech synthesizer = new TextToSpeech(ttsAuthenticator);

    String text = "Greetings from Watson Developer Cloud";

    // translate
    TranslateOptions translateOptions =
        new TranslateOptions.Builder()
            .addText(text)
            .source(Language.ENGLISH)
            .target(Language.SPANISH)
            .build();
    TranslationResult translationResult =
        translator.translate(translateOptions).execute().getResult();
    String translation = translationResult.getTranslations().get(0).getTranslation();

    // synthesize
    SynthesizeOptions synthesizeOptions =
        new SynthesizeOptions.Builder()
            .text(translation)
            .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
            .accept(SynthesizeOptions.Accept.AUDIO_WAV)
            .build();
    InputStream in = synthesizer.synthesize(synthesizeOptions).execute().getResult();
    writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));
  }

  /** Write the input stream to a file. */
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
