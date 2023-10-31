package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;
import com.exam.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void registerMember(RegisterRequest dto) throws Exception {
		memberDao.registerMember(dto);
	}

	@Override
	public Member selectMember(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectWithPass(String email, String pw) throws Exception {
		memberDao.selectWithPass(email, pw);
		return null;
	}

}
