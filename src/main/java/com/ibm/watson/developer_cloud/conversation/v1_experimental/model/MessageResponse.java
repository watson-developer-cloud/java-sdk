package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class MessageResponse extends GenericModel {
  public static class Entity{
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
  
  public static class Intent{
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
  
  private Map<String, Object> context;
  private Entity[] entities;
  private Intent[] intents;
  private Map<String, Object> output;

  public MessageResponse() {
  }

  public Map<String, Object> getContext() {
    return context;
  }

  public Entity[] getEntities() {
    return entities;
  }

  public Intent[] getIntents() {
    return intents;
  }

  public Map<String, Object> getOutput() {
    return output;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
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
  
  public String getText(){
    if(this.output != null && this.output.containsKey("text")){
      return (String) this.output.get("text");
    }
    return null;
  }
}
