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

import com.ibm.watson.developer_cloud.document_conversion.v1.model.*;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class DocumentConversionExample{

    public static void main(String[] args) throws URISyntaxException, IOException {
        DocumentConversion service = new DocumentConversion();
        service.setUsernameAndPassword("<username>", "<password>");

        // ## Scenario 1: Convert a document without persistence ##
        // service.convertDocument(document);

        // ## Scenario 2: Convert a document using a batch operation ##
        // Step 1. Upload a document
         System.out.println("-------------------- Upload a document ------------------------------");
         File tempFile1 = createTempFile("sample.txt","This is the new text file");
         Document doc1 = service.uploadDocument(tempFile1);
         System.out.println("1st Document Uploaded : \n"+doc1);

         File tempFile2 = createTempFile("new.html", "<html>\n" +"\t\t<title>Sample html</title>\n"+"\t<body>\n" + "\t\tThis is a sample html file\n" + "\t</body>\n" + "</html>");
         Document doc2 = service.uploadDocument(tempFile2);
         System.out.println("2nd Document Uploaded : \n"+doc2);

         System.out.println("-------------------- Document Collection ------------------------------");
         DocumentCollection documentCollection = service.getDocumentCollection(doc2.getId(), "2", "sample.html", null, "application/octet-stream");
         System.out.println("Document Collection with parameters:\n" + documentCollection);

         // Step 1.1 Get a document
         System.out.println("-------------------- Get a document ------------------------------");
         System.out.println("Get Document 2:\n" + service.getDocument(doc2.getId()));

        // Step 2. Create a batch
         System.out.println("-------------------- Create a batch ------------------------------");
         Batch batch1 = service.createBatch();
         System.out.println("Create Batch 1 :\n" + batch1);
         System.out.println("Batch was created successfully with id = " + batch1.getId());

         List<Property> propertyList = Arrays.asList(
                                               new Property("media_type", "html"), new Property("num_docs", "2"));
         Batch batch2 = service.createBatch("batch_new_name", propertyList);
         System.out.println("Create Batch 2 :\n" + batch2);
         System.out.println("Batch was created successfully with id = " + batch2.getId());

         // Step 2. Get a batch
         System.out.println("-------------------- Get a batch ------------------------------");
         System.out.println("Get a Batch 2 :\n" + service.getBatch(batch2.getId()));

         // Step 2.1 Update a batch
         System.out.println("-------------------- Update a batch  ------------------------------");
         System.out.println("Update a Batch 2 :\n" + service.updateBatch(batch2.getId(), "batch_NEW_name", null));

         System.out.println("-------------------- Batch Collection ------------------------------");
         BatchCollection batchCollection = service.getBatchCollection(batch2.getId(), "2", null, null);
         System.out.println("Batch Collection - Batch list starting from 2nd Batch :\n" + batchCollection);

        // Step 3. Add the document to the batch
        String batchId2 = batch2.getId();
        System.out.println("----------------------- Add document to the batch -----------------------");
        System.out.println("\n"+ service.addDocumentToBatch(batchId2, doc1.getId()));
        System.out.println("\n"+ service.addDocumentToBatch(batchId2, doc2.getId()));

        System.out.println("-------------------- Batch Document Collection ------------------------------");
        BatchDocumentCollection batchDocumentCollection = service.getBatchDocumentCollection(batchId2);
        System.out.println("Batch Document Collection for Batch 2 :\n" + batchDocumentCollection);

        // Step 3.1 Get a document from the batch
        System.out.println("-------------------- Get a document from batch ------------------------------");
        BatchDocumentResponse batchDocumentResponse = service.getBatchDocument(batchId2, doc2.getId());
        System.out.println("Get documents from Batch 2 :\n" + batchDocumentResponse);

        // Step 4. Create a job
        System.out.println("-------------------- Create a job ------------------------------");
        CreateJobResponse createJobResponse = service.createJob("Job 1", batch2.getId(), ConversionTarget.ANSWER_UNITS);
        System.out.println("Create Job for Batch 2:\n" + createJobResponse);

        System.out.println("-------------------- Job Collection ------------------------------");
        JobCollection jobCollection = service.getJobs();
        System.out.println("Job Collection :\n" + jobCollection);

        // Step 4.1 Get job
        System.out.println("-------------------- Get a job ------------------------------");
        Job job = service.getJob(createJobResponse.getId());
        System.out.println("Get Job 1:\n" + job);

        // Wait for the job to get into a Complete state (5 seconds max)
        waitForJobToComplete(job, 5000);

        // Step 5. Get Job Logs
        System.out.println("-------------------- Get a job ------------------------------");
        String jobLog = service.getJobLog(job.getId());
        System.out.println("Get logs for Job 1:\n" + jobLog);

        // Step 6. Get Output Collection
        System.out.println("-------------------- Output Collection ------------------------------");
        OutputCollection outputCollection = service.getOutputCollection();
        System.out.println("Get Output Collection:\n" + outputCollection);

        System.out.println("-------------------- Output Collection for Job ------------------------------");
        OutputCollection job1OutputCollection = service.getOutputCollection(null, 5, null, job.getId(), null);
        System.out.println("Get Output Collection for Job 1:\n" + job1OutputCollection);

        // Step 6.1 Get Output for Job 1
        System.out.println("-------------------- Output for Job 1 ------------------------------");
        List<Output> job1Outputs = job1OutputCollection.getOutput();
        for (int i = 0; i < job1Outputs.size(); i++) {
            String outputId = job1Outputs.get(i).getId();
            String job1Output = service.getOutput(outputId);
            System.out.println("Job 1, Output " + (i+1) + ":\n" + job1Output);
        }

        // Step 7. Convert Document for existing document
        System.out.println("-------------------- Convert existing document to Answer Unit ------------------------------");
        String convertDoc1ToAnswerUnit = service.convertDocument(doc1.getId(), ConversionTarget.ANSWER_UNITS);
        System.out.println("Doc 1 converted to Answer Unit:\n" + convertDoc1ToAnswerUnit);

        System.out.println("-------------------- Convert existing document to Normalized HTML ------------------------------");
        String convertDoc1ToNormHtml = service.convertDocument(doc1.getId(), ConversionTarget.NORMALIZED_HTML);
        System.out.println("Doc 1 converted to Normalized HTML:\n" + convertDoc1ToNormHtml);

        System.out.println("-------------------- Convert existing document to Normalized Text ------------------------------");
        String convertDoc1ToNormText = service.convertDocument(doc1.getId(), ConversionTarget.NORMALIZED_TEXT);
        System.out.println("Doc 1 converted to Normalized Text:\n" + convertDoc1ToNormText);

        deleteTempFiles();
    }

    private static File createTempFile(String fileName, String contents) throws IOException {
        File dir = new File("tmp");
        dir.mkdirs();
        File tmp = new File(dir, fileName);
        tmp.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        bw.write(contents);
        bw.close();
        return tmp;
    }

    private static void deleteTempFiles() {
        File dir = new File("tmp");
        File[] files = dir.listFiles();

        if(files != null) {
            for(File f: files) {
                f.delete();
            }
        }
        dir.delete();
    }

    private static void waitForJobToComplete(Job job, long maxWaitTimeMilliSeconds) {
        long waitTimeMilliSeconds = 0;
        long waitIntervalMilliSeconds = 100;
        while( !JobStatus.COMPLETE.equals(job.getStatus()) && waitTimeMilliSeconds < maxWaitTimeMilliSeconds ) {
            try {
                Thread.sleep(waitIntervalMilliSeconds);
            } catch (InterruptedException e) {
                // No Action
            } finally {
                waitTimeMilliSeconds += waitIntervalMilliSeconds;
            }
        }
    }
}
