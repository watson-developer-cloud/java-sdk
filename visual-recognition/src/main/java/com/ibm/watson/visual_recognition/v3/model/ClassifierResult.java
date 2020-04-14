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
import java.util.List;

/** Classifier and score combination. */
public class ClassifierResult extends GenericModel {

  protected String name;

  @SerializedName("classifier_id")
  protected String classifierId;

  protected List<ClassResult> classes;

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
   * Gets the classes.
   *
   * <p>Classes within the classifier.
   *
   * @return the classes
   */
  public List<ClassResult> getClasses() {
    return classes;
  }
}
