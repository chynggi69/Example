package com.cyg.service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.BMemberDAO;
import com.cyg.dto.BMember;

public class ConfirmIdService implements Service {
	/*
	 *
	 * 
	 * 
	 */
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			System.out.println("ConfID");
			request.setCharacterEncoding("UTF-8");
			// 세팅 위치 : Important!
			response.setContentType("text/html;charset=UTF-8");
			SqlSession session = MBUtils.getSession();
			BMemberDAO dao = session.getMapper(BMemberDAO.class);
			String id = request.getParameter("tempid");
			BMember vo = dao.selectById(id);
			PrintWriter out = response.getWriter();
			if (vo != null) {
				out.print("<h1>중복된 아이디 입니다</h1><a href='BMemberJoin.jsp'>돌아가기</a>");
			} else {
				out.print("<h1>사용가능 아이디 입니다</h1><a href='BMemberJoin.jsp'>돌아가기</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
