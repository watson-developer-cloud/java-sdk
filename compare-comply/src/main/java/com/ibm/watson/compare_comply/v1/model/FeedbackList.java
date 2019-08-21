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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The results of a successful **List Feedback** request for all feedback.
 */
public class FeedbackList extends GenericModel {

  private List<GetFeedback> feedback;

  /**
   * Gets the feedback.
   *
   * A list of all feedback for the document.
   *
   * @return the feedback
   */
  public List<GetFeedback> getFeedback() {
    return feedback;
  }
}
