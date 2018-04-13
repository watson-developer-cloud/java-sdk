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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Provides information about the face.
 */
public class Face extends GenericModel {

  private FaceAge age;
  private FaceGender gender;
  @SerializedName("face_location")
  private FaceLocation faceLocation;

  /**
   * Gets the age.
   *
   * @return the age
   */
  public FaceAge getAge() {
    return age;
  }

  /**
   * Gets the gender.
   *
   * @return the gender
   */
  public FaceGender getGender() {
    return gender;
  }

  /**
   * Gets the faceLocation.
   *
   * @return the faceLocation
   */
  public FaceLocation getFaceLocation() {
    return faceLocation;
  }
}
