package com.spring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring1.dao.BoardDAO;
import com.spring1.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<Board> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Transactional
	@Override
	public Board getBoard(int bno) {
		boardDAO.upCount(bno);
		return boardDAO.getBoard(bno);
	}

	@Override
	public Board selBoard(int bno) {
		return boardDAO.getBoard(bno);
	}
	
	@Override
	public int maxNum() {
		return boardDAO.maxNum();
	}

	@Override
	public void insBoard(Board board) {
		boardDAO.insBoard(board);
	}

	@Override
	public void upBoard(Board board) {
		boardDAO.upBoard(board);
	}

	@Override
	public void delBoard(int bno) {
		boardDAO.delBoard(bno);		
	}
	
}
