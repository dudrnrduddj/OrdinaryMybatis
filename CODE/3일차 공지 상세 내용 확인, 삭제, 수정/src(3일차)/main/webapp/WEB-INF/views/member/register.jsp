<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<h3>회원정보를 입력하세요</h3>
	<fieldset>
		<legend>회원가입</legend>
		<form action="/member/join.kh" method="post">
			아이디 : <input type="text" name="member-id" placeholder="아이디를 입력해주세요"> <br>
			비밀번호 : <input type="password" name="member-pw" placeholder="비밀번호를 입력해주세요"> <br>
			이름 : <input type="text" name="member-name"> <br>
			성별 : 남<input type="radio" name="member-gender" value="M"> 여<input type="radio" name="member-gender" value="F"> <br>
			나이 : <input type="number" name="member-age"> <br>
			이메일 : <input type="text" name="member-email"> <br>
			전화번호 : <input type="text" name="member-phone"> <br>
			주소 : <input type="text" name="member-address"> <br>
			취미 : <input type="text" name="member-hobby"> <br>
			<input type="submit" value="회원가입">
		</form>
	</fieldset>
</body>
</html>