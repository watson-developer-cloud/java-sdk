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
package com.ibm.watson.visual_recognition.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Training status information for the collection.
 */
public class TrainingStatus extends GenericModel {

  protected ObjectTrainingStatus objects;

  /**
   * Builder.
   */
  public static class Builder {
    private ObjectTrainingStatus objects;

    private Builder(TrainingStatus trainingStatus) {
      this.objects = trainingStatus.objects;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param objects the objects
     */
    public Builder(ObjectTrainingStatus objects) {
      this.objects = objects;
    }

    /**
     * Builds a TrainingStatus.
     *
     * @return the trainingStatus
     */
    public TrainingStatus build() {
      return new TrainingStatus(this);
    }

    /**
     * Set the objects.
     *
     * @param objects the objects
     * @return the TrainingStatus builder
     */
    public Builder objects(ObjectTrainingStatus objects) {
      this.objects = objects;
      return this;
    }
  }

  protected TrainingStatus(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.objects,
        "objects cannot be null");
    objects = builder.objects;
  }

  /**
   * New builder.
   *
   * @return a TrainingStatus builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the objects.
   *
   * Training status for the objects in the collection.
   *
   * @return the objects
   */
  public ObjectTrainingStatus objects() {
    return objects;
  }
}
