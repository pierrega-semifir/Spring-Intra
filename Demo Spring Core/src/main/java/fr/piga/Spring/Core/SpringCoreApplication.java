package fr.piga.Spring.Core;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SpringCoreApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringCoreApplication.class);

		Voiture voiture = context.getBean(Voiture.class);
		Voiture peugeot = context.getBean(Voiture.class);
		voiture.rouler();
		peugeot.rouler();

		MonBean bean1 = context.getBean(MonBean.class);
		MonBean bean2 = context.getBean(MonBean.class);

		System.out.println(bean1 == bean2);

	}

}
