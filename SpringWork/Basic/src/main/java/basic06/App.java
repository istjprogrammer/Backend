package basic06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx ;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("config/basic06_config.xml");
		//ctx = new AnnotationConfigApplicationContext("basic06");
		
		MessageBean bean = ctx.getBean("msgKr", basic06.MessageBean.class);
		bean.sayHello();
		
		bean = ctx.getBean("messageBeanEn", basic06.MessageBean.class);
		bean.sayHello();
	}
}
