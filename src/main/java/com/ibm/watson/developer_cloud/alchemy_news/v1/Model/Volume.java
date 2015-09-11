
/*
 * *
 *  * Copyright 2015 IBM Corp. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ibm.watson.developer_cloud.alchemy_news.v1.Model;

import com.ibm.watson.developer_cloud.alchemy_news.v1.AlchemyDataNews;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Volume by the {@link AlchemyDataNews} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class Volume {


    private int count;

    private List<Integer> slices = new ArrayList<Integer>();

    private String status;

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public Volume withCount(int count) {
        this.count = count;
        return this;
    }

    /**
     * @return The slices
     */
    public List<Integer> getSlices() {
        return slices;
    }

    /**
     * @param slices The slices
     */
    public void setSlices(List<Integer> slices) {
        this.slices = slices;
    }

    public Volume withSlices(List<Integer> slices) {
        this.slices = slices;
        return this;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Volume withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;

        if (count != volume.count) return false;
        if (slices != null ? !slices.equals(volume.slices) : volume.slices != null) return false;
        return !(status != null ? !status.equals(volume.status) : volume.status != null);

    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + (slices != null ? slices.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
