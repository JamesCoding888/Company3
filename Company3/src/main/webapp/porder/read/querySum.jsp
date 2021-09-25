<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "Dao.porderDao" %>
<%
	String start = request.getParameter("start");
	String end = request.getParameter("end");
	String show;
	if(start != null && start != "" && end!= null && end != ""){
		int s = Integer.parseInt(start);
		int e = Integer.parseInt(end);
		show = porderDao.querySum2(s, e);
	} else{
		show = porderDao.queryAllShow();
	}
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
					<h3>查詢金額訂單資料</h3>
					<form action="querySum.jsp" method="post">
						<table width=400 align=center>
							<tr>
								<td>輸入查詢金額: 從<input type="text" name="start" size=5>
									到<input type="text" name="end" size=5> <input
									type="submit" value="確定">
						</table>
					</form>
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
				<%=show %>
			<tr>
				<td colspan=6>
					<hr>
			<tr>
				<td colspan=6 align=center><a href="query.jsp">上一頁</a>
		</table>

	</div>
<div id="end"><jsp:include page="../../end.jsp"></jsp:include></div>
</body>
</html>