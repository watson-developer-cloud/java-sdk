/*
 * (C) Copyright IBM Corp. 2023.
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
import java.util.Map;

/** The contents of the current table's header. */
public class TableHeaders extends GenericModel {

  @SerializedName("cell_id")
  protected String cellId;

  protected Map<String, Object> location;
  protected String text;

  @SerializedName("row_index_begin")
  protected Long rowIndexBegin;

  @SerializedName("row_index_end")
  protected Long rowIndexEnd;

  @SerializedName("column_index_begin")
  protected Long columnIndexBegin;

  @SerializedName("column_index_end")
  protected Long columnIndexEnd;

  protected TableHeaders() {}

  /**
   * Gets the cellId.
   *
   * <p>The unique ID of the cell in the current table.
   *
   * @return the cellId
   */
  public String getCellId() {
    return cellId;
  }

  /**
   * Gets the location.
   *
   * <p>The location of the table header cell in the current table as defined by its `begin` and
   * `end` offsets, respectfully, in the input document.
   *
   * @return the location
   */
  public Map<String, Object> getLocation() {
    return location;
  }

  /**
   * Gets the text.
   *
   * <p>The textual contents of the cell from the input document without associated markup content.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the rowIndexBegin.
   *
   * <p>The `begin` index of this cell's `row` location in the current table.
   *
   * @return the rowIndexBegin
   */
  public Long getRowIndexBegin() {
    return rowIndexBegin;
  }

  /**
   * Gets the rowIndexEnd.
   *
   * <p>The `end` index of this cell's `row` location in the current table.
   *
   * @return the rowIndexEnd
   */
  public Long getRowIndexEnd() {
    return rowIndexEnd;
  }

  /**
   * Gets the columnIndexBegin.
   *
   * <p>The `begin` index of this cell's `column` location in the current table.
   *
   * @return the columnIndexBegin
   */
  public Long getColumnIndexBegin() {
    return columnIndexBegin;
  }

  /**
   * Gets the columnIndexEnd.
   *
   * <p>The `end` index of this cell's `column` location in the current table.
   *
   * @return the columnIndexEnd
   */
  public Long getColumnIndexEnd() {
    return columnIndexEnd;
  }
}
