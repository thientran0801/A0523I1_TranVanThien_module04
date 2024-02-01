package com.example.borrowbooks.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAOP {
    private long countAccess = 0;
    @After("execution(* com.example.borrowbooks.controller.BookController.borow(..)) || execution(* com.example.borrowbooks.controller.BookController.returnBook(..))")
    public void afterChange(JoinPoint joinPoint) {
        System.out.println("The number of books has changed !");
    }

    @After("execution(* com.example.borrowbooks.controller.BookController.showList(..))")
    public void afterAllRun(JoinPoint joinPoint) {
        countAccess++;
        System.out.println("WELCOME TO LIBRARY : Access quantity: " + countAccess );
    }
}
