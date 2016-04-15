package com.ibm.watson.developer_cloud.language_translation.v2.model;

public enum Language {

    ARABIC {
        @Override
        public String toString() {
            return "ar";
        }
    }, ENGLISH {
        @Override
        public String toString() {
            return "en";
        }
    }, SPANISH {
        @Override
        public String toString() {
            return "es";
        }
    }, FRENCH {
        @Override
        public String toString() {
            return "fr";
        }
    }, ITALIAN {
        @Override
        public String toString() {
            return "it";
        }
    }, PORTUGUESE {
        @Override
        public String toString() {
            return "pt";
        }
    };

    @Override
    public String toString() {
        return "";
    }
}
