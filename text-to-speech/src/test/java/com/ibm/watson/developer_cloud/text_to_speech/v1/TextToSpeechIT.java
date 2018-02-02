/**
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

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voices;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.util.RetryRunner;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Text to Speech integration tests.
 */
@RunWith(RetryRunner.class)
public class TextToSpeechIT extends WatsonServiceTest {

  private TextToSpeech service;
  private String voiceName;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("text_to_speech.username");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new TextToSpeech();
    service.setUsernameAndPassword(username, getProperty("text_to_speech.password"));
    service.setEndPoint(getProperty("text_to_speech.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    voiceName = getProperty("text_to_speech.voice_name");
  }


  /**
   * Test list voices.
   */
  @Test
  public void testListVoices() {
    Voices voices = service.listVoices().execute();
    assertNotNull(voices);
    assertTrue(!voices.getVoices().isEmpty());
    assertNotNull(voices.getVoices().get(0).getDescription());
    assertNotNull(voices.getVoices().get(0).getGender());
    assertNotNull(voices.getVoices().get(0).getLanguage());
    assertNotNull(voices.getVoices().get(0).getName());
    assertNotNull(voices.getVoices().get(0).getUrl());
  }

  /**
   * Test get voice.
   */
  @Test
  public void testGetVoice() {
    GetVoiceOptions getOptions = new GetVoiceOptions.Builder()
        .voice(voiceName)
        .build();
    Voice voice = service.getVoice(getOptions).execute();
    assertNotNull(voice);
    assertNotNull(voice.getDescription());
    assertNotNull(voice.getGender());
    assertNotNull(voice.getLanguage());
    assertNotNull(voice.getName());
    assertNotNull(voice.getUrl());
  }

  /**
   * Synthesize text and write it to a temporary file.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSynthesize() throws IOException {
    String text = "This is an integration test; 1,2 !, @, #, $, %, ^, 20.";
    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(text)
        .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_WAV)
        .build();
    InputStream result = service.synthesize(synthesizeOptions).execute();
    writeInputStreamToFile(result, File.createTempFile("tts-audio", "wav"));
  }

  /**
   * Test word pronunciation.
   */
  @Test
  public void testGetWordPronunciation() {
    String word = "Congressman";
    GetPronunciationOptions getOptions1 = new GetPronunciationOptions.Builder()
        .text(word)
        .voice(GetPronunciationOptions.Voice.EN_US_MICHAELVOICE)
        .format(GetPronunciationOptions.Format.IBM)
        .build();
    Pronunciation pronunciation = service.getPronunciation(getOptions1).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    GetPronunciationOptions getOptions2 = new GetPronunciationOptions.Builder()
        .text(word)
        .format(GetPronunciationOptions.Format.IBM)
        .build();
    pronunciation = service.getPronunciation(getOptions2).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    GetPronunciationOptions getOptions3 = new GetPronunciationOptions.Builder()
        .text(word)
        .voice(GetPronunciationOptions.Voice.EN_US_MICHAELVOICE)
        .build();
    pronunciation = service.getPronunciation(getOptions3).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    GetPronunciationOptions getOptions4 = new GetPronunciationOptions.Builder()
        .text(word)
        .voice(GetPronunciationOptions.Voice.EN_US_MICHAELVOICE)
        .format(GetPronunciationOptions.Format.IPA)
        .build();
    pronunciation = service.getPronunciation(getOptions4).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

  }

  /**
   * Test the fix wave header not having the size due to be streamed.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws UnsupportedAudioFileException the unsupported audio file exception
   */
  @Test
  public void testSynthesizeAndFixHeader() throws IOException, UnsupportedAudioFileException {
    String text = "one two three four five";
    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(text)
        .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_WAV)
        .build();
    InputStream result = service.synthesize(synthesizeOptions).execute();
    assertNotNull(result);
    result = WaveUtils.reWriteWaveHeader(result);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(result, tempFile);
    assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }
}
