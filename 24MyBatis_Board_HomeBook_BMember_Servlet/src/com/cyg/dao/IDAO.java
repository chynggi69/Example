package com.cyg.dao;

import java.util.List;

public interface IDAO<T,K> {
	//public boolean isExist(K key);
	public List<T> selectAll();
	public T selectById(K id);
	public int insert(T vo);
	public int delete(K id);
	public int update(T vo);
	public long maxIdNum();
}
