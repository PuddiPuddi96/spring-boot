package it.davide.course.aop.aspect;

import it.davide.course.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(1)
@Aspect
@Component
public class DemoLoggingAspect {

    //Match only addAccount() method in AccountDao class
    //@Before("execution(public void it.davide.course.aop.dao.AccountDao.addAccount())")

    //Match on method names using wildcards
    //Match methods starting with add in any class
    //@Before("execution(public void add*())")

    //Match methods in any class starting with add and that have Account param
    //@Before("execution(* add*(it.davide.course.aop.model.Account))")

    //Match methods with Acocunt param and more param types (add .. -> any number of arguments)
    //@Before("execution(* add*(it.davide.course.aop.model.Account, ..))")

    //Match methods with any parameters
    //Always narrow the pointcut expression to our package
    //@Before("execution(* it.davide.course.aop..add*(..))")

    //Match methods in a package
    //First wildcard means any class, second one means any method
    //@Before("execution(* it.davide.course.aop.dao.*.*(..))")

    //Use wildcards on return type
    //@Before("execution(public * add*())")

    //Remember: modifier (ex. public) is optional
    //@Before("execution(* add*())")

    //Match any addAccount() method in any class (same signature)
    //@Before("execution(public void addAccount())")

    //Combine pointcut to match methods in DAO package and exclude getter/setter methods
    @Before("it.davide.course.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("\n====> @Before advice on method");

        //Display the method signature
        System.out.println("Method: " + joinPoint.getSignature());

        //Display method arguments
        Arrays.stream(joinPoint.getArgs()).toList().forEach(arg -> {
            if(arg instanceof Account account) {
                System.out.println("FirstName: " + account.getFirstName());
                System.out.println("LastName: " + account.getLastName());
            }
        });
    }

    @AfterReturning(
            pointcut = "execution(* it.davide.course.aop.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint joinPoint, List<Account> result) {

        System.out.println("\n====> Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());
        System.out.println("\n====> Result: " + result);
    }


}
