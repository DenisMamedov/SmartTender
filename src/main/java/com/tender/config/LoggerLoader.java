package com.tender.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class LoggerLoader {
	static {
        load();
    }

    public static synchronized void load() {
        Properties props = new Properties();
        props.setProperty("log4j.rootLogger", "debug file");
        props.setProperty("lof4j.appender.file", "org.apache.log4j.RollingFileAppender");
        props.setProperty("lof4j.appender.file.file", "./log/test_log1.log");
        props.setProperty("log4j.appender.file.MaxFileSize", "5120KB");
        props.setProperty("log4j.appender.file.MaxBackupIndex", "10");
        props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
        props.setProperty("log4j.appender.file.layout.conversionPattern", "--------------------------------------------------------------------------------------------------------------------%n%d{ISO8601} %5p %c{1}:%M:%L - %m%n");
        PropertyConfigurator.configure(props);
    }

	public static Logger getLogger(Class class1) {
		// TODO Auto-generated method stub
		return Logger.getLogger(class1);
	}

}