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
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Batch;
import com.ibm.watson.developer_cloud.service.Request;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.tone_analyzer.v1.model.Tone;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.ibm.watson.developer_cloud.util.ResponseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The IBM Watson Document Conversion service converts provided source
 * documents (HTML, Word, PDF) into JSON Answer Units, Normalized HTML,
 * or Normalized Text.
 *
 * @version v1
 * @see <a
 *      href="http://www.ibm.com/smarterplanet/us/en/ibmwatson/developercloud/document-conversion.html">
 *      Tone Analyzer</a>
 */
public class DocumentConversion extends WatsonService {

    /** The Constant URL. */
    //private static final String URL = "https://gateway.watsonplatform.net/document-conversion/api";
    private static final String URL = "http://localhost:8187/api";

    public DocumentConversion() {
        setEndPoint(URL);
    }

    public void convertDocument(File document) {
        System.out.println("Your document (" + document + ") has been converted!");
    }

    public String addDocument(File document) {
        return "documentId";
    }

    public Batch createBatch() {
        JsonObject contentJson = new JsonObject();

        HttpRequestBase request = Request.Post("/v1/batches")
                .withContent(contentJson).build();

        try {
            HttpResponse response = execute(request);
            String batchAsJson = ResponseUtil.getString(response);
            Batch batch = GsonSingleton.getGson().fromJson(batchAsJson, Batch.class);
            return batch;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDocumentToBatch(String batchId, String documentId) {
        // Add the document to the batch
    }

    public String createJob(String batchId) {
        return "jobId";
    }

    public String getJobStatus(String jobId) {
        return "COMPLETE";
    }

    public List<String> getOutput(String jobId) {
        return new ArrayList<String>();
    }

}
