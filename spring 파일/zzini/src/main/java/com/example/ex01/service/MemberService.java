package com.example.ex01.service;

import javax.servlet.http.HttpSession;

import com.example.ex01.model.dto.MemberDTO;

public interface MemberService {
	public boolean check_passwd(String id, String passwd);
	public String loginCheck(MemberDTO dto, HttpSession session);
}
