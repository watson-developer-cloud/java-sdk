package com.ibm.watson.developer_cloud.conversation.v1_experimental.model;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class MessageRequest extends GenericModel {
  private Map<String, Object> context;
  private Map<String, Object> input;
  
  public static class Builder{
    private String text;
    private Map<String, Object> input;
    private Map<String, Object> context;
    public Builder(){}
    
    public Builder(String text, Map<String, Object> context){
      this.text = text;
      if(context != null)
        this.context = new HashMap<>(context);
    }
    
    public Builder setText(String text){
      this.text = text;
      return this;
    }
    
    public Builder setContext(Map<String, Object> context){
      if(context != null)
        this.context = new HashMap<>(context);
      else
        this.context = null;
      return this;
    }
    
    public Builder setInput(Map<String, Object> input){
      if(input != null)
        this.input = new HashMap<>(input);
      else{
        this.input = null;
      }
      return this;
    }
    
    public MessageRequest build(){
      MessageRequest request = new MessageRequest(this.text, this.context);
      if(this.input != null){
        request.setInput(this.input);
      }
      return request;
    }
  }

  private MessageRequest(String text, Map<String, Object> context) {
    this.context = context;
    if (text != null)
      this.setText(text);
  }

  public Map<String, Object> getContext() {
    return context;
  }

  public Map<String, Object> getInput() {
    return input;
  }

  public void setContext(Map<String, Object> context) {
    this.context = context;
  }

  public void setInput(Map<String, Object> input) {
    this.input = input;
  }

  public void setText(String text) {
    if (this.input == null) {
      this.input = new HashMap<>();
    }
    if(text == null){
      this.input.remove("text");
      return;
    }
    this.input.put("text", text);
  }
  
  public String getText(){
    if(this.input != null){
      return (String)this.input.get("text");
    }
    return null;
  }
}
