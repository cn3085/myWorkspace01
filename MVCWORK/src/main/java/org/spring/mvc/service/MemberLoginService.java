package org.spring.mvc.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberLoginService {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	MemberDAO dao;
	
	MemberDTO dto;
	
	@Transactional
	public void SelectMember(HttpServletRequest request, String email, String password) {
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		
		System.out.println("내가 적은 이메일 : "+email);
		System.out.println("내가 적은 비번 : "+password);
		if(((dto = dao.memberSelect(email))!=null)||(dto.getPassword().equals(password))) { //해당 아이디가 없으면
			//email이 일치하는 member를 dto에 담는다
			//dto가 null이 아니고 (해당 email 있음) || password 가 맞으면
			System.out.println("로그인 됐다!!");
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);
			//세션을 받아와서 해당 dto를 저장
		}
		
	}
}

