package com.github.zhanglp92.service.impl;

import com.github.zhanglp92.aop.annotations.InitProcessLog;
import com.github.zhanglp92.service.MemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;


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
    @InitProcessLog
    public String memo() {
        this.notInterfaceMethod();
        this.interfaceMethod();

        // Assert.that(false, "异常测试");
        return this.memoName;
    }

    @InitProcessLog
    public String notInterfaceMethod() {
        return "xx";
    }

    @Override
    @InitProcessLog
    public void interfaceMethod() {
    }

}
