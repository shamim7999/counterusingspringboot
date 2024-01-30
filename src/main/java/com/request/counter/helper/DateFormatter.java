package com.request.counter.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String convertToYearTimeDay(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEEE");
        return localDateTime.format(dateTimeFormatter);
    }
}
