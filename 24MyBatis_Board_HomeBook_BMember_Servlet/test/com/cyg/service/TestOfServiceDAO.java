package com.cyg.service;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.*;
import java.util.*;
import com.cyg.common.MBUtils;
import com.cyg.dto.BMember;
import com.cyg.dto.HomeBook;
import com.cyg.dto.Total;
import com.cyg.dto.Total2;
import com.cyg.service.ServiceDAO;

public class TestOfServiceDAO {
	SqlSession session;
	ServiceDAO service;

	@Before
	public void beforeClass() {
		session = MBUtils.getSession();
		service = session.getMapper(ServiceDAO.class);

	}

	@After
	public void afterClass() {
		session.close();
		System.out.println("End of Test - HomeBook");
	}

	@Test
	public void GetTotalListT() {
		List<Total> alldata = service.GetTotalList();
		assertTrue(alldata != null);
		for (Total x : alldata) {
			System.out.println(x);
		}
	}
	@Test 
	public void countT() {
		long count = service.countofcontents();
		if(count>0)
		{
			assertTrue(true);
			System.out.println(count);
		}
		else
		{
			assertTrue(false);
		}
		session.rollback();
		
	}
	@Test 
	public void SelByUIdT() {
		List<HomeBook> alldata = service.SelectByUserID("chynggi");
		assertTrue(alldata != null);
		for (HomeBook x : alldata) {
			System.out.println(x);
		}
	}
	@Test 
	public void SelByDateT() {
		Map<String,String> map = new HashMap<>();
		map.put("startdate", "2019-04-01");
		map.put("enddate",  "2019-08-31");
		map.put("id", "chynggi");
		System.out.println(map.toString());
		List<HomeBook> alldata = service.SelectBeetweendata(map);
		assertTrue(alldata != null);
		for (HomeBook x : alldata) {
			System.out.println(x);
		}
	}
	@Test
	public void GetStats() {
		List<Total2> alldata = service.GetStats("chynggi");
		assertTrue(alldata != null);
		for (Total2 x : alldata) {
			System.out.println(x);
		}
	}
}
