package com.github.zhanglp92.aop.proxy.staticproxy;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * 狮子 实现了猫科动物接口Cat， 并实现了具体的行为。作为委托类实现
 */

@Log4j2
@Data
public class Lion implements Cat {
    private String name;

    private int runningSpeed;

    @Override
    public String eatFood(String foodName) {
        String eat = this.name + " Lion eat food. foodName = " + foodName;
        log.info("{}", eat);
        return eat;
    }

    @Override
    public boolean running() {
        log.info("{} Lion is running . Speed : {}", this.name, this.runningSpeed);
        return false;
    }
}
