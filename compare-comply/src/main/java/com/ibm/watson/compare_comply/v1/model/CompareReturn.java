/*
 * (C) Copyright IBM Corp. 2018, 2020.
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
import java.util.List;

/** The comparison of the two submitted documents. */
public class CompareReturn extends GenericModel {

  @SerializedName("model_id")
  protected String modelId;

  @SerializedName("model_version")
  protected String modelVersion;

  protected List<Document> documents;

  @SerializedName("aligned_elements")
  protected List<AlignedElement> alignedElements;

  @SerializedName("unaligned_elements")
  protected List<UnalignedElement> unalignedElements;

  /**
   * Gets the modelId.
   *
   * <p>The analysis model used to compare the input documents. For the **Compare two documents**
   * method, the only valid value is `contracts`.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the modelVersion.
   *
   * <p>The version of the analysis model identified by the value of the `model_id` key.
   *
   * @return the modelVersion
   */
  public String getModelVersion() {
    return modelVersion;
  }

  /**
   * Gets the documents.
   *
   * <p>Information about the documents being compared.
   *
   * @return the documents
   */
  public List<Document> getDocuments() {
    return documents;
  }

  /**
   * Gets the alignedElements.
   *
   * <p>A list of pairs of elements that semantically align between the compared documents.
   *
   * @return the alignedElements
   */
  public List<AlignedElement> getAlignedElements() {
    return alignedElements;
  }

  /**
   * Gets the unalignedElements.
   *
   * <p>A list of elements that do not semantically align between the compared documents.
   *
   * @return the unalignedElements
   */
  public List<UnalignedElement> getUnalignedElements() {
    return unalignedElements;
  }
}
