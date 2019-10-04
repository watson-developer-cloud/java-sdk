/*
 * (C) Copyright IBM Corp. 2019.
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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.watson.common.WatsonServiceUnitTest;
import com.ibm.watson.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.CreateVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.text_to_speech.v1.model.ListVoiceModelsOptions;
import com.ibm.watson.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.text_to_speech.v1.model.Translation;
import com.ibm.watson.text_to_speech.v1.model.UpdateVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.text_to_speech.v1.model.VoiceModels;
import com.ibm.watson.text_to_speech.v1.model.Word;
import com.ibm.watson.text_to_speech.v1.model.Words;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Unit tests for the Speech to text customization API.
 */
public class CustomizationsTest extends WatsonServiceUnitTest {

  private static final String VOICES_PATH = "/v1/voices";
  private static final String VOICE_MODELS_PATH = "/v1/customizations";
  private static final String VOICE_MODEL_PATH = VOICE_MODELS_PATH + "/%s";
  private static final String WORDS_PATH = VOICE_MODELS_PATH + "/%s/words";
  private static final String WORD_PATH = WORDS_PATH + "/%s";

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-US";
  private static final String MODEL_DESCRIPTION = "a simple model for testing purposes";

  private static final String WORDS = "words";
  private static final String TRANSLATION = "translation";

  private static final String CUSTOMIZATION_ID = "cafebabe-1234-5678-9abc-def012345678";

  private VoiceModel voiceModel;
  private VoiceModel voiceModelWords;
  private VoiceModels voiceModels;
  private Voice voice;

  /** The service. */
  private TextToSpeech service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    service = new TextToSpeech(new NoAuthAuthenticator());
    service.setServiceUrl(getMockWebServerUrl());

    voiceModel = loadFixture("src/test/resources/text_to_speech/voice_model.json", VoiceModel.class);
    voiceModelWords = loadFixture("src/test/resources/text_to_speech/voice_model_words.json", VoiceModel.class);
    voiceModels = loadFixture("src/test/resources/text_to_speech/list_voice_model.json", VoiceModels.class);
    voice = loadFixture("src/test/resources/text_to_speech/voice.json", Voice.class);
  }

  private static Word instantiateWord() {
    return new Word.Builder()
        .word("hodor")
        .translation("hold the door")
        .build();
  }

  private static List<Word> instantiateWords() {
    return ImmutableList.of(instantiateWord());
  }

  /**
   * Test get voice with custom voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceCustomization() throws InterruptedException {
    server.enqueue(jsonResponse(voice));

    GetVoiceOptions getOptions = new GetVoiceOptions.Builder()
        .voice("en-US_TestMaleVoice")
        .customizationId("cafebabe-1234-5678-9abc-def012345678")
        .build();
    final Voice result = service.getVoice(getOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICES_PATH + "/en-US_TestMaleVoice?customization_id=" + CUSTOMIZATION_ID,
        request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(voice, result);
  }

  /**
   * Test list voice models for null language.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListVoiceModelsNull() throws InterruptedException {
    server.enqueue(jsonResponse(voiceModels));

    final VoiceModels result = service.listVoiceModels().execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("GET", request.getMethod());
    assertFalse(voiceModels.getCustomizations().isEmpty());
    assertEquals(voiceModels, result);
  }

  /**
   * Test list voice models for a language.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListVoiceModelsLanguage() throws InterruptedException {
    server.enqueue(jsonResponse(voiceModels));

    ListVoiceModelsOptions listOptions = new ListVoiceModelsOptions.Builder()
        .language(MODEL_LANGUAGE)
        .build();
    final VoiceModels result = service.listVoiceModels(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH + "?language=" + MODEL_LANGUAGE, request.getPath());
    assertEquals("GET", request.getMethod());
    assertFalse(result.getCustomizations().isEmpty());
    assertEquals(voiceModels, result);
  }

  /**
   * Test get voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceModel() throws InterruptedException {
    // Test with customization ID
    server.enqueue(jsonResponse(voiceModelWords));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .build();
    VoiceModel result = service.getVoiceModel(getOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(voiceModelWords, result);
    assertNotNull(voiceModelWords.getWords());
    assertEquals(voiceModelWords.getWords(), result.getWords());
  }

  /**
   * Test create voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateVoiceModel() throws InterruptedException {
    // Create the custom voice model.
    server.enqueue(jsonResponse(voiceModel));

    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(MODEL_NAME)
        .language(MODEL_LANGUAGE)
        .description(MODEL_DESCRIPTION)
        .build();
    final VoiceModel result = service.createVoiceModel(createOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(CUSTOMIZATION_ID, result.getCustomizationId());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(voiceModel));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .build();
    final VoiceModel getResult = service.getVoiceModel(getOptions).execute().getResult();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(voiceModel, getResult);
    assertNull(voiceModel.getWords());
    assertEquals(voiceModel.getWords(), getResult.getWords());

  }

  /**
   * Test update voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModel() throws InterruptedException {
    // Create the custom voice model.
    server.enqueue(jsonResponse(voiceModel));

    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(MODEL_NAME)
        .language(MODEL_LANGUAGE)
        .description(MODEL_DESCRIPTION)
        .build();
    final VoiceModel result = service.createVoiceModel(createOptions).execute().getResult();

    final RecordedRequest request = server.takeRequest();
    assertEquals(CUSTOMIZATION_ID, result.getCustomizationId());

    // Update the custom voice model.
    server.enqueue(new MockResponse().setResponseCode(201));
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .name(MODEL_NAME)
        .description(MODEL_DESCRIPTION)
        .build();
    service.updateVoiceModel(updateOptions).execute().getResult();
    final RecordedRequest updateRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), updateRequest.getPath());
    assertEquals("POST", request.getMethod());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(voiceModel));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .build();
    final VoiceModel getResult = service.getVoiceModel(getOptions).execute().getResult();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(voiceModel, getResult);
    assertNull(voiceModel.getWords());
    assertEquals(voiceModel.getWords(), getResult.getWords());
  }

  /**
   * Test update voice model with new words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModelWords() throws InterruptedException {
    // Create the custom voice model.
    server.enqueue(jsonResponse(voiceModelWords));

    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(MODEL_NAME)
        .language(MODEL_LANGUAGE)
        .description(MODEL_DESCRIPTION)
        .build();
    final VoiceModel result = service.createVoiceModel(createOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();
    assertEquals(CUSTOMIZATION_ID, result.getCustomizationId());

    // Update the custom voice model with new words.
    server.enqueue(new MockResponse().setResponseCode(201));
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .name(MODEL_NAME)
        .description(MODEL_DESCRIPTION)
        .words(instantiateWords())
        .build();
    service.updateVoiceModel(updateOptions).execute().getResult();
    final RecordedRequest updateRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), updateRequest.getPath());
    assertEquals("POST", request.getMethod());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(voiceModelWords));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .build();
    final VoiceModel getResult = service.getVoiceModel(getOptions).execute().getResult();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(voiceModelWords, getResult);
    assertNotNull(voiceModelWords.getWords());
    assertEquals(voiceModelWords.getWords(), getResult.getWords());
  }

  /**
   * Test delete voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteVoiceModel() throws InterruptedException {
    server.enqueue(new MockResponse().setResponseCode(204));
    DeleteVoiceModelOptions deleteOptions = new DeleteVoiceModelOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .build();
    service.deleteVoiceModel(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, CUSTOMIZATION_ID), request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Test list words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListWords() throws InterruptedException {
    final List<Word> expected = instantiateWords();

    server.enqueue(jsonResponse(ImmutableMap.of(WORDS, expected)));
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .build();
    final Words result = service.listWords(listOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, CUSTOMIZATION_ID), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result.words());
  }

  /**
   * Test get word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetWord() throws InterruptedException {
    final Word expected = instantiateWords().get(0);

    server.enqueue(jsonResponse(ImmutableMap.of(TRANSLATION, expected.translation())));
    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .word(expected.word())
        .build();
    final Translation result = service.getWord(getOptions).execute().getResult();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, CUSTOMIZATION_ID) + "/" + expected.word(), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected.translation(), result.translation());
  }

  /**
   * Test add words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAddWords() throws InterruptedException {
    final List<Word> expected = instantiateWords();

    server.enqueue(new MockResponse().setResponseCode(201));
    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .words(expected)
        .build();
    service.addWords(addOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, CUSTOMIZATION_ID), request.getPath());
    assertEquals("POST", request.getMethod());
  }

  /**
   * Test add word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAddWord() throws InterruptedException {
    final Word expected = instantiateWord();

    server.enqueue(new MockResponse().setResponseCode(201));
    AddWordOptions addOptions = new AddWordOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .word(expected.word())
        .translation(expected.translation())
        .build();
    service.addWord(addOptions).execute().getResult();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORD_PATH, CUSTOMIZATION_ID, expected.word()), request.getPath());
    assertEquals("PUT", request.getMethod());
  }

  /**
   * Test delete word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteWord() throws InterruptedException {
    final String expected = instantiateWords().get(0).word();

    server.enqueue(new MockResponse().setResponseCode(204));
    DeleteWordOptions deleteOptions = new DeleteWordOptions.Builder()
        .customizationId(CUSTOMIZATION_ID)
        .word(expected)
        .build();
    service.deleteWord(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, CUSTOMIZATION_ID) + "/" + expected, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

}
