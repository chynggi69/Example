package com.cyg.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.HomeBookDAO;
import com.cyg.dto.HomeBook;

public class HomeBookInfoService implements Service {
	/*
	 * <% request.setCharacterEncoding("UTF-8"); HomeBookDAO dao = new
	 * HomeBookDAO(); Connection conn = ConnectionFactory.getConnection();
	 * List<HomeBook> data = new ArrayList<>(); try { data = dao.selectall(conn);
	 * }catch(Exception e) { e.printStackTrace(); } %> <h1>입력자료목록</h1> <hr> <table
	 * border="1"> <tr> <th>관리번호</th> <th>날짜</th> <th>수지구분</th> <th>계정과목</th>
	 * <th>적요(수지내역)</th> <th>수입(차변)</th> <th>지출(대변)</th> <th>사용자ID</th> </tr> <%
	 * for(HomeBook x:data) { out.print("<tr>");
	 * out.print("<td>"+x.getSerialno()+"</td>");
	 * out.print("<td>"+x.getDay()+"</td>");
	 * out.print("<td>"+x.getSection()+"</td>");
	 * out.print("<td>"+x.getAccount_title()+"</td>");
	 * out.print("<td>"+x.getRemark()+"</td>");
	 * out.print("<td>"+x.getRevenue()+"</td>");
	 * out.print("<td>"+x.getExpense()+"</td>");
	 * out.print("<td>"+x.getUser_id()+"</td>"); out.print("</tr>"); } %>
	 * 
	 * 
	 * </table> <button type="button" onclick="location.href='form_homebook'">입력
	 * 화면으로.</button>
	 * 
	 */

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HomeBook Info. Display");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		PrintWriter out = response.getWriter();
		SqlSession sqlSession = MBUtils.getSession();
		HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);
		List<HomeBook> data = new ArrayList<>();
		RequestDispatcher rd = request.getRequestDispatcher("./datadisp.jsp");
		try {
			data = dao.selectByIdList(id);
			request.setAttribute("data", data);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.close();
			return false;
		}
		sqlSession.close();
		return true;
	}

}
