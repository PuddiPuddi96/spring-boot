package it.davide.course.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //This annotation is optional if you only have pointcuts
public class AopExpression {

    @Pointcut("execution(* it.davide.course.aop.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* it.davide.course.aop.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* it.davide.course.aop.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

    @Pointcut("execution(* it.davide.course.aop.dao.AccountDao.findAccounts(..))")
    public void forFindAccounts() {}

    @Pointcut("execution(* it.davide.course.aop.service.*.getFortune(..))")
    public void forGetFortune() {}
}
