package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.CommentDTO;
import kh.spring.service.BoardService;
import kh.spring.service.CommentService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bService;
	@Autowired
	private HttpSession session;
	@Autowired
	private CommentService cService;
	
	//예시
	@RequestMapping("insert")
	public String insert(BoardDTO dto) {
		//bService.insert(dto);
		return "board";
	}
	@RequestMapping("viewBoard.board")
	public String viewBoard(HttpServletRequest request, Model model ) throws Exception {
		String id = (String)session.getAttribute("id");
		model.addAttribute("id",id);
		int cpage = Integer.parseInt(request.getParameter("cpage")); //page =1
		int seq = Integer.parseInt(request.getParameter("seq"));

		CommentDTO cdto = new CommentDTO();
		cdto.setLocation(seq);
		List<CommentDTO> clist =  cService.commentList(cpage,cdto); //댓글리스트
		model.addAttribute("clist",clist);
		String cnavi = cService.commentNavi(cpage,cdto); //댓글내비
		model.addAttribute("cnavi",cnavi);
		
		return "board/viewBoard";
	}

}
