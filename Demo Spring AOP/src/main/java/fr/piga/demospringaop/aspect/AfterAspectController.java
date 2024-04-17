package fr.piga.demospringaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Aspect
public class AfterAspectController {

    private static final Logger logger = LoggerFactory.getLogger(AfterAspectController.class);

    @Pointcut("within(fr.piga.demospringaop.controller.EmployerController)")
    public void controllerPointcut(){}

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.get*(..))")
    public void controllerGetPointcut(){}

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.save*(..))")
    public void controllerSavePointcut(){}

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.delete*(..))")
    public void controllerDeletePointcut(){}

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.*(Long))")
    public void controllerArgsLongPointcut(){}

    @Pointcut("controllerGetPointcut() && controllerArgsLongPointcut()")
    public void controllerGetAndLongPointcut(){}

    @After("controllerPointcut()")
    public void afterAdviceController (JoinPoint joinPoint) {
        logger.info("After Request de la couche controller" + joinPoint.getThis() + " a la date de : "+ new Date());
    }

    @After("controllerGetPointcut()")
    public void afterAdviceGetController (JoinPoint joinPoint) {
        logger.info("After Request des methode get" + joinPoint.getThis() + " a la date de : "+ new Date());
    }

    @After("controllerSavePointcut()")
    public void afterAdviceAddController (JoinPoint joinPoint) {
        logger.info("After Request des methode save" + joinPoint.getThis() + " a la date de : "+ new Date());
    }

    @After("controllerDeletePointcut()Pointcut()")
    public void afterAdviceDeleteController (JoinPoint joinPoint) {
        logger.info("After Request des methode delete" + joinPoint.getThis() + " a la date de : "+ new Date());
    }

    @After("controllerArgsLongPointcut()Pointcut()")
    public void afterAdviceLongController (JoinPoint joinPoint) {
        logger.info("After Request des methode manipulant un long" + joinPoint.getThis() + " a la date de : "+ new Date());
    }


}
