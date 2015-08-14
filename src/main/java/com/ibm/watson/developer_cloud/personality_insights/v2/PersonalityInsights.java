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
package com.ibm.watson.developer_cloud.personality_insights.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;

import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.HttpHeaders;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Watson Personality Insights service uses linguistic analytics to extract
 * a spectrum of cognitive and social characteristics from the text data that a
 * person generates through blogs, tweets, forum posts, and more.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v2
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/personality-insights.html">
 *      Personality Insights</a>
 */
public class PersonalityInsights extends WatsonService {
	
	/** The Constant ACCEPT_LANGUAGE. */
	public static final String ACCEPT_LANGUAGE = "accept_language";
	
	/** The Constant CONTENT. */
	public static final String CONTENT = "content";
	
	/** The Constant INCLUDE_RAW. */
	public static final String INCLUDE_RAW = "include_raw";
	
	/** The Constant LANGUAGE. */
	public static final String LANGUAGE = "language";
	
	/** The Constant TEXT. */
	public static final String TEXT = "text";
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(PersonalityInsights.class.getName());

	/** The url. */
	private static final String URL = "https://gateway.watsonplatform.net/personality-insights/api";

	/**
	 * Instantiates a new Personality Insights service.
	 */
	public PersonalityInsights() {
		setEndPoint(URL);
	}

	/**
	 * Accepts text or a {@link Content} object and responds with a {@link Profile}
	 * with a tree of characteristics that include personality, needs, and values.
	 * If you include either created or updated timestamps, the response also includes
	 * a summary of the author's writing habits with respect to time of day.
	 * 
	 * @param params
	 *            The parameters to generate the profile. Either text or content need
	 *            to be specified
	 * @return The personality profile
	 */
	public Profile getProfile(final Map<String, Object> params) {
		if (!params.containsKey(TEXT) && !params.containsKey(CONTENT))
			throw new IllegalArgumentException("text or content need to be specified");
		else if (params.containsKey(TEXT) && params.containsKey(CONTENT))
			log.warning("text and content were specified, only text will be used");
			
		
		Request request = Request.Post("/v2/profile");
		
		if (params.containsKey(TEXT)) {
			request.withContent(params.get(TEXT).toString(), HTTP.PLAIN_TEXT_TYPE);
		} else {
			String contentJson = GsonSingleton.getGson().toJson(params.get(CONTENT));
			request.withContent(contentJson, MediaType.APPLICATION_JSON);
		}
		
		if (params.containsKey(INCLUDE_RAW))
			request.withQuery(INCLUDE_RAW, params.get(INCLUDE_RAW));
		
		if (params.containsKey(LANGUAGE))
			request.withHeader(HttpHeaders.CONTENT_LANGUAGE, params.get(LANGUAGE));

		if (params.containsKey(ACCEPT_LANGUAGE))
			request.withHeader(HttpHeaders.ACCEPT_LANGUAGE, params.get(ACCEPT_LANGUAGE));

		HttpResponse response = execute(request.build());

		try {
			String profileJson = ResponseUtil.getString(response);
			Profile profile = GsonSingleton.getGson().fromJson(profileJson, Profile.class);
			return profile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Accepts text and responds with a {@link Profile}
	 * with a tree of characteristics that include personality, needs, and values.
	 * 
	 * @param text
	 *            Text to analyze
	 *            
	 * @return The personality {@link Profile}
	 */
	public Profile getProfile(final String text) {
		if (text == null || text.isEmpty())
			throw new IllegalArgumentException("text can not be null or empty");
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put(TEXT, text);
		return getProfile(params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonalityInsights [getEndPoint()=");
		builder.append(getEndPoint());
		builder.append("]");
		return builder.toString();
	}

}
