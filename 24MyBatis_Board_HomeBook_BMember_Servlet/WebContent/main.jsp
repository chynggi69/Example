<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/headers.css" rel="stylesheet" type="text/css">
<title>MainPage</title>
</head>
<body>
	<h1 align="center">
		<img width="50" height="50" src="./homebook.png"> Welcome!
	</h1>
	<h3 align="right">
		<%
			String id = null;
			String name	= null;
			try{
				id = (String) session.getAttribute("id");
				name = (String) session.getAttribute("name");
			}catch (Exception e){
				out.print("비로그인 상태입니다. <a href='./login/formLogin.jsp'>로그인</a>&nbsp;"
						+ "<a href='./mymember/memberJoin.jsp'>회원가입</a><hr>");
				%>
				<jsp:include page="./prefrences/header_logout.jsp"></jsp:include>
				<%
			}
			if (id == null || name == null) {
				out.print("비로그인 상태입니다. <a href='./login/formLogin.jsp'>로그인</a>&nbsp;"
						+ "<a href='./mymember/memberJoin.jsp'>회원가입</a><hr>");
				%>
				<jsp:include page="./prefrences/header_logout.jsp"></jsp:include>
				<%
			} else {
				out.print(name + "님 환영합니다. <a href='./mymember/MemberInfo.do'>내 정보</a>&nbsp;"
						+ "<a href='./login/Logout.do'>로그아웃</a><hr>");
				if(id.equals("admin"))
				{
				%>
				<jsp:include page="./prefrences/header_admin.jsp"></jsp:include>
				<%
				}
				else
				{
				%>
					<jsp:include page="./prefrences/header.jsp"></jsp:include>	
				<%	
				}
			}
		%>		
	</h3>	
	<div align="center"><img src="./homebook_large.jpg"></div>
	<jsp:include page="./prefrences/footer.jsp"></jsp:include>	
</body>
</html>