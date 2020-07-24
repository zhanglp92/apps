package com.github.zhanglp92.aop.proxy.dynamicproxy.jdk;

/**
 * 创建Person 接口 用于定义 委托类和代理类之间的约束行为
 */
public interface Person {
    /**
     * @param name 人名
     * @param dst  工作目的地
     */
    void goWorking(String name, String dst);

    /**
     * 获取名称
     */
    String getName();

    /**
     * 设置名称
     */
    void setName(String name);
}