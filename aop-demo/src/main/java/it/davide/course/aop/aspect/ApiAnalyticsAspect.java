package it.davide.course.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class ApiAnalyticsAspect {

//    @Before("it.davide.course.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()")
//    public void performApiAnalytics() {
//        System.out.println("\n====> Performing api analytics");
//    }
}
