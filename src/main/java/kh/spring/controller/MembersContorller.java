package kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MembersDTO;
import kh.spring.service.MembersService;

@Controller
@RequestMapping("/members")
public class MembersContorller {
	@Autowired
	private MembersService mService;
	
		
		@RequestMapping("re-quest")
		public String quit(HttpSession session) {
			MembersDTO dto = new MembersDTO();
			dto.setId((String)session.getAttribute("id"));
			mService.quit(dto);
			return "members/re-quest";
		}
		
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			session.removeAttribute("id");
			return "home";
		}
		@RequestMapping("updatePage")
		public String updatePage(HttpSession session,Model model) {
			String id = (String)session.getAttribute("id");
			MembersDTO dto = mService.selectAll(id);
			model.addAttribute("dto",dto);
			return "updatePage";
		}
		
		@RequestMapping("update")
		public String update(HttpServletRequest request,HttpSession session){
			MembersDTO dto = new MembersDTO();
			dto.setEmail((String)request.getAttribute("email"));
			dto.setName((String)request.getAttribute("name"));
			dto.setImg((String)request.getAttribute("img"));
			dto.setId((String)session.getAttribute("id"));
			mService.update(dto);
			
			return "home";
		}
		
}
