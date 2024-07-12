package com.ordinary.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ordinary.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession conn, Notice notice) {
		int result = conn.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectAllNotice(SqlSession conn) {
		List<Notice> nList = conn.selectList("NoticeMapper.selectList");
		return nList;
	}

}
