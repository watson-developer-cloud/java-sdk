/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Details about a specific project. */
public class ProjectListDetails extends GenericModel {

  /**
   * The type of project.
   *
   * <p>The `content_intelligence` type is a *Document Retrieval for Contracts* project and the
   * `other` type is a *Custom* project.
   *
   * <p>The `content_mining` and `content_intelligence` types are available with Premium plan
   * managed deployments and installed deployments only.
   */
  public interface Type {
    /** document_retrieval. */
    String DOCUMENT_RETRIEVAL = "document_retrieval";
    /** conversational_search. */
    String CONVERSATIONAL_SEARCH = "conversational_search";
    /** content_mining. */
    String CONTENT_MINING = "content_mining";
    /** content_intelligence. */
    String CONTENT_INTELLIGENCE = "content_intelligence";
    /** other. */
    String OTHER = "other";
  }

  @SerializedName("project_id")
  protected String projectId;

  protected String name;
  protected String type;

  @SerializedName("relevancy_training_status")
  protected ProjectListDetailsRelevancyTrainingStatus relevancyTrainingStatus;

  @SerializedName("collection_count")
  protected Long collectionCount;

  /**
   * Gets the projectId.
   *
   * <p>The unique identifier of this project.
   *
   * @return the projectId
   */
  public String getProjectId() {
    return projectId;
  }

  /**
   * Gets the name.
   *
   * <p>The human readable name of this project.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the type.
   *
   * <p>The type of project.
   *
   * <p>The `content_intelligence` type is a *Document Retrieval for Contracts* project and the
   * `other` type is a *Custom* project.
   *
   * <p>The `content_mining` and `content_intelligence` types are available with Premium plan
   * managed deployments and installed deployments only.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the relevancyTrainingStatus.
   *
   * <p>Relevancy training status information for this project.
   *
   * @return the relevancyTrainingStatus
   */
  public ProjectListDetailsRelevancyTrainingStatus getRelevancyTrainingStatus() {
    return relevancyTrainingStatus;
  }

  /**
   * Gets the collectionCount.
   *
   * <p>The number of collections configured in this project.
   *
   * @return the collectionCount
   */
  public Long getCollectionCount() {
    return collectionCount;
  }
}
