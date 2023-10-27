package com.exam.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.domain.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/*/.xml"})
public class BoardDaoImplTest {	
	@Autowired
    private BoardDao boardDao;

    @Test
    public void writeTest() throws Exception {
        // Board 생성자에 값 넣기
        Board dto = new Board("title1", "content1", "홍길동");
        // 1개가 저장된 것이 맞는지
        assertTrue(boardDao.write(dto) == 1);
    }
}