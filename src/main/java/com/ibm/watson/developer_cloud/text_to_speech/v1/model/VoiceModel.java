package com.ibm.watson.developer_cloud.text_to_speech.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class VoiceModel extends GenericModel {
  
  @SerializedName("customization_id")
  private String id;
  
  private String name;
  
  private String description;
  
  private String language;
  
  private String owner;
  
  private Long created;
  
  @SerializedName("last_modified")
  private Long lastModified;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getOwner() {
    return owner;
  }

  public Long getCreated() {
    return created;
  }

  public Long getLastModified() {
    return lastModified;
  }

}
