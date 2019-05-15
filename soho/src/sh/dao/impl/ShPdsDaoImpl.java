package sh.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.dao.ShPdsDao;
import sh.model.ShPdsDto;

@Repository
public class ShPdsDaoImpl implements ShPdsDao {

	@Autowired
	SqlSession sqlSession;
	
	String ns = "ShPds.";
	
	@Override
	public List<ShPdsDto> getShPdsList() {
		return sqlSession.selectList(ns + "getPdsList");
	}

	@Override
	public boolean uploadPds(ShPdsDto dto) {
		int n = sqlSession.insert(ns + "uploadPds", dto);
		return n>0?true:false;		//3항연산자야 ! 크면 true로 반환
	}
	

}
