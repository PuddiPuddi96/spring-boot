package it.davide.lascaux.challenge.cinemille.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

    @Pointcut("execution(* it.davide.lascaux.challenge.cinemille.rest.*.*(..))")
    public void forRestPackage() {}

    @Pointcut("execution(* it.davide.lascaux.challenge.cinemille.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(* it.davide.lascaux.challenge.cinemille.repository.*.*(..))")
    public void forRepositoryPackage() {}

    @Pointcut("execution(* it.davide.lascaux.challenge.cinemille.handler.exception.*.*(..))")
    public void forHandlerExceptionPackage() {}

    @Pointcut("forRepositoryPackage() || forServicePackage() || forRestPackage() || forHandlerExceptionPackage()")
    public void forAppFlow() {}

}
