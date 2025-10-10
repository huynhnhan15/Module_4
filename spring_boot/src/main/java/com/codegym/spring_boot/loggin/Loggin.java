package com.codegym.spring_boot.loggin;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Aspect
@Component
public class Loggin {
    private final Map<String, Integer> methodCountMap = new ConcurrentHashMap<>();

    @Pointcut("execution(* com.codegym.spring_boot.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void countMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        methodCountMap.merge(methodName, 1, Integer::sum);

        System.out.println( " đã được gọi " + methodCountMap.get(methodName) + " lần");
    }
}
