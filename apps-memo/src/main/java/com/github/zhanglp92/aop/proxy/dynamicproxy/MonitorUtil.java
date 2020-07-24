package com.github.zhanglp92.aop.proxy.dynamicproxy;

import lombok.extern.log4j.Log4j2;

/**
 * 方法调用时监控
 */
@Log4j2
public class MonitorUtil {
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    public static void finish(String methodName) {
        long ut = System.currentTimeMillis() - tl.get();
        log.info("{} 方法执行耗时 = {}ms", methodName, ut);
    }
}
