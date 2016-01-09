/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.visual_recognition.v2;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.Validate;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.ClassifierSet;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualRecognitionImages;
import com.squareup.okhttp.MultipartBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * The Visual Recognition service analyzes images, enabling you to understand their content without
 * any accompanying descriptive text.
 *
 * @version v2 beta
 * @see <a
 * href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-recognition.html">
 * Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

    /**
     * The Constant IMG_FILE (value is "imgFile")
     */
    public static final String IMG_FILE = "imgFile";

    /**
     * The Constant CLASSIFIER_IDS, VERSION, and VERSION_LATEST
     */
    public static final String CLASSIFIER_IDS = "classifier_ids";
    public static final String VERSION = "version";
    public static final String VERSION_LATEST = "2015-12-02";

    /**
     * The service endpoint.
     */
    private static final String URL =
            "https://gateway.watsonplatform.net/visual-recognition-beta/api";

    /**
     * Instantiates a new visual recognition.
     */
    public VisualRecognition() {
        super("visual_recognition");
        setEndPoint(URL);
    }

    /**
     * Gets the list of classifiers.
     */
    public ClassifierSet getClassifierSet() {
        return executeRequest(RequestBuilder.get("/v2/classifiers").build(), ClassifierSet.class);
    }

    /**
     * Classifies the images against all the label groups and labels. The response includes a score
     * for a label if the score meets the minimum threshold of 0.5. If no score meets the threshold
     * for an image, no labels are returned.
     *
     * @param image the image file
     * @return the visual recognition images
     */
    public VisualRecognitionImages recognize(final File image) {
        return recognize(image, null);
    }

    /**
     * Classifies the images against the label groups and labels. The response includes a score for a
     * classifier if the score meets the minimum threshold of 0.5. If no score meets the threshold for an
     * image, no classifiers are returned.
     *
     * @param image         the file image
     * @param classifierSet the classifiers to classify against
     * @return the visual recognition images
     */
    public VisualRecognitionImages recognize(final File image, final ClassifierSet classifierSet) {
        Validate.isTrue(image != null && image.exists(), "image cannot be null or not be found");
        InputStream stream = null;
        try {
            stream = new FileInputStream(image);
        } catch (FileNotFoundException e) {
        }
        return recognize(image.getName(), stream, classifierSet);
    }

    public VisualRecognitionImages recognize(final String imageName, final InputStream image,
                                             final ClassifierSet classifierSet) {
        if (image == null)
            throw new IllegalArgumentException("image cannot be null");

        final RequestBuilder requestBuilder = RequestBuilder.post("/v2/classify");

        final MultipartBuilder bodyBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
        bodyBuilder.addFormDataPart(IMG_FILE, imageName,
                InputStreamRequestBody.create(HttpMediaType.BINARY_FILE, image));

        if (classifierSet != null)
            bodyBuilder.addFormDataPart(CLASSIFIER_IDS, GsonSingleton.getGson().toJson(classifierSet));

        requestBuilder.withBody(bodyBuilder.build());
        requestBuilder.withQuery(VERSION, VERSION_LATEST);

        return executeRequest(requestBuilder.build(), VisualRecognitionImages.class);
    }
}
