package org.spring.mvc.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.persistence.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
public class MemberListService {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MemberDAO dao;
	
	@Transactional
	public void memberListSelect(Model model) {
		
		dao=sqlSessionTemplate.getMapper(MemberDAO.class);
		List<MemberDTO> list = dao.memberListSelect();
		model.addAttribute("list", list);
	}
	
	@Transactional
	public List<MemberDTO> memberListSelect() { //오버로딩
		
		dao=sqlSessionTemplate.getMapper(MemberDAO.class);
		List<MemberDTO> list = dao.memberListSelect();
		return list;
	}
}
