package com.ibm.watson.developer_cloud.conversation.v1.model.util;

import com.ibm.watson.developer_cloud.service.model.ObjectModel;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.util.HashMap;

public abstract class DynamicModel extends HashMap<String, Object> implements ObjectModel {

  /*
   * (non-Javadoc)
   *
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
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return GsonSingleton.getGson().toJson(this);
  }

  /*@Override
  public void putAll(Map<? extends String, ?> m) {
    System.out.println(m.toString());
  }*/
}
