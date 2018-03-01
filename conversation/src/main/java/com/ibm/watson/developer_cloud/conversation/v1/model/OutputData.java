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
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.service.model.DynamicModel;
import com.ibm.watson.developer_cloud.util.GsonSerializationHelper;

/**
 * An output object that includes the response to the user, the nodes that were hit, and messages from the log.
 */
public class OutputData extends DynamicModel {
  private Type logMessagesType = new TypeToken<List<LogMessage>>() {
  }.getType();
  private Type textType = new TypeToken<List<String>>() {
  }.getType();
  private Type nodesVisitedType = new TypeToken<List<String>>() {
  }.getType();
  private Type nodesVisitedDetailsType = new TypeToken<List<DialogNodeVisitedDetails>>() {
  }.getType();

  /**
   * Builder.
   */
  public static class Builder {
    private List<LogMessage> logMessages;
    private List<String> text;
    private List<String> nodesVisited;
    private List<DialogNodeVisitedDetails> nodesVisitedDetails;

    private Builder(OutputData outputData) {
      logMessages = outputData.logMessages;
      text = outputData.text;
      nodesVisited = outputData.nodesVisited;
      nodesVisitedDetails = outputData.nodesVisitedDetails;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param logMessages the logMessages
     * @param text the text
     */
    public Builder(List<LogMessage> logMessages, List<String> text) {
      this.logMessages = logMessages;
      this.text = text;
    }

    /**
     * Builds a OutputData.
     *
     * @return the outputData
     */
    public OutputData build() {
      OutputData outputData = new OutputData();
      outputData.put("log_messages", this.logMessages);
      outputData.put("text", this.text);
      outputData.put("nodes_visited", this.nodesVisited);
      outputData.put("nodes_visited_details", this.nodesVisitedDetails);
      return outputData;
    }

    /**
     * Adds an logMessages to logMessages.
     *
     * @param logMessages the new logMessages
     * @return the OutputData builder
     */
    public Builder addLogMessages(LogMessage logMessages) {
      Validator.notNull(logMessages, "logMessages cannot be null");
      if (this.logMessages == null) {
        this.logMessages = new ArrayList<LogMessage>();
      }
      this.logMessages.add(logMessages);
      return this;
    }

    /**
     * Adds an text to text.
     *
     * @param text the new text
     * @return the OutputData builder
     */
    public Builder addText(String text) {
      Validator.notNull(text, "text cannot be null");
      if (this.text == null) {
        this.text = new ArrayList<String>();
      }
      this.text.add(text);
      return this;
    }

    /**
     * Adds an nodesVisited to nodesVisited.
     *
     * @param nodesVisited the new nodesVisited
     * @return the OutputData builder
     */
    public Builder addNodesVisited(String nodesVisited) {
      Validator.notNull(nodesVisited, "nodesVisited cannot be null");
      if (this.nodesVisited == null) {
        this.nodesVisited = new ArrayList<String>();
      }
      this.nodesVisited.add(nodesVisited);
      return this;
    }

    /**
     * Adds an nodesVisitedDetails to nodesVisitedDetails.
     *
     * @param nodesVisitedDetails the new nodesVisitedDetails
     * @return the OutputData builder
     */
    public Builder addNodesVisitedDetails(DialogNodeVisitedDetails nodesVisitedDetails) {
      Validator.notNull(nodesVisitedDetails, "nodesVisitedDetails cannot be null");
      if (this.nodesVisitedDetails == null) {
        this.nodesVisitedDetails = new ArrayList<DialogNodeVisitedDetails>();
      }
      this.nodesVisitedDetails.add(nodesVisitedDetails);
      return this;
    }

    /**
     * Set the logMessages.
     * Existing logMessages will be replaced.
     *
     * @param logMessages the logMessages
     * @return the OutputData builder
     */
    public Builder logMessages(List<LogMessage> logMessages) {
      this.logMessages = logMessages;
      return this;
    }

    /**
     * Set the text.
     * Existing text will be replaced.
     *
     * @param text the text
     * @return the OutputData builder
     */
    public Builder text(List<String> text) {
      this.text = text;
      return this;
    }

    /**
     * Set the nodesVisited.
     * Existing nodesVisited will be replaced.
     *
     * @param nodesVisited the nodesVisited
     * @return the OutputData builder
     */
    public Builder nodesVisited(List<String> nodesVisited) {
      this.nodesVisited = nodesVisited;
      return this;
    }

    /**
     * Set the nodesVisitedDetails.
     * Existing nodesVisitedDetails will be replaced.
     *
     * @param nodesVisitedDetails the nodesVisitedDetails
     * @return the OutputData builder
     */
    public Builder nodesVisitedDetails(List<DialogNodeVisitedDetails> nodesVisitedDetails) {
      this.nodesVisitedDetails = nodesVisitedDetails;
      return this;
    }
  }

  private OutputData(Builder builder) {
    Validator.notNull(builder.logMessages, "logMessages cannot be null");
    Validator.notNull(builder.text, "text cannot be null");
    logMessages = builder.logMessages;
    text = builder.text;
    nodesVisited = builder.nodesVisited;
    nodesVisitedDetails = builder.nodesVisitedDetails;
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
   * Gets the logMessages.
   *
   * @return the logMessages
   */
  public List<LogMessage> logMessages() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("log_messages"), logMessagesType);
  }

  /**
   * Gets the text.
   *
   * @return the text
   */
  public List<String> text() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("text"), textType);
  }

  /**
   * Gets the nodesVisited.
   *
   * @return the nodesVisited
   */
  public List<String> nodesVisited() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nodes_visited"), nodesVisitedType);
  }

  /**
   * Gets the nodesVisitedDetails.
   *
   * @return the nodesVisitedDetails
   */
  public List<DialogNodeVisitedDetails> nodesVisitedDetails() {
    return GsonSerializationHelper.serializeDynamicModelProperty(this.get("nodes_visited_details"),
        nodesVisitedDetailsType);
  }
}
