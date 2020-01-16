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
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Object containing normalization operations.
 */
public class NormalizationOperation extends GenericModel {

  /**
   * Identifies what type of operation to perform.
   *
   * **copy** - Copies the value of the **source_field** to the **destination_field** field. If the
   * **destination_field** already exists, then the value of the **source_field** overwrites the original value of the
   * **destination_field**.
   *
   * **move** - Renames (moves) the **source_field** to the **destination_field**. If the **destination_field** already
   * exists, then the value of the **source_field** overwrites the original value of the **destination_field**. Rename
   * is identical to copy, except that the **source_field** is removed after the value has been copied to the
   * **destination_field** (it is the same as a _copy_ followed by a _remove_).
   *
   * **merge** - Merges the value of the **source_field** with the value of the **destination_field**. The
   * **destination_field** is converted into an array if it is not already an array, and the value of the
   * **source_field** is appended to the array. This operation removes the **source_field** after the merge. If the
   * **source_field** does not exist in the current document, then the **destination_field** is still converted into an
   * array (if it is not an array already). This conversion ensures the type for **destination_field** is consistent
   * across all documents.
   *
   * **remove** - Deletes the **source_field** field. The **destination_field** is ignored for this operation.
   *
   * **remove_nulls** - Removes all nested null (blank) field values from the ingested document. **source_field** and
   * **destination_field** are ignored by this operation because _remove_nulls_ operates on the entire ingested
   * document. Typically, **remove_nulls** is invoked as the last normalization operation (if it is invoked at all, it
   * can be time-expensive).
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

  protected String operation;
  @SerializedName("source_field")
  protected String sourceField;
  @SerializedName("destination_field")
  protected String destinationField;

  /**
   * Builder.
   */
  public static class Builder {
    private String operation;
    private String sourceField;
    private String destinationField;

    private Builder(NormalizationOperation normalizationOperation) {
      this.operation = normalizationOperation.operation;
      this.sourceField = normalizationOperation.sourceField;
      this.destinationField = normalizationOperation.destinationField;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NormalizationOperation.
     *
     * @return the normalizationOperation
     */
    public NormalizationOperation build() {
      return new NormalizationOperation(this);
    }

    /**
     * Set the operation.
     *
     * @param operation the operation
     * @return the NormalizationOperation builder
     */
    public Builder operation(String operation) {
      this.operation = operation;
      return this;
    }

    /**
     * Set the sourceField.
     *
     * @param sourceField the sourceField
     * @return the NormalizationOperation builder
     */
    public Builder sourceField(String sourceField) {
      this.sourceField = sourceField;
      return this;
    }

    /**
     * Set the destinationField.
     *
     * @param destinationField the destinationField
     * @return the NormalizationOperation builder
     */
    public Builder destinationField(String destinationField) {
      this.destinationField = destinationField;
      return this;
    }
  }

  protected NormalizationOperation(Builder builder) {
    operation = builder.operation;
    sourceField = builder.sourceField;
    destinationField = builder.destinationField;
  }

  /**
   * New builder.
   *
   * @return a NormalizationOperation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the operation.
   *
   * Identifies what type of operation to perform.
   *
   * **copy** - Copies the value of the **source_field** to the **destination_field** field. If the
   * **destination_field** already exists, then the value of the **source_field** overwrites the original value of the
   * **destination_field**.
   *
   * **move** - Renames (moves) the **source_field** to the **destination_field**. If the **destination_field** already
   * exists, then the value of the **source_field** overwrites the original value of the **destination_field**. Rename
   * is identical to copy, except that the **source_field** is removed after the value has been copied to the
   * **destination_field** (it is the same as a _copy_ followed by a _remove_).
   *
   * **merge** - Merges the value of the **source_field** with the value of the **destination_field**. The
   * **destination_field** is converted into an array if it is not already an array, and the value of the
   * **source_field** is appended to the array. This operation removes the **source_field** after the merge. If the
   * **source_field** does not exist in the current document, then the **destination_field** is still converted into an
   * array (if it is not an array already). This conversion ensures the type for **destination_field** is consistent
   * across all documents.
   *
   * **remove** - Deletes the **source_field** field. The **destination_field** is ignored for this operation.
   *
   * **remove_nulls** - Removes all nested null (blank) field values from the ingested document. **source_field** and
   * **destination_field** are ignored by this operation because _remove_nulls_ operates on the entire ingested
   * document. Typically, **remove_nulls** is invoked as the last normalization operation (if it is invoked at all, it
   * can be time-expensive).
   *
   * @return the operation
   */
  public String operation() {
    return operation;
  }

  /**
   * Gets the sourceField.
   *
   * The source field for the operation.
   *
   * @return the sourceField
   */
  public String sourceField() {
    return sourceField;
  }

  /**
   * Gets the destinationField.
   *
   * The destination field for the operation.
   *
   * @return the destinationField
   */
  public String destinationField() {
    return destinationField;
  }
}
