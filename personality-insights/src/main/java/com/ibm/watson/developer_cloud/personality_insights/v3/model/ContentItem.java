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

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * ContentItem.
 */
public class ContentItem extends GenericModel {

  /**
   * MIME type of the content. The default is plain text. The tags are stripped from HTML content before it is analyzed;
   * plain text is processed as submitted.
   */
  public interface Contenttype {
    /** text/plain. */
    String TEXT_PLAIN = "text/plain";
    /** text/html. */
    String TEXT_HTML = "text/html";
  }

  /**
   * Language identifier (two-letter ISO 639-1 identifier) for the language of the content item. The default is `en`
   * (English). Regional variants are treated as their parent language; for example, `en-US` is interpreted as `en`. A
   * language specified with the `Content-Type` header overrides the value of this parameter; any content items that
   * specify a different language are ignored. Omit the `Content-Type` header to base the language on the most prevalent
   * specification among the content items; again, content items that specify a different language are ignored. You can
   * specify any combination of languages for the input and response content.
   */
  public interface Language {
    /** ar. */
    String AR = "ar";
    /** en. */
    String EN = "en";
    /** es. */
    String ES = "es";
    /** ja. */
    String JA = "ja";
    /** ko. */
    String KO = "ko";
  }

  private String content;
  private String id;
  private Long created;
  private Long updated;
  private String contenttype;
  private String language;
  private String parentid;
  private Boolean reply;
  private Boolean forward;

  /**
   * Builder.
   */
  public static class Builder {
    private String content;
    private String id;
    private Long created;
    private Long updated;
    private String contenttype;
    private String language;
    private String parentid;
    private Boolean reply;
    private Boolean forward;

    private Builder(ContentItem contentItem) {
      content = contentItem.content;
      id = contentItem.id;
      created = contentItem.created;
      updated = contentItem.updated;
      contenttype = contentItem.contenttype;
      language = contentItem.language;
      parentid = contentItem.parentid;
      reply = contentItem.reply;
      forward = contentItem.forward;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param content the content
     */
    public Builder(String content) {
      this.content = content;
    }

    /**
     * Builds a ContentItem.
     *
     * @return the contentItem
     */
    public ContentItem build() {
      return new ContentItem(this);
    }

    /**
     * Set the content.
     *
     * @param content the content
     * @return the ContentItem builder
     */
    public Builder content(String content) {
      this.content = content;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ContentItem builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the created.
     *
     * @param created the created
     * @return the ContentItem builder
     */
    public Builder created(long created) {
      this.created = created;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the ContentItem builder
     */
    public Builder updated(long updated) {
      this.updated = updated;
      return this;
    }

    /**
     * Set the contenttype.
     *
     * @param contenttype the contenttype
     * @return the ContentItem builder
     */
    public Builder contenttype(String contenttype) {
      this.contenttype = contenttype;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the ContentItem builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the parentid.
     *
     * @param parentid the parentid
     * @return the ContentItem builder
     */
    public Builder parentid(String parentid) {
      this.parentid = parentid;
      return this;
    }

    /**
     * Set the reply.
     *
     * @param reply the reply
     * @return the ContentItem builder
     */
    public Builder reply(Boolean reply) {
      this.reply = reply;
      return this;
    }

    /**
     * Set the forward.
     *
     * @param forward the forward
     * @return the ContentItem builder
     */
    public Builder forward(Boolean forward) {
      this.forward = forward;
      return this;
    }
  }

  private ContentItem(Builder builder) {
    Validator.notNull(builder.content, "content cannot be null");
    content = builder.content;
    id = builder.id;
    created = builder.created;
    updated = builder.updated;
    contenttype = builder.contenttype;
    language = builder.language;
    parentid = builder.parentid;
    reply = builder.reply;
    forward = builder.forward;
  }

  /**
   * New builder.
   *
   * @return a ContentItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the content.
   *
   * Content that is to be analyzed. The service supports up to 20 MB of content for all items combined.
   *
   * @return the content
   */
  public String content() {
    return content;
  }

  /**
   * Gets the id.
   *
   * Unique identifier for this content item.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the created.
   *
   * Timestamp that identifies when this content was created. Specify a value in milliseconds since the UNIX Epoch
   * (January 1, 1970, at 0:00 UTC). Required only for results that include temporal behavior data.
   *
   * @return the created
   */
  public Long created() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * Timestamp that identifies when this content was last updated. Specify a value in milliseconds since the UNIX Epoch
   * (January 1, 1970, at 0:00 UTC). Required only for results that include temporal behavior data.
   *
   * @return the updated
   */
  public Long updated() {
    return updated;
  }

  /**
   * Gets the contenttype.
   *
   * MIME type of the content. The default is plain text. The tags are stripped from HTML content before it is analyzed;
   * plain text is processed as submitted.
   *
   * @return the contenttype
   */
  public String contenttype() {
    return contenttype;
  }

  /**
   * Gets the language.
   *
   * Language identifier (two-letter ISO 639-1 identifier) for the language of the content item. The default is `en`
   * (English). Regional variants are treated as their parent language; for example, `en-US` is interpreted as `en`. A
   * language specified with the `Content-Type` header overrides the value of this parameter; any content items that
   * specify a different language are ignored. Omit the `Content-Type` header to base the language on the most prevalent
   * specification among the content items; again, content items that specify a different language are ignored. You can
   * specify any combination of languages for the input and response content.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the parentid.
   *
   * Unique ID of the parent content item for this item. Used to identify hierarchical relationships between
   * posts/replies, messages/replies, and so on.
   *
   * @return the parentid
   */
  public String parentid() {
    return parentid;
  }

  /**
   * Gets the reply.
   *
   * Indicates whether this content item is a reply to another content item.
   *
   * @return the reply
   */
  public Boolean reply() {
    return reply;
  }

  /**
   * Gets the forward.
   *
   * Indicates whether this content item is a forwarded/copied version of another content item.
   *
   * @return the forward
   */
  public Boolean forward() {
    return forward;
  }
}
