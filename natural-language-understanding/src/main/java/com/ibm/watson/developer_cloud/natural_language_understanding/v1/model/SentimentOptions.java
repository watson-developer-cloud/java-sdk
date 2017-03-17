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
package com.ibm.watson.developer_cloud.natural_language_understanding.v1.model;

import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * An option specifying if sentiment of detected entities, keywords, or phrases should be returned.
 */
public class SentimentOptions extends GenericModel {

  /** Set this to false to hide document-level sentiment results. */
  private Boolean document;
  /** Sentiment results will be returned for each target string that is found in the document. */
  private List<String> targets;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean document;
    private List<String> targets;

    private Builder(SentimentOptions sentimentOptions) {
      document = sentimentOptions.document;
      targets = sentimentOptions.targets;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Builds the SentimentOptions.
     *
     * @return the sentimentOptions
     */
    public SentimentOptions build() {
      return new SentimentOptions(this);
    }

    /**
     * Add the document.
     *
     * @param document the document
     * @return a SentimentOptions Builder
     */
    public Builder document(Boolean document) {
      this.document = document;
      return this;
    }

    /**
     * Add the targets.
     *
     * @param targets the targets
     * @return a SentimentOptions Builder
     */
    public Builder targets(List<String> targets) {
      this.targets = targets;
      return this;
    }
  }

  private SentimentOptions(Builder builder) {
    document = builder.document;
    targets = builder.targets;
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the document.
   *
   * @return the document
   */
  public Boolean document() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * @return the targets
   */
  public List<String> targets() {
    return targets;
  }

}
