package com.cyg.service;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.BMemberDAO;
import com.cyg.dto.BMember;

public class PasswordSeekService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Member's Password Seek");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		SqlSession sqlsession = MBUtils.getSession();
		BMemberDAO dao = sqlsession.getMapper(BMemberDAO.class);
		BMember mem = null;
		try {
			mem = dao.selectById(id);
			if(mem!=null)
			{
				out.print("회원님의 비밀번호는 "+mem.getMpassword()+"입니다.</br>");
				out.print("<a href='./formLogin.jsp'>로그인하러 가기</a>");
				
			}
			else
			{
				out.print("<h1>FATAL ERROR: 일치하는 아이디가 없습니다.</h1>"+
						"<button onclick='history.back()'>Go Back</button>");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			out.print("<h1>FATAL ERROR: 일치하는 아이디가 없습니다.</h1>"+
					"<button onclick='history.back()'>Go Back</button>");
		}
		sqlsession.close();
		return true;
	}

}
