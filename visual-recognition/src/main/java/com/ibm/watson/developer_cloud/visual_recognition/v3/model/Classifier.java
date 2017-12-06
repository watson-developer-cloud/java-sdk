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
  private String explanation;
  private Date created;
  private List<Class> classes;

  /**
   * Gets the classifierId.
   *
   * The ID of the classifier.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the name.
   *
   * The name of the classifier.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the owner.
   *
   * Unique ID of the account who owns the classifier.
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
   * Gets the explanation.
   *
   * If classifier training has failed, this field may explain why
   *
   * @return the explanation
   */
  public String getExplanation() {
    return explanation;
  }

  /**
   * Gets the created.
   *
   * The time and date when classifier was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the classes.
   *
   * An array of classes that define a classifier.
   *
   * @return the classes
   */
  public List<Class> getClasses() {
    return classes;
  }

  /**
   * Sets the classifierId.
   *
   * @param classifierId the new classifierId
   */
  public void setClassifierId(final String classifierId) {
    this.classifierId = classifierId;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Sets the owner.
   *
   * @param owner the new owner
   */
  public void setOwner(final String owner) {
    this.owner = owner;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Sets the explanation.
   *
   * @param explanation the new explanation
   */
  public void setExplanation(final String explanation) {
    this.explanation = explanation;
  }

  /**
   * Sets the created.
   *
   * @param created the new created
   */
  public void setCreated(final Date created) {
    this.created = created;
  }

  /**
   * Sets the classes.
   *
   * @param classes the new classes
   */
  public void setClasses(final List<Class> classes) {
    this.classes = classes;
  }
}
