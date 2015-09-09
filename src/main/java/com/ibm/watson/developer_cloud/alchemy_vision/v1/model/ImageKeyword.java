
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

package com.ibm.watson.developer_cloud.alchemy_vision.v1.model;

import com.ibm.watson.developer_cloud.alchemy_vision.v1.AlchemyVision;

/**
 * ImageKeyword by the {@link AlchemyVision} service.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ImageKeyword {


    private String text;

    private String score;

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    public ImageKeyword withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * @return The score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(String score) {
        this.score = score;
    }

    public ImageKeyword withScore(String score) {
        this.score = score;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageKeyword that = (ImageKeyword) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return !(score != null ? !score.equals(that.score) : that.score != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("ImageKeyword [text=%s,score=%s]", text, score);
    }

}
