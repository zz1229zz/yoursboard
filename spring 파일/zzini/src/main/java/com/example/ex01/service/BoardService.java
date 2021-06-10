package com.example.ex01.service;

import java.util.List;

import com.example.ex01.model.dto.BoardDTO;

public interface BoardService {
	
	List<BoardDTO> board_list(String id);
	int board_count(String id);
}
