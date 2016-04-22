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
package com.ibm.watson.developer_cloud.dialog.v1.model;

import java.util.Date;

/**
 * Conversational data options used by the {@link Dialog} service.
 */
public class ConversationDataOptions {
  private String dialogId;
  private Date from;
  private Integer limit;
  private Integer offset;
  private Date to;


  /**
   * Sets the dialog id.
   *
   * @param dialogId the dialog id
   * @return the conversation data options
   */
  public ConversationDataOptions dialogId(String dialogId) {
    this.dialogId = dialogId;
    return this;
  }


  /**
   * Sets the 'from' date.
   *
   * @param from the from
   * @return the conversation data options
   */
  public ConversationDataOptions from(Date from) {
    this.from = from;
    return this;
  }

  /**
   * Gets the dialog id.
   *
   * @return the dialog id
   */
  public String getDialogId() {
    return dialogId;
  }

  /**
   * Gets the from.
   *
   * @return the from
   */
  public Date getFrom() {
    return from;
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * @return the offset
   */
  public Integer getOffset() {
    return offset;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public Date getTo() {
    return to;
  }

  /**
   * Sets the data limit.
   *
   * @param limit the limit
   * @return the conversation data options
   */
  public ConversationDataOptions limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Sets the data offset.
   *
   * @param offset the offset
   * @return the conversation data options
   */
  public ConversationDataOptions offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Sets the 'to' date.
   *
   * @param to the to
   * @return the conversation data options
   */
  public ConversationDataOptions to(Date to) {
    this.to = to;
    return this;
  }

}
