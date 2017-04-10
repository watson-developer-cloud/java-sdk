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
 * Request to create a {@link Document}.
 */
public class CreateDocumentRequest extends GenericModel {
    private final String environmentId;
    private final String collectionId;
    private String configurationId;
    private String documentId;
    private JsonObject metadata;
    private InputStream file;
    private String mediaType;
    private String fileName;
    //TODO add configuration

    protected CreateDocumentRequest(Builder builder) {
        this.environmentId = builder.environmentId;
        this.collectionId = builder.collectionId;
        this.configurationId = builder.configurationId;
        this.documentId = builder.documentId;
        this.metadata = builder.metadata;
        this.file = builder.file;
        this.mediaType = builder.mediaType;
        this.fileName = builder.fileName;
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

    public String getFileName() {
        return fileName;
    }

    public static class Builder {
        private final String environmentId;
        private final String collectionId;
        private String configurationId;
        private String documentId;
        private JsonObject metadata;
        private InputStream file;
        private String mediaType;
        private String fileName;

        public Builder(String environmentId, String collectionId) {
            this.environmentId = environmentId;
            this.collectionId = collectionId;
            this.fileName = this.fileName == null || this.fileName.isEmpty() ? "file_name_not_provided" : this.fileName;
        }

        public Builder documentId(String documentId) {
            this.documentId = documentId;
            return this;
        }

        public Builder configurationId(String configurationId) {
            this.configurationId = configurationId;
            return this;
        }

        public Builder metadata(JsonObject metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * @deprecated
         * Use instead file(InputStream content, String mediaType)
         *
         * @param file An input stream of bytes
         * @param mediaType The media type
         * @return A document builder
         */
        @Deprecated
        public Builder inputStream(InputStream file, String mediaType) {
            this.file = file;
            this.mediaType = mediaType;
            return this;
        }

        public Builder file(InputStream content) {
            this.file = content;
            return this;
        }

        public Builder file(InputStream content, String mediaType) {
            this.file = content;
            this.mediaType = mediaType;
            return this;
        }

        /**
         * Create a document builder with an input stream, file name, and media type.
         *
         * @param content An input stream of bytes
         * @param fileName The file name
         * @param mediaType The media type. If the media type is unknown then use null or empty string.
         * @return A document builder
         */
        public Builder file(InputStream content, String fileName, String mediaType) {
            this.file = content;
            this.mediaType = mediaType;
            this.fileName = fileName;
            return this;
        }

        public Builder file(File inputFile, String mediaType) {
            InputStream file;
            try {
                file = new FileInputStream(inputFile);
                this.mediaType = mediaType;
                this.fileName = inputFile.getName();
            } catch (FileNotFoundException e) {
                file = null;
            }
            this.file = file;
            return this;
        }

        public Builder file(File inputFile) {
            InputStream file;
            try {
                file = new FileInputStream(inputFile);
                this.fileName = inputFile.getName();
            } catch (FileNotFoundException e) {
                file = null;
            }
            this.file = file;
            return this;
        }

        public CreateDocumentRequest build() {
            return new CreateDocumentRequest(this);
        }
    }
}
