package com.github.zhanglp92.aop.smaple;

import com.github.zhanglp92.aop.annotations.Todo;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Method;

@Log4j2
public class TodoReport {
    public TodoReport() {
        super();
    }

    public static void main(String[] args) {
        getTodoReportForBusinessLogic();
    }

    /**
     * 解析使用注解的类，获取通过注解设置的属性
     */
    private static void getTodoReportForBusinessLogic() {
        for (Method method : BusinessLogic.class.getMethods()) {
            Todo todoAnnotation = method.getAnnotation(Todo.class);
            if (todoAnnotation != null) {
                log.info(" Method Name : " + method.getName());
                log.info(" Author : " + todoAnnotation.author());
                log.info(" Priority : " + todoAnnotation.priority());
                log.info(" Status : " + todoAnnotation.status());
                log.info(" --------------------------- ");
            }
        }
    }
}