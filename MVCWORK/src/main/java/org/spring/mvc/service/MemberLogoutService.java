package org.spring.mvc.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

@Service
public class MemberLogoutService {
	public void logOutAction(SessionStatus sessionStatus) {
		System.out.println("로그아웃한다!!!");
		sessionStatus.setComplete();
	}
}
