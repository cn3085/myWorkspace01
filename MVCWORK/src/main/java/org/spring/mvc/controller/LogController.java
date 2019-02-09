package org.spring.mvc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.spring.mvc.service.MemberLoginService;
import org.spring.mvc.service.MemberLogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@SessionAttributes("dto")
public class LogController {
	
	@Inject
	private MemberLoginService loginService;
	
	@Inject
	private MemberLogoutService logoutService;
	
	@RequestMapping("/login")
	public String loginForm() {
		return "/loginForm";
	}
	
	@RequestMapping("**/loginAction")
	public String logIn(
			HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("password") String password
			) {
		loginService.SelectMember(request, email, password);
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request) {
		logoutService.logOutAction(request);
		return "redirect:/";
	}
}
