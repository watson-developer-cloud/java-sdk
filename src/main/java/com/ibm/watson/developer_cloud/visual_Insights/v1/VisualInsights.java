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
package com.ibm.watson.developer_cloud.visual_insights.v1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.visual_insights.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.visual_insights.v1.model.Summary;


/**
 * The IBM Watson Visual Insights gives insight into the themes present in a collection of images based on their visual appearance / content.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a
 * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-insights.html">
 * Visual Insights</a>
 */
public class VisualInsights extends WatsonService {

    private static final String FILE = "file";

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
     * Instantiates a new visual insights service.
     */
    public VisualInsights() {
		setEndPoint(URL);
	}
    
    /**
     * Returns a summary of the collection's visual classifiers
     *
     * @return the Summary
     */
    public Classifiers getClassifiers() {
        Request request = Request.Get(CLASSIFIERS_PATH);
        return executeRequest(request, Classifiers.class);
    }

    /**
     * Returns a summary of the collection's visual classifiers, filtered by name
     *
     * @param filterName the images File
     * @return the Summary
     */
    public Classifiers getClassifiers(final String filterName) {

        Request request = Request.Get(CLASSIFIERS_PATH);

        if(filterName!=null && !filterName.isEmpty()) {
            Map<String, Object> queryParameters = new HashMap<String, Object>();
            queryParameters.put(FILTER_NAME,filterName);
            request.withQuery(queryParameters);
        }

        return executeRequest(request, Classifiers.class);
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
        reqEntity.addPart(FILE, new FileBody(imagesFile));
        Request request = Request.Post(SUMMARY_PATH)
                .withEntity(reqEntity);

        return executeRequest(request, Summary.class);

    }

}
