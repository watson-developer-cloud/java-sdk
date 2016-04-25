/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Profile Options when using the {@link PersonalityInsights#getProfile(ProfileOptions)} method.
 */
public class ProfileOptions {
  
  /**
   * Builder.
   */
  public static class Builder {
    private AcceptLanguage acceptLanguage;
    private List<ContentItem> contentItems;
    private String contentType;
    private Boolean includeRaw;
    private Language language;
    private String text;

    private Builder(ProfileOptions options) {
      this.text = options.text;
      this.contentType = options.contentType;
      this.contentItems = options.contentItems;
      this.includeRaw = options.includeRaw;
      this.acceptLanguage = options.acceptLanguage;
      this.language = options.language;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {}

    /**
     * Accept language.
     * 
     * @param acceptLanguage the accept language
     * @return the profile options
     */
    public Builder acceptLanguage(AcceptLanguage acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Adds a content items.
     * 
     * @param contentItem the content item
     * @return the profile options
     */
    public Builder addContentItem(ContentItem contentItem) {
      if (this.contentItems == null) {
        this.contentItems = new ArrayList<ContentItem>();
        this.contentType = HttpMediaType.APPLICATION_JSON;
      }
      this.contentItems.add(contentItem);
      return this;
    }

    /**
     * Builds the profile options.
     *
     * @return the profile options
     */
    public ProfileOptions build() {
      return new ProfileOptions(this);
    }

    /**
     * Content items.
     * 
     * @param contentItems the content items
     * @return the profile options
     */
    public Builder contentItems(List<ContentItem> contentItems) {
      this.contentItems = contentItems;
      this.contentType = HttpMediaType.APPLICATION_JSON;
      return this;
    }

    /**
     * Html.
     * 
     * @param html the html
     * @return the profile options
     */
    public Builder html(String html) {
      this.text = html;
      this.contentType = HttpMediaType.TEXT_HTML;
      return this;
    }


    /**
     * Include raw.
     * 
     * @param includeRaw the include raw
     * @return the profile options
     */
    public Builder includeRaw(boolean includeRaw) {
      this.includeRaw = includeRaw;
      return this;
    }

    /**
     * Language.
     * 
     * @param language the language
     * @return the profile options
     */
    public Builder language(Language language) {
      this.language = language;
      return this;
    }

    /**
     * Text.
     * 
     * @param text the text
     * @return the profile options
     */
    public Builder text(String text) {
      this.text = text;
      this.contentType = HttpMediaType.TEXT_PLAIN;
      return this;
    }
  }

  private AcceptLanguage acceptLanguage;
  private List<ContentItem> contentItems;
  private String contentType;
  private Boolean includeRaw;
  private Language language;
  private String text;
  private ProfileOptions(Builder builder) {
    Validator.isTrue((builder.text != null && !builder.text.isEmpty())
        || (builder.contentItems != null && !builder.contentItems.isEmpty()), "text or contentItems are required");

    this.text = builder.text;
    this.contentType = builder.contentType;
    this.contentItems = builder.contentItems;
    this.includeRaw = builder.includeRaw;
    this.acceptLanguage = builder.acceptLanguage;
    this.language = builder.language;
  }


  /**
   * Gets the accept language.
   * 
   * @return the acceptLanguage
   */
  public AcceptLanguage acceptLanguage() {
    return acceptLanguage;
  }


  /**
   * Gets the content items.
   * 
   * @return the contentItems
   */
  public List<ContentItem> contentItems() {
    return contentItems;
  }


  /**
   * Gets the content type.
   * 
   * @return the contentType
   */
  public String contentType() {
    return contentType;
  }

  /**
   * Gets the include raw.
   * 
   * @return the includeRaw
   */
  public Boolean includeRaw() {
    return includeRaw;
  }


  /**
   * Gets the language.
   * 
   * @return the language
   */
  public Language language() {
    return language;
  }


  /**
   * New builder.
   *
   * @return the builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }


  /**
   * Gets the text.
   * 
   * @return the text
   */
  public String text() {
    return text;
  }



}
