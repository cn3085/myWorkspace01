package org.spring.mvc.persistence;

import java.util.List;

import org.spring.mvc.domain.MemberDTO;

public interface MemberDAO {
		
	public int memberInsert(MemberDTO dto);
	public MemberDTO memberSelect(String email);
	public List<MemberDTO> memberListSelect();
	public void memberRemove(String eamil);
	public void memberEdit(MemberDTO dto);
}
