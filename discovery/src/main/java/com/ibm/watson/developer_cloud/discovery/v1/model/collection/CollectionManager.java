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

package com.ibm.watson.developer_cloud.discovery.v1.model.collection;

import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.Field;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.GetCollectionFieldsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.field.GetCollectionFieldsResponse;
import com.ibm.watson.developer_cloud.http.ServiceCall;

/**
 * Interface defining the constants and methods associated with Collections.
 *
 * @see Collection
 */
public interface CollectionManager {
    String COLLECTIONS = "collections";

    //Collection
    String ID = "collection_id";
    String NAME = "name";
    String DESCRIPTION = "description";
    String CREATED = "created";
    String UPDATED = "update";
    String STATUS = "status";
    String CONFIGURATION_ID = "configuration_id";
    String LANGUAGE = "language";
    String DOCUMENT_COUNTS = "document_counts";

    //Document Counts
    String AVAILABLE = "available";
    String PROCESSING = "processing";
    String FAILED = "failed";

    //Fields
    String FIELDS = "fields";
    String FIELD = "field";
    String TYPE = "type";

    /**
     * Gets a list of {@link Collection}. An optional parameter of name can be provided to filter by name.
     *
     * @param getRequest options for getting the {@link Collection}s
     * @return a {@link GetCollectionsResponse} containing the result of {@link GetCollectionsRequest}
     */
    ServiceCall<GetCollectionsResponse> getCollections(GetCollectionsRequest getRequest);

    /**
     * Gets a {@link Collection}.
     *
     * @param getRequest options for getting the {@link Collection}
     * @return a {@link GetCollectionResponse} containing the result of {@link GetCollectionRequest}
     */
    ServiceCall<GetCollectionResponse> getCollection(GetCollectionRequest getRequest);

    /**
     * Creates a {@link Collection}.
     *
     * @param createRequest options for creating a {@link Collection}
     * @return a {@link CreateCollectionResponse} containing the result of {@link CreateCollectionRequest}
     */
    ServiceCall<CreateCollectionResponse> createCollection(CreateCollectionRequest createRequest);

    /**
     * Deletes a {@link Collection}.
     *
     * @param deleteRequest options for deleting a {@link Collection}
     * @return a {@link DeleteCollectionResponse} containing the result of {@link DeleteCollectionRequest}
     */
    ServiceCall<DeleteCollectionResponse> deleteCollection(DeleteCollectionRequest deleteRequest);

    /**
     * Gets a list of unique {@link Field}s from a {@link Collection}.
     *
     * @param getRequest options for getting a unique fields from a {@link Collection}
     * @return a {@link GetCollectionFieldsResponse} containing the result of {@link GetCollectionFieldsRequest}
     */
    ServiceCall<GetCollectionFieldsResponse> getCollectionFields(GetCollectionFieldsRequest getRequest);
}
