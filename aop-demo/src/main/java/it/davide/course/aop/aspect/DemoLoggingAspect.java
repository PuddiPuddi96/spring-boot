package it.davide.course.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    //Match only addAccount() method in AccountDao class
    //@Before("execution(public void it.davide.course.aop.dao.AccountDao.addAccount())")

    //Match on method names using wildcards
    //Match methods starting with add in any class
    //@Before("execution(public void add*())")

    //Use wildcards on return type
    //@Before("execution(public * add*())")

    //Remember: modifier (ex. public) is optional
    //@Before("execution(* add*())")

    //Match any addAccount() method in any class (same signature)
    @Before("execution(public void addAccount())")
    public void beforeAddAccount() {
        System.out.println("\nBefore addAccount: Any addAccount() method in any class");
    }
}
