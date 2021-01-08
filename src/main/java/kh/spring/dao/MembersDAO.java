package kh.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MembersDTO;

@Repository
public class MembersDAO {

	@Autowired
	SqlSession session;
	
	public int quit(MembersDTO dto) {
		return session.delete("Members.quit",dto);
	}
	
	public int update(MembersDTO dto) {
		return session.update("Members.update",dto);
	}
	
	public MembersDTO selectAll(String id) {
		return session.selectOne("Members.selectAll",id);
	}
}
