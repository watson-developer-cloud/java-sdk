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
package com.ibm.watson.developer_cloud.language_translation.v2;


import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concepts;

public class ConceptInsightsExample {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		ConceptInsights service = new ConceptInsights();
		service.setUsernameAndPassword("<username>", "<password>");

		Map<String,Object> params = new HashMap<String, Object>();
		params.put("account_id", "wikipedia");
		params.put("graph", "en-20120601");
		List<String> concepts = new ArrayList<String>();
		concepts.add("/graphs/wikipedia/en-20120601/concepts/IBM_Watson");
		params.put("concepts", concepts);
		params.put("limit", 10);
		params.put("level", 1);

		Concepts result =  service.getGraphsRelatedConcepts(params);

		System.out.println(result);
	}

}
