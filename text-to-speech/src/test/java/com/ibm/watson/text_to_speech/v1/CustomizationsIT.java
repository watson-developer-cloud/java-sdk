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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.UnauthorizedException;
import com.ibm.watson.common.TestUtils;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.text_to_speech.v1.model.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/** Integration tests for the Speech to text customization API. */
public class CustomizationsIT extends WatsonServiceTest {

  private TextToSpeech service;

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-US";
  private static final String MODEL_LANGUAGE_JAPANESE = "ja-JP";
  private static final String MODEL_DESCRIPTION = "a simple model for testing purposes";

  private CustomModel model;

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
  }

  private List<Word> instantiateWords() {
    Word word1 = new Word.Builder().word("hodor").translation("hold the door").build();
    Word word2 =
        new Word.Builder()
            .word("shocking")
            .translation("<phoneme alphabet='ibm' ph='.1Sa.0kIG'></phoneme>")
            .build();
    return ImmutableList.of(word1, word2);
  }

  private List<Word> instantiateWordsJapanese() {
    Word word1 =
        new Word.Builder()
            .word("hodor")
            .translation("hold the door")
            .partOfSpeech(Word.PartOfSpeech.JOSI)
            .build();
    Word word2 =
        new Word.Builder()
            .word("clodor")
            .translation("close the door")
            .partOfSpeech(Word.PartOfSpeech.HOKA)
            .build();
    return ImmutableList.of(word1, word2);
  }

  private CustomModel createCustomModel() {
    CreateCustomModelOptions createOptions =
        new CreateCustomModelOptions.Builder()
            .name(MODEL_NAME)
            .language(MODEL_LANGUAGE)
            .description(MODEL_DESCRIPTION)
            .build();
    return service.createCustomModel(createOptions).execute().getResult();
  }

  private CustomModel createVoiceModelJapanese() {
    CreateCustomModelOptions createOptions =
        new CreateCustomModelOptions.Builder()
            .name(MODEL_NAME)
            .language(MODEL_LANGUAGE_JAPANESE)
            .description(MODEL_DESCRIPTION)
            .build();
    return service.createCustomModel(createOptions).execute().getResult();
  }

  private void assertModelsEqual(CustomModel a, CustomModel b) {
    assertEquals(a.getCustomizationId(), b.getCustomizationId());
    GetCustomModelOptions getOptionsA =
        new GetCustomModelOptions.Builder().customizationId(a.getCustomizationId()).build();
    assertEquals(
        (service.getCustomModel(getOptionsA).execute().getResult()).getName(), b.getName());
    assertEquals(
        (service.getCustomModel(getOptionsA).execute().getResult()).getLanguage(), b.getLanguage());
  }

  /** Clean up. */
  @After
  public void cleanUp() {
    if ((model != null) && (model.getCustomizationId() != null)) {
      try {
        DeleteCustomModelOptions deleteOptions =
            new DeleteCustomModelOptions.Builder()
                .customizationId(model.getCustomizationId())
                .build();
        service.deleteCustomModel(deleteOptions).execute();
      } catch (Exception e) {
        // Exceptions are fine in the clean up method
      }
    }
  }

  /** Test create voice model. */
  @Test
  @Ignore
  public void testCreateVoiceModel() {
    model = createCustomModel();

    assertNotNull(model.getCustomizationId());
  }

  /** Test create voice model for Japanese. */
  @Test
  @Ignore
  public void testCreateVoiceModelJapanese() {
    model = createVoiceModelJapanese();

    assertNotNull(model.getCustomizationId());
  }

  /** Test get voice model. */
  @Test
  @Ignore
  public void testGetVoiceModelString() {
    model = createCustomModel();
    GetCustomModelOptions getOptions =
        new GetCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
    final CustomModel model2 = service.getCustomModel(getOptions).execute().getResult();

    assertNotNull(model2);
    assertModelsEqual(model, model2);
    assertNotNull(model2.getOwner());
    assertNotNull(model2.getCreated());
    assertNotNull(model2.getLastModified());
  }

  /** Test get voice model. */
  @Test
  @Ignore
  public void testGetVoiceModelObject() {
    model = createCustomModel();
    GetCustomModelOptions getOptions =
        new GetCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
    final CustomModel model2 = service.getCustomModel(getOptions).execute().getResult();

    assertNotNull(model2);
    assertModelsEqual(model, model2);
    assertNotNull(model2.getOwner());
    assertNotNull(model2.getCreated());
    assertNotNull(model2.getLastModified());
  }

  /** Test get voice with customization. */
  @Test
  @Ignore
  public void testGetVoiceCustomization() {
    model = createCustomModel();
    GetCustomModelOptions getVoiceModelOptions =
        new GetCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
    final CustomModel model2 = service.getCustomModel(getVoiceModelOptions).execute().getResult();
    GetVoiceOptions getVoiceOptions =
        new GetVoiceOptions.Builder()
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

  /** Test update voice model with new name and ignored language change. */
  @Test
  @Ignore
  public void testUpdateVoiceModel() {
    final String newName = "new test";

    model = createCustomModel();
    GetCustomModelOptions getOptions =
        new GetCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
    model = service.getCustomModel(getOptions).execute().getResult();
    UpdateCustomModelOptions updateOptions =
        new UpdateCustomModelOptions.Builder()
            .customizationId(model.getCustomizationId())
            .name(newName)
            .build();
    service.updateCustomModel(updateOptions).execute().getResult();

    final CustomModel model2 = service.getCustomModel(getOptions).execute().getResult();
    assertModelsEqual(model, model2); // comparison at service
    assertEquals(model2.getLanguage(), MODEL_LANGUAGE); // value at service
  }

  /** Test update voice model with new name and new custom translations. */
  @Test
  @Ignore
  public void testUpdateVoiceModelWords() {
    final String newName = "new test";

    model = createCustomModel();
    GetCustomModelOptions getOptions =
        new GetCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
    model = service.getCustomModel(getOptions).execute().getResult();
    UpdateCustomModelOptions updateOptions =
        new UpdateCustomModelOptions.Builder()
            .customizationId(model.getCustomizationId())
            .name(newName)
            .words(instantiateWords())
            .build();
    service.updateCustomModel(updateOptions).execute().getResult();

    final CustomModel model2 = service.getCustomModel(getOptions).execute().getResult();
    assertModelsEqual(model, model2);
    assertNotEquals(model.getWords(), model2.getWords());
  }

  /** Test delete voice model. */
  @Test
  @Ignore
  public void testDeleteVoiceModel() {
    model = createCustomModel();

    DeleteCustomModelOptions deleteOptions =
        new DeleteCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
    service.deleteCustomModel(deleteOptions).execute();

    try {
      GetCustomModelOptions getOptions =
          new GetCustomModelOptions.Builder().customizationId(model.getCustomizationId()).build();
      service.getCustomModel(getOptions).execute().getResult();
      fail("deleting customization failed");
    } catch (UnauthorizedException e) {
      // success!
    }
  }

  /** Test list models. */
  @Test
  public void testListModels() {
    ListCustomModelsOptions listOptions =
        new ListCustomModelsOptions.Builder().language(MODEL_LANGUAGE).build();
    service.listCustomModels(listOptions);
    service.listCustomModels();
  }

  /** Test list models after create. */
  @Test
  @Ignore
  public void testListModelsAfterCreate() {
    model = createCustomModel();
    ListCustomModelsOptions listOptions =
        new ListCustomModelsOptions.Builder().language(model.getLanguage()).build();
    final CustomModels models = service.listCustomModels(listOptions).execute().getResult();
    CustomModel model2 = null;

    for (CustomModel m : models.getCustomizations()) {
      if (m.getCustomizationId().equals(model.getCustomizationId())) {
        model2 = m;
        break;
      }
    }

    assertNotNull(model2);
    assertModelsEqual(model, model2);
  }

  /** Test add word. */
  @Test
  @Ignore
  public void testAddWord() {
    model = createCustomModel();
    final Word expected = instantiateWords().get(0);

    AddWordOptions addOptions =
        new AddWordOptions.Builder()
            .word(expected.word())
            .translation(expected.translation())
            .customizationId(model.getCustomizationId())
            .build();
    service.addWord(addOptions).execute().getResult();

    ListWordsOptions listOptions =
        new ListWordsOptions.Builder().customizationId(model.getCustomizationId()).build();
    final Words results = service.listWords(listOptions).execute().getResult();
    assertEquals(1, results.words().size());

    final Word result = results.words().get(0);
    assertEquals(expected, result);
    assertEquals(expected.word(), result.word());
    assertEquals(expected.translation(), result.translation());
  }

  /** Test add words and list words. */
  @Test
  @Ignore
  public void testAddWords() {
    model = createCustomModel();
    final List<Word> expected = instantiateWords();

    AddWordsOptions addOptions =
        new AddWordsOptions.Builder()
            .customizationId(model.getCustomizationId())
            .words(expected)
            .build();
    service.addWords(addOptions).execute().getResult();

    ListWordsOptions listOptions =
        new ListWordsOptions.Builder().customizationId(model.getCustomizationId()).build();
    final Words words = service.listWords(listOptions).execute().getResult();
    assertEquals(expected.size(), words.words().size());
  }

  /** Test add words and list words for Japanese. */
  @Test
  @Ignore
  public void testAddWordsJapanese() {
    model = createVoiceModelJapanese();
    final List<Word> expected = instantiateWordsJapanese();

    AddWordsOptions addOptions =
        new AddWordsOptions.Builder()
            .customizationId(model.getCustomizationId())
            .words(expected)
            .build();
    service.addWords(addOptions).execute().getResult();

    ListWordsOptions listOptions =
        new ListWordsOptions.Builder().customizationId(model.getCustomizationId()).build();
    final Words words = service.listWords(listOptions).execute().getResult();
    assertEquals(expected.size(), words.words().size());
  }

  /** Test get word. */
  @Test
  @Ignore
  public void testGetWord() {
    model = createCustomModel();
    final List<Word> expected = instantiateWords();

    AddWordsOptions addOptions =
        new AddWordsOptions.Builder()
            .customizationId(model.getCustomizationId())
            .words(expected)
            .build();
    service.addWords(addOptions).execute().getResult();

    GetWordOptions getOptions =
        new GetWordOptions.Builder()
            .customizationId(model.getCustomizationId())
            .word(expected.get(0).word())
            .build();
    final Translation translation = service.getWord(getOptions).execute().getResult();
    assertEquals(expected.get(0).translation(), translation.translation());
  }

  /** Test get word for Japanese. */
  @Test
  @Ignore
  public void testGetWordJapanese() {
    model = createVoiceModelJapanese();
    final List<Word> expected = instantiateWordsJapanese();

    AddWordsOptions addOptions =
        new AddWordsOptions.Builder()
            .customizationId(model.getCustomizationId())
            .words(expected)
            .build();
    service.addWords(addOptions).execute().getResult();

    GetWordOptions getOptions =
        new GetWordOptions.Builder()
            .customizationId(model.getCustomizationId())
            .word(expected.get(0).word())
            .build();
    final Translation translation = service.getWord(getOptions).execute().getResult();
    assertEquals(expected.get(0).translation(), translation.translation());
    assertEquals(expected.get(0).partOfSpeech(), translation.partOfSpeech());
  }

  /** Test delete word with string. */
  @Test
  @Ignore
  public void testDeleteWord() {
    model = createCustomModel();
    final Word expected = instantiateWords().get(0);

    AddWordOptions addOptions =
        new AddWordOptions.Builder()
            .word(expected.word())
            .translation(expected.translation())
            .customizationId(model.getCustomizationId())
            .build();
    service.addWord(addOptions).execute().getResult();
    DeleteWordOptions deleteOptions =
        new DeleteWordOptions.Builder()
            .customizationId(model.getCustomizationId())
            .word(expected.word())
            .build();
    service.deleteWord(deleteOptions).execute();

    ListWordsOptions listOptions =
        new ListWordsOptions.Builder().customizationId(model.getCustomizationId()).build();
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
    model = createCustomModel();
    final Word expected = instantiateWords().get(0);

    AddWordOptions addOptions =
        new AddWordOptions.Builder()
            .word(expected.word())
            .translation(expected.translation())
            .customizationId(model.getCustomizationId())
            .build();
    service.addWord(addOptions).execute().getResult();
    SynthesizeOptions synthesizeOptions1 =
        new SynthesizeOptions.Builder()
            .text(expected.word())
            .voice(SynthesizeOptions.Voice.EN_US_MICHAELVOICE)
            .accept(HttpMediaType.AUDIO_WAV)
            .build();
    final InputStream stream1 = service.synthesize(synthesizeOptions1).execute().getResult();
    SynthesizeOptions synthesizeOptions2 =
        new SynthesizeOptions.Builder()
            .text(expected.word())
            .voice(SynthesizeOptions.Voice.EN_US_MICHAELVOICE)
            .accept(HttpMediaType.AUDIO_WAV)
            .customizationId(model.getCustomizationId())
            .build();
    final InputStream stream2 = service.synthesize(synthesizeOptions2).execute().getResult();

    assertFalse(TestUtils.streamContentEquals(stream1, stream2));
  }
}
