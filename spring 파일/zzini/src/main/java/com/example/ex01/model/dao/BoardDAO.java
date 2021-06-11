package com.example.ex01.model.dao;

import java.util.List;

import com.example.ex01.model.dto.BoardDTO;

public interface BoardDAO {
	
	//회원의 일기 리스트 조회
	List<BoardDTO> board_list(String id, int startindex);
	
	//회원의 일기 리스트 총 갯수
	int board_count(String id);
	
	//일기 상세보기
	public BoardDTO board_view(BoardDTO dto);
	
	//일기 작성
	public void board_insert(BoardDTO dto);
	

}
