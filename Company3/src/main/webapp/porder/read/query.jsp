<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		<table width=400 align=center border=0>
			<tr>
				<td align=center>
					<h3>查詢訂單</h3>
			<tr>
				<td>
					<hr>
			<tr>
				<td align=center><a href="queryAll.jsp">1)全部</a>
			<tr>
				<td align=center><a href="querySum.jsp">2)金額條件</a>
			<tr>
				<td align=center><a href="../index.jsp">3)回首頁</a>
		</table>

	</div>
<div id="end"><jsp:include page="../../end.jsp"></jsp:include></div>
</body>
</html>