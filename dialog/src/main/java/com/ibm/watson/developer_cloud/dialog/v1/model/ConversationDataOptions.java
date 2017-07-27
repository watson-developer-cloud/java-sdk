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
package com.ibm.watson.developer_cloud.dialog.v1.model;

import java.util.Date;

import com.ibm.watson.developer_cloud.util.Validator;

/**
 * Conversational data options used by the {@link Dialog} service.<br>
 * <br>
 * Here is an example of how to create a {@link ConversationDataOptions}:
 *
 * <pre>
 * <code>
 * ConversationDataOptions options = new ConversationDataOptions.Builder()
     .dialogId(&quot;dialog-id-here&quot;)
     .offset(0)
     .limit(10).build();
  </code>
 * </pre>
 */
public class ConversationDataOptions {
  private String dialogId;
  private Date from;
  private Integer limit;
  private Integer offset;
  private Date to;

  /**
   * Instantiates a new conversation data options.
   *
   * @param builder the builder
   */
  private ConversationDataOptions(Builder builder) {
    dialogId = builder.dialogId;
    from = builder.from;
    limit = builder.limit;
    offset = builder.offset;
    to = builder.to;
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
   * Builder.
   */
  public static class Builder {
    private String dialogId;
    private Date from;
    private Integer limit;
    private Integer offset;
    private Date to;


    /**
     * Instantiates a new builder.
     */
    public Builder() { }

    private Builder(ConversationDataOptions options) {
      dialogId = options.dialogId;
      from = options.from;
      limit = options.limit;
      offset = options.offset;
      to = options.to;
    }

    /**
     * Builds the conversation options.
     *
     * @return the conversation data options
     */
    public ConversationDataOptions build() {
      Validator.notNull(dialogId, "dialogId cannot be null");
      return new ConversationDataOptions(this);
    }

    /**
     * Sets the dialog id.
     *
     * @param dialogId the dialog id
     * @return the builder
     */
    public Builder dialogId(String dialogId) {
      this.dialogId = dialogId;
      return this;
    }

    /**
     * Sets the 'from' date.
     *
     * @param from the from
     * @return the builder
     */
    public Builder from(Date from) {
      this.from = from;
      return this;
    }

    /**
     * Sets the data limit.
     *
     * @param limit the limit
     * @return the builder
     */
    public Builder limit(Integer limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Sets the data offset.
     *
     * @param offset the offset
     * @return the builder
     */
    public Builder offset(Integer offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Sets the 'to' date.
     *
     * @param to the to
     * @return the builder
     */
    public Builder to(Date to) {
      this.to = to;
      return this;
    }
  }

  /**
   * Gets the dialog id.
   *
   * @return the dialog id
   */
  public String dialogId() {
    return dialogId;
  }

  /**
   * Gets the from.
   *
   * @return the from
   */
  public Date from() {
    return from;
  }

  /**
   * Gets the limit.
   *
   * @return the limit
   */
  public Integer limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * @return the offset
   */
  public Integer offset() {
    return offset;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public Date to() {
    return to;
  }

}
