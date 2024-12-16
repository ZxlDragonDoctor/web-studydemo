package com.zxl.webspringmvc.webspringmvc.formatter;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * 格式化器，日期转换
 */
public class LocalDateFormatter implements Formatter<LocalDate> {
    private DateTimeFormatter formatter;
    private String datePattern;

    public LocalDateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.formatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        try {
            return LocalDate.parse(s, formatter);
        } catch (DateTimeParseException e) {
            // the error message will be displayed in <form:errors>
            throw new IllegalArgumentException("invalid date format. Please use this pattern: \"" + datePattern + "\"");
        }
    }

    @Override
    public String print(LocalDate date, Locale locale) {

        return date.format(formatter);
    }
}