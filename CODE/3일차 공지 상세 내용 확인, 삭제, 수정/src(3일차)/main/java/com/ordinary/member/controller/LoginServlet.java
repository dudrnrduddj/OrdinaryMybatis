package com.ordinary.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ordinary.member.model.service.MemberService;
import com.ordinary.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login.kh")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			Member member = new Member(memberId, memberPw);
			
			MemberService mService = new MemberService();
			member = mService.checkLogin(member);
			
			if(member != null) {
				// 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("memberId", member.getMemberId());
				session.setAttribute("memberName", member.getMemberName());
				response.sendRedirect("/");
			}else {
				// 로그인 실패
				request.setAttribute("msg", "로그인에 실패했습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
				.forward(request, response);				
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
			.forward(request, response);
		}
		
	}

}
