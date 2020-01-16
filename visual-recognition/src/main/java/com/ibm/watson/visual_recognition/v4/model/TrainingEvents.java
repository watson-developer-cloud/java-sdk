/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
package com.ibm.watson.visual_recognition.v4.model;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Details about the training events.
 */
public class TrainingEvents extends GenericModel {

  @SerializedName("start_time")
  protected Date startTime;
  @SerializedName("end_time")
  protected Date endTime;
  @SerializedName("completed_events")
  protected Long completedEvents;
  @SerializedName("trained_images")
  protected Long trainedImages;
  protected List<TrainingEvent> events;

  /**
   * Gets the startTime.
   *
   * The starting day for the returned training events in Coordinated Universal Time (UTC). If not specified in the
   * request, it identifies the earliest training event.
   *
   * @return the startTime
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * Gets the endTime.
   *
   * The ending day for the returned training events in Coordinated Universal Time (UTC). If not specified in the
   * request, it lists the current time.
   *
   * @return the endTime
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * Gets the completedEvents.
   *
   * The total number of training events in the response for the start and end times.
   *
   * @return the completedEvents
   */
  public Long getCompletedEvents() {
    return completedEvents;
  }

  /**
   * Gets the trainedImages.
   *
   * The total number of images that were used in training for the start and end times.
   *
   * @return the trainedImages
   */
  public Long getTrainedImages() {
    return trainedImages;
  }

  /**
   * Gets the events.
   *
   * The completed training events for the start and end time.
   *
   * @return the events
   */
  public List<TrainingEvent> getEvents() {
    return events;
  }
}
