package com.github.zhanglp92.launcher;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 备忘录APP的主入口
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.github.zhanglp92.*"})
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Log4j2
public class MemoLauncher extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    public static void main(String[] args) {
        SpringApplication.run(MemoLauncher.class, args);
    }
}
