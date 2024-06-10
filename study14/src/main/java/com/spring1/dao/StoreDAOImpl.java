package com.spring1.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring1.dto.Store;

@Repository
public class StoreDAOImpl implements StoreDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Store> getStoreList() {
		return sqlSession.selectList("stage.getStoreList");
	}

	@Override
	public Store getStore(int storeNum) {
		return sqlSession.selectOne("stage.getStore", storeNum);
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("stage.maxNum");
	}

	@Override
	public void insStore(Store store) {
		sqlSession.insert("stage.insStore", store);	
	}

	@Override
	public void upStore(Store store) {
		sqlSession.update("stage.upStore", store);		
	}

	@Override
	public void delStore(Store store) {
		sqlSession.delete("stage.delStore", store);	
	}
	
}
