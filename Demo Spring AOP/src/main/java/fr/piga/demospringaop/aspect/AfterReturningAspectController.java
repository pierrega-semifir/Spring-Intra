package fr.piga.demospringaop.aspect;

import fr.piga.demospringaop.model.Employer;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAspectController {

    private static final Logger logger = LoggerFactory.getLogger(AfterReturningAspectController.class);
    private static final StringBuilder builder = new StringBuilder();

    @Pointcut("execution(* fr.piga.demospringaop.controller.EmployerController.save*(..))")
    public void controllerSavePointcut(){}

    @AfterReturning(value = "controllerSavePointcut()",  returning = "employer")
    public void afterReturningAddEmployerController(Employer employer){
        builder.append(employer.getName()).append(" a été ajouté à l'id ").append(employer.getId());
        logger.info(builder.toString());
    }
}
