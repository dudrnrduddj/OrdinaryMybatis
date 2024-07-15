package com.ordinary.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordinary.common.PageUtils;
import com.ordinary.notice.model.service.NoticeService;
import com.ordinary.notice.model.vo.Notice;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/notice/update.kh")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get이면 수정페이지 이동
		String noticeNoStr = request.getParameter("noticeNo");
		int noticeNo = Integer.parseInt(noticeNoStr);
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(noticeNo);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post면 공지사항 수정
		PageUtils pu = new PageUtils();
		try {
			request.setCharacterEncoding("UTF-8");
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			String noticeSubject = request.getParameter("subject");
			String noticeComment = request.getParameter("comment");
			
			Notice notice = new Notice();
			notice.setNoticeNo(noticeNo);
			notice.setSubject(noticeSubject);
			notice.setComment(noticeComment);
			NoticeService nService = new NoticeService();
			int result = nService.updateNotice(notice);
			
			if(result > 0) {
				// 수정 성공
				response.sendRedirect("/notice/list.kh");
			}else {
				// 수정 실패
				pu.moveErrorPage(request, response, "수정에 실패했습니다.");
			}
		} catch (Exception e) {
			pu.moveErrorPage(request, response, e.getMessage());
		}
		
	}

}
