package com.pika.designPattern.chainOfResponsibility;

public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger chainOfLoggers = getChainOfLoggers();
        chainOfLoggers.logMessage(AbstractLogger.INFO, "This is a info information");
        System.out.println("------------------------------------------------");
        chainOfLoggers.logMessage(AbstractLogger.DEBUG, "This is a debug information");
        System.out.println("------------------------------------------------");
        chainOfLoggers.logMessage(AbstractLogger.ERROR, "This is a error information");
    }
}
