<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<h1>당신의 계정 ID를 입력하세요.</h1>
<hr>
<form name = "passwordSeek" action="password.do" method="post">
	<input type="text" name="id" size="20" required="required">
	<input type="submit" value="전송">
</form>
</body>
</html>