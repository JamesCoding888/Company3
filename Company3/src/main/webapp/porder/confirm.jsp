<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "Model.porder" %>
<%@ page import="Model.member" %>

<%
	request.setCharacterEncoding("UTF-8");
	String Desk = request.getParameter("desk");
	int A = Integer.parseInt(request.getParameter("A"));
	int B = Integer.parseInt(request.getParameter("B"));
	int C = Integer.parseInt(request.getParameter("C"));
	
	porder p = new porder(Desk, A, B, C);
	session.setAttribute("P", p);
	member m = (member)session.getAttribute("M");

%>

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
						<h3><%=m.getName() %>這是你的訂單細目</h3>
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
						<a href="../addOrderController">確定</a>
						<a href="addPorder.jsp">上一頁</a>
				</table>


</div>
<div id="end"><jsp:include page="../end.jsp"></jsp:include></div>
</body>
</html>