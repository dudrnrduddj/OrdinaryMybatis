<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberWeb Home</title>
</head>
<body>
	<h1>환영합니다 MemberWeb Home입니다~</h1>
	<c:if test="${sessionScope.memberId ne null}">   <!-- ne => '!=' -->
		${sessionScope.memberName}님 환영합니다!
		<a href="/member/mypage.kh">마이페이지</a>
		<a href="/member/logout.kh">로그아웃</a>
		<a href="/notice/insert.kh">공지 등록</a>
		<a href="/notice/list.kh">공지 목록</a>
		<!-- form태그를 이용하여 서버로 값 전송하는 법 -->
<%--     	<form action="/member/remove.kh" method="get">
			<input type="hidden" name="memberId" value="${memberId }">
			<input type="submit" value="회원탈퇴">
		</form> --%>
	</c:if>
	<c:if test="${sessionScope.memberId eq null}">   <!-- eq => '==' -->
		<form action="/member/login.kh" method="post">
			<fieldset>
				<legend>로그인</legend>
				ID : <input type="text" name="memberId"> <br> 
				PW : <input type="password" name="memberPw"> <br> 
				<input type="submit" value="로그인">
				
			</fieldset>
		</form>
		<a href="/member/join.kh">회원가입</a>
	</c:if>
</body>
</html>