package it.davide.course.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Aspect
@Component
public class CloudLogAsyncAspect {

//    @Before("it.davide.course.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()")
//    public void logToCloudAsync() {
//        System.out.println("\n====> Logging to Cloud in async function ");
//    }
}
