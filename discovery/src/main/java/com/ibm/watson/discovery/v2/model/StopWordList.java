/*
 * (C) Copyright IBM Corp. 2022, 2023.
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
package com.ibm.watson.discovery.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** List of words to filter out of text that is submitted in queries. */
public class StopWordList extends GenericModel {

  protected List<String> stopwords;

  /** Builder. */
  public static class Builder {
    private List<String> stopwords;

    /**
     * Instantiates a new Builder from an existing StopWordList instance.
     *
     * @param stopWordList the instance to initialize the Builder with
     */
    private Builder(StopWordList stopWordList) {
      this.stopwords = stopWordList.stopwords;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param stopwords the stopwords
     */
    public Builder(List<String> stopwords) {
      this.stopwords = stopwords;
    }

    /**
     * Builds a StopWordList.
     *
     * @return the new StopWordList instance
     */
    public StopWordList build() {
      return new StopWordList(this);
    }

    /**
     * Adds an stopwords to stopwords.
     *
     * @param stopwords the new stopwords
     * @return the StopWordList builder
     */
    public Builder addStopwords(String stopwords) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(stopwords, "stopwords cannot be null");
      if (this.stopwords == null) {
        this.stopwords = new ArrayList<String>();
      }
      this.stopwords.add(stopwords);
      return this;
    }

    /**
     * Set the stopwords. Existing stopwords will be replaced.
     *
     * @param stopwords the stopwords
     * @return the StopWordList builder
     */
    public Builder stopwords(List<String> stopwords) {
      this.stopwords = stopwords;
      return this;
    }
  }

  protected StopWordList() {}

  protected StopWordList(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.stopwords, "stopwords cannot be null");
    stopwords = builder.stopwords;
  }

  /**
   * New builder.
   *
   * @return a StopWordList builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the stopwords.
   *
   * <p>List of stop words.
   *
   * @return the stopwords
   */
  public List<String> stopwords() {
    return stopwords;
  }
}
