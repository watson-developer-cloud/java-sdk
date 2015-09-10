package com.ibm.watson.developer_cloud.retrieve_and_rank.v1.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatter {
    private final ResourceBundle rb;

    public MessageFormatter(String bundleName) {
        this.rb = ResourceBundle.getBundle(bundleName, Locale.getDefault());
    }

    public String format(BundleKey key, Object... args) {
        return MessageFormat.format(rb.getString(key.toString()), args);
    }
}
