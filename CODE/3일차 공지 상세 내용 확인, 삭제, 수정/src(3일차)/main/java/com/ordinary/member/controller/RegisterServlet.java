package com.ordinary.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordinary.member.model.service.MemberService;
import com.ordinary.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.kh")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 버튼(링크)을 누르면 동작
//		1. 클라이언트 요청 : 주소창에 입력 enter => 브라우저가 http get요청을 서버로 보냄
//		2. URL 매핑 : URL과 서블릿(어노테이션 @..)을 매핑
//		3. 매핑된 서블릿 객체 생성(존재하면 그냥 사용, 초기화면 init메소드호출)
//		4. doGet 메서드 실행 : 메서드에 HttpServletRequest, HttpServletResponse객체 파라미터로 받아 요청 처리 및 응답 작성
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지, UTF-8 인코딩
			String memberId = request.getParameter("member-id");
			String memberPw = request.getParameter("member-pw");
			String memberName = request.getParameter("member-name");
			String memberGender = request.getParameter("member-gender");
			String memberAge = request.getParameter("member-age");
			String memberEmail = request.getParameter("member-email");
			String memberPhone = request.getParameter("member-phone");
			String memberAddress = request.getParameter("member-address");
			String memberHobby = request.getParameter("member-hobby");
			
			Member member = new Member(memberId, memberPw, memberName, memberGender, Integer.parseInt(memberAge), memberEmail, memberPhone, memberAddress, memberHobby);
			MemberService mService = new MemberService();
			
			int result = mService.insertMember(member);
			if(result > 0) {
				response.sendRedirect("/");
			}else {
				request.setAttribute("msg", "회원가입이 완료되지 않았습니다.");
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
