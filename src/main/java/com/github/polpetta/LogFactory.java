package com.github.polpetta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class LogFactory {
    public Logger create(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public Logger create(String name) {
        return LoggerFactory.getLogger(name);
    }
}
