package com.github.zhanglp92.aop.proxy.dynamicproxy.jdk;

import com.github.zhanglp92.aop.proxy.dynamicproxy.MonitorUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

@Log4j2
@AllArgsConstructor
public class PersonInvocationHandler<T> implements InvocationHandler {
    /**
     * 被代理对象引用，invoke 方法里面method 需要使用这个 被代理对象
     */
    private T target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /* 在转调具体目标对象之前，可以执行一些功能处理 */
        log.info("被动态代理类回调执行, 代理类 proxyClass ={} 方法名: {} 方法. 方法返回类型：{} 接口方法入参数组: {}", proxy.getClass(), method.getName(), method.getReturnType(), (args == null ? "null" : Arrays.toString(args)));

        /* 代理过程中插入监测方法,计算该方法耗时 */
        MonitorUtil.start();

        /* 调用呗代理对象的真实方法，*/
        Thread.sleep(1);

        Object result = method.invoke(target, args);

        MonitorUtil.finish(method.getName());
        return result;
    }
}
