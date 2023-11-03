package com.example.demo.domain;

import lombok.Data;

/*@Data는 getter와 setter를 하나로 묶어서 만들어 준 어노테이션이다.*/
@Data
public class Member {
	private String num, name, addr;
}
