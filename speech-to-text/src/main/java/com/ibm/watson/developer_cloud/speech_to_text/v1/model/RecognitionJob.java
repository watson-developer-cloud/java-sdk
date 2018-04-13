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
package com.ibm.watson.developer_cloud.speech_to_text.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * RecognitionJob.
 */
public class RecognitionJob extends GenericModel {

  /**
   * The current status of the job: * `waiting`: The service is preparing the job for processing. The service returns
   * this status when the job is initially created or when it is waiting for capacity to process the job. The job
   * remains in this state until the service has the capacity to begin processing it. * `processing`: The service is
   * actively processing the job. * `completed`: The service has finished processing the job. If the job specified a
   * callback URL and the event `recognitions.completed_with_results`, the service sent the results with the callback
   * notification; otherwise, you must retrieve the results by checking the individual job. * `failed`: The job failed.
   */
  public interface Status {
    /** waiting. */
    String WAITING = "waiting";
    /** processing. */
    String PROCESSING = "processing";
    /** completed. */
    String COMPLETED = "completed";
    /** failed. */
    String FAILED = "failed";
  }

  private String id;
  private String status;
  private String created;
  private String updated;
  private String url;
  @SerializedName("user_token")
  private String userToken;
  private List<SpeechRecognitionResults> results;
  private List<String> warnings;

  /**
   * Gets the id.
   *
   * The ID of the job.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the status.
   *
   * The current status of the job: * `waiting`: The service is preparing the job for processing. The service returns
   * this status when the job is initially created or when it is waiting for capacity to process the job. The job
   * remains in this state until the service has the capacity to begin processing it. * `processing`: The service is
   * actively processing the job. * `completed`: The service has finished processing the job. If the job specified a
   * callback URL and the event `recognitions.completed_with_results`, the service sent the results with the callback
   * notification; otherwise, you must retrieve the results by checking the individual job. * `failed`: The job failed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the created.
   *
   * The date and time in Coordinated Universal Time (UTC) at which the job was created. The value is provided in full
   * ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * The date and time in Coordinated Universal Time (UTC) at which the job was last updated by the service. The value
   * is provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`). **Note:** This field is returned only when you
   * list information about a specific or all existing jobs.
   *
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Gets the url.
   *
   * The URL to use to request information about the job with the `GET /v1/recognitions/{id}` method. **Note:** This
   * field is returned only when you create a new job.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the userToken.
   *
   * The user token associated with a job that was created with a callback URL and a user token. **Note:** This field
   * can be returned only when you list information about all existing jobs.
   *
   * @return the userToken
   */
  public String getUserToken() {
    return userToken;
  }

  /**
   * Gets the results.
   *
   * If the status is `completed`, the results of the recognition request as an array that includes a single instance of
   * a `SpeechRecognitionResults` object. **Note:** This field can be returned only when you list information about a
   * specific existing job.
   *
   * @return the results
   */
  public List<SpeechRecognitionResults> getResults() {
    return results;
  }

  /**
   * Gets the warnings.
   *
   * An array of warning messages about invalid query parameters included with the request. Each warning includes a
   * descriptive message and a list of invalid argument strings, for example, `"unexpected query parameter 'user_token',
   * query parameter 'callback_url' was not specified"`. The request succeeds despite the warnings. **Note:** This field
   * can be returned only when you create a new job.
   *
   * @return the warnings
   */
  public List<String> getWarnings() {
    return warnings;
  }
}
