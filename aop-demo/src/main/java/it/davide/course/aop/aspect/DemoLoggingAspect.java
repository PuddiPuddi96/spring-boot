package it.davide.course.aop.aspect;

import it.davide.course.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
//    @Before("it.davide.course.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()")
//    public void beforeAddAccount(JoinPoint joinPoint) {
//        System.out.println("\n====> @Before advice on method");
//
//        //Display the method signature
//        System.out.println("Method: " + joinPoint.getSignature());
//
//        //Display method arguments
//        Arrays.stream(joinPoint.getArgs()).toList().forEach(arg -> {
//            if(arg instanceof Account account) {
//                System.out.println("FirstName: " + account.getFirstName());
//                System.out.println("LastName: " + account.getLastName());
//            }
//        });
//    }
//
//    @AfterReturning(
//            pointcut = "it.davide.course.aop.aspect.AopExpression.forFindAccounts()",
//            returning = "result")
//    public void afterReturningFindAccountsAdvice(
//            JoinPoint joinPoint, List<Account> result) {
//
//        System.out.println("\n====> Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());
//        System.out.println("\n====> Result: " + result);
//
//        result.forEach(account ->
//                account.setLastName(
//                        account.getLastName().toUpperCase()));
//    }

//    @AfterThrowing(
//            pointcut = "it.davide.course.aop.aspect.AopExpression.forFindAccounts()",
//            throwing = "exception")
//    public void afterThrowingFindAccountsAdvice(
//            JoinPoint joinPoint,
//            Throwable exception){
//        //print out which method we are advising on
//        System.out.println("\n====> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());
//
//        //print out the exception
//        System.out.println("\n====> The exception is: " + exception);
//    }

    @After("it.davide.course.aop.aspect.AopExpression.forFindAccounts()")
    public void afterFinallyFindAccountsAfvice(
            JoinPoint joinPoint) {
        //print out which method we are advising on
        System.out.println("\n====> Executing @After (finally) on method: " + joinPoint.getSignature().toShortString());
    }

    @Around("it.davide.course.aop.aspect.AopExpression.forGetFortune()")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {
        //Print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //execute the method
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e) {
            System.out.println("\n====> Exception: " + e.getMessage());
            //result = "Major accident! But no worries, your private AOP helicopter is on the way!";

            //Rethrow exception
            throw e;
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and print out it
        long duration = end - begin;
        System.out.println("\n====> duration: " + duration/1000.0 + " seconds");

        return result;
    }

}
