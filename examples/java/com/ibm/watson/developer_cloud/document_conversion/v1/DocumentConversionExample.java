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

        // Step 3. Create a new job with the batch
        //String jobId = service.createJob(batchId);
        // Step 4. Get information about the job
        //String status = service.getJob(jobId).toString();
        // Step 5. Get the converted document output when the job is completed
        //if( "COMPLETE".equals(status) ) {
            //Output output = service.getOutput(jobId);
            //System.out.println("Conversion is complete=" + output);
        //} else {
            //System.out.println("Conversion did not complete, job status=" + status);
        //}
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
}
