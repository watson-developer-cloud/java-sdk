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
package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Trait.
 */
public class Trait extends GenericModel {

  /**
   * The category of the characteristic: * `personality` for Big Five personality characteristics * `needs` for Needs *
   * `values` for Values.
   */
  public interface Category {
    /** personality. */
    String PERSONALITY = "personality";
    /** needs. */
    String NEEDS = "needs";
    /** values. */
    String VALUES = "values";
  }

  @SerializedName("trait_id")
  private String traitId;
  private String name;
  private String category;
  private Double percentile;
  @SerializedName("raw_score")
  private Double rawScore;
  private Boolean significant;
  private List<Trait> children;

  /**
   * Gets the traitId.
   *
   * The unique identifier of the characteristic to which the results pertain. IDs have the form `big5_{characteristic}`
   * for Big Five personality characteristics, `need_{characteristic}` for Needs, or `value_{characteristic}` for
   * Values.
   *
   * @return the traitId
   */
  public String getTraitId() {
    return traitId;
  }

  /**
   * Gets the name.
   *
   * The user-visible name of the characteristic.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the category.
   *
   * The category of the characteristic: * `personality` for Big Five personality characteristics * `needs` for Needs *
   * `values` for Values
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Gets the percentile.
   *
   * The normalized percentile score for the characteristic. The range is 0 to 1. For example, if the percentage for
   * Openness is 0.60, the author scored in the 60th percentile; the author is more open than 59 percent of the
   * population and less open than 39 percent of the population.
   *
   * @return the percentile
   */
  public Double getPercentile() {
    return percentile;
  }

  /**
   * Gets the rawScore.
   *
   * The raw score for the characteristic. The range is 0 to 1. A higher score generally indicates a greater likelihood
   * that the author has that characteristic, but raw scores must be considered in aggregate: The range of values in
   * practice might be much smaller than 0 to 1, so an individual score must be considered in the context of the overall
   * scores and their range. The raw score is computed based on the input and the service model; it is not normalized or
   * compared with a sample population. The raw score enables comparison of the results against a different sampling
   * population and with a custom normalization approach.
   *
   * @return the rawScore
   */
  public Double getRawScore() {
    return rawScore;
  }

  /**
   * Gets the significant.
   *
   * **`2017-10-13`**: Indicates whether the characteristic is meaningful for the input language. The field is always
   * `true` for all characteristics of English, Spanish, and Japanese input. The field is `false` for the subset of
   * characteristics of Arabic and Korean input for which the service's models are unable to generate meaningful
   * results. **`2016-10-19`**: Not returned.
   *
   * @return the significant
   */
  public Boolean isSignificant() {
    return significant;
  }

  /**
   * Gets the children.
   *
   * For `personality` (Big Five) dimensions, more detailed results for the facets of each dimension as inferred from
   * the input text.
   *
   * @return the children
   */
  public List<Trait> getChildren() {
    return children;
  }

  /**
   * Sets the traitId.
   *
   * @param traitId the new traitId
   */
  public void setTraitId(final String traitId) {
    this.traitId = traitId;
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
   * Sets the category.
   *
   * @param category the new category
   */
  public void setCategory(final String category) {
    this.category = category;
  }

  /**
   * Sets the percentile.
   *
   * @param percentile the new percentile
   */
  public void setPercentile(final Double percentile) {
    this.percentile = percentile;
  }

  /**
   * Sets the rawScore.
   *
   * @param rawScore the new rawScore
   */
  public void setRawScore(final Double rawScore) {
    this.rawScore = rawScore;
  }

  /**
   * Sets the significant.
   *
   * @param significant the new significant
   */
  public void setSignificant(final Boolean significant) {
    this.significant = significant;
  }

  /**
   * Sets the children.
   *
   * @param children the new children
   */
  public void setChildren(final List<Trait> children) {
    this.children = children;
  }
}
