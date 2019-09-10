package com.cyg.service;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.cyg.common.MBUtils;
import com.cyg.dao.BMemberDAO;
import com.cyg.dto.BMember;

public class MemberJoinService implements Service {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		SqlSession session = MBUtils.getSession();
		BMemberDAO dao = session.getMapper(BMemberDAO.class);
		BMember vo = dao.selectById(mid);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (vo != null) {
			out.print("<h1>중복된 아이디 입니다</h1><a href='memberJoin.jsp'>돌아가기</a>");
			return false;
		} 
		else {
		session.close();
		String mpassword = request.getParameter("mpassword");
		String mpassword2 = request.getParameter("mpassword2");
		if(!mpassword.equals(mpassword2)){
			out.print("<h1>비밀번호 재확인 [비밀번호 랑 비밀번호 확인 이 일치하지 않음]</h1><a href='memberJoin.jsp'>돌아가기</a>");
			return false;
		} 
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String mjoinDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		
		//태그인식 여부
		
		PrintWriter writer = response.getWriter();
		session = MBUtils.getSession();
		
		// 인터페이스를 별도로 구현없이 사용하기 위해 매퍼와 바로 연결
		dao = session.getMapper(BMemberDAO.class);
		BMember mem = new BMember(mid, mname, mpassword, mphone, mjoinDate);
		try {
			dao.insert(mem);
			session.commit();
			writer.print("<h1>회원가입을 환영합니다!</h1>");
			writer.print("<button type='button' onclick=\"location.href='./login/formLogin.jsp'\">로그인</button>");
			writer.print("<button type='button' onclick=\"location.href='../main.jsp'\">메인</button>");
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();		
			writer.print("<h1>정보를 확인하고 다시 시도해 주세요.</h1>");
			writer.print("<a href='./mymember/memberJoin.jsp'>회원가입</a>");
			writer.print("<button type='button' onclick=\"location.href='../main.jsp'\">메인</button>");
			return false;
		}
		session.close();
		writer.close();
		return true;
		}
	}

}
