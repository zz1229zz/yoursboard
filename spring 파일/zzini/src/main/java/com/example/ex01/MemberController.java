package com.example.ex01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ex01.model.dto.BoardDTO;
import com.example.ex01.model.dto.MemberDTO;
import com.example.ex01.service.BoardService;
import com.example.ex01.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@Inject
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto, BoardDTO dto2, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 로그인 체크 처리하는 서비스 요청(세션값을 생성 시킴)
		String name = memberService.loginCheck(dto, session);
		logger.info("name: "+name);
		
		// 로그인 처리 결과에 따라 처리
		if (name != null) {// 로그인 성공시  session값을 생성해서 home페이지로 이동
			
			List<BoardDTO> list = boardService.board_list(dto.getId());
			
			map.put("list", list);
			
			mav.addObject("count", boardService.board_count(dto.getId()));
			mav.addObject("map", map);
			mav.setViewName("main");

	    }else {
			// 로그인 실패시 에러 메시지와 함께 로그인 페이지로 이동
			mav.setViewName("index");
			mav.addObject("message","error");
		}
		return mav;
	}

}
