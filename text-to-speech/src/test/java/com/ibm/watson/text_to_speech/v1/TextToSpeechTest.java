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
package com.ibm.watson.text_to_speech.v1;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.watson.common.TestUtils;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * The Class TextToSpeechTest.
 */
@FixMethodOrder(MethodSorters.JVM)
public class TextToSpeechTest extends WatsonServiceUnitTest {

  private static final Gson GSON = GsonSingleton.getGsonWithoutPrettyPrinting();
  private static final String GET_VOICES_PATH = "/v1/voices";
  private static final String SYNTHESIZE_PATH = "/v1/synthesize";

  private Voice getVoiceResponse;
  private Voices listVoicesResponse;

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
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new TextToSpeech();
    service.setUsernameAndPassword("", "");
    service.setEndPoint(getMockWebServerUrl());

    getVoiceResponse = loadFixture("src/test/resources/text_to_speech/get_voice_response.json", Voice.class);
    listVoicesResponse = loadFixture("src/test/resources/text_to_speech/list_voices_response.json", Voices.class);
  }

  /**
   * Test list voices.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListVoices() throws InterruptedException {
    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(listVoicesResponse)));

    final Voices result = service.listVoices().execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(GET_VOICES_PATH, request.getPath());
    assertNotNull(result);
    assertFalse(result.getVoices().isEmpty());
    assertEquals(listVoicesResponse.getVoices(), result.getVoices());
  }

  /**
   * Test get voice.
   */
  @Test
  public void testGetVoice() {
    server.enqueue(new MockResponse()
        .addHeader(CONTENT_TYPE, HttpMediaType.APPLICATION_JSON)
        .setBody(GSON.toJson(getVoiceResponse)));

    GetVoiceOptions getOptions = new GetVoiceOptions.Builder()
        .voice("en-US_TestMaleVoice")
        .build();
    Voice result = service.getVoice(getOptions).execute();
    assertNotNull(result);
    assertEquals(result, getVoiceResponse);

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

    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(text)
        .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
        .accept(HttpMediaType.AUDIO_PCM + "; rate=16000")
        .build();
    final InputStream in = service.synthesize(synthesizeOptions).execute();
    final RecordedRequest request = server.takeRequest();
    final HttpUrl requestUrl = HttpUrl.parse("http://www.example.com" + request.getPath());

    assertEquals(request.getBody().readUtf8(), "{\"text\":\"" + text + "\"}");
    assertEquals(SYNTHESIZE_PATH, requestUrl.encodedPath());
    assertEquals(SynthesizeOptions.Voice.EN_US_LISAVOICE, requestUrl.queryParameter("voice"));
    assertEquals(HttpMediaType.AUDIO_PCM + "; rate=16000", request.getHeader("Accept"));
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

    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(text)
        .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_WEBM)
        .build();
    final InputStream in = service.synthesize(synthesizeOptions).execute();
    final RecordedRequest request = server.takeRequest();
    final HttpUrl requestUrl = HttpUrl.parse("http://www.example.com" + request.getPath());

    assertEquals(request.getBody().readUtf8(), "{\"text\":\"" + text + "\"}");
    assertEquals(SYNTHESIZE_PATH, requestUrl.encodedPath());
    assertEquals(SynthesizeOptions.Voice.EN_US_LISAVOICE, requestUrl.queryParameter("voice"));
    assertEquals(HttpMediaType.AUDIO_WEBM, request.getHeader("Accept"));
    assertNotNull(in);

    writeInputStreamToOutputStream(in, new FileOutputStream("build/output.webm"));
  }

  /**
   * Test with voice as AudioFormat.WAV.
   */
  // @Test
  public void testWithVoiceAsWav() {
    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(text)
        .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_WAV)
        .build();
    final InputStream is = service.synthesize(synthesizeOptions).execute();
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

  @Test
  public void testDeleteUserDataOptionsBuilder() {
    String customerId = "java_sdk_test_id";

    DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
        .customerId(customerId)
        .build();

    assertEquals(deleteOptions.customerId(), customerId);
  }
}
