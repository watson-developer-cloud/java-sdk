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
package com.ibm.watson.discovery.v2.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.List;
import java.util.Map;

/** Result document for the specified query. */
public class QueryNoticesResult extends DynamicModel<Object> {
  /** The type of the original source file. */
  public interface FileType {
    /** pdf. */
    String PDF = "pdf";
    /** html. */
    String HTML = "html";
    /** word. */
    String WORD = "word";
    /** json. */
    String JSON = "json";
  }

  @SerializedName("document_id")
  private String documentId;

  @SerializedName("metadata")
  private Map<String, Object> metadata;

  @SerializedName("result_metadata")
  private QueryResultMetadata resultMetadata;

  @SerializedName("document_passages")
  private List<QueryResultPassage> documentPassages;

  @SerializedName("code")
  private Long code;

  @SerializedName("filename")
  private String filename;

  @SerializedName("file_type")
  private String fileType;

  @SerializedName("sha1")
  private String sha1;

  @SerializedName("notices")
  private List<Notice> notices;

  public QueryNoticesResult() {
    super(new TypeToken<Object>() {});
  }

  /**
   * Gets the documentId.
   *
   * <p>The unique identifier of the document.
   *
   * @return the documentId
   */
  public String getDocumentId() {
    return this.documentId;
  }

  /**
   * Gets the metadata.
   *
   * <p>Metadata of the document.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  /**
   * Gets the resultMetadata.
   *
   * <p>Metadata of a query result.
   *
   * @return the resultMetadata
   */
  public QueryResultMetadata getResultMetadata() {
    return this.resultMetadata;
  }

  /**
   * Gets the documentPassages.
   *
   * <p>Passages returned by Discovery.
   *
   * @return the documentPassages
   */
  public List<QueryResultPassage> getDocumentPassages() {
    return this.documentPassages;
  }

  /**
   * Gets the code.
   *
   * <p>The internal status code returned by the ingestion subsystem indicating the overall result
   * of ingesting the source document.
   *
   * @return the code
   */
  public Long getCode() {
    return this.code;
  }

  /**
   * Gets the filename.
   *
   * <p>Name of the original source file (if available).
   *
   * @return the filename
   */
  public String getFilename() {
    return this.filename;
  }

  /**
   * Gets the fileType.
   *
   * <p>The type of the original source file.
   *
   * @return the fileType
   */
  public String getFileType() {
    return this.fileType;
  }

  /**
   * Gets the sha1.
   *
   * <p>The SHA-1 hash of the original source file (formatted as a hexadecimal string).
   *
   * @return the sha1
   */
  public String getSha1() {
    return this.sha1;
  }

  /**
   * Gets the notices.
   *
   * <p>Array of notices for the document.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return this.notices;
  }
}
