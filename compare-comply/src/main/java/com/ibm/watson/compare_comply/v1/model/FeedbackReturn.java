/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about the document and the submitted feedback.
 */
public class FeedbackReturn extends GenericModel {

  @SerializedName("feedback_id")
  private String feedbackId;
  @SerializedName("user_id")
  private String userId;
  private String comment;
  private Date created;
  @SerializedName("feedback_data")
  private FeedbackDataOutput feedbackData;

  /**
   * Gets the feedbackId.
   *
   * The unique ID of the feedback object.
   *
   * @return the feedbackId
   */
  public String getFeedbackId() {
    return feedbackId;
  }

  /**
   * Gets the userId.
   *
   * An optional string identifying the person submitting feedback.
   *
   * @return the userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Gets the comment.
   *
   * An optional comment from the person submitting the feedback.
   *
   * @return the comment
   */
  public String getComment() {
    return comment;
  }

  /**
   * Gets the created.
   *
   * Timestamp listing the creation time of the feedback submission.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the feedbackData.
   *
   * Information returned from the **Add Feedback** method.
   *
   * @return the feedbackData
   */
  public FeedbackDataOutput getFeedbackData() {
    return feedbackData;
  }
}
