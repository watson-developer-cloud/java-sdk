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

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.OutputCollection;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;

/**
 * Handler class for all output API calls
 *
 * @see DocumentConversion
 */
public class OutputHandler {
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
    public OutputHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Gets a collection of all generated outputs with optional query parameters for filtering results.
     * GET /v1/output
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of outputs to get, pass null to use the default limit from server (100)
     * @param since The date to filter on, outputs created on or after the provided date and time format
     *              will be returned. NOTE: ISO 8601 date and time format is required: (YYYY-MM-DDTHH:MM:SSZ),
     *              pass null to exclude this filter
     * @param jobId The id of a job to filter outputs by, pass null to exclude this filter
     * @param mediaType The Internet media type to filter on, pass null to exclude this filter
     * @return Outputs based on filtering parameters provided
     *
     * @see DocumentConversion#getOutputCollection(String, int, String, String, String)
     */
    public OutputCollection getOutputCollection(final String token, final int limit, final String since,
                                       final String jobId, final String mediaType) {
        Request request = Request.Get("/v1/output");

        if (token != null && !token.isEmpty())
            request.withQuery("token", token);

        if (limit > 0)
            request.withQuery("limit", limit);

        if (since != null && !since.isEmpty())
            request.withQuery("since", since);

        if (jobId != null && !jobId.isEmpty())
            request.withQuery("job_id", jobId);

        if (mediaType != null && !mediaType.isEmpty())
            request.withQuery("media_type", mediaType);

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String OutputsAsJson = ResponseUtil.getString(response);
            OutputCollection outputs = GsonSingleton.getGson().fromJson(OutputsAsJson, OutputCollection.class);
            return outputs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the content of the output requested
     * @param outputId The id of the output to get
     * @return The requested Output
     *
     * @see DocumentConversion#getOutput(String)
     */
    public String getOutput(final String outputId) {
        if (outputId == null || outputId.isEmpty())
            throw new IllegalArgumentException("output id can not be null or empty");

        HttpRequestBase request = Request.Get("/v1/output/" + outputId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            return ResponseUtil.getString(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
