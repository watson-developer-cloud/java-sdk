package com.ibm.watson.developer_cloud.text_to_speech.v1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

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
    Files.copy(in, Paths.get("output.wav"), StandardCopyOption.REPLACE_EXISTING);

  }
}
