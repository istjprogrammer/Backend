package basic06;

import org.springframework.stereotype.Component;

@Component("msgKr")
public class MessageBeanKr implements MessageBean{
	private String name;
	private int age;
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }

	public void sayHello() {
		System.out.println("나의 이름은 " + name + "이고 나이는 " +
				age + "살 입니다.");
	}
}
