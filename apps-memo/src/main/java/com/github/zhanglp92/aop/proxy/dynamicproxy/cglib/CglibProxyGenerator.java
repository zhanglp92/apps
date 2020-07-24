package com.github.zhanglp92.aop.proxy.dynamicproxy.cglib;

import com.github.zhanglp92.aop.proxy.dynamicproxy.IAspect;
import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.Arrays;

/**
 * cglib 动态代理生成器
 */
@Log4j2
public class CglibProxyGenerator {

    public static <T> T generatorCglibProxy(Class<T> clazz, final Object target, IAspect aspect) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            if (aspect.startTransaction(objects)) {
                Object response = methodProxy.invokeSuper(o, objects);
                aspect.endTransaction();
                return response;
            } else {
                throw new RuntimeException("args: " + Arrays.toString(objects) + "不能为null");
            }
        });
        return clazz.cast(enhancer.create());
    }
}
