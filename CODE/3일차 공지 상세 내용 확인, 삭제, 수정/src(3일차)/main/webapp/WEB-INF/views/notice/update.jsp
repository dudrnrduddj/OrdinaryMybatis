<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 수정</title>
	</head>
	<body>
		<fieldset>
			<legend>공지사항 수정</legend>
			<form action="/notice/update.kh" method="post">
			<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
				<div>
					<div style="float:left; margin-right: 10px">제목 : </div>
					<input type="text" name="subject" style="width: 500px" value="${notice.subject }"> <br>
				</div>
				<div style="margin-top: 10px">
					<div style="float: left; margin-right: 10px;">내용 : </div>
					<textarea rows="10" name="comment" cols="70">${notice.comment }</textarea>
				</div>
				<input type="submit" value="수정하기">			
			</form>
		</fieldset>
	</body>
</html>