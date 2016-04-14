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

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;

import com.google.common.io.Files;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * The Class TextToSpeechTest.
 */
@FixMethodOrder(MethodSorters.JVM)
public class TextToSpeechTest extends WatsonServiceUnitTest {
  private final static String GET_VOICES_PATH = "/v1/voices";
  private final static String SYNTHESIZE_PATH = "/v1/synthesize";

  /**
   * Write input stream to output stream.
   * 
   * @param inputStream the input stream
   * @param outputStream the output stream
   */
  private static void writeInputStreamToOutputStream(InputStream inputStream,
      OutputStream outputStream) {
    try {
      try {
        final byte[] buffer = new byte[1024];
        int read;

        while ((read = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, read);
        }

        outputStream.flush();
      } catch (final Exception e) {
        e.printStackTrace();
      } finally {
        outputStream.close();
        inputStream.close();
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  /** The service. */
  private TextToSpeech service;

  /** The text. */
  private final String text = "IBM Watson Developer Cloud";

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
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

  }

  /**
   * Test get voices.
   */
  @Test
  public void testGetVoices() {

    final Map<String, Object> response = new HashMap<String, Object>();
    final List<Voice> voices = new ArrayList<Voice>();
    final Voice voice = new Voice();
    voice.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestMaleVoice");
    voice.setName("en-US_TestMaleVoice");
    voice.setGender("male");
    voice.setLanguage("en-US");
    voice.setDescription("TestMale");

    final Voice voice1 = new Voice();
    voice1.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestFemaleVoice");
    voice1.setName("en-US_TestFemaleVoice");
    voice1.setGender("female");
    voice1.setLanguage("en-US");
    voice1.setDescription("TestFemale");

    voices.add(voice);
    voices.add(voice1);

    response.put("voices", voices);

    mockServer.when(request().withPath(GET_VOICES_PATH)).respond(
        response().withHeaders(
            new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)).withBody(
            GsonSingleton.getGsonWithoutPrettyPrinting().toJson(response)));

    final List<Voice> result = service.getVoices().execute();
    Assert.assertNotNull(result);
    Assert.assertFalse(result.isEmpty());
    Assert.assertEquals(result, voices);
  }

  /**
   * Test synthesize.
   */
  @Test
  public void testSynthesize() {
    final File audio = new File("src/test/resources/speech_to_text/sample1.wav");

    try {
      final List<Parameter> parameters = new ArrayList<Parameter>();
      parameters.add(new Parameter("text", text));
      parameters.add(new Parameter("voice", Voice.EN_LISA.getName()));
      parameters.add(new Parameter("accept", HttpMediaType.AUDIO_WAV));

      mockServer.when(request().withQueryStringParameters(parameters).withPath(SYNTHESIZE_PATH))
          .respond(
              response().withHeaders(
                  new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.AUDIO_WAV)).withBody(
                  Files.toByteArray(audio)));

      final InputStream in = service.synthesize(text, Voice.EN_LISA, HttpMediaType.AUDIO_WAV).execute();
      Assert.assertNotNull(in);

      writeInputStreamToOutputStream(in, new FileOutputStream("target/output.wav"));

    } catch (final FileNotFoundException e) {
      Assert.fail(e.getMessage());
    } catch (final IOException e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Test synthesize with empty '' input text string.
   */
  @Test
  public void testSynthesizeEmptyTextParamValue() {
    boolean throwException = false;
    try {
      service.synthesize(null, Voice.EN_ALLISON, "empty input string");
    } catch (final IllegalArgumentException e) {
      throwException = true;
    }
    Assert.assertTrue(throwException);
  }

  /**
   * Test synthesize with a wrong format type.
   */
  @Test
  public void testSynthesizeWithWrongFormat() {
    boolean throwException = false;
    try {
      service.synthesize(text, null, "bad format");
    } catch (final IllegalArgumentException e) {
      throwException = true;
    }
    Assert.assertTrue(throwException);
  }

  /**
   * Test with voice as wav.
   */
  // @Test
  public void testWithVoiceAsWav() {
    final InputStream is = service.synthesize(text, Voice.EN_LISA, HttpMediaType.AUDIO_WAV).execute();
    Assert.assertNotNull(is);

    try {
      writeInputStreamToOutputStream(is, new FileOutputStream("target/output.wav"));
    } catch (final FileNotFoundException e) {
      Assert.fail(e.getMessage());
    }

  }


  /**
   * Test the fix wave header not having the size due to be streamed.
   * 
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws UnsupportedAudioFileException the unsupported audio file exception
   */
  @Test
  public void testSynthesizeAndFixHeader() throws IOException, UnsupportedAudioFileException {
    File audio = new File("src/test/resources/text_to_speech/numbers.wav");
    InputStream stream = new FileInputStream(audio);
    Assert.assertNotNull(stream);
    stream = WaveUtils.reWriteWaveHeader(stream);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(stream, tempFile);
    Assert.assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }

}
