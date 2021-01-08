package kh.spring.controller;


import java.util.List;

import java.io.File;
import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.CommentDTO;
import kh.spring.service.BoardService;
import kh.spring.service.CommentService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private HttpSession session;
	@Autowired
	private BoardService bService;

	@Autowired
	private CommentService cService;
	
	// 게시판 글작성
	@RequestMapping("boardWrite.board")
	public String boardWrite(MultipartFile file,BoardDTO dto) throws Exception {
		int result = 0;
		
		// 파일 첨부 유무
		if(dto.getImg() != null) {
			String realPath = session.getServletContext().getRealPath("resources/files");
			File filesPath = new File(realPath);
			if(!filesPath.exists()) {filesPath.mkdir();}
			
			String fileName = file.getOriginalFilename();
			String uid = UUID.randomUUID().toString().replaceAll("-","");
			String newFileName = uid + "_" + fileName;
			dto.setImg(newFileName);
			result = bService.boardWrite(dto);
			
			if(result>0) {
				File targetLoc = new File(filesPath.getAbsoluteFile()+"/"+newFileName);
				FileCopyUtils.copy(file.getBytes(), targetLoc);
			}
		}else {
			result = bService.boardWrite(dto);
		}
		return "board/boardWriteResult";
	}
	
	// 게시판 글수정
	@RequestMapping("boardUpdate.board")
	public String boardUpdate(MultipartFile file,Model model,BoardDTO dto) throws Exception {
		int result = 0;
		
		// 파일 첨부 유무
		if(dto.getImg() != null) {
			String realPath = session.getServletContext().getRealPath("resources/files");
			File filesPath = new File(realPath);
			if(!filesPath.exists()) {filesPath.mkdir();}
			
			String fileName = file.getOriginalFilename();
			String uid = UUID.randomUUID().toString().replaceAll("-","");
			String newFileName = uid + "_" + fileName;
			dto.setImg(newFileName);
			result = bService.boardUpdate(dto);
			
			if(result>0) {
				File targetLoc = new File(filesPath.getAbsoluteFile()+"/"+newFileName);
				FileCopyUtils.copy(file.getBytes(), targetLoc);
			}
		}else {
			result = bService.boardUpdate(dto);
		}
		model.addAttribute("result",result);
		return "board/boardUpdateResult";
	}
	
	// 게시판 글삭제
	@RequestMapping("boardDelete.board")
	public String boardDelete(Model model,int seq) {
		int result = bService.boardDelete(Integer.toString(seq));
		model.addAttribute("result",result);
		return "board/boardDeleteResult";
	}
	
	//게시글 상세보기
	@RequestMapping("viewBoard.board")

	public String viewBoard(HttpServletRequest request, Model model ) throws Exception {
		String id = (String)session.getAttribute("id");
		model.addAttribute("id",id);
		BoardDTO dto = bService.selectPage();
		model.addAttribute("dto", dto);
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

	
	//게시글 목록
	@RequestMapping("boardListView.board")
	public String boardListView(HttpServletRequest request,BoardDTO dto, Model model) throws Exception {
	System.out.println("Controller viewBoard요청 ");
	String id = (String) session.getAttribute("id");
	String cpage = request.getParameter("cpage");
	int currentPage = Integer.parseInt(cpage);
	List<BoardDTO> list = bService.listByCpage(Integer.parseInt(cpage));
	String navi = bService.getNavi(currentPage);
	model.addAttribute("list", list);
	model.addAttribute("navi", navi);
	model.addAttribute("id", id);
	
		return "board/boardListView";	
	}
	
}
