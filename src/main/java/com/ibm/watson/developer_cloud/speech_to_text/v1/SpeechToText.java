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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;

import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SessionStatus;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModelSet;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechSession;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Speech to Text service uses IBM's speech recognition capabilities to
 * convert English speech into text. The transcription of incoming audio is
 * continuously sent back to the client with minimal delay, and it is corrected
 * as more speech is heard.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/speech-to-text.html">
 *      Speech to Text</a>
 */
public class SpeechToText extends WatsonService {

	/** The Constant MODEL. */
	public static final String MODEL = "model";
	
	/** The Constant INACTIVITY_TIMEOUT. */
	public static final String INACTIVITY_TIMEOUT = "inactivity_timeout";
	
	/** The Constant TIMESTAMPS. */
	public static final String TIMESTAMPS = "timestamps";
	
	/** The Constant MAX_ALTERNATIVES. */
	public static final String MAX_ALTERNATIVES = "max_alternatives";
	
	/** The Constant WORD_CONFIDENCE. */
	public static final String WORD_CONFIDENCE = "word_confidence";
	
	/** The Constant CONTINUOUS. */
	public static final String CONTINUOUS = "continuous";
	
	/** The Constant SESSION_ID. */
	public static final String SESSION_ID = "session_id";
	
	/** The Constant CONTENT_TYPE. */
	public static final String CONTENT_TYPE = "content_type";
	
	/** The Constant AUDIO. */
	public static final String AUDIO = "audio";
	
	/** The url. */
	private final static String URL = "https://stream.watsonplatform.net/speech-to-text/api";

	/**
	 * Instantiates a new speech to text.
	 */
	public SpeechToText() {
		setEndPoint(URL);
	}

	/**
	 * Create a session to lock an engine to the session. You can use the
	 * session for multiple recognition requests, so that each request is
	 * processed with the same speech-to-text engine. Use the cookie that is
	 * returned from this operation in the Set-Cookie header for each request
	 * that uses this session. The session expires after 15 minutes of
	 * inactivity.
	 * 
	 * @return the {@link SpeechSession}
	 */
	public SpeechSession createSession() {
		return createSession(null);
	}

	/**
	 * Create a session to lock an engine to the session. You can use the
	 * session for multiple recognition requests, so that each request is
	 * processed with the same speech-to-text engine. Use the cookie that is
	 * returned from this operation in the Set-Cookie header for each request
	 * that uses this session. The session expires after 15 minutes of
	 * inactivity.
	 *
	 * @param model the model
	 * @return the {@link SpeechSession}
	 */
	public SpeechSession createSession(final String model) {
		String path = "/v1/sessions";

		if (model != null && !model.isEmpty())
			path += "?model=" + model;

		HttpRequestBase request = Request.Post(path).build();
		try {
			HttpResponse response = execute(request);
			SpeechSession speechSession = ResponseUtil.getObject(response, SpeechSession.class);
			speechSession.setCookieSession(response.getFirstHeader("set-cookie").getValue());
			return speechSession;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Delete a session.
	 * 
	 * @param session
	 *            the speech session
	 */
	public void deleteSession(final SpeechSession session) {
		if (session == null)
			throw new IllegalArgumentException("session was not specified");

		HttpRequestBase request = Request.Delete("/v1/sessions/" + session.getSessionId())
				.withHeader("Cookie", session.getCookieSession())
				.build();
		HttpResponse response = execute(request);
		
		try {
			ResponseUtil.getString(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (response.getStatusLine().getStatusCode() != 204)
			throw new RuntimeException("Cound't delete session");	
	}

	/**
	 * Gets the model.
	 * 
	 * @param watsonModel
	 *            the watson model
	 * @return the model
	 */
	public SpeechModel getModel(final SpeechModel watsonModel) {
		return getModel(watsonModel.getName());
	}

	/**
	 * Gets the speech model.
	 * 
	 * @param name
	 *            the name
	 * @return the model
	 */
	public SpeechModel getModel(final String name) {
		if (name == null)
			throw new IllegalArgumentException("name was not specified");

		HttpRequestBase request = Request.Get("/v1/models/" + name).build();
		try {
			HttpResponse response = execute(request);
			return ResponseUtil.getObject(response,SpeechModel.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the models.
	 * 
	 * @return the models
	 */
	public List<SpeechModel> getModels() {
		HttpRequestBase request = Request.Get("/v1/models").build();
		try {
			HttpResponse response = execute(request);
			return ResponseUtil.getObject(response,SpeechModelSet.class).getModels();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the session status. Concurrent recognition tasks during the same
	 * session are not allowed. This method offers a way to check whether the
	 * session can accept another recognition task. The returned state must be
	 * "initialized" to call {@link #recognize(File, String)}.
	 * 
	 * @param session
	 *            the speech session
	 * @return the model
	 */
	public SessionStatus getRecognizeStatus(final SpeechSession session) {
		if (session == null)
			throw new IllegalArgumentException("session was not specified");

		HttpRequestBase request = Request
				.Get("/v1/sessions/" + session.getSessionId() + "/recognize")
				.withHeader("Cookie", session.getCookieSession())
				.build();
		try {
			HttpResponse response = execute(request);
			String resultJson = ResponseUtil.getString(response);
			SessionStatus sessionStatus = GsonSingleton.getGson().fromJson(resultJson,
					SessionStatus.class);
			return sessionStatus;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Recognize.
	 * 
	 * @param audio
	 *            the audio file
	 * @param contentType
	 *            the content type
	 * @return the speech results
	 */
	public SpeechResults recognize(final File audio, final String contentType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(AUDIO, audio);
		params.put(CONTENT_TYPE, contentType);
		return recognize(params);
	}

	/**
	 * Recognize.
	 * 
	 * @param params
	 *            the parameters to use for the recognition. for example:
	 *            "word_confidence", "continuous", "max_alternatives",
	 *            "timestamps", "inactivity_timeout", "model", "session_id",
	 *            content_type
	 * @return the speech results
	 */
	public SpeechResults recognize(Map<String, Object> params) {

		File audio = (File) params.get(AUDIO);
		if (audio == null || !audio.exists() || !audio.isFile())
			throw new IllegalArgumentException(
					"audio is not a valid audio file");

		String contentType = (String) params.get(CONTENT_TYPE);
		if (contentType == null)
			throw new IllegalArgumentException("contentType was not specified");

		// Build the recognize url
		StringBuilder urlBuider = new StringBuilder();
		urlBuider.append("/v1");
		urlBuider.append(params.containsKey(SESSION_ID) ? "/sessions/"
				+ params.get(SESSION_ID) : "");
		urlBuider.append("/recognize");

		Request request = Request.Post(urlBuider.toString());
		request.withHeader("Content-Type", contentType);

		String[] queryParameters = new String[] { WORD_CONFIDENCE,
				CONTINUOUS, MAX_ALTERNATIVES, TIMESTAMPS,
				INACTIVITY_TIMEOUT, MODEL };

		for (String param : queryParameters) {
			if (params.containsKey(param))
				request.withQuery(param, params.get(param));
		}

		InputStreamEntity reqEntity = null;
		try {
			reqEntity = new InputStreamEntity(new FileInputStream(audio), -1);

			reqEntity.setContentType(contentType);
			reqEntity.setChunked(true);
			request.withEntity(reqEntity);

			HttpResponse response = execute(request.build());
			return ResponseUtil.getObject(response,SpeechResults.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
