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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.DeleteModelOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ListModelsResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.MetadataOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The Class NaturalLanguageunderstandingTest.
 */
public class NaturalLanguageUnderstandingTest extends WatsonServiceUnitTest {
  private static final String MODELS_PATH = "/v1/models?version=2017-02-27";
  private static final String DELETE_PATH = "/v1/models/foo?version=2017-02-27";
  private static final String ANALYZE_PATH = "/v1/analyze?version=2017-02-27";
  private static final String RESOURCE = "src/test/resources/natural_language_understanding/";

  private ListModelsResults models;
  private AnalysisResults analyzeResults;
  private String modelId;
  private NaturalLanguageUnderstanding service;

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new NaturalLanguageUnderstanding("2017-02-27");
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());

    modelId = "foo";
    models = loadFixture(RESOURCE + "models.json", ListModelsResults.class);
    analyzeResults = loadFixture(RESOURCE + "analyze.json", AnalysisResults.class);
  }

  /**
   * Test analyze.
   *
   * @throws InterruptedException the interrupted exception
   * @throws FileNotFoundException
   */
  @Test
  public void testAnalyze() throws InterruptedException, FileNotFoundException {
    String testHtmlFileName = RESOURCE + "testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new ConceptsOptions.Builder()
        .limit(5)
        .build();
    assertEquals(concepts.limit(), 5, 0);
    concepts.newBuilder();

    Features features = new Features.Builder().concepts(concepts).build();
    AnalyzeOptions parameters = new AnalyzeOptions.Builder().html(html).features(features).build();

    server.enqueue(jsonResponse(analyzeResults));
    final AnalysisResults response = service.analyze(parameters).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ANALYZE_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(analyzeResults, response);
  }

  /**
   * Test analyze with null parameters. Test different constructor
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAnalyzeNullParams() throws InterruptedException {
    NaturalLanguageUnderstanding service1 = new NaturalLanguageUnderstanding("2017-02-27", "username", "password");
    service1.setApiKey("");
    service1.setEndPoint(getMockWebServerUrl());

    server.enqueue(jsonResponse(analyzeResults));
    Features features = new Features.Builder().concepts(null).categories(null).emotion(null)
        .entities(null).keywords(null).metadata(null).relations(null).semanticRoles(null).sentiment(null).build();
    AnalyzeOptions.Builder builder = new AnalyzeOptions.Builder().features(features);
    final AnalysisResults response = service1.analyze(builder.build()).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(ANALYZE_PATH, request.getPath());
    assertEquals("POST", request.getMethod());
    assertEquals(analyzeResults, response);
  }

  /**
   * Test some of the model constructors. pump up the code coverage numbers
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testModelOptions() throws InterruptedException {
    Features features = new Features.Builder().concepts(null).categories(null).emotion(null).entities(null).keywords(
        null).metadata(null).relations(null).semanticRoles(null).sentiment(null).build();

    // AnalyzeOptions
    AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text("text").html("html").url("url")
        .features(features).clean(true).xpath("xpath").fallbackToRaw(false).returnAnalyzedText(true)
        .language("language").build();
    assertEquals(analyzeOptions.text(), "text");
    assertEquals(analyzeOptions.html(), "html");
    assertEquals(analyzeOptions.url(), "url");
    assertEquals(analyzeOptions.features(), features);
    assertEquals(analyzeOptions.clean(), true);
    assertEquals(analyzeOptions.xpath(), "xpath");
    assertEquals(analyzeOptions.fallbackToRaw(), false);
    assertEquals(analyzeOptions.returnAnalyzedText(), true);
    assertEquals(analyzeOptions.language(), "language");
    analyzeOptions.newBuilder();

    // CategoriesOptions
    CategoriesOptions categoriesOptions = new CategoriesOptions();
    assertNotNull(categoriesOptions);

    // EmotionOptions
    List<String> emotionOptionsTargets = new ArrayList<>(Arrays.asList("target1", "target2"));
    EmotionOptions emotionOptions = new EmotionOptions.Builder()
        .document(true)
        .targets(emotionOptionsTargets)
        .addTargets("target3").build();
    emotionOptionsTargets.add("target3");
    assertEquals(emotionOptions.document(), true);
    assertEquals(emotionOptions.targets(), emotionOptionsTargets);
    emotionOptions.newBuilder();

    // EntitiesOptions
    EntitiesOptions entitiesOptions = new EntitiesOptions.Builder().emotion(true).limit(10).model("model").sentiment(
        false).mentions(false).build();
    assertEquals(entitiesOptions.emotion(), true);
    assertEquals(entitiesOptions.limit(), 10, 0);
    assertEquals(entitiesOptions.model(), "model");
    assertEquals(entitiesOptions.sentiment(), false);
    assertEquals(entitiesOptions.mentions(), false);
    entitiesOptions.newBuilder();

    // Features
    assertEquals(features.categories(), null);
    assertEquals(features.concepts(), null);
    assertEquals(features.emotion(), null);
    assertEquals(features.entities(), null);
    assertEquals(features.keywords(), null);
    assertEquals(features.metadata(), null);
    assertEquals(features.relations(), null);
    assertEquals(features.semanticRoles(), null);
    assertEquals(features.sentiment(), null);
    features.newBuilder();

    // KeywordsOptions
    KeywordsOptions keywordsOptions = new KeywordsOptions.Builder().emotion(true).limit(10).sentiment(false).build();
    assertEquals(keywordsOptions.emotion(), true);
    assertEquals(keywordsOptions.limit(), 10, 0);
    assertEquals(keywordsOptions.sentiment(), false);
    keywordsOptions.newBuilder();

    // MetadataOptions
    MetadataOptions metadataOptions = new MetadataOptions();
    assertNotNull(metadataOptions);

    // RelationsOptions
    RelationsOptions relationsOptions = new RelationsOptions.Builder().model("model").build();
    assertEquals(relationsOptions.model(), "model");
    relationsOptions.newBuilder();

    // SemanticRolesOptions
    SemanticRolesOptions semanticRolesOptions = new SemanticRolesOptions.Builder().entities(true).keywords(false).limit(
        10).build();
    assertEquals(semanticRolesOptions.entities(), true);
    assertEquals(semanticRolesOptions.keywords(), false);
    assertEquals(semanticRolesOptions.limit(), 10, 0);
    semanticRolesOptions.newBuilder();

    // SentimentOptions
    List<String> optionsTargets = new ArrayList<>(Arrays.asList("target1", "target2"));
    SentimentOptions sentimentOptions = new SentimentOptions.Builder()
        .document(true)
        .targets(optionsTargets)
        .addTargets("target3")
        .build();
    optionsTargets.add("target3");
    assertEquals(sentimentOptions.document(), true);
    assertEquals(sentimentOptions.targets(), optionsTargets);
    sentimentOptions.newBuilder();
  }

  /**
   * Test get models.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testListModels() throws InterruptedException {
    server.enqueue(jsonResponse(models));
    final ListModelsResults response = service.listModels().execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(MODELS_PATH, request.getPath());
    assertEquals("GET", request.getMethod());
    assertEquals(models, response);
  }

  /**
   * Test delete model.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDeleteModel() throws InterruptedException {
    server.enqueue(jsonResponse(null));
    DeleteModelOptions deleteOptions = new DeleteModelOptions.Builder(modelId).build();
    final Void response = service.deleteModel(deleteOptions).execute();
    final RecordedRequest request = server.takeRequest();

    assertEquals(DELETE_PATH, request.getPath());
    assertEquals("DELETE", request.getMethod());
    assertEquals(null, response);
  }

  // START NEGATIVE TESTS
  /**
   * Test delete model with a null model ID.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullModelId() {
    service.deleteModel(null).execute();
  }

  /**
   * Test constructor with null version.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullVersion() {
    @SuppressWarnings("unused")
    NaturalLanguageUnderstanding service2 = new NaturalLanguageUnderstanding(null);
  }

}
