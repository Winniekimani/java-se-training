package com.systechafrika.possystemupdate.filelogging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class FileLogging {

    private static final Logger LOGGER = Logger.getLogger(FileLogging.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        try {
            setupLogger(); // Calling setupLogger()
            LOGGER.info("Info message logging\n");
            LOGGER.severe("Error message logging\n");
            LOGGER.warning("Warning message logging\n");
            test();
        } catch (SecurityException e) {
            LOGGER.info("Security permission exception " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info("I/O permission exception " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void setupLogger() throws IOException {

        FileHandler fileHandler = new FileHandler("log.txt", true);
        CustomFormatter formatter = new CustomFormatter();
        LOGGER.addHandler(fileHandler);
        fileHandler.setFormatter(formatter);
        // fileHandler.setFlushOnPublish(true); // Add this line to enable immediate
        // flushing
    }

    public static void test() {
        LOGGER.info("Info message logging test\n");
        LOGGER.severe("Error message logging test\n");
        LOGGER.warning("Warning message logging test\n");
    }

    // public static void logInfo(String message) {
    // LOGGER.info(message);
    // }

    // public static void logError(String message) {
    // LOGGER.severe(message);
    // }

    // public static void logWarning(String message) {
    // LOGGER.warning(message);
    // }

}
