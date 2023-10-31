package com.exam.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.domain.Board;
import com.exam.domain.RegisterRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoImplTest {
	@Autowired
	private MemberDao memberDao;
	
	
	public void registerTest() throws Exception {
		RegisterRequest regreq = new RegisterRequest();
		regreq.setEmail("java@test.com");
		regreq.setName("이현재");
		regreq.setPassword("1111");
		
		memberDao.registerMember(regreq);
	}
	
	@Test
	public void testSelectWithPass() throws Exception {
		assertNotNull(memberDao.selectWithPass("java@test.com", "1111"));
		assertNull(memberDao.selectWithPass("java@test.com", "2222"));
	}
}











