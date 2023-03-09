/*
 * (C) Copyright IBM Corp. 2019, 2023.
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

/** A list of Word conversion settings. */
public class WordSettings extends GenericModel {

  protected WordHeadingDetection heading;

  /** Builder. */
  public static class Builder {
    private WordHeadingDetection heading;

    /**
     * Instantiates a new Builder from an existing WordSettings instance.
     *
     * @param wordSettings the instance to initialize the Builder with
     */
    private Builder(WordSettings wordSettings) {
      this.heading = wordSettings.heading;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a WordSettings.
     *
     * @return the new WordSettings instance
     */
    public WordSettings build() {
      return new WordSettings(this);
    }

    /**
     * Set the heading.
     *
     * @param heading the heading
     * @return the WordSettings builder
     */
    public Builder heading(WordHeadingDetection heading) {
      this.heading = heading;
      return this;
    }
  }

  protected WordSettings() {}

  protected WordSettings(Builder builder) {
    heading = builder.heading;
  }

  /**
   * New builder.
   *
   * @return a WordSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the heading.
   *
   * <p>Object containing heading detection conversion settings for Microsoft Word documents.
   *
   * @return the heading
   */
  public WordHeadingDetection heading() {
    return heading;
  }
}
