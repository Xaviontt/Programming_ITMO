package utility;

import javax.swing.text.SimpleAttributeSet;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtility {
    private static Logger infoLogger;
    private static Logger warningLogger;
    private static Logger errorLogger;
    private static final String INFO_PATH = "logs/info.log";
    private static final String WARNING_PATH = "logs/warning.log";
    private static final String ERROR_PATH = "logs/error.log";

    public static void info(String msg) {
        if (infoLogger == null)
        {
            infoLogger = Logger.getLogger("info-logger");
            setFileHandler(infoLogger, INFO_PATH);
        }
        infoLogger.info(msg);
    }

    public static void warning(String msg) {
        if (warningLogger == null)
        {
            warningLogger = Logger.getLogger("warning-logger");
            setFileHandler(warningLogger, WARNING_PATH);
        }
        warningLogger.warning(msg);
    }

    public static void error(String msg) {
        if (errorLogger == null)
        {
            errorLogger = Logger.getLogger("error-logger");
            setFileHandler(errorLogger, ERROR_PATH);
        }
        errorLogger.severe(msg);
    }

    public static void error(String msg, Throwable thrown) {
        if (errorLogger == null)
        {
            errorLogger = Logger.getLogger("error-logger");
            setFileHandler(errorLogger, ERROR_PATH);
        }
        errorLogger.log(Level.SEVERE, msg, thrown);
    }

    private static void setFileHandler(Logger logger, String path)  {
        try {
            File file = Paths.get(path).toFile();
            if (!file.exists())
            {
                File folder = file.getParentFile();
                Files.createDirectories(folder.toPath());
            }
            FileHandler handler = new FileHandler(file.getPath());
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            logger.addHandler(handler);
        } catch (Exception e) {
            System.err.println("Проблема с логгером в классе LoggerUtility!");
            e.printStackTrace();
        }
    }

}
