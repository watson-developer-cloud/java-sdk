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
package retrieve_and_rank.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import service_core.service.model.GenericModel;

/**
 * Response from requesting a list of provisioned Solr Clusters.
 */
public class SolrClusters extends GenericModel {
  @SerializedName(ApiConstants.SOLR_CLUSTER_RESPONSES)
  private final List<SolrCluster> solrClusters;

  /**
   * Instantiates a new solr cluster list.
   * 
   * @param solrClusterResponses the solr cluster responses
   */
  public SolrClusters(final List<SolrCluster> solrClusterResponses) {
    this.solrClusters = solrClusterResponses;
  }

  /**
   * Gets the solr cluster responses.
   * 
   * @return the solr cluster responses
   */
  public List<SolrCluster> getSolrClusters() {
    return solrClusters;
  }

}
