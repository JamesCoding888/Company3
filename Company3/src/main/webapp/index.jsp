<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="st1.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="title"><jsp:include page="title.jsp"></jsp:include></div>
<div id="content">
	<form action="LoginController" method="post">
		<table width="400" align=center>
			<tr>
				<td colspan=2 align=center>
				會員登入
			<tr>
				<td colspan=2 align=center>
				帳號
				<td><input type="text" name="username">
				
			<tr>
				<td colspan=2 align=center>
				密碼
				<td><input type="password" name="password">
			<tr>
				<td colspan=2 align=center>
				<input type="submit" value="ok">	
						
		</table>
	
	</form>

</div>
<div id="end"><jsp:include page="end.jsp"></jsp:include></div>

</body>
</html>