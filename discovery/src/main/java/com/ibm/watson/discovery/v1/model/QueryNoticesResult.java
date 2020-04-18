/*
 * (C) Copyright IBM Corp. 2017, 2020.
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
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.List;
import java.util.Map;

/** Query result object. */
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

  @SerializedName("id")
  protected String id;

  @SerializedName("metadata")
  protected Map<String, Object> metadata;

  @SerializedName("collection_id")
  protected String collectionId;

  @SerializedName("result_metadata")
  protected QueryResultMetadata resultMetadata;

  @SerializedName("code")
  protected Long code;

  @SerializedName("filename")
  protected String filename;

  @SerializedName("file_type")
  protected String fileType;

  @SerializedName("sha1")
  protected String sha1;

  @SerializedName("notices")
  protected List<Notice> notices;

  public QueryNoticesResult() {
    super(new TypeToken<Object>() {});
  }

  /**
   * Gets the id.
   *
   * <p>The unique identifier of the document.
   *
   * @return the id
   */
  public String getId() {
    return this.id;
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
   * Gets the collectionId.
   *
   * <p>The collection ID of the collection containing the document for this result.
   *
   * @return the collectionId
   */
  public String getCollectionId() {
    return this.collectionId;
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
