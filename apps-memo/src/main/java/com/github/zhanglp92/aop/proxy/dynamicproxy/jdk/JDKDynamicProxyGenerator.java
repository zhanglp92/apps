package com.github.zhanglp92.aop.proxy.dynamicproxy.jdk;

import com.github.zhanglp92.aop.proxy.dynamicproxy.IAspect;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态生成JDK代理
 */
@Log4j2
public class JDKDynamicProxyGenerator {

    public static <T> T generatorJDKProxy(Class<T> clazz, T targetPoint, final IAspect aspect) {
        return clazz.cast(Proxy.newProxyInstance(
                targetPoint.getClass().getClassLoader(),
                targetPoint.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (aspect.startTransaction(args)) {
                        Object response = method.invoke(targetPoint, args);
                        aspect.endTransaction();
                        return response;
                    } else {
                        throw new RuntimeException("args: " + Arrays.toString(args) + "不能为null");
                    }
                }));
    }
}
