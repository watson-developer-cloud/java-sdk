/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Cells that are not table header, column header, or row header cells.
 */
public class BodyCells extends GenericModel {

  @SerializedName("cell_id")
  private String cellId;
  private Location location;
  private String text;
  @SerializedName("row_index_begin")
  private Long rowIndexBegin;
  @SerializedName("row_index_end")
  private Long rowIndexEnd;
  @SerializedName("column_index_begin")
  private Long columnIndexBegin;
  @SerializedName("column_index_end")
  private Long columnIndexEnd;
  @SerializedName("row_header_ids")
  private List<RowHeaderIds> rowHeaderIds;
  @SerializedName("row_header_texts")
  private List<RowHeaderTexts> rowHeaderTexts;
  @SerializedName("row_header_texts_normalized")
  private List<RowHeaderTextsNormalized> rowHeaderTextsNormalized;
  @SerializedName("column_header_ids")
  private List<ColumnHeaderIds> columnHeaderIds;
  @SerializedName("column_header_texts")
  private List<ColumnHeaderTexts> columnHeaderTexts;
  @SerializedName("column_header_texts_normalized")
  private List<ColumnHeaderTextsNormalized> columnHeaderTextsNormalized;

  /**
   * Gets the cellId.
   *
   * A string value in the format `columnHeader-x-y`, where `x` and `y` are the begin and end offsets of this column
   * header cell in the input document.
   *
   * @return the cellId
   */
  public String getCellId() {
    return cellId;
  }

  /**
   * Gets the location.
   *
   * The numeric location of the identified element in the document, represented with two integers labeled `begin` and
   * `end`.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Gets the text.
   *
   * The textual contents of this cell from the input document without associated markup content.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the rowIndexBegin.
   *
   * The `begin` index of this cell's `row` location in the current table.
   *
   * @return the rowIndexBegin
   */
  public Long getRowIndexBegin() {
    return rowIndexBegin;
  }

  /**
   * Gets the rowIndexEnd.
   *
   * The `end` index of this cell's `row` location in the current table.
   *
   * @return the rowIndexEnd
   */
  public Long getRowIndexEnd() {
    return rowIndexEnd;
  }

  /**
   * Gets the columnIndexBegin.
   *
   * The `begin` index of this cell's `column` location in the current table.
   *
   * @return the columnIndexBegin
   */
  public Long getColumnIndexBegin() {
    return columnIndexBegin;
  }

  /**
   * Gets the columnIndexEnd.
   *
   * The `end` index of this cell's `column` location in the current table.
   *
   * @return the columnIndexEnd
   */
  public Long getColumnIndexEnd() {
    return columnIndexEnd;
  }

  /**
   * Gets the rowHeaderIds.
   *
   * @return the rowHeaderIds
   */
  public List<RowHeaderIds> getRowHeaderIds() {
    return rowHeaderIds;
  }

  /**
   * Gets the rowHeaderTexts.
   *
   * @return the rowHeaderTexts
   */
  public List<RowHeaderTexts> getRowHeaderTexts() {
    return rowHeaderTexts;
  }

  /**
   * Gets the rowHeaderTextsNormalized.
   *
   * @return the rowHeaderTextsNormalized
   */
  public List<RowHeaderTextsNormalized> getRowHeaderTextsNormalized() {
    return rowHeaderTextsNormalized;
  }

  /**
   * Gets the columnHeaderIds.
   *
   * @return the columnHeaderIds
   */
  public List<ColumnHeaderIds> getColumnHeaderIds() {
    return columnHeaderIds;
  }

  /**
   * Gets the columnHeaderTexts.
   *
   * @return the columnHeaderTexts
   */
  public List<ColumnHeaderTexts> getColumnHeaderTexts() {
    return columnHeaderTexts;
  }

  /**
   * Gets the columnHeaderTextsNormalized.
   *
   * @return the columnHeaderTextsNormalized
   */
  public List<ColumnHeaderTextsNormalized> getColumnHeaderTextsNormalized() {
    return columnHeaderTextsNormalized;
  }
}
