package com.github.zhanglp92.service.impl;

import com.github.zhanglp92.aop.annotations.AOPPerformance;
import com.github.zhanglp92.aop.annotations.InitProcessLog;
import com.github.zhanglp92.commons.SpringContextUtil;
import com.github.zhanglp92.service.MemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.utilities.Assert;


@Log4j2
@Service(value = "memoServiceImpl")
public class MemoServiceImpl implements MemoService, BeanNameAware {

    private String memoName;

    @Override
//    @InitProcessLog
    public void setBeanName(String name) {
        this.memoName = name;
    }

    @Override
//    @InitProcessLog
    public String memo() {
//        this.memoInnerInvoke1();
        this.memoInnerInvoke2();
//        this.performance((int) 1E5);
        return this.memoName;
    }

    /**
     * 异常测试
     */
    @InitProcessLog
    public String memoException() {
        Assert.that(false, "异常测试");
        return this.memoName;
    }


    /**
     * 内部this指针调用
     */
    @InitProcessLog
    private String memoInnerInvoke() {
        this.notInterfaceMethod();
        this.interfaceMethod();
        return this.memoName;
    }

    /**
     * 内部this指针调用(不生效解法1)
     */
    @InitProcessLog
    private String memoInnerInvoke1() {
        SpringContextUtil.getBean(this.getClass()).interfaceMethod();
        SpringContextUtil.getBean(this.getClass()).notInterfaceMethod();
        return this.memoName;
    }

    /**
     * 内部this指针调用(不生效解法2)
     */
    private String memoInnerInvoke2() {
        MemoServiceImpl memoService = (MemoServiceImpl) AopContext.currentProxy();

        log.info("私有方法不调用吗 ---->");
        memoService.notInterfaceMethod();
        log.info("私有方法不调用吗 ---->");

        memoService.interfaceMethod();
        return this.memoName;
    }

    @InitProcessLog
    protected String notInterfaceMethod() {
        return "xx 私有";
    }

    @Override
    @InitProcessLog
    public void interfaceMethod() {
    }

    /**
     * 使用AOP和不使用AOP性能测试
     */
    protected void performance(int n) {
        MemoServiceImpl memoService = SpringContextUtil.getBean(this.getClass());

        long beginTime, endTime, useTime;

        beginTime = System.currentTimeMillis();
        for (int idx = 0; idx < n; idx++) {
            memoService.noAopTest();
        }
        useTime = (endTime = System.currentTimeMillis()) - beginTime;
        log.info("无注解调用耗时, {}, ({}-{})/{}={}", useTime, endTime, beginTime, n, useTime / n);


        beginTime = System.currentTimeMillis();
        for (int idx = 0; idx < n; idx++) {
            memoService.aopTest();
        }
        useTime = (endTime = System.currentTimeMillis()) - beginTime;
        log.info("有注解调用耗时, {}, ({}-{})/{}={}", useTime, endTime, beginTime, n, useTime / n);
    }

    protected void noAopTest() {
    }

    @AOPPerformance
    protected void aopTest() {
    }

}
