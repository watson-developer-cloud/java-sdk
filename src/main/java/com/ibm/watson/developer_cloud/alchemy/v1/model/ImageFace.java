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

package com.ibm.watson.developer_cloud.alchemy.v1.model;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

/**
 * ImageFace returned by {@link AlchemyVision#recognizeFaces(java.util.Map)}.
 *
 * @author Nizar Alseddeg (nmalsedd@us.ibm.com)
 */
public class ImageFace {

	/**
	 * Face gender.
	 */
	public static class Gender {
		
		/** The gender. */
		private String gender;

		/** The score. */
		private Double score;

		/**
		 * Gets the gender.
		 *
		 * @return The gender
		 */
		public String getGender() {
			return gender;
		}

		/**
		 * Sets the gender.
		 *
		 * @param gender The gender
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}

		/**
		 * Gets the score.
		 *
		 * @return The score
		 */
		public Double getScore() {
			return score;
		}

		/**
		 * Sets the score.
		 *
		 * @param score The score
		 */
		public void setScore(Double score) {
			this.score = score;
		}

	}

	/**
	 * Age range.
	 */
	public static class Age extends GenericModel {

		/** The age range. */
		private String ageRange;

		/** The score. */
		private Double score;

		/**
		 * Gets the age range.
		 * 
		 * @return The ageRange
		 */
		public String getAgeRange() {
			return ageRange;
		}

		/**
		 * Sets the age range.
		 * 
		 * @param ageRange The ageRange
		 */
		public void setAgeRange(String ageRange) {
			this.ageRange = ageRange;
		}

		/**
		 * Gets the score.
		 * 
		 * @return The score
		 */
		public Double getScore() {
			return score;
		}

		/**
		 * Sets the score.
		 * 
		 * @param score The score
		 */
		public void setScore(Double score) {
			this.score = score;
		}
	}

	/** The age. */
	private Age age;

	/** The gender. */
	private Gender gender;

	/** The height. */
	private String height;

	/** The identity. */
	private Identity identity;

	/** The position x. */
	private String positionX;

	/** The position y. */
	private String positionY;

	/** The width. */
	private String width;

	/**
	 * Gets the age.
	 *
	 * @return The age
	 */
	public Age getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age            The age
	 */
	public void setAge(Age age) {
		this.age = age;
	}

	/**
	 * With age.
	 *
	 * @param age the age
	 * @return the image face
	 */
	public ImageFace withAge(Age age) {
		this.age = age;
		return this;
	}

	/**
	 * Gets the gender.
	 *
	 * @return The gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender            The gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * With gender.
	 *
	 * @param gender the gender
	 * @return the image face
	 */
	public ImageFace withGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Gets the height.
	 *
	 * @return The height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height            The height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * With height.
	 *
	 * @param height the height
	 * @return the image face
	 */
	public ImageFace withHeight(String height) {
		this.height = height;
		return this;
	}

	/**
	 * Gets the identity.
	 *
	 * @return The identity
	 */
	public Identity getIdentity() {
		return identity;
	}

	/**
	 * Sets the identity.
	 *
	 * @param identity            The identity
	 */
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	/**
	 * With identity.
	 *
	 * @param identity the identity
	 * @return the image face
	 */
	public ImageFace withIdentity(Identity identity) {
		this.identity = identity;
		return this;
	}

	/**
	 * Gets the position x.
	 *
	 * @return The positionX
	 */
	public String getPositionX() {
		return positionX;
	}

	/**
	 * Sets the position x.
	 *
	 * @param positionX            The positionX
	 */
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	/**
	 * With position x.
	 *
	 * @param positionX the position x
	 * @return the image face
	 */
	public ImageFace withPositionX(String positionX) {
		this.positionX = positionX;
		return this;
	}

	/**
	 * Gets the position y.
	 *
	 * @return The positionY
	 */
	public String getPositionY() {
		return positionY;
	}

	/**
	 * Sets the position y.
	 *
	 * @param positionY            The positionY
	 */
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	/**
	 * With position y.
	 *
	 * @param positionY the position y
	 * @return the image face
	 */
	public ImageFace withPositionY(String positionY) {
		this.positionY = positionY;
		return this;
	}

	/**
	 * Gets the width.
	 *
	 * @return The width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width            The width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * With width.
	 *
	 * @param width the width
	 * @return the image face
	 */
	public ImageFace withWidth(String width) {
		this.width = width;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ImageFace imageFace = (ImageFace) o;

		if (age != null ? !age.equals(imageFace.age) : imageFace.age != null)
			return false;
		if (gender != null ? !gender.equals(imageFace.gender) : imageFace.gender != null)
			return false;
		if (height != null ? !height.equals(imageFace.height) : imageFace.height != null)
			return false;
		if (identity != null ? !identity.equals(imageFace.identity) : imageFace.identity != null)
			return false;
		if (positionX != null ? !positionX.equals(imageFace.positionX) : imageFace.positionX != null)
			return false;
		if (positionY != null ? !positionY.equals(imageFace.positionY) : imageFace.positionY != null)
			return false;
		return !(width != null ? !width.equals(imageFace.width) : imageFace.width != null);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName() + " " + GsonSingleton.getGson().toJson(this);
	}
}
