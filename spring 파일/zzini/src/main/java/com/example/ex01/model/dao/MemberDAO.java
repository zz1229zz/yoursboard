package com.example.ex01.model.dao;

import com.example.ex01.model.dto.MemberDTO;

public interface MemberDAO {
	public boolean check_passwd(String id, String passwd);
	public String loginCheck(MemberDTO dto);
}
