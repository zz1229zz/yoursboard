package com.example.ex01.model.dao;

import java.util.List;

import com.example.ex01.model.dto.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> board_list(String id);
	int board_count(String id);

}
