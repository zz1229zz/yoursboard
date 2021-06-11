package com.example.ex01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.ex01.model.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardDTO> board_list(String id, int startindex) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("startindex", startindex);
		
		return sqlSession.selectList("mysqlBoard.board_list", map);
	}

	@Override
	public int board_count(String id) {
		return sqlSession.selectOne("mysqlBoard.board_count", id);
	}

	@Override
	public BoardDTO board_view(BoardDTO dto) {
		return sqlSession.selectOne("mysqlBoard.board_view", dto);
	}

	@Override
	public void board_insert(BoardDTO dto) {
		sqlSession.insert("mysqlBoard.board_insert", dto);
	}

}
