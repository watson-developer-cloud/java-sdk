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

import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Dataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;

public class ConceptExpansionExample {


  public static void main(String[] args) {
    final ConceptExpansion service = new ConceptExpansion();
    service.setUsernameAndPassword("<username>", "<password>");

    final String[] seeds = new String[] {"motrin", "tylenol", "aspirin"};
    final String label = "medicine";
    service.setDataset(Dataset.MT_SAMPLES);
    final Job job = service.createJob(label, seeds);

    while (service.getJobStatus(job) == Job.Status.AWAITING_WORK
        || service.getJobStatus(job) == Job.Status.IN_FLIGHT) {
      try {
        Thread.sleep(4000);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(service.getJobResult(job));
  }
}
