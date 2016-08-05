/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure that stores the configuration for the Retrieve and Rank service
 * when indexing documents through the Document Conversion service
 *
 * @see DocumentConversion
 * @see RetrieveAndRank
 */
public class IndexConfiguration extends GenericModel {

  /**
   * The instance id for the Retrieve and Rank service
   */
  private String serviceInstanceId;

  /**
   * The Solr cluster id from the Retrieve and Rank service
   */
  private String clusterId;

  /**
   * The Solr search collection name
   */
  private String searchCollectionName;

  /**
   * The fields configuration object. Allows you to specify field mappings,
   * field mappings, fields to include, and fields to exclude during indexing
   */
  private IndexFields fields;

  /**
   * Constructor for the Retrieve and Rank configuration. You will need to get Retrieve and Rank
   * service credentials and create a Solr cluster through the Retrieve and Rank service prior
   * to creating this configuration object.
   * @param serviceInstanceId The instance id for the Retrieve and Rank service
   * @param clusterId The Solr cluster id from the Retrieve and Rank service
   * @param searchCollectionName The Solr search collection name
   *
   * @see RetrieveAndRank
   */
  public IndexConfiguration(String serviceInstanceId, String clusterId, String searchCollectionName) {
    this(serviceInstanceId, clusterId, searchCollectionName, null);
  }

  /**
   * Constructor for the Retrieve and Rank configuration. You will need to get Retrieve and Rank
   * service credentials and create a Solr cluster through the Retrieve and Rank service prior
   * to creating this configuration object.
   * @param serviceInstanceId The instance id for the Retrieve and Rank service
   * @param clusterId The Solr cluster id from the Retrieve and Rank service
   * @param searchCollectionName The Solr search collection name
   * @param fields The field mapping object to pass to the Retrieve and Rank service
   *
   * @see RetrieveAndRank
   */
  public IndexConfiguration(String serviceInstanceId, String clusterId, String searchCollectionName, IndexFields fields) {
    this.serviceInstanceId = serviceInstanceId;
    this.clusterId = clusterId;
    this.searchCollectionName = searchCollectionName;
    this.fields = fields;
  }

  /**
   * Gets the service instance id for the Retrieve and Rank service
   * @return String
   */
  public String getServiceInstanceId() { return serviceInstanceId; }

  /**
   * Gets the cluster id for the Retrieve and Rank service
   * @return String
   */
  public String getClusterId() { return clusterId; }

  /**
   * Gets the search collection name for the Retrieve and Rank service
   * @return String
   */
  public String getSearchCollectionName() { return searchCollectionName; }

  /**
   * Gets the fields object to pass to the Retrieve and Rank service
   * @return Fields
   */
  public IndexFields getFields() { return fields; }

}
