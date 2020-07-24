package com.github.zhanglp92.aop.proxy.dynamicproxy.cglib;

import com.github.zhanglp92.aop.proxy.dynamicproxy.MonitorUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 */
@Log4j2
public class CglibMethodInterceptor implements MethodInterceptor {

    /**
     * 代理生成
     */
    public <T> T cglibProxyGenerator(Class<T> target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(this);
        return target.cast(enhancer.create());
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("方法拦截 before...");

        MonitorUtil.start();

        Object response = methodProxy.invokeSuper(o, objects);

        MonitorUtil.finish(method.getName());

        log.info("方法拦截 after");

        return response;
    }
}
