package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LogUtils {
    private static final Logger log = LoggerFactory.getLogger(LogUtils.class.getName());

    public static void logInfoMessage(String msg) {
        log.info(msg);
    }

    public static void logSevereMessage(String msg) {
        log.error(msg);
    }

    public static void logWarningMessage(String msg) {
        log.warn(msg);
    }
}

