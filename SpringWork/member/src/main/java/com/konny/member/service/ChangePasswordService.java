package com.konny.member.service;

import com.konny.member.model.MemberDto;
import com.konny.member.repository.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao;

	public ChangePasswordService() {}
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPass, String newPass) {
		//해당 이메일이 존재하는지 여부 검사
		MemberDto member = memberDao.selectByEmail(email);

		if(member == null) {
			System.out.println("해당 회원은 존재하지 않습니다.");
			return;
		}
		
		//현재 비밀번호가 맞는지 확인
		member.changePassword(oldPass, newPass);
		memberDao.update(member);
	}
}
