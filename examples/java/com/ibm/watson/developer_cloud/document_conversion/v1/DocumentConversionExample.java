/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.watson.developer_cloud.document_conversion.v1;

import java.io.File;

import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;

/**
 * Example class that shows the various usage scenario's of the Document Conversion service
 */
public class DocumentConversionExample {

  public static void main(String[] args) {
    final DocumentConversion service =
        new DocumentConversion(DocumentConversion.VERSION_DATE_2015_12_01);
    service.setUsernameAndPassword("<username>", "<password>");

    final File html =
        new File("src/test/resources/document_conversion/html-with-extra-content-input.htm");
    final File pdf = new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf");
    final File doc =
        new File("src/test/resources/document_conversion/word-document-heading-input.doc");

    System.out.println("Convert html document to Answers");
    final Answers htmlToAnswers = service.convertDocumentToAnswer(html);
    System.out.println(htmlToAnswers);

    System.out.println("Convert pdf document to Normalized HTML");
    final String normalizedHTML = service.convertDocumentToHTML(pdf);
    System.out.println(normalizedHTML);

    System.out.println("Convert html document to Normalized Text");
    final String normalizedText = service.convertDocumentToText(doc);
    System.out.println(normalizedText);

  }
}
