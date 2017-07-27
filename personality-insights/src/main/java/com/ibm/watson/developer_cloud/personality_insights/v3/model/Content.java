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
package com.ibm.watson.developer_cloud.personality_insights.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Content.
 */
public class Content extends GenericModel {

  private List<ContentItem> contentItems;

  /**
   * Builder.
   */
  public static class Builder {
    private List<ContentItem> contentItems;

    private Builder(Content content) {
      contentItems = content.contentItems;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param contentItems the contentItems
     */
    public Builder(List<ContentItem> contentItems) {
      this.contentItems = contentItems;
    }

    /**
     * Builds a Content.
     *
     * @return the content
     */
    public Content build() {
      return new Content(this);
    }

    /**
     * Adds an contentItem to contentItems.
     *
     * @param contentItem the new contentItem
     * @return the Content builder
     */
    public Builder addContentItem(ContentItem contentItem) {
      Validator.notNull(contentItem, "contentItem cannot be null");
      if (this.contentItems == null) {
        this.contentItems = new ArrayList<ContentItem>();
      }
      this.contentItems.add(contentItem);
      return this;
    }

    /**
     * Set the contentItems.
     * Existing contentItems will be replaced.
     *
     * @param contentItems the contentItems
     * @return the Content builder
     */
    public Builder contentItems(List<ContentItem> contentItems) {
      this.contentItems = contentItems;
      return this;
    }
  }

  private Content(Builder builder) {
    Validator.notNull(builder.contentItems, "contentItems cannot be null");
    contentItems = builder.contentItems;
  }

  /**
   * New builder.
   *
   * @return a Content builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the contentItems.
   *
   * An array of `ContentItem` objects that provides the text that is to be analyzed.
   *
   * @return the contentItems
   */
  public List<ContentItem> contentItems() {
    return contentItems;
  }
}
