/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.alchemy_vision.v1;

import com.ibm.watson.developer_cloud.alchemy_vision.v1.model.FaceTag;
import com.ibm.watson.developer_cloud.alchemy_vision.v1.model.Image;
import com.ibm.watson.developer_cloud.alchemy_vision.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.service.AlchemyService;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.AlchemyEndPoints;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.FileEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.MissingFormatArgumentException;

/**
 * The Alchemy Vision service uses IBM's ....
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 * @version v1
 * @see <a
 * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/alchemy-vision.html">
 * Speech to Text</a>
 */
public class AlchemyVision extends AlchemyService {

    /**
     * The Constant OUT_PUT_MODE. desired API output format
     */
    public static final String OUT_PUT_MODE = "outputMode";

    /**
     * The Constant FORCE_SHOW_ALL.
     */
    public static final String FORCE_SHOW_ALL = "forceShowAll";

    /**
     * The Constant KNOWLEDGE_GRAPH
     */
    public static final String KNOWLEDGE_GRAPH = "knowledgeGraph";

    /**
     * The Constant IMAGE_POST_MODE
     */
    public static final String IMAGE_POST_MODE = "imagePostMode";

    public static final String RAW = "raw";

    public static final String NOT_RAW = "not-raw";

    public AlchemyVision() {
        setEndPoint(URL);
    }

    /**
     * Extract image for a web URL
     *
     * @param params
     * @return {@link ImageLink}
     */
    public ImageLink getImage(Map<String, Object> params) {
        String url = (String) params.get(AlchemyEndPoints.AlchemyAPI.url.name());
        String html = (String) params.get(AlchemyEndPoints.AlchemyAPI.html.name());

        String apiCall = null;
        if (!StringUtils.isEmpty(url)) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(AlchemyEndPoints.AlchemyObjects.image_link.name(), AlchemyEndPoints.AlchemyAPI.url.name());
        } else if (!StringUtils.isEmpty(html)) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(AlchemyEndPoints.AlchemyObjects.image_link.name(), AlchemyEndPoints.AlchemyAPI.html.name());
        } else
            throw new MissingFormatArgumentException("url or html should be specified");

        params.put(OUT_PUT_MODE, "json");
        // TODO validate the query parameters
        String[] queryParameters = new String[]{
                FORCE_SHOW_ALL, OUT_PUT_MODE, KNOWLEDGE_GRAPH, AlchemyEndPoints.AlchemyAPI.url.name(), AlchemyEndPoints.AlchemyAPI.html.name()};

        // Build the entities url
        StringBuilder urlBuider = new StringBuilder();
        urlBuider.append(URL).append(apiCall);
        Request request = Request.Post(urlBuider.toString());
        for (String param : queryParameters) {
            if (params.containsKey(param))
                request.withForm(param, params.get(param));
        }
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonstring = ResponseUtil.getString(response);
            ImageLink imageLink = GsonSingleton.getGson().fromJson(
                    jsonstring, ImageLink.class);
            return imageLink;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Extract image for a web URL
     *
     * @param params
     * @return {@link Image}
     */
    public Image recognizeImage(Map<String, Object> params) {
        String url = (String) params.get(AlchemyEndPoints.AlchemyAPI.url.name());
        File image = (File) params.get(AlchemyEndPoints.AlchemyAPI.image.name());
        boolean raw = true; // TODO dafault used raw

        String apiCall;
        // Set the image_file
        FileEntity fileEntity = null;

        if (!StringUtils.isEmpty(url)) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(AlchemyEndPoints.AlchemyObjects.image_keywords.name(), AlchemyEndPoints.AlchemyAPI.url.name());
            raw = false;
        } else if (image != null && image.exists()) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(AlchemyEndPoints.AlchemyObjects.image_keywords.name(), AlchemyEndPoints.AlchemyAPI.image.name());
            if (params.get(IMAGE_POST_MODE) != null && (params.get(IMAGE_POST_MODE)).equals(NOT_RAW)) {
                try {
                    // TODO need to test not raw
                    raw = false;
                    String base64String = encodeFileToBase64Binary(image);
                    params.put("image", base64String);
                    params.put(IMAGE_POST_MODE, NOT_RAW);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                fileEntity = new FileEntity(image, "binary/octet-stream");
                params.put(IMAGE_POST_MODE, RAW);
                params.remove("image");
            }
        } else
            throw new MissingFormatArgumentException("url string or image file should be specified");

        params.put(OUT_PUT_MODE, "json");
        String[] queryParameters = new String[]{
                FORCE_SHOW_ALL, OUT_PUT_MODE, KNOWLEDGE_GRAPH, AlchemyEndPoints.AlchemyAPI.url.name()};

        StringBuilder urlBuider = new StringBuilder();
        urlBuider.append(URL).append(apiCall);
        Request request = Request.Post(urlBuider.toString());

        for (String param : queryParameters) {
            if (params.containsKey(param)) {
                if (!StringUtils.isEmpty(url)) {
                    request.withForm(param, params.get(param));
                } else {
                    request.withQuery(param, params.get(param));
                }
            }
        }

        if (raw)
            request.withEntity(fileEntity);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonstring = ResponseUtil.getString(response);
            Image image1 = GsonSingleton.getGson().fromJson(
                    jsonstring, Image.class);
            return image1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Extract image for a web URL
     *
     * @param params
     * @return {@link FaceTag}
     */
    public FaceTag recognizeFaces(Map<String, Object> params) {
        String url = (String) params.get(AlchemyEndPoints.AlchemyAPI.url.name());
        File image = (File) params.get(AlchemyEndPoints.AlchemyAPI.image.name());
        boolean raw = true; // TODO dafault used raw

        String apiCall;
        // Set the image_file
        FileEntity fileEntity = null;

        if (!StringUtils.isEmpty(url)) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(AlchemyEndPoints.AlchemyObjects.image_recognition.name(), AlchemyEndPoints.AlchemyAPI.url.name());
            raw = false;
        } else if (image != null && image.exists()) {
            apiCall = AlchemyEndPoints.getAlchemyAPI(AlchemyEndPoints.AlchemyObjects.image_recognition.name(), AlchemyEndPoints.AlchemyAPI.image.name());
            if (params.get(IMAGE_POST_MODE) != null && (params.get(IMAGE_POST_MODE)).equals(NOT_RAW)) {
                try {
                    // TODO need to test not raw
                    raw = false;
                    String base64String = encodeFileToBase64Binary(image);
                    params.put("image", base64String);
                    params.put(IMAGE_POST_MODE, NOT_RAW);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                fileEntity = new FileEntity(image, "binary/octet-stream");
                params.put(IMAGE_POST_MODE, RAW);
                params.remove("image");
            }
        } else
            throw new MissingFormatArgumentException("url string or image file should be specified");

        params.put(OUT_PUT_MODE, "json");
        String[] queryParameters = new String[]{
                OUT_PUT_MODE, KNOWLEDGE_GRAPH, AlchemyEndPoints.AlchemyAPI.url.name()};

        StringBuilder urlBuider = new StringBuilder();
        urlBuider.append(URL).append(apiCall);
        Request request = Request.Post(urlBuider.toString());

        for (String param : queryParameters) {
            if (params.containsKey(param)) {
                if (!StringUtils.isEmpty(url)) {
                    request.withForm(param, params.get(param));
                } else {
                    request.withQuery(param, params.get(param));
                }
            }
        }

        if (raw)
            request.withEntity(fileEntity);
        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = execute(requestBase);
            String jsonstring = ResponseUtil.getString(response);
            FaceTag faceTag = GsonSingleton.getGson().fromJson(
                    jsonstring, FaceTag.class);
            return faceTag;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * utility functions
     **/
    private String encodeFileToBase64Binary(File file)
            throws IOException {
        byte[] bytes = loadFile(file);
        byte[] encoded = Base64.encodeBase64(bytes);
        String encodedString = new String(encoded);
        return encodedString;
    }

    private byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }

}
