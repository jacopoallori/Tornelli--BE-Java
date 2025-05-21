package com.td.tornelli.util;

import java.time.format.DateTimeFormatter;

public class Constant {

    private static final String PATTERN_DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(PATTERN_DATE_TIME_FORMATTER);
}
