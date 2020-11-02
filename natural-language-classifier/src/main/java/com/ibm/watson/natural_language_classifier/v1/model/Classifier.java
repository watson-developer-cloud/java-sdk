/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.watson.natural_language_classifier.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** A classifier for natural language phrases. */
public class Classifier extends GenericModel {

  /** The state of the classifier. */
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

  protected String name;
  protected String url;
  protected String status;

  @SerializedName("classifier_id")
  protected String classifierId;

  protected Date created;

  @SerializedName("status_description")
  protected String statusDescription;

  protected String language;

  /**
   * Gets the name.
   *
   * <p>User-supplied name for the classifier.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the url.
   *
   * <p>Link to the classifier.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the status.
   *
   * <p>The state of the classifier.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the classifierId.
   *
   * <p>Unique identifier for this classifier.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the created.
   *
   * <p>Date and time (UTC) the classifier was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the statusDescription.
   *
   * <p>Additional detail about the status.
   *
   * @return the statusDescription
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  /**
   * Gets the language.
   *
   * <p>The language used for the classifier.
   *
   * @return the language
   */
  public String getLanguage() {
    return language;
  }
}
