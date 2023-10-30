package com.exam.service;

import java.util.List;

import com.exam.domain.Board;

public interface BoardService {
	public List<Board> getList() throws Exception;
	public Board read(int bNo) throws Exception;
	public void write(Board board) throws Exception;
	public void update(Board board) throws Exception;
	public void delete(int bNo) throws Exception;
}
