package com.github.zhanglp92.aop.proxy.staticproxy;


/**
 * 静态代理类接口, 委托类和代理类都需要实现的接口规范
 */
public interface Cat {

    String eatFood(String foodName);

    boolean running();
}
