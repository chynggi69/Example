package com.cyg.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.*;
import java.util.*;
import com.cyg.common.MBUtils;
import com.cyg.dto.HomeBook;

public class TestOfHomeBookDAO {
	SqlSession session;
	HomeBookDAO dao;

	@Before
	public void beforeClass() {
		session = MBUtils.getSession();
		dao = session.getMapper(HomeBookDAO.class);

	}

	@After
	public void afterClass() {
		session.close();
		System.out.println("End of Test - HomeBook");
	}

	@Test
	public void selectAllT() {
		List<HomeBook> alldata = dao.selectAll();
		assertTrue(alldata != null);
		for (HomeBook x : alldata) {
			System.out.println(x);
		}
	}

	@Test
	public void insertT() {
		HomeBook vo = new HomeBook();
		vo.setSerialno(2);
		vo.setDate("19/05/23");
		vo.setSection("선물 구입");
		vo.setAccount_title("김진우");
		vo.setRemark("김뚜띠 생일선물");
		vo.setRevenue(0);
		vo.setExpense(140000);
		vo.setUser_id("chynggi");
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
	public void insertFailT() {
		HomeBook vo = new HomeBook();
		// vo.setSerialno(2);
		// vo.setDate("19/05/23");
		vo.setSection("선물 구입");
		vo.setAccount_title("김진우");
		vo.setRemark("김뚜띠 생일선물");
		vo.setRevenue(0);
		vo.setExpense(140000);
		// vo.setUser_id("chynggi");
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
	public void updateT() {
		HomeBook vo = dao.selectById((1L));
		vo.setRemark(vo.getRemark() + "999");
		vo.setDate(vo.getDate().substring(0, 10));
		dao.update(vo);
		session.commit();
		vo = dao.selectById(1L);

		boolean isModified = vo.getRemark().endsWith("999");
		if (isModified) {
			// 원상복구 작업 //
			// 테스트로 인해 정상적인 데이터에 영향을 주면 안 되기 때문이다.
			assertTrue(true);
			vo.setDate(vo.getDate().substring(0, 10));
			vo.setRemark(vo.getRemark().replace("999", ""));
			dao.update(vo);
			session.commit();
		} else {
			assertTrue(false);
		}

	}

	@Test
	public void deleteFailT() {

		int num = dao.delete(444L);
		if (num > 0) {
			assertTrue(false);
		} else {
			assertTrue(true);
		}
		session.rollback();

	}

	@Test
	public void deleteT() {

		int num = dao.delete(1L);
		if (num > 0) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		session.rollback();

	}

}
