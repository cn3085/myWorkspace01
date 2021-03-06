package org.spring.mvc.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession(false);

		if (session.getAttribute("dto") == null) { // 로그인 실패면

			System.out.println("로그인 실패잖아...");
			request.setAttribute("msg", "<script>alert('로그인 안 됐음.')</script>");
			//로그인 실패면 alert 띄우고 다시 로그인 폼으로 보낸다
			RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/login");
			dispatcher.forward(request, response);
		}
	}
}