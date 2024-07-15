<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>공지사항</h2>
		<div>
			<div>${notice.subject } </div>
			<span>작성자 : ${notice.writer }</span>
			<span>작성일 : ${notice.regDate }</span>
			<span>조회수 : ${notice.viewCount }</span>
		</div>
		<div>
			<p>글내용 : ${notice.comment }</p>
		</div>
		<c:if test="${sessionScope.memberName eq notice.writer }">
			<a href="/notice/update.kh?noticeNo=${notice.noticeNo }">수정하기</a>
			<a href="javascript:void(0)" onclick="checkDelete();">삭제하기</a>		
		</c:if>
		<input type="button" id="listBtn" value="목록으로 가기">
		
		<script type="text/javascript">
			var listBtn = document.querySelector('#listBtn');
			listBtn.addEventListener('click',()=>{
				location.href="/notice/list.kh";
			})
			
			function checkDelete(){
				if(confirm("정말 삭제하시겠습니까?")){
					location.href = "/notice/delete.kh?noticeNo=${notice.noticeNo }";
				}
			}
		</script>
		
	</body>
</html>