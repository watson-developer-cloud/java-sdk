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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit tests for the Speech to text customization API
 */
public class CustomizationsTest extends WatsonServiceUnitTest {

  private final static String VOICE_MODELS_PATH = "/v1/customizations";
  private final static String WORDS_PATH = VOICE_MODELS_PATH + "/%s/words";

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-us";
  private static final String MODEL_DESCRIPTION = "a simple model for testing purposes";

  private static final String ID = "customization_id";
  private static final String CUSTOMIZATIONS = "customizations";
  private static final String WORDS = "words";

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

  private static List<CustomTranslation> instantiateWords() {
    return ImmutableList.of(new CustomTranslation("hodor", "hold the door"));
  }

  /**
   * Test get voice models.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testGetVoiceModels() throws InterruptedException {
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
    final CustomVoiceModel expected = instantiateVoiceModel();
    server.enqueue(jsonResponse(expected));

    final CustomVoiceModel result = service.getCustomVoiceModel(expected.getId()).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH + "/" + expected.getId(), request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(expected, result);
  }

  /**
   * Test create voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCreateVoiceModel() throws InterruptedException {
    final CustomVoiceModel expected = instantiateVoiceModel();
    server.enqueue(jsonResponse(ImmutableMap.of(ID, expected.getId())));

    final CustomVoiceModel newModel = new CustomVoiceModel();
    newModel.setName(expected.getName());
    newModel.setLanguage(expected.getLanguage());
    newModel.setDescription(expected.getDescription());

    final CustomVoiceModel result = service.saveCustomVoiceModel(newModel).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(expected, result);
  }

  /**
   * Test update voice model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testUpdateVoiceModel() throws InterruptedException {
    final CustomVoiceModel expected = instantiateVoiceModel();

    server.enqueue(new MockResponse().setResponseCode(201));
    final CustomVoiceModel result = service.saveCustomVoiceModel(expected).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(VOICE_MODELS_PATH + "/" + expected.getId(), request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(expected, result);
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

    assertEquals(VOICE_MODELS_PATH + "/" + expected.getId(), request.getPath());
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
   * Test add word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAddWord() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final List<CustomTranslation> expected = instantiateWords();

    server.enqueue(new MockResponse().setResponseCode(201));
    service.saveWords(model, expected.toArray(new CustomTranslation[]{})).execute();
    RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()), request.getPath());
    assertEquals("POST", request.getMethod());

    server.enqueue(new MockResponse().setResponseCode(201));
    service.saveWords(model, expected.get(0)).execute();
    request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()), request.getPath());
    assertEquals("POST", request.getMethod());
  }

  /**
   * Test delete word.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteWord() throws InterruptedException {
    final CustomVoiceModel model = instantiateVoiceModel();
    final CustomTranslation expected = instantiateWords().get(0);

    server.enqueue(new MockResponse().setResponseCode(204));
    service.deleteWord(model, expected).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(String.format(WORDS_PATH, model.getId()) + "/" + expected.getWord(), request.getPath());
    assertEquals("DELETE", request.getMethod());
  }

}
