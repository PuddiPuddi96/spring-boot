package it.davide.lascaux.challenge.cinemille.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class CineMilleLoggingAspect {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Before("it.davide.lascaux.challenge.cinemille.aspect.AopExpression.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.log(Level.INFO, "[START] -> {0}", method);
    }

    @AfterReturning(pointcut = "it.davide.lascaux.challenge.cinemille.aspect.AopExpression.forAppFlow()")
    public void afterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.log(Level.INFO, "[END] -> {0}", method);
    }

}
