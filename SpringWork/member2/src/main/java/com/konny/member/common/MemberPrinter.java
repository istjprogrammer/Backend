package com.konny.member.common;

import org.springframework.stereotype.Component;

import com.konny.member.model.MemberDto;
@Component
public class MemberPrinter {
	public void print(MemberDto member) {
		System.out.printf("회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), member.getEmail(), member.getName(),
				member.getRegisterDate());
	}
}
