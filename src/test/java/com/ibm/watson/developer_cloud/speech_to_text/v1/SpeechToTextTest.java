/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.speech_to_text.v1;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModelSet;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.TestUtils;

/**
 * The Class SpeechToTextTest.
 */
public class SpeechToTextTest extends WatsonServiceTest {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(SpeechToTextTest.class.getName());

	/** Mock Server *. */
	private ClientAndServer mockServer;

	/** The Constant GET_MODELS_PATH. (value is "/v1/models") */
	private final static String GET_MODELS_PATH = "/v1/models";

	/** The CREATE_DELETE_SESSIONS_PATH.  (value is "/v1/sessions") */
	private final static String CREATE_DELETE_SESSIONS_PATH = "/v1/sessions";

	/** The RECOGNIZE_PATH.  (value is "/v1/recognize") */
	private final static String RECOGNIZE_PATH = "/v1/recognize";

	/** The service. */
	private SpeechToText service;

	/**
	 * Start mock server.
	 */
	@Before
	public void startMockServer() {
		try {
			mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
			service = new SpeechToText();
			service.setApiKey("");
			service.setEndPoint("http://" + prop.getProperty("mock.server.host") + ":"
					+ prop.getProperty("mock.server.port"));
		} catch (NumberFormatException e) {
			log.log(Level.SEVERE, "Error mocking the service", e);
		}

	}

	/**
	 * Stop mock server.
	 */
	@After
	public void stopMockServer() {
		mockServer.stop();
	}


	/* (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test get models.
	 */
	@Test
	public void testGetModels() {

		SpeechModelSet speechModelSet = new SpeechModelSet();

		SpeechModel speechModel = new SpeechModel("not-a-real-Model");
		speechModel.setRate(8000);

		SpeechModel speechModel1 = new SpeechModel("not-a-real-Model1");
		speechModel1.setRate(1600);

		SpeechModel speechModel2 = new SpeechModel("not-a-real-Model2");
		speechModel2.setRate(8000);

		List<SpeechModel> speechModels = new ArrayList<SpeechModel>();
		speechModels.add(speechModel);
		speechModels.add(speechModel1);
		speechModels.add(speechModel2);

		speechModelSet.setModels(speechModels);

		mockServer.when(request().withPath(GET_MODELS_PATH)).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(speechModelSet)));
		List<SpeechModel> models = service.getModels();
		Assert.assertNotNull(models);
		Assert.assertFalse(models.isEmpty());
		Assert.assertEquals(models, speechModelSet.getModels());
	}

	/**
	 * Test get model.
	 */
	@Test
	public void testGetModel() {

		SpeechModel speechModel = new SpeechModel("not-a-real-Model");
		speechModel.setRate(8000);

		mockServer.when(request().withPath(GET_MODELS_PATH + "/" + speechModel.getName())).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(speechModel)));


		SpeechModel model = service.getModel("not-a-real-Model");
		Assert.assertNotNull(model);
		Assert.assertEquals(model, speechModel);
		try {
			TestUtils.assertNoExceptionsOnGetters(model);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test create and delete session.
	 */
	@Test
	public void testCreateAndDeleteSession() {
		SpeechSession speechSession = new SpeechSession();
		speechSession.setRecognize("http://ibm.watson.com/speech-to-text/api/v1/sessions/f7332a2d7a138ea9f05ffaa8f697a788/recognize");
		speechSession.setRecognizeWS("wss://ibm.watson.com/speech-to-text/api/v1/sessions/f7332a2d7a138ea9f05ffaa8f697a788/recognize");
		speechSession.setNewSessionUri("http://ibm.watson.com/speech-to-text/api/v1/sessions/f7332a2d7a138ea9f05ffaa8f697a788");
		speechSession.setSessionId("f7332a2d7a138ea9f05ffaa8f697a788");
		speechSession.setObserveResult("http://ibm.watson.com/speech-to-text/api/v1/sessions/f7332a2d7a138ea9f05ffaa8f697a788/observe_result");

		System.out.print(GsonSingleton.getGson().toJson(speechSession));

		mockServer.when(request().withMethod("POST").withPath(CREATE_DELETE_SESSIONS_PATH)).

				respond(
						response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON),new Header("set-cookie","test-cookie"))
								.withBody(GsonSingleton.getGson().toJson(speechSession)));

		SpeechSession session = service.createSession();
		Assert.assertNotNull(session);

		mockServer.when(request().withMethod("DELETE").withPath(CREATE_DELETE_SESSIONS_PATH+ "/" +session.getSessionId())
						.withHeader("Cookie", session.getCookieSession())

		).respond(
				response().withHeaders(new Header(HttpHeaders.Names.COOKIE, session.getCookieSession()))
						.withStatusCode(204));
      	service.deleteSession(session);
	}

	/**
	 * Test recognize.
	 * 
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@Test
	public void testRecognize() throws URISyntaxException {

		SpeechResults speechResults = new SpeechResults();
		speechResults.setResultIndex(0);
		Transcript transcript = new Transcript();
		transcript.setFinal(true);
		final SpeechAlternative speechAlternative = new SpeechAlternative();
		speechAlternative.setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");
		List<SpeechAlternative> speechAlternatives = new ArrayList<SpeechAlternative>();
		speechAlternatives.add(speechAlternative);
		
		transcript.setAlternatives(speechAlternatives);
		List<Transcript> transcripts = new ArrayList<Transcript>();
		transcripts.add(transcript);
		speechResults.setResults(transcripts);

		File audio = new File("src/test/resources/sample1.wav");

		mockServer.when(request().withMethod("POST").withPath(RECOGNIZE_PATH).withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, "audio/l16; rate=44100")))

				.respond(
						response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
								.withBody(GsonSingleton.getGson().toJson(speechResults)));
		SpeechResults result = service.recognize(audio, "audio/l16; rate=44100");
		Assert.assertNotNull(result);
		Assert.assertEquals(result,speechResults);
	}
	
	/**
	 * Test recognize.
	 * 
	 * @throws URISyntaxException
	 *             the URI syntax exception
	 */
	@Test
	public void testRecognizeWithParams() throws URISyntaxException {
		File audio = new File("src/test/resources/sample1.wav");
		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("audio", audio);
		params.put("content_type", "audio/l16; rate=44100");
		params.put("word_confidence", "false");
		params.put("continuous", "false");
		params.put("timestamps", "false");
		params.put("inactivity_timeout", "30");
		params.put("max_alternatives", "1");
		String[] queryParameters = new String[] { SpeechToText.WORD_CONFIDENCE,
				SpeechToText.CONTINUOUS, SpeechToText.MAX_ALTERNATIVES, SpeechToText.TIMESTAMPS,
				SpeechToText.INACTIVITY_TIMEOUT, SpeechToText.MODEL };
		List<Parameter> parameters = new ArrayList<Parameter>();
		for (String param : queryParameters) {
			if (params.containsKey(param))
				parameters.add(new Parameter(param, (String) params.get(param)));
		}

		SpeechResults speechResults = new SpeechResults();
		speechResults.setResultIndex(0);
		Transcript transcript = new Transcript();
		transcript.setFinal(true);
		final SpeechAlternative speechAlternative = new SpeechAlternative();
		speechAlternative.setTranscript("thunderstorms could produce large hail isolated tornadoes and heavy rain");
		List<SpeechAlternative> speechAlternatives = new ArrayList<SpeechAlternative>();
		speechAlternatives.add(speechAlternative);

		transcript.setAlternatives(speechAlternatives);
		List<Transcript> transcripts = new ArrayList<Transcript>();
		transcripts.add(transcript);
		speechResults.setResults(transcripts);

		mockServer.when(request().withMethod("POST").withPath(RECOGNIZE_PATH).withQueryStringParameters(parameters)
				.withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, "audio/l16; rate=44100")))

				.respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(speechResults)));

		SpeechResults result = service.recognize(params);

		Assert.assertNotNull(result);
		Assert.assertEquals(result, speechResults);
	}
	
}
