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
package com.ibm.watson.developer_cloud.visual_recognition.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.InputStreamRequestBody;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.util.Validate;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualClassifier;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualClassifiers;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

/**
 * Visual Recognition allows you to derive insights from an image based on its visual content. You
 * can organize image libraries, understand an individual image, and create custom classifiers for
 * specific results that are tailored to your needs.
 * 
 * @version v2
 * @see <a href=
 *      "http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/visual-recognition.html">
 *      Visual Recognition</a>
 */
public class VisualRecognition extends WatsonService {

  /** The version date: 2015-12-02. */
  public static final String VERSION_DATE_2015_12_02 = "2015-12-02";
  private static final String POSITIVE_EXAMPLES = "positive_examples";
  private static final String NEGATIVE_EXAMPLES = "negative_examples";
  private static final String IMAGES_FILE = "images_file";
  private static final String NAME = "name";
  private static final String VERBOSE = "verbose";
  private static final String CLASSIFIER_IDS = "classifier_ids";

  private static final String PATH_CLASSIFIER = "/v2/classifiers/%s";
  private static final String PATH_CLASSIFIERS = "/v2/classifiers";
  private static final String PATH_CLASSIFY = "/v2/classify";
  private static final String URL =
      "https://gateway.watsonplatform.net/visual-recognition-beta/api";

  private String versionDate;

  /**
   * Instantiates a new Visual Recognition V2 service.
   * 
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *        will keep your API calls from failing when the service introduces breaking changes.
   */
  public VisualRecognition(String versionDate) {
    super("visual_recognition");
    setEndPoint(URL);
    this.versionDate = versionDate;
  }


  /**
   * Classifies the image/s against all the classifiers. The response includes a score for a
   * classifier if the score meets the minimum threshold of 0.5. If no score meets the threshold for
   * an image, no classifiers are returned. <br>
   * <br>
   * Here is an example of how to classify an image using all the classifiers:
   * 
   * <pre>
   * VisualRecognition service = new VisualRecognition(&quot;2015-12-02&quot;);
   * service.setUsernameAndPassword(&quot;&lt;username&gt;&quot;, &quot;&lt;password&gt;&quot;);
   * 
   * File image = new File(&quot;car.png&quot;);
   * 
   * VisualClassification result = service.classify(image);
   * System.out.println(result);
   * </pre>
   * 
   * @param imagesFile the image/s to classify
   * @return the visual recognition images
   */
  public VisualClassification classify(final File imagesFile) {
    return classify(imagesFile, (VisualClassifier) null);
  }

  /**
   * Classifies the images against the label groups and labels. The response includes a score for a
   * label if the score meets the minimum threshold of 0.5. If no score meets the threshold for an
   * image, no labels are returned.
   * 
   * <br>
   * <br>
   * Here is an example of how to classify an image using an existing classifier:
   * 
   * <pre>
   * VisualRecognition service = new VisualRecognition(&quot;2015-12-02&quot;);
   * service.setUsernameAndPassword(&quot;&lt;username&gt;&quot;, &quot;&lt;password&gt;&quot;);
   * 
   * File image = new File(&quot;car.png&quot;);
   * VisualClassifier car = new VisualClassifier(&quot;Car&quot;);
   * 
   * VisualClassification result = service.classify(image, car);
   * System.out.println(result);
   * </pre>
   * 
   * @param imagesFile the image/s to classify
   * @param classifiers the classifiers
   * @return the visual recognition images
   */
  public VisualClassification classify(final File imagesFile,
      final VisualClassifier... classifiers) {
    Validate.isTrue(imagesFile != null && imagesFile.exists(),
        "image cannot be null or not be found");

    InputStream stream = null;
    try {
      stream = new FileInputStream(imagesFile);
    } catch (FileNotFoundException e) {
    }
    return classify(imagesFile.getName(), stream, classifiers);
  }

  /**
   * Classifies the image/s against the Classifiers. The response includes a score for a classifier
   * only if the score meets the minimum threshold of 0.5. If no score meets the threshold for an
   * image, no classifiers are returned.
   * 
   * <br>
   * <br>
   * Here is an example of how to classify an InputStream image with an existing classifier:
   * 
   * <pre>
   * VisualRecognition service = new VisualRecognition(&quot;2015-12-02&quot;);
   * service.setUsernameAndPassword(&quot;&lt;username&gt;&quot;, &quot;&lt;password&gt;&quot;);
   * 
   * FileInputStream image = new FileInputStream(&quot;car.png&quot;);
   * VisualClassifier car = new VisualClassifier(&quot;Car&quot;);
   * 
   * VisualClassification result = service.classify(&quot;foo.png&quot;, image, car);
   * System.out.println(result);
   * </pre>
   * 
   * @param filename The file name
   * @param imagesInputStream the image/s input stream to classify
   * @param classifiers the classifiers
   * @return the {@link Classification}
   */
  public VisualClassification classify(final String filename, final InputStream imagesInputStream,
      final VisualClassifier... classifiers) {
    Validate.notNull(imagesInputStream, "image cannot be null");
    Validate.notNull(filename, "filename cannot be null");

    MultipartBuilder bodyBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
    bodyBuilder.addFormDataPart(IMAGES_FILE, filename,
        InputStreamRequestBody.create(HttpMediaType.BINARY_FILE, imagesInputStream));

    if (classifiers != null && classifiers.length > 0 && classifiers[0] != null) {
      JsonObject classifierIds = getClassifierIdsAsJson(classifiers);
      bodyBuilder.addFormDataPart(CLASSIFIER_IDS, classifierIds.toString());
    }

    RequestBuilder requestBuilder = RequestBuilder.post(PATH_CLASSIFY)
        .withQuery(VERSION, versionDate).withBody(bodyBuilder.build());

    return executeRequest(requestBuilder.build(), VisualClassification.class);
  }

  /**
   * Creates a {@link JsonObject} with an array of classifier ids.
   * 
   * @param classifiers the classifiers
   * @return the classifier ids as {@link JsonObject}
   */
  private JsonObject getClassifierIdsAsJson(VisualClassifier... classifiers) {
    JsonObject ret = new JsonObject();
    JsonArray array = new JsonArray();
    ret.add(CLASSIFIER_IDS, array);

    for (VisualClassifier classifier : classifiers) {
      array.add(new JsonPrimitive(classifier.getId()));
    }
    return ret;
  }

  /**
   * Train a new classifier on the uploaded image data. Upload a compressed (.zip) file of images
   * (.jpg, .png, or .gif) with positive examples that show your classifier and another compressed
   * file with negative examples that are similar to but do NOT show your classifier. <br>
   * <br>
   * Here is an example of how to create a classifier with positive and negatives images:
   * 
   * <pre>
   * VisualRecognition service = new VisualRecognition(&quot;2015-12-02&quot;);
   * service.setUsernameAndPassword(&quot;&lt;username&gt;&quot;, &quot;&lt;password&gt;&quot;);
   * 
   * File positiveImages = new File(&quot;positive.zip&quot;); // zip file with at least 10 images
   * File negativeImages = new File(&quot;negative.zip&quot;);
   * 
   * VisualClassifier foo = service.createClassifier(&quot;foo&quot;, positiveImages, negativeImages);
   * System.out.println(foo);
   * </pre>
   * 
   * 
   * @param name the classifier name
   * @param positiveImages A compressed (.zip) file of images which prominently depict the visual
   *        subject for a new classifier. Must contain a minimum of 10 images.
   * @param negativeImages A compressed (.zip) file of images which do not depict the subject for a
   *        new classifier. Must contain a minimum of 10 images.
   * @return the created {@link VisualClassifier}
   * @see VisualClassifier
   */
  public VisualClassifier createClassifier(final String name, final File positiveImages,
      final File negativeImages) {
    Validate.isTrue(positiveImages != null && positiveImages.exists(),
        "positiveImages cannot be null or not be found");
    Validate.isTrue(negativeImages != null && negativeImages.exists(),
        "negativeImages cannot be null or not be found");

    Validate.isTrue(name != null && !name.isEmpty(), "name cannot be null or empty");

    // POST body
    RequestBody body = new MultipartBuilder().type(MultipartBuilder.FORM)
        .addFormDataPart(POSITIVE_EXAMPLES, positiveImages.getName(),
            RequestBody.create(HttpMediaType.BINARY_FILE, positiveImages))
        .addFormDataPart(NEGATIVE_EXAMPLES, negativeImages.getName(),
            RequestBody.create(HttpMediaType.BINARY_FILE, negativeImages))
        .addFormDataPart(NAME, name).build();

    Request request = RequestBuilder.post(PATH_CLASSIFIERS).withQuery(VERSION, versionDate)
        .withBody(body).build();

    return executeRequest(request, VisualClassifier.class);
  }


  /**
   * Deletes a classifier.
   * 
   * @param classifierId the classifier ID to delete
   * @see VisualClassifier
   */
  public void deleteClassifier(String classifierId) {
    Validate.isTrue(classifierId != null && !classifierId.isEmpty(),
        "classifierId cannot be null or empty");

    Request request = RequestBuilder.delete(String.format(PATH_CLASSIFIER, classifierId))
        .withQuery(VERSION, versionDate).build();
    executeWithoutResponse(request);
  }

  /**
   * Retrieves a classifier.
   * 
   * @param classifierId the classifier ID
   * @return the classifier list
   * @see VisualClassifier
   */
  public VisualClassifier getClassifier(String classifierId) {
    Validate.isTrue(classifierId != null && !classifierId.isEmpty(),
        "classifierId cannot be null or empty");

    Request request = RequestBuilder.get(String.format(PATH_CLASSIFIER, classifierId))
        .withQuery(VERSION, versionDate).build();
    return executeRequest(request, VisualClassifier.class);
  }

  /**
   * Retrieves the list of classifiers.
   * 
   * @return the classifier list
   * @see VisualClassifier
   */
  public List<VisualClassifier> getClassifiers() {
    Request request = RequestBuilder.get(PATH_CLASSIFIERS).withQuery(VERSION, versionDate)
        .withQuery(VERBOSE, true).build();
    VisualClassifiers classifiers = executeRequest(request, VisualClassifiers.class);
    return classifiers.getClassifiers();
  }
}
