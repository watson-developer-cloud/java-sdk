/**
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests associated with the WatsonService core class.
 *
 */
public class WatsonServiceTest {


    @Test
    public void testMimeTypes() {
        assertTrue(WatsonService.isJsonMimeType("application/json"));
        assertTrue(WatsonService.isJsonMimeType("application/json; charset=utf-8"));
        assertTrue(WatsonService.isJsonMimeType("application/json;charset=utf-8"));
        assertTrue(WatsonService.isJsonMimeType("APPLICATION/JSON;charset=utf-16"));
        assertFalse(WatsonService.isJsonMimeType("application/notjson"));
        assertFalse(WatsonService.isJsonMimeType("application/json-patch+json"));
        assertFalse(WatsonService.isJsonMimeType("APPlication/JSON-patCH+jSoN;charset=utf-8"));
        assertTrue(WatsonService.isJsonPatchMimeType("APPlication/JSON-patCH+jSoN;charset=utf-8"));
        assertTrue(WatsonService.isJsonMimeType("application/merge-patch+json"));
        assertTrue(WatsonService.isJsonMimeType("application/merge-patch+json;charset=utf-8"));
        assertFalse(WatsonService.isJsonMimeType("application/json2-patch+json"));
        assertFalse(WatsonService.isJsonMimeType("application/merge-patch+json-blah"));
        assertFalse(WatsonService.isJsonMimeType("application/merge patch json"));

        assertTrue(WatsonService.isJsonPatchMimeType("application/json-patch+json"));
        assertTrue(WatsonService.isJsonPatchMimeType("application/json-patch+json;charset=utf-8"));
        assertFalse(WatsonService.isJsonPatchMimeType("application/json"));
        assertFalse(WatsonService.isJsonPatchMimeType("APPLICATION/JsOn; charset=utf-8"));
        assertFalse(WatsonService.isJsonPatchMimeType("application/merge-patch+json"));
        assertFalse(WatsonService.isJsonPatchMimeType("application/merge-patch+json;charset=utf-8"));
    }
}
