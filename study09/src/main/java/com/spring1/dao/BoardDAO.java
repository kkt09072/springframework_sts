package com.spring1.dao;

import java.util.List;

import com.spring1.dto.Board;

public interface BoardDAO {
	public List<Board> getBoardList();
	public Board getBoard(int bno);
	public int maxNum();
	public void insBoard(Board board);
	public void upBoard(Board board);
	public void delBoard(int bno);
}
