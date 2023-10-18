package basic08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("config/basic08_config.xml");
		
		MessageBean bean = ctx.getBean("msg", MessageBean.class);
		bean.sayHello();
		
	}
}