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

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assume;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Parameters;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Author;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.ConceptsResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionScores;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
//import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.MetadataOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.MetadataResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.RelationsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SemanticRolesResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.TargetedSentimentResults;

/**
 * The Class NaturalLanguageunderstandingTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturalLanguageUnderstandingIT extends WatsonServiceTest {

  private NaturalLanguageUnderstanding service;
  private String text = "In 2009, Elliot Turner launched AlchemyAPI to process the written word,"
      + " with all of its quirks and nuances, and got immediate traction.";

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("natural_language_understanding.username");
    String password = getProperty("natural_language_understanding.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("natural_language_understanding.url"));
  }

  /**
   * Default test for HTML input.
   */
  @Test
  public void analyzeHtmlIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new  ConceptsOptions.Builder().limit(5).build();
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder().html(html).features(features).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
  }

  /**
   * Default test for text input.
   */
  @Test
  public void analyzeTextIsSuccessful() throws Exception {
    ConceptsOptions concepts = new ConceptsOptions.Builder().limit(5).build();
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder()
        .text(text)
        .features(features)
        .build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
  }

  /**
   * Default test for URL input.
   */
  @Test
  public void analyzeUrlIsSuccessful() throws Exception {
    String url = "http://www.politico.com/story/2016/07/dnc-2016-obama-prepared-remarks-226345";

    ConceptsOptions concepts = new ConceptsOptions.Builder().limit(5).build();
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters =
        new Parameters.Builder()
        .url(url)
        .features(features)
        .returnAnalyzedText(true)
        .build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.analyzedText());
  }

  /**
   * Analyze given test input text for concepts.
   */
  @Test
  public void analyzeTextForConceptsIsSuccessful() throws Exception {
    String text = "In remote corners of the world, citizens are demanding respect"
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
    Parameters parameters = new Parameters.Builder()
        .text(text)
        .features(features)
        .returnAnalyzedText(true)
        .build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.analyzedText());
    assertNotNull(results.concepts());
    for (ConceptsResult concept : results.concepts()) {
      assertNotNull(concept.text());
      assertNotNull(concept.dbpediaResource());
      assertNotNull(concept.relevance());
    }
  }

  /**
   * Analyze test HTML for concepts.
   */
  @Test
  public void analyzeHtmlForConceptsIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new ConceptsOptions.Builder().build();
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters =
        new Parameters.Builder().html(html).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.analyzedText());
    assertNotNull(results.concepts());
    for (ConceptsResult concept : results.concepts()) {
      assertNotNull(concept.text());
      assertNotNull(concept.dbpediaResource());
      assertNotNull(concept.relevance());
    }
  }

  /**
   * Analyze input text for emotions without targets.
   */
  @Test
  public void analyzeTextForEmotionsWithoutTargetsIsSuccessful() throws Exception {
    String text = "But I believe this thinking is wrong. I believe the road of true democracy remains the better path."
        + " I believe that in the 21st century, economies can only grow to a certain point until they need to open up"
        + " -- because entrepreneurs need to access information in order to invent; young people need a global"
        + " education in order to thrive; independent media needs to check the abuses of power.";

    EmotionOptions emotion = new EmotionOptions.Builder().build();
    Features features = new Features.Builder().emotion(emotion).build();
    Parameters parameters =
        new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.analyzedText());
    assertNotNull(results.emotion());
    assertNotNull(results.emotion().document());
    assertNotNull(results.emotion().document().emotion());

    EmotionScores scores = results.emotion().document().emotion();
    assertNotNull(scores.anger());
    assertNotNull(scores.disgust());
    assertNotNull(scores.fear());
    assertNotNull(scores.joy());
    assertNotNull(scores.sadness());

    assertNull(results.emotion().targets());
  }

  /**
   * Analyze input text for entities.
   */
  @Test
  public void analyzeTextForEntitiesIsSuccessful() throws Exception {
    String text =
        "In 2009, Elliot Turner launched AlchemyAPI to process the written word, with all of its quirks and nuances,"
        + " and got immediate traction.";

    EntitiesOptions entities = new EntitiesOptions.Builder().limit(2).sentiment(true).build();
    Features features = new Features.Builder()
        .entities(entities)
        .build();

    Parameters parameters = new Parameters.Builder()
        .text(text)
        .features(features)
        .returnAnalyzedText(true)
        .build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertNotNull(results.entities());
    assertTrue(results.entities().size() == 2);

    for (EntitiesResult result : results.entities()) {
      assertNotNull(result.count());
      assertNotNull(result.relevance());
      assertNotNull(result.text());
      assertNotNull(result.type());
      assertNotNull(result.sentiment());
    }
  }

  /**
   * Analyze input text for keywords.
   */
  @Test
  public void analyzeTextForKeywordsIsSuccessful() throws Exception {
    KeywordsOptions keywords = new KeywordsOptions.Builder().sentiment(true).build();
    Features features = new Features.Builder().keywords(keywords).build();
    Parameters parameters =
        new Parameters.Builder()
        .text(text)
        .features(features)
        .returnAnalyzedText(true)
        .build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertNotNull(results.keywords());

    for (KeywordsResult result : results.keywords()) {
      assertNotNull(result.relevance());
      assertNotNull(result.text());
      assertNotNull(result.sentiment());
    }
  }

  /**
   * Analyze html input for metadata.
   */
  @Test
  public void analyzeHtmlForMetadataIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));
    String fileTitle = "This 5,000-year-old recipe for beer actually sounds pretty tasty";
    String fileDate = "2016-05-23T20:13:00";
    String fileAuthor = "Annalee Newitz";
    Features features = new Features.Builder()
        .metadata(new LinkedHashMap<String,Object>())
        .build();
    Parameters parameters = new Parameters.Builder()
        .html(html)
        .features(features)
        .returnAnalyzedText(true)
        .build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.language(), "en");
    assertNotNull(results.metadata());
    MetadataResult result = results.metadata();
    assertNotNull(result.title());
    assertEquals(result.title(), fileTitle);
    assertNotNull(result.publicationDate());
    assertEquals(result.publicationDate(), fileDate);
    assertNotNull(result.authors());
    List<Author> authors = result.authors();
    assertEquals(authors.size(), 1);
    assertEquals(authors.get(0).name(), fileAuthor);
  }

  /**
   * Analyze input text for relations.
   */
  @Test
  public void analyzeTextForRelationsIsSuccessful() throws Exception {
    Features features = new Features.Builder().relations(new RelationsOptions.Builder().build()).build();
    Parameters parameters =
        new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertEquals(results.language(), "en");
    assertNotNull(results.relations());
  }

  /**
   * Analyze input text for semantic roles.
   */
  @Test
  public void analyzeTextForSemanticRolesIsSuccessful() throws Exception {
    SemanticRolesOptions options = new SemanticRolesOptions.Builder().limit(7).keywords(true).entities(true)
            .build();
    Features features = new Features.Builder().semanticRoles(options).build();
    Parameters parameters =
        new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertEquals(results.language(), "en");
    assertNotNull(results.semanticRoles());
    for (SemanticRolesResult result : results.semanticRoles()) {
      assertEquals(result.sentence(), text);
      if (result.subject() != null) {
        assertNotNull(result.subject().text());
      }
      if (result.action() != null) {
        assertNotNull(result.action().text());
      }
      if (result.object() != null) {
        assertNotNull(result.object().text());
      }
    }
  }

  /**
   * Analyze input text for sentiment with targets.
   */
  @Test
  public void analyzeTextForSentimentWithTargetsIsSuccessful() throws Exception {
    SentimentOptions options = new SentimentOptions.Builder().document(true)
            .targets(Arrays.asList("Elliot Turner", "traction"))
            .build();
    Features features = new Features.Builder().sentiment(options).build();
    Parameters parameters =
        new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertEquals(results.language(), "en");
    assertNotNull(results.sentiment());
    assertNotNull(results.sentiment().document());
    assertNotNull(results.sentiment().document().score());
    assertNotNull(results.sentiment().targets());
    for (TargetedSentimentResults result : results.sentiment().targets()) {
      assertNotNull(result.text());
      assertNotNull(result.score());
    }
  }

  /**
   * Analyze input text for sentiment without targets.
   */
  @Test
  public void analyzeTextForSentimentWithoutTargetsIsSuccessful() throws Exception {
    SentimentOptions options = new SentimentOptions.Builder().document(true).build();
    Features features = new Features.Builder().sentiment(options).build();
    Parameters parameters =
        new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertEquals(results.language(), "en");
    assertNotNull(results.sentiment());
    assertNotNull(results.sentiment().document());
    assertNotNull(results.sentiment().document().score());
    assertNull(results.sentiment().targets());
  }

  /**
   * Analyze input text for categories.
   */
  @Test
  public void analyzeTextForCategoriesIsSuccessful() throws Exception {
    Features features = new Features.Builder().categories(new LinkedHashMap<String,Object>()).build();
    Parameters parameters =
        new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.analyzedText(), text);
    assertEquals(results.language(), "en");
    assertNotNull(results.categories());
    for (CategoriesResult result : results.categories()) {
      assertNotNull(result.label());
      assertNotNull(result.score());
    }
  }
}
