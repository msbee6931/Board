package kh.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession db;
	
	// 게시판 글 작성
	public int boardWrite(BoardDTO dto) {
		return db.insert("Board.boardWrite",dto);
	}
	
	// 게시판 글 수정
	public int boardUpdate(BoardDTO dto) {
		return db.update("Board.boardUpdate", dto);
	}
	
	// 게시판 글 삭제
	public int boardDelete(String seq) {
		return db.delete("Board.boardDelete", seq);
	}
}
