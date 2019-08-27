/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.compare_comply.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
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
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * IBM Watson&trade; Compare and Comply analyzes governing documents to provide details about critical aspects of the
 * documents.
 *
 * @version v1
 * @see <a href="https://cloud.ibm.com/docs/services/compare-comply?topic=compare-comply-about">Compare Comply</a>
 */
public class CompareComply extends BaseService {

  private static final String SERVICE_NAME = "compare_comply";
  private static final String URL = "https://gateway.watsonplatform.net/compare-comply/api";

  private String versionDate;

  /**
   * Constructs a new `CompareComply` client with the specified Authenticator.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param authenticator the Authenticator instance to be configured for this service
   */
  public CompareComply(String versionDate, Authenticator authenticator) {
    super(SERVICE_NAME, authenticator);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
    com.ibm.cloud.sdk.core.util.Validator.isTrue((versionDate != null) && !versionDate.isEmpty(),
        "version cannot be null.");
    this.versionDate = versionDate;
  }

  /**
   * Convert document to HTML.
   *
   * Converts a document to HTML.
   *
   * @param convertToHtmlOptions the {@link ConvertToHtmlOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link HTMLReturn}
   */
  public ServiceCall<HTMLReturn> convertToHtml(ConvertToHtmlOptions convertToHtmlOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(convertToHtmlOptions,
        "convertToHtmlOptions cannot be null");
    String[] pathSegments = { "v1/html_conversion" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "convertToHtml");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (convertToHtmlOptions.model() != null) {
      builder.query("model", convertToHtmlOptions.model());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody fileBody = RequestUtils.inputStreamBody(convertToHtmlOptions.file(), convertToHtmlOptions
        .fileContentType());
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<HTMLReturn> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<HTMLReturn>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Classify the elements of a document.
   *
   * Analyzes the structural and semantic elements of a document.
   *
   * @param classifyElementsOptions the {@link ClassifyElementsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ClassifyReturn}
   */
  public ServiceCall<ClassifyReturn> classifyElements(ClassifyElementsOptions classifyElementsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(classifyElementsOptions,
        "classifyElementsOptions cannot be null");
    String[] pathSegments = { "v1/element_classification" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "classifyElements");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (classifyElementsOptions.model() != null) {
      builder.query("model", classifyElementsOptions.model());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody fileBody = RequestUtils.inputStreamBody(classifyElementsOptions.file(), classifyElementsOptions
        .fileContentType());
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<ClassifyReturn> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<ClassifyReturn>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Extract a document's tables.
   *
   * Analyzes the tables in a document.
   *
   * @param extractTablesOptions the {@link ExtractTablesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TableReturn}
   */
  public ServiceCall<TableReturn> extractTables(ExtractTablesOptions extractTablesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(extractTablesOptions,
        "extractTablesOptions cannot be null");
    String[] pathSegments = { "v1/tables" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "extractTables");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (extractTablesOptions.model() != null) {
      builder.query("model", extractTablesOptions.model());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody fileBody = RequestUtils.inputStreamBody(extractTablesOptions.file(), extractTablesOptions
        .fileContentType());
    multipartBuilder.addFormDataPart("file", "filename", fileBody);
    builder.body(multipartBuilder.build());
    ResponseConverter<TableReturn> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<TableReturn>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Compare two documents.
   *
   * Compares two input documents. Documents must be in the same format.
   *
   * @param compareDocumentsOptions the {@link CompareDocumentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link CompareReturn}
   */
  public ServiceCall<CompareReturn> compareDocuments(CompareDocumentsOptions compareDocumentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(compareDocumentsOptions,
        "compareDocumentsOptions cannot be null");
    String[] pathSegments = { "v1/comparison" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "compareDocuments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (compareDocumentsOptions.file1Label() != null) {
      builder.query("file_1_label", compareDocumentsOptions.file1Label());
    }
    if (compareDocumentsOptions.file2Label() != null) {
      builder.query("file_2_label", compareDocumentsOptions.file2Label());
    }
    if (compareDocumentsOptions.model() != null) {
      builder.query("model", compareDocumentsOptions.model());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody file1Body = RequestUtils.inputStreamBody(compareDocumentsOptions.file1(),
        compareDocumentsOptions.file1ContentType());
    multipartBuilder.addFormDataPart("file_1", "filename", file1Body);
    okhttp3.RequestBody file2Body = RequestUtils.inputStreamBody(compareDocumentsOptions.file2(),
        compareDocumentsOptions.file2ContentType());
    multipartBuilder.addFormDataPart("file_2", "filename", file2Body);
    builder.body(multipartBuilder.build());
    ResponseConverter<CompareReturn> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<CompareReturn>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add feedback.
   *
   * Adds feedback in the form of _labels_ from a subject-matter expert (SME) to a governing document.
   * **Important:** Feedback is not immediately incorporated into the training model, nor is it guaranteed to be
   * incorporated at a later date. Instead, submitted feedback is used to suggest future updates to the training model.
   *
   * @param addFeedbackOptions the {@link AddFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link FeedbackReturn}
   */
  public ServiceCall<FeedbackReturn> addFeedback(AddFeedbackOptions addFeedbackOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addFeedbackOptions,
        "addFeedbackOptions cannot be null");
    String[] pathSegments = { "v1/feedback" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "addFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.add("feedback_data", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addFeedbackOptions
        .feedbackData()));
    if (addFeedbackOptions.userId() != null) {
      contentJson.addProperty("user_id", addFeedbackOptions.userId());
    }
    if (addFeedbackOptions.comment() != null) {
      contentJson.addProperty("comment", addFeedbackOptions.comment());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<FeedbackReturn> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<FeedbackReturn>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List the feedback in a document.
   *
   * Lists the feedback in a document.
   *
   * @param listFeedbackOptions the {@link ListFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link FeedbackList}
   */
  public ServiceCall<FeedbackList> listFeedback(ListFeedbackOptions listFeedbackOptions) {
    String[] pathSegments = { "v1/feedback" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "listFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listFeedbackOptions != null) {
      if (listFeedbackOptions.feedbackType() != null) {
        builder.query("feedback_type", listFeedbackOptions.feedbackType());
      }
      if (listFeedbackOptions.before() != null) {
        builder.query("before", String.valueOf(listFeedbackOptions.before()));
      }
      if (listFeedbackOptions.after() != null) {
        builder.query("after", String.valueOf(listFeedbackOptions.after()));
      }
      if (listFeedbackOptions.documentTitle() != null) {
        builder.query("document_title", listFeedbackOptions.documentTitle());
      }
      if (listFeedbackOptions.modelId() != null) {
        builder.query("model_id", listFeedbackOptions.modelId());
      }
      if (listFeedbackOptions.modelVersion() != null) {
        builder.query("model_version", listFeedbackOptions.modelVersion());
      }
      if (listFeedbackOptions.categoryRemoved() != null) {
        builder.query("category_removed", listFeedbackOptions.categoryRemoved());
      }
      if (listFeedbackOptions.categoryAdded() != null) {
        builder.query("category_added", listFeedbackOptions.categoryAdded());
      }
      if (listFeedbackOptions.categoryNotChanged() != null) {
        builder.query("category_not_changed", listFeedbackOptions.categoryNotChanged());
      }
      if (listFeedbackOptions.typeRemoved() != null) {
        builder.query("type_removed", listFeedbackOptions.typeRemoved());
      }
      if (listFeedbackOptions.typeAdded() != null) {
        builder.query("type_added", listFeedbackOptions.typeAdded());
      }
      if (listFeedbackOptions.typeNotChanged() != null) {
        builder.query("type_not_changed", listFeedbackOptions.typeNotChanged());
      }
      if (listFeedbackOptions.pageLimit() != null) {
        builder.query("page_limit", String.valueOf(listFeedbackOptions.pageLimit()));
      }
      if (listFeedbackOptions.cursor() != null) {
        builder.query("cursor", listFeedbackOptions.cursor());
      }
      if (listFeedbackOptions.sort() != null) {
        builder.query("sort", listFeedbackOptions.sort());
      }
      if (listFeedbackOptions.includeTotal() != null) {
        builder.query("include_total", String.valueOf(listFeedbackOptions.includeTotal()));
      }
    }
    ResponseConverter<FeedbackList> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<FeedbackList>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List the feedback in a document.
   *
   * Lists the feedback in a document.
   *
   * @return a {@link ServiceCall} with a response type of {@link FeedbackList}
   */
  public ServiceCall<FeedbackList> listFeedback() {
    return listFeedback(null);
  }

  /**
   * Get a specified feedback entry.
   *
   * Gets a feedback entry with a specified `feedback_id`.
   *
   * @param getFeedbackOptions the {@link GetFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link GetFeedback}
   */
  public ServiceCall<GetFeedback> getFeedback(GetFeedbackOptions getFeedbackOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getFeedbackOptions,
        "getFeedbackOptions cannot be null");
    String[] pathSegments = { "v1/feedback" };
    String[] pathParameters = { getFeedbackOptions.feedbackId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "getFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getFeedbackOptions.model() != null) {
      builder.query("model", getFeedbackOptions.model());
    }
    ResponseConverter<GetFeedback> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<GetFeedback>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a specified feedback entry.
   *
   * Deletes a feedback entry with a specified `feedback_id`.
   *
   * @param deleteFeedbackOptions the {@link DeleteFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link FeedbackDeleted}
   */
  public ServiceCall<FeedbackDeleted> deleteFeedback(DeleteFeedbackOptions deleteFeedbackOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteFeedbackOptions,
        "deleteFeedbackOptions cannot be null");
    String[] pathSegments = { "v1/feedback" };
    String[] pathParameters = { deleteFeedbackOptions.feedbackId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "deleteFeedback");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteFeedbackOptions.model() != null) {
      builder.query("model", deleteFeedbackOptions.model());
    }
    ResponseConverter<FeedbackDeleted> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<FeedbackDeleted>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Submit a batch-processing request.
   *
   * Run Compare and Comply methods over a collection of input documents.
   *
   * **Important:** Batch processing requires the use of the [IBM Cloud Object Storage
   * service](https://cloud.ibm.com/docs/services/cloud-object-storage?topic=cloud-object-storage-about#about-ibm-cloud-object-storage).
   * The use of IBM Cloud Object Storage with Compare and Comply is discussed at [Using batch
   * processing](https://cloud.ibm.com/docs/services/compare-comply?topic=compare-comply-batching#before-you-batch).
   *
   * @param createBatchOptions the {@link CreateBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> createBatch(CreateBatchOptions createBatchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createBatchOptions,
        "createBatchOptions cannot be null");
    String[] pathSegments = { "v1/batches" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "createBatch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("function", createBatchOptions.function());
    if (createBatchOptions.model() != null) {
      builder.query("model", createBatchOptions.model());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    okhttp3.RequestBody inputCredentialsFileBody = RequestUtils.inputStreamBody(createBatchOptions
        .inputCredentialsFile(), "application/json");
    multipartBuilder.addFormDataPart("input_credentials_file", "filename", inputCredentialsFileBody);
    multipartBuilder.addFormDataPart("input_bucket_location", createBatchOptions.inputBucketLocation());
    multipartBuilder.addFormDataPart("input_bucket_name", createBatchOptions.inputBucketName());
    okhttp3.RequestBody outputCredentialsFileBody = RequestUtils.inputStreamBody(createBatchOptions
        .outputCredentialsFile(), "application/json");
    multipartBuilder.addFormDataPart("output_credentials_file", "filename", outputCredentialsFileBody);
    multipartBuilder.addFormDataPart("output_bucket_location", createBatchOptions.outputBucketLocation());
    multipartBuilder.addFormDataPart("output_bucket_name", createBatchOptions.outputBucketName());
    builder.body(multipartBuilder.build());
    ResponseConverter<BatchStatus> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<BatchStatus>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List submitted batch-processing jobs.
   *
   * Lists batch-processing jobs submitted by users.
   *
   * @param listBatchesOptions the {@link ListBatchesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Batches}
   */
  public ServiceCall<Batches> listBatches(ListBatchesOptions listBatchesOptions) {
    String[] pathSegments = { "v1/batches" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "listBatches");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listBatchesOptions != null) {
    }
    ResponseConverter<Batches> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<Batches>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List submitted batch-processing jobs.
   *
   * Lists batch-processing jobs submitted by users.
   *
   * @return a {@link ServiceCall} with a response type of {@link Batches}
   */
  public ServiceCall<Batches> listBatches() {
    return listBatches(null);
  }

  /**
   * Get information about a specific batch-processing job.
   *
   * Gets information about a batch-processing job with a specified ID.
   *
   * @param getBatchOptions the {@link GetBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> getBatch(GetBatchOptions getBatchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getBatchOptions,
        "getBatchOptions cannot be null");
    String[] pathSegments = { "v1/batches" };
    String[] pathParameters = { getBatchOptions.batchId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "getBatch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<BatchStatus> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<BatchStatus>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a pending or active batch-processing job.
   *
   * Updates a pending or active batch-processing job. You can rescan the input bucket to check for new documents or
   * cancel a job.
   *
   * @param updateBatchOptions the {@link UpdateBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> updateBatch(UpdateBatchOptions updateBatchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateBatchOptions,
        "updateBatchOptions cannot be null");
    String[] pathSegments = { "v1/batches" };
    String[] pathParameters = { updateBatchOptions.batchId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query("version", versionDate);
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("compare-comply", "v1", "updateBatch");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("action", updateBatchOptions.action());
    if (updateBatchOptions.model() != null) {
      builder.query("model", updateBatchOptions.model());
    }
    ResponseConverter<BatchStatus> responseConverter = ResponseConverterUtils.getValue(
        new com.google.gson.reflect.TypeToken<BatchStatus>() {
        }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
