<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.member" %>

<%
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
<div id="title"></div>
<div id="content">
	<h3><%=m.getName() %> ,歡迎您, 登入成功</h3>
	<a href="../porder/index.jsp">進入購物</a>

</div>
<div id="end"></div>

</body>
</html>
