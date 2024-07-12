package com.ordinary.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.ordinary.common.SqlSessionTemplate;
import com.ordinary.member.model.dao.MemberDAO;
import com.ordinary.member.model.vo.Member;

public class MemberService {

	// Connection (X) -> SqlSession (O)
	private SqlSession conn;
	private MemberDAO mDao;
	
	public MemberService() {
		this.conn = SqlSessionTemplate.getSqlSession();
		this.mDao = new MemberDAO();
	}
	
	public int insertMember(Member member) {
		int result = mDao.insertMember(conn, member);
		
		return result;
	}

	public Member checkLogin(Member member) {
		Member mOne = mDao.checkLogin(conn, member);
		return mOne;
	}

	public Member selectOneById(String memberId) {
		Member member = mDao.selectOneById(conn, memberId);
		return member;
	}

	public int deleteMember(String memberId) {
		int result = mDao.deleteMember(conn, memberId);
		return result;
	}

	public int modifyMember(Member member) {
		int result = mDao.modifyMember(conn, member);
		return result;
	}

}
