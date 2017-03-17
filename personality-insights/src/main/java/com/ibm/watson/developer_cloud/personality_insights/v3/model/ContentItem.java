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

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;

/**
 * The Content to be analyzed.
 */
public class ContentItem extends GenericModel {
  private String content;
  @SerializedName("contenttype")
  private String contentType;

  @JsonAdapter(LongToDateTypeAdapter.class)
  private Date created;
  @JsonAdapter(LongToDateTypeAdapter.class)
  private Date updated;


  private Boolean forward;
  private String id;
  private String language;
  @SerializedName("parentid")
  private String parentId;
  private Boolean reply;

  /**
   * Gets the content to be analyzed. Up to 20MB of content is supported.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Gets the date that identifies when this content was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the unique identifier for this content item.
   *
   * @return the identifier
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the language identifier (two-letter ISO 639-1 identifier).
   *
   * @return the language identifier (two-letter ISO 639-1 identifier).
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the date that identifies when this content was last updated.
   *
   * @return the updated date
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Indicates whether this content item is a forwarded/copied version of another content item.
   *
   * @return the forward
   */
  public boolean isForward() {
    return forward;
  }

  /**
   * Indicates whether this content item is a reply to another content item.
   *
   * @return true, if is reply
   */
  public boolean isReply() {
    return reply;
  }

  /**
   * Sets the content to be analyzed. Up to 20MB of content is supported.
   *
   * @param content the new content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Sets the date that identifies when this content was created.
   *
   * @param created the new created date
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Sets the unique identifier for this content item.
   *
   * @param id the unique identifier
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets the language identifier (two-letter ISO 639-1 identifier). Currently only English content (en) is supported.,
   *
   * @param language the language charset (two-letter ISO 639-1 identifier)
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Sets the date that identifies when this content was last updated..
   *
   * @param updated the updated date
   */
  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  /**
   * Gets the MIME type of the content, for example, "text/plain, text/html". The tags are stripped from HTML content
   * before it is analyzed. Other MIME types are processed as is.
   *
   * @return the contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * Sets the MIME type of the content, for example, "text/plain, text/html". The tags are stripped from HTML content
   * before it is analyzed. Other MIME types are processed as is.
   *
   * @param contentType the new MIME type of the content
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  /**
   * Gets the unique id of the parent content item. Used to identify hierarchical relationships between posts/replies,
   * messages/replies, etc.
   *
   * @return the parent identifier
   */
  public String getParentId() {
    return parentId;
  }

  /**
   * Sets the unique id of the parent content item. Used to identify hierarchical relationships between posts/replies,
   * messages/replies, etc.,
   *
   * @param parentId the parent identifier
   */
  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  /**
   * Indicates whether this content item is a forwarded/copied version of another content item.
   *
   * @param forward set true if the content is a forwarded/copied version of another content item.
   */
  public void setForward(Boolean forward) {
    this.forward = forward;
  }

  /**
   * Indicates whether this content item is a reply to another content item.
   *
   * @param reply true if is a reply
   */
  public void setReply(Boolean reply) {
    this.reply = reply;
  }

}
