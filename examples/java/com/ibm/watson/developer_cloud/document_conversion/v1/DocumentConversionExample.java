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
package com.ibm.watson.developer_cloud.document_conversion.v1;

import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.document_conversion.v1.helpers.ConversionUtils;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Example class that shows the various usage scenario's of the Document Conversion service
 */
public class DocumentConversionExample{

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        DocumentConversion service = new DocumentConversion();
        service.setUsernameAndPassword("<username>", "<password>");

        // ## Scenario 1: Convert a document without persistence ##
        File html = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
        File pdf = new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf");
        File doc = new File("src/test/resources/document_conversion/word-document-heading-input.doc");

        System.out.println("-------------------- Convert html document to Answers ----------------------");
        Answers htmlToAnswers = service.convertDocumentToAnswer(html);
        System.out.println("HTML converted to Answers:\n" + htmlToAnswers);

        System.out.println("-------------------- Convert html document to Normalized HTML ----------------------");
        String htmlToNormHtml = ConversionUtils.writeInputStreamToString(service.convertDocument(html, ConversionTarget.NORMALIZED_HTML));
        System.out.println("HTML converted to Normalized HTML:\n" + htmlToNormHtml);

        System.out.println("-------------------- Convert html document to Normalized Text ----------------------");
        String htmlToNormText = ConversionUtils.writeInputStreamToString(service.convertDocument(html, ConversionTarget.NORMALIZED_TEXT));

        System.out.println("HTML converted to Normalized Text:\n" + htmlToNormText);

        System.out.println("-------------------- Convert pdf document to Answers ----------------------");
        Answers pdfToAnswers = service.convertDocumentToAnswer(pdf);
        System.out.println("PDF converted to Answers:\n" + pdfToAnswers);

        System.out.println("-------------------- Convert MS Word document to Answers ----------------------");
        Answers docToAnswers = service.convertDocumentToAnswer(doc);
        System.out.println("MS Word converted to Answers:\n" + docToAnswers);

        // ## Scenario 2: Convert a document using a batch operation ##
        // Step 1. Upload a document
        System.out.println("-------------------- Upload a document ------------------------------");
        File tempFile1 = new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf");
        Document doc1 = service.uploadDocument(tempFile1);
        System.out.println("1st document uploaded : \n"+ doc1);

        Thread.sleep(1000);
        Date since = new Date();
        Thread.sleep(1000);

        File tempFile2 = new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
        Document doc2 = service.uploadDocument(tempFile2);
        System.out.println("2nd document uploaded : \n" + doc2);

        System.out.println("-------------------- Document Collection ------------------------------");
        Map<String, Object> docListParams = new HashMap<String, Object>();
        docListParams.put(DocumentConversion.LIMIT, 10);
        docListParams.put(DocumentConversion.NAME, "html-with-extra-content-input.htm");
        docListParams.put(DocumentConversion.SINCE, since);
        docListParams.put(DocumentConversion.MEDIA_TYPE, "text/html");
        DocumentCollection documentCollection = service.getDocumentCollection(docListParams);
        System.out.println("List of documents with the filtered parameters :\n" + documentCollection);

        // Step 1.1 Get a document
        System.out.println("-------------------- Get a document ------------------------------");
        InputStream is = service.getDocument(doc2.getId());
        System.out.println("Get document 2:\n" + ConversionUtils.writeInputStreamToString(is));

        // Step 2. Create a batch
        System.out.println("-------------------- Create a batch ------------------------------");
        List<Property> propertyList = Arrays.asList(
                new Property("media_type", "html"), new Property("num_docs", "2"));
        Batch batch = service.createBatch("batch_new_name", propertyList);
        System.out.println("Create Batch :\n" + batch);
        System.out.println("Batch was created successfully with id = " + batch.getId());

        // Step 2. Get a batch
        System.out.println("-------------------- Get a batch ------------------------------");
        System.out.println("Get Batch :\n" + service.getBatch(batch.getId()));

        // Step 2.1 Update a batch
        System.out.println("-------------------- Update a batch  ------------------------------");
        System.out.println("Update Batch :\n" + service.updateBatch(batch.getId(), "batch_NEW_name", null));

        System.out.println("-------------------- Batch Collection ------------------------------");
        Map<String, Object> batchListParams = new HashMap<String, Object>();
        batchListParams.put(DocumentConversion.LIMIT, 2);
        BatchCollection batchCollection = service.getBatchCollection(batchListParams);
        System.out.println("Batch Collection with 2 items in a page :\n" + batchCollection);

        // Step 3. Add the document to the batch
        String batchId2 = batch.getId();
        System.out.println("----------------------- Add document to the batch -----------------------");
        System.out.println("\n"+ service.addDocumentToBatch(batchId2, doc1.getId()));
        System.out.println("\n"+ service.addDocumentToBatch(batchId2, doc2.getId()));

        System.out.println("-------------------- Batch Document Collection ------------------------------");
        BatchDocumentCollection batchDocumentCollection = service.getBatchDocumentCollection(batchId2);
        System.out.println("The list of documents from the batch :\n" + batchDocumentCollection);

        // Step 3.1 Get a document from the batch
        System.out.println("-------------------- Get a document from batch ------------------------------");
        BatchDocumentResponse batchDocumentResponse = service.getBatchDocument(batchId2, doc2.getId());
        System.out.println("Get documents from the batch :\n" + batchDocumentResponse);

        // Step 4. Create a job
        System.out.println("-------------------- Create a job ------------------------------");
        JobResponse jobResponse = service.createJob("Job 1", batch.getId(), ConversionTarget.ANSWER_UNITS);
        System.out.println("Create a job for the batch :\n" + jobResponse);

        // Step 4.1 Create a job with a custom config
        JsonObject customJobConfig = new JsonObject();
        JsonObject configOptions = new JsonObject();
        configOptions.addProperty("selector", "h3");
        configOptions.addProperty("output.content-types", "text/plain,text/html");
        customJobConfig.add("html-to-pau", configOptions);
        JobResponse jobWithConfigResponse = service.createJob("JobWithCustomConfig",
                batch.getId(), ConversionTarget.ANSWER_UNITS, customJobConfig);
        System.out.println("Create a job with a custom config for the batch :\n" + jobWithConfigResponse);

        System.out.println("-------------------- Job Collection ------------------------------");
        JobCollection jobCollection = service.getJobCollection();
        System.out.println("List of all the jobs :\n" + jobCollection);

        // Step 4.2 Get job
        System.out.println("-------------------- Get a job ------------------------------");
        Job job = service.getJob(jobResponse.getId());
        System.out.println("Get job 1:\n" + job);

        // Wait for the job to get into a Complete state (5 seconds max)
        long maxWaitTimeMilliSeconds = 5000;
        long currentWaitTimeMilliSeconds = 0;
        long waitIntervalMilliSeconds = 100;
        while( !JobStatus.COMPLETE.equals(service.getJob(jobResponse.getId()).getStatus())
                && currentWaitTimeMilliSeconds < maxWaitTimeMilliSeconds ) {
            try {
                Thread.sleep(waitIntervalMilliSeconds);
            } catch (InterruptedException e) {
                // No Action, keep waiting
            } finally {
                currentWaitTimeMilliSeconds += waitIntervalMilliSeconds;
            }
        }

        // Step 5. Get Job Logs
        System.out.println("-------------------- Get the logs for the job ------------------------------");
        String jobLog = ConversionUtils.writeInputStreamToString(service.getJobLog(job.getId()));
        System.out.println("Get logs for Job 1:\n" + jobLog);

        // Step 6. Get Output Collection
        System.out.println("-------------------- Output Collection ------------------------------");
        OutputCollection outputCollection = service.getOutputCollection();
        System.out.println("Get Output Collection:\n" + outputCollection);

        System.out.println("-------------------- Output Collection for Job ------------------------------");
        Map<String, Object> outputListParams = new HashMap<String, Object>();
        outputListParams.put(DocumentConversion.LIMIT, 5);
        outputListParams.put(DocumentConversion.JOB_ID, job.getId());
        OutputCollection job1OutputCollection = service.getOutputCollection(outputListParams);
        System.out.println("Get Output Collection for Job 1:\n" + job1OutputCollection);

        // Step 6.1 Get Output for Job 1
        System.out.println("-------------------- Output for Job 1 ------------------------------");
        List<Output> job1Outputs = job1OutputCollection.getOutputs();
        for (int i = 0; i < job1Outputs.size(); i++) {
            String outputId = job1Outputs.get(i).getId();
            String job1Output = ConversionUtils.writeInputStreamToString(service.getOutput(outputId));
            System.out.println("Job 1, Output " + (i+1) + ":\n" + job1Output);
        }

        // Step 7. Convert Document for existing document
        System.out.println("-------------------- Convert existing document to Answers ----------------------");
        Answers convertDoc1ToAnswers = service.convertDocumentToAnswer(doc1.getId());
        System.out.println("Doc 1 converted to Answers:\n" + convertDoc1ToAnswers);

        System.out.println("-------------------- Convert existing document to Normalized HTML ----------------------");
        String convertDoc1ToNormHtml = ConversionUtils.writeInputStreamToString(service.convertDocument(doc1.getId(), ConversionTarget.NORMALIZED_HTML));
        System.out.println("Doc 1 converted to Normalized HTML:\n" + convertDoc1ToNormHtml);

        System.out.println("-------------------- Convert existing document to Normalized Text ----------------------");
        String convertDoc1ToNormText = ConversionUtils.writeInputStreamToString(service.convertDocument(doc1.getId(), ConversionTarget.NORMALIZED_TEXT));
        System.out.println("Doc 1 converted to Normalized Text:\n" + convertDoc1ToNormText);
    }
}
