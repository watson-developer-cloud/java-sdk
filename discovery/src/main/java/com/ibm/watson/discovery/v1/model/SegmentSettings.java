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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A list of Document Segmentation settings.
 */
public class SegmentSettings extends GenericModel {

  private Boolean enabled;
  @SerializedName("selector_tags")
  private List<String> selectorTags;
  @SerializedName("annotated_fields")
  private List<String> annotatedFields;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private List<String> selectorTags;
    private List<String> annotatedFields;

    private Builder(SegmentSettings segmentSettings) {
      this.enabled = segmentSettings.enabled;
      this.selectorTags = segmentSettings.selectorTags;
      this.annotatedFields = segmentSettings.annotatedFields;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SegmentSettings.
     *
     * @return the segmentSettings
     */
    public SegmentSettings build() {
      return new SegmentSettings(this);
    }

    /**
     * Adds an selectorTags to selectorTags.
     *
     * @param selectorTags the new selectorTags
     * @return the SegmentSettings builder
     */
    public Builder addSelectorTags(String selectorTags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(selectorTags,
          "selectorTags cannot be null");
      if (this.selectorTags == null) {
        this.selectorTags = new ArrayList<String>();
      }
      this.selectorTags.add(selectorTags);
      return this;
    }

    /**
     * Adds an annotatedFields to annotatedFields.
     *
     * @param annotatedFields the new annotatedFields
     * @return the SegmentSettings builder
     */
    public Builder addAnnotatedFields(String annotatedFields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(annotatedFields,
          "annotatedFields cannot be null");
      if (this.annotatedFields == null) {
        this.annotatedFields = new ArrayList<String>();
      }
      this.annotatedFields.add(annotatedFields);
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the SegmentSettings builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the selectorTags.
     * Existing selectorTags will be replaced.
     *
     * @param selectorTags the selectorTags
     * @return the SegmentSettings builder
     */
    public Builder selectorTags(List<String> selectorTags) {
      this.selectorTags = selectorTags;
      return this;
    }

    /**
     * Set the annotatedFields.
     * Existing annotatedFields will be replaced.
     *
     * @param annotatedFields the annotatedFields
     * @return the SegmentSettings builder
     */
    public Builder annotatedFields(List<String> annotatedFields) {
      this.annotatedFields = annotatedFields;
      return this;
    }
  }

  private SegmentSettings(Builder builder) {
    enabled = builder.enabled;
    selectorTags = builder.selectorTags;
    annotatedFields = builder.annotatedFields;
  }

  /**
   * New builder.
   *
   * @return a SegmentSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * Enables/disables the Document Segmentation feature.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the selectorTags.
   *
   * Defines the heading level that splits into document segments. Valid values are h1, h2, h3, h4, h5, h6. The content
   * of the header field that the segmentation splits at is used as the **title** field for that segmented result. Only
   * valid if used with a collection that has **enabled** set to `false` in the **smart_document_understanding** object.
   *
   * @return the selectorTags
   */
  public List<String> selectorTags() {
    return selectorTags;
  }

  /**
   * Gets the annotatedFields.
   *
   * Defines the annotated smart document understanding fields that the document is split on. The content of the
   * annotated field that the segmentation splits at is used as the **title** field for that segmented result. For
   * example, if the field `sub-title` is specified, when a document is uploaded each time the smart documement
   * understanding conversion encounters a field of type `sub-title` the document is split at that point and the content
   * of the field used as the title of the remaining content. Thnis split is performed for all instances of the listed
   * fields in the uploaded document. Only valid if used with a collection that has **enabled** set to `true` in the
   * **smart_document_understanding** object.
   *
   * @return the annotatedFields
   */
  public List<String> annotatedFields() {
    return annotatedFields;
  }
}
