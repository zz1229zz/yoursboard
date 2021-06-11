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
import com.example.ex01.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@RequestMapping("main.do")
	public ModelAndView main(@ModelAttribute BoardDTO dto, @RequestParam(defaultValue="1") int curPage, HttpServletRequest request, Model model, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int count = boardService.board_count(session.getAttribute("id").toString());
		
		pagination pagination = new pagination(count, curPage);
		
		int startindex = pagination.getStartindex();
		
		List<BoardDTO> list = boardService.board_list(session.getAttribute("id").toString(), startindex );
		
		dto.setStartindex(pagination.getStartindex());
		dto.setCntperpage(pagination.getPageSize());
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("count", count);
		
		map.put("list", list);
		mav.addObject("map", map);
		
		mav.setViewName("main");
		
		return mav;
		
	}
	
	@RequestMapping("view.do")
	public String view(@RequestParam int index, @ModelAttribute BoardDTO dto, Model model, HttpSession session, @RequestParam int curPage) {
		
		dto.setId(session.getAttribute("id").toString());
		
		model.addAttribute("dto", boardService.board_view(dto));
		model.addAttribute("curPage", curPage);
		
		return "view";
	}
	
	@RequestMapping("write.do")
	public String write() {
		
		return "write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session) {
		
		dto.setId(session.getAttribute("id").toString());
		
		boardService.board_insert(dto);
		
		return "redirect:/board/main.do";
	}
	

}
