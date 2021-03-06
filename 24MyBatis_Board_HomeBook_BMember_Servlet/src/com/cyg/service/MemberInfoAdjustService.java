package com.cyg.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.BMemberDAO;
import com.cyg.dto.BMember;

public class MemberInfoAdjustService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String mid = request.getParameter("id");
		String mname = request.getParameter("name");
		String mpassword = request.getParameter("password");
		String mphone = request.getParameter("phone");
		String mjoinDate = request.getParameter("joindate");
		SqlSession sqlsession = MBUtils.getSession();
		BMemberDAO dao = sqlsession.getMapper(BMemberDAO.class);
		BMember mem = dao.selectById(mid);
		if (mem == null) {
			out.print("<h1>FATAL ERROR: 일치하는 아이디가 없습니다.</h1>" + "<a href='Location.history(-1)'>Go Back</a>");

		} else {
			try {
				System.out.println(mem);
				dao.update(mem);
				sqlsession.commit();
				out.print("성공적으로 정보가 수정되었습니다!");
				out.print("<button type=\"button\" onclick=\"history.go(-2)\">돌아가기</button>");
			} catch (Exception e) {
				sqlsession.rollback();
				sqlsession.close();
				e.printStackTrace();
				return false;
			}
		}
		sqlsession.close();
		return true;

	}

}
