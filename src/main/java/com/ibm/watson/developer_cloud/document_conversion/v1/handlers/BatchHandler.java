/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1.handlers;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Batch;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchDocument;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.List;

public class BatchHandler {
    private DocumentConversion docConversionService;

    public BatchHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    public Batch createBatch() {
        JsonObject contentJson = new JsonObject();

        HttpRequestBase request = Request.Post("/v1/batches")
                .withContent(contentJson).build();

        try {
            HttpResponse response = docConversionService.execute(request);
            String batchAsJson = ResponseUtil.getString(response);
            Batch batch = GsonSingleton.getGson().fromJson(batchAsJson, Batch.class);
            return batch;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateBatch(String batchId) {
    }

    public List<Batch> getBatches() {
        return null;
    }

    public Batch getBatch(String batchId) {
        return null;
    }

    public List<BatchDocument> getBatchDocuments() {
        return null;
    }

    public BatchDocument getBatchDocument(String documentId) {
        return null;
    }

    public void addDocumentToBatch(String batchId, String documentId) {
    }
}
