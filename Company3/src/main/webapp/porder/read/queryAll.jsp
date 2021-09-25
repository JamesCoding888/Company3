<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.porder" %>
<%@ page import="Model.member" %>
<%@ page import="Dao.porderDao" %>
<%@ page import="java.util.List" %>
<%
	List l = new porderDao().queryAll();
	porder[] p = (porder[])l.toArray(new porder[l.size()]);
%>
<%
	member m = (member)session.getAttribute("M");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../st2.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="title"><jsp:include page="../../title.jsp"></jsp:include></div>
<div id="content">

		<table width=600 align=center boarder=1>
			<tr>
				<td colspan=6 align=center>
					<h3><%=m.getName() %>所有訂單資料</h3>
			<tr>
				<td colspan=6>
					<hr>
			<tr>
				<td width=100>ID
				<td width=100>桌號
				<td width=100>A
				<td width=100>B
				<td width=100>C
				<td width=100>sum
			<tr>
				<td colspan=6>
					<hr>
			<tr>
				<td colspan=6><!--  全部內容  --> 
				<hr>
				<%=new porderDao().queryAllShow()%>
			<tr>
				<td colspan=6>
					<hr>
			<tr>
				<td colspan=6 align=center>
				<a href="query.jsp">上一頁</a>
				<a href="../../logoutController">登出</a>
		</table>

	</div>
<div id="end"><jsp:include page="../../end.jsp"></jsp:include></div>
</body>
</html>