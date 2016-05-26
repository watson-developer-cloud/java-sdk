/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.text_to_speech.v1;

/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Phoneme;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

/**
 * Text to Speech integration tests.
 */
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
    service = new TextToSpeech();
    service.setUsernameAndPassword(
        getExistingProperty("text_to_speech.username"),
        getExistingProperty("text_to_speech.password"));
    service.setEndPoint(getExistingProperty("text_to_speech.url"));
    service.setDefaultHeaders(getDefaultHeaders());
    voiceName = getExistingProperty("text_to_speech.voice_name");
  }



  /**
   * Test get voices.
   */
  @Test
  public void testGetVoices() {
    List<Voice> voices = service.getVoices().execute();
    Assert.assertNotNull(voices);
    Assert.assertTrue(!voices.isEmpty());
    Assert.assertNotNull(voices.get(0).getDescription());
    Assert.assertNotNull(voices.get(0).getGender());
    Assert.assertNotNull(voices.get(0).getLanguage());
    Assert.assertNotNull(voices.get(0).getName());
    Assert.assertNotNull(voices.get(0).getUrl());
  }

  /**
   * Test get voice
   */
  @Test
  public void testGetVoice() {
    Voice voice = service.getVoice(voiceName).execute();
    Assert.assertNotNull(voice);
    Assert.assertNotNull(voice.getDescription());
    Assert.assertNotNull(voice.getGender());
    Assert.assertNotNull(voice.getLanguage());
    Assert.assertNotNull(voice.getName());
    Assert.assertNotNull(voice.getUrl());
  }

  /**
   * Synthesize text and write it to a temporary file.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSynthesize() throws IOException {
    String text = "This is an integration test";
    InputStream result = service.synthesize(text, Voice.EN_LISA, AudioFormat.WAV).execute();
    writeInputStreamToFile(result, File.createTempFile("tts-audio", "wav"));
  }

  /**
   *  Test word pronunciation
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testGetWordPronunciation(){
    String word = "Congressman";
    Pronunciation pronunciation = service.getPronunciation(word, Voice.EN_MICHAEL,Phoneme.SPR).execute();
    Assert.assertNotNull(pronunciation);
    Assert.assertNotNull(pronunciation.getPronunciation());
    
    pronunciation = service.getPronunciation(word, null,Phoneme.SPR).execute();
    Assert.assertNotNull(pronunciation);
    Assert.assertNotNull(pronunciation.getPronunciation());
    
    pronunciation = service.getPronunciation(word, Voice.EN_MICHAEL, null).execute();
    Assert.assertNotNull(pronunciation);
    Assert.assertNotNull(pronunciation.getPronunciation());
    
    pronunciation = service.getPronunciation(word, Voice.EN_MICHAEL,Phoneme.IPA).execute();
    Assert.assertNotNull(pronunciation);
    Assert.assertNotNull(pronunciation.getPronunciation());
    
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
    Assert.assertNotNull(result);
    result = WaveUtils.reWriteWaveHeader(result);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(result, tempFile);
    Assert.assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }
}
