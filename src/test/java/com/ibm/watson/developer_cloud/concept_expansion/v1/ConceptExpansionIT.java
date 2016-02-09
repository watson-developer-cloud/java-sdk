/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.concept_expansion.v1;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Dataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job.Status;

public class ConceptExpansionIT extends WatsonServiceTest {

  private ConceptExpansion service;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new ConceptExpansion();
    service.setUsernameAndPassword(getValidProperty("concept_expansion.username"),
        getValidProperty("concept_expansion.password"));
    service.setEndPoint(getValidProperty("concept_expansion.url"));
    service.setDefaultHeaders(getDefaultHeaders());
  }

  /**
   * Test expand concepts.
   */
  @Test
  public void testExpandConcepts() {
    final String[] seeds = new String[] {"motrin", "tylenol", "aspirin"};
    final String label = "medicine";
    service.setDataset(Dataset.MT_SAMPLES);

    final Job job = service.createJob(label, seeds);
    Status status = service.getJobStatus(job);

    while (status == Status.AWAITING_WORK || status == Status.IN_FLIGHT) {
      status = service.getJobStatus(job);
      try {
        Thread.sleep(2000);
      } catch (final InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    if (status == Status.DONE) {
      final List<Concept> concepts = service.getJobResult(job);
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
      service.createJob("X", new String[] {"foo", "bar"});
    } catch (final IllegalArgumentException e) {
      fail = false;
    }
    Assert.assertFalse(fail);
  }

}
