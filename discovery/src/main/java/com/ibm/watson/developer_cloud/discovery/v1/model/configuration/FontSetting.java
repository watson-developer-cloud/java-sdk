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

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.service.model.GenericModel;

/**
 * Contains basic settings for a font.
 */
public class FontSetting extends GenericModel {
    @SerializedName(ConfigurationManager.LEVEL)
    private Number level;
    @SerializedName(ConfigurationManager.MIN_SIZE)
    private Number minSize;
    @SerializedName(ConfigurationManager.MAX_SIZE)
    private Number maxSize;
    @SerializedName(ConfigurationManager.BOLD)
    private boolean bold;
    @SerializedName(ConfigurationManager.ITALIC)
    private boolean italic;
    @SerializedName(ConfigurationManager.FONT_NAME)
    private String fontName;

    public Number getLevel() {
        return level;
    }

    public Number getMinSize() {
        return minSize;
    }

    public Number getMaxSize() {
        return maxSize;
    }

    public boolean isBold() {
        return bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public String getFontName() {
        return fontName;
    }
}
