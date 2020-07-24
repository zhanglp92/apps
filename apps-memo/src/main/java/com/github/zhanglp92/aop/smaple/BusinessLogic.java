package com.github.zhanglp92.aop.smaple;

import com.github.zhanglp92.aop.annotations.Todo;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BusinessLogic {
    public BusinessLogic() {
        super();
    }

    @Todo(priority = Todo.Priority.HIGH)
    public void notYetStartedMethod() {
        // No Code Written yet
    }

    @Todo(priority = Todo.Priority.MEDIUM, author = "Uday", status = Todo.Status.STARTED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet
    }

    @Todo(priority = Todo.Priority.LOW, status = Todo.Status.STARTED)
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
    }
}