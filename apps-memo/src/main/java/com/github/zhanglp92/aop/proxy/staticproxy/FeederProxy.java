package com.github.zhanglp92.aop.proxy.staticproxy;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * 饲养员 实现Cat接口，作为静态代理类实现。代理狮子的行为。
 * 代理类中可以新增一些其他行为，在实践中主要做的是参数校验的功能。
 */

@Data
@Log4j2
public class FeederProxy implements Cat {
    private Cat cat;

    public FeederProxy(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String eatFood(String foodName) {
        log.info("proxy Lion exec eatFood ");
        return cat.eatFood(foodName);
    }

    @Override
    public boolean running() {
        log.info("proxy Lion exec running.");
        return cat.running();
    }
}
