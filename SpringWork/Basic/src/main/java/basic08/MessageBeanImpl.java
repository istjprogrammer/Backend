package basic08;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	
	@Autowired
	@Qualifier("out1")
	private Outputter outputter;
	
	public MessageBeanImpl() {}
	public MessageBeanImpl(String name, int age, String greeting) {
		this.name = name;
		this.age = age;
	}
	
	/*
	public MessageBeanImpl(Outputter outputter) {
		this.outputter = outputter;
	}*/
	
	@Autowired
	@Qualifier("out1")
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }
	public MessageBeanImpl(Outputter outputter) {
		this.outputter = outputter;
	}
	
	/*
	@Autowired
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	*/
	
	@Override
	public void sayHello() {
		String msg = name + "님~~ 이제 당신은 " + age + "살 입니다.^^";
		System.out.println(msg);
		
		try {
			outputter.output(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
