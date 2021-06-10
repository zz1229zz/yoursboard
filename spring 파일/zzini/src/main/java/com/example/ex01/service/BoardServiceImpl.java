package com.example.ex01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.ex01.model.dao.BoardDAO;
import com.example.ex01.model.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDao;

	@Override
	public List<BoardDTO> board_list(String id) {
		return boardDao.board_list(id);
	}

	@Override
	public int board_count(String id) {
		return boardDao.board_count(id);
	}

}
