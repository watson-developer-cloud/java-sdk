/*
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
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.TestUtils;

/**
 * Integration tests for the Speech to text customization API.
 */
public class CustomizationsIT extends WatsonServiceTest {

  private TextToSpeech service;

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-US";
  private static final String MODEL_LANGUAGE_JAPANESE = "ja-JP";
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
        (username == null) || username.equals(PLACEHOLDER));

    service = new TextToSpeech();
    service.setUsernameAndPassword(username, getProperty("text_to_speech.password"));
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
      new CustomTranslation("shocking", "<phoneme alphabet='ibm' ph='.1Sa.0kIG'></phoneme>")
      /** The following IPA entry is causing a test failure:
       *  new CustomTranslation("trinitroglycerin", "try<phoneme alphabet=\"ipa\" ph=\"nˈaɪtɹəglɪsəɹɨn\"></phoneme>"),
       */
    );
  }

  private List<CustomTranslation> instantiateCustomTranslationsJapanese() {
    return ImmutableList.of(new CustomTranslation("hodor", "hold the door", CustomTranslation.PartOfSpeech.JOSI),
        new CustomTranslation("clodor", "Close the door", CustomTranslation.PartOfSpeech.HOKA));
  }

  private CustomVoiceModel createVoiceModel() {
    return service.createCustomVoiceModel(MODEL_NAME, MODEL_LANGUAGE, MODEL_DESCRIPTION).execute();
  }

  private CustomVoiceModel createVoiceModelJapanese() {
    return service.createCustomVoiceModel(MODEL_NAME, MODEL_LANGUAGE_JAPANESE, MODEL_DESCRIPTION).execute();
  }

  private void assertModelsEqual(CustomVoiceModel a, CustomVoiceModel b) {
    assertEquals(a.getId(), b.getId());
    assertEquals((service.getCustomVoiceModel(a.getId()).execute()).getName(), b.getName());
    assertEquals((service.getCustomVoiceModel(a.getId()).execute()).getLanguage(), b.getLanguage());
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {
    if ((model != null) && (model.getId() != null)) {
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
   * Test create voice model for Japanese.
   */
  @Test
  public void testCreateVoiceModelJapanese() {
    model = createVoiceModelJapanese();

    assertNotNull(model.getId());
  }

  /**
   * Test get voice model.
   */
  @Test
  public void testGetVoiceModelString() {
    model = createVoiceModel();
    final CustomVoiceModel model2 = service.getCustomVoiceModel(model.getId()).execute();

    assertNotNull(model2);
    assertModelsEqual(model, model2);
    assertNotNull(model2.getOwner());
    assertNotNull(model2.getCreated());
    assertNotNull(model2.getLastModified());
  }

  /**
   * Test get voice model.
   */
  @Test
  public void testGetVoiceModelObject() {
    model = createVoiceModel();
    final CustomVoiceModel model2 = service.getCustomVoiceModel(model).execute();

    assertNotNull(model2);
    assertModelsEqual(model, model2);
    assertNotNull(model2.getOwner());
    assertNotNull(model2.getCreated());
    assertNotNull(model2.getLastModified());
  }

  /**
   * Test get voice with customization.
   */
  @Test
  public void testGetVoiceCustomization() {
    model = createVoiceModel();
    final CustomVoiceModel model2 = service.getCustomVoiceModel(model.getId()).execute();
    final Voice voice = service.getVoice("en-US_AllisonVoice", model.getId()).execute();

    assertNotNull(model);
    assertNotNull(model2);
    assertNotNull(voice);
    assertEquals(model2.getId(), voice.getCustomVoiceModel().getId());
    assertEquals(model2.getName(), voice.getCustomVoiceModel().getName());
    assertEquals(model2.getDescription(), voice.getCustomVoiceModel().getDescription());
    assertEquals(model2.getLanguage(), voice.getCustomVoiceModel().getLanguage());
    assertEquals(model2.getOwner(), voice.getCustomVoiceModel().getOwner());
    assertEquals(model2.getCreated(), voice.getCustomVoiceModel().getCreated());
    assertEquals(model2.getLastModified(), voice.getCustomVoiceModel().getLastModified());
  }

  /**
   * Test update voice model with new name and ignored language change.
   */
  @Test
  public void testUpdateVoiceModel() {
    final String newName = "new test";
    final String newLanguage = "pt-BR";

    model = createVoiceModel();
    model = service.getCustomVoiceModel(model).execute();
    model.setName(newName);
    model.setLanguage(newLanguage); // ignored on update
    service.updateCustomVoiceModel(model).execute();

    final CustomVoiceModel model2 = service.getCustomVoiceModel(model).execute();
    assertModelsEqual(model, model2); // comparison at service
    assertEquals(model.getLanguage(), "pt-BR"); // local value
    assertEquals(model2.getLanguage(), MODEL_LANGUAGE); // value at service
  }

  /**
   * Test update voice model with new name and new custom translations.
   */
  @Test
  public void testUpdateVoiceModelWords() {
    final String newName = "new test";

    model = createVoiceModel();
    model = service.getCustomVoiceModel(model).execute();
    model.setName(newName);
    model.setCustomTranslations(instantiateCustomTranslations());
    service.updateCustomVoiceModel(model).execute();

    final CustomVoiceModel model2 = service.getCustomVoiceModel(model).execute();
    assertModelsEqual(model, model2);
    assertEquals(model.getCustomTranslations(), model2.getCustomTranslations());
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
    service.getCustomVoiceModels(null);
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

    service.addWord(model, expected).execute();

    final List<CustomTranslation> results = service.getWords(model).execute();
    assertEquals(1, results.size());

    final CustomTranslation result = results.get(0);
    assertEquals(expected, result);
    assertEquals(expected.getWord(), result.getWord());
    assertEquals(expected.getTranslation(), result.getTranslation());
  }

  /**
   * Test add words and get words.
   */
  @Test
  public void testAddWords() {
    model = createVoiceModel();
    final List<CustomTranslation> expected = instantiateCustomTranslations();

    service.addWords(model, expected.toArray(new CustomTranslation[] { })).execute();

    final List<CustomTranslation> words = service.getWords(model).execute();
    assertEquals(expected.size(), words.size());
  }

  /**
   * Test add words and get words for Japanese.
   */
  @Test
  public void testAddWordsJapanese() {
    model = createVoiceModelJapanese();
    final List<CustomTranslation> expected = instantiateCustomTranslationsJapanese();

    service.addWords(model, expected.toArray(new CustomTranslation[] { })).execute();

    final List<CustomTranslation> words = service.getWords(model).execute();
    assertEquals(expected.size(), words.size());
  }

  /**
   * Test get word.
   */
  @Test
  public void testGetWord() {
    model = createVoiceModel();
    final List<CustomTranslation> expected = instantiateCustomTranslations();

    service.addWords(model, expected.toArray(new CustomTranslation[] { })).execute();

    final CustomTranslation word = service.getWord(model, expected.get(0).getWord()).execute();
    assertEquals(expected.get(0).getTranslation(), word.getTranslation());
  }

  /**
   * Test get word for Japanese.
   */
  @Test
  public void testGetWordJapanese() {
    model = createVoiceModelJapanese();
    final List<CustomTranslation> expected = instantiateCustomTranslationsJapanese();

    service.addWords(model, expected.toArray(new CustomTranslation[] { })).execute();

    final CustomTranslation word = service.getWord(model, expected.get(0).getWord()).execute();
    assertEquals(expected.get(0).getTranslation(), word.getTranslation());
    assertEquals(expected.get(0).getPartOfSpeech(), word.getPartOfSpeech());
  }

  /**
   * Test remove word with object.
   */
  @Test
  public void testRemoveWordObject() {
    model = createVoiceModel();
    final CustomTranslation expected = instantiateCustomTranslations().get(0);

    service.addWord(model, expected).execute();
    service.deleteWord(model, expected).execute();

    final List<CustomTranslation> results = service.getWords(model).execute();
    assertEquals(0, results.size());
  }

  /**
   * Test remove word with string.
   */
  @Test
  public void testRemoveWordString() {
    model = createVoiceModel();
    final CustomTranslation expected = instantiateCustomTranslations().get(0);

    service.addWord(model, expected).execute();
    service.deleteWord(model, expected.getWord()).execute();

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

    service.addWords(model, expected).execute();
    final InputStream stream1 = service.synthesize(expected.getWord(), Voice.EN_MICHAEL, AudioFormat.WAV).execute();
    final InputStream stream2 =
        service.synthesize(expected.getWord(), Voice.EN_MICHAEL, AudioFormat.WAV, model.getId()).execute();

    assertFalse(TestUtils.streamContentEquals(stream1, stream2));
  }

}
