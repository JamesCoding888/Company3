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
<div id="title"></div>
<div id="content">
	<form action="../addMembercController" method="post">
		<table width=500 align=center>
			<tr>
				<td colspan=2 align=center>
				<h3>會員註冊</h3>
			<tr>
				<td>姓名
				<td><input type="text" name="name">
			<tr>
				<td>帳號
				<td><input type="text" name="username">
			<tr>
				<td>密碼
				<td><input type="text" name="password">
			<tr>
				<td>地址
				<td><input type="text" name="address">
			<tr>
				<td>電話
				<td><input type="text" name="phone">
			<tr>
				<td>行動
				<td><input type="text" name="mobile">
			<tr>
				<td colspan=2 align=center>
				<input type="submit" value="ok">
					
		</table>
	</form>
</div>
<div id="end"></div>

</body>
</html>