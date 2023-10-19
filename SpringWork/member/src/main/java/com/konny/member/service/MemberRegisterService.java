package com.konny.member.service;

import java.util.Date;

import com.konny.member.model.MemberDto;
import com.konny.member.model.RegisterRequest;
import com.konny.member.repository.MemberDao;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService() {}
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		//같은 이메일이 있는지 여부 검사
		
		MemberDto member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일이 있습니다.");
			return;
		}
		
		MemberDto newMem = new MemberDto(req.getEmail(), req.getName(), req.getPassword(),new Date());
		memberDao.insert(newMem);
	}
}