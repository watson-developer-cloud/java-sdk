/*
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

import static com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat.WAV;
import static com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice.EN_MICHAEL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.util.TestUtils;

/**
 * Integration tests for the Speech to text customization API
 */
public class CustomizationsIT extends WatsonServiceTest {

  private TextToSpeech service;

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-US";
  private static final String MODEL_DESCRIPTION = "a simple model for testing purposes";

  private CustomVoiceModel model;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("text_to_speech.username");
    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        username ==null || username.equals(PLACEHOLDER));
    
    service = new TextToSpeech();
    service.setUsernameAndPassword(username,
        getProperty("text_to_speech.password"));
    service.setEndPoint(getProperty("text_to_speech.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  private CustomVoiceModel instantiateVoiceModel() {
    final CustomVoiceModel model = new CustomVoiceModel();
    model.setName(MODEL_NAME);
    model.setDescription(MODEL_DESCRIPTION);
    model.setLanguage(MODEL_LANGUAGE);

    return model;
  }

  private List<CustomTranslation> instantiateCustomTranslations() {
    return ImmutableList.of(new CustomTranslation("hodor", "hold the door"),
        new CustomTranslation("trinitroglycerin", "try<phoneme alphabet=\"ipa\" ph=\"nˈaɪtɹəglɪsəɹɨn\"></phoneme>"),
        new CustomTranslation("shocking", "<phoneme alphabet='ibm' ph='.1Sa.0kIG'></phoneme>"));
  }

  private CustomVoiceModel createVoiceModel() {
    return service.saveCustomVoiceModel(instantiateVoiceModel()).execute();
  }

  private void assertModelsEqual(CustomVoiceModel a, CustomVoiceModel b) {
    assertEquals(a.getId(), b.getId());
    assertEquals(a.getName(), b.getName());
    assertEquals(a.getDescription(), b.getDescription());
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {
    if (model != null && model.getId() != null) {
      try {
        service.deleteCustomVoiceModel(model).execute();
      } catch (Exception e) {
        // Exceptions are fine in the clean up method
      }
    }
  }

  /**
   * Test create voice model.
   */
  @Test
  public void testCreateVoiceModel() {
    model = createVoiceModel();

    assertNotNull(model.getId());
  }

  /**
   * Test get voice model.
   */
  @Test
  public void testGetVoiceModel() {
    model = createVoiceModel();
    final CustomVoiceModel model2 = service.getCustomVoiceModel(model.getId()).execute();

    assertNotNull(model2);
    assertModelsEqual(model, model2);
    assertNotNull(model2.getOwner());
    assertNotNull(model2.getCreated());
    assertNotNull(model2.getLastModified());
  }

  /**
   * Test update voice model.
   */
  @Test
  public void testUpdateVoiceModel() {
    final String newName = "new test";

    model = createVoiceModel();
    model = service.getCustomVoiceModel(model.getId()).execute();
    model.setName(newName);
    service.saveCustomVoiceModel(model).execute();

    final CustomVoiceModel model2 = service.getCustomVoiceModel(model.getId()).execute();
    assertModelsEqual(model, model2);
  }

  /**
   * Test delete voice model.
   */
  @Test
  public void testDeleteVoiceModel() {
    model = createVoiceModel();

    service.deleteCustomVoiceModel(model).execute();

    try {
      service.getCustomVoiceModel(model.getId()).execute();
      fail("deleting customization failed");
    } catch (UnauthorizedException e) {
      // success!
    }
  }

  /**
   * Test get models.
   */
  @Test
  public void testGetModels() {
    service.getCustomVoiceModels(instantiateVoiceModel().getLanguage());
  }

  /**
   * Test get models after create.
   */
  @Test
  public void testGetModelsAfterCreate() {
    model = createVoiceModel();
    final List<CustomVoiceModel> models = service.getCustomVoiceModels(model.getLanguage()).execute();
    CustomVoiceModel model2 = null;

    for (CustomVoiceModel m : models) {
      if (m.getId().equals(model.getId())) {
        model2 = m;
        break;
      }
    }

    assertNotNull(model2);
    assertModelsEqual(model, model2);
  }

  /**
   * Test add word.
   */
  @Test
  public void testAddWord() {
    model = createVoiceModel();
    final CustomTranslation expected = instantiateCustomTranslations().get(0);

    service.saveWords(model, expected).execute();

    final List<CustomTranslation> results = service.getWords(model).execute();
    assertEquals(1, results.size());

    final CustomTranslation result = results.get(0);
    assertEquals(expected, result);
    assertEquals(expected.getWord(), result.getWord());
    assertEquals(expected.getTranslation(), result.getTranslation());
  }

  /**
   * Test add words.
   */
  @Test
  public void testAddWords() {
    model = createVoiceModel();
    final List<CustomTranslation> expected = instantiateCustomTranslations();

    service.saveWords(model, expected.toArray(new CustomTranslation[] {})).execute();

    final List<CustomTranslation> words = service.getWords(model).execute();
    assertEquals(expected.size(), words.size());
  }

  /**
   * Test remove word.
   */
  @Test
  public void testRemoveWord() {
    model = createVoiceModel();
    final CustomTranslation expected = instantiateCustomTranslations().get(0);

    service.saveWords(model, expected).execute();
    service.deleteWord(model, expected).execute();

    final List<CustomTranslation> results = service.getWords(model).execute();
    assertEquals(0, results.size());
  }

  /**
   * Test synthesize.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSynthesize() throws IOException {
    model = createVoiceModel();
    final CustomTranslation expected = instantiateCustomTranslations().get(0);

    service.saveWords(model, expected).execute();
    final InputStream stream1 = service.synthesize(expected.getWord(), EN_MICHAEL, WAV).execute();
    final InputStream stream2 = service.synthesize(expected.getWord(), EN_MICHAEL, WAV, model.getId()).execute();

    assertFalse(TestUtils.streamContentEquals(stream1, stream2));
  }

}
