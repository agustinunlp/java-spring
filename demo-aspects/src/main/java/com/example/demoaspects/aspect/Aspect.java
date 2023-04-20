package com.example.demoaspects.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    /**
     * First we create the Pointcuts (puntos de corte)
     */

    /**
     * All methods that matches with package
     * com.example.demoaspects.service.*.*
     */
    @Pointcut("execution(* com.example.demoaspects.service.*.* (..))")
    public void allMethodsInPackage() { }


    //Advices / Consejos

    @Before("allMethodsInPackage()")
    public void advice1(JoinPoint jp) {
        LoggerFactory.getLogger("com.example.demoaspects." + jp.getSignature().getName()).info("EXECUTE IN advice1 (BEFORE METHOD)");
    }

    @After("allMethodsInPackage()")
    public void advice2(JoinPoint jp) {
        LoggerFactory.getLogger("com.example.demoaspects." + jp.getSignature().getName()).info("EXECUTE IN advice2 (AFTER METHOD)");
    }

    //A todos los metodos de una clase anotada con @CustomAnnotation
    @Before("@within(com.example.demoaspects.annotation.CustomAnnotation)")
    public void advice3(JoinPoint jp) {
        LoggerFactory.getLogger("com.example.demoaspects." + jp.getSignature().getName()).info("EXECUTE IN advice3 (BEFORE METHOD)");
    }

    //Todos los metodos Anotados con @CustomMethodAnnotation
    @Before("@annotation(com.example.demoaspects.annotation.CustomMethodAnnotation)")
    public void advice4(JoinPoint jp) {
        LoggerFactory.getLogger("com.example.demoaspects." + jp.getSignature().getName()).info("EXECUTE IN advice4 (BEFORE METHOD)");
    }

    //Todos los metodos que tiren una excepcion
    @AfterThrowing(pointcut = "allMethodsInPackage()")
    public void advice5(JoinPoint jp) {
        LoggerFactory.getLogger("com.example.demoaspects." + jp.getSignature().getName()).info("EXECUTE IN advice5 (THROWING EXCEPTION)");
    }

    //Todos los metodos Anotados con @AnotherCustomMethodAnnotation y reciban un string como argumento
    @Around("@annotation(com.example.demoaspects.annotation.AnotherCustomMethodAnnotation) && args(String)")
    public void advice6(ProceedingJoinPoint pjp) throws Throwable {
        LoggerFactory.getLogger("com.example.demoaspects." + pjp.getSignature().getName()).info("EXECUTE IN advice4 (AROUND METHOD) before");
        pjp.proceed();
        LoggerFactory.getLogger("com.example.demoaspects." + pjp.getSignature().getName()).info("EXECUTE IN advice4 (AROUND METHOD) after");
    }
}
