package com.exam.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.domain.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.exam.mybatis.boardMapper";
	
	@Override
	public List<Board> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".getList");
	}

	@Override
	public Board read(int bNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bNo);
	}

	@Override
	public int write(Board board) throws Exception {
		return sqlSession.insert(NAMESPACE + ".write", board);
	}

	@Override
	public int update(Board board) throws Exception {
		return 0;
	}

	@Override
	public int delete(int bNo) throws Exception {
		return 0;
	}
}
