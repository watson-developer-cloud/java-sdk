package com.ibm.watson.developer_cloud.service.model;

import com.ibm.watson.developer_cloud.util.GsonSingleton;
import okhttp3.Headers;

public class StaticResponseModel implements ResponseModel {

  private Headers headers;

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    final DynamicModel other = (DynamicModel) o;

    return toString().equals(other.toString());
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return GsonSingleton.getGson().toJson(this);
  }

  @Override
  public Headers getHeaders() {
    return this.headers;
  }

  void setHeaders(Headers headers) {
    this.headers = headers;
  }
}
