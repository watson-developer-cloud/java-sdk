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
package com.ibm.watson.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Object containing smart document understanding information for this collection. */
public class SduStatus extends GenericModel {

  protected Boolean enabled;

  @SerializedName("total_annotated_pages")
  protected Long totalAnnotatedPages;

  @SerializedName("total_pages")
  protected Long totalPages;

  @SerializedName("total_documents")
  protected Long totalDocuments;

  @SerializedName("custom_fields")
  protected SduStatusCustomFields customFields;

  /**
   * Gets the enabled.
   *
   * <p>When `true`, smart document understanding conversion is enabled for this collection. All
   * collections created with a version date after `2019-04-30` have smart document understanding
   * enabled. If `false`, documents added to the collection are converted using the **conversion**
   * settings specified in the configuration associated with the collection.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the totalAnnotatedPages.
   *
   * <p>The total number of pages annotated using smart document understanding in this collection.
   *
   * @return the totalAnnotatedPages
   */
  public Long getTotalAnnotatedPages() {
    return totalAnnotatedPages;
  }

  /**
   * Gets the totalPages.
   *
   * <p>The current number of pages that can be used for training smart document understanding. The
   * `total_pages` number is calculated as the total number of pages identified from the documents
   * listed in the **total_documents** field.
   *
   * @return the totalPages
   */
  public Long getTotalPages() {
    return totalPages;
  }

  /**
   * Gets the totalDocuments.
   *
   * <p>The total number of documents in this collection that can be used to train smart document
   * understanding. For **lite** plan collections, the maximum is the first 20 uploaded documents
   * (not including HTML or JSON documents). For other plans, the maximum is the first 40 uploaded
   * documents (not including HTML or JSON documents). When the maximum is reached, additional
   * documents uploaded to the collection are not considered for training smart document
   * understanding.
   *
   * @return the totalDocuments
   */
  public Long getTotalDocuments() {
    return totalDocuments;
  }

  /**
   * Gets the customFields.
   *
   * <p>Information about custom smart document understanding fields that exist in this collection.
   *
   * @return the customFields
   */
  public SduStatusCustomFields getCustomFields() {
    return customFields;
  }
}
