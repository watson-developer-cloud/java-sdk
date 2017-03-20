/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.retrieve_and_rank.v1;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterSizeResponse;

/**
 * Example of how to create and resize a {@link SolrCluster} with {@link RetrieveAndRank}.
 */
public class ResizeASolrClusterExample {
  public static void main(String[] args) throws InterruptedException {

    // 1 create the service
    final RetrieveAndRank service = new RetrieveAndRank();
    service.setUsernameAndPassword("<username>", "<password>");
    // 2 create the Solr Cluster of size 1
    final SolrClusterOptions options = new SolrClusterOptions("<cluster-name>", 1);
    SolrCluster cluster = service.createSolrCluster(options).execute();
    System.out.println("SolrCluster: " + cluster);
    final String solrClusterId = cluster.getId();
    // 2 wait until the Solr Cluster is available
    while (cluster.getStatus() == Status.NOT_AVAILABLE) {
      Thread.sleep(10000); // sleep 10 seconds
      cluster = service.getSolrCluster(solrClusterId).execute();
      System.out.println("SolrCluster status: " + cluster.getStatus());
    }
    // 3 resize the cluster form size 1 to size 2
    final int desiredClusterSize = 2;
    SolrClusterSizeResponse response = service.resizeSolrCluster(solrClusterId, desiredClusterSize).execute();
    System.out.println(response.toString());

    // 4 wait until the resize processs is complete
    while (response.getCurrentSize() != desiredClusterSize) {
      if (response.getStatus() == SolrClusterSizeResponse.Status.ERROR) {
        System.out.println(response.getMessage());
        return;
      }
      System.out.println("Resize status: " + response.getStatus());
      Thread.sleep(10000);
      response = service.getSolrClusterResizeStatus(solrClusterId).execute();
    }
    System.out.println(response.getMessage());
    System.out.println("resize completed");
  }
}
