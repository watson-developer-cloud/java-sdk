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
package com.ibm.watson.developer_cloud.visual_recognition.v2;

import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualRecognitionImages;

import java.io.File;

public class VisualRecognitionExample {

  public static void main(String[] args) {
    VisualRecognition service = new VisualRecognition();
    service.setUsernameAndPassword("<username>", "<password>");

    File image = new File("src/test/resources/visual_recognition/eiffel-tower.jpg");

    VisualRecognitionImages recognizedImage = service.recognize(image);
    System.out.println(recognizedImage);

  }
}
