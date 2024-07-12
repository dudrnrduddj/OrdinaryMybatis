package com.ordinary.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ordinary.notice.model.service.NoticeService;
import com.ordinary.notice.model.vo.Notice;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/notice/insert.kh")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String memberName = (String)session.getAttribute("memberName");
			String subject = request.getParameter("subject");
			String comment = request.getParameter("comment");
			
			Notice notice = new Notice(subject, comment);
			notice.setWriter(memberName);
			NoticeService nService = new NoticeService();
			int result = nService.insertNotice(notice);
			if(result > 0) {
				// 등록 성공
				response.sendRedirect("/");
			}else {
				// 등록 실패
				request.setAttribute("msg", "등록에 실패했습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

}
