package com.ordinary.notice.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Notice {
	private int noticeNo;
	private String subject;
	private String comment;
	private String writer;
	private Timestamp regDate;
	private Timestamp updateDate;
	private int viewCount;
	
	
	public Notice() {}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public Notice(String subject, String comment) {
		super();
		this.subject = subject;
		this.comment = comment;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", subject=" + subject + ", comment=" + comment + ", writer=" + writer
				+ ", regDate=" + regDate + ", updateDate=" + updateDate + ", viewCount=" + viewCount + "]";
	}
	
	
	
	
	
	
}
