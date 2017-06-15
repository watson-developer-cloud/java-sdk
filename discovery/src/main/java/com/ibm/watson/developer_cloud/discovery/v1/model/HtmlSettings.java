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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * A list of HTML conversion settings.
 */
public class HtmlSettings extends GenericModel {

  @SerializedName("exclude_tags_completely")
  private List<String> excludeTagsCompletely;
  @SerializedName("exclude_tags_keep_content")
  private List<String> excludeTagsKeepContent;
  @SerializedName("keep_content")
  private XPathPatterns keepContent;
  @SerializedName("exclude_content")
  private XPathPatterns excludeContent;
  @SerializedName("keep_tag_attributes")
  private List<String> keepTagAttributes;
  @SerializedName("exclude_tag_attributes")
  private List<String> excludeTagAttributes;

  /**
   * Gets the excludeTagsCompletely.
   *
   * @return the excludeTagsCompletely
   */
  public List<String> getExcludeTagsCompletely() {
    return excludeTagsCompletely;
  }

  /**
   * Gets the excludeTagsKeepContent.
   *
   * @return the excludeTagsKeepContent
   */
  public List<String> getExcludeTagsKeepContent() {
    return excludeTagsKeepContent;
  }

  /**
   * Gets the keepContent.
   *
   * @return the keepContent
   */
  public XPathPatterns getKeepContent() {
    return keepContent;
  }

  /**
   * Gets the excludeContent.
   *
   * @return the excludeContent
   */
  public XPathPatterns getExcludeContent() {
    return excludeContent;
  }

  /**
   * Gets the keepTagAttributes.
   *
   * @return the keepTagAttributes
   */
  public List<String> getKeepTagAttributes() {
    return keepTagAttributes;
  }

  /**
   * Gets the excludeTagAttributes.
   *
   * @return the excludeTagAttributes
   */
  public List<String> getExcludeTagAttributes() {
    return excludeTagAttributes;
  }

  /**
   * Sets the excludeTagsCompletely.
   *
   * @param excludeTagsCompletely the new excludeTagsCompletely
   */
  public void setExcludeTagsCompletely(final List<String> excludeTagsCompletely) {
    this.excludeTagsCompletely = excludeTagsCompletely;
  }

  /**
   * Sets the excludeTagsKeepContent.
   *
   * @param excludeTagsKeepContent the new excludeTagsKeepContent
   */
  public void setExcludeTagsKeepContent(final List<String> excludeTagsKeepContent) {
    this.excludeTagsKeepContent = excludeTagsKeepContent;
  }

  /**
   * Sets the keepContent.
   *
   * @param keepContent the new keepContent
   */
  public void setKeepContent(final XPathPatterns keepContent) {
    this.keepContent = keepContent;
  }

  /**
   * Sets the excludeContent.
   *
   * @param excludeContent the new excludeContent
   */
  public void setExcludeContent(final XPathPatterns excludeContent) {
    this.excludeContent = excludeContent;
  }

  /**
   * Sets the keepTagAttributes.
   *
   * @param keepTagAttributes the new keepTagAttributes
   */
  public void setKeepTagAttributes(final List<String> keepTagAttributes) {
    this.keepTagAttributes = keepTagAttributes;
  }

  /**
   * Sets the excludeTagAttributes.
   *
   * @param excludeTagAttributes the new excludeTagAttributes
   */
  public void setExcludeTagAttributes(final List<String> excludeTagAttributes) {
    this.excludeTagAttributes = excludeTagAttributes;
  }
}
