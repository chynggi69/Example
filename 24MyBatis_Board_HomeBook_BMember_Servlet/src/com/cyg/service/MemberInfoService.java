package com.cyg.service;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.BMemberDAO;
import com.cyg.dto.BMember;

public class MemberInfoService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		SqlSession sqlsession = MBUtils.getSession();
		BMemberDAO dao = sqlsession.getMapper(BMemberDAO.class);
		RequestDispatcher rd = request.getRequestDispatcher("./MyMemberInfo.jsp");
		try {
			BMember vo = dao.selectById(id);
			request.setAttribute("id", id);
			request.setAttribute("name", vo.getMname());
			request.setAttribute("password", vo.getMpassword());
			request.setAttribute("phone", vo.getMphone());
			request.setAttribute("joindate", vo.getMjoinDate());
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			sqlsession.close();
			return false;
		}
		sqlsession.close();
		return true;
	}

}
