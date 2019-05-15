package sh.service;

import java.util.List;

import sh.model.ShPdsDto;

public interface ShPdsService {

	public List<ShPdsDto> getShPdsList();
	
	public boolean uploadPds(ShPdsDto dto);
}
