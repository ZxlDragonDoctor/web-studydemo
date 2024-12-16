package com.zxl.webspringmvc.webspringmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * 转换器，日期转换
 */
public class StringToLocalDateConverter implements Converter<String,LocalDate> {
    private String datePattern;

    public StringToLocalDateConverter(String datePattern) {

        this.datePattern = datePattern;
    }

    @Override
    public LocalDate convert(String s) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            return LocalDate.parse(s, formatter);
        } catch (DateTimeParseException e) {
            // 错误消息使用<form:errors>标签显示
            throw new IllegalArgumentException("日期格式非法。请使用下面格式: \"" + datePattern + "\"");
        }
    }
}