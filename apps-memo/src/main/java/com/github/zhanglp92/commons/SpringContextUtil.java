package com.github.zhanglp92.commons;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SpringContextUtil implements InitializingBean {
    @Autowired
    private ApplicationContext ctx;

    private static SpringContextUtil springContextUtil;

    @Override
    public void afterPropertiesSet() throws Exception {
        springContextUtil = ctx.getBean(SpringContextUtil.class);
    }

    public static <T> T getBean(Class<T> beanType) {
        return springContextUtil.ctx.getBean(beanType);
    }

    public static Object getBean(String name) {
        return springContextUtil.ctx.getBean(name);
    }

    public static Object getCtx() {
        return springContextUtil.ctx;
    }
}