package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;

@Service
public class MembersService {
	@Autowired
	private MembersDAO mDao;
	
	public int checkId(String id) throws Exception{
		return mDao.checkId(id);
	}
	public int loginCheck(String id, String pw)throws Exception{
		return mDao.loginCheck(id, pw);
	}
	public int insert(MembersDTO dto)throws Exception{
		return mDao.insert(dto);
	}

}
