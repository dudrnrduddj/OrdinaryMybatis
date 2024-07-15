package com.ordinary.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordinary.common.PageUtils;
import com.ordinary.notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/notice/delete.kh")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageUtils pu = new PageUtils();
		String errorPage = "/WEB-INF/views/common/errorPage.jsp";
		try {
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			
			NoticeService nService = new NoticeService();
			int result = nService.deleteNotice(noticeNo);
			
			if(result > 0) {
				//삭제 성공 -> list로 이동
				response.sendRedirect("/notice/list.kh");
			}else {
				pu.moveErrorPage(request, response, "삭제를 실패했습니다.");
			}
		} catch (Exception e) {
			pu.moveErrorPage(request, response, e.getMessage());
		}
		
	}

}
