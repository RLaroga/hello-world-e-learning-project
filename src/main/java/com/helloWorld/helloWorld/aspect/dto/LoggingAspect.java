package com.helloWorld.helloWorld.mainStudy.aspect.dto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.helloWorld.helloWorld.mainStudy.aspect.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

//        logger.info("Method will execute");
//        joinPoint.proceed();
//        logger.info("Method executed");

        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Method " +
                methodName + " with parameters " +
                Arrays.asList(arguments) + " will execute");

        Object returnedByMethod = joinPoint.proceed();
        logger.info("Method executed and returned " + returnedByMethod);

        return returnedByMethod;

    }
}
