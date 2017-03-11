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

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.junit.Assume;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;

/**
 * The Class NaturalLanguageunderstandingTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaturalLanguageUnderstandingIT extends WatsonServiceTest {

  /** The service. */
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
    String username = getProperty("natural_language_understanding.username");
    String password = getProperty("natural_language_understanding.password");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
    service.setDefaultHeaders(getDefaultHeaders());
    service.setUsernameAndPassword(username, password);
    service.setEndPoint(getProperty("natural_language_understanding.url"));
  }

  // MARK: - Positive tests

  /**
   * Default test for HTML input.
   */
  @Test
  public void analyzeHtmlIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new ConceptsOptions();
    concepts.setLimit(5);
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
    String text = "In 2009, Elliot Turner launched AlchemyAPI to process the written word, with all of its quirks and nuances, and got immediate traction.";

    ConceptsOptions concepts = new ConceptsOptions();
    concepts.setLimit(5);
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder().text(text).features(features).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
  }

  /**
   * Default test for URL input.
   */
  @Test
  public void analyzeUrlIsSuccessful() throws Exception {
    String url = "http://www.politico.com/story/2016/07/dnc-2016-obama-prepared-remarks-226345";

    ConceptsOptions concepts = new ConceptsOptions();
    concepts.setLimit(5);
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder().url(url).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
  }

  /**
   * Analyze given test input text for concepts.
   */
  @Test
  public void analyzeTextForConceptsIsSuccessful() throws Exception {
    String text = "In remote corners of the world, citizens are demanding respect for the dignity of all people no matter their gender, or race, or religion, or disability, or sexual orientation, and those who deny others dignity are subject to public reproach. An explosion of social media has given ordinary people more ways to express themselves, and has raised people's expectations for those of us in power. Indeed, our international order has been so successful that we take it as a given that great powers no longer fight world wars; that the end of the Cold War lifted the shadow of nuclear Armageddon; that the battlefields of Europe have been replaced by peaceful union; that China and India remain on a path of remarkable growth.";
    ConceptsOptions concepts = new ConceptsOptions();
    concepts.setLimit(5);
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertNotNull(results.getAnalyzedText());
    assertNotNull(results.getConcepts());
    for (ConceptsResult concept: results.getConcepts()) {
      assertNotNull(concept.getText());
      assertNotNull(concept.getDbpediaResource());
      assertNotNull(concept.getRelevance());
    }
  }

  /**
   * Analyze test HTML for concepts.
   */
  @Test
  public void analyzeHtmlForConceptsIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));

    ConceptsOptions concepts = new ConceptsOptions();
    Features features = new Features.Builder().concepts(concepts).build();
    Parameters parameters = new Parameters.Builder().html(html).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

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
   * Analyze input text for emotions without targets
   */
  @Test
  public void analyzeTextForEmotionsWithoutTargetsIsSuccessful() throws Exception {
    String text = "But I believe this thinking is wrong. I believe the road of true democracy remains the better path. I believe that in the 21st century, economies can only grow to a certain point until they need to open up -- because entrepreneurs need to access information in order to invent; young people need a global education in order to thrive; independent media needs to check the abuses of power.";

    EmotionOptions emotion = new EmotionOptions();
    Features features = new Features.Builder().emotion(emotion).build();
    Parameters parameters = new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

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
   * Analyze input text for entities
   */
  @Test
  public void analyzeTextForEntitiesIsSuccessful() throws Exception {
    String text = "In 2009, Elliot Turner launched AlchemyAPI to process the written word, with all of its quirks and nuances, and got immediate traction.";
    EntitiesOptions entities = new EntitiesOptions();
    entities.setLimit(2);
    entities.setSentiment(true);
    Features features = new Features.Builder().entities(entities).build();
    Parameters parameters = new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.getAnalyzedText(), text);
    assertNotNull(results.getEntities());
    assertTrue(results.getEntities().size() == 2);

    for (EntitiesResult result : results.getEntities()) {
      assertNotNull(result.getCount());
      assertNotNull(result.getRelevance());
      assertNotNull(result.getText());
      assertNotNull(result.getType());
      assertNotNull(result.getSentiment());
    }
  }

  /**
   * Analyze input text for keywords
   */
  @Test
  public void analyzeTextForKeywordsIsSuccessful() throws Exception {
    String text = "In 2009, Elliot Turner launched AlchemyAPI to process the written word, with all of its quirks and nuances, and got immediate traction.";
    KeywordsOptions keywords = new KeywordsOptions();
    keywords.setSentiment(true);
    Features features = new Features.Builder().keywords(keywords).build();
    Parameters parameters = new Parameters.Builder().text(text).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

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
   * Analyze html input for metadata
   */
  @Test
  public void analyzeHtmlForMetadataIsSuccessful() throws Exception {
    String testHtmlFileName = "src/test/resources/natural_language_understanding/testArticle.html";
    String html = getStringFromInputStream(new FileInputStream(testHtmlFileName));
    String fileTitle = "This 5,000-year-old recipe for beer actually sounds pretty tasty";
    String fileDate = "2016-05-23T20:13:00";
    String fileAuthor = "Annalee Newitz";
    Map<String, Object> metadata = new HashMap<>();
    Features features = new Features.Builder().metadata(metadata).build();
    Parameters parameters = new Parameters.Builder().html(html).features(features).returnAnalyzedText(true).build();

    AnalysisResults results = service.analyze(parameters).execute();

    assertNotNull(results);
    assertEquals(results.getLanguage(), "en");
    assertNotNull(results.getMetadata());
    MetadataResult result = results.getMetadata();
    assertNotNull(result.getTitle());
    assertEquals(result.getTitle(), fileTitle);
    assertNotNull(result.getPublicationDate());
    assertEquals(result.getPublicationDate(), fileDate);
    assertNotNull(result.getAuthors());
    List<Author> authors = result.getAuthors();
    assertEquals(authors.size(), 1);
    assertEquals(authors.get(0).getName(), fileAuthor);
  }
}
