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

package com.ibm.watson.developer_cloud.discovery.v1.model.environment;

import com.ibm.watson.developer_cloud.http.ServiceCall;

/**
 * Interface defining the constants and methods associated with Environments.
 *
 * @see Environment
 */
public interface EnvironmentManager {
    String ENVIRONMENTS = "environments";

    //Environment
    String ID = "environment_id";
    String NAME = "name";
    String DESCRIPTION = "description";
    String CREATED = "created";
    String UPDATED = "updated";
    String STATUS = "status";
    String READ_ONLY = "read_only";
    String INDEX_CAPACITY = "index_capacity";

    //Disk & Memory Usage
    String DISK_USAGE = "disk_usage";
    String MEMORY_USAGE = "memory_usage";
    String USED_BYTES = "used_bytes";
    String TOTAL_BYTES = "total_bytes";
    String USED = "used";
    String TOTAL = "total";
    String PERCENT_USED = "percent_used";

    //only on creation request
    String SIZE = "size";

    /**
     * Lists existing environments. Optional query param of name can be used to search for environments by name.
     *
     * @param getRequest options for getting the environments
     * @return a {@link GetEnvironmentsResponse} containing result of the {@link GetEnvironmentsRequest}
     */
    ServiceCall<GetEnvironmentsResponse> getEnvironments(GetEnvironmentsRequest getRequest);

    /**
     * Gets details about an existing environment.
     *
     * @param getRequest options for getting the environment
     * @return a {@link GetEnvironmentResponse} containing the result of the {@link GetEnvironmentRequest}
     */
    ServiceCall<GetEnvironmentResponse> getEnvironment(GetEnvironmentRequest getRequest);

    /**
     * Creates a new environment.
     *
     * @param createRequest options for creating the environment
     * @return a {@link CreateEnvironmentResponse} containing the result of the {@link CreateEnvironmentRequest}
     */
    ServiceCall<CreateEnvironmentResponse> createEnvironment(CreateEnvironmentRequest createRequest);

    /**
     * Deletes an existing environment.
     *
     * @param deleteRequest options for deleting the environment
     * @return a {@link DeleteEnvironmentResponse} containing the result of the {@link DeleteEnvironmentRequest}
     */
    ServiceCall<DeleteEnvironmentResponse> deleteEnvironment(DeleteEnvironmentRequest deleteRequest);

    /**
     * Updates an environment.
     *
     * @param updateRequest options for deleting the environment
     * @return a {@link UpdateEnvironmentResponse} containing the result of the {@link UpdateEnvironmentRequest}
     */
    ServiceCall<UpdateEnvironmentResponse> updateEnvironment(UpdateEnvironmentRequest updateRequest);
}
