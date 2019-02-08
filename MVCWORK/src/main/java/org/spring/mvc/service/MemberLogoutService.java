package org.spring.mvc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberLogoutService {
	public void logOutAction(HttpServletRequest request) {
		System.out.println("로그아웃한다!!!");
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
