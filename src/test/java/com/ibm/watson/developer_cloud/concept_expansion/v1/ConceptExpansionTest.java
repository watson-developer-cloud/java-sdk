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
package com.ibm.watson.developer_cloud.concept_expansion.v1;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.ConceptExpansionDataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job.Status;

/**
 * The Class ConceptExpansionTest.
 */
public class ConceptExpansionTest extends WatsonServiceTest {

	/** The service. */
	private ConceptExpansion service;

	/* (non-Javadoc)
	 * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		service = new ConceptExpansion();
		service.setUsernameAndPassword(
				prop.getProperty("concept_expansion.username"),
				prop.getProperty("concept_expansion.password")
				);
		service.setEndPoint(prop.getProperty("concept_expansion.url"));
	}

	/**
	 * Should generat a valid payload.
	 */
	@Test
	public void shouldGeneratAValidPayload() {
		String []seeds = new String[]{"motrin","tylenol","aspirin"};
		String label = "medicine";
		service.setDataset(ConceptExpansionDataset.MT_SAMPLES);
		Job job = service.createJob(label, seeds);
		Assert.assertNotNull(job);
	}

	/**
	 * Test create job.
	 */
	@Test
	public void testCreateJob() {
		String []seeds = new String[]{"motrin","tylenol","aspirin"};
		String label = "medicine";
		service.setDataset(ConceptExpansionDataset.MT_SAMPLES);
		Job job = service.createJob(label, seeds);
		Assert.assertNotNull(job);
	}

	/**
	 * Test expand concepts.
	 */
	@Test
	public void testExpandConcepts() {
		String []seeds = new String[]{"motrin","tylenol","aspirin"};
		String label = "medicine";
		service.setDataset(ConceptExpansionDataset.MT_SAMPLES);

		Job job = service.createJob(label, seeds);
		Status status = service.getJobStatus(job);

		while (status == Status.AWAITING_WORK || status == Status.IN_FLIGHT) {
			status = service.getJobStatus(job);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (status == Status.DONE) {
			List<Concept> concepts = service.getJobResult(job);
			Assert.assertNotNull(concepts);
		} else {
			Assert.fail("The concept coudn't be expanded");
		}
	}

	/**
	 * Test missing dataset.
	 */
	@Test
	public void testMissingDataset() {
		boolean fail = true;
		service.setDataset(null);
		try {
			service.createJob("X", null);
		} catch (IllegalArgumentException e) {
			fail = false;
		}
		Assert.assertFalse(fail);
	}

}
