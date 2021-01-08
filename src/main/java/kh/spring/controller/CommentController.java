package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


import kh.spring.dto.CommentDTO;
import kh.spring.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private CommentService service;
	
	@RequestMapping("insert.comment")
	@ResponseBody
	public String insert(HttpServletRequest request){
		String id =(String)session.getAttribute("id");
		int location = Integer.parseInt(request.getParameter("seq"));
		String content = request.getParameter("content");
		System.out.println("id :" +id+" location :" + location + " content" + content);
		CommentDTO  dto = new CommentDTO();
		dto.setWriter(id);
		dto.setLocation(location);
		dto.setContent(content);
		int result = service.insert(dto);
		if(result > 0) {
			int cpage=1;		
			List<CommentDTO> list =  service.commentList(cpage,dto); //댓글리스트
			Gson gson = new Gson();
			return gson.toJson(list);
		}
		return "false";
	}
	@RequestMapping("getNavi.comment")
	@ResponseBody
	public String getNavi(HttpServletRequest request) throws Exception{
		int location = Integer.parseInt(request.getParameter("seq"));
		CommentDTO  dto = new CommentDTO();
		dto.setLocation(location);
		int cpage =1;
		String navi = service.commentNavi(cpage, dto);
		return navi;
	}
	@RequestMapping("del.comment")
	@ResponseBody
	public String delete(HttpServletRequest request) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		CommentDTO  dto = new CommentDTO();
		dto.setSeq(seq);
		service.delete(dto);
		return "true";
	}
	@RequestMapping("update.comment")
	@ResponseBody
	public String update(HttpServletRequest request){
		int seq = Integer.parseInt(request.getParameter("seq"));
		String content = request.getParameter("content");
		System.out.println(content +":"+ seq);
		CommentDTO  dto = new CommentDTO();
		dto.setContent(content);
		dto.setSeq(seq);
		service.update(dto);
		return "true";
	}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}
}
