/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
package com.ibm.watson.discovery.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** An object specifying the sentiment extraction enrichment and related parameters. */
public class NluEnrichmentSentiment extends GenericModel {

  protected Boolean document;
  protected List<String> targets;

  /** Builder. */
  public static class Builder {
    private Boolean document;
    private List<String> targets;

    private Builder(NluEnrichmentSentiment nluEnrichmentSentiment) {
      this.document = nluEnrichmentSentiment.document;
      this.targets = nluEnrichmentSentiment.targets;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a NluEnrichmentSentiment.
     *
     * @return the new NluEnrichmentSentiment instance
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
      com.ibm.cloud.sdk.core.util.Validator.notNull(target, "target cannot be null");
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
     * Set the targets. Existing targets will be replaced.
     *
     * @param targets the targets
     * @return the NluEnrichmentSentiment builder
     */
    public Builder targets(List<String> targets) {
      this.targets = targets;
      return this;
    }
  }

  protected NluEnrichmentSentiment(Builder builder) {
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
   * <p>When `true`, sentiment analysis is performed on the entire field.
   *
   * @return the document
   */
  public Boolean document() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * <p>A comma-separated list of target strings that will have any associated sentiment analyzed.
   *
   * @return the targets
   */
  public List<String> targets() {
    return targets;
  }
}
