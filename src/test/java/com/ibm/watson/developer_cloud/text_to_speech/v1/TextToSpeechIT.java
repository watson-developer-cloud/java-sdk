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
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

/**
 * The Class TextToSpeechIntegrationTest.
 */
public class TextToSpeechIT extends WatsonServiceTest {

  private TextToSpeech service;

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
    service.setUsernameAndPassword(prop.getProperty("text_to_speech.username"),
        prop.getProperty("text_to_speech.password"));
    service.setEndPoint(prop.getProperty("text_to_speech.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }



  /**
   * Test get voices.
   */
  @Test
  public void testGetVoices() {
    List<Voice> voices = service.getVoices();
    Assert.assertNotNull(voices);
    Assert.assertTrue(!voices.isEmpty());
  }

  /**
   * Synthesize text and write it to a temporary file
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSynthesize() throws IOException {
    String text = "This is an integration test";
    InputStream result = service.synthesize(text, Voice.EN_LISA, HttpMediaType.AUDIO_WAV);
    writeInputStreamToFile(result, File.createTempFile("tts-audio", "wav"));
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
    InputStream result = service.synthesize(text, Voice.EN_LISA, HttpMediaType.AUDIO_WAV);
    Assert.assertNotNull(result);
    result = WaveUtils.reWriteWaveHeader(result);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(result, tempFile);
    Assert.assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }
}
