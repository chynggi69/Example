<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formCheck(frm) {
		if (frm.id.value == "") {
			alert("회원 아이디는 반드시 넣어야 합니다.")
			frm.id.focus();
			return false;
		}
		if (frm.password.value !== frm.passwordconf.value) {
			alert("패스워드 확인")
			frm.password.focus();
			return false;
		}
		//모두 정상일때
		document.getElementById('registerForm').submit();

	}
</script>
</head>
<body>
	<h1>회원정보 수정</h1>
	<hr>
	<div align="right">
		<button type="button" onclick="history.go(-1)">뒤로</button>
	</div>
	<table border="1">
		<form name="adjustForm" onsubmit="return formCheck(this)"
			action="MemberInfoAdjust.do" method="POST">
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"
					<%request.setCharacterEncoding("UTF-8");
				String id = "";
				String name = "";
				String password = "";
				String phone = "";
				String joindate = "";
			String index = request.getParameter("index");
			if (index == null) {
				id = (String)session.getAttribute("id");
				out.print("value=\"" + session.getAttribute("id") + "\"");
			} else {

				id = request.getParameter("id" + index);
				name = request.getParameter("name" + index);
				 password = request.getParameter("password" + index);
				 phone = request.getParameter("phone" + index);
				joindate = request.getParameter("joindate" + index);
				if (((String) session.getAttribute("id")).equals("admin")) {
					out.print("value=\"" + id + "\"");
				} else {
					out.print("value=\"" + session.getAttribute("id") + "\"");
				}
			}%>
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="password" name="password"
					value="<%=password%>"></td>
			</tr>
			<tr>
				<th>PASSWORD CONFIRM</th>
				<td><input type="password" name="passwordconf"
					value="<%=password%>"></td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td><input type="text" name="phone" value="<%=phone%>">
					<input type="hidden" name="joindate" value=<%=joindate.substring(0,10)%>></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정하기"> <input
					type="reset" value="다시작성"> <%
 	if (id.equals("admin")) {
 %>
					<button type="button" onclick="location.href='memberList.do'">회원목록</button>
					<%
						}
					%></td>
			</tr>
		</form>
	</table>
</body>
</html>