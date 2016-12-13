/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
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

package com.ibm.watson.developer_cloud.discovery.v1.model.common;

/**
 * @author apturgeo
 */
public interface CommonManager {
    //Disk & Memory Usage
    String DISK_USAGE = "disk_usage";
    String MEMORY_USAGE = "memory_usage";
    String USED_BYTES = "used_bytes";
    String TOTAL_BYTES = "total_bytes";
    String USED = "used";
    String TOTAL = "total";
    String PERCENT_USED = "percent_used";

    //Notices (Warnings & Errors)
    String NOTICES = "notices";
    String NOTICE_ID = "notice_id";
    String CREATED = "created";
    String SEVERITY = "severity";
    String STEP = "step";
    String DESCRIPTION = "description";
}
