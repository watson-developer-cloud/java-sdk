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
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import com.ibm.watson.common.TestUtils;
import com.ibm.watson.common.WatsonServiceTest;
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
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Translation;
import com.ibm.watson.text_to_speech.v1.model.UpdateVoiceModelOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.model.VoiceModel;
import com.ibm.watson.text_to_speech.v1.model.VoiceModels;
import com.ibm.watson.text_to_speech.v1.model.Word;
import com.ibm.watson.text_to_speech.v1.model.Words;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Integration tests for the Speech to text customization API.
 */
public class CustomizationsIT extends WatsonServiceTest {

  private TextToSpeech service;

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-US";
  private static final String MODEL_LANGUAGE_JAPANESE = "ja-JP";
  private static final String MODEL_DESCRIPTION = "a simple model for testing purposes";

  private VoiceModel model;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String apiKey = getProperty("text_to_speech.apikey");
    Assume.assumeFalse("config.properties doesn't have valid credentials.", apiKey == null);

    Authenticator authenticator = new IamAuthenticator(apiKey);
    service = new TextToSpeech(authenticator);
    service.setServiceUrl(getProperty("text_to_speech.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  private List<Word> instantiateWords() {
    Word word1 = new Word.Builder()
        .word("hodor")
        .translation("hold the door")
        .build();
    Word word2 = new Word.Builder()
        .word("shocking")
        .translation("<phoneme alphabet='ibm' ph='.1Sa.0kIG'></phoneme>")
        .build();
    return ImmutableList.of(word1, word2);
  }

  private List<Word> instantiateWordsJapanese() {
    Word word1 = new Word.Builder()
        .word("hodor")
        .translation("hold the door")
        .partOfSpeech(Word.PartOfSpeech.JOSI)
        .build();
    Word word2 = new Word.Builder()
        .word("clodor")
        .translation("close the door")
        .partOfSpeech(Word.PartOfSpeech.HOKA)
        .build();
    return ImmutableList.of(word1, word2);
  }

  private VoiceModel createVoiceModel() {
    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(MODEL_NAME)
        .language(MODEL_LANGUAGE)
        .description(MODEL_DESCRIPTION)
        .build();
    return service.createVoiceModel(createOptions).execute().getResult();
  }

  private VoiceModel createVoiceModelJapanese() {
    CreateVoiceModelOptions createOptions = new CreateVoiceModelOptions.Builder()
        .name(MODEL_NAME)
        .language(MODEL_LANGUAGE_JAPANESE)
        .description(MODEL_DESCRIPTION)
        .build();
    return service.createVoiceModel(createOptions).execute().getResult();
  }

  private void assertModelsEqual(VoiceModel a, VoiceModel b) {
    assertEquals(a.getCustomizationId(), b.getCustomizationId());
    GetVoiceModelOptions getOptionsA = new GetVoiceModelOptions.Builder()
        .customizationId(a.getCustomizationId())
        .build();
    assertEquals((service.getVoiceModel(getOptionsA).execute().getResult()).getName(), b.getName());
    assertEquals((service.getVoiceModel(getOptionsA).execute().getResult()).getLanguage(), b.getLanguage());
  }

  /**
   * Clean up.
   */
  @After
  public void cleanUp() {
    if ((model != null) && (model.getCustomizationId() != null)) {
      try {
        DeleteVoiceModelOptions deleteOptions = new DeleteVoiceModelOptions.Builder()
            .customizationId(model.getCustomizationId())
            .build();
        service.deleteVoiceModel(deleteOptions).execute();
      } catch (Exception e) {
        // Exceptions are fine in the clean up method
      }
    }
  }

  /**
   * Test create voice model.
   */
  @Test
  @Ignore
  public void testCreateVoiceModel() {
    model = createVoiceModel();

    assertNotNull(model.getCustomizationId());
  }

  /**
   * Test create voice model for Japanese.
   */
  @Test
  @Ignore
  public void testCreateVoiceModelJapanese() {
    model = createVoiceModelJapanese();

    assertNotNull(model.getCustomizationId());
  }

  /**
   * Test get voice model.
   */
  @Test
  @Ignore
  public void testGetVoiceModelString() {
    model = createVoiceModel();
    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final VoiceModel model2 = service.getVoiceModel(getOptions).execute().getResult();

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
  @Ignore
  public void testGetVoiceModelObject() {
    model = createVoiceModel();
    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final VoiceModel model2 = service.getVoiceModel(getOptions).execute().getResult();

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
  @Ignore
  public void testGetVoiceCustomization() {
    model = createVoiceModel();
    GetVoiceModelOptions getVoiceModelOptions = new GetVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final VoiceModel model2 = service.getVoiceModel(getVoiceModelOptions).execute().getResult();
    GetVoiceOptions getVoiceOptions = new GetVoiceOptions.Builder()
        .customizationId(model.getCustomizationId())
        .voice(GetVoiceOptions.Voice.EN_US_ALLISONVOICE)
        .build();
    final Voice voice = service.getVoice(getVoiceOptions).execute().getResult();

    assertNotNull(model);
    assertNotNull(model2);
    assertNotNull(voice);
    assertEquals(model2.getCustomizationId(), voice.getCustomization().getCustomizationId());
    assertEquals(model2.getName(), voice.getCustomization().getName());
    assertEquals(model2.getDescription(), voice.getCustomization().getDescription());
    assertEquals(model2.getLanguage(), voice.getCustomization().getLanguage());
    assertEquals(model2.getOwner(), voice.getCustomization().getOwner());
    assertEquals(model2.getCreated(), voice.getCustomization().getCreated());
    assertEquals(model2.getLastModified(), voice.getCustomization().getLastModified());
  }

  /**
   * Test update voice model with new name and ignored language change.
   */
  @Test
  @Ignore
  public void testUpdateVoiceModel() {
    final String newName = "new test";

    model = createVoiceModel();
    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    model = service.getVoiceModel(getOptions).execute().getResult();
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .name(newName)
        .build();
    service.updateVoiceModel(updateOptions).execute().getResult();

    final VoiceModel model2 = service.getVoiceModel(getOptions).execute().getResult();
    assertModelsEqual(model, model2); // comparison at service
    assertEquals(model2.getLanguage(), MODEL_LANGUAGE); // value at service
  }

  /**
   * Test update voice model with new name and new custom translations.
   */
  @Test
  @Ignore
  public void testUpdateVoiceModelWords() {
    final String newName = "new test";

    model = createVoiceModel();
    GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    model = service.getVoiceModel(getOptions).execute().getResult();
    UpdateVoiceModelOptions updateOptions = new UpdateVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .name(newName)
        .words(instantiateWords())
        .build();
    service.updateVoiceModel(updateOptions).execute().getResult();

    final VoiceModel model2 = service.getVoiceModel(getOptions).execute().getResult();
    assertModelsEqual(model, model2);
    assertNotEquals(model.getWords(), model2.getWords());
  }

  /**
   * Test delete voice model.
   */
  @Test
  @Ignore
  public void testDeleteVoiceModel() {
    model = createVoiceModel();

    DeleteVoiceModelOptions deleteOptions = new DeleteVoiceModelOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    service.deleteVoiceModel(deleteOptions).execute();

    try {
      GetVoiceModelOptions getOptions = new GetVoiceModelOptions.Builder()
          .customizationId(model.getCustomizationId())
          .build();
      service.getVoiceModel(getOptions).execute().getResult();
      fail("deleting customization failed");
    } catch (UnauthorizedException e) {
      // success!
    }
  }

  /**
   * Test list models.
   */
  @Test
  public void testListModels() {
    ListVoiceModelsOptions listOptions = new ListVoiceModelsOptions.Builder()
        .language(MODEL_LANGUAGE)
        .build();
    service.listVoiceModels(listOptions);
    service.listVoiceModels();
  }

  /**
   * Test list models after create.
   */
  @Test
  @Ignore
  public void testListModelsAfterCreate() {
    model = createVoiceModel();
    ListVoiceModelsOptions listOptions = new ListVoiceModelsOptions.Builder()
        .language(model.getLanguage())
        .build();
    final VoiceModels models = service.listVoiceModels(listOptions).execute().getResult();
    VoiceModel model2 = null;

    for (VoiceModel m : models.getCustomizations()) {
      if (m.getCustomizationId().equals(model.getCustomizationId())) {
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
  @Ignore
  public void testAddWord() {
    model = createVoiceModel();
    final Word expected = instantiateWords().get(0);

    AddWordOptions addOptions = new AddWordOptions.Builder()
        .word(expected.word())
        .translation(expected.translation())
        .customizationId(model.getCustomizationId())
        .build();
    service.addWord(addOptions).execute().getResult();

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final Words results = service.listWords(listOptions).execute().getResult();
    assertEquals(1, results.words().size());

    final Word result = results.words().get(0);
    assertEquals(expected, result);
    assertEquals(expected.word(), result.word());
    assertEquals(expected.translation(), result.translation());
  }

  /**
   * Test add words and list words.
   */
  @Test
  @Ignore
  public void testAddWords() {
    model = createVoiceModel();
    final List<Word> expected = instantiateWords();

    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .words(expected)
        .build();
    service.addWords(addOptions).execute().getResult();

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final Words words = service.listWords(listOptions).execute().getResult();
    assertEquals(expected.size(), words.words().size());
  }

  /**
   * Test add words and list words for Japanese.
   */
  @Test
  @Ignore
  public void testAddWordsJapanese() {
    model = createVoiceModelJapanese();
    final List<Word> expected = instantiateWordsJapanese();

    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .words(expected)
        .build();
    service.addWords(addOptions).execute().getResult();

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final Words words = service.listWords(listOptions).execute().getResult();
    assertEquals(expected.size(), words.words().size());
  }

  /**
   * Test get word.
   */
  @Test
  @Ignore
  public void testGetWord() {
    model = createVoiceModel();
    final List<Word> expected = instantiateWords();

    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .words(expected)
        .build();
    service.addWords(addOptions).execute().getResult();

    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(model.getCustomizationId())
        .word(expected.get(0).word())
        .build();
    final Translation translation = service.getWord(getOptions).execute().getResult();
    assertEquals(expected.get(0).translation(), translation.translation());
  }

  /**
   * Test get word for Japanese.
   */
  @Test
  @Ignore
  public void testGetWordJapanese() {
    model = createVoiceModelJapanese();
    final List<Word> expected = instantiateWordsJapanese();

    AddWordsOptions addOptions = new AddWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .words(expected)
        .build();
    service.addWords(addOptions).execute().getResult();

    GetWordOptions getOptions = new GetWordOptions.Builder()
        .customizationId(model.getCustomizationId())
        .word(expected.get(0).word())
        .build();
    final Translation translation = service.getWord(getOptions).execute().getResult();
    assertEquals(expected.get(0).translation(), translation.translation());
    assertEquals(expected.get(0).partOfSpeech(), translation.partOfSpeech());
  }

  /**
   * Test delete word with string.
   */
  @Test
  @Ignore
  public void testDeleteWord() {
    model = createVoiceModel();
    final Word expected = instantiateWords().get(0);

    AddWordOptions addOptions = new AddWordOptions.Builder()
        .word(expected.word())
        .translation(expected.translation())
        .customizationId(model.getCustomizationId())
        .build();
    service.addWord(addOptions).execute().getResult();
    DeleteWordOptions deleteOptions = new DeleteWordOptions.Builder()
        .customizationId(model.getCustomizationId())
        .word(expected.word())
        .build();
    service.deleteWord(deleteOptions).execute();

    ListWordsOptions listOptions = new ListWordsOptions.Builder()
        .customizationId(model.getCustomizationId())
        .build();
    final Words results = service.listWords(listOptions).execute().getResult();
    assertEquals(0, results.words().size());
  }

  /**
   * Test synthesize.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  @Ignore
  public void testSynthesize() throws IOException {
    model = createVoiceModel();
    final Word expected = instantiateWords().get(0);

    AddWordOptions addOptions = new AddWordOptions.Builder()
        .word(expected.word())
        .translation(expected.translation())
        .customizationId(model.getCustomizationId())
        .build();
    service.addWord(addOptions).execute().getResult();
    SynthesizeOptions synthesizeOptions1 = new SynthesizeOptions.Builder()
        .text(expected.word())
        .voice(SynthesizeOptions.Voice.EN_US_MICHAELVOICE)
        .accept(HttpMediaType.AUDIO_WAV)
        .build();
    final InputStream stream1 = service.synthesize(synthesizeOptions1).execute().getResult();
    SynthesizeOptions synthesizeOptions2 = new SynthesizeOptions.Builder()
        .text(expected.word())
        .voice(SynthesizeOptions.Voice.EN_US_MICHAELVOICE)
        .accept(HttpMediaType.AUDIO_WAV)
        .customizationId(model.getCustomizationId())
        .build();
    final InputStream stream2 = service.synthesize(synthesizeOptions2).execute().getResult();

    assertFalse(TestUtils.streamContentEquals(stream1, stream2));
  }

}
