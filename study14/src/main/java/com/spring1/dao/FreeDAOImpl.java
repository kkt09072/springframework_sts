package com.spring1.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring1.dto.Free;

@Repository
public class FreeDAOImpl implements FreeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("free.getTotalCount");
	}

    @Override
    public List<Free> getFreeList(int offset, int limit) {
        return sqlSession.selectList("free.getFreeList", new RowBounds(offset, limit));
    }

	@Override
	public Free getFree(int no) {
		return sqlSession.selectOne("free.getFree", no);
	}

	@Override
	public void insFree(Free free) {
		sqlSession.insert("free.insFree", free);
	}

	@Override
	public void upFree(Free free) {
		sqlSession.update("free.upFree", free);
	}

	@Override
	public void hitCount(int no) {
		sqlSession.update("free.hitCount", no);		
	}

	@Override
	public void delFree(int no) {
		sqlSession.delete("free.delFree", no);
	}
}
