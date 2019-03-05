/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.compare_comply.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The addFeedback options.
 */
public class AddFeedbackOptions extends GenericModel {

  private String userId;
  private String comment;
  private FeedbackDataInput feedbackData;

  /**
   * Builder.
   */
  public static class Builder {
    private String userId;
    private String comment;
    private FeedbackDataInput feedbackData;

    private Builder(AddFeedbackOptions addFeedbackOptions) {
      userId = addFeedbackOptions.userId;
      comment = addFeedbackOptions.comment;
      feedbackData = addFeedbackOptions.feedbackData;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param feedbackData the feedbackData
     */
    public Builder(FeedbackDataInput feedbackData) {
      this.feedbackData = feedbackData;
    }

    /**
     * Builds a AddFeedbackOptions.
     *
     * @return the addFeedbackOptions
     */
    public AddFeedbackOptions build() {
      return new AddFeedbackOptions(this);
    }

    /**
     * Set the userId.
     *
     * @param userId the userId
     * @return the AddFeedbackOptions builder
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment
     * @return the AddFeedbackOptions builder
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }

    /**
     * Set the feedbackData.
     *
     * @param feedbackData the feedbackData
     * @return the AddFeedbackOptions builder
     */
    public Builder feedbackData(FeedbackDataInput feedbackData) {
      this.feedbackData = feedbackData;
      return this;
    }
  }

  private AddFeedbackOptions(Builder builder) {
    Validator.notNull(builder.feedbackData, "feedbackData cannot be null");
    userId = builder.userId;
    comment = builder.comment;
    feedbackData = builder.feedbackData;
  }

  /**
   * New builder.
   *
   * @return a AddFeedbackOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the userId.
   *
   * An optional string identifying the user.
   *
   * @return the userId
   */
  public String userId() {
    return userId;
  }

  /**
   * Gets the comment.
   *
   * An optional comment on or description of the feedback.
   *
   * @return the comment
   */
  public String comment() {
    return comment;
  }

  /**
   * Gets the feedbackData.
   *
   * Feedback data for submission.
   *
   * @return the feedbackData
   */
  public FeedbackDataInput feedbackData() {
    return feedbackData;
  }
}
