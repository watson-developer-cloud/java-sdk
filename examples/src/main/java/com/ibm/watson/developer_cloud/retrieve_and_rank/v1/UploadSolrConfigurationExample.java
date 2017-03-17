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

import java.io.File;
import java.util.List;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;

/**
 * Creates a SolrClusterConfiguration using the {@link RetrieveAndRank} service.
 * <p>
 * You must first create a Solr cluster and specify its ID here. A Solr cluster can be created with the
 * {@link CreateASolrClusterExample}.
 */
public class UploadSolrConfigurationExample {

  public static void main(String[] args) {
    // 1 create the service
    RetrieveAndRank service = new RetrieveAndRank();
    service.setUsernameAndPassword("<username>", "<password>");

    // 2 return the existing SolrCluster using the id
    SolrCluster cluster = service.getSolrCluster("<solr-cluster-id>").execute();
    System.out.println("SolrCluster: " + cluster);

    // 3 upload the Solr configuration directory
    File directory = new File("src/test/resources/retrieve_and_rank");
    service.uploadSolrClusterConfigurationDirectory(cluster.getId(), "<config-name>", directory);

    // 4 list the existing solr configurations
    List<String> configs = service.getSolrClusterConfigurations(cluster.getId()).execute().getSolrConfigs();
    System.out.println("Solr configurations: " + configs);
  }
}
