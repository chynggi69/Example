package com.cyg.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cyg.service.TestOfServiceDAO;

@RunWith(Suite.class)
@SuiteClasses({ TestOfBMemberDAO.class, TestOfBoardDAO.class, TestOfHomeBookDAO.class , TestOfServiceDAO.class})
public class AllTests {

}
