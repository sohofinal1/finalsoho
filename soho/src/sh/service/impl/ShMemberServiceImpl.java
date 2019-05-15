package sh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sh.dao.ShMemberDao;
import sh.dao.impl.ShMemberDaoImpl;
import sh.model.ShMemberDto;
import sh.service.ShMemberService;

@Service
public class ShMemberServiceImpl implements ShMemberService {
	
	@Autowired
	ShMemberDao ShMemberDao;

	@Override
	public boolean addmember(ShMemberDto mem) throws Exception {		
		return ShMemberDao.addmember(mem);		
	}

	@Override
	public ShMemberDto login(ShMemberDto mem) {		
		return ShMemberDao.login(mem);		
	}
	
	@Override
	public int getId(ShMemberDto mem) {		
		return ShMemberDao.getId(mem);		
	}

}




