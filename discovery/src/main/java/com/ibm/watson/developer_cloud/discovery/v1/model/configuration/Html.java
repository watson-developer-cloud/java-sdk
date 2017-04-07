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
 * Configuration options for an HTML document.
 */
public class Html extends GenericModel {
    @SerializedName(ConfigurationManager.EXCLUDE_TAGS_COMPLETELY)
    private List<String> excludeTagsCompletely;
    @SerializedName(ConfigurationManager.EXCLUDE_TAGS_KEEP_CONTENT)
    private List<String> excludeTagsKeepContent;
    @SerializedName(ConfigurationManager.KEEP_CONTENT)
    private ContentSelector keepContent;
    @SerializedName(ConfigurationManager.EXCLUDE_CONTENT)
    private ContentSelector excludeContent;
    @SerializedName(ConfigurationManager.KEEP_TAG_ATTRIBUTES)
    private List<String> keepTagAttributes;
    @SerializedName(ConfigurationManager.EXCLUDE_TAG_ATTRIBUTES)
    private List<String> excludeTagAttributes;

    public List<String> getExcludeTagsCompletely() {
        return excludeTagsCompletely;
    }

    public List<String> getExcludeTagsKeepContent() {
        return excludeTagsKeepContent;
    }

    public ContentSelector getKeepContent() {
        return keepContent;
    }

    public ContentSelector getExcludeContent() {
        return excludeContent;
    }

    public List<String> getKeepTagAttributes() {
        return keepTagAttributes;
    }

    public List<String> getExcludeTagAttributes() {
        return excludeTagAttributes;
    }
}
