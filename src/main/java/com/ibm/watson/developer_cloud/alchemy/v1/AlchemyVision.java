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
package com.ibm.watson.developer_cloud.alchemy.v1;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.FileEntity;

import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.util.AlchemyEndPoints.AlchemyAPI;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * The Alchemy Vision service uses deep learning innovations to understand a picture’s
 * content and context. It sees complex visual scenes in their entirety —without needing
 * any textual clues— leveraging a holistic approach to understanding the multiple objects
 * and surroundings.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a
 * href="http://www.alchemyapi.com/products/alchemyvision">
 * Alchemy Vision</a>
 */
public class AlchemyVision extends AlchemyService {

    /**
     * The Constant FORCE_SHOW_ALL. (value is "forceShowAll")
     */
    public static final String FORCE_SHOW_ALL = "forceShowAll";

    /**
     * The Constant KNOWLEDGE_GRAPH. (value is "knowledgeGraph")
     */
    public static final String KNOWLEDGE_GRAPH = "knowledgeGraph";

    /**
     * The Constant IMAGE_POST_MODE. (value is "imagePostMode")
     */
    public static final String IMAGE_POST_MODE = "imagePostMode";

    /** The Constant RAW. (value is "raw") */
    public static final String RAW = "raw";

    /** The Constant NOT_RAW. (value is "not-raw") */
    public static final String NOT_RAW = "not-raw";

    /** The Constant IMAGE. (value is "image") */
    public static final String IMAGE = "image";

    /** The Constant URL. (value is "url") */
	public static final String URL = "url";
	
	/** The Constant HTML. (value is "html") */
	public static final String HTML = "html";

    /**
     * Extract main image link from html or a URL.
     *
     * @param params The parameters to be used in the service call, html or url should
     *               be specified.
     * @return {@link ImageLink}
     */
    public ImageLink getImageLink(Map<String, Object> params) {
        String inputType = getInputFormat(params, "html", "url");
        String path = AlchemyEndPoints.getPath(AlchemyAPI.image_link, inputType);
        
        // Return json
        params.put(OUTPUT_MODE, "json");

        Request request = Request.Post(path);
        for (String param : params.keySet()) {
            request.withForm(param, params.get(param));
        }

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            return ResponseUtil.getObject(response, ImageLink.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Extract keywords from an image or url.
     *
     * @param params The parameters to be used in the service call, image or url should
     *               be specified.
     * @return {@link ImageKeywords}
     */
    public ImageKeywords getImageKeywords(Map<String, Object> params) {
        return executeRequest(params, AlchemyAPI.image_keywords, ImageKeywords.class);
    }

    /**
     * Recognize faces from an image or url.
     * For each face detected returns:
     * <ul>
     * <li>bounding box
     * <li>gender
     * <li>approximate age
     * <li>name (if celebrity is detected)
     * </ul>
     *
     * @param params The parameters to be used in the service call, image or url should
     *               be specified.
     * @return {@link ImageFaces}
     */
    public ImageFaces recognizeFaces(Map<String, Object> params) {
        return executeRequest(params, AlchemyAPI.image_recognition, ImageFaces.class);
    }

    /**
     * Execute the request and return the POJO that represent the response.
     *
     * @param <T>        The POJO that represents the response object
     * @param params     the request parameters
     * @param operation  the alchemy operation
     * @param returnType the POJO class to be parsed from the response
     * @return the POJO object that represent the response
     */
    private <T> T executeRequest(Map<String, Object> params, AlchemyAPI operation, Class<T> returnType) {
        String inputType = getInputFormat(params, "image", "url");
        String path = AlchemyEndPoints.getPath(operation, inputType);

        Request request = Request.Post(path);
        if (inputType == IMAGE) {
            if (params.get(IMAGE) instanceof String) {
                params.put(IMAGE_POST_MODE, NOT_RAW);
            } else {
                params.put(IMAGE_POST_MODE, RAW);
                File image = (File) params.get(IMAGE);
                if (!image.exists()) {
                    throw new IllegalArgumentException("The file: " + image.getAbsolutePath() + " does not exist.");
                } else {
                    // if image is a file add it as file entity and remove it from the parameters
                    request.withEntity(new FileEntity((File) params.get(IMAGE), MediaType.APPLICATION_OCTET_STREAM));
                    params.remove("image");
                }
            }
        }

        // set json as default output mode
        params.put(OUTPUT_MODE, "json");

        // add all the parameters into the request as form-url-encoded parameters
        for (String param : params.keySet()) {
            if(inputType.equals("image")) {
                request.withQuery(param, params.get(param));
            }  else {
               request.withForm(param, params.get(param));
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
