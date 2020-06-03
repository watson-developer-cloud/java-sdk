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
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getModelFile options. */
public class GetModelFileOptions extends GenericModel {

  /** The feature for the model. */
  public interface Feature {
    /** objects. */
    String OBJECTS = "objects";
  }

  /** The format of the returned model. */
  public interface ModelFormat {
    /** rscnn. */
    String RSCNN = "rscnn";
  }

  protected String collectionId;
  protected String feature;
  protected String modelFormat;

  /** Builder. */
  public static class Builder {
    private String collectionId;
    private String feature;
    private String modelFormat;

    private Builder(GetModelFileOptions getModelFileOptions) {
      this.collectionId = getModelFileOptions.collectionId;
      this.feature = getModelFileOptions.feature;
      this.modelFormat = getModelFileOptions.modelFormat;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param collectionId the collectionId
     * @param feature the feature
     * @param modelFormat the modelFormat
     */
    public Builder(String collectionId, String feature, String modelFormat) {
      this.collectionId = collectionId;
      this.feature = feature;
      this.modelFormat = modelFormat;
    }

    /**
     * Builds a GetModelFileOptions.
     *
     * @return the getModelFileOptions
     */
    public GetModelFileOptions build() {
      return new GetModelFileOptions(this);
    }

    /**
     * Set the collectionId.
     *
     * @param collectionId the collectionId
     * @return the GetModelFileOptions builder
     */
    public Builder collectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    /**
     * Set the feature.
     *
     * @param feature the feature
     * @return the GetModelFileOptions builder
     */
    public Builder feature(String feature) {
      this.feature = feature;
      return this;
    }

    /**
     * Set the modelFormat.
     *
     * @param modelFormat the modelFormat
     * @return the GetModelFileOptions builder
     */
    public Builder modelFormat(String modelFormat) {
      this.modelFormat = modelFormat;
      return this;
    }
  }

  protected GetModelFileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.collectionId, "collectionId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.feature, "feature cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.modelFormat, "modelFormat cannot be null");
    collectionId = builder.collectionId;
    feature = builder.feature;
    modelFormat = builder.modelFormat;
  }

  /**
   * New builder.
   *
   * @return a GetModelFileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the collectionId.
   *
   * <p>The identifier of the collection.
   *
   * @return the collectionId
   */
  public String collectionId() {
    return collectionId;
  }

  /**
   * Gets the feature.
   *
   * <p>The feature for the model.
   *
   * @return the feature
   */
  public String feature() {
    return feature;
  }

  /**
   * Gets the modelFormat.
   *
   * <p>The format of the returned model.
   *
   * @return the modelFormat
   */
  public String modelFormat() {
    return modelFormat;
  }
}
