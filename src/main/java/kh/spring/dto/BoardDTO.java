package kh.spring.dto;

import java.sql.Date;

public class BoardDTO {
   private int seq;
   private String title;
   private String writer;
   private String contents;
   private String img;
   private int view_count;
   private Date write_date;
   
   public BoardDTO() {}
   public BoardDTO(int seq, String title, String writer, String contents, String img, int view_count,
         Date write_date) {
      super();
      this.seq = seq;
      this.title = title;
      this.writer = writer;
      this.contents = contents;
      this.img = img;
      this.view_count = view_count;
      this.write_date = write_date;
   }
   
   public int getSeq() {
      return seq;
   }
   public void setSeq(int seq) {
      this.seq = seq;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public String getContents() {
      return contents;
   }
   public void setContents(String contents) {
      this.contents = contents;
   }
   public String getImg() {
      return img;
   }
   public void setImg(String img) {
      this.img = img;
   }
   public int getView_count() {
      return view_count;
   }
   public void setView_count(int view_count) {
      this.view_count = view_count;
   }
   public Date getWrite_date() {
      return write_date;
   }
   public void setWrite_date(Date write_date) {
      this.write_date = write_date;
   }
}