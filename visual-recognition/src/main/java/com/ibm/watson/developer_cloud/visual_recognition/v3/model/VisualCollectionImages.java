package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

public class VisualCollectionImages extends GenericModel {
	/**
	 * VisualCollectionImages.
	 */
	@SerializedName("image_id")
	private String image_id;
	private Date created;
	private String image_file;
	public String getImage_id() {
		return image_id;
	}
	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getImage_file() {
		return image_file;
	}
	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}
}
