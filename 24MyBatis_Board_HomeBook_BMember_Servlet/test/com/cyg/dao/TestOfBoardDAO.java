package com.cyg.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.*;
import java.util.*;
import com.cyg.common.MBUtils;
import com.cyg.dto.Board;

public class TestOfBoardDAO {
	SqlSession session;
	BoardDAO dao;	
	@Before
	public void beforeClass() {
		session = MBUtils.getSession();
		dao = session.getMapper(BoardDAO.class);
		
	}
	@After
	public void afterClass() {
		session.close();
		System.out.println("End of Test - HomeBook");
	}	
	
	
	@Test
	public void selectAllT() {
		List<Board> alldata = dao.selectAll();
		assertTrue(alldata!=null);
		for(Board x : alldata)
		{
			System.out.println(x);
		}
	}
	@Test
	public void insertT() {
		Board vo = new Board();
		vo.setBno(2);
		vo.setMid("chynggi");
		vo.setBtitle("TitleTest");
		vo.setBcontent("ContentTest");
		vo.setBdate("2019-08-02");		
		vo.setBhit(451);
		vo.setBgroup(1);
		vo.setBstep(5);
		vo.setBindent(10);
		
		try {
		dao.insert(vo);
		assertTrue(true);
		session.rollback();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			assertTrue(false);
			session.rollback();
		}
		
	
	}
	
	@Test
	public void insertFailT() {
		Board vo = new Board();
		//vo.setBno(2);
		//vo.setMid("chynggi");
		vo.setBtitle("TitleTest");
		vo.setBcontent("ContentTest");
		vo.setBdate("2019-08-02");		
		vo.setBhit(451);
		vo.setBgroup(1);
		vo.setBstep(5);
		vo.setBindent(10);
		try {
		dao.insert(vo);
		assertTrue(false);
		session.rollback();
		}
		catch (Exception e)
		{
			assertTrue(true);
			session.rollback();
		}
		
	
	}
	@Test
	public void updateT() {
		Board vo = dao.selectById(1L);
		vo.setBtitle(vo.getBtitle()+"999");
		vo.setBdate(vo.getBdate().substring(0,10));
		dao.update(vo);
		session.commit();
		vo = dao.selectById(1L);
		if(vo.getBtitle().endsWith("999"))
		{
			assertTrue(true);
			vo.setBdate(vo.getBdate().substring(0,10));
			vo.setBtitle(vo.getBtitle().replace("999", ""));
			dao.update(vo);
			session.commit();
		}
		else
		{
			assertTrue(false);
		}
		
		
	
	}
	@Test
	public void deleteT() {
		int num = dao.delete(1L);
		if(num>0)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
		session.rollback();
		
	
	}

	@Test
	public void deleteFailT() {
		
		int num = dao.delete(5156L);
		if(num>0)
		{
			assertTrue(false);
		}
		else
		{
			assertTrue(true);
		}
		session.rollback();
	
	}
	@Test 
	public void countT() {
		long count = dao.countofcontents();
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
	

}
