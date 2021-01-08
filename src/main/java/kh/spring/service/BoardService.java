package kh.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.statics.BoardConfigurator;

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

	public BoardDTO selectPage() {
		return bDao.selectPage();
	}
	
	public List<BoardDTO> listByCpage(int cpage) throws Exception{
		return bDao.listByCpage(cpage);
	}
	
	public int getDataCount() throws Exception{
		return bDao.getDataCount();
	}
	
	public List<BoardDTO> list() throws Exception{
		return bDao.list();
	}
	
	public int setViewCount(int seq)throws Exception {
		return bDao.setViewCount(seq);
	}
	
	public String getNavi(int currentPage) throws Exception {
		int recordTotalCount = getDataCount();
		int pageTotalCount;
		
		if(recordTotalCount % BoardConfigurator.recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / BoardConfigurator.recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / BoardConfigurator.recordCountPerPage; 
		}

		// 보안 처리 코드
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage-1) / BoardConfigurator.naviCountPerPage * BoardConfigurator.naviCountPerPage + 1;
		int endNavi = startNavi + BoardConfigurator.naviCountPerPage - 1;

		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount ) {
			needNext = false;
		}


		StringBuilder sb = new StringBuilder(); // 메모리 효율성과 코드의 가독성에 좋음

		if(needPrev) {
			sb.append("<li class='page-item'> a class='page-link' href='/board/boardListView?cpage="+(startNavi-1)+
					"' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>");
		}
		for(int i=startNavi; i <= endNavi; i++) {
			sb.append("<li class='page-item'><a class='page-link' href='/board/boardListView?cpage='>"+i+"</a></li>");
		}
		if(needNext) {
			sb.append("<li class='page-item'> a class='page-link' href='/board/boardListView?cpage="+(endNavi+1)+
					"' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>");
		}

		return sb.toString();
	}
}
