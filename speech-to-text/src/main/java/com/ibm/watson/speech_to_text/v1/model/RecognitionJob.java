/*
 * (C) Copyright IBM Corp. 2016, 2020.
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
package com.ibm.watson.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** Information about a current asynchronous speech recognition job. */
public class RecognitionJob extends GenericModel {

  /**
   * The current status of the job: * `waiting`: The service is preparing the job for processing.
   * The service returns this status when the job is initially created or when it is waiting for
   * capacity to process the job. The job remains in this state until the service has the capacity
   * to begin processing it. * `processing`: The service is actively processing the job. *
   * `completed`: The service has finished processing the job. If the job specified a callback URL
   * and the event `recognitions.completed_with_results`, the service sent the results with the
   * callback notification. Otherwise, you must retrieve the results by checking the individual job.
   * * `failed`: The job failed.
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

  protected String id;
  protected String status;
  protected String created;
  protected String updated;
  protected String url;

  @SerializedName("user_token")
  protected String userToken;

  protected List<SpeechRecognitionResults> results;
  protected List<String> warnings;

  /**
   * Gets the id.
   *
   * <p>The ID of the asynchronous job.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the status.
   *
   * <p>The current status of the job: * `waiting`: The service is preparing the job for processing.
   * The service returns this status when the job is initially created or when it is waiting for
   * capacity to process the job. The job remains in this state until the service has the capacity
   * to begin processing it. * `processing`: The service is actively processing the job. *
   * `completed`: The service has finished processing the job. If the job specified a callback URL
   * and the event `recognitions.completed_with_results`, the service sent the results with the
   * callback notification. Otherwise, you must retrieve the results by checking the individual job.
   * * `failed`: The job failed.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the created.
   *
   * <p>The date and time in Coordinated Universal Time (UTC) at which the job was created. The
   * value is provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`).
   *
   * @return the created
   */
  public String getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The date and time in Coordinated Universal Time (UTC) at which the job was last updated by
   * the service. The value is provided in full ISO 8601 format (`YYYY-MM-DDThh:mm:ss.sTZD`). This
   * field is returned only by the **Check jobs** and **Check a job** methods.
   *
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * Gets the url.
   *
   * <p>The URL to use to request information about the job with the **Check a job** method. This
   * field is returned only by the **Create a job** method.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the userToken.
   *
   * <p>The user token associated with a job that was created with a callback URL and a user token.
   * This field can be returned only by the **Check jobs** method.
   *
   * @return the userToken
   */
  public String getUserToken() {
    return userToken;
  }

  /**
   * Gets the results.
   *
   * <p>If the status is `completed`, the results of the recognition request as an array that
   * includes a single instance of a `SpeechRecognitionResults` object. This field is returned only
   * by the **Check a job** method.
   *
   * @return the results
   */
  public List<SpeechRecognitionResults> getResults() {
    return results;
  }

  /**
   * Gets the warnings.
   *
   * <p>An array of warning messages about invalid parameters included with the request. Each
   * warning includes a descriptive message and a list of invalid argument strings, for example,
   * `"unexpected query parameter 'user_token', query parameter 'callback_url' was not specified"`.
   * The request succeeds despite the warnings. This field can be returned only by the **Create a
   * job** method.
   *
   * @return the warnings
   */
  public List<String> getWarnings() {
    return warnings;
  }
}
