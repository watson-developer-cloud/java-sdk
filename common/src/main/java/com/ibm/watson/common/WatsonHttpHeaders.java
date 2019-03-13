package com.ibm.watson.common;

public interface WatsonHttpHeaders {
  /** Allow Watson to collect the payload. */
  String X_WATSON_LEARNING_OPT_OUT = "X-Watson-Learning-Opt-Out";

  /** Header containing analytics info. */
  String X_IBMCLOUD_SDK_ANALYTICS = "X-IBMCloud-SDK-Analytics";

  /** Mark API calls as tests. */
  String X_WATSON_TEST = "X-Watson-Test";
}
