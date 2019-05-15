package sh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sh.dao.ShPdsDao;
import sh.model.ShPdsDto;
import sh.service.ShPdsService;

@Service
public class ShPdsServiceImpl implements ShPdsService {


	@Autowired
	ShPdsDao ShPdsDao;
	
	@Override
	public List<ShPdsDto> getShPdsList() {
		return ShPdsDao.getShPdsList();
	}

	@Override
	public boolean uploadPds(ShPdsDto dto) {

		return ShPdsDao.uploadPds(dto);
	}
}
