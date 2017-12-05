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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.DisambiguationResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntityMention;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Author;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.DeleteModelOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.DocumentEmotionResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.DocumentSentimentResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionScores;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.FeatureSentimentResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ListModelsResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.MetadataOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.MetadataResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Model;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationArgument;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationEntity;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesAction;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesEntity;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesKeyword;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesObject;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesSubject;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesVerb;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.TargetedEmotionResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.TargetedSentimentResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Usage;

import okhttp3.mockwebserver.RecordedRequest;

/**
 * The Class NaturalLanguageunderstandingTest.
 */
public class NaturalLanguageUnderstandingTest extends WatsonServiceUnitTest {
  private static final String MODELS_PATH = "/v1/models?version="
      + NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27;
  private static final String DELETE_PATH = "/v1/models/foo?version="
      + NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27;
  private static final String ANALYZE_PATH = "/v1/analyze?version="
      + NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27;
  private static final String RESOURCE = "src/test/resources/natural_language_understanding/";

  private ListModelsResults models;
  private AnalysisResults analyzeResults;
  private String modelId;
  private NaturalLanguageUnderstanding service;

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
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
   * Test analyze with null parameters.  Test different constructor
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testAnalyzeNullParams() throws InterruptedException {
    NaturalLanguageUnderstanding service1 = new NaturalLanguageUnderstanding(
        NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27, "username", "password");
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
  public void testModelOptions1() throws InterruptedException {
    Features features = new Features.Builder().concepts(null).categories(null).emotion(null).
        entities(null).keywords(null).metadata(null).relations(null).semanticRoles(null).sentiment(null).build();

    // AnalysisResults
    ConceptsResult addConcept = new ConceptsResult();
    EntitiesResult addEntity = new EntitiesResult();
    KeywordsResult addKeyword = new KeywordsResult();
    CategoriesResult addCategory = new CategoriesResult();
    RelationsResult addRelation = new RelationsResult();
    SemanticRolesResult addRole = new SemanticRolesResult();
    List<ConceptsResult> concepts = new ArrayList<ConceptsResult>();
    concepts.add(addConcept);
    List<EntitiesResult> entities = new ArrayList<EntitiesResult>();
    entities.add(addEntity);
    List<KeywordsResult> keywords = new ArrayList<KeywordsResult>();
    keywords.add(addKeyword);
    List<CategoriesResult> categories = new ArrayList<CategoriesResult>();
    categories.add(addCategory);
    List<RelationsResult> relations = new ArrayList<RelationsResult>();
    relations.add(addRelation);
    List<SemanticRolesResult> semanticRoles = new ArrayList<SemanticRolesResult>();
    semanticRoles.add(addRole);
    AnalysisResults analysisResults = new AnalysisResults();
    analysisResults.setAnalyzedText("Analyzed");
    analysisResults.setCategories(categories);
    analysisResults.setConcepts(concepts);
    analysisResults.setEmotion(null);
    analysisResults.setEntities(entities);
    analysisResults.setKeywords(keywords);
    analysisResults.setLanguage("English");
    analysisResults.setMetadata(null);
    analysisResults.setRelations(relations);
    analysisResults.setRetrievedUrl("URL");
    analysisResults.setSemanticRoles(semanticRoles);
    analysisResults.setSentiment(null);
    analysisResults.setUsage(null);
    assertEquals(analysisResults.getAnalyzedText(), "Analyzed");
    assertEquals(analysisResults.getCategories().size(), 1);
    assertEquals(analysisResults.getConcepts().size(), 1);
    assertEquals(analysisResults.getEmotion(), null);
    assertEquals(analysisResults.getEntities().size(), 1);
    assertEquals(analysisResults.getKeywords().size(), 1);
    assertEquals(analysisResults.getLanguage(), "English");
    assertEquals(analysisResults.getMetadata(), null);
    assertEquals(analysisResults.getRelations().size(), 1);
    assertEquals(analysisResults.getRetrievedUrl(), "URL");
    assertEquals(analysisResults.getSemanticRoles().size(), 1);
    assertEquals(analysisResults.getSentiment(), null);
    assertEquals(analysisResults.getUsage(), null);

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

    // Author
    Author author = new Author();
    author.setName("name");
    assertEquals(author.getName(), "name");

    // CategoriesOptions
    CategoriesOptions categoriesOptions = new CategoriesOptions();
    assertNotNull(categoriesOptions);

    // CategoriesResult
    CategoriesResult categoriesResult = new CategoriesResult();
    categoriesResult.setLabel("label");
    categoriesResult.setScore(10.10);
    assertEquals(categoriesResult.getLabel(), "label");
    assertEquals(categoriesResult.getScore(), 10.10, 0);

    // ConceptsResult
    ConceptsResult conceptsResult = new ConceptsResult();
    conceptsResult.setDbpediaResource("dbpediaResource");
    conceptsResult.setRelevance(10.10);
    conceptsResult.setText("text");
    assertEquals(conceptsResult.getDbpediaResource(), "dbpediaResource");
    assertEquals(conceptsResult.getRelevance(), 10.10, 0);
    assertEquals(conceptsResult.getText(), "text");

    // DisambiguationResult
    DisambiguationResult disambiguationResult = new DisambiguationResult();
    disambiguationResult.setName("name");
    disambiguationResult.setDbpediaResource("dbpediaResource");
    assertEquals(disambiguationResult.getName(), "name");
    assertEquals(disambiguationResult.getDbpediaResource(), "dbpediaResource");

    // DocumentEmotionResults
    DocumentEmotionResults dpcumentEmotionsResults = new DocumentEmotionResults();
    dpcumentEmotionsResults.setEmotion(null);
    assertEquals(dpcumentEmotionsResults.getEmotion(), null);

    // DocumentSentimentResults
    DocumentSentimentResults documentSentimentResults = new DocumentSentimentResults();
    documentSentimentResults.setScore(10.10);
    documentSentimentResults.setLabel("neutral");
    assertEquals(documentSentimentResults.getScore(), 10.10, 0);
    assertEquals(documentSentimentResults.getLabel(), "neutral");

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

    // EmotionResult
    TargetedEmotionResults addTarget = new TargetedEmotionResults();
    List<TargetedEmotionResults> targets = new ArrayList<TargetedEmotionResults>();
    targets.add(addTarget);
    EmotionResult emotionResult = new EmotionResult();
    emotionResult.setDocument(null);
    emotionResult.setTargets(targets);
    assertEquals(emotionResult.getDocument(), null);
    assertEquals(emotionResult.getTargets().size(), 1);

    // EmotionScores
    EmotionScores emotionScores = new EmotionScores();
    emotionScores.setAnger(10.10);
    emotionScores.setDisgust(11.11);
    emotionScores.setFear(12.12);
    emotionScores.setJoy(13.13);
    emotionScores.setSadness(14.14);
    assertEquals(emotionScores.getAnger(), 10.10, 0);
    assertEquals(emotionScores.getDisgust(), 11.11, 0);
    assertEquals(emotionScores.getFear(), 12.12, 0);
    assertEquals(emotionScores.getJoy(), 13.13, 0);
    assertEquals(emotionScores.getSadness(), 14.14, 0);

    // EntitiesOptions
    EntitiesOptions entitiesOptions = new EntitiesOptions.Builder().emotion(true).
        limit(10).model("model").sentiment(false).mentions(false).build();
    assertEquals(entitiesOptions.emotion(), true);
    assertEquals(entitiesOptions.limit(), 10, 0);
    assertEquals(entitiesOptions.model(), "model");
    assertEquals(entitiesOptions.sentiment(), false);
    assertEquals(entitiesOptions.mentions(), false);
    entitiesOptions.newBuilder();

    // EntityMention
    EntityMention mention = new EntityMention();
    mention.setText("text");
    List<Long> location = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
    mention.setLocation(location);
    List<EntityMention> entityMentions = new ArrayList<>();
    entityMentions.add(mention);
    assertEquals(mention.getText(), "text");
    assertEquals(mention.getLocation(), location);

    // EntitiesResult
    EntitiesResult entitiesResult = new EntitiesResult();
    entitiesResult.setCount(10);
    entitiesResult.setEmotion(null);
    entitiesResult.setRelevance(10.10);
    entitiesResult.setSentiment(null);
    entitiesResult.setText("text");
    entitiesResult.setType("type");
    entitiesResult.setMentions(entityMentions);
    entitiesResult.setDisambiguation(disambiguationResult);
    assertEquals(entitiesResult.getCount(), 10, 0);
    assertEquals(entitiesResult.getEmotion(), null);
    assertEquals(entitiesResult.getRelevance(), 10.10, 0);
    assertEquals(entitiesResult.getSentiment(), null);
    assertEquals(entitiesResult.getText(), "text");
    assertEquals(entitiesResult.getType(), "type");
    assertEquals(entitiesResult.getMentions(), entityMentions);
    assertEquals(entitiesResult.getDisambiguation(), disambiguationResult);

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

    // FeatureSentimentResults
    FeatureSentimentResults featureSentimentResults = new FeatureSentimentResults();
    featureSentimentResults.setScore(10.10);
    assertEquals(featureSentimentResults.getScore(), 10.10, 0);
  }

  /**
   * Test some of the model constructors. pump up the code coverage numbers
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testModelOptions2() throws InterruptedException {
    // FeaturesResults
    ConceptsResult addConcepts = new ConceptsResult();
    EntitiesResult addEntity1 = new EntitiesResult();
    KeywordsResult addKeyword1 = new KeywordsResult();
    CategoriesResult addCategory1 = new CategoriesResult();
    RelationsResult addRelation1 = new RelationsResult();
    SemanticRolesResult addRole1 = new SemanticRolesResult();
    List<ConceptsResult> concepts1 = new ArrayList<ConceptsResult>();
    List<EntitiesResult> entities1 = new ArrayList<EntitiesResult>();
    List<KeywordsResult> keywords1 = new ArrayList<KeywordsResult>();
    List<CategoriesResult> categories1 = new ArrayList<CategoriesResult>();
    List<RelationsResult> relations1 = new ArrayList<RelationsResult>();
    List<SemanticRolesResult> semanticRoles1 = new ArrayList<SemanticRolesResult>();

    // KeywordsOptions
    KeywordsOptions keywordsOptions = new KeywordsOptions.Builder().emotion(true).limit(10).sentiment(false).build();
    assertEquals(keywordsOptions.emotion(), true);
    assertEquals(keywordsOptions.limit(), 10, 0);
    assertEquals(keywordsOptions.sentiment(), false);
    keywordsOptions.newBuilder();

    // KeywordsResult
    KeywordsResult keywordsResult = new KeywordsResult();
    keywordsResult.setEmotion(null);
    keywordsResult.setRelevance(10.10);
    keywordsResult.setSentiment(null);
    keywordsResult.setText("text");
    assertEquals(keywordsResult.getEmotion(), null);
    assertEquals(keywordsResult.getRelevance(), 10.10, 0);
    assertEquals(keywordsResult.getSentiment(), null);
    assertEquals(keywordsResult.getText(), "text");

    // ListModelsResults
    Model addModel = new Model();
    List<Model> models = new ArrayList<Model>();
    models.add(addModel);
    ListModelsResults listModelsResults = new ListModelsResults();
    listModelsResults.setModels(models);
    assertEquals(listModelsResults.getModels().size(), 1);

    // MetadataOptions
    MetadataOptions metadataOptions = new MetadataOptions();
    assertNotNull(metadataOptions);

    // MetadataResult
    Author addAuthor = new Author();
    List<Author> authors = new ArrayList<Author>();
    authors.add(addAuthor);
    MetadataResult metadataResult = new MetadataResult();
    metadataResult.setAuthors(authors);
    metadataResult.setPublicationDate("publicationDate");
    metadataResult.setTitle("title");
    assertEquals(metadataResult.getAuthors().size(), 1);
    assertEquals(metadataResult.getPublicationDate(), "publicationDate");
    assertEquals(metadataResult.getTitle(), "title");

    // Model
    Model model = new Model();
    model.setDescription("description");
    model.setLanguage("language");
    model.setModelId("modelId");
    model.setStatus("status");
    assertEquals(model.getDescription(), "description");
    assertEquals(model.getLanguage(), "language");
    assertEquals(model.getModelId(), "modelId");
    assertEquals(model.getStatus(), "status");

    // RelationArgument
    RelationEntity addEntity = new RelationEntity();
    List<RelationEntity> entities = new ArrayList<RelationEntity>();
    entities.add(addEntity);
    RelationArgument relationArgument = new RelationArgument();
    relationArgument.setEntities(entities);
    relationArgument.setText("text");
    assertEquals(relationArgument.getEntities().size(), 1);
    assertEquals(relationArgument.getText(), "text");

    // RelationEntity
    RelationEntity relationEntity = new RelationEntity();
    relationEntity.setText("text");
    relationEntity.setType("type");
    assertEquals(relationEntity.getText(), "text");
    assertEquals(relationEntity.getType(), "type");

    // RelationsOptions
    RelationsOptions relationsOptions = new RelationsOptions.Builder().model("model").build();
    assertEquals(relationsOptions.model(), "model");
    relationsOptions.newBuilder();

    // RelationsResult
    RelationArgument addArgument = new RelationArgument();
    List<RelationArgument> arguments = new ArrayList<RelationArgument>();
    arguments.add(addArgument);
    RelationsResult relationsResult = new RelationsResult();
    relationsResult.setArguments(arguments);
    relationsResult.setScore(10.10);
    relationsResult.setSentence("sentence");
    relationsResult.setType("type");
    assertEquals(relationsResult.getArguments().size(), 1);
    assertEquals(relationsResult.getScore(), 10.10, 0);
    assertEquals(relationsResult.getSentence(), "sentence");
    assertEquals(relationsResult.getType(), "type");

    // SemanticRolesAction
    SemanticRolesAction semanticRolesAction = new SemanticRolesAction();
    semanticRolesAction.setNormalized("normalized");
    semanticRolesAction.setText("text");
    semanticRolesAction.setVerb(null);
    assertEquals(semanticRolesAction.getNormalized(), "normalized");
    assertEquals(semanticRolesAction.getText(), "text");
    assertEquals(semanticRolesAction.getVerb(), null);

    // SemanticRolesEntity
    SemanticRolesEntity semanticRolesEntity = new SemanticRolesEntity();
    semanticRolesEntity.setText("text");
    semanticRolesEntity.setType("type");
    assertEquals(semanticRolesEntity.getText(), "text");
    assertEquals(semanticRolesEntity.getType(), "type");

    // SemanticRolesKeyword
    SemanticRolesKeyword semanticRolesKeyword = new SemanticRolesKeyword();
    semanticRolesKeyword.setText("text");
    assertEquals(semanticRolesKeyword.getText(), "text");

    // SemanticRolesObject
    SemanticRolesKeyword addKeyword = new SemanticRolesKeyword();
    List<SemanticRolesKeyword> keywords = new ArrayList<SemanticRolesKeyword>();
    keywords.add(addKeyword);
    SemanticRolesObject semanticRolesObject = new SemanticRolesObject();
    semanticRolesObject.setKeywords(keywords);
    semanticRolesObject.setText("text");
    assertEquals(semanticRolesObject.getKeywords().size(), 1);
    assertEquals(semanticRolesObject.getText(), "text");

    // SemanticRolesOptions
    SemanticRolesOptions semanticRolesOptions = new SemanticRolesOptions.Builder().entities(true).
        keywords(false).limit(10).build();
    assertEquals(semanticRolesOptions.entities(), true);
    assertEquals(semanticRolesOptions.keywords(), false);
    assertEquals(semanticRolesOptions.limit(), 10, 0);
    semanticRolesOptions.newBuilder();

    // SemanticRolesResult
    SemanticRolesResult semanticRolesResult = new SemanticRolesResult();
    semanticRolesResult.setAction(null);
    semanticRolesResult.setObject(null);
    semanticRolesResult.setSentence("sentence");
    semanticRolesResult.setSubject(null);
    assertEquals(semanticRolesResult.getAction(), null);
    assertEquals(semanticRolesResult.getObject(), null);
    assertEquals(semanticRolesResult.getSentence(), "sentence");
    assertEquals(semanticRolesResult.getSubject(), null);
  }

  /**
   * Test some of the model constructors. pump up the code coverage numbers
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testModelOptions3() throws InterruptedException {
    // SemanticRolesSubject
    SemanticRolesEntity semanticAddEntity = new SemanticRolesEntity();
    SemanticRolesKeyword semanticAddKeyword = new SemanticRolesKeyword();
    List<SemanticRolesEntity> semanticEntities = new ArrayList<SemanticRolesEntity>();
    List<SemanticRolesKeyword> semanticKeywords = new ArrayList<SemanticRolesKeyword>();
    semanticEntities.add(semanticAddEntity);
    semanticKeywords.add(semanticAddKeyword);
    SemanticRolesSubject semanticRolesSubject = new SemanticRolesSubject();
    semanticRolesSubject.setEntities(semanticEntities);
    semanticRolesSubject.setKeywords(semanticKeywords);
    semanticRolesSubject.setText("text");
    assertEquals(semanticRolesSubject.getEntities().size(), 1);
    assertEquals(semanticRolesSubject.getKeywords().size(), 1);
    assertEquals(semanticRolesSubject.getText(), "text");

    // SemanticRolesVerb
    SemanticRolesVerb semanticRolesVerb = new SemanticRolesVerb();
    semanticRolesVerb.setTense("tense");
    semanticRolesVerb.setText("text");
    assertEquals(semanticRolesVerb.getTense(), "tense");
    assertEquals(semanticRolesVerb.getText(), "text");

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

    // SentimentResult
    TargetedSentimentResults addTarget = new TargetedSentimentResults();
    List<TargetedSentimentResults> targets = new ArrayList<TargetedSentimentResults>();
    targets.add(addTarget);
    SentimentResult sentimentResult = new SentimentResult();
    sentimentResult.setDocument(null);
    sentimentResult.setTargets(targets);
    assertEquals(sentimentResult.getDocument(), null);
    assertEquals(sentimentResult.getTargets().size(), 1);

    // TargetedEmotionResults
    TargetedEmotionResults targetedEmotionResults = new TargetedEmotionResults();
    targetedEmotionResults.setEmotion(null);
    targetedEmotionResults.setText("text");
    assertEquals(targetedEmotionResults.getEmotion(), null);
    assertEquals(targetedEmotionResults.getText(), "text");

    // TargetedSentimentResults
    TargetedSentimentResults targetedSentimentResults = new TargetedSentimentResults();
    targetedSentimentResults.setScore(10.10);
    targetedSentimentResults.setText("text");
    assertEquals(targetedSentimentResults.getScore(), 10.10, 0);
    assertEquals(targetedSentimentResults.getText(), "text");

    // Usage
    Usage usage = new Usage();
    usage.setFeatures(10);
    usage.setTextCharacters(20);
    usage.setTextUnits(30);
    assertEquals(usage.getFeatures(), 10, 0);
    assertEquals(usage.getTextCharacters(), 20, 0);
    assertEquals(usage.getTextUnits(), 30, 0);
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
