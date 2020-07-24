package com.github.zhanglp92.aop.proxy.dynamicproxy.cglib;

import com.github.zhanglp92.aop.proxy.dynamicproxy.CustomAspect;
import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.core.DebuggingClassWriter;

import java.lang.reflect.Field;
import java.util.Properties;

@Log4j2
public class CglibMethodInterceptorTest {

    public static void main(String[] args) throws Exception {
        CglibMethodInterceptorTest cglibMethodInterceptorTest = new CglibMethodInterceptorTest();
//        cglibMethodInterceptorTest.cglib1();
        cglibMethodInterceptorTest.cglib2();
    }

    public void cglib2() {
        Dog dog = CglibProxyGenerator.generatorCglibProxy(Dog.class, new Dog(), new CustomAspect());
        dog.call();
        dog.call("ha");
        dog.call(null);
    }

    /**
     * 同cglib1
     */
    public void cglib1() throws Exception {
        CglibMethodInterceptorTest.saveGeneratedJdkProxyFiles("user.dir");
        Dog dog = new CglibMethodInterceptor().cglibProxyGenerator(Dog.class);
        log.info("call -- {}", dog.call());
    }

    /**
     * 设置保存Java动态代理生成的类文件。
     */
    public static void saveGeneratedJdkProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }
}
