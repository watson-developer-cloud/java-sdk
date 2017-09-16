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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Classifier and score combination.
 */
public class ClassifierResult extends GenericModel {

  private String name;
  @SerializedName("classifier_id")
  private String classifierId;
  private List<ClassResult> classes;

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
   * Gets the classifierId.
   *
   * Classifier ID. Only returned if custom classifier.
   *
   * @return the classifierId
   */
  public String getClassifierId() {
    return classifierId;
  }

  /**
   * Gets the classes.
   *
   * An array of classes within a classifier.
   *
   * @return the classes
   */
  public List<ClassResult> getClasses() {
    return classes;
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
   * Sets the classifierId.
   *
   * @param classifierId the new classifierId
   */
  public void setClassifierId(final String classifierId) {
    this.classifierId = classifierId;
  }

  /**
   * Sets the classes.
   *
   * @param classes the new classes
   */
  public void setClasses(final List<ClassResult> classes) {
    this.classes = classes;
  }
}
