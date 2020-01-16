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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Cells that are not table header, column header, or row header cells.
 */
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
  protected List<TableRowHeaderIds> rowHeaderIds;
  @SerializedName("row_header_texts")
  protected List<TableRowHeaderTexts> rowHeaderTexts;
  @SerializedName("row_header_texts_normalized")
  protected List<TableRowHeaderTextsNormalized> rowHeaderTextsNormalized;
  @SerializedName("column_header_ids")
  protected List<TableColumnHeaderIds> columnHeaderIds;
  @SerializedName("column_header_texts")
  protected List<TableColumnHeaderTexts> columnHeaderTexts;
  @SerializedName("column_header_texts_normalized")
  protected List<TableColumnHeaderTextsNormalized> columnHeaderTextsNormalized;
  protected List<DocumentAttribute> attributes;

  /**
   * Gets the cellId.
   *
   * The unique ID of the cell in the current table.
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
  public TableElementLocation getLocation() {
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
   * A list of table row header ids.
   *
   * @return the rowHeaderIds
   */
  public List<TableRowHeaderIds> getRowHeaderIds() {
    return rowHeaderIds;
  }

  /**
   * Gets the rowHeaderTexts.
   *
   * A list of table row header texts.
   *
   * @return the rowHeaderTexts
   */
  public List<TableRowHeaderTexts> getRowHeaderTexts() {
    return rowHeaderTexts;
  }

  /**
   * Gets the rowHeaderTextsNormalized.
   *
   * A list of table row header texts normalized.
   *
   * @return the rowHeaderTextsNormalized
   */
  public List<TableRowHeaderTextsNormalized> getRowHeaderTextsNormalized() {
    return rowHeaderTextsNormalized;
  }

  /**
   * Gets the columnHeaderIds.
   *
   * A list of table column header ids.
   *
   * @return the columnHeaderIds
   */
  public List<TableColumnHeaderIds> getColumnHeaderIds() {
    return columnHeaderIds;
  }

  /**
   * Gets the columnHeaderTexts.
   *
   * A list of table column header texts.
   *
   * @return the columnHeaderTexts
   */
  public List<TableColumnHeaderTexts> getColumnHeaderTexts() {
    return columnHeaderTexts;
  }

  /**
   * Gets the columnHeaderTextsNormalized.
   *
   * A list of table column header texts normalized.
   *
   * @return the columnHeaderTextsNormalized
   */
  public List<TableColumnHeaderTextsNormalized> getColumnHeaderTextsNormalized() {
    return columnHeaderTextsNormalized;
  }

  /**
   * Gets the attributes.
   *
   * A list of document attributes.
   *
   * @return the attributes
   */
  public List<DocumentAttribute> getAttributes() {
    return attributes;
  }
}
