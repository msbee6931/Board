package kh.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;
import kh.spring.service.MembersService;

@Controller

@RequestMapping("/members")

public class MembersContorller {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private MembersDAO mDao;
	@Autowired
	private MembersService mService;
	
		
		@RequestMapping("againConfirm")
		public String again(HttpSession session) {
			return "members/againConfirm";
		}
		
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			session.removeAttribute("id");
			return "home";
		}
		
		@RequestMapping("mypage")
		public String myPage(HttpSession session,Model model) {
			String id = (String)session.getAttribute("id");
			MembersDTO dto = mService.selectAll(id);
			model.addAttribute("dto",dto);
			return "members/mypage";
		}
		
		
		
		@RequestMapping("updatePage")
		public String updatePage(HttpSession session,Model model) {
			String id = (String)session.getAttribute("id");
			MembersDTO dto = mService.selectAll(id);
			model.addAttribute("dto",dto);
			return "members/update";
		}
		
		@RequestMapping("update")
		public String update(MembersDTO dto,HttpSession session){

			
			dto.setId((String)session.getAttribute("id"));
			
			System.out.println("이메일 : "+dto.getEmail()+", name : "+dto.getName()+", img : "+dto.getImg()+", id : "+dto.getId());
			mService.update(dto);
			return "home";
		}
	
	@RequestMapping("signUp.mem")
	public String toSignUp() {
		return "members/SignUp";
	}
	
	@RequestMapping(value="idCheck.mem",produces="text/plain; charset=UTF8")
	@ResponseBody
	public String checkId(String id) throws Exception {
		int result = mService.checkId(id);
		if(result>0) {
			return "ID중복.";
		}else {
			return "사용가능.";
		}
		
	}
	
	@RequestMapping(value="okSignUp.mem",produces="text/plain; charset=UTF8")
	public String okSignUp(MembersDTO dto) throws Exception{
		int result = mDao.insert(dto);
		if(result>0) {
			return "home";
		}else {
			return "error";
		}
		
	}
	@RequestMapping(value="login.mem",produces="text/plain; charset=UTF8")
	public String login(String id,String pw) throws Exception {
		int result = mService.loginCheck(id, pw);
		if(result>0) {
			session.setAttribute("id", id);
			return "home";
		}else {
			return "error";
		}
		

	}
	
	@ExceptionHandler
	public String exceptionHandler(Exception e) {
		return "error";
	}

}
