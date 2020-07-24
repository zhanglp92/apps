package com.github.zhanglp92.aop.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Todo {
    enum Priority {LOW, MEDIUM, HIGH}

    enum Status {STARTED, NOT_STARTED}

    String author() default "Zhanglp";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
