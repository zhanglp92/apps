package com.github.zhanglp92.service.impl;

import com.github.zhanglp92.service.MemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;


@Log4j2
@Service(value = "memoServiceImpl2")
public class MemoServiceImpl2 implements MemoService, BeanNameAware {

    private String memoName;

    @Override
    public void setBeanName(String name) {
        this.memoName = name;
    }

    @Override
    public String memo() {
        return "empty";
    }

    @Override
    public void interfaceMethod() {
    }
}
