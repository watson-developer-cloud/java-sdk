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
package com.ibm.watson.developer_cloud.language_identification.v1;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.language_identification.v1.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Language Identification service identifies the language in which text is
 * written.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/language-identification.html">
 *      Language Identification</a>
 */
public class LanguageIdentification extends WatsonService {

	/** The Constant LANG. */
	private static final String LANG = "lang";
	
	/** The url. */
	private static String URL = "https://gateway.watsonplatform.net/language-identification-beta/api";

	/**
	 * Instantiates a new language identification.
	 */
	public LanguageIdentification() {
		setEndPoint(URL);
	}

	/**
	 * Identify language in which text is written.
	 * 
	 * @param text
	 *            the text to identify
	 * @return the identified language
	 */
	public IdentifiedLanguage identify(final String text) {
		HttpRequestBase request = Request.Post("/v1/txtlid/0")
				.withForm("sid", "lid-generic", "rt", "json", "txt", text)
				.build();

		try {
			HttpResponse response = execute(request);
			JsonObject jsonObject = ResponseUtil.getJsonObject(response);
			return new IdentifiedLanguage(jsonObject.get(LANG).getAsString());
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
		builder.append("LanguageIdentification [getEndPoint()=");
		builder.append(getEndPoint());
		builder.append("]");
		return builder.toString();
	}

}
