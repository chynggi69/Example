package com.cyg.service;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.HomeBookDAO;
import com.cyg.dto.HomeBook;

public class HomeBookAdjustService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HomeBook Adjusting");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String day = request.getParameter("day");
		String section = request.getParameter("section");
		String account_title = request.getParameter("account_title");
		String remark = request.getParameter("remark");
		int revenue = Integer.parseInt(request.getParameter("revenue"));
		int expense = Integer.parseInt(request.getParameter("expense"));
		System.err.println(request.getParameter("serialno"));
		long serialno = Long.parseLong(request.getParameter("serialno"));
		out.print("ID:" + id + "<br/>");
		out.print("일자:" + day + "<br/>");

		out.print("계정과목:" + account_title + "<br/>");
		out.print("적요(내역):" + remark + "<br/>");
		out.print("수입:" + revenue + "<br/>");
		out.print("지출:" + expense + "<br/>");

		//
		HomeBook vo = new HomeBook();
		vo.setSerialno(serialno);
		vo.setDate(day);
		vo.setSection(section);
		vo.setAccount_title(account_title);
		vo.setRemark(remark);
		vo.setRevenue(revenue);
		vo.setExpense(expense);
		vo.setUser_id(id);
		out.print(vo + "<br/>");
		SqlSession sqlSession = MBUtils.getSession();
		HomeBookDAO dao = sqlSession.getMapper(HomeBookDAO.class);

		int res = 0;
		try {
			res = dao.update(vo);
			if (res > 0) {
				sqlSession.commit();
				out.print("Data Input Success! 수정 성공");
			} else {
				sqlSession.rollback();
				out.print("Data Input Failed! 입력 실패");
				return false;
			}
		} catch (Exception e) {
			System.err.println("입력하려는 데이터나 구문에 문제가 있습니다.");
			e.printStackTrace();
			return false;
		}

		out.print("<a href=\"form_homebook.jsp\">계속 작업</a>");
		out.print("<button type=\"button\" onclick=\"location.href='datadisp.jsp'\">입력자료출력</button>");

		return true;
	}

}
