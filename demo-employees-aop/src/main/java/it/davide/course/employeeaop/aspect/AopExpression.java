package it.davide.course.employeeaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

    @Pointcut("execution(* it.davide.course.employeeaop.controller.*.*(..))")
    public void forControllerPackage() {}

    @Pointcut("execution(* it.davide.course.employeeaop.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(* it.davide.course.employeeaop.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("forDaoPackage() || forServicePackage() || forControllerPackage()")
    public void forAppFlow() {}
}
