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
package com.ibm.watson.developer_cloud.machine_translation.v1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.ibm.watson.developer_cloud.machine_translation.v1.model.Language;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Machine Translation service translate text from one language to another.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/machine-translation.html">
 *      Machine Translation</a>
 */
public class MachineTranslation extends WatsonService {

	/** The url. */
	private static String URL = "https://gateway.watsonplatform.net/machine-translation-beta/api";
	
	/** The supported sids. */
	private static List<String> supportedSids = new ArrayList<String>();

	static {
		supportedSids.add("mt-enus-eses");
		supportedSids.add("mt-eses-enus");
		supportedSids.add("mt-enus-frfr");
		supportedSids.add("mt-enus-ptbr");
		supportedSids.add("mt-enus-zhcn");
		supportedSids.add("mt-frfr-enus");
		supportedSids.add("mt-ptbr-enus");
		supportedSids.add("mt-zhcn-enus");
	}

	/**
	 * Creates the sid.
	 * 
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * 
	 * @return the string
	 */
	private static String createSid(final Language from, final Language to) {
		return String.format("mt-%s-%s", from.getId(), to.getId());
	}

	/**
	 * Instantiates a new machine translation.
	 */
	public MachineTranslation() {
		setEndPoint(URL);
	}

	/**
	 * Translate text from one language to another.
	 * 
	 * @param text
	 *            the text to translate
	 * @param from
	 *            the origin language
	 * @param to
	 *            the target language
	 * @return the translated result
	 */
	public String translate(final String text, final Language from, final Language to) {
		String sid = createSid(from, to);

		if (!supportedSids.contains(sid))
			throw new IllegalArgumentException(String.format(
					"Translation from: %s to: %s is not supported.", from, to));

		try {
			HttpRequestBase request = Request.Post("/v1/smt/0")
					.withForm("sid", sid, "rt", "text", "txt", text).build();

			HttpResponse response = execute(request);

			return ResponseUtil.getString(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
