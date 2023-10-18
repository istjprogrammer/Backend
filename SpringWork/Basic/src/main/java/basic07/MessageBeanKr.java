package basic07;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Component("msgKr")
public class MessageBeanKr implements MessageBean {
	
	private String name;
	private int age;
	private Outputter outputter;
	
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	public void sayHello()  {
		System.out.println("나의 이름은 " + name + "이고 나이는 "+ age +"살 입니다.");
		try {
			outputter.output("나의 이름은 " + name + "이고 나이는 "+ age +"살 입니다.");
		} catch (IOException e) {e.printStackTrace();}
		
		System.out.println("MessageBeanKr : " + outputter.toString());
	}	
}