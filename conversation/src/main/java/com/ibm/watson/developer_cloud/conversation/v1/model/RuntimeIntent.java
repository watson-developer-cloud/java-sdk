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
package com.ibm.watson.developer_cloud.conversation.v1.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * An intent identified in the user input.
 */
public class RuntimeIntent extends DynamicModel {
  private Type intentType = new TypeToken<String>() {
  }.getType();
  private Type confidenceType = new TypeToken<Double>() {
  }.getType();

  /**
   * Builder.
   */
  public static class Builder {
    private String intent;
    private Double confidence;

    private Builder(RuntimeIntent runtimeIntent) {
      intent = runtimeIntent.intent;
      confidence = runtimeIntent.confidence;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param intent the intent
     * @param confidence the confidence
     */
    public Builder(String intent, Double confidence) {
      this.intent = intent;
      this.confidence = confidence;
    }

    /**
     * Builds a RuntimeIntent.
     *
     * @return the runtimeIntent
     */
    public RuntimeIntent build() {
      RuntimeIntent runtimeIntent = new RuntimeIntent();
      runtimeIntent.put("intent", this.intent);
      runtimeIntent.put("confidence", this.confidence);
      return runtimeIntent;
    }

    /**
     * Set the intent.
     *
     * @param intent the intent
     * @return the RuntimeIntent builder
     */
    public Builder intent(String intent) {
      this.intent = intent;
      return this;
    }

    /**
     * Set the confidence.
     *
     * @param confidence the confidence
     * @return the RuntimeIntent builder
     */
    public Builder confidence(Double confidence) {
      this.confidence = confidence;
      return this;
    }
  }

  private RuntimeIntent(Builder builder) {
    Validator.notNull(builder.intent, "intent cannot be null");
    Validator.notNull(builder.confidence, "confidence cannot be null");
    intent = builder.intent;
    confidence = builder.confidence;
  }

  /**
   * New builder.
   *
   * @return a RuntimeIntent builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the intent.
   *
   * @return the intent
   */
  public String intent() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("intent"), intentType);
  }

  /**
   * Gets the confidence.
   *
   * @return the confidence
   */
  public Double confidence() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("confidence"), confidenceType);
  }
}
