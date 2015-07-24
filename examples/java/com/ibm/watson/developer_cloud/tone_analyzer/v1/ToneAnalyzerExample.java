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
package com.ibm.watson.developer_cloud.tone_analyzer.v1;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Scorecard;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.SynonymResult;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;

public class ToneAnalyzerExample {


	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		ToneAnalyzer service = new ToneAnalyzer();
		service.setUsernameAndPassword("<username>", "<password>");

		String text = "I know the times are difficult! Our sales have been "
			+ "disappointing for the past three quarters for our data analytics "
			+ "product suite. We have a competitive data analytics product "
			+ "suite in the industry. But we need to do our job selling it! "
			+ "We need to acknowledge and fix our sales challenges. "
			+ "We can’t blame the economy for our lack of execution! "
			+ "We are missing critical sales opportunities. "
			+ "Our product is in no way inferior to the competitor products. "
			+ "Our clients are hungry for analytical tools to improve their "
			+ "business outcomes. Economy has nothing to do with it.";
		
		// Call the service and get the tone
		Tone tone = service.getTone(text, Scorecard.EMAIL);
		System.out.println(tone);

		// Call the service and get the synonym for 'difficult'
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ToneAnalyzer.WORDS, new String[]{"difficult","inferior"});
		params.put(ToneAnalyzer.LIMIT, 3);
		params.put(ToneAnalyzer.HOPS, 3);
		
		List<SynonymResult> synonyms = service.getSynonyms(params);
		System.out.println(synonyms);
	}
}
