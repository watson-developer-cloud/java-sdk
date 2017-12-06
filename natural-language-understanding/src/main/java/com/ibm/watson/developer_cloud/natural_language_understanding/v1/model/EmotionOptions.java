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

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Whether or not to return emotion analysis of the content.
 */
public class EmotionOptions extends GenericModel {

  private Boolean document;
  private List<String> targets;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean document;
    private List<String> targets;

    private Builder(EmotionOptions emotionOptions) {
      document = emotionOptions.document;
      targets = emotionOptions.targets;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a EmotionOptions.
     *
     * @return the emotionOptions
     */
    public EmotionOptions build() {
      return new EmotionOptions(this);
    }

    /**
     * Adds an targets to targets.
     *
     * @param targets the new targets
     * @return the EmotionOptions builder
     */
    public Builder addTargets(String targets) {
      Validator.notNull(targets, "targets cannot be null");
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
     * @return the EmotionOptions builder
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
     * @return the EmotionOptions builder
     */
    public Builder targets(List<String> targets) {
      this.targets = targets;
      return this;
    }
  }

  private EmotionOptions(Builder builder) {
    document = builder.document;
    targets = builder.targets;
  }

  /**
   * New builder.
   *
   * @return a EmotionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the document.
   *
   * Set this to false to hide document-level emotion results
   *
   * @return the document
   */
  public Boolean document() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * Emotion results will be returned for each target string that is found in the document
   *
   * @return the targets
   */
  public List<String> targets() {
    return targets;
  }
}
