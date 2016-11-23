package com.hoo.utils;

import org.apache.commons.lang.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * Created by palagend on 2016/11/28.
 */
public class CustomBigDecimalEditor extends PropertyEditorSupport {

    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            setValue(NumberUtils.getBigDecimal(text));
        }
    }
}

