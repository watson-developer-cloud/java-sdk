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
package com.ibm.watson.developer_cloud.visual_insights.v1;

import java.io.File;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.visual_insights.v1.model.Classifiers;
import com.ibm.watson.developer_cloud.visual_insights.v1.model.Summary;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

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

  /**
   * The CLASSIFIERS_PATH. (value is "/classifiers")
   */
  private static final String CLASSIFIERS_PATH = "/v1/classifiers";

  /**
   * The Constant FILTER_NAME. (value is "filter_name")
   */
  public static final String FILTER_NAME = "filter_name";

  /** The Constant IMAGES_FILE. */
  private static final String IMAGES_FILE = "images_file";

  /**
   * The SUMMARY_PATH. (value is "/summary")
   */
  private static final String SUMMARY_PATH = "/v1/summary";

  /**
   * The service URL. (value is "https://gateway.watsonplatform.net/visual-insights/api")
   */
  private static final String URL =
      "https://gateway.watsonplatform.net/visual-insights-experimental/api";

  /**
   * Instantiates a new visual insights service.
   */
  public VisualInsights() {
    super("visual_insights");
    setEndPoint(URL);
  }

  /**
   * Returns a summary of the collection's visual classifiers.
   * 
   * @return the Summary
   */
  public Classifiers getClassifiers() {
    return getClassifiers(null);
  }

  /**
   * Returns a summary of the collection's visual classifiers, filtered by name.
   * 
   * @param name the filter name
   * @return the {@link Classifiers} that match the given filter name
   */
  public Classifiers getClassifiers(final String name) {

    final RequestBuilder requestBuilder = RequestBuilder.get(CLASSIFIERS_PATH);

    if (name != null && !name.isEmpty())
      requestBuilder.withQuery(FILTER_NAME, name);

    return executeRequest(requestBuilder.build(), Classifiers.class);
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
   * Summary summary = service.getSummary(images);
   * 
   * System.out.println(summary);
   * </pre>
   * 
   * @param imagesFile the images File
   * @return the {@link Summary} of the collection's visual attributes
   */
  public Summary getSummary(final File imagesFile) {
    if (imagesFile == null || !imagesFile.exists())
      throw new IllegalArgumentException("imagesFile cannot be null or empty");

    final MediaType mediaType = HttpMediaType.BINARY_FILE;
    final RequestBody body =
        new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart(IMAGES_FILE,
            imagesFile.getName(), RequestBody.create(mediaType, imagesFile)).build();

    final RequestBuilder requestBuilder = RequestBuilder.post(SUMMARY_PATH).withBody(body);

    return executeRequest(requestBuilder.build(), Summary.class);

  }

}
