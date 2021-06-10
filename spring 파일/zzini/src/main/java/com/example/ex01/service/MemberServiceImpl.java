package com.example.ex01.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.ex01.model.dao.MemberDAO;
import com.example.ex01.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public boolean check_passwd(String id, String passwd) {
		return memberDao.check_passwd(id, passwd);
	}

	@Override
	public String loginCheck(MemberDTO dto, HttpSession session) {
		String name = memberDao.loginCheck(dto);
		
		if(name != null) {
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", name);
		}
		return name;
	}


}
