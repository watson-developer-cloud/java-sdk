/**
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

/**
 * Example of how to create a {@link SolrCluster} with {@link RetrieveAndRank}.
 */
public class CreateASolrClusterExample {
  public static void main(String[] args) throws InterruptedException {

    // 1 create the service
    RetrieveAndRank service = new RetrieveAndRank();
    service.setUsernameAndPassword("<username>", "<password>");

    // 2 create the Solr Cluster
    SolrClusterOptions options = new SolrClusterOptions("<cluster-name>", 1);
    SolrCluster cluster = service.createSolrCluster(options).execute();
    System.out.println("SolrCluster: " + cluster);

    // 2 wait until the Solr Cluster is available
    while (cluster.getStatus() == Status.NOT_AVAILABLE) {
      Thread.sleep(10000); // sleep 10 seconds
      cluster = service.getSolrCluster(cluster.getId()).execute();
      System.out.println("SolrCluster status: " + cluster.getStatus());
    }

    // 3 list Solr Clusters
    System.out.println("Solr clusters: " + service.getSolrClusters().execute());

  }
}
