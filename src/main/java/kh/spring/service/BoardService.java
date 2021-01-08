package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO bDao;
	
	// 게시판 글 작성
	public int boardWrite(BoardDTO dto) {
		return bDao.boardWrite(dto);
	}
	
	// 게시판 글 수정
	public int boardUpdate(BoardDTO dto) {
		return bDao.boardUpdate(dto);
	}
	
	// 게시판 글 삭제
	public int boardDelete(String seq) {
		return bDao.boardDelete(seq);
	}
}
