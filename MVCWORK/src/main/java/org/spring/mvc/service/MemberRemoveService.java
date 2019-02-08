package org.spring.mvc.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberRemoveService {

	
	@Inject
	SqlSessionTemplate sqlSessionTemplate;
	
	MemberDAO dao;
	
	public void MemberRemove(String email) {
		System.out.println("서비스에서 받은 이메일 : "+ email);
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		dao.memberRemove(email);
	}
}
