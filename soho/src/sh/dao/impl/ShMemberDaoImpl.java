package sh.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.dao.ShMemberDao;
import sh.model.ShMemberDto;

@Repository	// = 저장소
public class ShMemberDaoImpl implements ShMemberDao {
	
	@Autowired	// 의존성
	SqlSession sqlSession;
	
	String namespace = "ShMember.";

	@Override
	public boolean addmember(ShMemberDto mem) throws Exception {
		
		int n = sqlSession.insert(namespace + "addmember", mem);		
		return n>0?true:false;
	}

	@Override
	public ShMemberDto login(ShMemberDto mem) {		
		return sqlSession.selectOne(namespace + "login", mem);
	}	
	
	@Override
	public int getId(ShMemberDto mem) {		
		return sqlSession.selectOne(namespace + "getId", mem);		
	}
	
	
	
}






