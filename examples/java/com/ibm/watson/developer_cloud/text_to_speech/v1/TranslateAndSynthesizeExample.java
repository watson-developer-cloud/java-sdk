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
   * Write the input stream to a file
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
