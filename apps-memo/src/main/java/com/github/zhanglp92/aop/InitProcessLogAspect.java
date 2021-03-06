package com.github.zhanglp92.aop;

import com.github.zhanglp92.aop.annotations.InitProcessLog;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * bean初始化日志打印, 切面/代理的委托类
 */

@Aspect
@Component
@Log4j2
public class InitProcessLogAspect {

    /**
     * 定义切点的位置
     */
    @Pointcut("execution(* *(..)) && @annotation(initProcessLog)")
    public void serviceStatistics(InitProcessLog initProcessLog) {
    }

    /**
     * 以下方法执行顺序:
     * 正常: doAround before --> doBefore --> doAround after --> doAfter --> doAfterReturning
     * 异常: doAround before --> doBefore --> doAfter --> doAfterThrowing
     */

    @Around(value = "serviceStatistics(initProcessLog)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, InitProcessLog initProcessLog) throws Throwable {
        String kind = proceedingJoinPoint.getSignature().toLongString();

        log.info("{} doAround before --> ", kind);
        Object response = proceedingJoinPoint.proceed();
        log.info("{} doAround after --> ", kind);
        return response;
    }

    /**
     * 多个注解都会被执行
     */
    @Before(value = "serviceStatistics(initProcessLog)")
    public void doBefore(JoinPoint joinPoint, InitProcessLog initProcessLog) {
        log.info("{} doBefore --> ", joinPoint.getSignature().toLongString());
    }

    @Before(value = "serviceStatistics(initProcessLog)")
    public void doBefore2(JoinPoint joinPoint, InitProcessLog initProcessLog) {
        log.info("{} doBefore2 --> ", joinPoint.getSignature().toLongString());
    }


    @After(value = "serviceStatistics(initProcessLog)")
    public void doAfter(JoinPoint joinPoint, InitProcessLog initProcessLog) {
        log.info("{} doAfter --> ", joinPoint.getSignature().toLongString());
    }


    @AfterReturning(value = "serviceStatistics(initProcessLog)")
    public void doAfterReturning(JoinPoint joinPoint, InitProcessLog initProcessLog) {
        log.info("{} doAfterReturning --> ", joinPoint.getSignature().toLongString());
    }

    @AfterThrowing(value = "serviceStatistics(initProcessLog)")
    public void doAfterThrowing(JoinPoint joinPoint, InitProcessLog initProcessLog) {
        log.info("{} doAfterThrowing --> ", joinPoint.getSignature().toLongString());
    }
}
