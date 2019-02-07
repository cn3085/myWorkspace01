package org.spring.mvc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.spring.mvc.domain.MemberDTO;
import org.spring.mvc.service.MemberJoinService;
import org.spring.mvc.service.MemberLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberJoinController {

	@Inject
	private MemberJoinService joinService;
	
	@Inject
	private MemberLoginService loginService;
	
	@RequestMapping("memberJoinForm")
	public String regForm() {
		return "/joinForm";
	}
	
	@RequestMapping("memberJoin")
	public String memberJoin(
			MemberDTO dto,
			HttpSession session
			) {
		System.out.println(dto.toString());
		joinService.Insert(dto);
		loginService.SelectMember(dto.getEmail(), dto.getPassword(), session);
		
		return "redirect:/";
	}
}
