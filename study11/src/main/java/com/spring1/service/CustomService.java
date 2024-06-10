package com.spring1.service;

import java.util.List;

import com.spring1.dto.Custom;

public interface CustomService {
	public List<Custom> getCustomList();
	public Custom getCustom(String id);
	public int maxNum();
	public void insCustom(Custom custom);
	public void changePw(String pw);
	public void changeInfo(Custom custom);
	public void delCustom(String id);
}
