package com.spring1.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring1.dto.Custom;

@Repository
public class CustomDAOImpl implements CustomDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Custom> getCustomList() {
		return sqlSession.selectList("custom.getCustomList");
	}

	@Override
	public Custom getCustom(String id) {
		return sqlSession.selectOne("custom.getCustom", id);
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("custom.maxNum");
	}

	@Override
	public void insCustom(Custom custom) {
		sqlSession.insert("custom.insCustom", custom);		
	}

	@Override
	public void changePw(String pw) {
		sqlSession.update("custom.changePw", pw);
	}

	@Override
	public void changeInfo(Custom custom) {
		sqlSession.update("custom.changeInfo", custom);		
	}

	@Override
	public void delCustom(String id) {
		sqlSession.delete("custom.delCustom", id);		
	}
	
}
