package org.spring.mvc.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberEditService {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	MemberDAO dao;
	
	public void MemberEdit(MemberDTO dto) {
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		dao.memberEdit(dto);
		
	}
}
