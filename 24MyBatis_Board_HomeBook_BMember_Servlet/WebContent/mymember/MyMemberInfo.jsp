<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = null;
		String name = null;
		String password = null;
		String phone = null;
		String joindate = null;
		System.out.println("a");
		try {
			System.out.println("NANI0");
			id = (String) request.getAttribute("id");
			name = (String) request.getAttribute("name");
			password = (String) request.getAttribute("password");
			phone = (String) request.getAttribute("phone");
			joindate= (String) request.getAttribute("joindate");
			if (id == null || name == null || password == null || phone == null||joindate==null) {
				System.out.println("NANI1");
	%>
	<script>
		if (confirm("정보가 제대로 전송되지 않았습니다. 재로그인해주세요.")) {
			document.location = '../Login/formLogin.jsp';
		}
	</script>
	<%
		return;
			}
		} catch (Exception e) {
			System.out.println("NANI2");
			%>
			<script>
				if (confirm("정보가 제대로 전송되지 않았습니다. 재로그인해주세요.")) {
					document.location = '../Login/formLogin.jsp';
				}
			</script>
			<%
		}
	%>
	<h1>내 정보</h1>
	<hr>
	<div align="right">
		<button type="button" onclick="history.go(-1)">뒤로</button>
	</div>
	<table border='1' align='left' width='50%'>
		<tr>
			<th>ID</th>
			<td><%=id%></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><%=name%></td>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<td>
				<%
					for (int i = 0; i < password.length(); i++) {
						out.print("●");
					}
				%> &nbsp;&nbsp;보안을 위해 ●로 처리되었습니다.
				<button align='right' type="button"
					onclick="location.href='passwordAdjust.jsp'">비밀번호 변경</button>
			</td>

		</tr>
		<tr>
			<th>PHONE</th>
			<td><%=phone%></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><%=joindate%></td>
		</tr>
		<tr>		
			<td colspan='2'>
			<form name="dataform1" action="MyMemberAdjust.jsp" method="post">
			<input type="hidden" name="id1" value=<%=id%>> <input
				type="hidden" name="name1" value=<%=name%>> <input
				type="hidden" name="password1" value=<%=password%>>
			<input type="hidden" name="phone1" value=<%=phone%>>
			<input type="hidden" name="joindate1" value=<%=joindate%>>
			<input type="hidden" name="index" value="1">
				<input type="submit" value="회원정보 수정">
					<% 
					if(id.equals("admin"))
					{
					%>
				<button type="button" onclick="location.href='memberList.do'">회원목록</button>
				<% 
					}
				%>
				</form>
			</td>
		</tr>
	</table>


</body>
</html>