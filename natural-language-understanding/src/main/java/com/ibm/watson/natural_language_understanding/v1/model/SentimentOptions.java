/*
 * (C) Copyright IBM Corp. 2017, 2022.
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
import java.util.ArrayList;
import java.util.List;

/**
 * Analyzes the general sentiment of your content or the sentiment toward specific target phrases.
 * You can analyze sentiment for detected entities with `entities.sentiment` and for keywords with
 * `keywords.sentiment`.
 *
 * <p>Supported languages: Arabic, English, French, German, Italian, Japanese, Korean, Portuguese,
 * Russian, Spanish.
 */
public class SentimentOptions extends GenericModel {

  protected Boolean document;
  protected List<String> targets;
  protected String model;

  /** Builder. */
  public static class Builder {
    private Boolean document;
    private List<String> targets;
    private String model;

    private Builder(SentimentOptions sentimentOptions) {
      this.document = sentimentOptions.document;
      this.targets = sentimentOptions.targets;
      this.model = sentimentOptions.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a SentimentOptions.
     *
     * @return the new SentimentOptions instance
     */
    public SentimentOptions build() {
      return new SentimentOptions(this);
    }

    /**
     * Adds an targets to targets.
     *
     * @param targets the new targets
     * @return the SentimentOptions builder
     */
    public Builder addTargets(String targets) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(targets, "targets cannot be null");
      if (this.targets == null) {
        this.targets = new ArrayList<String>();
      }
      this.targets.add(targets);
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the SentimentOptions builder
     */
    public Builder document(Boolean document) {
      this.document = document;
      return this;
    }

    /**
     * Set the targets. Existing targets will be replaced.
     *
     * @param targets the targets
     * @return the SentimentOptions builder
     */
    public Builder targets(List<String> targets) {
      this.targets = targets;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the SentimentOptions builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected SentimentOptions() {}

  protected SentimentOptions(Builder builder) {
    document = builder.document;
    targets = builder.targets;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a SentimentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the document.
   *
   * <p>Set this to `false` to hide document-level sentiment results.
   *
   * @return the document
   */
  public Boolean document() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * <p>Sentiment results will be returned for each target string that is found in the document.
   *
   * @return the targets
   */
  public List<String> targets() {
    return targets;
  }

  /**
   * Gets the model.
   *
   * <p>(Beta) Enter a [custom
   * model](https://cloud.ibm.com/docs/natural-language-understanding?topic=natural-language-understanding-customizing)
   * ID to override the standard sentiment model for all sentiment analysis operations in the
   * request, including targeted sentiment for entities and keywords.
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
