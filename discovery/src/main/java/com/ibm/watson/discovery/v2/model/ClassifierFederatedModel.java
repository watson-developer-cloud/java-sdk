/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An object with details for creating federated document classifier models. */
public class ClassifierFederatedModel extends GenericModel {

  protected String field;

  /** Builder. */
  public static class Builder {
    private String field;

    /**
     * Instantiates a new Builder from an existing ClassifierFederatedModel instance.
     *
     * @param classifierFederatedModel the instance to initialize the Builder with
     */
    private Builder(ClassifierFederatedModel classifierFederatedModel) {
      this.field = classifierFederatedModel.field;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param field the field
     */
    public Builder(String field) {
      this.field = field;
    }

    /**
     * Builds a ClassifierFederatedModel.
     *
     * @return the new ClassifierFederatedModel instance
     */
    public ClassifierFederatedModel build() {
      return new ClassifierFederatedModel(this);
    }

    /**
     * Set the field.
     *
     * @param field the field
     * @return the ClassifierFederatedModel builder
     */
    public Builder field(String field) {
      this.field = field;
      return this;
    }
  }

  protected ClassifierFederatedModel() {}

  protected ClassifierFederatedModel(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.field, "field cannot be null");
    field = builder.field;
  }

  /**
   * New builder.
   *
   * @return a ClassifierFederatedModel builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the field.
   *
   * <p>Name of the field that contains the values from which multiple classifier models are
   * defined. For example, you can specify a field that lists product lines to create a separate
   * model per product line.
   *
   * @return the field
   */
  public String field() {
    return field;
  }
}
