package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CommentDAO;
import kh.spring.dto.CommentDTO;
import kh.spring.statics.BoardConfigurator;

@Service
public class CommentService {
	@Autowired
	private CommentDAO dao;

	public int insert(CommentDTO dto) {
		return dao.insert(dto);
	}
	public List<CommentDTO> commentList(int page,CommentDTO dto){
		return dao.commentList(page,dto);
	}
	public int delete(CommentDTO dto) {
		return dao.delete(dto);
	}
	public int update(CommentDTO dto) {
		return dao.update(dto);
	}
	public int getDataCount(CommentDTO dto){
		return dao.getDataCount(dto);
	}
	public String commentNavi(int currentPage,CommentDTO dto) throws Exception {
		int recordTotalCount = getDataCount(dto); 
		int pageTotalCount = 0;
		if(recordTotalCount % BoardConfigurator.recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / BoardConfigurator.recordCountPerPage+ 1;
		}else {
			pageTotalCount = recordTotalCount/ BoardConfigurator.recordCountPerPage;
		}
		if(currentPage < 1) {
			currentPage = 1;
		}else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = (currentPage-1) / BoardConfigurator.naviCountPerPage * BoardConfigurator.naviCountPerPage  +1;
		int endNavi = startNavi + BoardConfigurator.naviCountPerPage  - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {needPrev = false;}
		if(endNavi == pageTotalCount) {needNext = false;}
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='viewBoard.board?cpage="+(startNavi-1)+"&seq="+dto.getLocation()+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='viewBoard.board?cpage="+i+"&seq="+dto.getLocation()+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='viewBoard.board?cpage="+(endNavi+1)+"&seq="+dto.getLocation()+"'> > </a>");
		}
		return sb.toString();
	}
}
