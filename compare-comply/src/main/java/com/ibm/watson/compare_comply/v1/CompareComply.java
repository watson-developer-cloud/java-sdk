/*
 * (C) Copyright IBM Corp. 2019, 2020.
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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-be3b4618-20201201-123423
 */

package com.ibm.watson.compare_comply.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.compare_comply.v1.model.AddFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.BatchStatus;
import com.ibm.watson.compare_comply.v1.model.Batches;
import com.ibm.watson.compare_comply.v1.model.ClassifyElementsOptions;
import com.ibm.watson.compare_comply.v1.model.ClassifyReturn;
import com.ibm.watson.compare_comply.v1.model.CompareDocumentsOptions;
import com.ibm.watson.compare_comply.v1.model.CompareReturn;
import com.ibm.watson.compare_comply.v1.model.ConvertToHtmlOptions;
import com.ibm.watson.compare_comply.v1.model.CreateBatchOptions;
import com.ibm.watson.compare_comply.v1.model.DeleteFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.ExtractTablesOptions;
import com.ibm.watson.compare_comply.v1.model.FeedbackDeleted;
import com.ibm.watson.compare_comply.v1.model.FeedbackList;
import com.ibm.watson.compare_comply.v1.model.FeedbackReturn;
import com.ibm.watson.compare_comply.v1.model.GetBatchOptions;
import com.ibm.watson.compare_comply.v1.model.GetFeedback;
import com.ibm.watson.compare_comply.v1.model.GetFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.HTMLReturn;
import com.ibm.watson.compare_comply.v1.model.ListBatchesOptions;
import com.ibm.watson.compare_comply.v1.model.ListFeedbackOptions;
import com.ibm.watson.compare_comply.v1.model.TableReturn;
import com.ibm.watson.compare_comply.v1.model.UpdateBatchOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&amp;trade; Compare and Comply analyzes governing documents to provide details about
 * critical aspects of the documents.
 *
 * @version v1
 * @see <a href="https://cloud.ibm.com/docs/compare-comply?topic=compare-comply-about">Compare
 *     Comply</a>
 */

 /**
 * @deprecated On 30 November 2021, Compare and Comply will no longer be available. 
 *     For more information, see Compare and Comply Deprecation
 *     (https://github.com/watson-developer-cloud/java-sdk#compare-and-comply-deprecation).
 */
@Deprecated
public class CompareComply extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "compare-comply";

  public static final String DEFAULT_SERVICE_URL =
      "https://api.us-south.compare-comply.watson.cloud.ibm.com";

  private String version;

  /**
   * Constructs an instance of the `CompareComply` client. The default service name is used to
   * configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2018-10-15`.
   */
  public CompareComply(String version) {
    this(
        version,
        DEFAULT_SERVICE_NAME,
        ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
  }

  /**
   * Constructs an instance of the `CompareComply` client. The default service name and specified
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2018-10-15`.
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public CompareComply(String version, Authenticator authenticator) {
    this(version, DEFAULT_SERVICE_NAME, authenticator);
  }

  /**
   * Constructs an instance of the `CompareComply` client. The specified service name is used to
   * configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2018-10-15`.
   * @param serviceName the service name to be used when configuring the client instance
   */
  public CompareComply(String version, String serviceName) {
    this(version, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
  }

  /**
   * Constructs an instance of the `CompareComply` client. The specified service name and
   * authenticator are used to configure the client instance.
   *
   * @param version Release date of the version of the API you want to use. Specify dates in
   *     YYYY-MM-DD format. The current version is `2018-10-15`.
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public CompareComply(String version, String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
    setVersion(version);
    this.configureService(serviceName);

    System.err.println(
        "On 30 November 2021, Compare and Comply will no longer be available."
            + "\nFor more information, see Compare and Comply Deprecation "
            + "(https://github.com/watson-developer-cloud/java-sdk#compare-and-comply-deprecation).");
  }

  /**
   * Gets the version.
   *
   * <p>Release date of the version of the API you want to use. Specify dates in YYYY-MM-DD format.
   * The current version is `2018-10-15`.
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
   * Convert document to HTML.
   *
   * <p>Converts a document to HTML.
   *
   * @param convertToHtmlOptions the {@link ConvertToHtmlOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link HTMLReturn}
   */
  public ServiceCall<HTMLReturn> convertToHtml(ConvertToHtmlOptions convertToHtmlOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        convertToHtmlOptions, "convertToHtmlOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/html_conversion"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("compare-comply", "v1", "convertToHtml");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (convertToHtmlOptions.model() != null) {
      builder.query("model", String.valueOf(convertToHtmlOptions.model()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody fileBody =
        RequestUtils.inputStreamBody(
            convertToHtmlOptions.file(), convertToHtmlOptions.fileContentType());
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<HTMLReturn> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<HTMLReturn>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Classify the elements of a document.
   *
   * <p>Analyzes the structural and semantic elements of a document.
   *
   * @param classifyElementsOptions the {@link ClassifyElementsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link ClassifyReturn}
   */
  public ServiceCall<ClassifyReturn> classifyElements(
      ClassifyElementsOptions classifyElementsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        classifyElementsOptions, "classifyElementsOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(
            RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/element_classification"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("compare-comply", "v1", "classifyElements");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (classifyElementsOptions.model() != null) {
      builder.query("model", String.valueOf(classifyElementsOptions.model()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody fileBody =
        RequestUtils.inputStreamBody(
            classifyElementsOptions.file(), classifyElementsOptions.fileContentType());
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<ClassifyReturn> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<ClassifyReturn>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Extract a document's tables.
   *
   * <p>Analyzes the tables in a document.
   *
   * @param extractTablesOptions the {@link ExtractTablesOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link TableReturn}
   */
  public ServiceCall<TableReturn> extractTables(ExtractTablesOptions extractTablesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        extractTablesOptions, "extractTablesOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/tables"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("compare-comply", "v1", "extractTables");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (extractTablesOptions.model() != null) {
      builder.query("model", String.valueOf(extractTablesOptions.model()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody fileBody =
        RequestUtils.inputStreamBody(
            extractTablesOptions.file(), extractTablesOptions.fileContentType());
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<TableReturn> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<TableReturn>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Compare two documents.
   *
   * <p>Compares two input documents. Documents must be in the same format.
   *
   * @param compareDocumentsOptions the {@link CompareDocumentsOptions} containing the options for
   *     the call
   * @return a {@link ServiceCall} with a result of type {@link CompareReturn}
   */
  public ServiceCall<CompareReturn> compareDocuments(
      CompareDocumentsOptions compareDocumentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        compareDocumentsOptions, "compareDocumentsOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/comparison"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("compare-comply", "v1", "compareDocuments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (compareDocumentsOptions.file1Label() != null) {
      builder.query("file_1_label", String.valueOf(compareDocumentsOptions.file1Label()));
    }
    if (compareDocumentsOptions.file2Label() != null) {
      builder.query("file_2_label", String.valueOf(compareDocumentsOptions.file2Label()));
    }
    if (compareDocumentsOptions.model() != null) {
      builder.query("model", String.valueOf(compareDocumentsOptions.model()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody file1Body =
        RequestUtils.inputStreamBody(
            compareDocumentsOptions.file1(), compareDocumentsOptions.file1ContentType());
    multipartBuilder.addFormDataPart("file_1", "filename", file1Body);
    okhttp3.RequestBody file2Body =
        RequestUtils.inputStreamBody(
            compareDocumentsOptions.file2(), compareDocumentsOptions.file2ContentType());
    multipartBuilder.addFormDataPart("file_2", "filename", file2Body);
    builder.body(multipartBuilder.build());
    ResponseConverter<CompareReturn> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<CompareReturn>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add feedback.
   *
   * <p>Adds feedback in the form of _labels_ from a subject-matter expert (SME) to a governing
   * document. **Important:** Feedback is not immediately incorporated into the training model, nor
   * is it guaranteed to be incorporated at a later date. Instead, submitted feedback is used to
   * suggest future updates to the training model.
   *
   * @param addFeedbackOptions the {@link AddFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link FeedbackReturn}
   */
  public ServiceCall<FeedbackReturn> addFeedback(AddFeedbackOptions addFeedbackOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        addFeedbackOptions, "addFeedbackOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/feedback"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "addFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    final JsonObject contentJson = new JsonObject();
    contentJson.add(
        "feedback_data",
        com.ibm.cloud.sdk.core.util.GsonSingleton.getGson()
            .toJsonTree(addFeedbackOptions.feedbackData()));
    if (addFeedbackOptions.userId() != null) {
      contentJson.addProperty("user_id", addFeedbackOptions.userId());
    }
    if (addFeedbackOptions.comment() != null) {
      contentJson.addProperty("comment", addFeedbackOptions.comment());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<FeedbackReturn> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<FeedbackReturn>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List the feedback in a document.
   *
   * <p>Lists the feedback in a document.
   *
   * @param listFeedbackOptions the {@link ListFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link FeedbackList}
   */
  public ServiceCall<FeedbackList> listFeedback(ListFeedbackOptions listFeedbackOptions) {
    if (listFeedbackOptions == null) {
      listFeedbackOptions = new ListFeedbackOptions.Builder().build();
    }
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/feedback"));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("compare-comply", "v1", "listFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (listFeedbackOptions.feedbackType() != null) {
      builder.query("feedback_type", String.valueOf(listFeedbackOptions.feedbackType()));
    }
    if (listFeedbackOptions.documentTitle() != null) {
      builder.query("document_title", String.valueOf(listFeedbackOptions.documentTitle()));
    }
    if (listFeedbackOptions.modelId() != null) {
      builder.query("model_id", String.valueOf(listFeedbackOptions.modelId()));
    }
    if (listFeedbackOptions.modelVersion() != null) {
      builder.query("model_version", String.valueOf(listFeedbackOptions.modelVersion()));
    }
    if (listFeedbackOptions.categoryRemoved() != null) {
      builder.query("category_removed", String.valueOf(listFeedbackOptions.categoryRemoved()));
    }
    if (listFeedbackOptions.categoryAdded() != null) {
      builder.query("category_added", String.valueOf(listFeedbackOptions.categoryAdded()));
    }
    if (listFeedbackOptions.categoryNotChanged() != null) {
      builder.query(
          "category_not_changed", String.valueOf(listFeedbackOptions.categoryNotChanged()));
    }
    if (listFeedbackOptions.typeRemoved() != null) {
      builder.query("type_removed", String.valueOf(listFeedbackOptions.typeRemoved()));
    }
    if (listFeedbackOptions.typeAdded() != null) {
      builder.query("type_added", String.valueOf(listFeedbackOptions.typeAdded()));
    }
    if (listFeedbackOptions.typeNotChanged() != null) {
      builder.query("type_not_changed", String.valueOf(listFeedbackOptions.typeNotChanged()));
    }
    if (listFeedbackOptions.pageLimit() != null) {
      builder.query("page_limit", String.valueOf(listFeedbackOptions.pageLimit()));
    }
    if (listFeedbackOptions.cursor() != null) {
      builder.query("cursor", String.valueOf(listFeedbackOptions.cursor()));
    }
    if (listFeedbackOptions.sort() != null) {
      builder.query("sort", String.valueOf(listFeedbackOptions.sort()));
    }
    if (listFeedbackOptions.includeTotal() != null) {
      builder.query("include_total", String.valueOf(listFeedbackOptions.includeTotal()));
    }
    ResponseConverter<FeedbackList> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<FeedbackList>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List the feedback in a document.
   *
   * <p>Lists the feedback in a document.
   *
   * @return a {@link ServiceCall} with a result of type {@link FeedbackList}
   */
  public ServiceCall<FeedbackList> listFeedback() {
    return listFeedback(null);
  }

  /**
   * Get a specified feedback entry.
   *
   * <p>Gets a feedback entry with a specified `feedback_id`.
   *
   * @param getFeedbackOptions the {@link GetFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link GetFeedback}
   */
  public ServiceCall<GetFeedback> getFeedback(GetFeedbackOptions getFeedbackOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getFeedbackOptions, "getFeedbackOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("feedback_id", getFeedbackOptions.feedbackId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/feedback/{feedback_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "getFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (getFeedbackOptions.model() != null) {
      builder.query("model", String.valueOf(getFeedbackOptions.model()));
    }
    ResponseConverter<GetFeedback> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<GetFeedback>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a specified feedback entry.
   *
   * <p>Deletes a feedback entry with a specified `feedback_id`.
   *
   * @param deleteFeedbackOptions the {@link DeleteFeedbackOptions} containing the options for the
   *     call
   * @return a {@link ServiceCall} with a result of type {@link FeedbackDeleted}
   */
  public ServiceCall<FeedbackDeleted> deleteFeedback(DeleteFeedbackOptions deleteFeedbackOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        deleteFeedbackOptions, "deleteFeedbackOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("feedback_id", deleteFeedbackOptions.feedbackId());
    RequestBuilder builder =
        RequestBuilder.delete(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/feedback/{feedback_id}", pathParamsMap));
    Map<String, String> sdkHeaders =
        SdkCommon.getSdkHeaders("compare-comply", "v1", "deleteFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    if (deleteFeedbackOptions.model() != null) {
      builder.query("model", String.valueOf(deleteFeedbackOptions.model()));
    }
    ResponseConverter<FeedbackDeleted> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<FeedbackDeleted>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Submit a batch-processing request.
   *
   * <p>Run Compare and Comply methods over a collection of input documents.
   *
   * <p>**Important:** Batch processing requires the use of the [IBM Cloud Object Storage
   * service](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-about#about-ibm-cloud-object-storage).
   * The use of IBM Cloud Object Storage with Compare and Comply is discussed at [Using batch
   * processing](https://cloud.ibm.com/docs/compare-comply?topic=compare-comply-batching#before-you-batch).
   *
   * @param createBatchOptions the {@link CreateBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> createBatch(CreateBatchOptions createBatchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        createBatchOptions, "createBatchOptions cannot be null");
    RequestBuilder builder =
        RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/batches"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "createBatch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("function", String.valueOf(createBatchOptions.function()));
    if (createBatchOptions.model() != null) {
      builder.query("model", String.valueOf(createBatchOptions.model()));
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody inputCredentialsFileBody =
        RequestUtils.inputStreamBody(createBatchOptions.inputCredentialsFile(), "application/json");
    multipartBuilder.addFormDataPart(
        "input_credentials_file", "filename", inputCredentialsFileBody);
    multipartBuilder.addFormDataPart(
        "input_bucket_location", createBatchOptions.inputBucketLocation());
    multipartBuilder.addFormDataPart("input_bucket_name", createBatchOptions.inputBucketName());
    okhttp3.RequestBody outputCredentialsFileBody =
        RequestUtils.inputStreamBody(
            createBatchOptions.outputCredentialsFile(), "application/json");
    multipartBuilder.addFormDataPart(
        "output_credentials_file", "filename", outputCredentialsFileBody);
    multipartBuilder.addFormDataPart(
        "output_bucket_location", createBatchOptions.outputBucketLocation());
    multipartBuilder.addFormDataPart("output_bucket_name", createBatchOptions.outputBucketName());
    builder.body(multipartBuilder.build());
    ResponseConverter<BatchStatus> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<BatchStatus>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List submitted batch-processing jobs.
   *
   * <p>Lists batch-processing jobs submitted by users.
   *
   * @param listBatchesOptions the {@link ListBatchesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Batches}
   */
  public ServiceCall<Batches> listBatches(ListBatchesOptions listBatchesOptions) {
    RequestBuilder builder =
        RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/batches"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "listBatches");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<Batches> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<Batches>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List submitted batch-processing jobs.
   *
   * <p>Lists batch-processing jobs submitted by users.
   *
   * @return a {@link ServiceCall} with a result of type {@link Batches}
   */
  public ServiceCall<Batches> listBatches() {
    return listBatches(null);
  }

  /**
   * Get information about a specific batch-processing job.
   *
   * <p>Gets information about a batch-processing job with a specified ID.
   *
   * @param getBatchOptions the {@link GetBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> getBatch(GetBatchOptions getBatchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        getBatchOptions, "getBatchOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("batch_id", getBatchOptions.batchId());
    RequestBuilder builder =
        RequestBuilder.get(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/batches/{batch_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "getBatch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    ResponseConverter<BatchStatus> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<BatchStatus>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a pending or active batch-processing job.
   *
   * <p>Updates a pending or active batch-processing job. You can rescan the input bucket to check
   * for new documents or cancel a job.
   *
   * @param updateBatchOptions the {@link UpdateBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> updateBatch(UpdateBatchOptions updateBatchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(
        updateBatchOptions, "updateBatchOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("batch_id", updateBatchOptions.batchId());
    RequestBuilder builder =
        RequestBuilder.put(
            RequestBuilder.resolveRequestUrl(
                getServiceUrl(), "/v1/batches/{batch_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "updateBatch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("version", String.valueOf(this.version));
    builder.query("action", String.valueOf(updateBatchOptions.action()));
    if (updateBatchOptions.model() != null) {
      builder.query("model", String.valueOf(updateBatchOptions.model()));
    }
    ResponseConverter<BatchStatus> responseConverter =
        ResponseConverterUtils.getValue(
            new com.google.gson.reflect.TypeToken<BatchStatus>() {}.getType());
    return createServiceCall(builder.build(), responseConverter);
  }
}
