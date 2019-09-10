<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cyg.dto.*"%>
<%@ page import="com.cyg.dao.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMembers List</title>
</head>
<body>
	<h1>BMembers List</h1>
	<h4>
		<a href="../main.jsp">메인으로 돌아가기</a>
	</h4>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>P/W</th>
			<th>Phone</th>
			<th>가입일자</th>
			<th>수정</th>
		</tr>
		<%
			List<BMember> data = (List<BMember>) request.getAttribute("data");
			if (data.size() > 0) {
				for (BMember x : data) {
					int i = 1;
		%>
		<form name="dataform<%=i%>" action="MyMemberAdjust.jsp" method="post">
			<input type="hidden" name="id<%=i%>" value=<%=x.getMid()%>> <input
				type="hidden" name="name<%=i%>" value=<%=x.getMname()%>> <input
				type="hidden" name="password<%=i%>" value=<%=x.getMpassword()%>>
			<input type="hidden" name="phone<%=i%>" value=<%=x.getMphone()%>>			
			<input type="hidden" name="joindate1" value=<%=x.getMjoinDate()%>>
			<input type="hidden" name="index" value=<%=i%>>

			<%
				out.print("<tr>");
						out.print("<td>" + x.getMid() + "</td>");
						out.print("<td>" + x.getMname() + "</td>");
						out.print("<td>" + x.getMpassword() + "</td>");
						out.print("<td>" + x.getMphone() + "</td>");
						out.print("<td>" + x.getMjoinDate().substring(0,10) + "</td>");
						%>
						<td><input type="submit" value="수정"></td>
						</form>
						<%
						out.print("</tr>");
						i++;
					}
				} else {
					out.print("<tr colspan='4'>데이터가 없습니다.</tr>");
				}
			%>
		
	</table>
</body>
</html>