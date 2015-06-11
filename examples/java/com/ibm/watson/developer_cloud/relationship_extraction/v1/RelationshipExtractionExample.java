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
package com.ibm.watson.developer_cloud.relationship_extraction.v1;

import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.RelationshipExtractionDataset;


public class RelationshipExtractionExample {

	public static void main(String[] args) {
		RelationshipExtraction service = new RelationshipExtraction();
		service.setUsernameAndPassword("<username>", "<password>");

		service.setDataset(RelationshipExtractionDataset.ENGLISH_NEWS);
		String response = service.extract("IBM Watson developer cloud");

		System.out.println(response);
	}
}
