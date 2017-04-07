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
 * Heading settings in a PDF or Word document.
 *
 * @see Pdf
 * @see Word
 */
public class Heading extends GenericModel {
    @SerializedName(ConfigurationManager.FONT_SETTINGS)
    private List<FontSetting> fontSettings;
    @SerializedName(ConfigurationManager.FONT_STYLES)
    private List<FontStyles> fontStyles;

    public List<FontSetting> getFontSettings() {
        return fontSettings;
    }

    public List<FontStyles> getFontStyles() {
        return fontStyles;
    }
}
