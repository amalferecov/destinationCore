package com.crag.destinationCore.util;

import org.apache.log4j.Logger;

/**
 * Created by heisenberg on 12/13/17.
 */
public class LogManager {
    public static Logger log = Logger.getLogger(LogManager.class);

    public static void info(String className,String infoMessage){
        log.info(className.concat(" : ").concat(infoMessage));
    }

    public static void error(String className,String errorMessage,Exception e){
        log.error(className.concat(" : ").concat(errorMessage),e);
    }
}
