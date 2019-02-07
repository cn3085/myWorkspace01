package org.spring.mvc.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	private MemberDAO dao;
	
	public int Insert(MemberDTO dto) {
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		
		return dao.memberInsert(dto);
		
	}
}
