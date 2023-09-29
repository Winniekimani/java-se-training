package com.systechafrika.possystemupdate.filelogging;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class FileLogging {

    private static final Logger LOGGER = Logger.getLogger(FileLogging.class.getName());

    public static void setupLogger() throws IOException {
        FileHandler fileHandler = new FileHandler("log.txt");
        CustomFormatter formatter = new CustomFormatter();
        LOGGER.addHandler(fileHandler);
        fileHandler.setFormatter(formatter);
    }

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logError(String message) {
        LOGGER.severe(message);
    }

    public static void logWarning(String message) {
        LOGGER.warning(message);
    }

    static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String method = record.getSourceMethodName();
            String level = record.getLevel().getName();
            String message = record.getMessage();
            Instant instant = record.getInstant();
            LocalDateTime now = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            return pattern.format(now) + " | " + method + " | " + level + " | " + message + "\n";
        }
    }
}
