package com.test.springboot.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date : 2018/10/25 09:49
 * @author: liangenmao
 */
@Component
public class DateConverter implements Converter<String, Date> {
    private static final String DATE_FORMAT_STRING = "yyyy-MM-dd";
    private static final String DATETIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING);
    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(DATETIME_FORMAT_STRING);

    @Override
    public Date convert(String source) {
        try {
            if (source.length() == DATE_FORMAT_STRING.length())
                return DATE_FORMAT.parse(source);
            if (source.length() == DATETIME_FORMAT_STRING.length())
                return DATETIME_FORMAT.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
