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
package com.ibm.watson.developer_cloud.visual_recognition.v2_beta.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.visual_recognition.v2_beta.VisualRecognition;

/**
 * Classifier used by the {@link VisualRecognition} V2 service.
 */
public class VisualClassifier extends GenericModel {

  private Date created;
  @SerializedName("classifier_id")
  private String id;
  private String name;
  private String owner;
  
  private Status status;

  /**
   * {@link VisualClassifier} Status.
   */
  public enum Status {
    @SerializedName("Available") AVAILABLE,
    @SerializedName("Failed") FAILED,
    @SerializedName("Non Existent") NON_EXISTENT,
    @SerializedName("Training") TRAINING,
    @SerializedName("Unavailable") UNAVAILABLE
  }
  
  /**
   * Instantiates a new visual classifier.
   */
  public VisualClassifier() {}

  /**
   * Instantiates a new visual classifier.
   * 
   * @param id the id
   */
  public VisualClassifier(String id) {
    this();
    this.id = id;
  }

  /**
   * Gets the created.
   * 
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the classifier id.
   * 
   * @return the classifier id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the owner.
   * 
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Sets the created.
   * 
   * @param created the created to set
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Sets the classifier id.
   * 
   * @param id the new classifier id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the name.
   * 
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the owner.
   * 
   * @param owner the owner to set
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
