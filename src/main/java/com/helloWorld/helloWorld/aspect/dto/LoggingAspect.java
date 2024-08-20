package com.helloWorld.helloWorld.aspect.dto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Around("execution(* com.helloWorld.helloWorld.mainStudy.aspect.service.*.*(..))")
@Around("@annotation(com.helloWorld.mainStudy.aspect.annotation.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        Object returnedValue = joinPoint.proceed();

        logger.info("Logging Aspect: Method executed and returned " + returnedValue);

        return "FAILED";

    }
}
