package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class VisualCollection extends GenericModel {
	  @SerializedName("collection_id")
	  private String id;
	  private String name;
	  private Date created;
	  private int images;
	  private Status status;
	  private int capacity;

	  public enum Status {
	    @SerializedName("ready") AVAILABLE,
	    @SerializedName("failed") FAILED,
	    @SerializedName("Non Existent") NON_EXISTENT,
	    @SerializedName("unavailable") UNAVAILABLE
	  }

	  public Status getStatus() {
	    return status;
	  }

	  public void setStatus(Status status) {
	    this.status = status;
	  }

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

	  public Date getCreated() {
	    return created;
	  }

	  public void setCreated(Date created) {
	    this.created = created;
	  }

	  public int getImages() {
	    return images;
	  }

	  public void setImages(int images) {
	    this.images = images;
	  }

	  public int getCapacity() {
	    return capacity;
	  }

	  public void setCapacity(int capacity) {
	    this.capacity = capacity;
	  }
}
