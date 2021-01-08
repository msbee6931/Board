package kh.spring.controller;

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
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private HttpSession session;
	@Autowired
	private BoardService bService;
	
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
		return "boardWriteResult";
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
		return "boardUpdateResult";
	}
	
	// 게시판 글삭제
	@RequestMapping("boardDelete.board")
	public String boardDelete(Model model,int seq) {
		int result = bService.boardDelete(Integer.toString(seq));
		model.addAttribute("result",result);
		return "boardDeleteResult";
	}
}
