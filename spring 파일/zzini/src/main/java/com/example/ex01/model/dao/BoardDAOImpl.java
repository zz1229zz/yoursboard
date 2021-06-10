package com.example.ex01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.ex01.model.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardDTO> board_list(String id) {
		return sqlSession.selectList("mysqlBoard.board_list", id);
	}

	@Override
	public int board_count(String id) {
		return sqlSession.selectOne("mysqlBoard.board_count", id);
	}

}
