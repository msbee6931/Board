package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CommentDTO;
import kh.spring.statics.BoardConfigurator;


@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession session;
	
	public int insert(CommentDTO dto) {
		return session.insert("Comment.insert",dto);
	}
	public int delete(CommentDTO dto) {
		return session.delete("Comment.delete",dto);
	}
	public int update(CommentDTO dto) {
		return session.update("Comment.update",dto);
	}
	public List<CommentDTO> commentList(int page,CommentDTO dto){
		int startRowNum = (page-1)*BoardConfigurator.recordCountPerPage +1;
	    int endRowNum = startRowNum + BoardConfigurator.recordCountPerPage -1;
		Map<String, Object> param =new HashMap<String, Object>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Comment.commentList",param);
	}
	public int getDataCount(CommentDTO dto) {
		return session.selectOne("Comment.getDataCount",dto);
	}
}
