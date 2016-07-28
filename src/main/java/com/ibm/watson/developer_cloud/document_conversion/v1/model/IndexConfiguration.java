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

import java.util.List;

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
  private Fields fields;

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
  public IndexConfiguration(String serviceInstanceId, String clusterId, String searchCollectionName, Fields fields) {
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
  public Fields getFields() { return fields; }

  /**
   * Fields configuration object. The fields that you want to map, fields that
   * you want to include, and the fields that you want to exclude during indexing
   */
  public static class Fields extends GenericModel {

    /**
     * List of field mappings
     */
    private List<Mapping> mappings;

    /**
     * List of fields to include during indexing
     */
    private List<String> include;

    /**
     * List of fields to exclude during indexing
     */
    private List<String> exclude;

    /**
     * Gets the list of field mappings
     * @return List
     */
    public List<Mapping> getMappings() {
      return mappings;
    }

    /**
     * Gets the list of fields to include
     * @return List
     */
    public List<String> getInclude() {
      return include;
    }

    /**
     * Gets the list of fields to exclude
     * @return
     */
    public List<String> getExclude() {
      return exclude;
    }

    /**
     * Sets the list of field mappings
     * @param mappings list of field mappings to use during indexing
     */
    public void setMappings(List<Mapping> mappings) {
      this.mappings = mappings;
    }

    /**
     * Sets the list of fields to include
     * @param include list of fields to include during indexing
     */
    public void setInclude(List<String> include) {
      this.include = include;
    }

    /**
     * Sets the list of fields to exclude
     * @param exclude list of fields to exclude during indexing
     */
    public void setExclude(List<String> exclude) {
      this.exclude = exclude;
    }
  }

  /**
   * Field Mapping object for indexing. Allows you to map
   * a fields from a certain name to a new name
   */
  public static class Mapping extends GenericModel {

    /**
     * The name of the field that will be mapped
     */
    private String from;

    /**
     * The new name that the field will be mapped to
     */
    private String to;

    /**
     * Creates a Mapping object which allows you to map
     * a field from a certain name to a new name
     * @param from the original name of the field that will be mapped
     * @param to the new name that the field will be mapped to
     */
    public Mapping(String from, String to) {
      this.from = from;
      this.to = to;
    }

    /**
     * Gets the original field name that is being mapped
     * @return String
     */
    public String getFrom() {
      return from;
    }

    /**
     * Gets the new name that the fields will be mapped to
     * @return String
     */
    public String getTo() {
      return to;
    }
  }
}
