package com.example.ex01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView login_check(@ModelAttribute MemberDTO dto, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		String name = memberService.loginCheck(dto, session);
		logger.info("name: "+name);
		
		if (name != null) {
			mav.setViewName("redirect:/board/main.do");
			
	    }else {
			mav.setViewName("index");
			mav.addObject("message","error");
		}
		
		return mav;
	}
	

}
