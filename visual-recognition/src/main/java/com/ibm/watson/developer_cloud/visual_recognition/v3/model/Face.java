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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

/**
 * This class represent a detected face by {@link VisualRecognition#detectFaces(VisualRecognitionOptions)} .
 *
 * @see VisualRecognition
 */
public class Face {

  /**
   * The age of a detected face.
   */
  public class Age {

    private Integer max;
    private Integer min;
    private Double score;

    /**
     * Gets the max.
     *
     * @return The max
     */
    public Integer getMax() {
      return max;
    }

    /**
     * Gets the min.
     *
     * @return The min
     */
    public Integer getMin() {
      return min;
    }

    /**
     * Gets the score.
     *
     * @return The score
     */
    public Double getScore() {
      return score;
    }

    /**
     * Sets the max.
     *
     * @param max The max
     */
    public void setMax(Integer max) {
      this.max = max;
    }

    /**
     * Sets the min.
     *
     * @param min The min
     */
    public void setMin(Integer min) {
      this.min = min;
    }

    /**
     * Sets the score.
     *
     * @param score The score
     */
    public void setScore(Double score) {
      this.score = score;
    }

  }

  /**
   * The gender of a detected face.
   */
  public class Gender {

    private String gender;
    private Double score;

    /**
     * Gets the gender.
     *
     * @return The gender
     */
    public String getGender() {
      return gender;
    }

    /**
     * Gets the score.
     *
     * @return The score
     */
    public Double getScore() {
      return score;
    }

    /**
     * Sets the gender.
     *
     * @param gender The gender
     */
    public void setGender(String gender) {
      this.gender = gender;
    }

    /**
     * Sets the score.
     *
     * @param score The score
     */
    public void setScore(Double score) {
      this.score = score;
    }

  }

  /**
   * The identity of a detected face.
   */
  public class Identity {
    private String name;
    private Double score;
    @SerializedName("type_hierarchy")
    private String typeHierarchy;

    /**
     * Gets the name.
     *
     * @return The name
     */
    public String getName() {
      return name;
    }

    /**
     * Gets the score.
     *
     * @return The score
     */
    public Double getScore() {
      return score;
    }

    /**
     * Gets the type hierarchy.
     *
     * @return The typeHierarchy
     */
    public String getTypeHierarchy() {
      return typeHierarchy;
    }

    /**
     * Sets the name.
     *
     * @param name The name
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * Sets the score.
     *
     * @param score The score
     */
    public void setScore(Double score) {
      this.score = score;
    }

    /**
     * Sets the type hierarchy.
     *
     * @param typeHierarchy The type_hierarchy
     */
    public void setTypeHierarchy(String typeHierarchy) {
      this.typeHierarchy = typeHierarchy;
    }

  }

  private Age age;

  private Gender gender;
  private Identity identity;
  @SerializedName("face_location")
  private Location location;

  /**
   * Gets the age.
   *
   * @return The age
   */
  public Age getAge() {
    return age;
  }

  /**
   * Gets the gender.
   *
   * @return The gender
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * Gets the identity.
   *
   * @return The identity
   */
  public Identity getIdentity() {
    return identity;
  }

  /**
   * Gets the location.
   *
   * @return The location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Sets the age.
   *
   * @param age The age
   */
  public void setAge(Age age) {
    this.age = age;
  }

  /**
   * Sets the gender.
   *
   * @param gender The gender
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * Sets the identity.
   *
   * @param identity The identity
   */
  public void setIdentity(Identity identity) {
    this.identity = identity;
  }

  /**
   * Sets the location.
   *
   * @param location the new location
   */
  public void setLocation(Location location) {
    this.location = location;
  }

}
