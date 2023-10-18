package basic07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApplicationContextConfigure {
	@Bean
	public MessageBean getMessageKr() {
		MessageBeanKr kr = new MessageBeanKr();
		kr.setAge(20);
		kr.setName("신돌석");
		kr.setOutputter(output());
		return kr;
	}
	
	@Bean
	public MessageBean getMessageEn() {
		MessageBeanEn en = new MessageBeanEn();
		en.setAge(30);
		en.setName("Tom");
		en.setOutputter(output());
		return en;
	}
	
	@Bean
	public Outputter output() {
		FileOutputter f = new FileOutputter();
		f.setFilePath("c:\\temp\\out.txt");
		return f;
	}
}
