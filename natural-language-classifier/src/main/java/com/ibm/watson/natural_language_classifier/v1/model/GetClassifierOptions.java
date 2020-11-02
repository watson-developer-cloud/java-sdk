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
package com.ibm.watson.natural_language_classifier.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getClassifier options. */
public class GetClassifierOptions extends GenericModel {

  protected String classifierId;

  /** Builder. */
  public static class Builder {
    private String classifierId;

    private Builder(GetClassifierOptions getClassifierOptions) {
      this.classifierId = getClassifierOptions.classifierId;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param classifierId the classifierId
     */
    public Builder(String classifierId) {
      this.classifierId = classifierId;
    }

    /**
     * Builds a GetClassifierOptions.
     *
     * @return the new GetClassifierOptions instance
     */
    public GetClassifierOptions build() {
      return new GetClassifierOptions(this);
    }

    /**
     * Set the classifierId.
     *
     * @param classifierId the classifierId
     * @return the GetClassifierOptions builder
     */
    public Builder classifierId(String classifierId) {
      this.classifierId = classifierId;
      return this;
    }
  }

  protected GetClassifierOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.classifierId, "classifierId cannot be empty");
    classifierId = builder.classifierId;
  }

  /**
   * New builder.
   *
   * @return a GetClassifierOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the classifierId.
   *
   * <p>Classifier ID to query.
   *
   * @return the classifierId
   */
  public String classifierId() {
    return classifierId;
  }
}
