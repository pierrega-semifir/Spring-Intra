package fr.piga.demospringaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspectController {

    private static final Logger logger = LoggerFactory.getLogger(AroundAspectController.class);

    @Pointcut("execution(* fr.piga.demospringaop.controller.*Controller.*(..))")
    public void controllerPointCut(){}

    @Around("controllerPointCut()")
    public Object aroundAdviceController(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Around request " + joinPoint.getSignature());

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executiontime = System.currentTimeMillis() - start;

        logger.info("La requete à mis " + executiontime);
        return result;
    }
}
