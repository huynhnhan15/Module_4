package com.codegym.spring_boot.loggin;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class Loggin {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

}
