/**
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

package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
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
    private Boolean rawScores;
    private Language language;
    private String text;
    private Boolean consumptionPreferences;

    private Builder(ProfileOptions options) {
      text = options.text;
      contentType = options.contentType;
      contentItems = options.contentItems;
      rawScores = options.rawScores;
      acceptLanguage = options.acceptLanguage;
      language = options.language;
      consumptionPreferences = options.consumptionPreferences;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    /**
     * Include consumption preference information.
     *
     * @param consumptionPreferences consumtion preferences
     * @return the profile options
     */
    public Builder consumptionPreferences(Boolean consumptionPreferences) {
      this.consumptionPreferences = consumptionPreferences;
      return this;
    }

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
      if (contentItems == null) {
        contentItems = new ArrayList<ContentItem>();
        contentType = HttpMediaType.APPLICATION_JSON;
      }
      contentItems.add(contentItem);
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
      contentType = HttpMediaType.APPLICATION_JSON;
      return this;
    }

    /**
     * Html.
     *
     * @param html the html
     * @return the profile options
     */
    public Builder html(String html) {
      text = html;
      contentType = HttpMediaType.TEXT_HTML;
      return this;
    }


    /**
     * Raw scores.
     *
     * @param includeRaw include the raw scores
     * @return the profile options
     */
    public Builder rawScores(boolean includeRaw) {
      this.rawScores = includeRaw;
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
      contentType = HttpMediaType.TEXT_PLAIN;
      return this;
    }
  }

  private AcceptLanguage acceptLanguage;
  private List<ContentItem> contentItems;
  private String contentType;
  private Boolean rawScores;
  private Language language;
  private String text;
  private Boolean consumptionPreferences;

  private ProfileOptions(Builder builder) {
    Validator.isTrue(
        ((builder.text != null) && !builder.text.isEmpty())
            || ((builder.contentItems != null) && !builder.contentItems.isEmpty()),
        "text or contentItems are required");

    text = builder.text;
    contentType = builder.contentType;
    contentItems = builder.contentItems;
    rawScores = builder.rawScores;
    acceptLanguage = builder.acceptLanguage;
    language = builder.language;
    consumptionPreferences = builder.consumptionPreferences;
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
   * Gets the raw scores.
   *
   * @return the rawScores
   */
  public Boolean rawScores() {
    return rawScores;
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
   * Gets the consumption preferences flag.
   *
   * @return the text
   */
  public Boolean consumptionPreferences() {
    return consumptionPreferences;
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
