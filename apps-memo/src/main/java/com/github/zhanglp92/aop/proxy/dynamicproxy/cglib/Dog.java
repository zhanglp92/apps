package com.github.zhanglp92.aop.proxy.dynamicproxy.cglib;

import lombok.extern.log4j.Log4j2;

/**
 * 业务类实现
 */

@Log4j2
public class Dog {
    public String call() {
        log.info("wang wang wang");
        return "Dog ..";
    }

    public String call(String voice) {
        log.info("{} {} {}", voice, voice, voice);
        return "Dog ..";
    }
}
