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

/** Full table object retrieved from Table Understanding Enrichment. */
public class TableResultTable extends GenericModel {

  protected TableElementLocation location;
  protected String text;

  @SerializedName("section_title")
  protected TableTextLocation sectionTitle;

  protected TableTextLocation title;

  @SerializedName("table_headers")
  protected List<TableHeaders> tableHeaders;

  @SerializedName("row_headers")
  protected List<TableRowHeaders> rowHeaders;

  @SerializedName("column_headers")
  protected List<TableColumnHeaders> columnHeaders;

  @SerializedName("key_value_pairs")
  protected List<TableKeyValuePairs> keyValuePairs;

  @SerializedName("body_cells")
  protected List<TableBodyCells> bodyCells;

  protected List<TableTextLocation> contexts;

  protected TableResultTable() {}

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
   * <p>The textual contents of the current table from the input document without associated markup
   * content.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the sectionTitle.
   *
   * <p>Text and associated location within a table.
   *
   * @return the sectionTitle
   */
  public TableTextLocation getSectionTitle() {
    return sectionTitle;
  }

  /**
   * Gets the title.
   *
   * <p>Text and associated location within a table.
   *
   * @return the title
   */
  public TableTextLocation getTitle() {
    return title;
  }

  /**
   * Gets the tableHeaders.
   *
   * <p>An array of table-level cells that apply as headers to all the other cells in the current
   * table.
   *
   * @return the tableHeaders
   */
  public List<TableHeaders> getTableHeaders() {
    return tableHeaders;
  }

  /**
   * Gets the rowHeaders.
   *
   * <p>An array of row-level cells, each applicable as a header to other cells in the same row as
   * itself, of the current table.
   *
   * @return the rowHeaders
   */
  public List<TableRowHeaders> getRowHeaders() {
    return rowHeaders;
  }

  /**
   * Gets the columnHeaders.
   *
   * <p>An array of column-level cells, each applicable as a header to other cells in the same
   * column as itself, of the current table.
   *
   * @return the columnHeaders
   */
  public List<TableColumnHeaders> getColumnHeaders() {
    return columnHeaders;
  }

  /**
   * Gets the keyValuePairs.
   *
   * <p>An array of key-value pairs identified in the current table.
   *
   * @return the keyValuePairs
   */
  public List<TableKeyValuePairs> getKeyValuePairs() {
    return keyValuePairs;
  }

  /**
   * Gets the bodyCells.
   *
   * <p>An array of cells that are neither table header nor column header nor row header cells, of
   * the current table with corresponding row and column header associations.
   *
   * @return the bodyCells
   */
  public List<TableBodyCells> getBodyCells() {
    return bodyCells;
  }

  /**
   * Gets the contexts.
   *
   * <p>An array of lists of textual entries across the document related to the current table being
   * parsed.
   *
   * @return the contexts
   */
  public List<TableTextLocation> getContexts() {
    return contexts;
  }
}
