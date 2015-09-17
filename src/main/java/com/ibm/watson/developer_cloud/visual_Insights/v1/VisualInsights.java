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

package com.ibm.watson.developer_cloud.visual_Insights.v1;

import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.visual_Insights.v1.model.Attribtes;
import com.ibm.watson.developer_cloud.visual_Insights.v1.model.Summary;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * The IBM Watson™ Visual Insights gives insight into the themes present in a collection of images based on their visual appearance / content.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v2
 * @see <a
 * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-insights.html">
 * Visual Insights</a>
 */
public class VisualInsights extends WatsonService {

    /**
     * The CLASSIFIERS_PATH. (value is "/classifiers")
     */
    private static final String CLASSIFIERS_PATH = "/v1/classifiers";

    /**
     * The SUMMARY_PATH. (value is "/summary")
     */
    private static final String SUMMARY_PATH = "/v1/summary";


    /**
     * The Constant FILTER_NAME. (value is "filter_name")
     */
    public static final String FILTER_NAME = "filter_name";

    /**
     * The service url.
     * (value is "https://gateway.watsonplatform.net/visual-insights/api")
     */
    private static final String URL = "https://gateway.watsonplatform.net/visual-insights-experimental/api";

    /**
     * Returns a summary of the collection's visual attributes
     *
     * @param filterName the images File
     * @return the Summary
     */
    public Attribtes getClassifiers(final String filterName) {
        Map<String, Object> queryParameters = new HashMap<String, Object>();
        queryParameters.put(FILTER_NAME,filterName);
        return executeRequest(CLASSIFIERS_PATH, queryParameters, Attribtes.class);
    }
    /**
     * Upload a set of images as a zip file for visual insight extraction.
     *
     * @param imagesFile the images File
     * @return the Summary of the collection's visual attributes
     */
    public Summary getSummary(final File imagesFile) {
        if (imagesFile == null || !imagesFile.exists())
            throw new IllegalArgumentException(
                    "imagesFile can not be null or empty");

        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", new FileBody(imagesFile));
        HttpRequestBase request = Request.Post(SUMMARY_PATH)
                 .withEntity(reqEntity).build();;

        try {
            HttpResponse response = execute(request);
            String jsonString = ResponseUtil.getString(response);
            Summary summary = GsonSingleton.getGson().fromJson(
                    jsonString, Summary.class);
            return summary;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Execute the request and return the POJO that represent the response.
     *
     * @param <T>             The POJO that represents the response object
     * @param resourcePath    the resource path
     * @param params          the request parameters
     * @param returnType      the POJO class to be parsed from the response
     * @return the POJO object that represent the response
     */
    private <T> T executeRequest(String resourcePath, Map<String, Object> params,  Class<T> returnType) {
        Request request = Request.Get(resourcePath);
        if(params!=null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                request.withQuery(entry.getKey(), entry.getValue());
            }
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            return ResponseUtil.getObject(response, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
