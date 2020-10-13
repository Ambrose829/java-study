package com.pika.designPattern.chainOfResponsibility;

/**
 * 创建抽象的记录器类
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;



    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    protected abstract void write(String message);

    public void logMessage(int level, String message) {
        if (level >= this.level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);

        }
    }
}
