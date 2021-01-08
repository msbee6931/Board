package kh.spring.dto;

import java.sql.Date;

public class MembersDTO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String img;
	private Date join_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public MembersDTO(String id, String pw, String name, String email, String img, Date join_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.img = img;
		this.join_date = join_date;
	}
	public MembersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
