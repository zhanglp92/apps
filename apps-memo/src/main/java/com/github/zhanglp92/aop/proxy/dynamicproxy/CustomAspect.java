package com.github.zhanglp92.aop.proxy.dynamicproxy;

import lombok.extern.log4j.Log4j2;

import java.util.Objects;

/**
 * 改类作为AOP 模型中切面角色类， 实现切面接口，切面接口定义了两个切面方法，分别在切点接口方法执行前和执行后执行
 */
@Log4j2
public class CustomAspect implements IAspect {

    /**
     * 对参数判空, args切点参数
     */
    @Override
    public boolean startTransaction(Object... args) {
        for (Object temp : args) {
            if (Objects.isNull(temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void endTransaction() {
        log.info("I get data source here and end transaction");
    }
}
