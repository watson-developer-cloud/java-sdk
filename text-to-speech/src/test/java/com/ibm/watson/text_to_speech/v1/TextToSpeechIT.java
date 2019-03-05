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

import com.ibm.cloud.sdk.core.test.WatsonServiceTest;
import com.ibm.cloud.sdk.core.test.util.RetryRunner;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.MarkTiming;
import com.ibm.watson.text_to_speech.v1.model.Marks;
import com.ibm.watson.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Timings;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.model.WordTiming;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.text_to_speech.v1.websocket.BaseSynthesizeCallback;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Text to Speech integration tests.
 */
@RunWith(RetryRunner.class)
public class TextToSpeechIT extends WatsonServiceTest {

  private CountDownLatch lock = new CountDownLatch(1);
  private TextToSpeech service;
  private String voiceName;
  private ByteArrayOutputStream byteArrayOutputStream;
  private String returnedContentType;
  private List<Timings> returnedTimings;
  private List<Marks> returnedMarks;

  /*
   * (non-Javadoc)
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

    byteArrayOutputStream = new ByteArrayOutputStream();
    returnedTimings = new ArrayList<>();
    returnedMarks = new ArrayList<>();
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

  @Test
  public void testDeleteUserData() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions = new DeleteUserDataOptions.Builder()
          .customerId(customerId)
          .build();
      service.deleteUserData(deleteOptions);
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  @Test
  public void testSynthesizeUsingWebSocket() throws InterruptedException, IOException {
    String basicText = "One taught me love. One taught me patience, and one taught me pain. Now, I'm so amazing. Say "
        + "I've loved and I've lost, but that's not what I see. So, look what I got. Look what you taught me. And for "
        + "that, I say... thank u, next.";

    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(basicText)
        .voice(SynthesizeOptions.Voice.EN_US_ALLISONVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_OGG_CODECS_OPUS)
        .timings(Collections.singletonList("words"))
        .build();

    service.synthesizeUsingWebSocket(synthesizeOptions, new BaseSynthesizeCallback() {
      @Override
      public void onContentType(String contentType) {
        returnedContentType = contentType;
      }

      @Override
      public void onAudioStream(byte[] bytes) {
        // build byte array of synthesized text
        try {
          byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onTimings(Timings timings) {
        returnedTimings.add(timings);
      }
    });

    // wait for synthesis to complete
    lock.await(5, TimeUnit.SECONDS);

    String filename = "synthesize_websocket_test.ogg";
    OutputStream fileOutputStream = new FileOutputStream(filename);
    byteArrayOutputStream.writeTo(fileOutputStream);
    File createdFile = new File(filename);

    assertTrue(createdFile.exists());
    assertEquals(SynthesizeOptions.Accept.AUDIO_OGG_CODECS_OPUS, returnedContentType);
    for (Timings t : returnedTimings) {
      List<WordTiming> wordTimings = t.getWords();
      for (WordTiming wordTiming : wordTimings) {
        assertTrue(basicText.contains(wordTiming.getWord()));
      }
    }

    // clean up
    byteArrayOutputStream.close();
    fileOutputStream.close();
    if (createdFile.delete()) {
      System.out.println("File deleted successfully!");
    } else {
      System.out.println("File could not be deleted");
    }
  }

  @Test
  public void testSynthesizeUsingWebSocketWithSsml() throws InterruptedException {
    List<String> ssmlMarks = new ArrayList<>();
    ssmlMarks.add("sean");
    ssmlMarks.add("ricky");
    String ssmlText = String.format("Thought I'd end up with <mark name=\"%s\" />Sean, <express-as type=\"Apology\"> "
        + "but he wasn't a match. </express-as> Wrote some songs about <mark name=\"%s\" />Ricky, now I listen and "
        + "laugh", ssmlMarks.get(0), ssmlMarks.get(1));

    SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
        .text(ssmlText)
        .voice(SynthesizeOptions.Voice.EN_US_ALLISONVOICE)
        .accept(SynthesizeOptions.Accept.AUDIO_OGG_CODECS_OPUS)
        .build();

    service.synthesizeUsingWebSocket(synthesizeOptions, new BaseSynthesizeCallback() {
      @Override
      public void onMarks(Marks marks) {
        returnedMarks.add(marks);
      }
    });

    // wait for synthesis to complete
    lock.await(5, TimeUnit.SECONDS);

    for (Marks m : returnedMarks) {
      List<MarkTiming> markList = m.getMarks();
      for (MarkTiming markTiming : markList) {
        assertTrue(ssmlMarks.contains(markTiming.getMark()));
      }
    }
  }
}
