package it.davide.course.employeeaop.aspect;

import it.davide.course.employeeaop.entity.Employee;
import org.aspectj.lang.JoinPoint;
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
        Arrays.stream(joinPoint.getArgs()).toList().forEach(arg -> {
            logger.log(Level.INFO, "=====>> in @Before: arg {0}", arg);
//            if(arg instanceof Employee employee) {
//                logger.log(Level.INFO, "=====>> in @Before: Employee {0}", employee);
//                logger.log(Level.INFO, "=====>> in @Before: Employee first name {0}", employee.getFirstName());
//                logger.log(Level.INFO, "=====>> in @Before: Employee last name {0}", employee.getLastName());
//            }
        });
    }

}

