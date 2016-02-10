/**
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
package com.ibm.watson.developer_cloud.tone_analyzer.v3;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Header;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.SentenceAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import io.netty.handler.codec.http.HttpHeaders;

/**
 * The Class ToneAnalyzerTest.
 */
@SuppressWarnings("serial")
public class ToneAnalyzerTest extends WatsonServiceUnitTest {

  private final static String TONE_PATH = "/v3/tone";

  /** The service. */
  private ToneAnalyzer service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ToneAnalyzer();
    service.setApiKey("");
    service.setEndPoint(MOCK_SERVER_URL);

  }

  /**
   * Test get tone.
   */
  @Test
  public void testGetTone() {
    final String text =
        "I know the times are difficult! Our sales have been "
            + "disappointing for the past three quarters for our data analytics "
            + "product suite. We have a competitive data analytics product "
            + "suite in the industry. But we need to do our job selling it! ";

    final ToneAnalysis response = new ToneAnalysis();

    final ElementTone docTone = new ElementTone();
    docTone.addTone(buildEmotionTone());
    docTone.addTone(buildWritingTone());
    docTone.addTone(buildSocialTone());
   
    List<SentenceAnalysis> sentences = new ArrayList<SentenceAnalysis>();
    response.setSentencesTone(sentences);

    final SentenceAnalysis sentence = new SentenceAnalysis(0, 0, text.length(), text);
    sentence.addTone(buildEmotionTone());
    sentence.addTone(buildWritingTone());
    sentence.addTone(buildSocialTone());
    
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("text", text);

    mockServer
        .when(request().withMethod(POST).withPath(TONE_PATH).withBody(contentJson.toString()))
        .respond(
            response().withHeaders(
                new Header(HttpHeaders.Names.CONTENT_TYPE, HttpMediaType.APPLICATION_JSON))
                .withBody(GsonSingleton.getGson().toJson(response)));

    // Call the service and get the tone
    final ToneAnalysis tone = service.getTone(text);
    Assert.assertNotNull(tone);
    Assert.assertNotNull(tone.getDocumentTone());
    Assert.assertEquals(3, tone.getDocumentTone().getTones().size());
    Assert.assertNotNull(tone.getSentencesTone());
    Assert.assertEquals(1, tone.getSentencesTone().size());
    Assert.assertNotNull(tone.getSentencesTone().get(0).getText());
    Assert.assertEquals(tone, response);

  }

  private ToneCategory buildEmotionTone() {
	final ToneCategory ret = new ToneCategory();
	ret.setId("emotion_tone");
	ret.setName("Emotion Tone");
	List<ToneScore> tones = new ArrayList<ToneScore>();
	tones.add(new ToneScore("anger", "Anger", 0.1));
	tones.add(new ToneScore("disgust", "Disgust", 0.2));
	tones.add(new ToneScore("fear", "Fear", 0.3));
	tones.add(new ToneScore("joy", "Joy", 0.4));
	tones.add(new ToneScore("sadness", "Sadness", 0.0));
	ret.setTones(tones);
	return null;
  }

  private ToneCategory buildWritingTone() {
	final ToneCategory ret = new ToneCategory();
	ret.setId("writing_tone");
	ret.setName("Writing Tone");
	List<ToneScore> tones = new ArrayList<ToneScore>();
	tones.add(new ToneScore("analytical", "Analytical", 0.2));
	tones.add(new ToneScore("confident", "Confident", 0.3));
	tones.add(new ToneScore("tentative", "Tentative", 0.4));
	ret.setTones(tones);
	return null;
  }

  private ToneCategory buildSocialTone() {
	final ToneCategory ret = new ToneCategory();
	ret.setId("social_tone");
	ret.setName("Social Tone");
	List<ToneScore> tones = new ArrayList<ToneScore>();
	tones.add(new ToneScore("openness_big5", "Openness", 0.1));
	tones.add(new ToneScore("conscientiousness_big5", "Conscientiousness", 0.2));
	tones.add(new ToneScore("extraversion_big5", "Extraversion", 0.3));
	tones.add(new ToneScore("agreeableness_big5", "Agreeableness", 0.4));
	tones.add(new ToneScore("neuroticism_big5", "Emotional Range", 0.5));
	ret.setTones(tones);
	return null;
  }

/**
   * Test tone with null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetToneWithNull() {
    service.getTone(null);
  }

}
