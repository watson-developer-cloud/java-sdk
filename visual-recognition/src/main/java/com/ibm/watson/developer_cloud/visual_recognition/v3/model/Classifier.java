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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Information about a classifier.
 */
public class Classifier extends GenericModel {

  /**
   * The training status of classifier.
   */
  public interface Status {
    /** ready. */
    String READY = "ready";
    /** training. */
    String TRAINING = "training";
    /** retraining. */
    String RETRAINING = "retraining";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("classifier_id")
  private String classifierId;
  private String name;
  private String owner;
  private String status;
  @SerializedName("core_ml_enabled")
  private Boolean coreMlEnabled;
  private String explanation;
  private Date created;
  private List<Class> classes;
  private Date retrained;
  private Date updated;

  /**
   * Gets the classifierId.
   *
   * ID of a classifier identified in the image.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the name.
   *
   * Name of the classifier.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the owner.
   *
   * Unique ID of the account who owns the classifier. Returned when verbose=`true`. Might not be returned by some
   * requests.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the status.
   *
   * The training status of classifier.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the coreMlEnabled.
   *
   * Whether the classifier can be downloaded as a Core ML model after the training status is `ready`.
   *
   * @return the coreMlEnabled
   */
  public Boolean isCoreMlEnabled() {
    return coreMlEnabled;
  }

  /**
   * Gets the explanation.
   *
   * If classifier training has failed, this field may explain why.
   *
   * @return the explanation
   */
  public String getExplanation() {
    return explanation;
  }

  /**
   * Gets the created.
   *
   * Date and time in Coordinated Universal Time (UTC) that the classifier was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the classes.
   *
   * Array of classes that define a classifier.
   *
   * @return the classes
   */
  public List<Class> getClasses() {
    return classes;
  }

  /**
   * Gets the retrained.
   *
   * Date and time in Coordinated Universal Time (UTC) that the classifier was updated. Returned when verbose=`true`.
   * Might not be returned by some requests. Identical to `updated` and retained for backward compatibility.
   *
   * @return the retrained
   */
  public Date getRetrained() {
    return retrained;
  }

  /**
   * Gets the updated.
   *
   * Date and time in Coordinated Universal Time (UTC) that the classifier was most recently updated. The field matches
   * either `retrained` or `created`. Returned when verbose=`true`. Might not be returned by some requests.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}
