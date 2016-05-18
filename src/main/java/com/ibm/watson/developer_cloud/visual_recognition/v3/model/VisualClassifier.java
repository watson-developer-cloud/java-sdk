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
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.visual_recognition.v2_beta.VisualRecognition;

/**
 * Classifier used by the {@link VisualRecognition} service.
 */
public class VisualClassifier extends GenericModel {

  /**
   * Classifier.
   */
  public class VisualClass {
    @SerializedName("class")
    private String name;
    private Double score;
    @SerializedName("type_hierarchy")
    private String typeHierarchy;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
      return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * Gets the score.
     *
     * @return the score
     */
    public Double getScore() {
      return score;
    }

    /**
     * Sets the score.
     *
     * @param score the new score
     */
    public void setScore(Double score) {
      this.score = score;
    }

    /**
     * Gets the type hierarchy.
     *
     * @return the type hierarchy
     */
    public String getTypeHierarchy() {
      return typeHierarchy;
    }

    /**
     * Sets the type hierarchy.
     *
     * @param typeHierarchy the new type hierarchy
     */
    public void setTypeHierarchy(String typeHierarchy) {
      this.typeHierarchy = typeHierarchy;
    }
  }

  @SerializedName("classifier_id")
  private String id;
  private String name;
  private List<VisualClass> classes;

  private String owner;
  private Date created;
  private String explanation;
  private Status status;



  /**
   * {@link VisualClassifier} Status.
   */
  public enum Status {
    
    /** The available. */
    @SerializedName("ready") AVAILABLE,
    
    /** The failed. */
    @SerializedName("failed") FAILED,
    
    /** The non existent. */
    @SerializedName("Non Existent") NON_EXISTENT,
    
    /** The training. */
    @SerializedName("training") TRAINING,
    
    /** The unavailable. */
    @SerializedName("unavailable") UNAVAILABLE
  }
  
  /**
   * Gets the explanation.
   *
   * @return the explanation
   */
  public String getExplanation() {
    return explanation;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Sets the explanation.
   *
   * @param explanation the new explanation
   */
  public void setExplanation(String explanation) {
    this.explanation = explanation;
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

  /**
   * Gets the classes.
   *
   * @return the classes
   */
  public List<VisualClass> getClasses() {
    return classes;
  }

  /**
   * Sets the classes.
   *
   * @param classes the new classes
   */
  public void setClasses(List<VisualClass> classes) {
    this.classes = classes;
  }
}
