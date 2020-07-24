package com.github.zhanglp92.aop.proxy.dynamicproxy.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * 动态代理委托类实现， 实现接口 Person。 被动态生成的代理类代理
 */
@Data
@Log4j2
@AllArgsConstructor
public class SoftwareEngineer implements Person {
    private String name;

    @Override
    public void goWorking(String source, String dst) {
        log.info("name ={}, 从{}去{}工作", name, source, dst);
    }
}