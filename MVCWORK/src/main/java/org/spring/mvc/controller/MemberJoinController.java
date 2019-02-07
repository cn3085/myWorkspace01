package org.spring.mvc.controller;

import org.spring.mvc.domain.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberJoinController {

	@RequestMapping("memberJoinForm")
	public String regForm() {
		return "/joinForm";
	}
	
	@RequestMapping("memberJoin")
	public String memberJoin(
//			@RequestParam("email") String email,
//			@RequestParam("password") String password,
//			@RequestParam("name") String name,
//			@RequestParam(value="photo", required=false, defaultValue="none") String photo,
			MemberDTO dto
			) {
		
		
//		MemberDTO dto = new MemberDTO();
		
//		dto.setEmail(email);
//		dto.setPassword(password);
//		dto.setName(name);
//		dto.setPhoto(photo);
//		
		System.out.println(dto.toString());
		
		return "redirect:/";
//		return "/index";
	}
}
