/*
 * Copyright 2015 IBM Corp. All Rights Reserved.
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
package com.ibm.watson.developer_cloud.conversation.v1.model.workspace.intent;

/**
 * An class used to describe the intent example payload object.
 */
public class ExampleResponse extends CreateExample{
	
    protected String created;
    protected String updated;

    /**
     * Returns the time stamp for when the example was created.
     *
     * @return a string representing the time stamp of example creation
     */
    public String getCreated() {
        return created;
    }


    /**
     * Returns the time stamp for when the example was last updated.
     *
     * @return a string representing the time stamp of example's last update
     */
    public String getUpdated() {
        return updated;
    }

}
