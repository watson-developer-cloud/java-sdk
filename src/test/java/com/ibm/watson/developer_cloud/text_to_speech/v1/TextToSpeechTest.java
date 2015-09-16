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
package com.ibm.watson.developer_cloud.text_to_speech.v1;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import io.netty.handler.codec.http.HttpHeaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.apache.http.entity.InputStreamEntity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;

/**
 * The Class TextToSpeechTest.
 */
public class TextToSpeechTest extends WatsonServiceTest {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(TextToSpeechTest.class.getName());

	/** Mock Server *. */
	private ClientAndServer mockServer;

	/** The Constant SYNTHESIZE_PATH. (value is "/v1/synthesize") */
	private final static String SYNTHESIZE_PATH = "/v1/synthesize";

	/** The Constant GET_VOICES_PATH.  (value is "/v1/voices") */
	private final static String GET_VOICES_PATH = "/v1/voices";

	/** The service. */
	private TextToSpeech service;
	
	/** The text. */
	private String text = "IBM Watson Developer Cloud";

	/**
	 * Start mock server.
	 */
	@Before
	public void startMockServer() {
		try {
			mockServer = startClientAndServer(Integer.parseInt(prop.getProperty("mock.server.port")));
			service = new TextToSpeech();
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
	 * Test synthesize.
	 */
	@Test
	public void testSynthesize() {
		File audio = new File("src/test/resources/sample1.wav");
		if (audio == null || !audio.exists() || !audio.isFile())
			throw new IllegalArgumentException(
					"audio is not a valid audio file");

		InputStreamEntity reqEntity = null;
		try {
		reqEntity = new InputStreamEntity(new FileInputStream(audio), -1);
			List<Parameter> parameters = new ArrayList<Parameter>();
			parameters.add(new Parameter("text",text));
			parameters.add(new Parameter("voice",Voice.EN_MICHAEL.getName()));
			parameters.add(new Parameter("accept",MediaType.AUDIO_WAV));

			mockServer.when(request().withQueryStringParameters(parameters).withPath(SYNTHESIZE_PATH)).respond(
					response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.AUDIO_WAV))
							.withBody(IOUtils.toString(reqEntity.getContent())));

		InputStream in = service.synthesize(text, Voice.EN_MICHAEL, MediaType.AUDIO_WAV);
		Assert.assertNotNull(in);

			writeInputStreamToOutputStream(in, new FileOutputStream("target/output.wav"));

		} catch (FileNotFoundException e) {
			Assert.fail(e.getMessage());
		}catch(IOException e)
		{
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test synthesize with a wrong format type.
	 */
	@Test
	public void testSynthesizeWithWrongFormat() {
		boolean throwException = false;
		try {
			service.synthesize(text, null, "bad format");
		} catch (IllegalArgumentException e) {
			throwException = true;
		}
		Assert.assertTrue(throwException);
	}

	/**
	 * Test with voice as wav.
	 */
	//@Test
	public void testWithVoiceAsWav() {
		InputStream is = service.synthesize(text, Voice.EN_MICHAEL, MediaType.AUDIO_WAV);
		Assert.assertNotNull(is);

		try {
			writeInputStreamToOutputStream(is, new FileOutputStream("target/output.wav"));
		} catch (FileNotFoundException e) {
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Test get voices.
	 */
	@Test
	public void testGetVoices() {

		Map<String, Object> response = new HashMap<String, Object>();
		List<Voice> voices = new ArrayList<Voice>();
		Voice voice = new Voice();
		voice.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestMaleVoice");
		voice.setName("en-US_TestMaleVoice");
		voice.setGender("male");
		voice.setLanguage("en-US");
		voice.setDescription("TestMale");

		Voice voice1 = new Voice();
		voice1.setUrl("http://ibm.watson.com/text-to-speech/voices/en-US_TestFemaleVoice");
		voice1.setName("en-US_TestFemaleVoice");
		voice1.setGender("female");
		voice1.setLanguage("en-US");
		voice1.setDescription("TestFemale");

		voices.add(voice);
		voices.add(voice1);

		response.put("voices",voices);
		System.out.print(GsonSingleton.getGson().toJson(response));

		mockServer.when(request().withPath(GET_VOICES_PATH)).respond(
				response().withHeaders(new Header(HttpHeaders.Names.CONTENT_TYPE, MediaType.APPLICATION_JSON))
						.withBody(GsonSingleton.getGson().toJson(response)));

		List<Voice> result = service.getVoices();
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(result, voices);
	}

	/**
	 * Write input stream to output stream.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @param outputStream
	 *            the output stream
	 */
	private static void writeInputStreamToOutputStream(InputStream inputStream, OutputStream outputStream) {
		try{
			try {
				final byte[] buffer = new byte[1024];
				int read;

				while ((read = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, read);
				}

				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				outputStream.close();
				inputStream.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
