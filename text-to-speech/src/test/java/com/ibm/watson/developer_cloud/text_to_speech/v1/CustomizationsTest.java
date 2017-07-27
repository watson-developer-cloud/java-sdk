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

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

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

  private static CustomVoiceModel instantiateVoiceModel() {
    CustomVoiceModel model = new CustomVoiceModel();
    model.setId("cafebabe-1234-5678-9abc-def012345678");
    model.setName(MODEL_NAME);
    model.setDescription(MODEL_DESCRIPTION);
    model.setLanguage(MODEL_LANGUAGE);

    return model;
  }

  private static CustomVoiceModel instantiateVoiceModelWords() {
    CustomVoiceModel model = new CustomVoiceModel();
    model.setId("cafebabe-1234-5678-9abc-def012345678");
    model.setName(MODEL_NAME);
    model.setDescription(MODEL_DESCRIPTION);
    model.setLanguage(MODEL_LANGUAGE);
    model.setCustomTranslations(instantiateWords());

    return model;
  }

  private static Voice instantiateVoice() {
    final Voice voice = new Voice();
    voice.setName("en-US_TestMaleVoice");
    voice.setGender("male");
    voice.setLanguage("en-US");
    voice.setDescription("TestMale");
    voice.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestMaleVoice");
    voice.setCustomVoiceModel(instantiateVoiceModel());

    return voice;
  }

  private static List<CustomTranslation> instantiateWords() {
    return ImmutableList.of(new CustomTranslation("hodor", "hold the door"));
  }

  private static CustomTranslation instantiateWord() {
    return new CustomTranslation("hodor", "hold the door");
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

    final Voice result = service.getVoice(expected.getName(), expected.getCustomVoiceModel().getId()).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICES_PATH + "/" + expected.getName() + "?customization_id=" + expected.getCustomVoiceModel().getId(),
      request.getPath()
    );
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
  }

  /**
   * Test get voice models for null language.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceModelsNull() throws InterruptedException {
    final List<CustomVoiceModel> expected = ImmutableList.of(instantiateVoiceModel());
    server.enqueue(jsonResponse(ImmutableMap.of(CUSTOMIZATIONS, expected)));

    final List<CustomVoiceModel> result = service.getCustomVoiceModels(null).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("GET", request.getMethod());
    assertFalse(result.isEmpty());
    assertEquals(expected, result);
  }

  /**
   * Test get voice models for a language.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceModelsLanguage() throws InterruptedException {
    final List<CustomVoiceModel> expected = ImmutableList.of(instantiateVoiceModel());
    server.enqueue(jsonResponse(ImmutableMap.of(CUSTOMIZATIONS, expected)));

    final List<CustomVoiceModel> result = service.getCustomVoiceModels(MODEL_LANGUAGE).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH + "?language=" + MODEL_LANGUAGE, request.getPath());
    assertEquals("GET", request.getMethod());
    assertFalse(result.isEmpty());
    assertEquals(expected, result);
  }

  /**
   * Test get voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceModel() throws InterruptedException {
    final CustomVoiceModel expected = instantiateVoiceModelWords();

    // Test with customization ID
    server.enqueue(jsonResponse(expected));

    CustomVoiceModel result = service.getCustomVoiceModel(expected.getId()).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
    assertNotNull(expected.getCustomTranslations());
    assertEquals(expected.getCustomTranslations(), result.getCustomTranslations());

    // Test with model object
    server.enqueue(jsonResponse(expected));

    result = service.getCustomVoiceModel(expected).execute();
    request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
    assertEquals(expected.getCustomTranslations(), result.getCustomTranslations());
  }

  /**
   * Test create voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateVoiceModel() throws InterruptedException {
    // Create the custom voice model.
    final CustomVoiceModel expected = instantiateVoiceModel();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getId())));

    final CustomVoiceModel result = service.createCustomVoiceModel(expected.getName(),
      expected.getLanguage(), expected.getDescription())
    .execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(expected.getId(), result.getId());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(expected));

    final CustomVoiceModel getResult = service.getCustomVoiceModel(expected.getId()).execute();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(expected, getResult);
    assertNull(expected.getCustomTranslations());
    assertEquals(expected.getCustomTranslations(), getResult.getCustomTranslations());

  }

  /**
   * Test update voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModel() throws InterruptedException {
    // Create the custom voice model.
    final CustomVoiceModel expected = instantiateVoiceModel();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getId())));

    final CustomVoiceModel result = service.createCustomVoiceModel(
      expected.getId(), expected.getName(), expected.getDescription())
      .execute();

    final RecordedRequest request = server.takeRequest();
    assertEquals(expected.getId(), result.getId());

    // Update the custom voice model.
    server.enqueue(new MockResponse().setResponseCode(201));
    service.updateCustomVoiceModel(expected).execute();
    final RecordedRequest updateRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), updateRequest.getPath());
    assertEquals("POST", request.getMethod());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(expected));

    final CustomVoiceModel getResult = service.getCustomVoiceModel(expected.getId()).execute();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(expected, getResult);
    assertNull(expected.getCustomTranslations());
    assertEquals(expected.getCustomTranslations(), getResult.getCustomTranslations());
  }

  /**
   * Test update voice model with new words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModelWords() throws InterruptedException {
    // Create the custom voice model.
    final CustomVoiceModel expected = instantiateVoiceModelWords();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getId())));

    final CustomVoiceModel result = service.createCustomVoiceModel(expected.getId(),
      expected.getName(), expected.getDescription())
      .execute();
    final RecordedRequest request = server.takeRequest();
    assertEquals(expected.getId(), result.getId());

    // Update the custom voice model with new words.
    server.enqueue(new MockResponse().setResponseCode(201));
    service.updateCustomVoiceModel(expected).execute();
    final RecordedRequest updateRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), updateRequest.getPath());
    assertEquals("POST", request.getMethod());

    // Compare expected with actual results.
    server.enqueue(jsonResponse(expected));

    final CustomVoiceModel getResult = service.getCustomVoiceModel(expected.getId()).execute();
    final RecordedRequest getRequest = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), getRequest.getPath());
    assertEquals("GET", getRequest.getMethod());
    assertEquals(expected, getResult);
    assertNotNull(expected.getCustomTranslations());
    assertEquals(expected.getCustomTranslations(), getResult.getCustomTranslations());
  }

  /**
   * Test delete voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteVoiceModel() throws InterruptedException {
    final CustomVoiceModel expected = instantiateVoiceModel();

    server.enqueue(new MockResponse().setResponseCode(204));
    service.deleteCustomVoiceModel(expected).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(VOICE_MODEL_PATH, expected.getId()), request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Test get words.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetWords() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final List<CustomTranslation> expected = instantiateWords();

    server.enqueue(jsonResponse(ImmutableMap.of(WORDS, expected)));
    final List<CustomTranslation> result = service.getWords(model).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
  }

  /**
   * Test get word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetWord() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final CustomTranslation expected = instantiateWords().get(0);

    server.enqueue(jsonResponse(ImmutableMap.of(TRANSLATION, expected.getTranslation())));
    final CustomTranslation result =
        service.getWord(model, expected.getWord()).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()) + "/" + expected.getWord(), request.getPath());
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
    final CustomVoiceModel model = instantiateVoiceModel();
    final List<CustomTranslation> expected = instantiateWords();

    server.enqueue(new MockResponse().setResponseCode(201));
    service.addWords(model, expected.toArray(new CustomTranslation[] { })).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()), request.getPath());
    assertEquals("POST", request.getMethod());

    server.enqueue(new MockResponse().setResponseCode(201));
    service.addWords(model, expected.get(0)).execute();
    request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()), request.getPath());
    assertEquals("POST", request.getMethod());
  }

  /**
   * Test add word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAddWord() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final CustomTranslation expected = instantiateWord();

    server.enqueue(new MockResponse().setResponseCode(201));
    service.addWord(model, expected).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORD_PATH, model.getId(), expected.getWord()), request.getPath());
    assertEquals("PUT", request.getMethod());

    server.enqueue(new MockResponse().setResponseCode(201));
    service.addWord(model, expected).execute();
    request = server.takeRequest();

    assertEquals(String.format(WORD_PATH, model.getId(), expected.getWord()), request.getPath());
    assertEquals("PUT", request.getMethod());
  }

  /**
   * Test delete word with object.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteWordObject() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final CustomTranslation expected = instantiateWords().get(0);

    server.enqueue(new MockResponse().setResponseCode(204));
    service.deleteWord(model, expected).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()) + "/" + expected.getWord(), request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

  /**
   * Test delete word with string.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteWordString() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final String expected = instantiateWords().get(0).getWord();

    server.enqueue(new MockResponse().setResponseCode(204));
    service.deleteWord(model, expected).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()) + "/" + expected, request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

}
