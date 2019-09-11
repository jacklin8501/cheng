package com.cheng.as.demo.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * WebConst
 */
public interface WebConst {

    public static final String MDL_ME = "/me";

    public static final String URI_A = MDL_ME + "/a";

    public enum WebContextEnum {
        ME_A(MDL_ME, "a");

        private String uri;
        private String html;

        private WebContextEnum(String uri, String html) {
            this.uri = uri;
            this.html = html;
        }

        public static WebContextEnum convert(String uri) {
            for (WebContextEnum item : values()) {
                if (StringUtils.equals(uri, item.getUri())) {
                    return item;
                }
            }
            return null;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }
}