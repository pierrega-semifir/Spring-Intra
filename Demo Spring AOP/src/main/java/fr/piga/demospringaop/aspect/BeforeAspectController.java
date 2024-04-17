package fr.piga.demospringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class BeforeAspectController {

    private static final Logger logger = LoggerFactory.getLogger(BeforeAspectController.class);

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.get*(..))")
    public void controllerGetPointcut(){}

    @Before("controllerGetPointcut()")
    public void beforeAdviceController(JoinPoint joinPoint) {
        logger.info("Before Request a la couche controller sur les methode get" + joinPoint.getSignature() + " a la date du : " + new Date());
    }
}
