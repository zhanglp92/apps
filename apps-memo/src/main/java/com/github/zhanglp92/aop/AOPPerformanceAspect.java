package com.github.zhanglp92.aop;

import com.github.zhanglp92.aop.annotations.AOPPerformance;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class AOPPerformanceAspect {
    @Pointcut("@annotation(aopPerformance)")
    public void performance(AOPPerformance aopPerformance) {
    }

    @Around(value = "performance(aopPerformance)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, AOPPerformance aopPerformance) throws Throwable {
//        log.info("注释正常进入");
        return proceedingJoinPoint.proceed();
    }

    @Before(value = "performance(aopPerformance)")
    public void doBefore(JoinPoint joinPoint, AOPPerformance aopPerformance) {
//        log.info("注释正常进入");
    }

    @After(value = "performance(aopPerformance)")
    public void doAfter(JoinPoint joinPoint, AOPPerformance aopPerformance) {
//        log.info("注释正常进入");
    }

    @AfterReturning(value = "performance(aopPerformance)")
    public void doAfterReturning(JoinPoint joinPoint, AOPPerformance aopPerformance) {
//        log.info("注释正常进入");
    }

    @AfterThrowing(value = "performance(aopPerformance)")
    public void doAfterThrowing(JoinPoint joinPoint, AOPPerformance aopPerformance) {
//        log.info("注释正常进入");
    }
}
