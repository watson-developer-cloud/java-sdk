/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */
package com.ibm.watson.developer_cloud.concept_insights.v2;


import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;

public class ConceptInsightsExample {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		ConceptInsights service = new ConceptInsights();
		service.setUsernameAndPassword("<username>", "<password>");

		Map<String,Object> params = new HashMap<String, Object>();
		params.put(ConceptInsights.ACCOUNT_ID, "wikipedia");
		params.put(ConceptInsights.GRAPH, "en-20120601");
		params.put(ConceptInsights.TEXT, "IBM Watson won the Jeopardy television show hosted by Alex Trebek");

		Annotations annotations =  service.annotateText(params);

		System.out.println(annotations);
	}

}
