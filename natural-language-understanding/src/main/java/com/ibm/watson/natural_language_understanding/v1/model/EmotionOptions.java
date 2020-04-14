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
import java.util.ArrayList;
import java.util.List;

/**
 * Detects anger, disgust, fear, joy, or sadness that is conveyed in the content or by the context
 * around target phrases specified in the targets parameter. You can analyze emotion for detected
 * entities with `entities.emotion` and for keywords with `keywords.emotion`.
 *
 * <p>Supported languages: English.
 */
public class EmotionOptions extends GenericModel {

  protected Boolean document;
  protected List<String> targets;

  /** Builder. */
  public static class Builder {
    private Boolean document;
    private List<String> targets;

    private Builder(EmotionOptions emotionOptions) {
      this.document = emotionOptions.document;
      this.targets = emotionOptions.targets;
    }

    /** Instantiates a new builder. */
    public Builder() {}

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
     * @return the EmotionOptions builder
     */
    public Builder document(Boolean document) {
      this.document = document;
      return this;
    }

    /**
     * Set the targets. Existing targets will be replaced.
     *
     * @param targets the targets
     * @return the EmotionOptions builder
     */
    public Builder targets(List<String> targets) {
      this.targets = targets;
      return this;
    }
  }

  protected EmotionOptions(Builder builder) {
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
   * <p>Set this to `false` to hide document-level emotion results.
   *
   * @return the document
   */
  public Boolean document() {
    return document;
  }

  /**
   * Gets the targets.
   *
   * <p>Emotion results will be returned for each target string that is found in the document.
   *
   * @return the targets
   */
  public List<String> targets() {
    return targets;
  }
}
