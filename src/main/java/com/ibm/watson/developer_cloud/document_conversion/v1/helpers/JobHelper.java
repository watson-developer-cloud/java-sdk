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

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.ConversionTarget;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Job;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.JobCollection;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.JobResponse;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.JobStatus;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.HttpHeaders;
import com.ibm.watson.developer_cloud.util.MediaType;
import com.ibm.watson.developer_cloud.util.ResponseUtil;

/**
 * Helper class for all job API calls
 *
 * NOTE: The methods in this class should not be called directly! Please
 * make all calls to the service using the DocumentConversion class.
 *
 * @see DocumentConversion
 */
public class JobHelper {
    
    /** The document service object. */
    @Expose
    private DocumentConversion docConversionService;

    /**
     * Sets the service object.
     *
     * @param docConversionService the doc conversion service
     */
    public JobHelper(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    /**
     * Gets a list of all jobs with optional query parameters for filtering results.
     * GET /v1/jobs
     *
     * @param jobListParams The parameters to be used in the job list service call.
     *                      The parameters - token, limit, since, name, since and status are optional
     * <ul>
     * <li> String token - The reference to the starting element of the requested page which is provided
     *              by the server, pass null to get the first page </li>
     * <li> int limit - The number of jobs to get, pass 0 to use the default limit from server (100) </li>
     * <li> String name - The name of the jobs to get, pass null to exclude this filter </li>
     * <li> Date since - The date to filter on, jobs created on or after the provided date and time format will
     *              be returned, pass null to exclude this filter </li>
     * <li> String status - The status of the job to filter on, pass null to exclude this filter </li>
     * </ul>
     *
     * @return Jobs based on filtering parameters provided
     *
     * @see DocumentConversion#getJobCollection(Map)
     */
    public JobCollection getJobCollection(Map<String, Object> jobListParams) {
        Request request = Request.Get(DocumentConversion.JOBS_PATH);

        if(jobListParams != null) {
            if (jobListParams.get(DocumentConversion.TOKEN) != null) {
                String token = (String) jobListParams.get(DocumentConversion.TOKEN);
                if (!token.isEmpty())
                    request.withQuery(DocumentConversion.TOKEN, token);
            }

            if (jobListParams.get(DocumentConversion.LIMIT) != null) {
                int limit = ((Integer) jobListParams.get(DocumentConversion.LIMIT)).intValue();
                if (limit > 0)
                    request.withQuery(DocumentConversion.LIMIT, limit);
                else
                    request.withQuery(DocumentConversion.LIMIT, DocumentConversion.DEFAULT_LIMIT);
            }

            if (jobListParams.get(DocumentConversion.NAME) != null) {
                String name = (String) jobListParams.get(DocumentConversion.NAME);
                if (!name.isEmpty())
                    request.withQuery(DocumentConversion.NAME, name);
            }

            if (jobListParams.get(DocumentConversion.SINCE) != null) {
                Date since = (Date) jobListParams.get(DocumentConversion.SINCE);
                request.withQuery(DocumentConversion.SINCE, ConversionUtils.convertToISO(since));
            }

            if (jobListParams.get(DocumentConversion.STATUS) != null) {
                String status = ((JobStatus) jobListParams.get(DocumentConversion.STATUS)).toString();
                if (!status.isEmpty())
                    request.withQuery(DocumentConversion.STATUS, status);
            }
        }

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
     * POST /v1/jobs.
     *
     * @param name The name of the job
     * @param batchId The id of the batch to process
     * @param conversionTarget The conversion target to use
     * @param config The configuration to use for the job (optional), pass null to use default config
     * @return JobResponse
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

        HttpRequestBase request = Request.Post(DocumentConversion.JOBS_PATH)
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
     * GET /v1/jobs/{job_id}.
     *
     * @param jobId The id of the job
     * @return Job
     * @see DocumentConversion#getJob(String)
     */
    public Job getJob(final String jobId) {
        if (jobId == null || jobId.isEmpty())
            throw new IllegalArgumentException("job id can not be null or empty");

        HttpRequestBase request = Request.Get(DocumentConversion.JOBS_PATH + "/" + jobId).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            String JobAsJson = ResponseUtil.getString(response);
            Job job = ConversionUtils.getGsonWithIso8601DateDeserializer().fromJson(JobAsJson, Job.class);
            return job;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the job processing log
     * GET /v1/jobs/{job_id}/log.
     *
     * @param jobId The id of the job
     * @return Job's processing log
     * @see DocumentConversion#getJobLog(String)
     */
    public InputStream getJobLog(final String jobId) {
        if (jobId == null || jobId.isEmpty())
            throw new IllegalArgumentException("job id can not be null or empty");

        HttpRequestBase request = Request.Get(DocumentConversion.JOBS_PATH + "/" + jobId + "/log")
                                         .withHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).build();
        try {
            HttpResponse response = docConversionService.execute(request);
            InputStream is = ResponseUtil.getInputStream(response);
            return is;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
