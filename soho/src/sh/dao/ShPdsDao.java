package sh.dao;

import java.util.List;

import sh.model.ShPdsDto;

public interface ShPdsDao {
	
	public List<ShPdsDto> getShPdsList();		//����Ʈ �ѷ��ֱ�
	
	public boolean uploadPds(ShPdsDto dto);		//���� ���ε�

}
