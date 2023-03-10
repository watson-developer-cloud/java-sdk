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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Recognizes when two entities are related and identifies the type of relation. For example, an
 * `awardedTo` relation might connect the entities "Nobel Prize" and "Albert Einstein". For more
 * information, see [Relation
 * types](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-relations).
 *
 * <p>Supported languages: Arabic, English, German, Japanese, Korean, Spanish. Chinese, Dutch,
 * French, Italian, and Portuguese custom models are also supported.
 */
public class RelationsOptions extends GenericModel {

  protected String model;

  /** Builder. */
  public static class Builder {
    private String model;

    /**
     * Instantiates a new Builder from an existing RelationsOptions instance.
     *
     * @param relationsOptions the instance to initialize the Builder with
     */
    private Builder(RelationsOptions relationsOptions) {
      this.model = relationsOptions.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a RelationsOptions.
     *
     * @return the new RelationsOptions instance
     */
    public RelationsOptions build() {
      return new RelationsOptions(this);
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the RelationsOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected RelationsOptions() {}

  protected RelationsOptions(Builder builder) {
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a RelationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the model.
   *
   * <p>Enter a [custom
   * model](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-customizing)
   * ID to override the default model.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
