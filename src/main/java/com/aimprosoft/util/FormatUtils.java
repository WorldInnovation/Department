package com.aimprosoft.util;

import com.mysql.cj.core.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatUtils {

    public static Integer getIntFromStr(String stringValue) {
        Integer value = null;
        if (!StringUtils.isEmptyOrWhitespaceOnly(stringValue)) {
            try {
                value = Integer.valueOf(stringValue);
            } catch (NumberFormatException ignored) {
            }
        }
        return value;
    }

    public static Long getLongFromStr(String stringVal) {
        Long value = null;
        if (!StringUtils.isEmptyOrWhitespaceOnly(stringVal)) {
            try {
                value = Long.valueOf(stringVal);
            } catch (NumberFormatException ignored) {
            }
        }
        return value;

    }

    public static Date getDateFromString(String stringValue) {

        String FORMAT_DATE = "yyyy-MM-dd";
        if (stringValue.equals("")) return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);

        try {
            return simpleDateFormat.parse(stringValue);
        } catch (ParseException ignored) {
            return null;
        }


    }
}
