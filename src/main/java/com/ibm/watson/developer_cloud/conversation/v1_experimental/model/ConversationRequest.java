package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class ConversationRequest extends GenericModel {
  private Map<String, Object> context;
  @SerializedName("input") private JsonObject rawInput;

  public static class Input {
    private String text;

    public Input(String text) {
      this.text = text;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }
  }

  private transient Input input;

  public ConversationRequest(String text, Map<String, Object> context) {
    this.input = new Input(text);
    convertInputToJson(this.input);
    this.context = context;
  }

  private final void convertInputToJson(Input input) {
    if (input == null) {
      this.rawInput = null;
      return;
    }
    this.rawInput = GsonSingleton.getGsonWithoutPrettyPrinting().toJsonTree(input, Input.class).getAsJsonObject();
  }

  private final void convertJsonToInput(JsonObject object) {
    if (object == null) {
      this.input = null;
      return;
    }
    this.input = GsonSingleton.getGsonWithoutPrettyPrinting().fromJson(object, Input.class);
  }

  public Map<String, Object> getContext() {
    return context;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

  public JsonObject getRawInput() {
    return rawInput;
  }

  public void setRawInput(JsonObject rawInput) {
    this.rawInput = rawInput;
    convertJsonToInput(this.rawInput);
  }

  public Input getInput() {
    return input;
  }

  public void setInput(Input input) {
    this.input = input;
  }

}
