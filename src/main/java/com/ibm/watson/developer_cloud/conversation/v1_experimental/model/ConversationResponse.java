/* ***************************************************************** */
/*                                                                   */
/* IBM Confidential */
/* OCO Source Materials */
/*                                                                   */
/* (C) Copyright IBM Corp. 2015, 2016 */
/*                                                                   */
/* The source code for this program is not published or otherwise */
/* divested of its trade secrets, irrespective of what has been */
/* deposited with the U.S. Copyright Office. */
/*                                                                   */
/* ***************************************************************** */

package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Response for {@link Conversation#message(String, ConversationRequest)}.
 */
public class ConversationResponse extends GenericModel {

  public static class Entity extends GenericModel {
    private String entity;
    private int[] location;
    private String value;

    public String getEntity() {
      return entity;
    }

    public int[] getLocation() {
      return location;
    }

    public String getValue() {
      return value;
    }

    public void setEntity(String entity) {
      this.entity = entity;
    }

    public void setLocation(int[] location) {
      this.location = location;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  public static class Intent extends GenericModel {
    private float confidence;
    private String intent;

    public float getConfidence() {
      return confidence;
    }

    public String getIntent() {
      return intent;
    }

    public void setConfidence(float confidence) {
      this.confidence = confidence;
    }

    public void setIntent(String intent) {
      this.intent = intent;
    }
  }

  private Entity[] entities;
  private Intent[] intents;
  private Map<String, Object> output;
  private Map<String, Object> context;

  public Entity[] getEntities() {
    return entities;
  }

  public Intent[] getIntents() {
    return intents;
  }

  /**
   * @return 'output' field from response.
   */
  public Map<String, Object> getOutput() {
    return output;
  }

  /**
   * @return 'state' field from response.
   */
  public Map<String, Object> getContext() {
    return context;
  }

  public void setEntities(Entity[] entities) {
    this.entities = entities;
  }

  public void setIntents(Intent[] intents) {
    this.intents = intents;
  }

  public void setOutput(Map<String, Object> output) {
    this.output = output;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
  }
}
