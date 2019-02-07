package org.spring.mvc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.spring.mvc.service.MemberJoinService;
import org.spring.mvc.service.MemberLoginService;
import org.spring.mvc.service.MemberLogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
			HttpSession session,
			@RequestParam("email") String email,
			@RequestParam("password") String password
			) {
		loginService.SelectMember(email, password ,session);
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		logoutService.logOutAction(session);
		
		return "redirect:/";
	}
}
