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
package com.ibm.watson.developer_cloud.document_conversion.v1.helpers;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;
import com.ibm.watson.developer_cloud.document_conversion.v1.util.ConversionUtils;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.HttpHeaders;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.Date;

/**
 * Helper class for all job API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class JobHelper {
    /**
     * The document service object
     */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object
     *
     * @param docConversionService
     */
    public JobHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Gets a list of all jobs with optional query parameters for filtering results.
     * GET /v1/jobs
     * @param token The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page
     * @param limit The number of jobs to get, pass 0 to use the default limit from server (100)
     * @param name The name of the jobs to get, pass null to exclude this filter
     * @param since The date to filter on, jobs created on or after the provided date and time format will
     *              be returned, pass null to exclude this filter
     * @param status The status of the job to filter on, pass null to exclude this filter
     * @return Jobs based on filtering parameters provided
     *
     * @see DocumentConversion#getJobCollection(String, int, String, Date, JobStatus)
     */
    public JobCollection getJobCollection(final String token, final int limit,
                                          final String name, final Date since, final JobStatus status) {
        Request request = Request.Get("/v1/jobs");

        if (token != null && !token.isEmpty())
            request.withQuery("token", token);

        if (limit > 0)
            request.withQuery("limit", limit);
        else
            request.withQuery("limit", DocumentConversion.LIMIT);

        if (name != null && !name.isEmpty())
            request.withQuery("name", name);

        if (since != null)
            request.withQuery("since", ConversionUtils.convertToISO(since));

        if (status != null)
            request.withQuery("status", status.toString());

        HttpRequestBase requestBase = request.build();
        try {
            HttpResponse response = docConversionService.execute(requestBase);
            String JobsAsJson = ResponseUtil.getString(response);
            JobCollection jobs = GsonSingleton.getGson().fromJson(JobsAsJson, JobCollection.class);
            return jobs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new job by submitting a batch for processing
     * POST /v1/jobs
     * @param name The name of the job
     * @param batchId The id of the batch to process
     * @param conversionTarget The conversion target to use
     * @param config The configuration to use for the job (optional), pass null to use default config
     * @return JobResponse
     *
     * @see DocumentConversion#createJob(String, String, ConversionTarget, JsonObject)
     */
    public JobResponse createJob(final String name, final String batchId,
                         final ConversionTarget conversionTarget, final JsonObject config) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("name can not be null or empty");
        if (batchId == null || batchId.isEmpty())
            throw new IllegalArgumentException("batch id can not be null or empty");
        if (conversionTarget == null)
            throw new IllegalArgumentException("conversion target can not be null");

        JsonObject contentJson = new JsonObject();
        contentJson.addProperty("name", name);
        contentJson.addProperty("batch_id", batchId);
        contentJson.addProperty("conversion_target", conversionTarget.toString());
        if (config != null )
            contentJson.add("config", config);

        HttpRequestBase request = Request.Post("/v1/jobs")
                .withContent(contentJson).build();

        try {
            HttpResponse response = docConversionService.execute(request);
            String JobAsJson = ResponseUtil.getString(response);
            JobResponse job = GsonSingleton.getGson().fromJson(JobAsJson, JobResponse.class);
            return job;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets information about a job
     * GET /v1/jobs/{job_id}
     * @param jobId The id of the job
     * @return Job
     *
     * @see DocumentConversion#getJob(String)
     */
    public Job getJob(final String jobId) {
        if (jobId == null || jobId.isEmpty())
            throw new IllegalArgumentException("job id can not be null or empty");

        HttpRequestBase request = Request.Get("/v1/jobs/" + jobId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String JobAsJson = ResponseUtil.getString(response);
            Job job = GsonSingleton.getGson().fromJson(JobAsJson, Job.class);
            return job;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the job processing log
     * GET /v1/jobs/{job_id}/log
     * @param jobId The id of the job
     * @return Job's processing log
     *
     * @see DocumentConversion#getJobLog(String)
     */
    public String getJobLog(final String jobId) {
        if (jobId == null || jobId.isEmpty())
            throw new IllegalArgumentException("job id can not be null or empty");

        HttpRequestBase request = Request.Get("/v1/jobs/" + jobId + "/log")
                .withHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            return ResponseUtil.getString(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
