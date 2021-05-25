/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.natural_language_understanding.v1;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.common.RetryRunner;
import com.ibm.watson.common.WatsonServiceTest;
import com.ibm.watson.natural_language_understanding.v1.model.*;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.ibm.watson.natural_language_understanding.v1.utils.TestUtilities;
import org.junit.Assume;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

/** Natural Language Understanding integration tests. */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RetryRunner.class)
public class NaturalLanguageUnderstandingIT extends WatsonServiceTest {

  private NaturalLanguageUnderstanding service;
  private String text =
      "In 2009, Elliot Turner launched AlchemyAPI to process the written word,"
          + " with all of its quirks and nuances, and got immediate traction.";

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
    String apiKey = getProperty("natural_language_understanding.apikey");

    Assume.assumeFalse("config.properties doesn't have valid credentials.", apiKey == null);

    Authenticator authenticator = new IamAuthenticator(apiKey);
    service = new NaturalLanguageUnderstanding("2019-07-12", authenticator);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setServiceUrl(getProperty("natural_language_understanding.url"));
  }

  /**
   * Default test for HTML input.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeHtmlIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new ConceptsOptions.Builder().limit(5).build();

    Features features = new Features.Builder().concepts(concepts).build();
    AnalyzeOptions parameters = new AnalyzeOptions.Builder().html(html).features(features).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
  }

  /**
   * Default test for text input.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextIsSuccessful() throws Exception {
    ConceptsOptions concepts = new ConceptsOptions.Builder().limit(5).build();
    Features features = new Features.Builder().concepts(concepts).build();
    AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(text).features(features).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
  }

  /**
   * Default test for URL input.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeUrlIsSuccessful() throws Exception {
    String url = "http://www.politico.com/story/2016/07/dnc-2016-obama-prepared-remarks-226345";

    ConceptsOptions concepts = new ConceptsOptions.Builder().limit(5).build();
    Features features = new Features.Builder().concepts(concepts).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().url(url).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
  }

  /**
   * Analyze given test input text for concepts.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForConceptsIsSuccessful() throws Exception {
    String text =
        "In remote corners of the world, citizens are demanding respect"
            + " for the dignity of all people no matter their gender, or race, or religion, or disability,"
            + " or sexual orientation, and those who deny others dignity are subject to public reproach."
            + " An explosion of social media has given ordinary people more ways to express themselves,"
            + " and has raised people's expectations for those of us in power. Indeed, our international"
            + " order has been so successful that we take it as a given that great powers no longer"
            + " fight world wars; that the end of the Cold War lifted the shadow of nuclear Armageddon;"
            + " that the battlefields of Europe have been replaced by peaceful union; that China and India"
            + " remain on a path of remarkable growth.";

    ConceptsOptions concepts = new ConceptsOptions.Builder().limit(5).build();
    Features features = new Features.Builder().concepts(concepts).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
    assertNotNull(results.getConcepts());
    for (ConceptsResult concept : results.getConcepts()) {
      assertNotNull(concept.getText());
      assertNotNull(concept.getDbpediaResource());
      assertNotNull(concept.getRelevance());
    }
  }

  /**
   * Analyze test HTML for concepts.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeHtmlForConceptsIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new ConceptsOptions.Builder().build();
    Features features = new Features.Builder().concepts(concepts).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().html(html).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
    assertNotNull(results.getConcepts());
    for (ConceptsResult concept : results.getConcepts()) {
      assertNotNull(concept.getText());
      assertNotNull(concept.getDbpediaResource());
      assertNotNull(concept.getRelevance());
    }
  }

  /**
   * Analyze input text for emotions without targets.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForEmotionsWithoutTargetsIsSuccessful() throws Exception {
    String text =
        "But I believe this thinking is wrong. I believe the road of true democracy remains the better path."
            + " I believe that in the 21st century, economies can only grow to a certain point until they"
            + " need to open up"
            + " -- because entrepreneurs need to access information in order to invent; young people need"
            + " a global"
            + " education in order to thrive; independent media needs to check the abuses of power.";

    EmotionOptions emotion = new EmotionOptions.Builder().build();
    Features features = new Features.Builder().emotion(emotion).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
    assertNotNull(results.getEmotion());
    assertNotNull(results.getEmotion().getDocument());
    assertNotNull(results.getEmotion().getDocument().getEmotion());

    EmotionScores scores = results.getEmotion().getDocument().getEmotion();
    assertNotNull(scores.getAnger());
    assertNotNull(scores.getDisgust());
    assertNotNull(scores.getFear());
    assertNotNull(scores.getJoy());
    assertNotNull(scores.getSadness());

    assertNull(results.getEmotion().getTargets());
  }

  /**
   * Analyze input text for entities.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForEntitiesIsSuccessful() throws Exception {
    String text =
        "In 2009, Elliot Turner launched AlchemyAPI to process the written word, with all of its quirks "
            + "and nuances, and got immediate traction.";

    EntitiesOptions entities = new EntitiesOptions.Builder().limit(2).sentiment(true).build();

    Features features = new Features.Builder().entities(entities).build();

    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertNotNull(results.getEntities());
    assertTrue(results.getEntities().size() <= 2);

    for (EntitiesResult result : results.getEntities()) {
      assertNotNull(result.getCount());
      assertNotNull(result.getRelevance());
      assertNotNull(result.getText());
      assertNotNull(result.getType());
      assertNotNull(result.getSentiment());
    }
  }

  /**
   * Analyze input text for keywords.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForKeywordsIsSuccessful() throws Exception {
    KeywordsOptions keywords = new KeywordsOptions.Builder().sentiment(true).build();
    Features features = new Features.Builder().keywords(keywords).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertNotNull(results.getKeywords());

    for (KeywordsResult result : results.getKeywords()) {
      assertNotNull(result.getRelevance());
      assertNotNull(result.getText());
      assertNotNull(result.getSentiment());
    }
  }

  /**
   * Analyze html input for metadata.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeHtmlForMetadataIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));
    String fileTitle = "This 5,000-year-old recipe for beer actually sounds pretty tasty";
    String fileDate = "2016-05-23T20:13:00";
    String fileAuthor = "Annalee Newitz";
    Features features = new Features.Builder().metadata(new HashMap<String, Object>()).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().html(html).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getMetadata());
    FeaturesResultsMetadata result = results.getMetadata();
    assertNotNull(result.getTitle());
    assertEquals(result.getTitle(), fileTitle);
    assertNotNull(result.getPublicationDate());
    assertEquals(result.getPublicationDate(), fileDate);
    assertNotNull(result.getAuthors());
    List<Author> authors = result.getAuthors();
    assertEquals(authors.size(), 1);
    assertEquals(authors.get(0).getName(), fileAuthor);
  }

  /**
   * Analyze input text for relations.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForRelationsIsSuccessful() throws Exception {
    Features features =
        new Features.Builder().relations(new RelationsOptions.Builder().build()).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getRelations());
  }

  /**
   * Analyze input text for semantic roles.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForSemanticRolesIsSuccessful() throws Exception {
    SemanticRolesOptions options =
        new SemanticRolesOptions.Builder().limit(7).keywords(true).entities(true).build();

    Features features = new Features.Builder().semanticRoles(options).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getSemanticRoles());
    for (SemanticRolesResult result : results.getSemanticRoles()) {
      assertEquals(result.getSentence(), text);
      if (result.getSubject() != null) {
        assertNotNull(result.getSubject().getText());
      }
      if (result.getAction() != null) {
        assertNotNull(result.getAction().getText());
      }
      if (result.getObject() != null) {
        assertNotNull(result.getObject().getText());
      }
    }
  }

  /**
   * Analyze input text for sentiment with targets.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForSentimentWithTargetsIsSuccessful() throws Exception {
    SentimentOptions options =
        new SentimentOptions.Builder()
            .document(true)
            .targets(Arrays.asList("Elliot Turner", "traction"))
            .build();
    Features features = new Features.Builder().sentiment(options).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getSentiment());
    assertNotNull(results.getSentiment().getDocument());
    assertNotNull(results.getSentiment().getDocument().getScore());
    assertNotNull(results.getSentiment().getTargets());
    for (TargetedSentimentResults result : results.getSentiment().getTargets()) {
      assertNotNull(result.getText());
      assertNotNull(result.getScore());
    }
  }

  /**
   * Analyze input text for sentiment without targets.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForSentimentWithoutTargetsIsSuccessful() throws Exception {
    SentimentOptions options = new SentimentOptions.Builder().document(true).build();
    Features features = new Features.Builder().sentiment(options).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getSentiment());
    assertNotNull(results.getSentiment().getDocument());
    assertNotNull(results.getSentiment().getDocument().getScore());
    assertNull(results.getSentiment().getTargets());
  }

  /**
   * Analyze input text for categories.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextForCategoriesIsSuccessful() throws Exception {
    Features features =
        new Features.Builder().categories(new CategoriesOptions.Builder().build()).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getCategories());
    for (CategoriesResult result : results.getCategories()) {
      assertNotNull(result.getLabel());
      assertNotNull(result.getScore());
    }
  }

  /**
   * Analyze html for disambiguation.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeHtmlForDisambiguationIsSuccessful() throws Exception {
    EntitiesOptions entities = new EntitiesOptions.Builder().sentiment(true).limit(1).build();
    Features features = new Features.Builder().entities(entities).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder().url("www.cnn.com").features(features).build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getEntities());
    assertTrue(results.getEntities().size() == 1);
    for (EntitiesResult result : results.getEntities()) {
      assertNotNull(result.getDisambiguation());
      assertEquals(result.getDisambiguation().getName(), "CNN");
      assertEquals(
          result.getDisambiguation().getDbpediaResource(), "http://dbpedia.org/resource/CNN");
      assertNotNull(result.getDisambiguation().getSubtype());
      assertTrue(result.getDisambiguation().getSubtype().size() > 0);
    }
  }

  /**
   * Analyze text while setting a character limit on the analyzed passage.
   *
   * @throws Exception the exception
   */
  @Test
  public void analyzeTextWithCharacterLimitIsSuccessful() throws Exception {
    String text =
        "But I believe this thinking is wrong. I believe the road of true democracy remains the better path."
            + " I believe that in the 21st century, economies can only grow to a certain "
            + "point until they need to open up"
            + " -- because entrepreneurs need to access information in order to invent; young people need a global"
            + " education in order to thrive; independent media needs to check the abuses of power.";

    Long characterLimit = 10L;
    Features features =
        new Features.Builder().categories(new CategoriesOptions.Builder().build()).build();
    AnalyzeOptions parameters =
        new AnalyzeOptions.Builder()
            .text(text)
            .features(features)
            .returnAnalyzedText(true)
            .limitTextCharacters(characterLimit)
            .build();

    AnalysisResults results = service.analyze(parameters).execute().getResult();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
    assertTrue(results.getAnalyzedText().length() == characterLimit);
  }

  /**
   * Test createSentimentModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testCreateSentimentModel() throws Exception {
    // Construct an instance of the CreateSentimentModelOptions model
    CreateSentimentModelOptions createSentimentModelOptionsModel =
        new CreateSentimentModelOptions.Builder()
            .language("en")
            .trainingData(TestUtilities.createMockStream("This is a mock file."))
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .versionDescription("testString")
            .build();
    SentimentModel response =
        service.createSentimentModel(createSentimentModelOptionsModel).execute().getResult();
    assertEquals(response.getName(), "testString");
    assertEquals(response.getLanguage(), "en");
    assertEquals(response.getDescription(), "testString");
    assertEquals(response.getModelVersion(), "testString");
    assertEquals(response.getVersionDescription(), "testString");

    DeleteSentimentModelOptions deleteSentimentModelOptionsModel =
        new DeleteSentimentModelOptions.Builder().modelId(response.getModelId()).build();
    DeleteModelResults deleteModelResults =
        service.deleteSentimentModel(deleteSentimentModelOptionsModel).execute().getResult();
  }

  /**
   * Test listSentimentModels service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testListSentimentModels() throws Exception {
    ListSentimentModelsResponse response = service.listSentimentModels().execute().getResult();
    assertNotNull(response.getModels());

    for (SentimentModel sentimentModel : response.getModels()) {
      if (sentimentModel.getName().startsWith("testString")) {
        DeleteSentimentModelOptions deleteSentimentModelOptionsModel =
            new DeleteSentimentModelOptions.Builder().modelId(sentimentModel.getModelId()).build();
        DeleteModelResults deleteModelResults =
            service.deleteSentimentModel(deleteSentimentModelOptionsModel).execute().getResult();
      }
    }
  }

  /**
   * Test updateSentimentModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testUpdateSentimentModel() throws Exception {
    String modelId = "";
    try {
      // Construct an instance of the CreateSentimentModelOptions model
      CreateSentimentModelOptions createSentimentModelOptionsModel =
          new CreateSentimentModelOptions.Builder()
              .language("en")
              .trainingData(TestUtilities.createMockStream("This is a mock file."))
              .name("testString")
              .description("testString")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      SentimentModel response =
          service.createSentimentModel(createSentimentModelOptionsModel).execute().getResult();
      modelId = response.getModelId();
      assertEquals(response.getName(), "testString");
      assertEquals(response.getLanguage(), "en");
      assertEquals(response.getDescription(), "testString");
      assertEquals(response.getModelVersion(), "testString");
      assertEquals(response.getVersionDescription(), "testString");

      UpdateSentimentModelOptions updateSentimentModelOptions =
          new UpdateSentimentModelOptions.Builder()
              .description("newDescription")
              .name("newName")
              .modelId(response.getModelId())
              .language("en")
              .trainingData(TestUtilities.createMockStream("This is a mock file."))
              .build();
      SentimentModel response2 =
          service.updateSentimentModel(updateSentimentModelOptions).execute().getResult();

      assertEquals(response2.getName(), "newName");
      assertEquals(response2.getLanguage(), "en");
      assertEquals(response2.getDescription(), "newDescription");
      assertEquals(response2.getModelVersion(), "testString");
      assertEquals(response2.getVersionDescription(), "testString");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (modelId != "") {
        DeleteSentimentModelOptions deleteSentimentModelOptionsModel =
            new DeleteSentimentModelOptions.Builder().modelId(modelId).build();
        DeleteModelResults deleteModelResults =
            service.deleteSentimentModel(deleteSentimentModelOptionsModel).execute().getResult();
      }
    }
  }

  /**
   * Test getSentimentModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetSentimentModel() throws Exception {
    String modelId = "";
    try {
      // Construct an instance of the CreateSentimentModelOptions model
      CreateSentimentModelOptions createSentimentModelOptionsModel =
          new CreateSentimentModelOptions.Builder()
              .language("en")
              .trainingData(TestUtilities.createMockStream("This is a mock file."))
              .name("testString")
              .description("testString")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      SentimentModel response =
          service.createSentimentModel(createSentimentModelOptionsModel).execute().getResult();
      modelId = response.getModelId();
      assertEquals(response.getName(), "testString");
      assertEquals(response.getLanguage(), "en");
      assertEquals(response.getDescription(), "testString");
      assertEquals(response.getModelVersion(), "testString");
      assertEquals(response.getVersionDescription(), "testString");

      GetSentimentModelOptions getSentimentModelOptionsModel =
          new GetSentimentModelOptions.Builder().modelId(response.getModelId()).build();
      SentimentModel response2 =
          service.getSentimentModel(getSentimentModelOptionsModel).execute().getResult();

      assertEquals(response2.getName(), "testString");
      assertEquals(response2.getLanguage(), "en");
      assertEquals(response2.getDescription(), "testString");
      assertEquals(response2.getModelVersion(), "testString");
      assertEquals(response2.getVersionDescription(), "testString");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (modelId != "") {
        DeleteSentimentModelOptions deleteSentimentModelOptionsModel =
            new DeleteSentimentModelOptions.Builder().modelId(modelId).build();
        DeleteModelResults deleteModelResults =
            service.deleteSentimentModel(deleteSentimentModelOptionsModel).execute().getResult();
      }
    }
  }

  /**
   * Test createCategoriesModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testCreateCategoriesModel() throws Exception {
    // Construct an instance of the CreateCategoriesModelOptions model
    CreateCategoriesModelOptions createCategoriesModelOptionsModel =
        new CreateCategoriesModelOptions.Builder()
            .language("en")
            .trainingData(
                TestUtilities.createMockStream(
                    "[\n"
                        + "       {\n"
                        + "           \"labels\": [\n"
                        + "               \"level1\"\n"
                        + "           ],\n"
                        + "           \"key_phrases\": [\n"
                        + "               \"key phrase\",\n"
                        + "               \"key phrase 2\"\n"
                        + "           ]\n"
                        + "       },\n"
                        + "       {\n"
                        + "           \"labels\": [\n"
                        + "               \"level1\",\n"
                        + "               \"level2\"\n"
                        + "           ],\n"
                        + "           \"key_phrases\": [\n"
                        + "               \"key phrase 3\",\n"
                        + "               \"key phrase 4\"\n"
                        + "           ]\n"
                        + "       }\n"
                        + "   ]"))
            .trainingDataContentType("application/json")
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .versionDescription("testString")
            .build();
    CategoriesModel response =
        service.createCategoriesModel(createCategoriesModelOptionsModel).execute().getResult();
    assertEquals(response.getName(), "testString");
    assertEquals(response.getLanguage(), "en");
    assertEquals(response.getDescription(), "testString");
    assertEquals(response.getModelVersion(), "testString");
    assertEquals(response.getVersionDescription(), "testString");

    DeleteCategoriesModelOptions deleteCategoriesModelOptions =
        new DeleteCategoriesModelOptions.Builder().modelId(response.getModelId()).build();
    DeleteModelResults deleteModelResults =
        service.deleteCategoriesModel(deleteCategoriesModelOptions).execute().getResult();
  }
  /**
   * Test listCategoriesModels service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testListCategoriesModels() throws Exception {
    ListCategoriesModelsResponse response = service.listCategoriesModels().execute().getResult();
    assertNotNull(response.getModels());

    for (CategoriesModelList categoriesModelList : response.getModels()) {
      if (categoriesModelList.getModels() != null) {
        for (CategoriesModel categoriesModel : categoriesModelList.getModels()) {
          if (categoriesModel.getName().startsWith("testString")) {
            DeleteCategoriesModelOptions deleteCategoriesModelOptions =
                new DeleteCategoriesModelOptions.Builder()
                    .modelId(categoriesModel.getModelId())
                    .build();
            DeleteModelResults deleteModelResults =
                service.deleteCategoriesModel(deleteCategoriesModelOptions).execute().getResult();
          }
        }
      }
    }
  }

  /**
   * Test updateCategoriesModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testUpdateCategoriesModel() throws Exception {
    String modelId = "";
    try {
      // Construct an instance of the CreateCategoriesModelOptions model
      CreateCategoriesModelOptions createCategoriesModelOptionsModel =
          new CreateCategoriesModelOptions.Builder()
              .language("en")
              .trainingData(
                  TestUtilities.createMockStream(
                      "[\n"
                          + "       {\n"
                          + "           \"labels\": [\n"
                          + "               \"level1\"\n"
                          + "           ],\n"
                          + "           \"key_phrases\": [\n"
                          + "               \"key phrase\",\n"
                          + "               \"key phrase 2\"\n"
                          + "           ]\n"
                          + "       },\n"
                          + "       {\n"
                          + "           \"labels\": [\n"
                          + "               \"level1\",\n"
                          + "               \"level2\"\n"
                          + "           ],\n"
                          + "           \"key_phrases\": [\n"
                          + "               \"key phrase 3\",\n"
                          + "               \"key phrase 4\"\n"
                          + "           ]\n"
                          + "       }\n"
                          + "   ]"))
              .trainingDataContentType("application/json")
              .name("testString")
              .description("testString")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      CategoriesModel response =
          service.createCategoriesModel(createCategoriesModelOptionsModel).execute().getResult();
      assertEquals(response.getName(), "testString");
      assertEquals(response.getLanguage(), "en");
      assertEquals(response.getDescription(), "testString");
      assertEquals(response.getModelVersion(), "testString");
      assertEquals(response.getVersionDescription(), "testString");

      modelId = response.getModelId();
      // Construct an instance of the UpdateCategoriesModelOptions model
      UpdateCategoriesModelOptions updateCategoriesModelOptionsModel =
          new UpdateCategoriesModelOptions.Builder()
              .language("en")
              .trainingData(
                  TestUtilities.createMockStream(
                      "[\n"
                          + "       {\n"
                          + "           \"labels\": [\n"
                          + "               \"level1\"\n"
                          + "           ],\n"
                          + "           \"key_phrases\": [\n"
                          + "               \"key phrase\",\n"
                          + "               \"key phrase 2\"\n"
                          + "           ]\n"
                          + "       },\n"
                          + "       {\n"
                          + "           \"labels\": [\n"
                          + "               \"level1\",\n"
                          + "               \"level2\"\n"
                          + "           ],\n"
                          + "           \"key_phrases\": [\n"
                          + "               \"key phrase 3\",\n"
                          + "               \"key phrase 4\"\n"
                          + "           ]\n"
                          + "       }\n"
                          + "   ]"))
              .trainingDataContentType("application/json")
              .name("newName")
              .description("newDescription")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      CategoriesModel response2 =
          service.updateCategoriesModel(updateCategoriesModelOptionsModel).execute().getResult();

      assertEquals(response2.getName(), "newName");
      assertEquals(response2.getLanguage(), "en");
      assertEquals(response2.getDescription(), "newDescription");
      assertEquals(response2.getModelVersion(), "testString");
      assertEquals(response2.getVersionDescription(), "testString");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (modelId != "") {
        DeleteCategoriesModelOptions deleteCategoriesModelOptions =
            new DeleteCategoriesModelOptions.Builder().modelId(modelId).build();
        DeleteModelResults deleteModelResults =
            service.deleteCategoriesModel(deleteCategoriesModelOptions).execute().getResult();
      }
    }
  }
  /**
   * Test getCategoriesModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetCategoriesModel() throws Exception {
    String modelId = "";
    try {
      // Construct an instance of the CreateCategoriesModelOptions model
      CreateCategoriesModelOptions createCategoriesModelOptionsModel =
          new CreateCategoriesModelOptions.Builder()
              .language("en")
              .trainingData(
                  TestUtilities.createMockStream(
                      "[\n"
                          + "       {\n"
                          + "           \"labels\": [\n"
                          + "               \"level1\"\n"
                          + "           ],\n"
                          + "           \"key_phrases\": [\n"
                          + "               \"key phrase\",\n"
                          + "               \"key phrase 2\"\n"
                          + "           ]\n"
                          + "       },\n"
                          + "       {\n"
                          + "           \"labels\": [\n"
                          + "               \"level1\",\n"
                          + "               \"level2\"\n"
                          + "           ],\n"
                          + "           \"key_phrases\": [\n"
                          + "               \"key phrase 3\",\n"
                          + "               \"key phrase 4\"\n"
                          + "           ]\n"
                          + "       }\n"
                          + "   ]"))
              .trainingDataContentType("application/json")
              .name("testString")
              .description("testString")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      CategoriesModel response =
          service.createCategoriesModel(createCategoriesModelOptionsModel).execute().getResult();
      assertEquals(response.getName(), "testString");
      assertEquals(response.getLanguage(), "en");
      assertEquals(response.getDescription(), "testString");
      assertEquals(response.getModelVersion(), "testString");
      assertEquals(response.getVersionDescription(), "testString");

      modelId = response.getModelId();

      GetCategoriesModelOptions getCategoriesModelOptions =
          new GetCategoriesModelOptions.Builder().modelId(response.getModelId()).build();
      CategoriesModel response2 =
          service.getCategoriesModel(getCategoriesModelOptions).execute().getResult();

      assertEquals(response2.getName(), "testString");
      assertEquals(response2.getLanguage(), "en");
      assertEquals(response2.getDescription(), "testString");
      assertEquals(response2.getModelVersion(), "testString");
      assertEquals(response2.getVersionDescription(), "testString");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (modelId != "") {
        DeleteCategoriesModelOptions deleteCategoriesModelOptions =
            new DeleteCategoriesModelOptions.Builder().modelId(modelId).build();
        DeleteModelResults deleteModelResults =
            service.deleteCategoriesModel(deleteCategoriesModelOptions).execute().getResult();
      }
    }
  }
  /**
   * Test createClassification service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testCreateClassificationModel() throws Exception {
    // Construct an instance of the CreateClassificationsModelOptions model
    CreateClassificationsModelOptions createClassificationsModelOptionsModel =
        new CreateClassificationsModelOptions.Builder()
            .language("en")
            .trainingData(
                TestUtilities.createMockStream(
                    "[\n"
                        + "    {\n"
                        + "        \"text\": \"How hot is it today?\",\n"
                        + "        \"labels\": [\"temperature\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Is it hot outside?\",\n"
                        + "        \"labels\": [\"temperature\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Will it be uncomfortably hot?\",\n"
                        + "        \"labels\": [\"temperature\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Will it be sweltering?\",\n"
                        + "        \"labels\": [\"temperature\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"How cold is it today?\",\n"
                        + "        \"labels\": [\"temperature\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Will we get snow?\",\n"
                        + "        \"labels\": [\"conditions\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Are we expecting sunny conditions?\",\n"
                        + "        \"labels\": [\"conditions\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Is it overcast?\",\n"
                        + "        \"labels\": [\"conditions\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"Will it be cloudy?\",\n"
                        + "        \"labels\": [\"conditions\"]\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"text\": \"How much rain will fall today?\",\n"
                        + "        \"labels\": [\"conditions\"]\n"
                        + "    }\n"
                        + "]"))
            .trainingDataContentType("application/json")
            .name("testString")
            .description("testString")
            .modelVersion("testString")
            .versionDescription("testString")
            .build();
    ClassificationsModel response =
        service
            .createClassificationsModel(createClassificationsModelOptionsModel)
            .execute()
            .getResult();
    assertEquals(response.getName(), "testString");
    assertEquals(response.getLanguage(), "en");
    assertEquals(response.getDescription(), "testString");
    assertEquals(response.getModelVersion(), "testString");
    assertEquals(response.getVersionDescription(), "testString");

    DeleteClassificationsModelOptions deleteClassificationsModelOptions =
        new DeleteClassificationsModelOptions.Builder().modelId(response.getModelId()).build();
    DeleteModelResults deleteModelResults =
        service.deleteClassificationsModel(deleteClassificationsModelOptions).execute().getResult();
  }
  /**
   * Test listClassificationModels service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testListClassificationModels() throws Exception {
    ListClassificationsModelsResponse response =
        service.listClassificationsModels().execute().getResult();
    assertNotNull(response.getModels());

    for (ClassificationsModelList classificationsModelList : response.getModels()) {
      if (classificationsModelList.getModels() != null) {
        for (ClassificationsModel classificationsModel : classificationsModelList.getModels()) {
          if (classificationsModel.getName().startsWith("testString")) {
            DeleteClassificationsModelOptions deleteClassificationsModelOptions =
                new DeleteClassificationsModelOptions.Builder()
                    .modelId(classificationsModel.getModelId())
                    .build();
            DeleteModelResults deleteModelResults =
                service
                    .deleteClassificationsModel(deleteClassificationsModelOptions)
                    .execute()
                    .getResult();
          }
        }
      }
    }
  }
  /**
   * Test updateClassificationModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testUpdateClassificationModel() throws Exception {
    String modelId = "";
    try {
      // Construct an instance of the CreateClassificationsModelOptions model
      CreateClassificationsModelOptions createClassificationsModelOptionsModel =
          new CreateClassificationsModelOptions.Builder()
              .language("en")
              .trainingData(
                  TestUtilities.createMockStream(
                      "[\n"
                          + "    {\n"
                          + "        \"text\": \"How hot is it today?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Is it hot outside?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be uncomfortably hot?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be sweltering?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"How cold is it today?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will we get snow?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Are we expecting sunny conditions?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Is it overcast?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be cloudy?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"How much rain will fall today?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    }\n"
                          + "]"))
              .trainingDataContentType("application/json")
              .name("testString")
              .description("testString")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      ClassificationsModel response =
          service
              .createClassificationsModel(createClassificationsModelOptionsModel)
              .execute()
              .getResult();
      assertEquals(response.getName(), "testString");
      assertEquals(response.getLanguage(), "en");
      assertEquals(response.getDescription(), "testString");
      assertEquals(response.getModelVersion(), "testString");
      assertEquals(response.getVersionDescription(), "testString");

      modelId = response.getModelId();
      // Construct an instance of the UpdateCategoriesModelOptions model
      UpdateClassificationsModelOptions updateClassificationsModelOptions =
          new UpdateClassificationsModelOptions.Builder()
              .language("en")
              .trainingData(
                  TestUtilities.createMockStream(
                      "[\n"
                          + "    {\n"
                          + "        \"text\": \"How hot is it today?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Is it hot outside?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be uncomfortably hot?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be sweltering?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"How cold is it today?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will we get snow?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Are we expecting sunny conditions?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Is it overcast?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be cloudy?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"How much rain will fall today?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    }\n"
                          + "]"))
              .trainingDataContentType("application/json")
              .name("newName")
              .description("newDescription")
              .modelVersion("testString")
              .versionDescription("testString")
              .modelId(modelId)
              .build();
      ClassificationsModel response2 =
          service
              .updateClassificationsModel(updateClassificationsModelOptions)
              .execute()
              .getResult();

      assertEquals(response2.getName(), "newName");
      assertEquals(response2.getLanguage(), "en");
      assertEquals(response2.getDescription(), "newDescription");
      assertEquals(response2.getModelVersion(), "testString");
      assertEquals(response2.getVersionDescription(), "testString");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (modelId != "") {
        DeleteClassificationsModelOptions deleteClassificationsModelOptions =
            new DeleteClassificationsModelOptions.Builder().modelId(modelId).build();
        DeleteModelResults deleteModelResults =
            service
                .deleteClassificationsModel(deleteClassificationsModelOptions)
                .execute()
                .getResult();
      }
    }
  }
  /**
   * Test getClassificationModel service call
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetClassificationModel() throws Exception {
    String modelId = "";
    try {
      // Construct an instance of the CreateClassificationsModelOptions model
      CreateClassificationsModelOptions createClassificationsModelOptionsModel =
          new CreateClassificationsModelOptions.Builder()
              .language("en")
              .trainingData(
                  TestUtilities.createMockStream(
                      "[\n"
                          + "    {\n"
                          + "        \"text\": \"How hot is it today?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Is it hot outside?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be uncomfortably hot?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be sweltering?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"How cold is it today?\",\n"
                          + "        \"labels\": [\"temperature\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will we get snow?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Are we expecting sunny conditions?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Is it overcast?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"Will it be cloudy?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    },\n"
                          + "    {\n"
                          + "        \"text\": \"How much rain will fall today?\",\n"
                          + "        \"labels\": [\"conditions\"]\n"
                          + "    }\n"
                          + "]"))
              .trainingDataContentType("application/json")
              .name("testString")
              .description("testString")
              .modelVersion("testString")
              .versionDescription("testString")
              .build();
      ClassificationsModel response =
          service
              .createClassificationsModel(createClassificationsModelOptionsModel)
              .execute()
              .getResult();
      assertEquals(response.getName(), "testString");
      assertEquals(response.getLanguage(), "en");
      assertEquals(response.getDescription(), "testString");
      assertEquals(response.getModelVersion(), "testString");
      assertEquals(response.getVersionDescription(), "testString");

      modelId = response.getModelId();

      GetClassificationsModelOptions getClassificationsModelOptions =
          new GetClassificationsModelOptions.Builder().modelId(response.getModelId()).build();
      ClassificationsModel response2 =
          service.getClassificationsModel(getClassificationsModelOptions).execute().getResult();

      assertEquals(response2.getName(), "testString");
      assertEquals(response2.getLanguage(), "en");
      assertEquals(response2.getDescription(), "testString");
      assertEquals(response2.getModelVersion(), "testString");
      assertEquals(response2.getVersionDescription(), "testString");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (modelId != "") {
        DeleteClassificationsModelOptions deleteClassificationsModelOptions =
            new DeleteClassificationsModelOptions.Builder().modelId(modelId).build();
        DeleteModelResults deleteModelResults =
            service
                .deleteClassificationsModel(deleteClassificationsModelOptions)
                .execute()
                .getResult();
      }
    }
  }
}
