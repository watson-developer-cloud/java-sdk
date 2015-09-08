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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Batch;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.BatchCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Property;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Helper for the batch API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class BatchHelper {
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
    public BatchHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Creates a new batch with name and properties
     *
     * POST /v1/batches
     * @param name the name of the created batch
     * @param properties the properties for the created batch
     * @return requested Batch
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
     * Gets a collection of all existing batches with optional query parameters for filtering results.
     * GET /v1/batches
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of batches to get, pass 0 to use the default limit from server (100)
     * @param name The name of batches to get, pass null to exclude this filter
     * @param since The date to filter on, batches created on or after the provided date and time format
     *              will be returned, pass null to exclude this filter
     * @return Batches based on filtering parameters provided
     * @see DocumentConversion#getBatchCollection(String, int, String, Date)
     */
    public BatchCollection getBatchCollection(final String token, final int limit,
                                              final String name, final Date since) {
        Request request = Request.Get("/v1/batches");
        if(token != null && !token.isEmpty())
            request.withQuery("token", token);

        if (limit > 0)
            request.withQuery("limit", limit);
        else
            request.withQuery("limit", DocumentConversion.LIMIT);

        if(name != null && !name.isEmpty())
            request.withQuery("name", name);

        if(since != null)
            request.withQuery("since", ConversionUtils.convertToISO(since));

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String batchCollectionAsJson = ResponseUtil.getString(response);
            BatchCollection batchCollection = GsonSingleton.getGson().fromJson(
                                              batchCollectionAsJson, BatchCollection.class);
            return batchCollection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets an existing batch
     *
     * GET /v1/batches/{batch_id}
     * @param batchId id for the batch to be updated
     * @return requested Batch
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
     * Updates an existing batch with the provided name and properties
     *
     * PUT /v1/batches/{batch_id}
     * @param batchId id for the batch to be updated
     * @param name name of the batch to be updated
     * @param properties properties of the batch to be updated
     * @return updated Batch
     *
     *@see DocumentConversion#updateBatch(String, String, List)
     */
    public Batch updateBatch(final String batchId, final String name,
                             final List<Property> properties) {
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batchId cannot be null or empty");
        JsonObject contentJson = new JsonObject();
        if (name != null && !name.isEmpty())
            contentJson.addProperty("name", name);
        if(properties != null && properties.isEmpty())
            contentJson.addProperty("properties", new Gson().toJson(properties));
        HttpRequestBase request = Request.Put("/v1/batches/" + batchId)
                                         .withContent(filterJson(contentJson),
                                                      MediaType.APPLICATION_JSON).build();
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
     * @param jsonObject Json Object to be filtered
     * @return filtered Json String
     */
    public String filterJson(JsonObject jsonObject) {
        return jsonObject.toString().replace("\\","").replace("\"[", "[").replaceAll("]\"","]");
    }
}
