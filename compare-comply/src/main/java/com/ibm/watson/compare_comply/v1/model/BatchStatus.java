/*
 * (C) Copyright IBM Corp. 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** The batch-request status. */
public class BatchStatus extends GenericModel {

  /**
   * The method to be run against the documents. Possible values are `html_conversion`,
   * `element_classification`, and `tables`.
   */
  public interface Function {
    /** element_classification. */
    String ELEMENT_CLASSIFICATION = "element_classification";
    /** html_conversion. */
    String HTML_CONVERSION = "html_conversion";
    /** tables. */
    String TABLES = "tables";
  }

  protected String function;

  @SerializedName("input_bucket_location")
  protected String inputBucketLocation;

  @SerializedName("input_bucket_name")
  protected String inputBucketName;

  @SerializedName("output_bucket_location")
  protected String outputBucketLocation;

  @SerializedName("output_bucket_name")
  protected String outputBucketName;

  @SerializedName("batch_id")
  protected String batchId;

  @SerializedName("document_counts")
  protected DocCounts documentCounts;

  protected String status;
  protected Date created;
  protected Date updated;

  /**
   * Gets the function.
   *
   * <p>The method to be run against the documents. Possible values are `html_conversion`,
   * `element_classification`, and `tables`.
   *
   * @return the function
   */
  public String getFunction() {
    return function;
  }

  /**
   * Gets the inputBucketLocation.
   *
   * <p>The geographical location of the Cloud Object Storage input bucket as listed on the
   * **Endpoint** tab of your COS instance; for example, `us-geo`, `eu-geo`, or `ap-geo`.
   *
   * @return the inputBucketLocation
   */
  public String getInputBucketLocation() {
    return inputBucketLocation;
  }

  /**
   * Gets the inputBucketName.
   *
   * <p>The name of the Cloud Object Storage input bucket.
   *
   * @return the inputBucketName
   */
  public String getInputBucketName() {
    return inputBucketName;
  }

  /**
   * Gets the outputBucketLocation.
   *
   * <p>The geographical location of the Cloud Object Storage output bucket as listed on the
   * **Endpoint** tab of your COS instance; for example, `us-geo`, `eu-geo`, or `ap-geo`.
   *
   * @return the outputBucketLocation
   */
  public String getOutputBucketLocation() {
    return outputBucketLocation;
  }

  /**
   * Gets the outputBucketName.
   *
   * <p>The name of the Cloud Object Storage output bucket.
   *
   * @return the outputBucketName
   */
  public String getOutputBucketName() {
    return outputBucketName;
  }

  /**
   * Gets the batchId.
   *
   * <p>The unique identifier for the batch request.
   *
   * @return the batchId
   */
  public String getBatchId() {
    return batchId;
  }

  /**
   * Gets the documentCounts.
   *
   * <p>Document counts.
   *
   * @return the documentCounts
   */
  public DocCounts getDocumentCounts() {
    return documentCounts;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the batch request.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the created.
   *
   * <p>The creation time of the batch request.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the updated.
   *
   * <p>The time of the most recent update to the batch request.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }
}
