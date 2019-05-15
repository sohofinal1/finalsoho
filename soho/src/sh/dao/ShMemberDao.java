package sh.dao;

import sh.model.ShMemberDto;

public interface ShMemberDao {

	public boolean addmember(ShMemberDto mem)throws Exception;
	
	public ShMemberDto login(ShMemberDto mem);
	
	public int getId(ShMemberDto mem);
}
