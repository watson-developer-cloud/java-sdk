/*
 * (C) Copyright IBM Corp. 2018, 2023.
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

/** An object contain retrieval type information. */
public class RetrievalDetails extends GenericModel {

  /**
   * Indentifies the document retrieval strategy used for this query. `relevancy_training` indicates
   * that the results were returned using a relevancy trained model. `continuous_relevancy_training`
   * indicates that the results were returned using the continuous relevancy training model created
   * by result feedback analysis. `untrained` means the results were returned using the standard
   * untrained model.
   *
   * <p>**Note**: In the event of trained collections being queried, but the trained model is not
   * used to return results, the **document_retrieval_strategy** will be listed as `untrained`.
   */
  public interface DocumentRetrievalStrategy {
    /** untrained. */
    String UNTRAINED = "untrained";
    /** relevancy_training. */
    String RELEVANCY_TRAINING = "relevancy_training";
    /** continuous_relevancy_training. */
    String CONTINUOUS_RELEVANCY_TRAINING = "continuous_relevancy_training";
  }

  @SerializedName("document_retrieval_strategy")
  protected String documentRetrievalStrategy;

  protected RetrievalDetails() {}

  /**
   * Gets the documentRetrievalStrategy.
   *
   * <p>Indentifies the document retrieval strategy used for this query. `relevancy_training`
   * indicates that the results were returned using a relevancy trained model.
   * `continuous_relevancy_training` indicates that the results were returned using the continuous
   * relevancy training model created by result feedback analysis. `untrained` means the results
   * were returned using the standard untrained model.
   *
   * <p>**Note**: In the event of trained collections being queried, but the trained model is not
   * used to return results, the **document_retrieval_strategy** will be listed as `untrained`.
   *
   * @return the documentRetrievalStrategy
   */
  public String getDocumentRetrievalStrategy() {
    return documentRetrievalStrategy;
  }
}
