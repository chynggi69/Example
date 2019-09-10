package com.cyg.dao;

import java.util.List;

import com.cyg.dto.HomeBook;

public interface HomeBookDAO extends IDAO<HomeBook, Long> {
	public List<HomeBook> selectByIdList(String id);
}
