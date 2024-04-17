package fr.piga.demospringaop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspectController {

    private static final Logger logger = LoggerFactory.getLogger(AfterThrowingAspectController.class);

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.save*(..))")
    public void controllerSavePointcut(){}

    @AfterThrowing(value ="controllerSavePointcut()", throwing = "exception")
    public void afterThrowingAdviceController( Exception exception) {
        logger.error("L'exception suivte à été levée : " + exception.getMessage());
    }
}
