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

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.protocol.HTTP;

import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Watson Personality Insights service uses linguistic analytics to extract
 * a spectrum of cognitive and social characteristics from the text data that a
 * person generates through blogs, tweets, forum posts, and more.
 * 
 * @version v2
 * 
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/personality-insights.html">
 *      Personality Insights</a>
 * 
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class PersonalityInsights extends WatsonService {

	private static String URL = "https://gateway.watsonplatform.net/personality-insights/api";

	/**
	 * Instantiates a new Personality Insights service.
	 */
	public PersonalityInsights() {
		setEndPoint(URL);
	}

	/**
	 * Accepts a {@link Content} object and analyzes the text. The response is
	 * {@link Profile} with a tree of characteristics that include personality,
	 * needs, and values. If you include either created or updated timestamps,
	 * the response also includes a summary of the author's writing habits with
	 * respect to time of day.
	 * 
	 * @param content
	 *            the content
	 * @return the profile
	 * @see Content
	 */
	public Profile getProfile(Content content) {
		if (content == null)
			throw new IllegalArgumentException("content can not be null");

		if (content.getContentItems() == null || content.getContentItems().isEmpty())
			throw new IllegalArgumentException("content needs to have contentItems.");

		String contentJson = getGson().toJson(content);
		HttpRequestBase request = Request.Post("/v2/profile")
				.withContent(contentJson, MediaType.APPLICATION_JSON).build();

		try {
			HttpResponse response = execute(request);
			String profileJson = ResponseUtil.getString(response);
			Profile profile = getGson().fromJson(profileJson, Profile.class);
			return profile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Accepts text and responds with a {@link Profile} with a tree of
	 * characteristics that include personality, needs, and values. If you
	 * include either created or updated timestamps, the response also includes
	 * a summary of the author's writing habits with respect to time of day.
	 * 
	 * @param text
	 *            the text to analyze
	 * @return the personality profile
	 * @see Content
	 */
	public Profile getProfile(String text) {
		if (text == null)
			throw new IllegalArgumentException("text can not be null");

		HttpRequestBase request = Request.Post("/v2/profile")
				.withContent(text, HTTP.PLAIN_TEXT_TYPE).build();

		HttpResponse response = execute(request);
		try {
			String profileJson = ResponseUtil.getString(response);
			Profile profile = getGson().fromJson(profileJson, Profile.class);
			return profile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
