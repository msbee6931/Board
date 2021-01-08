package kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.service.MembersService;

@Controller
public class MembersContorller {
	@Autowired
	private MembersService mService;
	
	
	//예시
		@RequestMapping("insert")
		public String insert(BoardDTO dto) {
			return "home";
		}
}
