package com.hoo.utils;

import java.math.BigDecimal;

/**
 * Created by palagend on 2016/11/28.
 */
public class NumberUtils {
    public static int parseInt(long l){
        return BigDecimal.valueOf(l).intValue();
    }

    public static long parseLong(String s) {
        return Long.parseLong(s.trim());
    }
    public static float parseFloat(String s) {
        return Float.parseFloat(s.trim());
    }

    public static BigDecimal getBigDecimal(String s) {
        return BigDecimal.valueOf(parseFloat(s));
    }

}
