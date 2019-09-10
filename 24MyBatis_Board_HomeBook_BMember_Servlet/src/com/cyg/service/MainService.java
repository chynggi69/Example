package com.cyg.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainService implements Service{

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("./main.jsp");
		return true;
	}

}
