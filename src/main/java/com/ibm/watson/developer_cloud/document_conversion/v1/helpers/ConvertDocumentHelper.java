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
package com.ibm.watson.developer_cloud.document_conversion.v1.helpers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.ConversionTarget;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Helper class for all convert document API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class ConvertDocumentHelper {
    
    /** The document service object. */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object.
     *
     * @param docConversionService the doc conversion service
     */
    public ConvertDocumentHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Converts the provided document to an Answers object.
     *
     * @param document the document
     * @return Answers
     * @see DocumentConversion#convertDocumentToAnswer(File)
     */
    public Answers convertDocumentToAnswer(final File document) {
        InputStream is = convertDocument(document, ConversionTarget.ANSWER_UNITS);
        String convertedDocument = ConversionUtils.writeInputStreamToString(is);
        Answers answers = ConversionUtils.getGsonWithIso8601DateDeserializer()
                .fromJson(convertedDocument, Answers.class);
        return answers;
    }

    /**
     * Synchronously converts a new document without persistence
     * POST /v1/convert_document.
     *
     * @param document The file to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     * @see DocumentConversion#convertDocument(File, ConversionTarget)
     */
    public InputStream convertDocument(final File document, final ConversionTarget conversionTarget) {
        String mediaType = ConversionUtils.getMediaTypeFromFile(document);
        return convertDocument(document, mediaType, conversionTarget);
    }

    /**
     * Synchronously converts a new document without persistence
     * POST /v1/convert_document.
     *
     * @param document The file to convert
     * @param mediaType Internet media type for the file
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     * @see DocumentConversion#convertDocument(File, String, ConversionTarget)
     */
    public InputStream convertDocument(final File document, String mediaType, final ConversionTarget conversionTarget) {
        if (mediaType == null || mediaType.isEmpty())
            throw new IllegalArgumentException("media type cannot be null or empty");
        if(!ConversionUtils.isValidMediaType(mediaType))
            throw new IllegalArgumentException("file with the given media type is not supported");
        if (document == null || !document.exists())
            throw new IllegalArgumentException("document can not be null and must exist");
        if (conversionTarget == null)
            throw new IllegalArgumentException("conversion target can not be null");

        try {
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(document, mediaType));
            JsonObject configRequestJson = new JsonObject();
            configRequestJson.addProperty("conversion_target", conversionTarget.toString());
            String json = configRequestJson.toString();
            reqEntity.addPart("config", new StringBody(json, MediaType.APPLICATION_JSON, Charset.forName("UTF-8")));

            HttpRequestBase request = Request.Post(DocumentConversion.CONVERT_DOCUMENT_PATH)
                    .withEntity(reqEntity).build();

            HttpResponse response = docConversionService.execute(request);
            InputStream is = ResponseUtil.getInputStream(response);
            return is;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts the specified document to an Answers object.
     *
     * @param documentId the document id
     * @return Answers
     * @see DocumentConversion#convertDocumentToAnswer(String)
     */
    public Answers convertDocumentToAnswer(final String documentId) {
        InputStream is = convertDocument(documentId, ConversionTarget.ANSWER_UNITS);
        String convertedDocument = ConversionUtils.writeInputStreamToString(is);
        Answers answers = ConversionUtils.getGsonWithIso8601DateDeserializer()
                .fromJson(convertedDocument, Answers.class);
        return answers;
    }

    /**
     * Synchronously converts a single previously uploaded document
     * POST /v1/convert_document.
     *
     * @param documentId The id of the document to convert
     * @param conversionTarget The conversion target to use
     * @return Converted document in the specified format
     * @see DocumentConversion#convertDocument(String, ConversionTarget)
     */
    public InputStream convertDocument(final String documentId, final ConversionTarget conversionTarget) {
        if (documentId == null || documentId.isEmpty())
            throw new IllegalArgumentException("document id can not be null or empty");
        if (conversionTarget == null)
            throw new IllegalArgumentException("conversion target can not be null");

        JsonObject contentJson = new JsonObject();
        contentJson.addProperty("document_id", documentId);
        contentJson.addProperty("conversion_target", conversionTarget.toString());

        HttpRequestBase request = Request.Post(DocumentConversion.CONVERT_DOCUMENT_PATH)
                .withContent(contentJson).build();

        try {
            HttpResponse response = docConversionService.execute(request);
            InputStream is = ResponseUtil.getInputStream(response);
            return is;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
