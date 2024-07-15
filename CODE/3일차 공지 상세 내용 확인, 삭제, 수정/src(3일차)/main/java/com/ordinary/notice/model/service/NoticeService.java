package com.ordinary.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ordinary.common.SqlSessionTemplate;
import com.ordinary.notice.model.dao.NoticeDAO;
import com.ordinary.notice.model.vo.Notice;

public class NoticeService {
	private NoticeDAO nDao;
	private SqlSession conn;
	
	public NoticeService() {
		this.conn = SqlSessionTemplate.getSqlSession();
		this.nDao = new NoticeDAO();
	}

	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(conn, notice);
		return result;
	}

	public List<Notice> selectAllNotice() {
		List<Notice> nList = nDao.selectAllNotice(conn);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		Notice notice = nDao.selectOneByNo(conn, noticeNo);
		return notice;
	}

	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(conn, notice);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = nDao.deleteNotice(conn, noticeNo);
		return result;
	}
	
	
	
}
