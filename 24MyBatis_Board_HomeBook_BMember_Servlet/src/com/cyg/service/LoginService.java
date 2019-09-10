package com.cyg.service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.BMemberDAO;
import com.cyg.dto.BMember;

public class LoginService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 파라미터/응답 인코딩 방식 지정
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		response.setCharacterEncoding("UTF-8");
		// 태그인식 여부
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = response.getWriter();
		SqlSession sqlsession = MBUtils.getSession();
		HttpSession session = request.getSession();
		// 인터페이스를 별도로 구현없이 사용하기 위해 매퍼와 바로 연결
		BMemberDAO dao = sqlsession.getMapper(BMemberDAO.class);
		BMember mem = null;
		try {
			mem = dao.selectById(id);
			if (mem.getMpassword().equals(password)) {
				session.setAttribute("loginOK", "OK");
				session.setAttribute("id", id);
				session.setAttribute("name", mem.getMname());
				
				response.sendRedirect("../main.jsp");
			} else {
				writer.print("로그인 실패<br/>");
				writer.print("<button type='button' onclick=\"location.href='../main.jsp'\">메인</button>");
				writer.print("<a href='./mymember/memberJoin.jsp'>회원가입</a>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			writer.print("로그인 실패<br/>");
			writer.print("<button type='button' onclick=\"location.href='../main.jsp'\">메인</button>");
			writer.print("<a href='./mymember/memberJoin.jsp'>회원가입</a>");
			return false;
		}
		sqlsession.close();
		writer.close();
		return true;
	}/*
		 * <%
		 * 
		 * request.setCharacterEncoding("UTF-8"); String id =
		 * request.getParameter("id"); String password =
		 * request.getParameter("password"); MyMemberDAO dao = new MyMemberDAO();
		 * Connection conn = ConnectionFactory.getConnection(); PrintWriter writer =
		 * response.getWriter(); MyMember mem = null; try{ mem = dao.select(conn, id);
		 * if(mem.getPassword().equals(password)) {
		 * writer.print("<h1>LOGIN SUCCESS! WELCOME!</h1>"); session.setAttribute("id",
		 * id);
		 * 
		 * writer.print("<button type='button' onclick="+
		 * "location.href='../homebook/form_homebook.jsp'" +">Homebook Input</button>");
		 * 
		 * 
		 * } else { writer.print("<h1>LOGIN FAILED! CHECK YOUR PASSWORD!</h1>"); }
		 * 
		 * }catch (Exception e) { writer.print("<h1>LOGIN FAILED! CHECK YOUR ID!</h1>");
		 * e.printStackTrace(); } %>
		 * 
		 * 
		 * 
		 */

}
