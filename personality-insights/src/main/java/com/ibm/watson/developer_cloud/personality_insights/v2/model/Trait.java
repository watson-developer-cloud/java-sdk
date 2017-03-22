/**
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
package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * The personality trait/model POJO class.
 */
public class Trait extends GenericModel {
  private String category;
  private List<Trait> children;
  private String id;
  private String name;
  private Double percentage;
  @SerializedName("raw_sampling_error")
  private Double rawSamplingError;
  @SerializedName("raw_score")
  private Double rawScore;
  @SerializedName("sampling_error")
  private Double samplingError;

  /**
   * Gets the personality model category. e.g: "values", "needs" or "personality"
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Gets the characteristic children.
   *
   * @return the children
   */
  public List<Trait> getChildren() {
    return children;
  }

  /**
   * Gets id of the characteristic, globally unique.
   *
   * @return the characteristic identifier
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the user-displayable name of the characteristic.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the normalized value of the characteristic, from 0-1. For example, if the percentage for Openness is 0.25, you
   * scored in the 25th percentile. You are more open than 24% of the population and less open than 74% of the
   * population.,
   *
   * @return the percentage
   */
  public Double getPercentage() {
    return percentage;
  }

  /**
   * Gets the raw sampling error.
   *
   * @return the raw sampling error
   */
  public Double getRawSamplingError() {
    return rawSamplingError;
  }

  /**
   * Gets the raw score.
   *
   * @return the raw score
   */
  public Double getRawScore() {
    return rawScore;
  }

  /**
   * Indicates the sampling error of the percentage, based on the number of words in the input. The number defines a 95%
   * confidence interval around the percentage. For example, the sampling error is 4% and percentage is 61%. It is 95%
   * likely that the actual percentage value is between 57% and 65% if more words are given.
   *
   * @return the sampling error
   */
  public Double getSamplingError() {
    return samplingError;
  }

  /**
   * Sets personality model category. e.g: "values", "needs" or "personality"
   *
   * @param category the new category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Sets the characteristic children.
   *
   * @param children the new children
   */
  public void setChildren(List<Trait> children) {
    this.children = children;
  }

  /**
   * Sets the id of the characteristic, globally unique.
   *
   * @param id the characteristic identifier
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the user-displayable name of the characteristic.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the normalized value of the characteristic, from 0-1.
   *
   * @param percentage the new percentage value from 0-1
   */
  public void setPercentage(Double percentage) {
    this.percentage = percentage;
  }

  /**
   * Sets the raw sampling error.
   *
   * @param rawSamplingError the new raw sampling error
   */
  public void setRawSamplingError(Double rawSamplingError) {
    this.rawSamplingError = rawSamplingError;
  }

  /**
   * Sets the raw score.
   *
   * @param rawScore the new raw score
   */
  public void setRawScore(Double rawScore) {
    this.rawScore = rawScore;
  }

  /**
   * Sets the sampling error of the percentage based on the number of words in the input.
   *
   * @param samplingError error the new sampling error
   */
  public void setSamplingError(Double samplingError) {
    this.samplingError = samplingError;
  }


}
