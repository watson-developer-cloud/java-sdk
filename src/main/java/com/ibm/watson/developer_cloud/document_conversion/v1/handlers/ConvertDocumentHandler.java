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
import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.ConversionTarget;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Handler class for all convert document API calls
 *
 * @see DocumentConversion
 */
public class ConvertDocumentHandler {
    /**
     * The document service object
     */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object
     *
     * @param docConversionService
     */
    public ConvertDocumentHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Synchronously converts a new document without persistence
     * POST /v1/convert_document
     * @param document The file to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     *
     * @see DocumentConversion#convertDocument(File, ConversionTarget)
     */
    public String convertDocument(final File document, final ConversionTarget conversionTarget) {
        if (document == null || !document.exists())
            throw new IllegalArgumentException("document can not be null and must exist");
        if (conversionTarget == null)
            throw new IllegalArgumentException("conversion target can not be null");

        try {
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(document, MediaType.TEXT_HTML));
            JsonObject configRequestJson = new JsonObject();
            configRequestJson.addProperty("conversion_target", conversionTarget.toString());
            String json = configRequestJson.toString();
            reqEntity.addPart("config", new StringBody(json, MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));

            HttpRequestBase request = Request.Post("/v1/convert_document")
                    .withEntity(reqEntity).build();

            HttpResponse response = docConversionService.execute(request);
            return ResponseUtil.getString(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Synchronously converts a single previously uploaded document
     * POST /v1/convert_document
     * @param documentId The id of the document to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     *
     * @see DocumentConversion#convertDocument(String, ConversionTarget)
     */
    public String convertDocument(final String documentId, final ConversionTarget conversionTarget) {
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("document id can not be null or empty");
        if (conversionTarget == null)
            throw new IllegalArgumentException("conversion target can not be null");

        JsonObject contentJson = new JsonObject();
        contentJson.addProperty("document_id", documentId);
        contentJson.addProperty("conversion_target", conversionTarget.toString());

        HttpRequestBase request = Request.Post("/v1/convert_document")
                .withContent(contentJson).build();

        try {
            HttpResponse response = docConversionService.execute(request);
            return ResponseUtil.getString(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
