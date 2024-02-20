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
package com.ibm.watson.assistant.v1.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ibm.cloud.sdk.core.service.model.DynamicModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An output object that includes the response to the user, the dialog nodes that were triggered,
 * and messages from the log.
 */
public class OutputData extends DynamicModel<Object> {

  @SerializedName("nodes_visited")
  protected List<String> nodesVisited;

  @SerializedName("nodes_visited_details")
  protected List<DialogNodeVisitedDetails> nodesVisitedDetails;

  @SerializedName("log_messages")
  protected List<LogMessage> logMessages;

  @SerializedName("generic")
  protected List<RuntimeResponseGeneric> generic;

  public OutputData() {
    super(new TypeToken<Object>() {});
  }

  /** Builder. */
  public static class Builder {
    private List<String> nodesVisited;
    private List<DialogNodeVisitedDetails> nodesVisitedDetails;
    private List<LogMessage> logMessages;
    private List<RuntimeResponseGeneric> generic;
    private Map<String, Object> dynamicProperties;

    /**
     * Instantiates a new Builder from an existing OutputData instance.
     *
     * @param outputData the instance to initialize the Builder with
     */
    private Builder(OutputData outputData) {
      this.nodesVisited = outputData.nodesVisited;
      this.nodesVisitedDetails = outputData.nodesVisitedDetails;
      this.logMessages = outputData.logMessages;
      this.generic = outputData.generic;
      this.dynamicProperties = outputData.getProperties();
    }

    /** Instantiates a new builder. */
    public Builder() {}

    /**
     * Instantiates a new builder with required properties.
     *
     * @param logMessages the logMessages
     */
    public Builder(List<LogMessage> logMessages) {
      this.logMessages = logMessages;
    }

    /**
     * Builds a OutputData.
     *
     * @return the new OutputData instance
     */
    public OutputData build() {
      return new OutputData(this);
    }

    /**
     * Adds a new element to nodesVisited.
     *
     * @param nodesVisited the new element to be added
     * @return the OutputData builder
     */
    public Builder addNodesVisited(String nodesVisited) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(nodesVisited, "nodesVisited cannot be null");
      if (this.nodesVisited == null) {
        this.nodesVisited = new ArrayList<String>();
      }
      this.nodesVisited.add(nodesVisited);
      return this;
    }

    /**
     * Adds a new element to nodesVisitedDetails.
     *
     * @param nodesVisitedDetails the new element to be added
     * @return the OutputData builder
     */
    public Builder addNodesVisitedDetails(DialogNodeVisitedDetails nodesVisitedDetails) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(
          nodesVisitedDetails, "nodesVisitedDetails cannot be null");
      if (this.nodesVisitedDetails == null) {
        this.nodesVisitedDetails = new ArrayList<DialogNodeVisitedDetails>();
      }
      this.nodesVisitedDetails.add(nodesVisitedDetails);
      return this;
    }

    /**
     * Adds a new element to logMessages.
     *
     * @param logMessages the new element to be added
     * @return the OutputData builder
     */
    public Builder addLogMessages(LogMessage logMessages) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(logMessages, "logMessages cannot be null");
      if (this.logMessages == null) {
        this.logMessages = new ArrayList<LogMessage>();
      }
      this.logMessages.add(logMessages);
      return this;
    }

    /**
     * Adds a new element to generic.
     *
     * @param generic the new element to be added
     * @return the OutputData builder
     */
    public Builder addGeneric(RuntimeResponseGeneric generic) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(generic, "generic cannot be null");
      if (this.generic == null) {
        this.generic = new ArrayList<RuntimeResponseGeneric>();
      }
      this.generic.add(generic);
      return this;
    }

    /**
     * Set the nodesVisited. Existing nodesVisited will be replaced.
     *
     * @param nodesVisited the nodesVisited
     * @return the OutputData builder
     */
    public Builder nodesVisited(List<String> nodesVisited) {
      this.nodesVisited = nodesVisited;
      return this;
    }

    /**
     * Set the nodesVisitedDetails. Existing nodesVisitedDetails will be replaced.
     *
     * @param nodesVisitedDetails the nodesVisitedDetails
     * @return the OutputData builder
     */
    public Builder nodesVisitedDetails(List<DialogNodeVisitedDetails> nodesVisitedDetails) {
      this.nodesVisitedDetails = nodesVisitedDetails;
      return this;
    }

    /**
     * Set the logMessages. Existing logMessages will be replaced.
     *
     * @param logMessages the logMessages
     * @return the OutputData builder
     */
    public Builder logMessages(List<LogMessage> logMessages) {
      this.logMessages = logMessages;
      return this;
    }

    /**
     * Set the generic. Existing generic will be replaced.
     *
     * @param generic the generic
     * @return the OutputData builder
     */
    public Builder generic(List<RuntimeResponseGeneric> generic) {
      this.generic = generic;
      return this;
    }

    /**
     * Add an arbitrary property.
     *
     * @param name the name of the property to add
     * @param value the value of the property to add
     * @return the OutputData builder
     */
    public Builder add(String name, Object value) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(name, "name cannot be null");
      if (this.dynamicProperties == null) {
        this.dynamicProperties = new HashMap<String, Object>();
      }
      this.dynamicProperties.put(name, value);
      return this;
    }
  }

  protected OutputData(Builder builder) {
    super(new TypeToken<Object>() {});
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        builder.logMessages, "logMessages cannot be null");
    nodesVisited = builder.nodesVisited;
    nodesVisitedDetails = builder.nodesVisitedDetails;
    logMessages = builder.logMessages;
    generic = builder.generic;
    this.setProperties(builder.dynamicProperties);
  }

  /**
   * New builder.
   *
   * @return a OutputData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the nodesVisited.
   *
   * <p>An array of the nodes that were triggered to create the response, in the order in which they
   * were visited. This information is useful for debugging and for tracing the path taken through
   * the node tree.
   *
   * @return the nodesVisited
   */
  public List<String> getNodesVisited() {
    return this.nodesVisited;
  }

  /**
   * Sets the nodesVisited.
   *
   * @param nodesVisited the new nodesVisited
   */
  public void setNodesVisited(final List<String> nodesVisited) {
    this.nodesVisited = nodesVisited;
  }

  /**
   * Gets the nodesVisitedDetails.
   *
   * <p>An array of objects containing detailed diagnostic information about the nodes that were
   * triggered during processing of the input message. Included only if **nodes_visited_details** is
   * set to `true` in the message request.
   *
   * @return the nodesVisitedDetails
   */
  public List<DialogNodeVisitedDetails> getNodesVisitedDetails() {
    return this.nodesVisitedDetails;
  }

  /**
   * Sets the nodesVisitedDetails.
   *
   * @param nodesVisitedDetails the new nodesVisitedDetails
   */
  public void setNodesVisitedDetails(final List<DialogNodeVisitedDetails> nodesVisitedDetails) {
    this.nodesVisitedDetails = nodesVisitedDetails;
  }

  /**
   * Gets the logMessages.
   *
   * <p>An array of up to 50 messages logged with the request.
   *
   * @return the logMessages
   */
  public List<LogMessage> getLogMessages() {
    return this.logMessages;
  }

  /**
   * Sets the logMessages.
   *
   * @param logMessages the new logMessages
   */
  public void setLogMessages(final List<LogMessage> logMessages) {
    this.logMessages = logMessages;
  }

  /**
   * Gets the generic.
   *
   * <p>Output intended for any channel. It is the responsibility of the client application to
   * implement the supported response types.
   *
   * @return the generic
   */
  public List<RuntimeResponseGeneric> getGeneric() {
    return this.generic;
  }

  /**
   * Sets the generic.
   *
   * @param generic the new generic
   */
  public void setGeneric(final List<RuntimeResponseGeneric> generic) {
    this.generic = generic;
  }
}
