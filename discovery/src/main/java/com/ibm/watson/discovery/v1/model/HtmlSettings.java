/*
 * (C) Copyright IBM Corp. 2024.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.ArrayList;
import java.util.List;

/** A list of HTML conversion settings. */
public class HtmlSettings extends GenericModel {

  @SerializedName("exclude_tags_completely")
  protected List<String> excludeTagsCompletely;

  @SerializedName("exclude_tags_keep_content")
  protected List<String> excludeTagsKeepContent;

  @SerializedName("keep_content")
  protected XPathPatterns keepContent;

  @SerializedName("exclude_content")
  protected XPathPatterns excludeContent;

  @SerializedName("keep_tag_attributes")
  protected List<String> keepTagAttributes;

  @SerializedName("exclude_tag_attributes")
  protected List<String> excludeTagAttributes;

  /** Builder. */
  public static class Builder {
    private List<String> excludeTagsCompletely;
    private List<String> excludeTagsKeepContent;
    private XPathPatterns keepContent;
    private XPathPatterns excludeContent;
    private List<String> keepTagAttributes;
    private List<String> excludeTagAttributes;

    /**
     * Instantiates a new Builder from an existing HtmlSettings instance.
     *
     * @param htmlSettings the instance to initialize the Builder with
     */
    private Builder(HtmlSettings htmlSettings) {
      this.excludeTagsCompletely = htmlSettings.excludeTagsCompletely;
      this.excludeTagsKeepContent = htmlSettings.excludeTagsKeepContent;
      this.keepContent = htmlSettings.keepContent;
      this.excludeContent = htmlSettings.excludeContent;
      this.keepTagAttributes = htmlSettings.keepTagAttributes;
      this.excludeTagAttributes = htmlSettings.excludeTagAttributes;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a HtmlSettings.
     *
     * @return the new HtmlSettings instance
     */
    public HtmlSettings build() {
      return new HtmlSettings(this);
    }

    /**
     * Adds a new element to excludeTagsCompletely.
     *
     * @param excludeTagsCompletely the new element to be added
     * @return the HtmlSettings builder
     */
    public Builder addExcludeTagsCompletely(String excludeTagsCompletely) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          excludeTagsCompletely, "excludeTagsCompletely cannot be null");
      if (this.excludeTagsCompletely == null) {
        this.excludeTagsCompletely = new ArrayList<String>();
      }
      this.excludeTagsCompletely.add(excludeTagsCompletely);
      return this;
    }

    /**
     * Adds a new element to excludeTagsKeepContent.
     *
     * @param excludeTagsKeepContent the new element to be added
     * @return the HtmlSettings builder
     */
    public Builder addExcludeTagsKeepContent(String excludeTagsKeepContent) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          excludeTagsKeepContent, "excludeTagsKeepContent cannot be null");
      if (this.excludeTagsKeepContent == null) {
        this.excludeTagsKeepContent = new ArrayList<String>();
      }
      this.excludeTagsKeepContent.add(excludeTagsKeepContent);
      return this;
    }

    /**
     * Adds a new element to keepTagAttributes.
     *
     * @param keepTagAttributes the new element to be added
     * @return the HtmlSettings builder
     */
    public Builder addKeepTagAttributes(String keepTagAttributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          keepTagAttributes, "keepTagAttributes cannot be null");
      if (this.keepTagAttributes == null) {
        this.keepTagAttributes = new ArrayList<String>();
      }
      this.keepTagAttributes.add(keepTagAttributes);
      return this;
    }

    /**
     * Adds a new element to excludeTagAttributes.
     *
     * @param excludeTagAttributes the new element to be added
     * @return the HtmlSettings builder
     */
    public Builder addExcludeTagAttributes(String excludeTagAttributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          excludeTagAttributes, "excludeTagAttributes cannot be null");
      if (this.excludeTagAttributes == null) {
        this.excludeTagAttributes = new ArrayList<String>();
      }
      this.excludeTagAttributes.add(excludeTagAttributes);
      return this;
    }

    /**
     * Set the excludeTagsCompletely. Existing excludeTagsCompletely will be replaced.
     *
     * @param excludeTagsCompletely the excludeTagsCompletely
     * @return the HtmlSettings builder
     */
    public Builder excludeTagsCompletely(List<String> excludeTagsCompletely) {
      this.excludeTagsCompletely = excludeTagsCompletely;
      return this;
    }

    /**
     * Set the excludeTagsKeepContent. Existing excludeTagsKeepContent will be replaced.
     *
     * @param excludeTagsKeepContent the excludeTagsKeepContent
     * @return the HtmlSettings builder
     */
    public Builder excludeTagsKeepContent(List<String> excludeTagsKeepContent) {
      this.excludeTagsKeepContent = excludeTagsKeepContent;
      return this;
    }

    /**
     * Set the keepContent.
     *
     * @param keepContent the keepContent
     * @return the HtmlSettings builder
     */
    public Builder keepContent(XPathPatterns keepContent) {
      this.keepContent = keepContent;
      return this;
    }

    /**
     * Set the excludeContent.
     *
     * @param excludeContent the excludeContent
     * @return the HtmlSettings builder
     */
    public Builder excludeContent(XPathPatterns excludeContent) {
      this.excludeContent = excludeContent;
      return this;
    }

    /**
     * Set the keepTagAttributes. Existing keepTagAttributes will be replaced.
     *
     * @param keepTagAttributes the keepTagAttributes
     * @return the HtmlSettings builder
     */
    public Builder keepTagAttributes(List<String> keepTagAttributes) {
      this.keepTagAttributes = keepTagAttributes;
      return this;
    }

    /**
     * Set the excludeTagAttributes. Existing excludeTagAttributes will be replaced.
     *
     * @param excludeTagAttributes the excludeTagAttributes
     * @return the HtmlSettings builder
     */
    public Builder excludeTagAttributes(List<String> excludeTagAttributes) {
      this.excludeTagAttributes = excludeTagAttributes;
      return this;
    }
  }

  protected HtmlSettings() {}

  protected HtmlSettings(Builder builder) {
    excludeTagsCompletely = builder.excludeTagsCompletely;
    excludeTagsKeepContent = builder.excludeTagsKeepContent;
    keepContent = builder.keepContent;
    excludeContent = builder.excludeContent;
    keepTagAttributes = builder.keepTagAttributes;
    excludeTagAttributes = builder.excludeTagAttributes;
  }

  /**
   * New builder.
   *
   * @return a HtmlSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the excludeTagsCompletely.
   *
   * <p>Array of HTML tags that are excluded completely.
   *
   * @return the excludeTagsCompletely
   */
  public List<String> excludeTagsCompletely() {
    return excludeTagsCompletely;
  }

  /**
   * Gets the excludeTagsKeepContent.
   *
   * <p>Array of HTML tags which are excluded but still retain content.
   *
   * @return the excludeTagsKeepContent
   */
  public List<String> excludeTagsKeepContent() {
    return excludeTagsKeepContent;
  }

  /**
   * Gets the keepContent.
   *
   * <p>Object containing an array of XPaths.
   *
   * @return the keepContent
   */
  public XPathPatterns keepContent() {
    return keepContent;
  }

  /**
   * Gets the excludeContent.
   *
   * <p>Object containing an array of XPaths.
   *
   * @return the excludeContent
   */
  public XPathPatterns excludeContent() {
    return excludeContent;
  }

  /**
   * Gets the keepTagAttributes.
   *
   * <p>An array of HTML tag attributes to keep in the converted document.
   *
   * @return the keepTagAttributes
   */
  public List<String> keepTagAttributes() {
    return keepTagAttributes;
  }

  /**
   * Gets the excludeTagAttributes.
   *
   * <p>Array of HTML tag attributes to exclude.
   *
   * @return the excludeTagAttributes
   */
  public List<String> excludeTagAttributes() {
    return excludeTagAttributes;
  }
}
