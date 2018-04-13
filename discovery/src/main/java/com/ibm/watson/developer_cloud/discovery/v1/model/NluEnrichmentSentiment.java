/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * An object specifying the sentiment extraction enrichment and related parameters.
 */
public class NluEnrichmentSentiment extends GenericModel {

  private Boolean document;
  private List<String> targets;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean document;
    private List<String> targets;

    private Builder(NluEnrichmentSentiment nluEnrichmentSentiment) {
      document = nluEnrichmentSentiment.document;
      targets = nluEnrichmentSentiment.targets;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NluEnrichmentSentiment.
     *
     * @return the nluEnrichmentSentiment
     */
    public NluEnrichmentSentiment build() {
      return new NluEnrichmentSentiment(this);
    }

    /**
     * Adds an target to targets.
     *
     * @param target the new target
     * @return the NluEnrichmentSentiment builder
     */
    public Builder addTarget(String target) {
      Validator.notNull(target, "target cannot be null");
      if (this.targets == null) {
        this.targets = new ArrayList<String>();
      }
      this.targets.add(target);
      return this;
    }

    /**
     * Set the document.
     *
     * @param document the document
     * @return the NluEnrichmentSentiment builder
     */
    public Builder document(Boolean document) {
      this.document = document;
      return this;
    }

    /**
     * Set the targets.
     * Existing targets will be replaced.
     *
     * @param targets the targets
     * @return the NluEnrichmentSentiment builder
     */
    public Builder targets(List<String> targets) {
      this.targets = targets;
      return this;
    }
  }

  private NluEnrichmentSentiment(Builder builder) {
    document = builder.document;
    targets = builder.targets;
  }

  /**
   * New builder.
   *
   * @return a NluEnrichmentSentiment builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the document.
   *
   * When `true`, sentiment analysis is performed on the entire field.
   *
   * @return the document
   */
  public Boolean document() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * A comma-separated list of target strings that will have any associated sentiment analyzed.
   *
   * @return the targets
   */
  public List<String> targets() {
    return targets;
  }
}
