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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** An object that describes the Smart Document Understanding model for a collection. */
public class CollectionDetailsSmartDocumentUnderstanding extends GenericModel {

  /**
   * Specifies the type of Smart Document Understanding (SDU) model that is enabled for the
   * collection. The following types of models are supported:
   *
   * <p>* `custom`: A user-trained model is applied.
   *
   * <p>* `pre_trained`: A pretrained model is applied. This type of model is applied automatically
   * to *Document Retrieval for Contracts* projects.
   *
   * <p>* `text_extraction`: An SDU model that extracts text and metadata from the content. This
   * model is enabled in collections by default regardless of the types of documents in the
   * collection (as long as the service plan supports SDU models).
   *
   * <p>You can apply user-trained or pretrained models to collections from the *Identify fields*
   * page of the product user interface. For more information, see [the product
   * documentation](/docs/discovery-data?topic=discovery-data-configuring-fields).
   */
  public interface Model {
    /** custom. */
    String CUSTOM = "custom";
    /** pre_trained. */
    String PRE_TRAINED = "pre_trained";
    /** text_extraction. */
    String TEXT_EXTRACTION = "text_extraction";
  }

  protected Boolean enabled;
  protected String model;

  /** Builder. */
  public static class Builder {
    private Boolean enabled;
    private String model;

    /**
     * Instantiates a new Builder from an existing CollectionDetailsSmartDocumentUnderstanding
     * instance.
     *
     * @param collectionDetailsSmartDocumentUnderstanding the instance to initialize the Builder
     *     with
     */
    private Builder(
        CollectionDetailsSmartDocumentUnderstanding collectionDetailsSmartDocumentUnderstanding) {
      this.enabled = collectionDetailsSmartDocumentUnderstanding.enabled;
      this.model = collectionDetailsSmartDocumentUnderstanding.model;
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Builds a CollectionDetailsSmartDocumentUnderstanding.
     *
     * @return the new CollectionDetailsSmartDocumentUnderstanding instance
     */
    public CollectionDetailsSmartDocumentUnderstanding build() {
      return new CollectionDetailsSmartDocumentUnderstanding(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the CollectionDetailsSmartDocumentUnderstanding builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the model.
     *
     * @param model the model
     * @return the CollectionDetailsSmartDocumentUnderstanding builder
     */
    public Builder model(String model) {
      this.model = model;
      return this;
    }
  }

  protected CollectionDetailsSmartDocumentUnderstanding() {}

  protected CollectionDetailsSmartDocumentUnderstanding(Builder builder) {
    enabled = builder.enabled;
    model = builder.model;
  }

  /**
   * New builder.
   *
   * @return a CollectionDetailsSmartDocumentUnderstanding builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * <p>When `true`, smart document understanding conversion is enabled for the collection.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the model.
   *
   * <p>Specifies the type of Smart Document Understanding (SDU) model that is enabled for the
   * collection. The following types of models are supported:
   *
   * <p>* `custom`: A user-trained model is applied.
   *
   * <p>* `pre_trained`: A pretrained model is applied. This type of model is applied automatically
   * to *Document Retrieval for Contracts* projects.
   *
   * <p>* `text_extraction`: An SDU model that extracts text and metadata from the content. This
   * model is enabled in collections by default regardless of the types of documents in the
   * collection (as long as the service plan supports SDU models).
   *
   * <p>You can apply user-trained or pretrained models to collections from the *Identify fields*
   * page of the product user interface. For more information, see [the product
   * documentation](/docs/discovery-data?topic=discovery-data-configuring-fields).
   *
   * @return the model
   */
  public String model() {
    return model;
  }
}
