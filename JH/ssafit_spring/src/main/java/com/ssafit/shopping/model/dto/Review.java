package com.ssafit.shopping.model.dto;


public class Review {
	private int id;
	private String videoName;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public Review(String videoName, String title, String writer, String content) {
		this.videoName = videoName;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", videoName=" + videoName + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
	
	


}
