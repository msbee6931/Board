package kh.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MembersDTO;

@Repository
public class MembersDAO {
	@Autowired
	private SqlSession db;
	
	public int checkId(String id) throws Exception{
		return db.selectOne("Members.checkId",id);
	}
	public int insert(MembersDTO dto)throws Exception{
		return db.insert("Members.insert",dto);
	}
	public int loginCheck(String id,String pw) throws Exception{
		Map<String,String> param = new HashMap();
		param.put("id", id);
		param.put("pw", pw);
		return db.selectOne("Members.logincheck",param);
	}

}
