<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1 align="center">로그인</h1>
	<hr>
	<table border="1" align="center">
		<form name="LoginFrm" action="login.do" method="POST">
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" size=20></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" size=20></td>
			</tr>
			<tr>
				<td colspan="2" align="cenyer"><input type="submit" value="로그인">
					<input type="reset" value="리셋"></td>
			</tr>

		</form>
	</table>
</body>
</html>