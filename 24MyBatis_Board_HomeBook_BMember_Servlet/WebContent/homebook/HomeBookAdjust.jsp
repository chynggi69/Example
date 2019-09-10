<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src='../jquery-3.4.1.min.js'></script>
<script>
	function radiocheck(value) {
		$('input:radio[name=section]:input[value=' + value + ']').attr("checked", true);
	}
	function optionselect(value) {
		$("#account_title").val(value).prop("selected", true);
	}
	function isadmin(id) {
		if (id == "admin") {
			$("#id").prop('readonly', false);
		}

	}
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("id");
		String index = request.getParameter("index");
		System.out.println(index);
		String serialno = request.getParameter("serialno" + index);
		String user_id = request.getParameter("user_id" + index);
		String day = request.getParameter("day" + index);
		String section = request.getParameter("section" + index);
		System.out.println(section);
		String account_title = request.getParameter("account_title" + index);
		System.out.println(account_title);
		String remark = request.getParameter("remark" + index);
		System.out.println(remark);
		int revenue = Integer.parseInt((request.getParameter("revenue" + index)));
		int expense = Integer.parseInt((request.getParameter("expense" + index)));
	%>

	<h1 align="center">
		<img width="50" height="50" src="../homebook.png"> 가계부 수정
	</h1>
	<hr>
	<form name="homebook_adjust" onsubmit="return formcheck(this)"
		method="POST" action="homebookadjust.do">
		<table border="1" align="center">
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id"
					placeholder="등록된 회원 ID" size="20" value=<%=user_id%> readonly></td>
			</tr>
			<tr>
				<td>관리번호</td>
				<td><input type="text" name="serialno"
					placeholder="관리번호(AutoSet)" size="20" value=<%=serialno%> readonly></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><input type="date" name="day" size="20" value=<%=day%>></td>
			</tr>
			<tr>
				<td>수지구분</td>

				<td><input type="radio" name="section" value="수입">수입 <input
					type="radio" name="section" value="지출" checked="checked">지출
				</td>
			</tr>
			<tr>
				<td>계정과목</td>
				<td><select name="account_title" id="account_title">
						<optgroup label="수입항목">
							<option value="월급">월급</option>
							<option value="상여금">상여금</option>
							<option value="잡수입">잡수입</option>
						</optgroup>
						<optgroup label="지출항목">
							<option value="피복비">피복비</option>
							<option value="외식비">외식비</option>
							<option value="식재료비">식재료비</option>
							<option value="공과금">공과금</option>
							<option value="상여금">상여금</option>
							<option value="자산매입">자산매입</option>
							<option value="소모품비">소모품비</option>
							<option value="차량유지비">차량유지비</option>
							<option value="접대비">접대비</option>
							<option value="모임회비">모임회비</option>
							<option value="기타잡비">기타잡비</option>
						</optgroup>
				</select></td>
			</tr>
			<tr>
				<td>적요(수지내역)</td>
				<td><input type="text" name="remark" size="50"
					value="<%=remark%>"></td>
			</tr>
			<tr>
				<td>수입(차변)</td>
				<td><input type="text" name="revenue" value=<%=revenue%>></td>
			</tr>
			<tr>
				<td>지출(대변)</td>
				<td><input type="text" name="expense" value=<%=expense%>></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="자료 입력"> <input type="reset" value="다시 작성">
			</tr>
		</table>
		<script>	
		radiocheck("<%=section%>");
		optionselect("<%=account_title%>");
		isadmin("<%=id%>");
	</script>
	</form>	
</body>
</html>