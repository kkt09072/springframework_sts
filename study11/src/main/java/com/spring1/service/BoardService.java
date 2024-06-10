package com.spring1.service;

import java.util.List;

import com.spring1.dto.Board;

public interface BoardService {
	public List<Board> getBoardList();
	public Board getBoard(int bno);
	public Board selBoard(int bno);
	public int maxNum();
	public void insBoard(Board board);
	public void upBoard(Board board);
	public void delBoard(int bno);
}
