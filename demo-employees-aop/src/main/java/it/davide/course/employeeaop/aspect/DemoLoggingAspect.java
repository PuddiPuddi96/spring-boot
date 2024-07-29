package it.davide.course.employeeaop.aspect;

import it.davide.course.employeeaop.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Before("it.davide.course.employeeaop.aspect.AopExpression.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.log(Level.INFO, "=====>> in @Before: calling method {0}", method);

        //Display method arguments
        Arrays.stream(
                joinPoint.getArgs())
                .toList()
                .forEach(arg ->
                        logger.log(Level.INFO, "=====>> in @Before: arg {0}", arg));
    }

    @AfterReturning(
            pointcut = "it.davide.course.employeeaop.aspect.AopExpression.forAppFlow()",
            returning = "result")
    public void afterReturning(
            JoinPoint joinPoint,
            Object result) {

        //Display method we are returning from
        logger.log(
                Level.INFO,
                "=====>> in @AfterReturning: from method {0}",
                joinPoint.getSignature().toShortString());


        //Display data returned
        logger.log(
                Level.INFO,
                "=====>> in @AfterReturning: result {0}",
                result);

    }

}

