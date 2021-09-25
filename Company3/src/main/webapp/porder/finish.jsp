<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "Model.porder" %>
<%@ page import = "Model.member" %>
<%
	porder p = (porder)session.getAttribute("P");
	member m = (member)session.getAttribute("M");

%>
<SCRIPT LANGUAGE="JavaScript">

<!-- This script and many more are available free online at -->
<!-- The JavaScript Source!! http://javascript.internet.com -->

<!-- Begin
function varitext(text){
text=document
print(text)
}
//  End -->
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../st2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="title"><jsp:include page="../title.jsp"></jsp:include></div>
<div id="content">

			<table width=500 align=center border=0>
				<tr>
					<td colspan=2 align=center>
					<h3>訂票完成，這是你的定單細目</h3>
					
				<tr>
					<td>客戶名稱
					<td><%=m.getName() %>
				<tr>
					<td>電話:(H)<%=m.getPhone() %> 
					<td>(m)<%=m.getMobile() %>
				<tr>
					<td>地址: 
					<td><%=m.getAddress() %>
					<tr>
						<td colspan=2>
						<hr>
					<tr>
						<td width=100 align=center>桌號
						<td><%=p.getDesk() %>
					<tr>
						<td width=100 align=center>A
						<td><%=p.getA() %>
					<tr>
						<td width=100 align=center>B
						<td><%=p.getB() %>
					<tr>
						<td width=100 align=center>C
						<td><%=p.getC() %>
					<tr>
						<td width=100 align=center>金額
						<td><%=p.getSum() %>
					<tr>
						<td colspan=2>
						<hr>	
					<tr>
						<td colspan=2 align=center>
						<a href="index.jsp">首頁</a>		
						<DIV ALIGN="CENTER">
							<FORM>
								<INPUT NAME="print" TYPE="button" VALUE="列印此頁"
								ONCLICK="varitext()">	
							</FORM>
						</DIV>							
			</table>	
</div>
<div id="end"><jsp:include page="../end.jsp"></jsp:include></div>
</body>
</html>