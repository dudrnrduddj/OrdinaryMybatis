<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항</title>
		<style type="text/css">
			table {
				width: 800px;
				border: 1px solid black;
				border-collapse: collapse;
			}
			th{
				background-color: #ccc;
			}
			th, td{
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<h2>공지사항</h2>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${nList }" var="notice">
				<tr>
					<td>${notice.noticeNo}</td>
					<td>${notice.subject }</td>
					<td>${notice.writer }</td>
					<td>${notice.regDate }</td>
					<td>${notice.viewCount }</td>
				</tr>
			</c:forEach>
			
			
		</table>
	
		
	</body>
</html>