package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bService;
	@Autowired
	private HttpSession session;
	
	//예시
	@RequestMapping("insert")
	public String insert(BoardDTO dto) {
		//bService.insert(dto);
		return "board";
	}
	
	//게시판 목록 띄우기
	@RequestMapping("viewBoard.board")
	public String viewBoard(Model model) throws Exception {
	String id = (String) session.getAttribute("id");
	BoardDTO dto = bService.selectPage();
	model.addAttribute("dto", dto);
	model.addAttribute("id", id);
	return "viewBoard";	
	}
	
	@RequestMapping("boardListView.board")
	public String boardListView(HttpServletRequest request,BoardDTO dto, Model model) throws Exception {
	System.out.println("Controller viewBoard요청 ");
	String id = (String) session.getAttribute("login");
	String cpage = request.getParameter("cpage");
	int currentPage = Integer.parseInt(cpage);
	List<BoardDTO> list = bService.listByCpage(Integer.parseInt(cpage));
	String navi = bService.getNavi(currentPage);
	model.addAttribute("list", list);
	model.addAttribute("navi", navi);
	model.addAttribute("id", id);
	
		return "boardListView";	
	}
	
}
