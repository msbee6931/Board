package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;
import kh.spring.service.MembersService;

@Controller
@RequestMapping("/member")
public class MembersContorller {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private MembersDAO mDao;
	@Autowired
	private MembersService mService;
	
	
	@RequestMapping("signUp.mem")
	public String toSignUp() {
		return "member/SignUp";
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
