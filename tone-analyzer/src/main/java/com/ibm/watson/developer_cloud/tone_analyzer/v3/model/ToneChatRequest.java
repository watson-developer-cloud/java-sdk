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

import com.google.gson.annotations.SerializedName;

/**
 * This object represents the input for Tone Chat analysis. It contains a list of utterances.
 */
public class ToneChatRequest {

  /** The utterances. */
  @SerializedName("utterances")
  List<Utterance> utterances;

  private ToneChatRequest(Builder builder) {
    this.utterances = builder.utterances;
  }

  /**
   * Gets the utterances.
   *
   * @return the utterances
   */
  public List<Utterance> utterances() {
    return utterances;
  }

  /**
   * The Tone Chat Builder.
   */
  public static class Builder {

    /** The utterances. */
    List<Utterance> utterances;

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Creates a Builder based on an existing {@link ToneChatRequest}.
     * @param options The {@link ToneChatRequest}.
     */
    private Builder(ToneChatRequest options) {
      this.utterances = new ArrayList<Utterance>(options.utterances);
    }

    /**
     * Gets the Utterances.
     *
     * @param utterances the utterances
     * @return the builder
     */
    public Builder utterances(List<Utterance> utterances) {
      this.utterances = new ArrayList<Utterance>(utterances);
      return this;
    }

    /**
     * Builds the {@link ToneChatRequest}.
     *
     * @return the tone chat input
     */
    public ToneChatRequest build() {
      return new ToneChatRequest(this);
    }
  }

  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}
