<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<table width=400 align=center border=0>
			<tr>
				<td align=center><a href="addPorder.jsp">1)新增訂單</a>
			<tr>
				<td align=center><a href="read/query.jsp">2)查詢訂單</a>
			<tr>
				<td align=center><a href="update.jsp">3)修改訂單</a>
			<tr>
				<td align=center><a href="delete.jsp">4)刪除訂單</a>
		</table>


	</div>
<div id="end"><jsp:include page="../end.jsp"></jsp:include></div>

</body>
</html>