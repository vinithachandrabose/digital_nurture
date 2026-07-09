package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("================================");
        System.out.println("Method Called : " + joinPoint.getSignature().getName());
        System.out.println("Logging Before Method Execution");
        System.out.println("================================");
    }
}
