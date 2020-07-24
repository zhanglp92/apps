package com.github.zhanglp92.aop.proxy.dynamicproxy;

/**
 * 定义切面接口，切面接口定义了两个切面方法，分别在切点接口方法执行前和执行后执行
 */
public interface IAspect {
    /**
     * 在切点接口方法执行之前执行
     */
    boolean startTransaction(Object... args);

    /**
     * 在切点接口方法执行之后执行
     */
    void endTransaction();
}
