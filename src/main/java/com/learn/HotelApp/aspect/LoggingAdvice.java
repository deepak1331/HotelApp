package com.learn.HotelApp.aspect;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Log4j2
@Aspect
@Component
public class LoggingAdvice {

    // Pointcut for methods annotated with @LogExecutionTime
    //@Around("execution (* com.learn.HotelApp.controller.HotelController.*(..)")
    @Around("execution (* com.learn.HotelApp.service.HotelService.saveHotel(..))")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.info("Exiting Method: {}  Execution Time : {} ms",
                proceedingJoinPoint.getSignature().toString(), stopWatch.getTotalTimeMillis());
        return result;
    }

    @Pointcut("execution (public * com.learn.HotelApp.controller.HotelController.*(..))")
    private void publicMethodsFromHotelController() {
    }

    @Before(value = "publicMethodsFromHotelController()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Method Name : {}, Arguments : {}", methodName, args);
    }

}


/*
@Around("execution (* com.learn.HotelApp.service.HotelService.saveHotel(..))")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String methodSignature = proceedingJoinPoint.getSignature().toLongString();

        log.info("Entering method : {}", methodSignature);

        Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();
        log.info("Exiting Method: {}  Execution Time : {} ms", methodSignature, stopWatch.getTotalTimeMillis());
        return result;
    }

@Aspect
@Component
public class LoggingAspect {
}

@Around(value = "publicMethodsFromLoggingPackage()")
public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    Object[] args = joinPoint.getArgs();
    String methodName = joinPoint.getSignature().getName();
    logger.debug(">> {}() - {}", methodName, Arrays.toString(args));
    Object result = joinPoint.proceed();
    logger.debug("<< {}() - {}", methodName, result);
    return result;
}

@Pointcut("execution(public * com.baeldung.logging.*.*(..))")
private void publicMethodsFromLoggingPackage() {
}

@Test
void givenName_whenGreet_thenReturnCorrectResult() {
    String result = greetingService.greet("Baeldung");
    assertNotNull(result);
    assertEquals("Hello Baeldung", result);
}

>> greet() - [Baeldung]
        << greet() - Hello Baeldung


@Before(value = "publicMethodsFromLoggingPackage()")
public void logBefore(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    String methodName = joinPoint.getSignature().getName();
    logger.debug(">> {}() - {}", methodName, Arrays.toString(args));
}


@AfterReturning(value = "publicMethodsFromLoggingPackage()", returning = "result")
public void logAfter(JoinPoint joinPoint, Object result) {
    String methodName = joinPoint.getSignature().getName();
    logger.debug("<< {}() - {}", methodName, result);
}

@AfterThrowing(pointcut = "publicMethodsFromLoggingPackage()", throwing = "exception")
public void logException(JoinPoint joinPoint, Throwable exception) {
    String methodName = joinPoint.getSignature().getName();
    logger.error("<< {}() - {}", methodName, exception.getMessage());
}*/
