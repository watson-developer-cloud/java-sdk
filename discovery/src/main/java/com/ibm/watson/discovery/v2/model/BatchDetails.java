/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/**
 * A batch is a set of documents that are ready for enrichment by an external application. After you
 * apply a webhook enrichment to a collection, and then process or upload documents to the
 * collection, Discovery creates a batch with a unique **batch_id**.
 */
public class BatchDetails extends GenericModel {

  @SerializedName("batch_id")
  protected String batchId;

  protected Date created;

  @SerializedName("enrichment_id")
  protected String enrichmentId;

  protected BatchDetails() {}

  /**
   * Gets the batchId.
   *
   * <p>The Universally Unique Identifier (UUID) for a batch of documents.
   *
   * @return the batchId
   */
  public String getBatchId() {
    return batchId;
  }

  /**
   * Gets the created.
   *
   * <p>The date and time (RFC3339) that the batch was created.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the enrichmentId.
   *
   * <p>The Universally Unique Identifier (UUID) for the external enrichment.
   *
   * @return the enrichmentId
   */
  public String getEnrichmentId() {
    return enrichmentId;
  }
}
