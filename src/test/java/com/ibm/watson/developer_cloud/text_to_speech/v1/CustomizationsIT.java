package com.ibm.watson.developer_cloud.text_to_speech.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.VoiceModel;

public class CustomizationsIT extends WatsonServiceTest {

  private TextToSpeech ttsService;
  private Customizations service;

  private static final String MODEL_NAME = "test model";
  private static final String MODEL_LANGUAGE = "en-us";
  private static final String MODEL_DESCRIPTION = "a simple model for testing purposes";

  private VoiceModel model;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    ttsService = new TextToSpeech();
    ttsService.setUsernameAndPassword(
        getExistingProperty("text_to_speech.username"),
        getExistingProperty("text_to_speech.password"));
    ttsService.setEndPoint(getExistingProperty("text_to_speech.url"));
    ttsService.setDefaultHeaders(getDefaultHeaders());

    service = ttsService.getCustomizations();
  }

  private VoiceModel instantiateVoiceModel() {
    VoiceModel model = new VoiceModel();
    model.setName(MODEL_NAME);
    model.setDescription(MODEL_DESCRIPTION);
    model.setLanguage(MODEL_LANGUAGE);

    return model;
  }

  private VoiceModel createVoiceModel() {
    return service.saveVoiceModel(instantiateVoiceModel()).execute();
  }

  private void assertModelsEqual(VoiceModel a, VoiceModel b) {
    assertEquals(a.getId(), b.getId());
    assertEquals(a.getName(), b.getName());
    assertEquals(a.getDescription(), b.getDescription());
  }

  @After
  public void cleanUp() {
    if (model != null && model.getId() != null) {
      try {
        service.deleteVoiceModel(model).execute();
      } catch (Exception e) {

      }
    }
  }

  @Test
  public void testCreateVoiceModel() {
    model = createVoiceModel();

    assertNotNull(model.getId());
  }

  @Test
  public void testGetVoiceModel() {
    model = createVoiceModel();
    VoiceModel model2 = service.getVoiceModel(model.getId()).execute();

    assertNotNull(model2);
    assertModelsEqual(model, model2);
    assertNotNull(model2.getCreated());
    assertNotNull(model2.getOwner());
    assertNotNull(model2.getLastModified());
  }
  
  @Test
  public void testUpdateVoiceModel() {
    final String newName = "new test";
    
    model = createVoiceModel();
    model.setName(newName);
    service.saveVoiceModel(model).execute();
    
    VoiceModel model2 = service.getVoiceModel(model.getId()).execute();
    assertModelsEqual(model, model2);
  }

  @Test
  public void testDeleteVoiceModel() {
    model = createVoiceModel();

    service.deleteVoiceModel(model).execute();

    try {
      service.getVoiceModel(model.getId()).execute();
      fail("deleting customization failed");
    } catch (UnauthorizedException e) {
      // success!
    }
  }

  @Test
  public void testGetModels() {
    service.getVoiceModels(instantiateVoiceModel().getLanguage());
  }

  @Test
  public void testGetModelsAfterCreate() {
    model = createVoiceModel();
    List<VoiceModel> models = service.getVoiceModels(model.getLanguage()).execute();
    VoiceModel model2 = null;

    for (VoiceModel m : models) {
      if (m.getId().equals(model.getId())) {
        model2 = m;
        break;
      }
    }

    assertNotNull(model2);
    assertModelsEqual(model, model2);
  }

  private CustomTranslation instantiateCustomTranslation() {
    return new CustomTranslation("whip", "hwhip");
  }

  @Test
  public void testAddWord() {
    model = createVoiceModel();
    CustomTranslation word = instantiateCustomTranslation();
    
    service.saveWord(model, word).execute();

    List<CustomTranslation> words = service.getWords(model).execute();
    assertEquals(1, words.size());
    assertEquals(word, words.get(0));
  }

  @Test
  public void testRemoveWord() {
    model = createVoiceModel();
    CustomTranslation word = instantiateCustomTranslation();

    service.saveWord(model, word).execute();
    service.deleteWord(model, word).execute();

    List<CustomTranslation> words = service.getWords(model).execute();
    assertEquals(0, words.size());
  }

}