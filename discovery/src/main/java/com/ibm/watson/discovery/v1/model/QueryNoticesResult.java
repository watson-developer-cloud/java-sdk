/*
 * (C) Copyright IBM Corp. 2019.
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

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;

/**
 * Query result object.
 */
public class QueryNoticesResult extends DynamicModel<Object> {
  /**
   * The type of the original source file.
   */
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

  @SerializedName("id")
  private String id;
  @SerializedName("metadata")
  private Map<String, Object> metadata;
  @SerializedName("collection_id")
  private String collectionId;
  @SerializedName("result_metadata")
  private QueryResultMetadata resultMetadata;
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
    super(new TypeToken<Object>() {
    });
  }

  /**
   * Gets the id.
   *
   * The unique identifier of the document.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
  }

  /**
   * Gets the metadata.
   *
   * Metadata of the document.
   *
   * @return the metadata
   */
  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  /**
   * Gets the collectionId.
   *
   * The collection ID of the collection containing the document for this result.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return this.collectionId;
  }

  /**
   * Gets the resultMetadata.
   *
   * Metadata of a query result.
   *
   * @return the resultMetadata
   */
  public QueryResultMetadata getResultMetadata() {
    return this.resultMetadata;
  }

  /**
   * Gets the code.
   *
   * The internal status code returned by the ingestion subsystem indicating the overall result of ingesting the source
   * document.
   *
   * @return the code
   */
  public Long getCode() {
    return this.code;
  }

  /**
   * Gets the filename.
   *
   * Name of the original source file (if available).
   *
   * @return the filename
   */
  public String getFilename() {
    return this.filename;
  }

  /**
   * Gets the fileType.
   *
   * The type of the original source file.
   *
   * @return the fileType
   */
  public String getFileType() {
    return this.fileType;
  }

  /**
   * Gets the sha1.
   *
   * The SHA-1 hash of the original source file (formatted as a hexadecimal string).
   *
   * @return the sha1
   */
  public String getSha1() {
    return this.sha1;
  }

  /**
   * Gets the notices.
   *
   * Array of notices for the document.
   *
   * @return the notices
   */
  public List<Notice> getNotices() {
    return this.notices;
  }
}
