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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.RelationshipExtractionDataset;

/**
 * The Class RelationshipExtractionTest.
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 */
public class RelationshipExtractionTest extends WatsonServiceTest {

	/**
	 * The service.
	 */
	private RelationshipExtraction service;

	/* (non-Javadoc)
	 * @see com.ibm.watson.developercloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new RelationshipExtraction();
		service.setUsernameAndPassword(
				prop.getProperty("relationship_extraction.username"),
				prop.getProperty("relationship_extraction.password")
				);
		service.setEndPoint(prop.getProperty("relationship_extraction.url"));
	}

	/**
	 * Test extract.
	 */
	@Test
	public void testExtract() {
		service.setDataset(RelationshipExtractionDataset.ENGLISH_NEWS);
		String response = service.extract("IBM Watson Developer Cloud");
		Assert.assertNotNull(response);
	}

	/**
	 * Test missing dataset.
	 */
	@Test
	public void testMissingDataset() {
		service.setDataset(null);
		boolean fail = true;
		try {
			service.extract("IBM Watson Developer Cloud");
		} catch (IllegalArgumentException e) {
			fail = false;
		}
		Assert.assertFalse(fail);
	}

}
