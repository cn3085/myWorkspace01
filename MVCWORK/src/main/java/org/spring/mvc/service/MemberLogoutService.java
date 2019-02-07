package org.spring.mvc.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberLogoutService {
	public void logOutAction(HttpSession session) {
		System.out.println("로그아웃한다!!!");
		session.invalidate();
	}
}
