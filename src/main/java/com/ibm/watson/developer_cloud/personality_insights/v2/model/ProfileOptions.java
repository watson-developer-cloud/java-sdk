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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Profile Options when using the {@link PersonalityInsights#getProfile(ProfileOptions)} method.
 */
public class ProfileOptions extends GenericModel {

  private String text;

  private String contentType;

  private List<ContentItem> contentItems;

  private Boolean includeRaw;

  private AcceptLanguage acceptLanguage;

  private Language language;


  /**
   * Gets the text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }


  /**
   * Gets the content type.
   * 
   * @return the contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Gets the content items.
   * 
   * @return the contentItems
   */
  public List<ContentItem> getContentItems() {
    return contentItems;
  }


  /**
   * Gets the include raw.
   * 
   * @return the includeRaw
   */
  public Boolean getIncludeRaw() {
    return includeRaw;
  }


  /**
   * Gets the accept language.
   * 
   * @return the acceptLanguage
   */
  public AcceptLanguage getAcceptLanguage() {
    return acceptLanguage;
  }


  /**
   * Gets the language.
   * 
   * @return the language
   */
  public Language getLanguage() {
    return language;
  }


  /**
   * The Language Status.
   */
  public enum Language {

    @SerializedName("en") ENGLISH("en"),

    @SerializedName("es") SPANISH("es");

    private final String text;

    /**
     * @param text
     */
    private Language(final String text) {
      this.text = text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
      return text;
    }
  }


  /**
   * The Language Status.
   */
  public enum AcceptLanguage {

    @SerializedName("en") ENGLISH("en"),

    @SerializedName("es") SPANISH("es");

    private final String text;

    /**
     * @param text
     */
    private AcceptLanguage(final String text) {
      this.text = text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
      return text;
    }
  }

  /**
   * Text.
   * 
   * @param text the text
   * @return the profile options
   */
  public ProfileOptions text(String text) {
    this.text = text;
    this.contentType = HttpMediaType.TEXT_PLAIN;
    return this;
  }

  /**
   * Html.
   * 
   * @param html the html
   * @return the profile options
   */
  public ProfileOptions html(String html) {
    this.text = html;
    this.contentType = HttpMediaType.TEXT_HTML;
    return this;
  }

  /**
   * Content items.
   * 
   * @param contentItems the content items
   * @return the profile options
   */
  public ProfileOptions contentItems(List<ContentItem> contentItems) {
    this.contentItems = contentItems;
    this.contentType = HttpMediaType.APPLICATION_JSON;
    return this;
  }

  /**
   * Adds a content items.
   * 
   * @param contentItem the content item
   * @return the profile options
   */
  public ProfileOptions addContentItem(ContentItem contentItem) {
    if (this.contentItems == null) {
      this.contentItems = new ArrayList<ContentItem>();
      this.contentType = HttpMediaType.APPLICATION_JSON;
    }
    this.contentItems.add(contentItem);
    return this;
  }


  /**
   * Include raw.
   * 
   * @param includeRaw the include raw
   * @return the profile options
   */
  public ProfileOptions includeRaw(boolean includeRaw) {
    this.includeRaw = includeRaw;
    return this;
  }

  /**
   * Language.
   * 
   * @param language the language
   * @return the profile options
   */
  public ProfileOptions language(Language language) {
    this.language = language;
    return this;
  }

  /**
   * Accept language.
   * 
   * @param acceptLanguage the accept language
   * @return the profile options
   */
  public ProfileOptions acceptLanguage(AcceptLanguage acceptLanguage) {
    this.acceptLanguage = acceptLanguage;
    return this;
  }

}
