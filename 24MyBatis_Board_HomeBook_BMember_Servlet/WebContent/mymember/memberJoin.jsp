<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Joining Member.</title>
<script type="text/javascript">
	function formCheck(frm) {
		if (frm.mid.value == "") {
			alert("id required")
			frm.id.focus()
			return false;
		}
		if (frm.mpassword.value == "") {
			alert("password required")
			frm.mpassword.focus()
			return false;
		}
		if (frm.mpassword.value != frm.mpassword2.value) {
			alert("password mismatch")
			frm.mpassword.focus()
			return false;
		}
		document.getElementById('homebook_input').submit();
	}
</script>
</head>
<body>
	<h1 align="left">회원 가입</h1>
	<hr>
	<div align="right">
		<button type="button" onclick="history.go(-1)">뒤로</button>
	</div>
	<form id="memberJoin" onsubmit="return formCheck(this)" method="post"
		action="bmemberJoin.do">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="mid" size="20"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpassword" size="20"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="mpassword2" size="20"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" size="20"></td>
			</tr>
			<tr>
				<th>휴대전화</th>
				<td><input type="text" name="mphone" size="20"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"> <input
					type="reset" value="리셋"></td>
			</tr>
		</table>
	</form>

</body>
</html>