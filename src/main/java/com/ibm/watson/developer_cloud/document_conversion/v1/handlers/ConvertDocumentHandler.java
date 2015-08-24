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
package com.ibm.watson.developer_cloud.document_conversion.v1.handlers;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;

import java.io.File;

public class ConvertDocumentHandler {

    private DocumentConversion docConversionService;

    public ConvertDocumentHandler(DocumentConversion docConversionService) {
        this.docConversionService = docConversionService;
    }

    public String convertDocument(File document) {
        return null;
    }

    public String convertDocument(String documentId) {
        return null;
    }
}
