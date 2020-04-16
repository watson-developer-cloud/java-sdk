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
package com.ibm.watson.language_translator.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.Date;

/** Document information, including translation status. */
public class DocumentStatus extends GenericModel {

  /** The status of the translation job associated with a submitted document. */
  public interface Status {
    /** processing. */
    String PROCESSING = "processing";
    /** available. */
    String AVAILABLE = "available";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("document_id")
  protected String documentId;

  protected String filename;
  protected String status;

  @SerializedName("model_id")
  protected String modelId;

  @SerializedName("base_model_id")
  protected String baseModelId;

  protected String source;
  protected String target;
  protected Date created;
  protected Date completed;

  @SerializedName("word_count")
  protected Long wordCount;

  @SerializedName("character_count")
  protected Long characterCount;

  /**
   * Gets the documentId.
   *
   * <p>System generated ID identifying a document being translated using one specific translation
   * model.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return documentId;
  }

  /**
   * Gets the filename.
   *
   * <p>filename from the submission (if it was missing in the multipart-form, 'noname.<ext matching
   * content type>' is used.
   *
   * @return the filename
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Gets the status.
   *
   * <p>The status of the translation job associated with a submitted document.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the modelId.
   *
   * <p>A globally unique string that identifies the underlying model that is used for translation.
   *
   * @return the modelId
   */
  public String getModelId() {
    return modelId;
  }

  /**
   * Gets the baseModelId.
   *
   * <p>Model ID of the base model that was used to customize the model. If the model is not a
   * custom model, this will be absent or an empty string.
   *
   * @return the baseModelId
   */
  public String getBaseModelId() {
    return baseModelId;
  }

  /**
   * Gets the source.
   *
   * <p>Translation source language code.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets the target.
   *
   * <p>Translation target language code.
   *
   * @return the target
   */
  public String getTarget() {
    return target;
  }

  /**
   * Gets the created.
   *
   * <p>The time when the document was submitted.
   *
   * @return the created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets the completed.
   *
   * <p>The time when the translation completed.
   *
   * @return the completed
   */
  public Date getCompleted() {
    return completed;
  }

  /**
   * Gets the wordCount.
   *
   * <p>An estimate of the number of words in the source document. Returned only if `status` is
   * `available`.
   *
   * @return the wordCount
   */
  public Long getWordCount() {
    return wordCount;
  }

  /**
   * Gets the characterCount.
   *
   * <p>The number of characters in the source document, present only if status=available.
   *
   * @return the characterCount
   */
  public Long getCharacterCount() {
    return characterCount;
  }
}
