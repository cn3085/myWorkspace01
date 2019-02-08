package org.spring.mvc.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);

		if (session.getAttribute("dto") == null) { // 로그인 실패면
			System.out.println("로그인 안 했잖아...");
			request.setAttribute("msg", "<script>alert('로그인 안 됐음.')</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/login");
			dispatcher.forward(request, response);
			return false;
		}
		return true;
	}
	
}

