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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AddWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AddWordsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CreateVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomWord;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.DeleteVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.DeleteWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.GetWordOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListVoiceModelsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.ListWordsOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Translation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.UpdateVoiceModelOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModels;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Word;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Words;
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

  private static final String ID = "customization_id";
  private static final String CUSTOMIZATIONS = "customizations";
  private static final String WORDS = "words";
  private static final String TRANSLATION = "translation";

  /** The service. */
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
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  private static VoiceModel instantiateVoiceModel() {
    VoiceModel model = new VoiceModel();
    model.setCustomizationId("cafebabe-1234-5678-9abc-def012345678");
    model.setName(MODEL_NAME);
    model.setDescription(MODEL_DESCRIPTION);
    model.setLanguage(MODEL_LANGUAGE);

    return model;
  }

  private static VoiceModel instantiateVoiceModelWords() {
    VoiceModel model = new VoiceModel();
    model.setCustomizationId("cafebabe-1234-5678-9abc-def012345678");
    model.setName(MODEL_NAME);
    model.setDescription(MODEL_DESCRIPTION);
    model.setLanguage(MODEL_LANGUAGE);
    model.setWords(instantiateWords());

    return model;
  }

  private static Voice instantiateVoice() {
    final Voice voice = new Voice();
    voice.setName("en-US_TestMaleVoice");
    voice.setGender("male");
    voice.setLanguage("en-US");
    voice.setDescription("TestMale");
    voice.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestMaleVoice");
    voice.setCustomization(instantiateVoiceModel());

    return voice;
  }

  private static List<Word> instantiateWords() {
    Word word = new Word();
    word.setWord("hodor");
    word.setTranslation("hold the door");
    return ImmutableList.of(word);
  }

  private static List<CustomWord> instantiateCustomWords() {
    CustomWord word = new CustomWord();
    word.setWord("hodor");
    word.setTranslation("hold the door");
    return ImmutableList.of(word);
  }

  private static Word instantiateWord() {
    Word word = new Word();
    word.setWord("hodor");
    word.setTranslation("hold the door");
    return word;
  }

  /**
   * Test get voice with custom voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceCustomization() throws InterruptedException {
    final Voice expected = instantiateVoice();
    server.enqueue(jsonResponse(expected));

    GetVoiceOptions getOptions = new GetVoiceOptions.Builder()
        .voice(expected.getName())
        .customizationId(expected.getCustomization().getCustomizationId())
        .build();
    final Voice result = service.getVoice(getOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICES_PATH
            + "/"
            + expected.getName()
            + "?customization_id="
            + expected.getCustomization().getCustomizationId(),
        request.getPath()
    );
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
  }

  /**
   * Test list voice models for null language.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListVoiceModelsNull() throws InterruptedException {
    VoiceModels expected = new VoiceModels();
    expected.setCustomizations(ImmutableList.of(instantiateVoiceModel()));
    server.enqueue(jsonResponse(ImmutableMap.of(CUSTOMIZATIONS, expected.getCustomizations())));

    final VoiceModels result = service.listVoiceModels().execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("GET", request.getMethod());
    assertFalse(result.getCustomizations().isEmpty());
    assertEquals(expected, result);
  }

  /**
   * Test list voice models for a language.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListVoiceModelsLanguage() throws InterruptedException {
    VoiceModels expected = new VoiceModels();
    expected.setCustomizations(ImmutableList.of(instantiateVoiceModel()));
    server.enqueue(jsonResponse(ImmutableMap.of(CUSTOMIZATIONS, expected.getCustomizations())));

    ListVoiceModelsOptions listOptions = new ListVoiceModelsOptions.Builder()
        .language(MODEL_LANGUAGE)
        .build();
    final VoiceModels result = service.listVoiceModels(listOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH + "?language=" + MODEL_LANGUAGE, request.getPath());
    assertEquals("GET", request.getMethod());
    assertFalse(result.getCustomizations().isEmpty());
    assertEquals(expected, result);
  }

  /**
   * Test get voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceModel() throws InterruptedException {
    final VoiceModel expected = instantiateVoiceModelWords();

    // Test with customization ID
    server.enqueue(jsonResponse(expected));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .build();
    VoiceModel result = service.getVoiceModel(getOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
    assertNotNull(expected.getWords());
    assertEquals(expected.getWords(), result.getWords());
  }

  /**
   * Test create voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateVoiceModel() throws InterruptedException {
    // Create the custom voice model.
    final VoiceModel expected = instantiateVoiceModel();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getCustomizationId())));

    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(expected.getName())
        .language(expected.getLanguage())
        .description(expected.getDescription())
        .build();
    final VoiceModel result = service.createVoiceModel(createOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(expected.getCustomizationId(), result.getCustomizationId());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(expected));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .build();
    final VoiceModel getResult = service.getVoiceModel(getOptions).execute();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(expected, getResult);
    assertNull(expected.getWords());
    assertEquals(expected.getWords(), getResult.getWords());

  }

  /**
   * Test update voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModel() throws InterruptedException {
    // Create the custom voice model.
    final VoiceModel expected = instantiateVoiceModel();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getCustomizationId())));

    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(expected.getName())
        .language(expected.getLanguage())
        .description(expected.getDescription())
        .build();
    final VoiceModel result = service.createVoiceModel(createOptions).execute();

    final RecordedRequest request = server.takeRequest();
    assertEquals(expected.getCustomizationId(), result.getCustomizationId());

    // Update the custom voice model.
    server.enqueue(new MockResponse().setResponseCode(201));
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .name(expected.getName())
        .description(expected.getDescription())
        .build();
    service.updateVoiceModel(updateOptions).execute();
    final RecordedRequest updateRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), updateRequest.getPath());
    assertEquals("POST", request.getMethod());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(expected));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .build();
    final VoiceModel getResult = service.getVoiceModel(getOptions).execute();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(expected, getResult);
    assertNull(expected.getWords());
    assertEquals(expected.getWords(), getResult.getWords());
  }

  /**
   * Test update voice model with new words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModelWords() throws InterruptedException {
    // Create the custom voice model.
    final VoiceModel expected = instantiateVoiceModelWords();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getCustomizationId())));

    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(expected.getName())
        .language(expected.getLanguage())
        .description(expected.getDescription())
        .build();
    final VoiceModel result = service.createVoiceModel(createOptions).execute();
    final RecordedRequest request = server.takeRequest();
    assertEquals(expected.getCustomizationId(), result.getCustomizationId());

    // Update the custom voice model with new words.
    server.enqueue(new MockResponse().setResponseCode(201));
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .name(expected.getName())
        .description(expected.getDescription())
        .words(expected.getWords())
        .build();
    service.updateVoiceModel(updateOptions).execute();
    final RecordedRequest updateRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), updateRequest.getPath());
    assertEquals("POST", request.getMethod());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(expected));

    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .build();
    final VoiceModel getResult = service.getVoiceModel(getOptions).execute();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(expected, getResult);
    assertNotNull(expected.getWords());
    assertEquals(expected.getWords(), getResult.getWords());
  }

  /**
   * Test delete voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteVoiceModel() throws InterruptedException {
    final VoiceModel expected = instantiateVoiceModel();

    server.enqueue(new MockResponse().setResponseCode(204));
    DeleteVoiceModelOptions deleteOptions = new DeleteVoiceModelOptions.Builder()
        .customizationId(expected.getCustomizationId())
        .build();
    service.deleteVoiceModel(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getCustomizationId()), request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Test list words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListWords() throws InterruptedException {
    final VoiceModel model = instantiateVoiceModel();
    final List<Word> expected = instantiateWords();

    server.enqueue(jsonResponse(ImmutableMap.of(WORDS, expected)));
    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final Words result = service.listWords(listOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getCustomizationId()), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result.getWords());
  }

  /**
   * Test get word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetWord() throws InterruptedException {
    final VoiceModel model = instantiateVoiceModel();
    final Word expected = instantiateWords().get(0);

    server.enqueue(jsonResponse(ImmutableMap.of(TRANSLATION, expected.getTranslation())));
    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(model.getCustomizationId())
        .word(expected.getWord())
        .build();
    final Translation result = service.getWord(getOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getCustomizationId()) + "/" + expected.getWord(), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected.getTranslation(), result.getTranslation());
  }

  /**
   * Test add words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAddWords() throws InterruptedException {
    final VoiceModel model = instantiateVoiceModel();
    final List<CustomWord> expected = instantiateCustomWords();

    server.enqueue(new MockResponse().setResponseCode(201));
    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .words(expected)
        .build();
    service.addWords(addOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getCustomizationId()), request.getPath());
    assertEquals("POST", request.getMethod());
  }

  /**
   * Test add word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAddWord() throws InterruptedException {
    final VoiceModel model = instantiateVoiceModel();
    final Word expected = instantiateWord();

    server.enqueue(new MockResponse().setResponseCode(201));
    AddWordOptions addOptions = new AddWordOptions.Builder()
        .customizationId(model.getCustomizationId())
        .word(expected.getWord())
        .translation(expected.getTranslation())
        .build();
    service.addWord(addOptions).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORD_PATH, model.getCustomizationId(), expected.getWord()), request.getPath());
    assertEquals("PUT", request.getMethod());
  }

  /**
   * Test delete word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteWord() throws InterruptedException {
    final VoiceModel model = instantiateVoiceModel();
    final String expected = instantiateWords().get(0).getWord();

    server.enqueue(new MockResponse().setResponseCode(204));
    DeleteWordOptions deleteOptions = new DeleteWordOptions.Builder()
        .customizationId(model.getCustomizationId())
        .word(expected)
        .build();
    service.deleteWord(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getCustomizationId()) + "/" + expected, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

}
