
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

import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class ImageFace {


    private Age age;

    private Gender gender;

    private String height;

    private Identity identity;

    private String positionX;

    private String positionY;

    private String width;

    /**
     * @return The age
     */
    public Age getAge() {
        return age;
    }

    /**
     * @param age The age
     */
    public void setAge(Age age) {
        this.age = age;
    }

    public ImageFace withAge(Age age) {
        this.age = age;
        return this;
    }

    /**
     * @return The gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ImageFace withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     * @return The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    public ImageFace withHeight(String height) {
        this.height = height;
        return this;
    }

    /**
     * @return The identity
     */
    public Identity getIdentity() {
        return identity;
    }

    /**
     * @param identity The identity
     */
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public ImageFace withIdentity(Identity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * @return The positionX
     */
    public String getPositionX() {
        return positionX;
    }

    /**
     * @param positionX The positionX
     */
    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public ImageFace withPositionX(String positionX) {
        this.positionX = positionX;
        return this;
    }

    /**
     * @return The positionY
     */
    public String getPositionY() {
        return positionY;
    }

    /**
     * @param positionY The positionY
     */
    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public ImageFace withPositionY(String positionY) {
        this.positionY = positionY;
        return this;
    }

    /**
     * @return The width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    public ImageFace withWidth(String width) {
        this.width = width;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageFace imageFace = (ImageFace) o;

        if (age != null ? !age.equals(imageFace.age) : imageFace.age != null) return false;
        if (gender != null ? !gender.equals(imageFace.gender) : imageFace.gender != null) return false;
        if (height != null ? !height.equals(imageFace.height) : imageFace.height != null) return false;
        if (identity != null ? !identity.equals(imageFace.identity) : imageFace.identity != null) return false;
        if (positionX != null ? !positionX.equals(imageFace.positionX) : imageFace.positionX != null) return false;
        if (positionY != null ? !positionY.equals(imageFace.positionY) : imageFace.positionY != null) return false;
        return !(width != null ? !width.equals(imageFace.width) : imageFace.width != null);

    }

    @Override
    public int hashCode() {
        int result = age != null ? age.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (positionX != null ? positionX.hashCode() : 0);
        result = 31 * result + (positionY != null ? positionY.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
    }
}
