package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kh.spring.dto.BoardDTO;
import kh.spring.statics.BoardConfigurator;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession session;
	
	// 게시판 글 작성
	public int boardWrite(BoardDTO dto) {
		return session.insert("Board.boardWrite",dto);
	}
		
	// 게시판 글 수정
	public int boardUpdate(BoardDTO dto) {
		return session.update("Board.boardUpdate", dto);
	}
		
	// 게시판 글 삭제
	public int boardDelete(String seq) {
		return session.delete("Board.boardDelete", seq);
	}
	
	public BoardDTO selectPage() {
		return session.selectOne("Board.select");
	}
	
	public List<BoardDTO> listByCpage(int cpage) throws Exception{
		int startRowNum = (cpage-1) * BoardConfigurator.recordCountPerPage + 1;
		int endRowNum = startRowNum + BoardConfigurator.recordCountPerPage - 1;
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		return session.selectList("Board.listByCpage",param);
	}

	public int getDataCount() throws Exception{
		return session.selectOne("Board.getDataCount");
	}
	
	public List<BoardDTO> list() throws Exception{
		return session.selectList("Board.list");
	}
	
	public int setViewCount(int seq)throws Exception {
		return session.update("Board.setViewCount",seq);
	}
}
