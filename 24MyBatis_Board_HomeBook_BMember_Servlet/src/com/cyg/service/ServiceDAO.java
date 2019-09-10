package com.cyg.service;
import java.util.*;

import com.cyg.dto.HomeBook;
import com.cyg.dto.Total;
import com.cyg.dto.Total2;

public interface ServiceDAO {
	public List<Total> GetTotalList();
	public long countofcontents();
	public List<HomeBook> SelectByUserID(String id);
	public List<HomeBook> SelectBeetweendata(Map<String, String> map);
	public List<Total2> GetStats(String id);
}
