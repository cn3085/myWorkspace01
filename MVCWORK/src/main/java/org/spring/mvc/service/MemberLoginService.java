package org.spring.mvc.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
public class MemberLoginService {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	MemberDAO dao;
	
	MemberDTO dto;
	
	@Transactional
	public void SelectMember(HttpServletRequest request, String email, String password, Model model) {
		dao = sqlSessionTemplate.getMapper(MemberDAO.class);
		System.out.println("내가 적은 이메일 : "+email);
		System.out.println("내가 적은 비번 : "+password);
		if(((dto = dao.memberSelect(email))==null)||(!dto.getPassword().equals(password))) { //해당 아이디가 없으면
			System.out.println("로그인 nonononononono");
			
		}else {
			System.out.println("로그인 됐다!!");
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);
			
		}
		
	}
}

