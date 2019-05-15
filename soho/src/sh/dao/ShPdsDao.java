package sh.dao;

import java.util.List;

import sh.model.ShPdsDto;

public interface ShPdsDao {
	
	public List<ShPdsDto> getShPdsList();		//리스트 뿌려주기
	
	public boolean uploadPds(ShPdsDto dto);		//파일 업로드

}
