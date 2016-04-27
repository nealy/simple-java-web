package com.nly.struts;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by nealy on 4/27/2016
 */
public class DateConverter extends StrutsTypeConverter {
    static final String DATE_FORMAT_DATE = "mm/dd/yyyy";

    public Date convertFromString(Map context, String[] values, Class toClass) {
        String value = values[0];
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_DATE);
        try {
            return format.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String convertToString(Map context, Object date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_DATE);
        return format.format(date);
    }
}
