package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;

@Service
public class MembersService {
	
	@Autowired
	private MembersDAO mDao;
	
	
	public int quit(MembersDTO dto) {
		return mDao.quit(dto);
	}
	
	public int update(MembersDTO dto) {
		return mDao.update(dto);
	}
	
	public MembersDTO selectAll(String id) {
		return mDao.selectAll(id);
	}
}
