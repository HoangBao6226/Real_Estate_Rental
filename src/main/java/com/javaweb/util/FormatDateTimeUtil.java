package com.javaweb.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDateTimeUtil {

    public LocalDateTime parseDateTime(String dateTimeString) {
        // Định dạng đầu vào từ client
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
