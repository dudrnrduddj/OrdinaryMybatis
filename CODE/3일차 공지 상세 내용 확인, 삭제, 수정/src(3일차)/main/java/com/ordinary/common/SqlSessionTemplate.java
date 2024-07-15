package com.ordinary.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		try {
			//1. MyBatis 설정 파일을 읽어와 SqlSessionFactory를 생성할 준비를 합니다.
			InputStream is = Resources.getResourceAsStream(resource);
			
			//2. SqlSessionFactory를 만들기 위한 빌더 객체를 초기화합니다.
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 공장 기술자
			
			//3. MyBatis 설정 파일을 기반으로 SQL 세션을 생성할 수 있는 SqlSessionFactory 객체를 생성합니다.
			SqlSessionFactory sessionFactory = builder.build(is); // 공장 만들어짐(스트림 객체 전달)
			
			// 4. 자동 커밋 모드로 설정된 새로운 SQL 세션을 생성하여, SQL 작업을 수행할 준비를 합니다.
			session = sessionFactory.openSession(true); // 연결 생성 
			// true : 자동 커밋 모드
			// false : 수동 커밋 모드
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
