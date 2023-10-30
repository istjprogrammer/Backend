package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;
import com.exam.repository.BoardDaoImpl;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getList() throws Exception {
		List<Board> list = boardDao.getList();
		return list;
	}

	@Override
	public Board read(int bNo) throws Exception {
		return boardDao.read(bNo);
	}

	@Override
	public void write(Board board) throws Exception {
		boardDao.write(board);
	}

	@Override
	public void update(Board board) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bNo) throws Exception {
		// TODO Auto-generated method stub

	}
}
