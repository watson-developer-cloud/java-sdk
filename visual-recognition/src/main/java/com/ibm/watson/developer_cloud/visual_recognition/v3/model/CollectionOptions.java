package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.io.File;
import java.util.List;

import com.ibm.watson.developer_cloud.util.Validator;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.CollectionOptions.Builder;

public class CollectionOptions {
	private String collectionId;
	private String collectionName;
	private File image;
	private List<File> uploadImages;

	public String collectionName() {
		return collectionName;
	}

	public static class Builder {
		private String collectionId;
		private String collectionName;
		private File image;
		private List<File> uploadImages;

		private Builder(CollectionOptions options){
			this();
			collectionId = options.collectionId;
			collectionName = options.collectionName;
			image = options.image;
			uploadImages = options.uploadImages;
		}

		public Builder() {
			
		}

		public CollectionOptions build() {
			return new CollectionOptions(this);
		}

		public Builder collectionName(String collectionName) {
			Validator.notNull(collectionName, "'collectionName' cannot be null");
			this.collectionName = collectionName;
			return this;
		}

		public Builder image(File image) {
			this.image = image;
			return this;
		}

		public Builder collectionId(String collectionId) {
			this.collectionId = collectionId;
			return this;
		}

		public Builder images(List<File> uploadImages) {
			this.uploadImages = uploadImages;
			return this;
		}
	}

	public CollectionOptions(Builder builder) {
		this.collectionId = builder.collectionId;
		this.collectionName = builder.collectionName;
		this.image = builder.image;
		this.uploadImages = builder.uploadImages;
	}

	public File image() {
		return this.image;
	}

	public List<File> uploadImages() {
		return this.uploadImages;
	}

	public String collectionId() {
		return this.collectionId;
	}
}
