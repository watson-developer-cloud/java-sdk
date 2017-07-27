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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Phoneme;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.util.RetryRunner;

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
   * Test get voices.
   */
  @Test
  public void testGetVoices() {
    List<Voice> voices = service.getVoices().execute();
    assertNotNull(voices);
    assertTrue(!voices.isEmpty());
    assertNotNull(voices.get(0).getDescription());
    assertNotNull(voices.get(0).getGender());
    assertNotNull(voices.get(0).getLanguage());
    assertNotNull(voices.get(0).getName());
    assertNotNull(voices.get(0).getUrl());
  }

  /**
   * Test get voice.
   */
  @Test
  public void testGetVoice() {
    Voice voice = service.getVoice(voiceName).execute();
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
    InputStream result = service.synthesize(text, Voice.EN_LISA, AudioFormat.WAV).execute();
    writeInputStreamToFile(result, File.createTempFile("tts-audio", "wav"));
  }

  /**
   * Test word pronunciation.
   */
  @Test
  public void testGetWordPronunciation() {
    String word = "Congressman";
    Pronunciation pronunciation = service.getPronunciation(word, Voice.EN_MICHAEL, Phoneme.SPR).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    pronunciation = service.getPronunciation(word, null, Phoneme.SPR).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    pronunciation = service.getPronunciation(word, Voice.EN_MICHAEL, null).execute();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    pronunciation = service.getPronunciation(word, Voice.EN_MICHAEL, Phoneme.IPA).execute();
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
    InputStream result = service.synthesize(text, Voice.EN_LISA, AudioFormat.WAV).execute();
    assertNotNull(result);
    result = WaveUtils.reWriteWaveHeader(result);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(result, tempFile);
    assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }
}
