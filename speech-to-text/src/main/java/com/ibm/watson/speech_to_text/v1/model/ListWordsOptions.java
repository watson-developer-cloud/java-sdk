/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
package com.ibm.watson.speech_to_text.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listWords options. */
public class ListWordsOptions extends GenericModel {

  /**
   * The type of words to be listed from the custom language model's words resource: * `all` (the
   * default) shows all words. * `user` shows only custom words that were added or modified by the
   * user directly. * `corpora` shows only OOV that were extracted from corpora. * `grammars` shows
   * only OOV words that are recognized by grammars.
   */
  public interface WordType {
    /** all. */
    String ALL = "all";
    /** user. */
    String USER = "user";
    /** corpora. */
    String CORPORA = "corpora";
    /** grammars. */
    String GRAMMARS = "grammars";
  }

  /**
   * Indicates the order in which the words are to be listed, `alphabetical` or by `count`. You can
   * prepend an optional `+` or `-` to an argument to indicate whether the results are to be sorted
   * in ascending or descending order. By default, words are sorted in ascending alphabetical order.
   * For alphabetical ordering, the lexicographical precedence is numeric values, uppercase letters,
   * and lowercase letters. For count ordering, values with the same count are ordered
   * alphabetically. With the `curl` command, URL-encode the `+` symbol as `%2B`.
   */
  public interface Sort {
    /** alphabetical. */
    String ALPHABETICAL = "alphabetical";
    /** count. */
    String COUNT = "count";
  }

  protected String customizationId;
  protected String wordType;
  protected String sort;

  /** Builder. */
  public static class Builder {
    private String customizationId;
    private String wordType;
    private String sort;

    private Builder(ListWordsOptions listWordsOptions) {
      this.customizationId = listWordsOptions.customizationId;
      this.wordType = listWordsOptions.wordType;
      this.sort = listWordsOptions.sort;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param customizationId the customizationId
     */
    public Builder(String customizationId) {
      this.customizationId = customizationId;
    }

    /**
     * Builds a ListWordsOptions.
     *
     * @return the listWordsOptions
     */
    public ListWordsOptions build() {
      return new ListWordsOptions(this);
    }

    /**
     * Set the customizationId.
     *
     * @param customizationId the customizationId
     * @return the ListWordsOptions builder
     */
    public Builder customizationId(String customizationId) {
      this.customizationId = customizationId;
      return this;
    }

    /**
     * Set the wordType.
     *
     * @param wordType the wordType
     * @return the ListWordsOptions builder
     */
    public Builder wordType(String wordType) {
      this.wordType = wordType;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListWordsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListWordsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(
        builder.customizationId, "customizationId cannot be empty");
    customizationId = builder.customizationId;
    wordType = builder.wordType;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListWordsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the customizationId.
   *
   * <p>The customization ID (GUID) of the custom language model that is to be used for the request.
   * You must make the request with credentials for the instance of the service that owns the custom
   * model.
   *
   * @return the customizationId
   */
  public String customizationId() {
    return customizationId;
  }

  /**
   * Gets the wordType.
   *
   * <p>The type of words to be listed from the custom language model's words resource: * `all` (the
   * default) shows all words. * `user` shows only custom words that were added or modified by the
   * user directly. * `corpora` shows only OOV that were extracted from corpora. * `grammars` shows
   * only OOV words that are recognized by grammars.
   *
   * @return the wordType
   */
  public String wordType() {
    return wordType;
  }

  /**
   * Gets the sort.
   *
   * <p>Indicates the order in which the words are to be listed, `alphabetical` or by `count`. You
   * can prepend an optional `+` or `-` to an argument to indicate whether the results are to be
   * sorted in ascending or descending order. By default, words are sorted in ascending alphabetical
   * order. For alphabetical ordering, the lexicographical precedence is numeric values, uppercase
   * letters, and lowercase letters. For count ordering, values with the same count are ordered
   * alphabetically. With the `curl` command, URL-encode the `+` symbol as `%2B`.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}
