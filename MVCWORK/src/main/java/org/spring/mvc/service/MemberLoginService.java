package org.spring.mvc.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
public class MemberLoginService {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	MemberDAO dao;
	
	MemberDTO dto;
	
	public void SelectMember(String email, String password, HttpSession session) {
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		
		if(((dto = dao.memberSelect(email))==null)||(!dto.getPassword().equals(password))) { //해당 아이디가 없으면
			System.out.println("로그인 nonononononono");
			
		}else {
			System.out.println("로그인 됐다!!");
			session.setAttribute("id", dto.getEmail());
		}
		
	}
}
