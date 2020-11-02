/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

/*
 * IBM OpenAPI SDK Code Generator Version: 3.16.0-36b26b63-20201022-212410
 */

package com.ibm.watson.visual_recognition.v4;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.visual_recognition.v4.model.AddImageTrainingDataOptions;
import com.ibm.watson.visual_recognition.v4.model.AddImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeOptions;
import com.ibm.watson.visual_recognition.v4.model.AnalyzeResponse;
import com.ibm.watson.visual_recognition.v4.model.Collection;
import com.ibm.watson.visual_recognition.v4.model.CollectionsList;
import com.ibm.watson.visual_recognition.v4.model.CreateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteImageOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteObjectOptions;
import com.ibm.watson.visual_recognition.v4.model.DeleteUserDataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.GetImageDetailsOptions;
import com.ibm.watson.visual_recognition.v4.model.GetJpegImageOptions;
import com.ibm.watson.visual_recognition.v4.model.GetModelFileOptions;
import com.ibm.watson.visual_recognition.v4.model.GetObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.model.GetTrainingUsageOptions;
import com.ibm.watson.visual_recognition.v4.model.ImageDetails;
import com.ibm.watson.visual_recognition.v4.model.ImageDetailsList;
import com.ibm.watson.visual_recognition.v4.model.ImageSummaryList;
import com.ibm.watson.visual_recognition.v4.model.ListCollectionsOptions;
import com.ibm.watson.visual_recognition.v4.model.ListImagesOptions;
import com.ibm.watson.visual_recognition.v4.model.ListObjectMetadataOptions;
import com.ibm.watson.visual_recognition.v4.model.ObjectMetadata;
import com.ibm.watson.visual_recognition.v4.model.ObjectMetadataList;
import com.ibm.watson.visual_recognition.v4.model.TrainOptions;
import com.ibm.watson.visual_recognition.v4.model.TrainingDataObjects;
import com.ibm.watson.visual_recognition.v4.model.TrainingEvents;
import com.ibm.watson.visual_recognition.v4.model.UpdateCollectionOptions;
import com.ibm.watson.visual_recognition.v4.model.UpdateObjectMetadata;
import com.ibm.watson.visual_recognition.v4.model.UpdateObjectMetadataOptions;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * Provide images to the IBM Watson&amp;trade; Visual Recognition service for analysis. The service
 * detects objects based on a set of images with training data.
 *
 * @version v4
 * @see <a
 *     href="https://cloud.ibm.com/docs/visual-recognition?topic=visual-recognition-object-detection-overview">Visual
 *     Recognition</a>
 */
public class VisualRecognition extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "watson_vision_combined";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.visual-recognition.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `VisualRecognition` client. The default service name is used to
   * configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2019-02-11`.
   */
  public VisualRecognition(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `VisualRecognition` client. The default service name and
   * specified authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2019-02-11`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public VisualRecognition(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `VisualRecognition` client. The specified service name is used to
   * configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2019-02-11`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public VisualRecognition(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `VisualRecognition` client. The specified service name and
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the API version you want to use. Specify dates in YYYY-MM-DD
   *     format. The current version is `2019-02-11`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public VisualRecognition(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the API version you want to use. Specify dates in YYYY-MM-DD format. The
   * current version is `2019-02-11`.
   *
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(version, "version cannot be empty.");
    this.version = version;
  }

  /**
   * Analyze images.
   *
   * <p>Analyze images by URL, by file, or both against your own collection. Make sure that
   * **training_status.objects.ready** is `true` for the feature before you use a collection to
   * analyze images.
   *
   * <p>Encode the image and .zip file names in UTF-8 if they contain non-ASCII characters. The
   * service assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * @param analyzeOptions the {@link AnalyzeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AnalyzeResponse}
   */
  public ServiceCall<AnalyzeResponse> analyze(AnalyzeOptions analyzeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(analyzeOptions, "analyzeOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/analyze"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "analyze");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    for (String item : analyzeOptions.collectionIds()) {
      multipartBuilder.addFormDataPart("collection_ids", item);
    }
    for (String item : analyzeOptions.features()) {
      multipartBuilder.addFormDataPart("features", item);
    }
    if (analyzeOptions.imagesFile() != null) {
      for (FileWithMetadata item : analyzeOptions.imagesFile()) {
        okhttp3.RequestBody itemBody =
            RequestUtils.inputStreamBody(item.data(), item.contentType());
        multipartBuilder.addFormDataPart("images_file", item.filename(), itemBody);
      }
    }
    if (analyzeOptions.imageUrl() != null) {
      for (String item : analyzeOptions.imageUrl()) {
        multipartBuilder.addFormDataPart("image_url", item);
      }
    }
    if (analyzeOptions.threshold() != null) {
      multipartBuilder.addFormDataPart("threshold", String.valueOf(analyzeOptions.threshold()));
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<AnalyzeResponse> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<AnalyzeResponse>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a collection.
   *
   * <p>Create a collection that can be used to store images.
   *
   * <p>To create a collection without specifying a name and description, include an empty JSON
   * object in the request body.
   *
   * <p>Encode the name and description in UTF-8 if they contain non-ASCII characters. The service
   * assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * @param createCollectionOptions the {@link CreateCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> createCollection(CreateCollectionOptions createCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createCollectionOptions, "createCollectionOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/collections"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "createCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (createCollectionOptions.name() != null) {
      contentJson.addProperty("name", createCollectionOptions.name());
    }
    if (createCollectionOptions.description() != null) {
      contentJson.addProperty("description", createCollectionOptions.description());
    }
    if (createCollectionOptions.trainingStatus() != null) {
      contentJson.add(
          "training_status",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(createCollectionOptions.trainingStatus()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a collection.
   *
   * <p>Create a collection that can be used to store images.
   *
   * <p>To create a collection without specifying a name and description, include an empty JSON
   * object in the request body.
   *
   * <p>Encode the name and description in UTF-8 if they contain non-ASCII characters. The service
   * assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> createCollection() {
    return createCollection(null);
  }

  /**
   * List collections.
   *
   * <p>Retrieves a list of collections for the service instance.
   *
   * @param listCollectionsOptions the {@link ListCollectionsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link CollectionsList}
   */
  public ServiceCall<CollectionsList> listCollections(
      ListCollectionsOptions listCollectionsOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/collections"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "listCollections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<CollectionsList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CollectionsList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List collections.
   *
   * <p>Retrieves a list of collections for the service instance.
   *
   * @return a {@link ServiceCall} with a result of type {@link CollectionsList}
   */
  public ServiceCall<CollectionsList> listCollections() {
    return listCollections(null);
  }

  /**
   * Get collection details.
   *
   * <p>Get details of one collection.
   *
   * @param getCollectionOptions the {@link GetCollectionOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> getCollection(GetCollectionOptions getCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCollectionOptions, "getCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", getCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a collection.
   *
   * <p>Update the name or description of a collection.
   *
   * <p>Encode the name and description in UTF-8 if they contain non-ASCII characters. The service
   * assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * @param updateCollectionOptions the {@link UpdateCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> updateCollection(UpdateCollectionOptions updateCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCollectionOptions, "updateCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", updateCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "updateCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (updateCollectionOptions.name() != null) {
      contentJson.addProperty("name", updateCollectionOptions.name());
    }
    if (updateCollectionOptions.description() != null) {
      contentJson.addProperty("description", updateCollectionOptions.description());
    }
    if (updateCollectionOptions.trainingStatus() != null) {
      contentJson.add(
          "training_status",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(updateCollectionOptions.trainingStatus()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a collection.
   *
   * <p>Delete a collection from the service instance.
   *
   * @param deleteCollectionOptions the {@link DeleteCollectionOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteCollection(DeleteCollectionOptions deleteCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCollectionOptions, "deleteCollectionOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", deleteCollectionOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a model.
   *
   * <p>Download a model that you can deploy to detect objects in images. The collection must
   * include a generated model, which is indicated in the response for the collection details as
   * `"rscnn_ready": true`. If the value is `false`, train or retrain the collection to generate the
   * model.
   *
   * <p>Currently, the model format is specific to Android apps. For more information about how to
   * deploy the model to your app, see the [Watson Visual Recognition on
   * Android](https://github.com/matt-ny/rscnn) project in GitHub.
   *
   * @param getModelFileOptions the {@link GetModelFileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getModelFile(GetModelFileOptions getModelFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getModelFileOptions, "getModelFileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", getModelFileOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}/model", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getModelFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/octet-stream");
    builder.query("version", String.valueOf(this.version));
    builder.query("feature", String.valueOf(getModelFileOptions.feature()));
    builder.query("model_format", String.valueOf(getModelFileOptions.modelFormat()));
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add images.
   *
   * <p>Add images to a collection by URL, by file, or both.
   *
   * <p>Encode the image and .zip file names in UTF-8 if they contain non-ASCII characters. The
   * service assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * @param addImagesOptions the {@link AddImagesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ImageDetailsList}
   */
  public ServiceCall<ImageDetailsList> addImages(AddImagesOptions addImagesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addImagesOptions, "addImagesOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (addImagesOptions.imagesFile() != null)
            || (addImagesOptions.imageUrl() != null)
            || (addImagesOptions.trainingData() != null),
        "At least one of imagesFile, imageUrl, or trainingData must be supplied.");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", addImagesOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}/images", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "addImages");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    if (addImagesOptions.imagesFile() != null) {
      for (FileWithMetadata item : addImagesOptions.imagesFile()) {
        okhttp3.RequestBody itemBody =
            RequestUtils.inputStreamBody(item.data(), item.contentType());
        multipartBuilder.addFormDataPart("images_file", item.filename(), itemBody);
      }
    }
    if (addImagesOptions.imageUrl() != null) {
      for (String item : addImagesOptions.imageUrl()) {
        multipartBuilder.addFormDataPart("image_url", item);
      }
    }
    if (addImagesOptions.trainingData() != null) {
      multipartBuilder.addFormDataPart("training_data", addImagesOptions.trainingData());
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<ImageDetailsList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ImageDetailsList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List images.
   *
   * <p>Retrieves a list of images in a collection.
   *
   * @param listImagesOptions the {@link ListImagesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ImageSummaryList}
   */
  public ServiceCall<ImageSummaryList> listImages(ListImagesOptions listImagesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listImagesOptions, "listImagesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", listImagesOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}/images", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "listImages");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ImageSummaryList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ImageSummaryList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get image details.
   *
   * <p>Get the details of an image in a collection.
   *
   * @param getImageDetailsOptions the {@link GetImageDetailsOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link ImageDetails}
   */
  public ServiceCall<ImageDetails> getImageDetails(GetImageDetailsOptions getImageDetailsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getImageDetailsOptions, "getImageDetailsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", getImageDetailsOptions.collectionId());
    pathParamsMap.put("image_id", getImageDetailsOptions.imageId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/images/{image_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getImageDetails");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ImageDetails> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ImageDetails>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an image.
   *
   * <p>Delete one image from a collection.
   *
   * @param deleteImageOptions the {@link DeleteImageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteImage(DeleteImageOptions deleteImageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteImageOptions, "deleteImageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", deleteImageOptions.collectionId());
    pathParamsMap.put("image_id", deleteImageOptions.imageId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/images/{image_id}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteImage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a JPEG file of an image.
   *
   * <p>Download a JPEG representation of an image.
   *
   * @param getJpegImageOptions the {@link GetJpegImageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> getJpegImage(GetJpegImageOptions getJpegImageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getJpegImageOptions, "getJpegImageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", getJpegImageOptions.collectionId());
    pathParamsMap.put("image_id", getJpegImageOptions.imageId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/images/{image_id}/jpeg",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getJpegImage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "image/jpeg");
    builder.query("version", String.valueOf(this.version));
    if (getJpegImageOptions.size() != null) {
      builder.query("size", String.valueOf(getJpegImageOptions.size()));
    }
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List object metadata.
   *
   * <p>Retrieves a list of object names in a collection.
   *
   * @param listObjectMetadataOptions the {@link ListObjectMetadataOptions} containing the options
   *     for the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectMetadataList}
   */
  public ServiceCall<ObjectMetadataList> listObjectMetadata(
      ListObjectMetadataOptions listObjectMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listObjectMetadataOptions, "listObjectMetadataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", listObjectMetadataOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}/objects", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "listObjectMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ObjectMetadataList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ObjectMetadataList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an object name.
   *
   * <p>Update the name of an object. A successful request updates the training data for all images
   * that use the object.
   *
   * @param updateObjectMetadataOptions the {@link UpdateObjectMetadataOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link UpdateObjectMetadata}
   */
  public ServiceCall<UpdateObjectMetadata> updateObjectMetadata(
      UpdateObjectMetadataOptions updateObjectMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateObjectMetadataOptions, "updateObjectMetadataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", updateObjectMetadataOptions.collectionId());
    pathParamsMap.put("object", updateObjectMetadataOptions.object());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/objects/{object}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "updateObjectMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("object", updateObjectMetadataOptions.newObject());
    builder.bodyJson(contentJson);
    ResponseConverter<UpdateObjectMetadata> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<UpdateObjectMetadata>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get object metadata.
   *
   * <p>Get the number of bounding boxes for a single object in a collection.
   *
   * @param getObjectMetadataOptions the {@link GetObjectMetadataOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link ObjectMetadata}
   */
  public ServiceCall<ObjectMetadata> getObjectMetadata(
      GetObjectMetadataOptions getObjectMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getObjectMetadataOptions, "getObjectMetadataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", getObjectMetadataOptions.collectionId());
    pathParamsMap.put("object", getObjectMetadataOptions.object());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/objects/{object}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getObjectMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<ObjectMetadata> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ObjectMetadata>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an object.
   *
   * <p>Delete one object from a collection. A successful request deletes the training data from all
   * images that use the object.
   *
   * @param deleteObjectOptions the {@link DeleteObjectOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteObject(DeleteObjectOptions deleteObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteObjectOptions, "deleteObjectOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", deleteObjectOptions.collectionId());
    pathParamsMap.put("object", deleteObjectOptions.object());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/objects/{object}",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Train a collection.
   *
   * <p>Start training on images in a collection. The collection must have enough training data and
   * untrained data (the **training_status.objects.data_changed** is `true`). If training is in
   * progress, the request queues the next training job.
   *
   * @param trainOptions the {@link TrainOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Collection}
   */
  public ServiceCall<Collection> train(TrainOptions trainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(trainOptions, "trainOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", trainOptions.collectionId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v4/collections/{collection_id}/train", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "train");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Collection> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Collection>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add training data to an image.
   *
   * <p>Add, update, or delete training data for an image. Encode the object name in UTF-8 if it
   * contains non-ASCII characters. The service assumes UTF-8 encoding if it encounters non-ASCII
   * characters.
   *
   * <p>Elements in the request replace the existing elements.
   *
   * <p>- To update the training data, provide both the unchanged and the new or changed values.
   *
   * <p>- To delete the training data, provide an empty value for the training data.
   *
   * @param addImageTrainingDataOptions the {@link AddImageTrainingDataOptions} containing the
   *     options for the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingDataObjects}
   */
  public ServiceCall<TrainingDataObjects> addImageTrainingData(
      AddImageTrainingDataOptions addImageTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addImageTrainingDataOptions, "addImageTrainingDataOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("collection_id", addImageTrainingDataOptions.collectionId());
    pathParamsMap.put("image_id", addImageTrainingDataOptions.imageId());
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(),
                "/v4/collections/{collection_id}/images/{image_id}/training_data",
                pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "addImageTrainingData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    if (addImageTrainingDataOptions.objects() != null) {
      contentJson.add(
          "objects",
          com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
              .toJsonTree(addImageTrainingDataOptions.objects()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TrainingDataObjects> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingDataObjects>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get training usage.
   *
   * <p>Information about the completed training events. You can use this information to determine
   * how close you are to the training limits for the month.
   *
   * @param getTrainingUsageOptions the {@link GetTrainingUsageOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link TrainingEvents}
   */
  public ServiceCall<TrainingEvents> getTrainingUsage(
      GetTrainingUsageOptions getTrainingUsageOptions) {
    if (getTrainingUsageOptions == null) {
      getTrainingUsageOptions = new GetTrainingUsageOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/training_usage"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getTrainingUsage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getTrainingUsageOptions.startTime() != null) {
      builder.query("start_time", String.valueOf(getTrainingUsageOptions.startTime()));
    }
    if (getTrainingUsageOptions.endTime() != null) {
      builder.query("end_time", String.valueOf(getTrainingUsageOptions.endTime()));
    }
    ResponseConverter<TrainingEvents> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TrainingEvents>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get training usage.
   *
   * <p>Information about the completed training events. You can use this information to determine
   * how close you are to the training limits for the month.
   *
   * @return a {@link ServiceCall} with a result of type {@link TrainingEvents}
   */
  public ServiceCall<TrainingEvents> getTrainingUsage() {
    return getTrainingUsage(null);
  }

  /**
   * Delete labeled data.
   *
   * <p>Deletes all data associated with a specified customer ID. The method has no effect if no
   * data is associated with the customer ID.
   *
   * <p>You associate a customer ID with data by passing the `X-Watson-Metadata` header with a
   * request that passes data. For more information about personal data and customer IDs, see
   * [Information
   * security](https://cloud.ibm.com/docs/visual-recognition?topic=visual-recognition-information-security).
   *
   * @param deleteUserDataOptions the {@link DeleteUserDataOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/user_data"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("customer_id", String.valueOf(deleteUserDataOptions.customerId()));
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}
