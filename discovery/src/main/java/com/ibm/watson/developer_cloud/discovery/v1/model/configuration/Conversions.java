/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.watson.developer_cloud.discovery.v1.model.configuration;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Conversions define the steps associated with various filetypes.
 *
 * @see Pdf
 * @see Word
 * @see Html
 * @see NormalizationOperation (Json)
 */
public class Conversions extends GenericModel {
    @SerializedName(ConfigurationManager.PDF)
    private Pdf pdf;
    @SerializedName(ConfigurationManager.WORD)
    private Word word;
    @SerializedName(ConfigurationManager.HTML)
    private Html html;
    @SerializedName(ConfigurationManager.JSON)
    private List<NormalizationOperation> json;

    public Pdf getPdf() {
        return pdf;
    }

    public Word getWord() {
        return word;
    }

    public Html getHtml() {
        return html;
    }

    public List<NormalizationOperation> getJson() {
        return json;
    }
}
