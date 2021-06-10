package com.example.ex01.model.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.ex01.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public boolean check_passwd(String id, String passwd) {
		boolean result = false;
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", passwd);
		
		int count = sqlSession.selectOne("mysqlMember.check_passwd", map);
		if (count == 1) 
			result =  true;
		
		return result;
	}

	@Override
	public String loginCheck(MemberDTO dto) {
		return sqlSession.selectOne("mysqlMember.loginCheck",dto);
	}

}
