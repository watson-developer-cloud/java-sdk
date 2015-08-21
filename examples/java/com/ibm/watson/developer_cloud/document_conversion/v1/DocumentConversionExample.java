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

import com.ibm.watson.developer_cloud.document_conversion.v1.model.Batch;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

public class DocumentConversionExample {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        DocumentConversion service = new DocumentConversion();
        //service.setUsernameAndPassword("<username>", "<password>");
        File document = null;

        // ## Scenario 1: Convert a document without persistence ##
        //service.convertDocument(document);

        // ## Scenario 2: Convert a document using a batch operation ##
        // Step 1. Upload a document
        String documentId = service.addDocument(document);
        // Step 2. Create a batch
        Batch batch = service.createBatch();
        String batchId = batch.getBatchId();
        System.out.println("Batch was created successfully with id = " + batchId);

        // Step 3. Add the document to the batch
        service.addDocumentToBatch(batchId, documentId);
        // Step 3. Create a new job with the batch
        String jobId = service.createJob(batchId);
        // Step 4. Get information about the job
        String status = service.getJobStatus(jobId);
        // Step 5. Get the converted document output when the job is completed
        if( "COMPLETE".equals(status) ) {
            List<String> output = service.getOutput(jobId);
            System.out.println("Conversion is complete=" + output);
        } else {
            System.out.println("Conversion did not complete, job status=" + status);
        }
    }
}
