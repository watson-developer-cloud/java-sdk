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
package com.ibm.watson.developer_cloud.visual_recognition.v1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.Validate;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.LabelSet;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.VisualRecognitionImages;
import com.squareup.okhttp.MultipartBuilder;

/**
 * The Visual Recognition service analyzes images, enabling you to understand their content without
 * any accompanying descriptive text.
 * 
 * @version v1
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-recognition.html">
 *      Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

  /** The Constant IMG_FILE (value is "imgFile") */
  public static final String IMG_FILE = "imgFile";

  /** The Constant LABELS_TO_CHECK (value is "labels_to_check"). */
  public static final String LABELS_TO_CHECK = "labels_to_check";
  /** The service endpoint. */
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
   * Gets the labels and label groups.
   * 
   * @return the labels and label groups
   */
  public LabelSet getLabelSet() {
    return executeRequest(RequestBuilder.get("/v1/tag/labels").build(), LabelSet.class);
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
   * label if the score meets the minimum threshold of 0.5. If no score meets the threshold for an
   * image, no labels are returned.
   * 
   * @param image the file image
   * @param labelSet the labels to classify against
   * @return the visual recognition images
   */
  public VisualRecognitionImages recognize(final File image, final LabelSet labelSet) {
    Validate.isTrue(image != null && image.exists(), "image cannot be null or not be found");
    InputStream stream = null;
    try {
      stream = new FileInputStream(image);
    } catch (FileNotFoundException e) {
    }
    return recognize(image.getName(), stream, labelSet);
  }

  public VisualRecognitionImages recognize(final String imageName, final InputStream image,
      final LabelSet labelSet) {
    if (image == null)
      throw new IllegalArgumentException("image cannot be null");

    final RequestBuilder requestBuilder = RequestBuilder.post("/v1/tag/recognize");

    final MultipartBuilder bodyBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
    bodyBuilder.addFormDataPart(IMG_FILE, imageName,
        InputStreamRequestBody.create(HttpMediaType.BINARY_FILE, image));

    if (labelSet != null)
      bodyBuilder.addFormDataPart(LABELS_TO_CHECK,
          GsonSingleton.getGsonWithoutPrettyPrinting().toJson(labelSet));

    requestBuilder.withBody(bodyBuilder.build());

    return executeRequest(requestBuilder.build(), VisualRecognitionImages.class);
  }
}
