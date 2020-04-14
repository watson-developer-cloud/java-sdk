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
package com.ibm.watson.visual_recognition.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;
import java.util.List;

/** Information about a classifier. */
public class Classifier extends GenericModel {

  /** Training status of classifier. */
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
  protected String classifierId;

  protected String name;
  protected String owner;
  protected String status;

  @SerializedName("core_ml_enabled")
  protected Boolean coreMlEnabled;

  protected String explanation;
  protected Date created;
  protected List<Class> classes;
  protected Date retrained;
  protected Date updated;

  /**
   * Gets the classifierId.
   *
   * <p>ID of a classifier identified in the image.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the name.
   *
   * <p>Name of the classifier.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the owner.
   *
   * <p>Unique ID of the account who owns the classifier. Might not be returned by some requests.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Gets the status.
   *
   * <p>Training status of classifier.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the coreMlEnabled.
   *
   * <p>Whether the classifier can be downloaded as a Core ML model after the training status is
   * `ready`.
   *
   * @return the coreMlEnabled
   */
  public Boolean isCoreMlEnabled() {
    return coreMlEnabled;
  }

  /**
   * Gets the explanation.
   *
   * <p>If classifier training has failed, this field might explain why.
   *
   * @return the explanation
   */
  public String getExplanation() {
    return explanation;
  }

  /**
   * Gets the created.
   *
   * <p>Date and time in Coordinated Universal Time (UTC) that the classifier was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the classes.
   *
   * <p>Classes that define a classifier.
   *
   * @return the classes
   */
  public List<Class> getClasses() {
    return classes;
  }

  /**
   * Gets the retrained.
   *
   * <p>Date and time in Coordinated Universal Time (UTC) that the classifier was updated. Might not
   * be returned by some requests. Identical to `updated` and retained for backward compatibility.
   *
   * @return the retrained
   */
  public Date getRetrained() {
    return retrained;
  }

  /**
   * Gets the updated.
   *
   * <p>Date and time in Coordinated Universal Time (UTC) that the classifier was most recently
   * updated. The field matches either `retrained` or `created`. Might not be returned by some
   * requests.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}
