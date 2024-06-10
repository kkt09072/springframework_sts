package com.spring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring1.dao.FreeDAO;
import com.spring1.dto.Free;

@Service
public class FreeServiceImpl implements FreeService {

	@Autowired
	private FreeDAO freeDAO;
		
	
	@Override
	public int getTotalCount() {
		return freeDAO.getTotalCount();
	}

	@Override
	public List<Free> getFreeList(int offset, int limit) {
		return freeDAO.getFreeList(offset, limit);
	}

	@Override
	@Transactional
	public Free getFree(int no) {
		freeDAO.hitCount(no);
		return freeDAO.getFree(no);
	}

	@Override
	public Free getNoCountFree(int no) {
		return freeDAO.getFree(no);
	}

	@Override
	public void insFree(Free free) {
		freeDAO.insFree(free);		
	}

	@Override
	public void upFree(Free free) {
		freeDAO.upFree(free);		
	}

	@Override
	public void hitCount(int no) {
		freeDAO.hitCount(no);		
	}

	@Override
	public void delFree(int no) {
		freeDAO.delFree(no);		
	}	
}
