package com.cyg.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.*;
import java.util.*;
import com.cyg.common.MBUtils;
import com.cyg.dto.BMember;

public class TestOfBMemberDAO {
	SqlSession session;
	BMemberDAO dao;

	@Before
	public void beforeClass() {
		session = MBUtils.getSession();
		dao = session.getMapper(BMemberDAO.class);

	}

	@After
	public void afterClass() {
		session.close();
		System.out.println("End of Test - HomeBook");
	}

	@Test
	public void selectAllT() {
		List<BMember> alldata = dao.selectAll();
		assertTrue(alldata != null);
		for (BMember x : alldata) {
			System.out.println(x);
		}
	}

	@Test
	public void insertFailT() {
		BMember vo = new BMember();
		// vo.setMid("jinu6734");
		vo.setMname("김진우");
		vo.setMjoinDate("2019-08-02");
		vo.setMpassword("jinu6734");
		vo.setMphone("010-2633-8884");
		try {
			dao.insert(vo);
			assertTrue(false);
			session.rollback();
		} catch (Exception e) {
			assertTrue(true);
			session.rollback();
		}

	}

	@Test
	public void insertT() {
		BMember vo = new BMember();
		vo.setMid("jinu6734");
		vo.setMname("김진우");
		vo.setMjoinDate("2019-08-02");
		vo.setMpassword("jinu6734");
		vo.setMphone("010-2633-8884");
		try {
			dao.insert(vo);
			assertTrue(true);
			session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
			session.rollback();
		}

	}
	@Test
	public void updateT() {
		BMember vo = dao.selectById("hgd");
		vo.setMname(vo.getMname() + "999");
		vo.setMjoinDate(vo.getMjoinDate().substring(0,10));
		dao.update(vo);
		session.commit();
		vo = dao.selectById("hgd");
		if (vo.getMname().endsWith("999")) {
			assertTrue(true);
			vo.setMjoinDate(vo.getMjoinDate().substring(0,10));
			vo.setMname(vo.getMname().replace("999", ""));
			dao.update(vo);
			session.commit();
		} else {
			assertTrue(false);
		}

	}

	@Test
	public void deleteFailT() {
		//제약조건으로 연결된 자료가 없는 경우
		//무결성강화와 연관이 없는 회원
		int num = dao.delete("a");
		if (num > 0) {
			assertTrue(false);
		} else {
			assertTrue(true);
		}
		session.rollback();

	}

	
	public void deleteFailAltT() {
		//제약조건으로 연결된 자료가 있는 경우
		int num = 0;
		try {
			num = dao.delete("hgd");
			System.out.println(num);
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
		session.rollback();

	}

	@Test
	public void deleteT() {

		int num = dao.delete("hgd");
		if (num > 0) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		session.rollback();

	}

}
