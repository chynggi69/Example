<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부 입력폼</title>
<script type="text/javascript">
	 function formCheck(frm)
	 {
		if(frm.id.value =="")
			{
				alert("id required")
				frm.id.focus()
				return false;
			}
		 }
	 if(frm.section.value =="수입"&&frm.expense.value!=0)
		{
			alert("expense required to 0")
			frm.expense.focus()
			return false;
		}
	 if(frm.section.value =="지출"&&frm.revenue.value!=0)
		{
			alert("revenue required to 0")
			frm.revenue.focus()
			return false;
		}
	 }
	 document.getElementById('homebook_input').submit();
</script>
</head>
<body>
	<%
		String loginOK = (String) session.getAttribute("loginOK");
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		if (!loginOK.equals("OK")) {
			response.sendRedirect("../Main.do");
		}
	%>
	<h1 align="center"><%=name%></h1>
	<div align="right">
		<button type="button" onclick="history.go(-1)">뒤로</button>
		<button type="button" onclick="location.href='../main.do'">메인으로</button>
	</div>
	<hr>
	<table border="1" align="center">
		<form id="homebook_input" onsubmit="return formCheck(this)"
			method="post" action="homebook.do">
			
			<tr>
				<th>아이디</th>
				<td>
				<input type="text" name = "id" size = "20" value = "<%=id%>">
				
				
				</td>
			</tr>
			<tr>
				<th>관리번호</th>
				<td>
				<input type="text" name = "serialno" size = "20" value = "자동">
				</td>
			</tr>
			<tr>
				<th>일자</th>
				<td>
				<input type="date" name = "day" size = "20" value = "자동">
				</td>
			</tr>
			<tr>
				<th>수지구분</th>
				<td>
				<input type="radio" name = "section" size = "20" value = "수입">수입
				<input type="radio" name = "section" size = "20" value = "지출" checked="checked">지출
				</td>
			</tr>
			<tr>
				<th>계정과목</th>
				<td>
				<select name = "account_title">
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
					<option value="자산매입">자산매입</option>
					<option value="소모품비">소모품비</option>
					<option value="차량유지비">차량유지비</option>
					<option value="접대비">접대비</option>
					<option value="모임회비">잡수입</option>
					<option value="기타잡비">잡수입</option>
				</optgroup>
				
				</select>
				</td>
			</tr>
			<tr>
				<th>적요(수지내역)</th>
				<td>
				<input type="text" name = "remark" size = "70">				
				</td>
			</tr>
			<tr>
				<th>수입(차변)</th>
				<td>
				<input type="text" name = "revenue" size = "20" value = "0">
				</td>
			</tr>
			<tr>
				<th>지출(대변)</th>
				<td>
				<input type="text" name = "expense" size = "20">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="입력">
				<input type="reset" value="리셋">
				<button type="button" onclick="location.href='datadisp2.jsp'">자료보기</button>
				</td>
			</tr>

		</form>
	</table>
</body>
</html>