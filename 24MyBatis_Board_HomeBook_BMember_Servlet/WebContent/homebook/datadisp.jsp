<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cyg.dto.HomeBook"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataDisp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		List<HomeBook> data = (List<HomeBook>)request.getAttribute("data");
		
		
	%>
	<h1>입력자료목록</h1>
	<hr>
	<table border="1">
	<tr>
		<th>관리번호</th>
		<th>날짜</th>
		<th>수지구분</th>
		<th>계정과목</th>
		<th>적요(수지내역)</th>
		<th>수입(차변)</th>
		<th>지출(대변)</th>
		<th>사용자ID</th>
		<th>수정</th>
	</tr>
	<%
		int i = 1;
		for(HomeBook x:data)
		{
			String remark = x.getRemark();
			%>
			<form name = "dataform<%=i%>" action="HomeBookAdjust.jsp" method="post">
			<input type="hidden" name="serialno<%=i%>" value=<%=x.getSerialno()%>>
			<input type="hidden" name="day<%=i%>" value=<%=x.getDate() %>>
			<input type="hidden" name="section<%=i%>" value=<%=x.getSection()%>>
			<input type="hidden" name="account_title<%=i%>" value=<%=x.getAccount_title()%>>
			<input type="hidden" name="remark<%=i%>" value='<%=remark%>'>
			<input type="hidden" name="revenue<%=i%>" value=<%=x.getRevenue()%>>
			<input type="hidden" name="expense<%=i%>" value=<%=x.getExpense()%>>
			<input type="hidden" name="user_id<%=i%>" value=<%=x.getUser_id()%>>
			<input type="hidden" name="index" value = <%=i %>>
			<%
			out.print("<tr>");
			out.print("<td>"+x.getSerialno()+"</td>");
			out.print("<td>"+x.getDate()+"</td>");
			out.print("<td>"+x.getSection()+"</td>");
			out.print("<td>"+x.getAccount_title()+"</td>");
			out.print("<td>"+x.getRemark()+"</td>");
			out.print("<td>"+x.getRevenue()+"</td>");
			out.print("<td>"+x.getExpense()+"</td>");
			out.print("<td>"+x.getUser_id()+"</td>");			
			%>
			<td><input type="submit" value="수정"></td>
			</form>
			<%
			out.print("</tr>");
			i++;
		}	
	%>
	
	
	</table>
	<button type="button" onclick="location.href='./form_homebook.jsp'">입력 화면으로.</button>
</body>
</html>