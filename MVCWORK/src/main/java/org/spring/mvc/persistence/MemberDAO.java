package org.spring.mvc.persistence;

import org.spring.mvc.domain.MemberDTO;

public interface MemberDAO {
		
	public int memberInsert(MemberDTO dto);
	public MemberDTO memberSelect(String email);
}
