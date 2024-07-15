package com.ordinary.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUtils {
	
	private final String ERROR_PAGE = "/WEB-INF/views/common/errorPage.jsp";
	
	public void moveErrorPage(
			HttpServletRequest request, HttpServletResponse response, 
			String errorMsg) throws ServletException, IOException {
		
		request.setAttribute("msg", errorMsg);
		RequestDispatcher view = request.getRequestDispatcher(this.ERROR_PAGE);
		view.forward(request, response);
	}
}
