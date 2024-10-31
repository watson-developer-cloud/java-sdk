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
import java.util.List;

/** Cells that are not table header, column header, or row header cells. */
public class TableBodyCells extends GenericModel {

  @SerializedName("cell_id")
  protected String cellId;

  protected TableElementLocation location;
  protected String text;

  @SerializedName("row_index_begin")
  protected Long rowIndexBegin;

  @SerializedName("row_index_end")
  protected Long rowIndexEnd;

  @SerializedName("column_index_begin")
  protected Long columnIndexBegin;

  @SerializedName("column_index_end")
  protected Long columnIndexEnd;

  @SerializedName("row_header_ids")
  protected List<String> rowHeaderIds;

  @SerializedName("row_header_texts")
  protected List<String> rowHeaderTexts;

  @SerializedName("row_header_texts_normalized")
  protected List<String> rowHeaderTextsNormalized;

  @SerializedName("column_header_ids")
  protected List<String> columnHeaderIds;

  @SerializedName("column_header_texts")
  protected List<String> columnHeaderTexts;

  @SerializedName("column_header_texts_normalized")
  protected List<String> columnHeaderTextsNormalized;

  protected List<DocumentAttribute> attributes;

  protected TableBodyCells() {}

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
   * <p>The numeric location of the identified element in the document, represented with two
   * integers labeled `begin` and `end`.
   *
   * @return the location
   */
  public TableElementLocation getLocation() {
    return location;
  }

  /**
   * Gets the text.
   *
   * <p>The textual contents of this cell from the input document without associated markup content.
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

  /**
   * Gets the rowHeaderIds.
   *
   * <p>A list of ID values that represent the table row headers that are associated with this body
   * cell.
   *
   * @return the rowHeaderIds
   */
  public List<String> getRowHeaderIds() {
    return rowHeaderIds;
  }

  /**
   * Gets the rowHeaderTexts.
   *
   * <p>A list of row header values that are associated with this body cell.
   *
   * @return the rowHeaderTexts
   */
  public List<String> getRowHeaderTexts() {
    return rowHeaderTexts;
  }

  /**
   * Gets the rowHeaderTextsNormalized.
   *
   * <p>A list of normalized row header values that are associated with this body cell.
   *
   * @return the rowHeaderTextsNormalized
   */
  public List<String> getRowHeaderTextsNormalized() {
    return rowHeaderTextsNormalized;
  }

  /**
   * Gets the columnHeaderIds.
   *
   * <p>A list of ID values that represent the column headers that are associated with this body
   * cell.
   *
   * @return the columnHeaderIds
   */
  public List<String> getColumnHeaderIds() {
    return columnHeaderIds;
  }

  /**
   * Gets the columnHeaderTexts.
   *
   * <p>A list of column header values that are associated with this body cell.
   *
   * @return the columnHeaderTexts
   */
  public List<String> getColumnHeaderTexts() {
    return columnHeaderTexts;
  }

  /**
   * Gets the columnHeaderTextsNormalized.
   *
   * <p>A list of normalized column header values that are associated with this body cell.
   *
   * @return the columnHeaderTextsNormalized
   */
  public List<String> getColumnHeaderTextsNormalized() {
    return columnHeaderTextsNormalized;
  }

  /**
   * Gets the attributes.
   *
   * <p>A list of document attributes.
   *
   * @return the attributes
   */
  public List<DocumentAttribute> getAttributes() {
    return attributes;
  }
}
