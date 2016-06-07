package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.Map;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class ConversationResponse extends GenericModel {
  private transient JsonObject rawOutput;
  public static class Intent{
    private String intent;
    private float confidence;
    public String getIntent() {
      return intent;
    }
    public void setIntent(String intent) {
      this.intent = intent;
    }
    public float getConfidence() {
      return confidence;
    }
    public void setConfidence(float confidence) {
      this.confidence = confidence;
    }
  }
  
  public static class Entity{
    private String entity;
    private String value;
    private int[] location;
    public String getEntity() {
      return entity;
    }
    public void setEntity(String entity) {
      this.entity = entity;
    }
    public String getValue() {
      return value;
    }
    public void setValue(String value) {
      this.value = value;
    }
    public int[] getLocation() {
      return location;
    }
    public void setLocation(int[] location) {
      this.location = location;
    }
  }
  
  public static class Output{
    private String[] text;

    public String[] getText() {
      return text;
    }

    public void setText(String[] text) {
      this.text = text;
    }
  }
  
  private Intent[] intents;
  private Entity[] entities;
  private Output output;
  private Map<String, Object> context;

  public ConversationResponse() {
  }

  public JsonObject getRawOutput() {
    return rawOutput;
  }

  public void setRawOutput(JsonObject rawOutput) {
    this.rawOutput = rawOutput;
    convertJsonToOutput(this.rawOutput);
  }

  public Intent[] getIntents() {
    return intents;
  }

  public void setIntents(Intent[] intents) {
    this.intents = intents;
  }

  public Entity[] getEntities() {
    return entities;
  }

  public void setEntities(Entity[] entities) {
    this.entities = entities;
  }

  public Output getOutput() {
    return output;
  }

  public void setOutput(Output output) {
    this.output = output;
    convertOutputToJson(this.output);
  }
  
  private void convertOutputToJson(Output output){
    if(output == null){
      this.rawOutput = null;
      return;
    }
    this.rawOutput = GsonSingleton.getGsonWithoutPrettyPrinting().toJsonTree(output, Output.class).getAsJsonObject();
  }
  
  private void convertJsonToOutput(JsonObject json){
    if(json == null){
      this.output = null;
    }
    this.output = GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(json, Output.class);
  }

  public Map<String, Object> getContext() {
    return context;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

}
