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
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.model.AlchemyGenericModel;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.alchemy.v1.util.AlchemyEndPoints.AlchemyAPI;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.squareup.okhttp.RequestBody;

/**
 * The Alchemy Vision service uses deep learning innovations to understand a picture’s content and
 * context. It sees complex visual scenes in their entirety —without needing any textual clues—
 * leveraging a holistic approach to understanding the multiple objects and surroundings.
 * 
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
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

  /**
   * Execute the request and return the POJO that represent the response.
   * 
   * @param <T> The POJO that represents the response object
   * @param params the request parameters
   * @param operation the alchemy operation
   * @param returnType the POJO class to be parsed from the response
   * @return the POJO object that represent the response
   */
  private <T extends AlchemyGenericModel> T executeRequest(Map<String, Object> params,
      AlchemyAPI operation, Class<T> returnType) {
    final String inputType = getInputFormat(params, IMAGE, "url");
    final String path = AlchemyEndPoints.getPath(operation, inputType);

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    if (inputType == IMAGE) {
      if (params.get(IMAGE) instanceof String) {
        params.put(IMAGE_POST_MODE, NOT_RAW);
      } else {
        params.put(IMAGE_POST_MODE, RAW);
        final File image = (File) params.get(IMAGE);
        if (!image.exists()) {
          throw new IllegalArgumentException("The file: " + image.getAbsolutePath()
              + " does not exist.");
        } else {
          requestBuilder.withBody(RequestBody.create(HttpMediaType.BINARY_FILE,
              (File) params.get(IMAGE)));
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
   * Extract keywords from an image or url.
   * 
   * @param params The parameters to be used in the service call, image or url should be specified.
   * @return {@link ImageKeywords}
   */
  public ImageKeywords getImageKeywords(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.image_keywords, ImageKeywords.class);
  }

  /**
   * Extract main image link from html or a URL.
   * 
   * @param params The parameters to be used in the service call, html or url should be specified.
   * @return {@link ImageLink}
   */
  public ImageLink getImageLink(Map<String, Object> params) {
    final String inputType = getInputFormat(params, HTML, URL);
    final String path = AlchemyEndPoints.getPath(AlchemyAPI.image_link, inputType);

    // Return json
    params.put(OUTPUT_MODE, "json");

    final RequestBuilder requestBuilder = RequestBuilder.post(path);
    for (final String param : params.keySet()) {
      requestBuilder.withForm(param, params.get(param));
    }

    return executeRequest(requestBuilder.build(), ImageLink.class);
  }

  /**
   * Recognize faces from an image or URL. For each face detected returns:
   * <ul>
   * <li>Bounding box
   * <li>Gender
   * <li>Approximate age
   * <li>Name (if celebrity is detected)
   * </ul>
   * 
   * @param params The parameters to be used in the service call, image or url should be specified.
   * @return {@link ImageFaces}
   */
  public ImageFaces recognizeFaces(Map<String, Object> params) {
    return executeRequest(params, AlchemyAPI.image_recognition, ImageFaces.class);
  }
}
