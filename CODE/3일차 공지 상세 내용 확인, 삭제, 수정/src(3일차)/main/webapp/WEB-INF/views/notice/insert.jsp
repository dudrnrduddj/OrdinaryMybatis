<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 등록</title>
	</head>
	<body>
		<form action="/notice/insert.kh" method="post">
			<fieldset style="width: 600px; margin: auto">
				<legend>공지사항 등록 (작성자 : ${sessionScope.memberName})</legend>
				<div>
					<div style="float:left; margin-right: 10px">제목 : </div>
					<input type="text" name="subject" style="width: 500px"> <br>
				</div>
				<div style="margin-top: 10px">
					<div style="float: left; margin-right: 10px;">내용 : </div>
					<textarea rows="10" name="comment" cols="70"></textarea>
				</div>
			<input type="submit" value="등록">
			</fieldset>
		</form>
	</body>
</html>