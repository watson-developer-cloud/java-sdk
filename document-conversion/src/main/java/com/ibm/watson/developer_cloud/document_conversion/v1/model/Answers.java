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
package com.ibm.watson.developer_cloud.document_conversion.v1.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Structure that stores the output of document that is converted into an Answer unit.
 *
 * @see DocumentConversion
 */
public class Answers extends GenericModel {

  /**
   * The object that holds the answer units of a source document.
   */
  public class AnswerUnits extends GenericModel {

    /**
     * The content of an answer unit.
     */
    public class Content extends GenericModel {

      /** The Internet media type of the answer unit. */
      @SerializedName("media_type")
      private String mediaType;

      /** The text of the answer unit. */
      private String text;

      /**
       * Gets the Internet media type of the answer unit.
       *
       * @return String
       */
      public String getMediaType() {
        return mediaType;
      }

      /**
       * Gets the text of the answer unit.
       *
       * @return String
       */
      public String getText() {
        return text;
      }

      /**
       * Sets the Internet media type of the answer unit.
       *
       * @param mediaType The Internet media type
       */
      public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
      }

      /**
       * Sets the text of the answer unit.
       *
       * @param text The text of the answer unit
       */
      public void setText(String text) {
        this.text = text;
      }
    }

    /** The list of content of the answer unit. */
    private List<Content> content;

    /** The id of the answer unit. */
    private String id;

    /** The title of the answer unit. */
    private String title;

    /** The type of the answer unit. */
    private String type;

    private String direction;

    @SerializedName("parent_id")
    private String parentId;

    /**
     * Gets the direction.
     *
     * @return the direction
     */
    public String getDirection() {
      return direction;
    }

    /**
     * Sets the direction.
     *
     * @param direction the new direction
     */
    public void setDirection(String direction) {
      this.direction = direction;
    }

    /**
     * Gets the parent id.
     *
     * @return the parent id
     */
    public String getParentId() {
      return parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(String parentId) {
      this.parentId = parentId;
    }

    /**
     * Gets the list of content for the answer unit.
     *
     * @return List
     */
    public List<Content> getContent() {
      return content;
    }

    /**
     * Gets the id of the answer unit.
     *
     * @return The id of the answer unit
     */
    public String getId() {
      return id;
    }

    /**
     * Gets the title of the answer unit.
     *
     * @return String
     */
    public String getTitle() {
      return title;
    }

    /**
     * Gets the type of the answer unit.
     *
     * @return String
     */
    public String getType() {
      return type;
    }

    /**
     * Sets the list of content for the answer unit.
     *
     * @param content The list of content for the answer unit
     */
    public void setContent(List<Content> content) {
      this.content = content;
    }

    /**
     * Sets the id of the answer unit.
     *
     * @param id The id of the answer unit
     */
    public void setId(String id) {
      this.id = id;
    }

    /**
     * Sets the title of the answer unit.
     *
     * @param title The title of the answer unit
     */
    public void setTitle(String title) {
      this.title = title;
    }

    /**
     * Sets the type of the answer unit.
     *
     * @param type The type of the answer unit
     */
    public void setType(String type) {
      this.type = type;
    }
  }

  /** The list of answer units generated for the source document. */
  @SerializedName("answer_units")
  private List<AnswerUnits> answerUnits;

  /** The id of the source document used to derive the answer. */
  @SerializedName("source_document_id")
  private String sourceDocumentId;

  /** The date time when the answer was created. */
  private Date timestamp;

  /**
   * Gets the list of answer units.
   *
   * @return List
   */
  public List<AnswerUnits> getAnswerUnits() {
    return answerUnits;
  }

  /**
   * Gets the source document id.
   *
   * @return String
   */
  public String getSourceDocumentId() {
    return sourceDocumentId;
  }

  /**
   * Gets the time stamp of the answer.
   *
   * @return Date
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the list of answer units.
   *
   * @param answerUnits The list of answer units
   */
  public void setAnswerUnits(List<AnswerUnits> answerUnits) {
    this.answerUnits = answerUnits;
  }

  /**
   * Sets the source document id.
   *
   * @param sourceDocumentId The id of the source document
   */
  public void setSourceDocumentId(String sourceDocumentId) {
    this.sourceDocumentId = sourceDocumentId;
  }

  /**
   * Sets the timestamp of the answwer.
   *
   * @param timestamp the new timestamp
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
}
