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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.model.AlchemyGenericModel;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageSceneText;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints.AlchemyAPI;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.util.Validate;
import com.squareup.okhttp.RequestBody;

/**
 * The Alchemy Vision service uses deep learning innovations to understand a picture’s content and
 * context. It sees complex visual scenes in their entirety —without needing any textual clues—
 * leveraging a holistic approach to understanding the multiple objects and surroundings.
 * 
 * @version v1
 * @see <a href="http://www.alchemyapi.com/products/alchemyvision"> Alchemy Vision</a>
 */
public class AlchemyVision extends AlchemyService {

  /**
   * The Constant FORCE_SHOW_ALL. (value is "forceShowAll")
   */
  public static final String FORCE_SHOW_ALL = "forceShowAll";

  /** The Constant HTML. (value is "html") */
  public static final String HTML = "html";

  /** The Constant IMAGE. (value is "image") */
  public static final String IMAGE = "image";

  /**
   * The Constant IMAGE_POST_MODE. (value is "imagePostMode")
   */
  public static final String IMAGE_POST_MODE = "imagePostMode";

  /**
   * The Constant KNOWLEDGE_GRAPH. (value is "knowledgeGraph")
   */
  public static final String KNOWLEDGE_GRAPH = "knowledgeGraph";

  /** The Constant NOT_RAW. (value is "not-raw") */
  public static final String NOT_RAW = "not-raw";

  /** The Constant RAW. (value is "raw") */
  public static final String RAW = "raw";

  /** The Constant URL. (value is "url") */
  public static final String URL = "url";

  /** The Constant NO_TAGS. (value is "NO_TAGS") */
  private static final String NO_TAGS = "NO_TAGS";

  /**
   * Executes the request and return the POJO that represent the response.
   * 
   * @param <T> The POJO that represents the response object
   * @param params the request parameters
   * @param operation the alchemy operation
   * @param returnType the POJO class to be parsed from the response
   * @return the POJO object that represent the response
   */
  private <T extends AlchemyGenericModel> T executeRequest(Map<String, Object> params,
      AlchemyAPI operation, Class<T> returnType) {
    final String inputType = getInputFormat(params, IMAGE, URL, HTML);
    final String path = AlchemyEndPoints.getPath(operation, inputType);

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    if (IMAGE.equals(inputType)) {
      if (params.get(IMAGE) instanceof String) {
        params.put(IMAGE_POST_MODE, NOT_RAW);
      } else {
        params.put(IMAGE_POST_MODE, RAW);
        final File image = (File) params.get(IMAGE);
        if (!image.exists()) {
          throw new IllegalArgumentException(
              "The file: " + image.getAbsolutePath() + " does not exist.");
        } else {
          requestBuilder
              .withBody(RequestBody.create(HttpMediaType.BINARY_FILE, (File) params.get(IMAGE)));
          params.remove(IMAGE);
        }
      }
    }

    // set json as default output mode
    params.put(OUTPUT_MODE, "json");

    // add all the parameters into the request as form-url-encoded parameters
    for (final String param : params.keySet()) {
      if (inputType.equals(IMAGE)) {
        requestBuilder.withQuery(param, params.get(param));
      } else {
        requestBuilder.withForm(param, params.get(param));
      }
    }

    return executeRequest(requestBuilder.build(), returnType);
  }

  /**
   * Identifies text in an image
   * 
   * @param image the image file
   * @return {@link ImageSceneText}
   */
  public ImageSceneText getImageSceneText(File image) {
    Validate.notNull(image, "image cannot be null");
    Validate.isTrue(image.exists(), "image file: " + image.getAbsolutePath() + " not found");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(IMAGE, image);

    return executeRequest(params, AlchemyAPI.image_scene_text, ImageSceneText.class);
  }

  /**
   * Identifies text in an image specified by URL or in the primary image in a web page specified by
   * URL
   * 
   * @param url the image URL
   * @return {@link ImageSceneText}
   */
  public ImageSceneText getImageSceneText(URL url) {
    Validate.notNull(url, "url cannot be null");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(URL, url);

    return executeRequest(params, AlchemyAPI.image_scene_text, ImageSceneText.class);
  }

  /**
   * Extracts keywords from an image
   * 
   * @param image the image file
   * @param forceShowAll Includes lower confidence tags
   * @param knowledgeGraph Include knowledge graph information in the the results.
   * @return {@link ImageKeywords}
   */
  public ImageKeywords getImageKeywords(File image, Boolean forceShowAll, Boolean knowledgeGraph) {
    Validate.notNull(image, "image cannot be null");
    Validate.isTrue(image.exists(), "image file: " + image.getAbsolutePath() + " not found");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(IMAGE, image);

    if (forceShowAll != null)
      params.put(FORCE_SHOW_ALL, forceShowAll ? 1 : 0);

    if (knowledgeGraph != null)
      params.put(KNOWLEDGE_GRAPH, knowledgeGraph ? 1 : 0);

    ImageKeywords imageKeywords = executeRequest(params, AlchemyAPI.image_keywords, ImageKeywords.class);

    // Remove the NO_TAGS keywords
    ListIterator<ImageKeyword> iter = imageKeywords.getImageKeywords().listIterator();
    while (iter.hasNext()) {
      if (iter.next().getText().equals(NO_TAGS)) {
        iter.remove();
      }
    }
    return imageKeywords;
  }


  /**
   * Extracts keywords from a URL.
   * 
   * @param url the image URL
   * @param forceShowAll Includes lower confidence tags
   * @param knowledgeGraph Include knowledge graph information in the the results.
   * @return {@link ImageKeywords}
   */
  public ImageKeywords getImageKeywords(URL url, Boolean forceShowAll, Boolean knowledgeGraph) {
    Validate.notNull(url, "url cannot be null");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(URL, url);

    if (forceShowAll != null)
      params.put(FORCE_SHOW_ALL, forceShowAll ? 1 : 0);

    if (knowledgeGraph != null)
      params.put(KNOWLEDGE_GRAPH, knowledgeGraph ? 1 : 0);

    return executeRequest(params, AlchemyAPI.image_keywords, ImageKeywords.class);
  }

  /**
   * Extracts main image link from a URL.
   * 
   * @param url the image URL
   * @return {@link ImageLink}
   */
  public ImageLink getImageLink(URL url) {
    Validate.notNull(url, "url cannot be null");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(URL, url);

    return executeRequest(params, AlchemyAPI.image_link, ImageLink.class);
  }

  /**
   * Extracts the main image link from a HTML page.
   * 
   * @param html the HTML
   * @return {@link ImageLink}
   */
  public ImageLink getImageLink(String html) {
    Validate.notNull(html, "html cannot be null");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(HTML, html);

    return executeRequest(params, AlchemyAPI.image_link, ImageLink.class);
  }

  /**
   * Recognizes faces from an image.<br>
   * For each face detected returns:
   * <ul>
   * <li>Bounding box
   * <li>Gender
   * <li>Approximate age
   * <li>Name (if celebrity is detected)
   * </ul>
   * <br>
   * Here is an example of how to recognize faces in an image:
   * 
   * <pre>
   * AlchemyVision service = new AlchemyVision();
   * service.setApiKey(&quot;&lt;api_key&gt;&quot;);
   * 
   * File image = new File(&quot;obama.jpg&quot;);
   * ImageFaces faces = service.recognizeFaces(image, true);
   * 
   * System.out.println(faces);
   * </pre>
   * 
   * @param image the image
   * @param knowledgeGraph provide extra metadata for detected celebrities
   * @return {@link ImageFaces}
   */
  public ImageFaces recognizeFaces(File image, Boolean knowledgeGraph) {
    Validate.notNull(image, "image cannot be null");
    Validate.isTrue(image.exists(), "image file: " + image.getAbsolutePath() + " not found");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(IMAGE, image);

    if (knowledgeGraph != null)
      params.put(KNOWLEDGE_GRAPH, knowledgeGraph ? 1 : 0);


    return executeRequest(params, AlchemyAPI.image_recognition, ImageFaces.class);
  }

  /**
   * Recognizes faces from a URL.<br>
   * For each face detected returns:
   * <ul>
   * <li>Bounding box
   * <li>Gender
   * <li>Approximate age
   * <li>Name (if celebrity is detected)
   * </ul>
   * <br>
   * Here is an example of how to recognize faces in an image:
   * 
   * <pre>
   * AlchemyVision service = new AlchemyVision();
   * service.setApiKey(&quot;&lt;api_key&gt;&quot;);
   * 
   * URL image = new URL(&quot;http://foo.com/the-image.png&quot;);
   * ImageFaces faces = service.recognizeFaces(image, true);
   * 
   * System.out.println(faces);
   * </pre>
   * 
   * @param url the image URL
   * @param knowledgeGraph provide extra metadata for detected celebrities
   * @return {@link ImageFaces}
   */
  public ImageFaces recognizeFaces(URL url, Boolean knowledgeGraph) {
    Validate.notNull(url, "url cannot be null");

    final Map<String, Object> params = new HashMap<String, Object>();
    params.put(URL, url);

    if (knowledgeGraph != null)
      params.put(KNOWLEDGE_GRAPH, knowledgeGraph ? 1 : 0);


    return executeRequest(params, AlchemyAPI.image_recognition, ImageFaces.class);
  }
}
