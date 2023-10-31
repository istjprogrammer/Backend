package com.exam.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.exam.mybatis.memberMapper";
	
	@Override
	public void registerMember(RegisterRequest dto) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertMember", dto);	
	}

	@Override
	public Member selectMember(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectWithPass(String email, String pw) throws Exception {
		RegisterRequest rr = new RegisterRequest();
		rr.setEmail(email);
		rr.setPassword(pw);		
		
		return sqlSession.selectOne(NAMESPACE + ".selectWithPass", rr);
	}

}
