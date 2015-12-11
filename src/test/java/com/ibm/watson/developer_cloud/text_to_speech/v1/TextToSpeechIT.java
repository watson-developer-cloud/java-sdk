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

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

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
  }

  /**
   * Synthesize.
   * 
   * @param text the text
   * @param audio the audio
   */
  private void synthesize(String text, File audio) {
    final InputStream is = service.synthesize(text, Voice.EN_LISA, HttpMediaType.AUDIO_WAV);
    Assert.assertNotNull(is);
    OutputStream outStream = null;
    try {
      outStream = new FileOutputStream(audio);

      final byte[] buffer = new byte[8 * 1024];
      int bytesRead;
      while ((bytesRead = is.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
      }
    } catch (final Exception e) {
      fail();
    } finally {
      IOUtils.closeQuietly(is);
      IOUtils.closeQuietly(outStream);
    }
  }

  /**
   * Test get voices.
   */
  @Test
  public void testGetVoices() {
    final List<Voice> voices = service.getVoices();
    Assert.assertNotNull(voices);
    Assert.assertTrue(!voices.isEmpty());
  }

  /**
   * Test synthesize.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSynthesize() throws IOException {
    final String text = "This is an integration test";
    final File audio = File.createTempFile("tts-audio", "wav");

    synthesize(text, audio);
  }
}
