package kh.spring.dto;


public class CommentDTO {
	private int seq;
	private String writer;
	private String content;
	private int location;
	private String reg_date;
	public CommentDTO() {}
	public CommentDTO(int seq, String writer, String content, int location, String reg_date) {
		this.seq = seq;
		this.writer = writer;
		this.content = content;
		this.location = location;
		this.reg_date = reg_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}
