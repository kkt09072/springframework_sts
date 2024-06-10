package com.spring1.service;

import java.util.List;

import com.spring1.dto.Free;

public interface FreeService {
	public int getTotalCount();
	public List<Free> getFreeList(int offset, int limit);
	public Free getFree(int no);
	public Free getNoCountFree(int no);
	public void insFree(Free free);
	public void upFree(Free free);
	public void hitCount(int no);
	public void delFree(int no);
}
