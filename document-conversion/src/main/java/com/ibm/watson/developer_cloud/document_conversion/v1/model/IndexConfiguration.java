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
package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure that stores the configuration for the Retrieve and Rank service when indexing documents through the
 * Document Conversion service.
 *
 * @see DocumentConversion
 */
public class IndexConfiguration extends GenericModel {

  /**
   * The Solr cluster id from the Retrieve and Rank service.
   */
  private String clusterId;

  /**
   * The fields configuration object. Allows you to specify field mappings, field mappings, fields to include, and
   * fields to exclude during indexing
   */
  private IndexFields fields;

  /**
   * The Solr search collection name.
   */
  private String searchCollectionName;

  /**
   * The instance id for the Retrieve and Rank service.
   */
  private String serviceInstanceId;

  /**
   * Constructor for the Retrieve and Rank configuration. You will need to get Retrieve and Rank service credentials and
   * create a Solr cluster through the Retrieve and Rank service prior to creating this configuration object.
   *
   * @param serviceInstanceId The instance id for the Retrieve and Rank service. To find your
   *        <code>service_instance_id</code>, click the tile for your service in Bluemix, and then look at the URL in
   *        the browser for the <code>serviceGuid=</code> request parameter. The value for
   *        <code>service_instance_id</code> is the value for <code>serviceGuid</code>.
   * @param clusterId The Solr cluster id from the Retrieve and Rank service
   * @param searchCollectionName The Solr search collection name
   *
   */
  public IndexConfiguration(String serviceInstanceId, String clusterId, String searchCollectionName) {
    this(serviceInstanceId, clusterId, searchCollectionName, null);
  }

  /**
   * Constructor for the Retrieve and Rank configuration. You will need to get Retrieve and Rank service credentials and
   * create a Solr cluster through the Retrieve and Rank service prior to creating this configuration object.
   *
   * @param serviceInstanceId The instance id for the Retrieve and Rank service
   * @param clusterId The Solr cluster id from the Retrieve and Rank service
   * @param searchCollectionName The Solr search collection name
   * @param fields The field mapping object to pass to the Retrieve and Rank service
   *
   */
  public IndexConfiguration(String serviceInstanceId, String clusterId, String searchCollectionName,
      IndexFields fields) {
    this.serviceInstanceId = serviceInstanceId;
    this.clusterId = clusterId;
    this.searchCollectionName = searchCollectionName;
    this.fields = fields;
  }

  /**
   * Gets the cluster id for the Retrieve and Rank service.
   *
   * @return String the cluster id
   */
  public String getClusterId() {
    return clusterId;
  }

  /**
   * Gets the fields object to pass to the Retrieve and Rank service.
   *
   * @return Fields the fields
   */
  public IndexFields getFields() {
    return fields;
  }

  /**
   * Gets the search collection name for the Retrieve and Rank service.
   *
   * @return String the collection name
   */
  public String getSearchCollectionName() {
    return searchCollectionName;
  }

  /**
   * Gets the service instance id for the Retrieve and Rank service. To find your <code>service_instance_id</code>,
   * click the tile for your service in Bluemix, and then look at the URL in the browser for the
   * <code>serviceGuid=</code> request parameter. The value for <code>service_instance_id</code> is the value for
   * <code>serviceGuid</code>.
   *
   * @return String the service instance id
   */
  public String getServiceInstanceId() {
    return serviceInstanceId;
  }

}
