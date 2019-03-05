/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.natural_language_classifier.v1.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A classifier for natural language phrases.
 */
public class Classifier extends GenericModel {

  /**
   * The state of the classifier.
   */
  public interface Status {
    /** Non Existent. */
    String NON_EXISTENT = "Non Existent";
    /** Training. */
    String TRAINING = "Training";
    /** Failed. */
    String FAILED = "Failed";
    /** Available. */
    String AVAILABLE = "Available";
    /** Unavailable. */
    String UNAVAILABLE = "Unavailable";
  }

  private String name;
  private String url;
  private String status;
  @SerializedName("classifier_id")
  private String classifierId;
  private Date created;
  @SerializedName("status_description")
  private String statusDescription;
  private String language;

  /**
   * Gets the name.
   *
   * User-supplied name for the classifier.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the url.
   *
   * Link to the classifier.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the status.
   *
   * The state of the classifier.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the classifierId.
   *
   * Unique identifier for this classifier.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the created.
   *
   * Date and time (UTC) the classifier was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the statusDescription.
   *
   * Additional detail about the status.
   *
   * @return the statusDescription
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the language.
   *
   * The language used for the classifier.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }
}
