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
package com.ibm.watson.developer_cloud.tone_analyzer.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * the toneChat options.
 */
public class ToneChatOptions extends GenericModel {

  /** An array of `Utterance` objects that provides the input content that the service is to analyze. */
  private List<Utterance> utterances;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Utterance> utterances;

    private Builder(ToneChatOptions toneChatOptions) {
      utterances = toneChatOptions.utterances;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param utterances the utterances
     */
    public Builder(List<Utterance> utterances) {
      this.utterances = utterances;
    }

    /**
     * Builds a ToneChatOptions.
     *
     * @return the toneChatOptions
     */
    public ToneChatOptions build() {
      return new ToneChatOptions(this);
    }

    /**
     * Adds an utterances to utterances.
     *
     * @param utterances the new utterances
     * @return the ToneChatOptions builder
     */
    public Builder addUtterances(Utterance utterances) {
      Validator.notNull(utterances, "utterances cannot be null");
      if (this.utterances == null) {
        this.utterances = new ArrayList<Utterance>();
      }
      this.utterances.add(utterances);
      return this;
    }

    /**
     * Set the utterances.
     * Existing utterances will be replaced.
     *
     * @param utterances the utterances
     * @return the ToneChatOptions builder
     */
    public Builder utterances(List<Utterance> utterances) {
      this.utterances = utterances;
      return this;
    }
  }

  private ToneChatOptions(Builder builder) {
    Validator.notNull(builder.utterances, "utterances cannot be null");
    utterances = builder.utterances;
  }

  /**
   * New builder.
   *
   * @return a ToneChatOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the utterances.
   *
   * @return the utterances
   */
  public List<Utterance> utterances() {
    return utterances;
  }
}
