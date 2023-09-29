package com.systechafrika.possystemupdate.filelogging;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String method = record.getSourceMethodName();
        LocalDateTime timestamp = LocalDateTime.now();
        String source = record.getSourceClassName() + " | " + record.getSourceMethodName();
        String level = record.getLevel().getName();
        String message = record.getMessage();

        return String.format("%s | %s | %s | %s\n",
                timestamp.format(pattern), level, method, message);
        // return timestamp.format(pattern) + " | " + level + " | " + method + " | " +
        // message + "\n";
    }

}
