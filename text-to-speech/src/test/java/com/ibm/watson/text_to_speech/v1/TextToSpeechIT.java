/*
 * (C) Copyright IBM Corp. 2019, 2022.
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.text_to_speech.v1.model.AddCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.CustomModel;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteUserDataOptions;
import com.ibm.watson.text_to_speech.v1.model.GetCustomPromptOptions;
import com.ibm.watson.text_to_speech.v1.model.GetPronunciationOptions;
import com.ibm.watson.text_to_speech.v1.model.GetSpeakerModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.ListCustomPromptsOptions;
import com.ibm.watson.text_to_speech.v1.model.MarkTiming;
import com.ibm.watson.text_to_speech.v1.model.Marks;
import com.ibm.watson.text_to_speech.v1.model.Prompt;
import com.ibm.watson.text_to_speech.v1.model.PromptMetadata;
import com.ibm.watson.text_to_speech.v1.model.Prompts;
import com.ibm.watson.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.text_to_speech.v1.model.SpeakerCustomModels;
import com.ibm.watson.text_to_speech.v1.model.SpeakerModel;
import com.ibm.watson.text_to_speech.v1.model.Speakers;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Timings;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.Voices;
import com.ibm.watson.text_to_speech.v1.model.WordTiming;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.text_to_speech.v1.websocket.BaseSynthesizeCallback;
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
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.annotations.Ignore;

/** Text to Speech integration tests. */
@RunWith(RetryRunner.class)
public class TextToSpeechIT extends WatsonServiceTest {

  private CountDownLatch lock = new CountDownLatch(1);
  private TextToSpeech service;
  private String voiceName;
  private ByteArrayOutputStream byteArrayOutputStream;
  private String returnedContentType;
  private List<Timings> returnedTimings;
  private List<Marks> returnedMarks;
  private String customizationId;
  private String speakerId;
  private static final String RESOURCE = "src/test/resources/text_to_speech/";

  /**
   * Sets up the tests.
   *
   * @throws Exception the exception
   */
  /*
   * (non-Javadoc)
   * @see com.ibm.watson.common.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String apiKey = System.getenv("TEXT_TO_SPEECH_APIKEY");
    String serviceUrl = System.getenv("TEXT_TO_SPEECH_URL");

    if (apiKey == null) {
      apiKey = getProperty("text_to_speech.apikey");
      serviceUrl = getProperty("text_to_speech.url");
    }

    assertNotNull("TEXT_TO_SPEECH_APIKEY is not defined and config.properties doesn't have valid credentials.", apiKey);

    Authenticator authenticator = new IamAuthenticator(apiKey);
    service = new TextToSpeech(authenticator);
    service.setServiceUrl(serviceUrl);
    service.setDefaultHeaders(getDefaultHeaders());
    voiceName = "en-US_MichaelVoice";

    byteArrayOutputStream = new ByteArrayOutputStream();
    returnedTimings = new ArrayList<>();
    returnedMarks = new ArrayList<>();
  }

  /** Test list voices. */
  @Test
  public void testListVoices() {
    Voices voices = service.listVoices().execute().getResult();
    assertNotNull(voices);
    assertTrue(!voices.getVoices().isEmpty());
    assertNotNull(voices.getVoices().get(0).getDescription());
    assertNotNull(voices.getVoices().get(0).getGender());
    assertNotNull(voices.getVoices().get(0).getLanguage());
    assertNotNull(voices.getVoices().get(0).getName());
    assertNotNull(voices.getVoices().get(0).getUrl());
  }

  /** Test get voice. */
  @Test
  public void testGetVoice() {
    GetVoiceOptions getOptions = new GetVoiceOptions.Builder().voice(voiceName).build();
    Voice voice = service.getVoice(getOptions).execute().getResult();
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
    SynthesizeOptions synthesizeOptions =
        new SynthesizeOptions.Builder()
            .text(text)
            .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
            .accept(HttpMediaType.AUDIO_WAV)
            .build();
    InputStream result = service.synthesize(synthesizeOptions).execute().getResult();
    writeInputStreamToFile(result, File.createTempFile("tts-audio", "wav"));
  }

  /** Test word pronunciation. */
  @Test
  public void testGetWordPronunciation() {
    String word = "Congressman";
    GetPronunciationOptions getOptions1 =
        new GetPronunciationOptions.Builder()
            .text(word)
            .voice(GetPronunciationOptions.Voice.EN_US_MICHAELVOICE)
            .format(GetPronunciationOptions.Format.IBM)
            .build();
    Pronunciation pronunciation = service.getPronunciation(getOptions1).execute().getResult();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    GetPronunciationOptions getOptions2 =
        new GetPronunciationOptions.Builder()
            .text(word)
            .format(GetPronunciationOptions.Format.IBM)
            .build();
    pronunciation = service.getPronunciation(getOptions2).execute().getResult();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    GetPronunciationOptions getOptions3 =
        new GetPronunciationOptions.Builder()
            .text(word)
            .voice(GetPronunciationOptions.Voice.EN_US_MICHAELVOICE)
            .build();
    pronunciation = service.getPronunciation(getOptions3).execute().getResult();
    assertNotNull(pronunciation);
    assertNotNull(pronunciation.getPronunciation());

    GetPronunciationOptions getOptions4 =
        new GetPronunciationOptions.Builder()
            .text(word)
            .voice(GetPronunciationOptions.Voice.EN_US_MICHAELVOICE)
            .format(GetPronunciationOptions.Format.IPA)
            .build();
    pronunciation = service.getPronunciation(getOptions4).execute().getResult();
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
    SynthesizeOptions synthesizeOptions =
        new SynthesizeOptions.Builder()
            .text(text)
            .voice(SynthesizeOptions.Voice.EN_US_LISAVOICE)
            .accept(HttpMediaType.AUDIO_WAV)
            .build();
    InputStream result = service.synthesize(synthesizeOptions).execute().getResult();
    assertNotNull(result);
    result = WaveUtils.reWriteWaveHeader(result);
    File tempFile = File.createTempFile("output", ".wav");
    writeInputStreamToFile(result, tempFile);
    assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  }

  /** Test delete user data. */
  @Test
  public void testDeleteUserData() {
    String customerId = "java_sdk_test_id";

    try {
      DeleteUserDataOptions deleteOptions =
          new DeleteUserDataOptions.Builder().customerId(customerId).build();
      service.deleteUserData(deleteOptions);
    } catch (Exception ex) {
      fail(ex.getMessage());
    }
  }

  /**
   * Test synthesize using web socket.
   *
   * @throws InterruptedException the interrupted exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSynthesizeUsingWebSocket() throws InterruptedException, IOException {
    String basicText =
        "One taught me love. One taught me patience, and one taught me pain. Now, I'm so amazing. Say "
            + "I've loved and I've lost, but that's not what I see. So, look what I got."
            + " Look what you taught me. And for that, I say... thank u, next.";

    SynthesizeOptions synthesizeOptions =
        new SynthesizeOptions.Builder()
            .text(basicText)
            .voice(SynthesizeOptions.Voice.EN_US_ALLISONVOICE)
            .accept(HttpMediaType.AUDIO_OGG)
            .timings(Collections.singletonList("words"))
            .build();

    service.synthesizeUsingWebSocket(
        synthesizeOptions,
        new BaseSynthesizeCallback() {
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
    assertTrue(returnedContentType.contains("audio/ogg"));
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

  /**
   * Test synthesize using web socket with ssml.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSynthesizeUsingWebSocketWithSsml() throws InterruptedException {
    List<String> ssmlMarks = new ArrayList<>();
    ssmlMarks.add("sean");
    ssmlMarks.add("ricky");
    String ssmlText =
        String.format(
            "Thought I'd end up with <mark name=\"%s\" />Sean, <express-as type=\"Apology\"> "
                + "but he wasn't a match. </express-as> Wrote some songs "
                + "about <mark name=\"%s\" />Ricky, now I listen and "
                + "laugh",
            ssmlMarks.get(0), ssmlMarks.get(1));

    SynthesizeOptions synthesizeOptions =
        new SynthesizeOptions.Builder()
            .text(ssmlText)
            .voice(SynthesizeOptions.Voice.EN_US_ALLISONVOICE)
            .accept(HttpMediaType.AUDIO_OGG)
            .build();

    service.synthesizeUsingWebSocket(
        synthesizeOptions,
        new BaseSynthesizeCallback() {
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

  /** Test listCustomPrompts. */
  @Test
  public void testListCustomPrompts() {
    CreateCustomModelOptions createCustomModelOptions =
        new CreateCustomModelOptions.Builder()
            .description("testdescription")
            .name("testname")
            .language(CreateCustomModelOptions.Language.EN_US)
            .build();
    CustomModel customModel =
        service.createCustomModel(createCustomModelOptions).execute().getResult();

    customizationId = customModel.getCustomizationId();
    ListCustomPromptsOptions listCustomPromptsOptions =
        new ListCustomPromptsOptions.Builder().customizationId(customizationId).build();
    Prompts prompts = service.listCustomPrompts(listCustomPromptsOptions).execute().getResult();

    assertNotNull(prompts.getPrompts());

    DeleteCustomModelOptions deleteCustomModelOptions =
        new DeleteCustomModelOptions.Builder().customizationId(customizationId).build();
    service.deleteCustomModel(deleteCustomModelOptions).execute().getResult();
  }

  /** Test addCustomPrompts. */
  @Test
  public void testAddCustomPrompts() {
    try {
      CreateCustomModelOptions createCustomModelOptions =
          new CreateCustomModelOptions.Builder()
              .description("testdescription")
              .name("testname")
              .language(CreateCustomModelOptions.Language.EN_US)
              .build();
      CustomModel customModel =
          service.createCustomModel(createCustomModelOptions).execute().getResult();
      customizationId = customModel.getCustomizationId();

      PromptMetadata promptMetadata = new PromptMetadata.Builder().promptText("promptText").build();
      File file = new File(RESOURCE + "numbers.wav");
      AddCustomPromptOptions addCustomPromptOptions =
          new AddCustomPromptOptions.Builder()
              .customizationId(customizationId)
              .promptId("testId")
              .metadata(promptMetadata)
              .file(file)
              .build();
      Prompt prompt = service.addCustomPrompt(addCustomPromptOptions).execute().getResult();

      assertNotNull(prompt.getStatus());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteCustomModelOptions deleteCustomModelOptions =
          new DeleteCustomModelOptions.Builder().customizationId(customizationId).build();
      service.deleteCustomModel(deleteCustomModelOptions).execute().getResult();
    }
  }

  /** Test getCustomPrompts. */
  @Test
  public void testGetCustomPrompts() {
    try {
      CreateCustomModelOptions createCustomModelOptions =
          new CreateCustomModelOptions.Builder()
              .description("testdescription")
              .name("testname")
              .language(CreateCustomModelOptions.Language.EN_US)
              .build();
      CustomModel customModel =
          service.createCustomModel(createCustomModelOptions).execute().getResult();
      customizationId = customModel.getCustomizationId();

      PromptMetadata promptMetadata = new PromptMetadata.Builder().promptText("promptText").build();
      File file = new File(RESOURCE + "numbers.wav");
      AddCustomPromptOptions addCustomPromptOptions =
          new AddCustomPromptOptions.Builder()
              .customizationId(customizationId)
              .promptId("testId")
              .metadata(promptMetadata)
              .file(file)
              .build();
      Prompt prompt = service.addCustomPrompt(addCustomPromptOptions).execute().getResult();

      assertNotNull(prompt.getStatus());

      GetCustomPromptOptions getCustomPromptOptions =
          new GetCustomPromptOptions.Builder()
              .customizationId(customizationId)
              .promptId("testId")
              .build();
      Prompt prompt1 = service.getCustomPrompt(getCustomPromptOptions).execute().getResult();

      assertNotNull(prompt1.getStatus());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteCustomModelOptions deleteCustomModelOptions =
          new DeleteCustomModelOptions.Builder().customizationId(customizationId).build();
      service.deleteCustomModel(deleteCustomModelOptions).execute().getResult();
    }
  }

  /** Test deleteCustomPrompts. */
  @Test
  public void testDeleteCustomPrompts() {
    try {
      CreateCustomModelOptions createCustomModelOptions =
          new CreateCustomModelOptions.Builder()
              .description("testdescription")
              .name("testname")
              .language(CreateCustomModelOptions.Language.EN_US)
              .build();
      CustomModel customModel =
          service.createCustomModel(createCustomModelOptions).execute().getResult();
      customizationId = customModel.getCustomizationId();

      PromptMetadata promptMetadata = new PromptMetadata.Builder().promptText("promptText").build();
      File file = new File(RESOURCE + "numbers.wav");
      AddCustomPromptOptions addCustomPromptOptions =
          new AddCustomPromptOptions.Builder()
              .customizationId(customizationId)
              .promptId("testId")
              .metadata(promptMetadata)
              .file(file)
              .build();
      Prompt prompt = service.addCustomPrompt(addCustomPromptOptions).execute().getResult();

      assertNotNull(prompt.getStatus());

      DeleteCustomPromptOptions deleteCustomPromptOptions =
          new DeleteCustomPromptOptions.Builder()
              .customizationId(customizationId)
              .promptId(prompt.getPromptId())
              .build();
      service.deleteCustomPrompt(deleteCustomPromptOptions).execute().getResult();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteCustomModelOptions deleteCustomModelOptions =
          new DeleteCustomModelOptions.Builder().customizationId(customizationId).build();
      service.deleteCustomModel(deleteCustomModelOptions).execute().getResult();
    }
  }

  /** Test createSpeakerModel. */
  @Test
  public void testCreateSpeakerModel() {
    try {
      CreateSpeakerModelOptions createSpeakerModelOptions =
          new CreateSpeakerModelOptions.Builder()
              .speakerName("speakerName")
              .audio(new File(RESOURCE + "numbers.wav"))
              .build();
      SpeakerModel speakerModel =
          service.createSpeakerModel(createSpeakerModelOptions).execute().getResult();

      speakerId = speakerModel.getSpeakerId();
      assertNotNull(speakerModel.getSpeakerId());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteSpeakerModelOptions deleteSpeakerModelOptions =
          new DeleteSpeakerModelOptions.Builder().speakerId(speakerId).build();
      service.deleteSpeakerModel(deleteSpeakerModelOptions).execute().getResult();
    }
  }

  /** Test listSpeakerModel. */
  @Test
  public void testListSpeakerModel() {
    try {
      CreateSpeakerModelOptions createSpeakerModelOptions =
          new CreateSpeakerModelOptions.Builder()
              .speakerName("speakerName")
              .audio(new File(RESOURCE + "numbers.wav"))
              .build();
      SpeakerModel speakerModel =
          service.createSpeakerModel(createSpeakerModelOptions).execute().getResult();

      speakerId = speakerModel.getSpeakerId();
      assertNotNull(speakerModel.getSpeakerId());

      Speakers speakers = service.listSpeakerModels().execute().getResult();
      assertNotNull(speakers.getSpeakers());
      assertTrue(speakers.getSpeakers().size() > 0);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteSpeakerModelOptions deleteSpeakerModelOptions =
          new DeleteSpeakerModelOptions.Builder().speakerId(speakerId).build();
      service.deleteSpeakerModel(deleteSpeakerModelOptions).execute().getResult();
    }
  }

  /** Test getSpeakerModel. */
  @Test
  public void testGetSpeakerModel() {
    try {
      CreateSpeakerModelOptions createSpeakerModelOptions =
          new CreateSpeakerModelOptions.Builder()
              .speakerName("speakerName")
              .audio(new File(RESOURCE + "numbers.wav"))
              .build();
      SpeakerModel speakerModel =
          service.createSpeakerModel(createSpeakerModelOptions).execute().getResult();

      speakerId = speakerModel.getSpeakerId();
      assertNotNull(speakerModel.getSpeakerId());

      GetSpeakerModelOptions getSpeakerModelOptions =
          new GetSpeakerModelOptions.Builder().speakerId(speakerId).build();
      SpeakerCustomModels speakerCustomModels =
          service.getSpeakerModel(getSpeakerModelOptions).execute().getResult();
      assertNotNull(speakerCustomModels.getCustomizations());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DeleteSpeakerModelOptions deleteSpeakerModelOptions =
          new DeleteSpeakerModelOptions.Builder().speakerId(speakerId).build();
      service.deleteSpeakerModel(deleteSpeakerModelOptions).execute().getResult();
    }
  }
}
