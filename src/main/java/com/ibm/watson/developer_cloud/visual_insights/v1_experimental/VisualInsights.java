/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.visual_insights.v1_experimental;

import java.io.File;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.ResponseConverterUtils;
import com.ibm.watson.developer_cloud.visual_insights.v1_experimental.model.Classifiers;
import com.ibm.watson.developer_cloud.visual_insights.v1_experimental.model.Summary;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * The IBM Watson Visual Insights gives insight into the themes present in a collection of images
 * based on their visual appearance / content.
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-insights.html">
 *      Visual Insights</a>
 */
public class VisualInsights extends WatsonService {

  private static final String SERVICE_NAME = "visual_insights";
  private static final String CLASSIFIERS_PATH = "/v1/classifiers";
  
  /** The Constant FILTER_NAME. */
  public static final String FILTER_NAME = "filter_name";
  private static final String IMAGES_FILE = "images_file";
  private static final String SUMMARY_PATH = "/v1/summary";
  private static final String URL = "https://gateway.watsonplatform.net/visual-insights-experimental/api";

  /**
   * Instantiates a new visual insights service.
   */
  public VisualInsights() {
    super(SERVICE_NAME);
    setEndPoint(URL);
  }

  /**
   * Returns a summary of the collection's visual classifiers.
   * 
   * @return the Summary
   */
  public ServiceCall<Classifiers> getClassifiers() {
    return getClassifiers(null);
  }

  /**
   * Returns a summary of the collection's visual classifiers, filtered by name.
   * 
   * @param name the filter name
   * @return the {@link Classifiers} that match the given filter name
   */
  public ServiceCall<Classifiers> getClassifiers(final String name) {

    final RequestBuilder requestBuilder = RequestBuilder.get(CLASSIFIERS_PATH);

    if (name != null && !name.isEmpty())
      requestBuilder.withQuery(FILTER_NAME, name);

    return createServiceCall(requestBuilder.build(), ResponseConverterUtils.getObject(Classifiers.class));
  }

  /**
   * Upload a set of images as a ZIP file for visual insight extraction.
   * 
   * <br>
   * Here is the code to get the {@link Summary} of a collection of images:
   * 
   * <pre>
   * VisualInsights service = new VisualInsights();
   * service.setUsernameAndPassword(&quot;&lt;username&gt;&quot;, &quot;&lt;password&gt;&quot;);
   * 
   * File images = new File(&quot;images.zip&quot;);
   * Summary summary = service.getSummary(images).execute();
   * 
   * System.out.println(summary);
   * </pre>
   * 
   * @param imagesFile the images File
   * @return the {@link Summary} of the collection's visual attributes
   */
  public ServiceCall<Summary> getSummary(final File imagesFile) {
    if (imagesFile == null || !imagesFile.exists())
      throw new IllegalArgumentException("imagesFile cannot be null or empty");

    final MediaType mediaType = HttpMediaType.BINARY_FILE;
    final RequestBody body = new MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart(IMAGES_FILE, imagesFile.getName(), RequestBody.create(mediaType, imagesFile)).build();

    final Request request = RequestBuilder.post(SUMMARY_PATH).withBody(body).build();

    return createServiceCall(request, ResponseConverterUtils.getObject(Summary.class));

  }

}
