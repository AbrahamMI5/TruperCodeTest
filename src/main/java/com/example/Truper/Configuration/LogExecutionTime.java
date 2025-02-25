package com.example.Truper.Configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTime {

    private static final Logger logger = LoggerFactory.getLogger(LogExecutionTime.class);

    @Around("execution(* com.example.Truper..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        logger.info("Método ejecutado en {} ms: {}", executionTime, joinPoint.getSignature());

        return result;
    }

}
