package com.cy.devp.util;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: liaoguoming
 * Date: 14-4-8
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
public class LogUtil {
    //配置log4j中的日志名字
    public static String testName = "test";

    public static void printLog(Class classzz, String logStr) {
        Logger logger = Logger.getLogger(classzz);
        logger.info(logStr);
    }

    public static void printLog(String logName, String logStr) {
        Logger logger = Logger.getLogger(logName);
        logger.info(logStr);
    }
}
