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
 * The contents of the tables extracted from a document.
 */
public class Tables extends GenericModel {

  private Location location;
  private String text;
  @SerializedName("section_title")
  private SectionTitle sectionTitle;
  @SerializedName("table_headers")
  private List<TableHeaders> tableHeaders;
  @SerializedName("row_headers")
  private List<RowHeaders> rowHeaders;
  @SerializedName("column_headers")
  private List<ColumnHeaders> columnHeaders;
  @SerializedName("body_cells")
  private List<BodyCells> bodyCells;

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
   * The textual contents of the current table from the input document without associated markup content.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the sectionTitle.
   *
   * The table's section title, if identified.
   *
   * @return the sectionTitle
   */
  public SectionTitle getSectionTitle() {
    return sectionTitle;
  }

  /**
   * Gets the tableHeaders.
   *
   * An array of table-level cells that apply as headers to all the other cells in the current table.
   *
   * @return the tableHeaders
   */
  public List<TableHeaders> getTableHeaders() {
    return tableHeaders;
  }

  /**
   * Gets the rowHeaders.
   *
   * An array of row-level cells, each applicable as a header to other cells in the same row as itself, of the current
   * table.
   *
   * @return the rowHeaders
   */
  public List<RowHeaders> getRowHeaders() {
    return rowHeaders;
  }

  /**
   * Gets the columnHeaders.
   *
   * An array of column-level cells, each applicable as a header to other cells in the same column as itself, of the
   * current table.
   *
   * @return the columnHeaders
   */
  public List<ColumnHeaders> getColumnHeaders() {
    return columnHeaders;
  }

  /**
   * Gets the bodyCells.
   *
   * An array of cells that are neither table header nor column header nor row header cells, of the current table with
   * corresponding row and column header associations.
   *
   * @return the bodyCells
   */
  public List<BodyCells> getBodyCells() {
    return bodyCells;
  }
}
