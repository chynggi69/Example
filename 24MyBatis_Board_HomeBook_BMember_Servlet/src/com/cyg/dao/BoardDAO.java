package com.cyg.dao;

import com.cyg.dto.Board;

public interface BoardDAO extends IDAO<Board, Long> {
	public long countofcontents();
}
