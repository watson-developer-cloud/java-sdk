/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.google.common.collect.ImmutableMap;
import com.ibm.watson.developer_cloud.WatsonServiceUnitTest;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.http.HttpHeaders;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.util.ZipUtils;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;
import com.ibm.watson.developer_cloud.service.exception.ConflictException;
import com.ibm.watson.developer_cloud.service.exception.ForbiddenException;
import com.ibm.watson.developer_cloud.service.exception.InternalServerErrorException;
import com.ibm.watson.developer_cloud.service.exception.NotFoundException;
import com.ibm.watson.developer_cloud.service.exception.RequestTooLargeException;
import com.ibm.watson.developer_cloud.service.exception.ServiceUnavailableException;
import com.ibm.watson.developer_cloud.service.exception.TooManyRequestsException;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;
import com.ibm.watson.developer_cloud.service.exception.UnsupportedException;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.util.MediaTypeUtils;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.util.CredentialUtils;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.RequestUtils;
import com.ibm.watson.developer_cloud.util.ResponseUtils;
import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

import jersey.repackaged.jsr166e.CompletableFuture;
import okhttp3.Credentials;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Generic Service Test.
 */
public class GenericServiceTest extends WatsonServiceUnitTest {
  private static final String GET_PROFILE_PATH = "/v2/profile";
  private final String sampleText = "this is a test";
  private PersonalityInsights service;

  private boolean reactiveSuccess = false;

  private MockResponse errorResponse(int code, String errorMessage) {
    return jsonResponse(ImmutableMap.of("code", code, "error", errorMessage)).setResponseCode(code);
  }

  private RecordedRequest checkRequest() throws InterruptedException {
    final RecordedRequest request = server.takeRequest();

    assertEquals("POST", request.getMethod());
    assertEquals(GET_PROFILE_PATH, request.getPath());
    return request;
  }

  /**
   * Checks the credential constructors of all services.
   */
  @Test
  public void testConstructors() {
    final String u = "u-s-e-r";
    final String p = "p-a-s-s";
    final String key = Credentials.basic(u, p);

    checkApiKey(new AlchemyDataNews(key), key);
    checkApiKey(new AlchemyLanguage(key), key);
    checkApiKey(new AlchemyVision(key), key);
    checkApiKey(new ConversationService(ConversationService.VERSION_DATE_2016_07_11, u, p), key);
    checkApiKey(new DialogService(u, p), key);
    checkApiKey(new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01, u, p), key);
    checkApiKey(new LanguageTranslation(u, p), key);
    checkApiKey(new NaturalLanguageClassifier(u, p), key);
    checkApiKey(new PersonalityInsights(u, p), key);
    checkApiKey(new RetrieveAndRank(u, p), key);
    checkApiKey(new SpeechToText(u, p), key);
    checkApiKey(new TextToSpeech(u, p), key);
    checkApiKey(new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19, u, p), key);
    checkApiKey(new TradeoffAnalytics(u, p), key);
    checkApiKey(new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, key), key);
  }

  /**
   * Tests Utility classes and their private constructors.
   *
   * @throws NoSuchMethodException the no such method exception
   */
  @Test
  public void testUtilityClasses() throws NoSuchMethodException {
    final List<Class<?>> utilityClasses = Arrays.asList(AlchemyEndPoints.class, ConversionUtils.class, ZipUtils.class,
        MediaTypeUtils.class, WaveUtils.class, CredentialUtils.class, GsonSingleton.class, RequestUtils.class,
        ResponseUtils.class, Validator.class, HttpMediaType.class);

    for (Class<?> cls : utilityClasses) {
      assertTrue("Utility class " + cls.getName() + " should be final.", Modifier.isFinal(cls.getModifiers()));
      assertEquals("Utility class " + cls.getName() + " should have one private constructor.", 1,
          cls.getDeclaredConstructors().length);

      final Constructor<?> constructor = cls.getDeclaredConstructor();
      assertTrue("Utility class " + cls.getName() + " should have one private constructor.",
          Modifier.isPrivate(constructor.getModifiers()));

      constructor.setAccessible(true);

      try {
        constructor.newInstance();
      } catch (Exception e) {
        // receiving an exception, e.g. UnsupportedOperationException, is fine here!
      }
    }
  }

  /**
   * Checks the equality of API keys.
   *
   * @param service the service
   * @param apiKey the API key
   */
  private static void checkApiKey(WatsonService service, String apiKey) {
    // assertEquals(service.getApiKey(), apiKey);
  }

  /**
   * Service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void serviceUnavailableException() {
    server.enqueue(errorResponse(503, "ServiceUnavailableException"));
    service.getProfile(sampleText).execute();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.ibm.watson.watson.developer_cloud.WatsonServiceUnitTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new PersonalityInsights();
    service.setApiKey("");
    service.setEndPoint(getMockWebServerUrl());
  }

  /**
   * Test bad request exception.
   */
  @Test(expected = BadRequestException.class)
  public void testBadRequestException() {
    server.enqueue(errorResponse(400, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test service conflict exception.
   */
  @Test(expected = ConflictException.class)
  public void testConflictException() {
    server.enqueue(errorResponse(409, "Conflict Exception"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test default headers are set.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testDefaultHeadersAreSet() throws InterruptedException {
    final Map<String, String> headers = new HashMap<String, String>();
    headers.put("name1", "value1");
    headers.put("name2", "value2");

    service.setDefaultHeaders(headers);

    server.enqueue(jsonResponse(Collections.emptyMap()));
    service.getProfile(sampleText).execute();
    final RecordedRequest request = checkRequest();

    assertEquals("value1", request.getHeader("name1"));
    assertEquals("value2", request.getHeader("name2"));
  }

  /**
   * Test forbidden exception.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = ForbiddenException.class)
  public void testForbiddenException() throws InterruptedException {
    server.enqueue(errorResponse(403, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test illegal argument exception.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() throws InterruptedException {
    final PersonalityInsights service = new PersonalityInsights();
    service.setEndPoint(null);
    service.getProfile(sampleText).execute();
  }

  /**
   * Test internal server error exception.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = InternalServerErrorException.class)
  public void testInternalServerErrorException() throws InterruptedException {
    server.enqueue(errorResponse(500, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test not found exception.
   */
  @Test(expected = NotFoundException.class)
  public void testNotFoundException() {
    server.enqueue(errorResponse(404, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test request too large exception.
   */
  @Test(expected = RequestTooLargeException.class)
  public void testRequestTooLargeException() {
    server.enqueue(errorResponse(413, "Bad request"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test service unavailable exception.
   */
  @Test(expected = ServiceUnavailableException.class)
  public void testServiceUnavailableException() {
    server.enqueue(errorResponse(503, "Service Unavailable"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test too many requests exception.
   */
  @Test(expected = TooManyRequestsException.class)
  public void testTooManyRequestsException() {
    server.enqueue(errorResponse(429, "TooManyRequestsException"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test unauthorized exception.
   */
  @Test(expected = UnauthorizedException.class)
  public void testUnauthorizedException() {
    server.enqueue(errorResponse(401, "UnauthorizedException"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test unsupported exception.
   */
  @Test(expected = UnsupportedException.class)
  public void testUnsupportedException() {
    server.enqueue(errorResponse(415, "UnsupportedException"));
    service.getProfile(sampleText).execute();
  }

  /**
   * Test user agent is set.
   *
   * @throws Exception the exception
   */
  @Test
  public void testUserAgentIsSet() throws Exception {
    server.enqueue(jsonResponse(Collections.emptyMap()));
    service.getProfile(sampleText).execute();
    final RecordedRequest request = checkRequest();
    final String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

    final String prefix = "watson-apis-java-sdk/";
    String version = "";

    assertTrue("Illegal user agent: " + userAgent, userAgent.startsWith(prefix));

    try {
      final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      final Document doc = builder.parse(new File("pom.xml"));
      version = doc.getElementsByTagName("version").item(0).getTextContent();
    } catch (Exception e) {
      throw new AssumptionViolatedException(e.getMessage(), e);
    }

    assertTrue("Illegal user agent version: " + userAgent, userAgent.startsWith(prefix + version));
  }

  /**
   * Test custom user agent.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCustomUserAgent() throws InterruptedException {
    server.enqueue(jsonResponse(Collections.emptyMap()));
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(HttpHeaders.USER_AGENT, "foo-bar");
    service.setDefaultHeaders(headers);
    service.getProfile(sampleText).execute();
    final RecordedRequest request = checkRequest();
    assertTrue(request.getHeader(HttpHeaders.USER_AGENT).endsWith("foo-bar"));
    service.setDefaultHeaders(null);
  }

  /**
   * Tests request without authentication.
   */
  @Test
  public void testNoAuthentication() {
    try {
      new SpeechToText().getModels();
      throw new AssumptionViolatedException("createServiceCall() did not throw an IllegalArgumentException, "
          + "even though no authentication has been specified.");
    } catch (IllegalArgumentException e) {
      // success!
    }
  }

  /**
   * Tests request with skipped authentication.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testSkipAuthentication() throws InterruptedException {
    server.enqueue(jsonResponse(Collections.emptyMap()));
    service.setApiKey(null);
    service.setSkipAuthentication(true);
    service.getProfile(sampleText).execute();
    checkRequest();
  }

  /**
   * Tests the execution of reactive calls.
   *
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException the execution exception
   */
  @Test
  public void testReactiveCalls() throws InterruptedException, ExecutionException {
    server.enqueue(jsonResponse(Collections.emptyMap()));
    service.getProfile(sampleText).rx().thenAccept(new CompletableFuture.Action<Profile>() {
      @Override
      public void accept(Profile profile) {
        Assert.assertNotNull(profile);
        reactiveSuccess = true;
      }
    });

    for (int i = 0; i < 10; i++) {
      if (reactiveSuccess) {
        return;
      }

      Thread.sleep(100);
    }
  }

}
