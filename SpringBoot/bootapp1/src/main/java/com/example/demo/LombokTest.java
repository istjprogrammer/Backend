package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//public class LombokTest {
//	/*변수 선언 private으로 선언되면 다른 클래스에서는 접근 불가능*/
//	private String hello;
//	private int count;
//	
//	public static void main(String[] args) {
//		LombokTest test = new LombokTest();
//		/*Lombok이 하는 역할이 getter/setter를 깔끔하게 추가해준다.*/
//		test.setHello("안녕하세요");
//		test.setCount(10);
//		
//		System.out.println(test.getHello());
//		System.out.println(test.getCount());
//		
//	}
//}

@Getter
@RequiredArgsConstructor
public class LombokTest {
	/*변수 선언 private으로 선언되면 다른 클래스에서는 접근 불가능*/
	private final String hello;
	private final int count;
	/*생성자로 선언하려면 final로 사용해야 한다.*/
	
	public static void main(String[] args) {
		LombokTest test = new LombokTest("안녕하세요", 100);
		/*Lombok이 하는 역할이 getter/setter를 깔끔하게 추가해준다.*/
				
		System.out.println(test.getHello());
		System.out.println(test.getCount());
		
	}
}
