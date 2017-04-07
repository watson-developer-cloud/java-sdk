/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

package com.ibm.watson.developer_cloud.discovery.v1.model.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Request to update a {@link Document}.
 */
public class UpdateDocumentRequest extends GenericModel {
    private final String environmentId;
    private final String collectionId;
    private final String documentId;
    private String configurationId;
    private JsonObject metadata;
    private InputStream file;
    private String mediaType;
    //TODO add configuration

    private UpdateDocumentRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.collectionId = builder.collectionId;
        this.documentId = builder.documentId;
        this.configurationId = builder.configurationId;
        this.metadata = builder.metadata;
        this.file = builder.file;
        this.mediaType = builder.mediaType;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public JsonObject getMetadata() {
        return metadata;
    }

    public InputStream getFile() {
        return file;
    }

    public String getMediaType() {
        return mediaType;
    }

    public static class Builder {
        private final String environmentId;
        private final String collectionId;
        private final String documentId;
        private String configurationId;
        private JsonObject metadata;
        private InputStream file;
        private String mediaType;

        public Builder(String environmentId, String collectionId, String documentId) {
            this.environmentId = environmentId;
            this.collectionId = collectionId;
            this.documentId = documentId;
        }

        public Builder configurationId(String configurationId) {
            this.configurationId = configurationId;
            return this;
        }

        public Builder metadata(JsonObject metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder inputStream(InputStream file, String mediaType) {
            this.file = file;
            this.mediaType = mediaType;
            return this;
        }

        public Builder file(File inputFile, String mediaType) {
            InputStream file;
            try {
                file = new FileInputStream(inputFile);
                this.mediaType = mediaType;
            } catch (FileNotFoundException e) {
                file = null;
            }
            this.file = file;
            return this;
        }

        public UpdateDocumentRequest build() {
            return new UpdateDocumentRequest(this);
        }
    }
}
