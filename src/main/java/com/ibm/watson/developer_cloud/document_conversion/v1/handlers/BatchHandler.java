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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Batch;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Property;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.List;

/**
 * Handler for the batches
 *
 * @see DocumentConversion
 */
public class BatchHandler {
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
    public BatchHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Creates the batch with the name and properties
     *
     * @param name
     *         name of the batch
     * @param properties
     *         properties to the batch
     * @return
     *
     * @see DocumentConversion#createBatch(String, List)
     */
    public Batch createBatch(final String name, final List<Property> properties) {
        JsonObject contentJson = new JsonObject();
        if (name != null && !name.isEmpty())
            contentJson.addProperty("name", name);
        if(properties != null && !properties.isEmpty())
            contentJson.addProperty("properties", new Gson().toJson(properties));

        HttpRequestBase request = Request.Post("/v1/batches")
                                         .withContent(filterJson(contentJson), MediaType.APPLICATION_JSON).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchAsJson = ResponseUtil.getString(response);
            Batch batch = GsonSingleton.getGson().fromJson(batchAsJson, Batch.class);
            return batch;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the batches in the stores which match the parameters
     * @param token
     *      token to the next page
     * @param limit
     *      number of batches in the page
     * @param name
     *      name of the batch
     * @param since
     *      the batches created after 'since'
     * @return
     *
     * @see DocumentConversion#getBatchCollection(String, String, String, String)
     */
    public BatchCollection getBatchCollection(final String token, final String limit, final String name, final String since) {
        Request request = Request.Get("/v1/batches");
        if(token != null && !token.isEmpty())
            request.withQuery("token", token);

        if(limit != null && !limit.isEmpty())
            request.withQuery("limit", limit);

        if(name != null && !name.isEmpty())
            request.withQuery("name", name);

        if(since != null && !since.isEmpty())
            request.withQuery("since", since);

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String batchCollectionAsJson = ResponseUtil.getString(response);
            BatchCollection batchCollection = GsonSingleton.getGson().fromJson(batchCollectionAsJson, BatchCollection.class);
            return batchCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the batch which matches the id
     *
     * @param batchId
     *      id to the batch
     * @return
     *
     * @see DocumentConversion#getBatch(String)
     */
    public Batch getBatch(final String batchId) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId can not be null or empty");
        HttpRequestBase request = Request.Get("/v1/batches/"+batchId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchAsJson = ResponseUtil.getString(response);
            Batch batch = GsonSingleton.getGson().fromJson(batchAsJson, Batch.class);
            return batch;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates the batch which have the name and properties
     *
     * @param batchId
     *      id to the batch
     * @param name
     *      name of the batch
     * @param properties
     *      properties of the batch
     * @return
     *
     * @see DocumentConversion#updateBatch(String, String, List)
     */
    public Batch updateBatch(final String batchId, final String name, final List<Property> properties) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");
        JsonObject contentJson = new JsonObject();
        if (name != null && !name.isEmpty())
            contentJson.addProperty("name", name);
        if(properties != null && properties.isEmpty())
            contentJson.addProperty("properties", new Gson().toJson(properties));
        HttpRequestBase request = Request.Put("/v1/batches/" + batchId)
                                         .withContent(filterJson(contentJson), MediaType.APPLICATION_JSON).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String batchAsJson = ResponseUtil.getString(response);
            Batch batch = GsonSingleton.getGson().fromJson(batchAsJson, Batch.class);
            return batch;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Escapes the Json object string to filter and send in the request
     *
     * @param jsonObject
     * @return
     */
    public String filterJson(JsonObject jsonObject) {
        return jsonObject.toString().replace("\\","").replace("\"[", "[").replaceAll("]\"","]");
    }
}
