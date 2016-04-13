package com.ibm.watson.developer_cloud.language_translation.v2.model;

public enum Language {

  ARABIC, ENGLISH, SPANISH, FRENCH, ITALIAN, PORTUGESE,
  AR, EN, ES, FR, IT, PT;
  
  public String toString() {
    if (super.toString().length() > 2) {
      switch (this) {
        case ARABIC: return "ar";
        case ENGLISH: return "en";
        case SPANISH: return "es";
        case FRENCH: return "fr";
        case ITALIAN: return "it";
        case PORTUGESE: return "pt";
      }
    } else {
      return super.toString();
    }
    return "";
  }

}
