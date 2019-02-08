package org.spring.mvc.controller;

import javax.inject.Inject;

import org.spring.mvc.service.MemberLoginService;
import org.spring.mvc.service.MemberLogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("dto")
public class LogController {
	
	@Inject
	private MemberLoginService loginService;
	
	@Inject
	private MemberLogoutService logoutService;
	
	@RequestMapping("/login")
	public String loginForm() {
		return "/loginForm";
	}
	
	@RequestMapping("/loginAction")
	public String logIn(
//			HttpSession session,
			Model model,
			@RequestParam("email") String email,
			@RequestParam("password") String password
			) {
		loginService.SelectMember(email, password ,model);
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String logOut(SessionStatus sessionStatus) {
		logoutService.logOutAction(sessionStatus);
		return "redirect:/";
	}
}
