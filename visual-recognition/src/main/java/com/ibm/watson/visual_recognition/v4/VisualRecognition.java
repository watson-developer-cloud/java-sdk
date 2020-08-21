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
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * Provide images to the IBM Watson&trade; Visual Recognition service for analysis. The service
 * detects objects based on a set of images with training data.
 *
 * @version v4
 * @see <a
 *     href="https://cloud.ibm.com/docs/visual-recognition?topic=visual-recognition-object-detection-overview">Visual
 *     Recognition</a>
 */
public class VisualRecognition extends BaseService {

  private static final String DEFAULT_SERVICE_NAME = "visual_recognition";

  private static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.visual-recognition.watson.cloud.ibm.com";

  private String versionDate;

  /**
   * Constructs a new `VisualRecognition` client using the DEFAULT_SERVICE_NAME.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *     will keep your API calls from failing when the service introduces breaking changes.
   */
  public VisualRecognition(String versionDate) {
    this(
        versionDate,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs a new `VisualRecognition` client with the DEFAULT_SERVICE_NAME and the specified
   * Authenticator.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *     will keep your API calls from failing when the service introduces breaking changes.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public VisualRecognition(String versionDate, Authenticator authenticator) {
    this(versionDate, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs a new `VisualRecognition` client with the specified serviceName.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *     will keep your API calls from failing when the service introduces breaking changes.
   * @param serviceName The name of the service to configure.
   */
  public VisualRecognition(String versionDate, String serviceName) {
    this(versionDate, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs a new `VisualRecognition` client with the specified Authenticator and serviceName.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
   *     will keep your API calls from failing when the service introduces breaking changes.
   * @param serviceName The name of the service to configure.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public VisualRecognition(String versionDate, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
    this.versionDate = versionDate;
    this.configureService(serviceName);
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
   * @return a {@link ServiceCall} with a response type of {@link AnalyzeResponse}
   */
  public ServiceCall<AnalyzeResponse> analyze(AnalyzeOptions analyzeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(analyzeOptions, "analyzeOptions cannot be null");
    String[] pathSegments = {"v4/analyze"};
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "analyze");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    multipartBuilder.addFormDataPart("collection_ids", RequestUtils.join(analyzeOptions.collectionIds(), ","));
    multipartBuilder.addFormDataPart("features", RequestUtils.join(analyzeOptions.features(), ","));
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
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> createCollection(CreateCollectionOptions createCollectionOptions) {
    String[] pathSegments = {"v4/collections"};
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "createCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (createCollectionOptions != null) {
      if (createCollectionOptions.name() != null) {
        contentJson.addProperty("name", createCollectionOptions.name());
      }
      if (createCollectionOptions.description() != null) {
        contentJson.addProperty("description", createCollectionOptions.description());
      }
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
   * @return a {@link ServiceCall} with a response type of {@link Collection}
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
   * @return a {@link ServiceCall} with a response type of {@link CollectionsList}
   */
  public ServiceCall<CollectionsList> listCollections(
      ListCollectionsOptions listCollectionsOptions) {
    String[] pathSegments = {"v4/collections"};
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "listCollections");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listCollectionsOptions != null) {}

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
   * @return a {@link ServiceCall} with a response type of {@link CollectionsList}
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
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> getCollection(GetCollectionOptions getCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getCollectionOptions, "getCollectionOptions cannot be null");
    String[] pathSegments = {"v4/collections"};
    String[] pathParameters = {getCollectionOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> updateCollection(UpdateCollectionOptions updateCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateCollectionOptions, "updateCollectionOptions cannot be null");
    String[] pathSegments = {"v4/collections"};
    String[] pathParameters = {updateCollectionOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "updateCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateCollectionOptions.name() != null) {
      contentJson.addProperty("name", updateCollectionOptions.name());
    }
    if (updateCollectionOptions.description() != null) {
      contentJson.addProperty("description", updateCollectionOptions.description());
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
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteCollection(DeleteCollectionOptions deleteCollectionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteCollectionOptions, "deleteCollectionOptions cannot be null");
    String[] pathSegments = {"v4/collections"};
    String[] pathParameters = {deleteCollectionOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteCollection");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> getModelFile(GetModelFileOptions getModelFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getModelFileOptions, "getModelFileOptions cannot be null");
    String[] pathSegments = {"v4/collections", "model"};
    String[] pathParameters = {getModelFileOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getModelFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/octet-stream");
    builder.query("feature", getModelFileOptions.feature());
    builder.query("model_format", getModelFileOptions.modelFormat());
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
   * @return a {@link ServiceCall} with a response type of {@link ImageDetailsList}
   */
  public ServiceCall<ImageDetailsList> addImages(AddImagesOptions addImagesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addImagesOptions, "addImagesOptions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.isTrue(
        (addImagesOptions.imagesFile() != null)
            || (addImagesOptions.imageUrl() != null)
            || (addImagesOptions.trainingData() != null),
        "At least one of imagesFile, imageUrl, or trainingData must be supplied.");
    String[] pathSegments = {"v4/collections", "images"};
    String[] pathParameters = {addImagesOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "addImages");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
   * @return a {@link ServiceCall} with a response type of {@link ImageSummaryList}
   */
  public ServiceCall<ImageSummaryList> listImages(ListImagesOptions listImagesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listImagesOptions, "listImagesOptions cannot be null");
    String[] pathSegments = {"v4/collections", "images"};
    String[] pathParameters = {listImagesOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "listImages");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of {@link ImageDetails}
   */
  public ServiceCall<ImageDetails> getImageDetails(GetImageDetailsOptions getImageDetailsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getImageDetailsOptions, "getImageDetailsOptions cannot be null");
    String[] pathSegments = {"v4/collections", "images"};
    String[] pathParameters = {
      getImageDetailsOptions.collectionId(), getImageDetailsOptions.imageId()
    };
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getImageDetails");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteImage(DeleteImageOptions deleteImageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteImageOptions, "deleteImageOptions cannot be null");
    String[] pathSegments = {"v4/collections", "images"};
    String[] pathParameters = {deleteImageOptions.collectionId(), deleteImageOptions.imageId()};
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteImage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a JPEG file of an image.
   *
   * <p>Download a JPEG representation of an image.
   *
   * @param getJpegImageOptions the {@link GetJpegImageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link InputStream}
   */
  public ServiceCall<InputStream> getJpegImage(GetJpegImageOptions getJpegImageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getJpegImageOptions, "getJpegImageOptions cannot be null");
    String[] pathSegments = {"v4/collections", "images", "jpeg"};
    String[] pathParameters = {getJpegImageOptions.collectionId(), getJpegImageOptions.imageId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getJpegImage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "image/jpeg");
    if (getJpegImageOptions.size() != null) {
      builder.query("size", getJpegImageOptions.size());
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
   * @return a {@link ServiceCall} with a response type of {@link ObjectMetadataList}
   */
  public ServiceCall<ObjectMetadataList> listObjectMetadata(
      ListObjectMetadataOptions listObjectMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        listObjectMetadataOptions, "listObjectMetadataOptions cannot be null");
    String[] pathSegments = {"v4/collections", "objects"};
    String[] pathParameters = {listObjectMetadataOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "listObjectMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of {@link UpdateObjectMetadata}
   */
  public ServiceCall<UpdateObjectMetadata> updateObjectMetadata(
      UpdateObjectMetadataOptions updateObjectMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateObjectMetadataOptions, "updateObjectMetadataOptions cannot be null");
    String[] pathSegments = {"v4/collections", "objects"};
    String[] pathParameters = {
      updateObjectMetadataOptions.collectionId(), updateObjectMetadataOptions.object()
    };
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "updateObjectMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
   * @return a {@link ServiceCall} with a response type of {@link ObjectMetadata}
   */
  public ServiceCall<ObjectMetadata> getObjectMetadata(
      GetObjectMetadataOptions getObjectMetadataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getObjectMetadataOptions, "getObjectMetadataOptions cannot be null");
    String[] pathSegments = {"v4/collections", "objects"};
    String[] pathParameters = {
      getObjectMetadataOptions.collectionId(), getObjectMetadataOptions.object()
    };
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getObjectMetadata");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteObject(DeleteObjectOptions deleteObjectOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteObjectOptions, "deleteObjectOptions cannot be null");
    String[] pathSegments = {"v4/collections", "objects"};
    String[] pathParameters = {deleteObjectOptions.collectionId(), deleteObjectOptions.object()};
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteObject");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of {@link Collection}
   */
  public ServiceCall<Collection> train(TrainOptions trainOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(trainOptions, "trainOptions cannot be null");
    String[] pathSegments = {"v4/collections", "train"};
    String[] pathParameters = {trainOptions.collectionId()};
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "train");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

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
   * @return a {@link ServiceCall} with a response type of {@link TrainingDataObjects}
   */
  public ServiceCall<TrainingDataObjects> addImageTrainingData(
      AddImageTrainingDataOptions addImageTrainingDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addImageTrainingDataOptions, "addImageTrainingDataOptions cannot be null");
    String[] pathSegments = {"v4/collections", "images", "training_data"};
    String[] pathParameters = {
      addImageTrainingDataOptions.collectionId(), addImageTrainingDataOptions.imageId()
    };
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "addImageTrainingData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
   * @return a {@link ServiceCall} with a response type of {@link TrainingEvents}
   */
  public ServiceCall<TrainingEvents> getTrainingUsage(
      GetTrainingUsageOptions getTrainingUsageOptions) {
    String[] pathSegments = {"v4/training_usage"};
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "getTrainingUsage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getTrainingUsageOptions != null) {
      if (getTrainingUsageOptions.startTime() != null) {
        builder.query("start_time", getTrainingUsageOptions.startTime());
      }
      if (getTrainingUsageOptions.endTime() != null) {
        builder.query("end_time", getTrainingUsageOptions.endTime());
      }
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
   * @return a {@link ServiceCall} with a response type of {@link TrainingEvents}
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
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteUserData(DeleteUserDataOptions deleteUserDataOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteUserDataOptions, "deleteUserDataOptions cannot be null");
    String[] pathSegments = {"v4/user_data"};
    RequestBuilder builder =
        RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("watson_vision_combined", "v4", "deleteUserData");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("customer_id", deleteUserDataOptions.customerId());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }
}
