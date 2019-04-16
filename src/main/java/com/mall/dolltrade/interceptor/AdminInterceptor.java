package com.mall.dolltrade.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mall.dolltrade.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member == null) {
			res.sendRedirect("/dolltrade/member/signin");
			return false;
		}
	
		if (member.getVerify() != 9) {
			res.sendRedirect("/dolltrade");
			return false;
		}

		return true;
	}
}
