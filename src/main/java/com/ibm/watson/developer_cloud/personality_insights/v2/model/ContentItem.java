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

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.LongToDateTypeAdapter;

/**
 * The Content to be analyzed.
 */
public class ContentItem extends GenericModel {
  private String charset;
  private String content;
  private String contentType;
  
  @JsonAdapter(LongToDateTypeAdapter.class)
  private Date created;
  private boolean forward;
  private String id;
  private String language;
  private String parentId;
  private boolean reply;
  private String sourceId;
  
  @JsonAdapter(LongToDateTypeAdapter.class)
  private Date updated;
  private String userId;

  /**
   * Gets the character set of the text, for example, "UTF-8".
   * 
   * @return the charset
   */
  public String getCharset() {
    return charset;
  }

  /**
   * Gets the content to be analyzed. Up to 20MB of content is supported.
   * 
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Gets the MIME type of the content, for example, "text/plain, text/html". The tags are stripped
   * from HTML content before it is analyzed. Other MIME types are processed as is.
   * 
   * @return the contentType
   */
  public String getContentType() {
    return contentType;
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
   * Gets the unique id of the parent content item. Used to identify hierarchical relationships
   * between posts/replies, messages/replies, etc.
   * 
   * @return the parent identifier
   */
  public String getParentId() {
    return parentId;
  }

  /**
   * Gets the identifier for the source of this content. For example, blog123, twitter.
   * 
   * @return the source identifier
   */
  public String getSourceId() {
    return sourceId;
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
   * Gets the unique identifier for the author of this content.
   * 
   * @return the user identifier
   */
  public String getUserId() {
    return userId;
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
   * Sets the character set of the text, for example, "UTF-8".
   * 
   * @param charset the new character set of the text, for example, "UTF-8"
   */
  public void setCharset(String charset) {
    this.charset = charset;
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
   * Sets the MIME type of the content, for example, "text/plain, text/html". The tags are stripped
   * from HTML content before it is analyzed. Other MIME types are processed as is.
   * 
   * @param contentType the new MIME type of the content
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
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
   * Indicates whether this content item is a forwarded/copied version of another content item.
   * 
   * @param forward set true if the content is a forwarded/copied version of another content item.
   */
  public void setForward(boolean forward) {
    this.forward = forward;
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
   * Sets the language identifier (two-letter ISO 639-1 identifier). Currently only English content
   * (en) is supported.,
   * 
   * @param language the language charset (two-letter ISO 639-1 identifier)
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Sets the unique id of the parent content item. Used to identify hierarchical relationships
   * between posts/replies, messages/replies, etc.,
   * 
   * @param parentId the parent identifier
   */
  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  /**
   * Indicates whether this content item is a reply to another content item.
   * 
   * @param reply true if is a reply
   */
  public void setReply(boolean reply) {
    this.reply = reply;
  }

  /**
   * Sets the identifier for the source of this content. For example, blog123, twitter
   * 
   * @param sourceId the source identifier
   */
  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
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
   * Sets the unique identifier for the author of this content.
   * 
   * @param userId the new user identifier
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

}
