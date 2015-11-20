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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import com.ibm.watson.developer_cloud.document_conversion.v1.model.Answers;

/**
 * The Class DocumentConversionIntegrationTest.
 */
public class DocumentConversionIntegrationTest extends WatsonServiceTest {

  /** The service. */
  private DocumentConversion service;
  private File[] files;

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new DocumentConversion();
    service.setUsernameAndPassword(prop.getProperty("document_conversion.username"),
        prop.getProperty("document_conversion.password"));
    service.setEndPoint(prop.getProperty("document_conversion.url"));

    files =
        new File[] {
            new File("src/test/resources/document_conversion/word-docx-heading-input.docx"),
            new File("src/test/resources/document_conversion/word-document-heading-input.doc"),
            new File("src/test/resources/document_conversion/pdf-with-sections-input.pdf"),
            new File("src/test/resources/document_conversion/html-with-extra-content-input.htm"),};
  }

  /**
   * Test Convert to answers unit
   */
  @Test
  public void testConvertToAnswers() {
    for (File file : files) {
      Answers answers = service.convertDocumentToAnswer(file);
      Assert.assertNotNull(answers);
      Assert.assertNotNull(answers.getAnswerUnits());
      Assert.assertTrue(!answers.getAnswerUnits().isEmpty());
    }
  }

  /**
   * Test convert to HTML
   */
  @Test
  public void testConvertToHtml() {
    for (File file : files) {
      String html = service.convertDocumentToHTML(file);
      Assert.assertNotNull(html);
      Assert.assertNotEquals(html, "");
    }
  }

  /**
   * Test convert to Text
   */
  @Test
  public void testConvertToText() {
    for (File file : files) {
      String text = service.convertDocumentToText(file);
      Assert.assertNotNull(text);
      Assert.assertNotEquals(text, "");
    }
  }
}
