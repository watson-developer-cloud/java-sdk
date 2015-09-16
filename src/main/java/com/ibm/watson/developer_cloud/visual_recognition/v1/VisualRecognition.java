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
package com.ibm.watson.developer_cloud.visual_recognition.v1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.LabelSet;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.RecognizedImage;
import com.ibm.watson.developer_cloud.visual_recognition.v1.model.VisualRecognitionImages;

/**
 * The Visual Recognition service analyzes images, enabling you to understand
 * their content without any accompanying descriptive text.
 *
 * @author German Attanasio Ruiz (germanatt@us.ibm.com)
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-recognition.html">
 *      Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

	/** The Constant LABELS_TO_CHECK. */
	public static final String LABELS_TO_CHECK = "labels_to_check";
	
	/** The Constant IMG_FILE. */
	public static final String IMG_FILE = "imgFile";
	/** The service endpoint. */
	private static final String URL = "https://gateway.watsonplatform.net/visual-recognition-beta/api";

	/**
	 * Instantiates a new visual recognition.
	 */
	public VisualRecognition() {
		setEndPoint(URL);
	}

	/**
	 * Classifies the images against the label groups and labels. The response
	 * includes a score for a label if the score meets the minimum threshold of
	 * 0.5. If no score meets the threshold for an image, no labels are
	 * returned.
	 * 
	 * @param image
	 *            the file image
	 * @param labelSet
	 *            the labels to classify against
	 * @return the visual recognition images
	 */
	public RecognizedImage recognize(final File image,final LabelSet labelSet) {
		if (image == null)
			throw new IllegalArgumentException("image can not be null");
		try {

			Request request = Request.Post("/v1/tag/recognize");

			MultipartEntity reqEntity = new MultipartEntity();

			// Set the image_file
			FileBody bin = new FileBody(image);
			reqEntity.addPart(IMG_FILE, bin);

			if (labelSet != null) {
				StringBody labels = new StringBody(GsonSingleton.getGson().toJson(labelSet),
						Charset.forName("UTF-8"));

				// Set the labels_to_check
				reqEntity.addPart(LABELS_TO_CHECK, labels);
			}
			request.withEntity(reqEntity);

			HttpResponse response = execute(request.build());
			String resultJson = ResponseUtil.getString(response);
			VisualRecognitionImages recognizedImages = GsonSingleton.getGson().fromJson(
					resultJson, VisualRecognitionImages.class);
			return recognizedImages.getImages().get(0);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the labels and label groups.
	 * 
	 * @return the labels and label groups
	 */
	public LabelSet getLabelSet() {
		HttpRequestBase request = Request.Get("/v1/tag/labels").build();
		try {
			HttpResponse response = execute(request);
			String jsonLabelSet = ResponseUtil.getString(response);
			return GsonSingleton.getGson().fromJson(jsonLabelSet, LabelSet.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Classifies the images against all the label groups and labels. The
	 * response includes a score for a label if the score meets the minimum
	 * threshold of 0.5. If no score meets the threshold for an image, no labels
	 * are returned.
	 * 
	 * @param image
	 *            the image file
	 * @return the visual recognition images
	 */
	public RecognizedImage recognize(final File image) {
		return recognize(image, null);
	}
}
