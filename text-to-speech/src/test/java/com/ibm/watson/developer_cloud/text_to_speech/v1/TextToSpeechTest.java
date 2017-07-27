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


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.TestUtils;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;

/**
 * The Class TextToSpeechTest.
 */
@FixMethodOrder(MethodSorters.JVM)
public class TextToSpeechTest extends WatsonServiceUnitTest {

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final String GET_VOICES_PATH = "/v1/voices";
  private static final String SYNTHESIZE_PATH = "/v1/synthesize";

  /**
   * Write input stream to output stream.
   *
   * @param inputStream the input stream
   * @param outputStream the output stream
   */
  private static void writeInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) {
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
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test get voices.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoices() throws InterruptedException {
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

    final List<Voice> voices = ImmutableList.of(voice, voice1);
    final Map<String, ?> response = ImmutableMap.of("voices", voices);

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(response)));

    final List<Voice> result = service.getVoices().execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(GET_VOICES_PATH, request.getPath());
    assertNotNull(result);
    assertFalse(result.isEmpty());
    assertEquals(voices, result);
  }

  /**
   * Test get voice.
   */
  @Test
  public void testGetVoice() {
    final Voice voice = new Voice();
    voice.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestMaleVoice");
    voice.setName("en-US_TestMaleVoice");
    voice.setGender("male");
    voice.setLanguage("en-US");
    voice.setDescription("TestMale");

    server.enqueue(
        new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON).setBody(GSON.toJson(voice)));

    Voice result = service.getVoice(voice.getName()).execute();
    assertNotNull(result);
    assertEquals(result, voice);

    try {
      TestUtils.assertNoExceptionsOnGetters(result);
    } catch (final Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Test synthesize.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @SuppressWarnings("resource")
  @Test
  public void testSynthesize() throws IOException, InterruptedException {
    final File audio = new File("src/test/resources/text_to_speech/sample1.wav");
    final Buffer buffer = new Buffer().write(Files.toByteArray(audio));

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.AUDIO_WAV).setBody(buffer));

    final InputStream in =
        service.synthesize(text, Voice.EN_LISA, new AudioFormat(HttpMediaType.AUDIO_PCM + "; rate=16000")).execute();
    final RecordedRequest request = server.takeRequest();
    final HttpUrl requestUrl = HttpUrl.parse("http://www.example.com" + request.getPath());

    assertEquals(request.getBody().readUtf8(), "{\"text\":\"" + text + "\"}");
    assertEquals(SYNTHESIZE_PATH, requestUrl.encodedPath());
    assertEquals(Voice.EN_LISA.getName(), requestUrl.queryParameter("voice"));
    assertEquals(HttpMediaType.AUDIO_PCM + "; rate=16000", requestUrl.queryParameter("accept"));
    assertNotNull(in);

    writeInputStreamToOutputStream(in, new FileOutputStream("build/output.wav"));
  }


  /**
   * Test synthesize for WebM.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @SuppressWarnings("resource")
  @Test
  public void testSynthesizeWebM() throws IOException, InterruptedException {
    final File audio = new File("src/test/resources/text_to_speech/sample1.webm");
    final Buffer buffer = new Buffer().write(Files.toByteArray(audio));

    server.enqueue(new MockResponse().addHeader(CONTENT_TYPE, HttpMediaType.AUDIO_WEBM).setBody(buffer));

    final InputStream in =
        service.synthesize(text, Voice.EN_LISA, AudioFormat.WEBM).execute();
    final RecordedRequest request = server.takeRequest();
    final HttpUrl requestUrl = HttpUrl.parse("http://www.example.com" + request.getPath());

    assertEquals(request.getBody().readUtf8(), "{\"text\":\"" + text + "\"}");
    assertEquals(SYNTHESIZE_PATH, requestUrl.encodedPath());
    assertEquals(Voice.EN_LISA.getName(), requestUrl.queryParameter("voice"));
    assertEquals(HttpMediaType.AUDIO_WEBM, requestUrl.queryParameter("accept"));
    assertNotNull(in);

    writeInputStreamToOutputStream(in, new FileOutputStream("build/output.webm"));
  }

  /**
   * Test with voice as AudioFormat.WAV.
   */
  // @Test
  public void testWithVoiceAsWav() {
    final InputStream is = service.synthesize(text, Voice.EN_LISA, AudioFormat.WAV).execute();
    assertNotNull(is);

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
    assertNotNull(stream);
    stream = WaveUtils.reWriteWaveHeader(stream);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(stream, tempFile);
    assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }

  /**
   * Tests the static method Voice.getByName.
   *
   * @throws IllegalAccessException the illegal access exception
   */
  @Test
  public void testVoiceClass() throws IllegalAccessException {
    Field[] fields = Voice.class.getDeclaredFields();
    int count = 0;

    for (Field field : fields) {
      boolean isVoice = field.getType().isAssignableFrom(Voice.class);
      boolean isDeprecated = field.getAnnotation(Deprecated.class) != null;

      if (Modifier.isStatic(field.getModifiers()) && isVoice && !isDeprecated) {
        Voice voice = (Voice) field.get(null);

        assertEquals(voice, Voice.getByName(voice.getName()));
        count++;
      }
    }

    assertTrue(count > 0);
    assertEquals(Voice.ALL.size(), count);
    assertNull(Voice.getByName("not existing"));
    assertNull(Voice.getByName(null));
    assertEquals(Voice.EN_ALLISON, Voice.getByName("en-US_AllisonVoice"));
  }

}
