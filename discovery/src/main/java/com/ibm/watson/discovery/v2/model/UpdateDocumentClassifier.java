/*
 * (C) Copyright IBM Corp. 2024.
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

/**
 * An object that contains a new name or description for a document classifier, updated training
 * data, or new or updated test data.
 */
public class UpdateDocumentClassifier extends GenericModel {

  protected String name;
  protected String description;

  /** Builder. */
  public static class Builder {
    private String name;
    private String description;

    /**
     * Instantiates a new Builder from an existing UpdateDocumentClassifier instance.
     *
     * @param updateDocumentClassifier the instance to initialize the Builder with
     */
    private Builder(UpdateDocumentClassifier updateDocumentClassifier) {
      this.name = updateDocumentClassifier.name;
      this.description = updateDocumentClassifier.description;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a UpdateDocumentClassifier.
     *
     * @return the new UpdateDocumentClassifier instance
     */
    public UpdateDocumentClassifier build() {
      return new UpdateDocumentClassifier(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateDocumentClassifier builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateDocumentClassifier builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UpdateDocumentClassifier() {}

  protected UpdateDocumentClassifier(Builder builder) {
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateDocumentClassifier builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * <p>A new name for the classifier.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * <p>A new description for the classifier.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}
