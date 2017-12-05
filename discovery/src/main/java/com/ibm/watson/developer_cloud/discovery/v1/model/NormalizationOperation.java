/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.discovery.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * NormalizationOperation.
 */
public class NormalizationOperation extends GenericModel {

  /**
   * Identifies what type of operation to perform. **copy** - Copies the value of the `source_field` to the
   * `destination_field` field. If the `destination_field` already exists, then the value of the `source_field`
   * overwrites the original value of the `destination_field`. **move** - Renames (moves) the `source_field` to the
   * `destination_field`. If the `destination_field` already exists, then the value of the `source_field` overwrites the
   * original value of the `destination_field`. Rename is identical to copy, except that the `source_field` is removed
   * after the value has been copied to the `destination_field` (it is the same as a _copy_ followed by a _remove_).
   * **merge** - Merges the value of the `source_field` with the value of the `destination_field`. The
   * `destination_field` is converted into an array if it is not already an array, and the value of the `source_field`
   * is appended to the array. This operation removes the `source_field` after the merge. If the `source_field` does not
   * exist in the current document, then the `destination_field` is still converted into an array (if it is not an array
   * already). This is ensures the type for `destination_field` is consistent across all documents. **remove** - Deletes
   * the `source_field` field. The `destination_field` is ignored for this operation. **remove_nulls** - Removes all
   * nested null (blank) leif values from the JSON tree. `source_field` and `destination_field` are ignored by this
   * operation because _remove_nulls_ operates on the entire JSON tree. Typically, `remove_nulls` is invoked as the last
   * normalization operation (if it is inoked at all, it can be time-expensive).
   */
  public interface Operation {
    /** copy. */
    String COPY = "copy";
    /** move. */
    String MOVE = "move";
    /** merge. */
    String MERGE = "merge";
    /** remove. */
    String REMOVE = "remove";
    /** remove_nulls. */
    String REMOVE_NULLS = "remove_nulls";
  }

  private String operation;
  @SerializedName("source_field")
  private String sourceField;
  @SerializedName("destination_field")
  private String destinationField;

  /**
   * Gets the operation.
   *
   * Identifies what type of operation to perform. **copy** - Copies the value of the `source_field` to the
   * `destination_field` field. If the `destination_field` already exists, then the value of the `source_field`
   * overwrites the original value of the `destination_field`. **move** - Renames (moves) the `source_field` to the
   * `destination_field`. If the `destination_field` already exists, then the value of the `source_field` overwrites the
   * original value of the `destination_field`. Rename is identical to copy, except that the `source_field` is removed
   * after the value has been copied to the `destination_field` (it is the same as a _copy_ followed by a _remove_).
   * **merge** - Merges the value of the `source_field` with the value of the `destination_field`. The
   * `destination_field` is converted into an array if it is not already an array, and the value of the `source_field`
   * is appended to the array. This operation removes the `source_field` after the merge. If the `source_field` does not
   * exist in the current document, then the `destination_field` is still converted into an array (if it is not an array
   * already). This is ensures the type for `destination_field` is consistent across all documents. **remove** - Deletes
   * the `source_field` field. The `destination_field` is ignored for this operation. **remove_nulls** - Removes all
   * nested null (blank) leif values from the JSON tree. `source_field` and `destination_field` are ignored by this
   * operation because _remove_nulls_ operates on the entire JSON tree. Typically, `remove_nulls` is invoked as the last
   * normalization operation (if it is inoked at all, it can be time-expensive).
   *
   * @return the operation
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Gets the sourceField.
   *
   * The source field for the operation.
   *
   * @return the sourceField
   */
  public String getSourceField() {
    return sourceField;
  }

  /**
   * Gets the destinationField.
   *
   * The destination field for the operation.
   *
   * @return the destinationField
   */
  public String getDestinationField() {
    return destinationField;
  }

  /**
   * Sets the operation.
   *
   * @param operation the new operation
   */
  public void setOperation(final String operation) {
    this.operation = operation;
  }

  /**
   * Sets the sourceField.
   *
   * @param sourceField the new sourceField
   */
  public void setSourceField(final String sourceField) {
    this.sourceField = sourceField;
  }

  /**
   * Sets the destinationField.
   *
   * @param destinationField the new destinationField
   */
  public void setDestinationField(final String destinationField) {
    this.destinationField = destinationField;
  }
}
