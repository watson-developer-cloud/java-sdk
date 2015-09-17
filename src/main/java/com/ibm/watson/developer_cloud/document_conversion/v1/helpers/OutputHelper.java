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

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.OutputCollection;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Helper class for all output API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class OutputHelper {
    
    /** The document service object. */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object.
     *
     * @param docConversionService the doc conversion service
     */
    public OutputHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Gets a collection of all generated outputs with optional query parameters for filtering results.
     * GET /v1/output
     *
     * @param outputListParams The parameters to be used in the output list service call.
     *                         The parameters - token, limit, since, job_id and media_type are optional
     * <ul>
     * <li> String token - The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page </li>
     * <li> int limit - The number of outputs to get, pass 0 to use the default limit from server (100) </li>
     * <li> Date since - The date to filter on, outputs created on or after the provided date and time format
     *              will be returned. </li>
     * <li> String job_id - The id of a job to filter outputs by, pass null to exclude this filter </li>
     * <li> String media_type - The Internet media type to filter on, pass null to exclude this filter </li>
     * </ul>
     * @return Outputs based on filtering parameters provided
     *
     * @see DocumentConversion#getOutputCollection(Map)
     */

    public OutputCollection getOutputCollection(Map<String, Object> outputListParams) {
        Request request = Request.Get(DocumentConversion.OUTPUT_PATH);

        if(outputListParams != null) {
            if (outputListParams.get(DocumentConversion.TOKEN) != null) {
                String token = (String) outputListParams.get(DocumentConversion.TOKEN);
                if (!token.isEmpty())
                    request.withQuery(DocumentConversion.TOKEN, token);
            }

            if (outputListParams.get(DocumentConversion.LIMIT) != null) {
                int limit = ((Integer) outputListParams.get(DocumentConversion.LIMIT)).intValue();
                if (limit > 0)
                    request.withQuery(DocumentConversion.LIMIT, limit);
                else
                    request.withQuery(DocumentConversion.LIMIT, DocumentConversion.DEFAULT_LIMIT);
            }

            if (outputListParams.get(DocumentConversion.SINCE) != null) {
                Date since = (Date) outputListParams.get(DocumentConversion.SINCE);
                request.withQuery(DocumentConversion.SINCE, ConversionUtils.convertToISO(since));
            }

            if (outputListParams.get(DocumentConversion.JOB_ID) != null) {
                String jobId = (String) outputListParams.get(DocumentConversion.JOB_ID);
                if (!jobId.isEmpty())
                    request.withQuery(DocumentConversion.JOB_ID, jobId);
            }

            if (outputListParams.get(DocumentConversion.MEDIA_TYPE) != null) {
                String mediaType = (String) outputListParams.get(DocumentConversion.MEDIA_TYPE);
                if (!mediaType.isEmpty())
                    request.withQuery(DocumentConversion.MEDIA_TYPE, mediaType);
            }
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String OutputsAsJson = ResponseUtil.getString(response);
            OutputCollection outputs = ConversionUtils.getGsonWithIso8601DateDeserializer()
                    .fromJson(OutputsAsJson, OutputCollection.class);
            return outputs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the content of the output requested.
     *
     * @param outputId The id of the output to get
     * @return The requested Output
     * @see DocumentConversion#getOutput(String)
     */
    public InputStream getOutput(final String outputId) {
        if (outputId == null || outputId.isEmpty())
            throw new IllegalArgumentException("output id can not be null or empty");

        HttpRequestBase request = Request.Get(DocumentConversion.OUTPUT_PATH +"/" + outputId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            InputStream is = ResponseUtil.getInputStream(response);
            return is;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
