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
package com.ibm.watson.developer_cloud.personality_insights.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * {@link ContentItem} container.
 */
public class Content extends GenericModel {
  private List<ContentItem> contentItems;

  /**
   * Adds a content item.
   *
   * @param contentItem the content item
   */
  public void addContentItem(ContentItem contentItem) {
    if (contentItems == null) {
      contentItems = new ArrayList<ContentItem>();
    }

    contentItems.add(contentItem);
  }

  /**
   * Gets the content items.
   *
   *
   * @return the content items
   */
  public List<ContentItem> getContentItems() {
    return contentItems;
  }

  /**
   * Sets the content items.
   *
   * @param contentItems the new content items
   */
  public void setContentItems(List<ContentItem> contentItems) {
    this.contentItems = contentItems;
  }

}
