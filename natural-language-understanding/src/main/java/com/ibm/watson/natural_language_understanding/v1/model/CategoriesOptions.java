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
package com.ibm.watson.natural_language_understanding.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Returns a five-level taxonomy of the content. The top three categories are returned.
 *
 * Supported languages: Arabic, English, French, German, Italian, Japanese, Korean, Portuguese, Spanish.
 */
public class CategoriesOptions extends GenericModel {

  protected Boolean explanation;
  protected Long limit;
  @Deprecated
  protected String model;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean explanation;
    private Long limit;
    @Deprecated
    private String model;

    private Builder(CategoriesOptions categoriesOptions) {
      this.explanation = categoriesOptions.explanation;
      this.limit = categoriesOptions.limit;
      this.model = categoriesOptions.model;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CategoriesOptions.
     *
     * @return the categoriesOptions
     */
    public CategoriesOptions build() {
      return new CategoriesOptions(this);
    }

    /**
     * Set the explanation.
     *
     * @param explanation the explanation
     * @return the CategoriesOptions builder
     */
    public Builder explanation(Boolean explanation) {
      this.explanation = explanation;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the CategoriesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the CategoriesOptions builder
     * @deprecated the model parameter is no longer supported by the Natural Language Understanding service and will
     * be removed in the next major release
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected CategoriesOptions(Builder builder) {
    explanation = builder.explanation;
    limit = builder.limit;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a CategoriesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the explanation.
   *
   * Set this to `true` to return explanations for each categorization. **This is available only for English
   * categories.**.
   *
   * @return the explanation
   */
  public Boolean explanation() {
    return explanation;
  }

  /**
   * Gets the limit.
   *
   * Maximum number of categories to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the model.
   *
   * Enter a [custom
   * model](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-customizing)
   * ID to override the standard categories model.
   *
   * The custom categories experimental feature will be retired on 19 December 2019. On that date, deployed custom
   * categories models will no longer be accessible in Natural Language Understanding. The feature will be removed from
   * Knowledge Studio on an earlier date. Custom categories models will no longer be accessible in Knowledge Studio on
   * 17 December 2019.
   *
   * @return the model
   * @deprecated the model parameter is no longer supported by the Natural Language Understanding
   * service and will be removed in the next major release
   */
  public String model() {
    return model;
  }
}
