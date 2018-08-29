<%@page import="com.studio.entity.RoleInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	RoleInfo roleInfo = (RoleInfo) request.getAttribute("roleInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体重信息添加</title>
<link href="css/common.css" rel="stylesheet">
<link href="css/addWeightInfo.css" rel="stylesheet">
</head>
<center>
	<div id="headTitle">体重信息添加</div>
</center>
<body>
	<div id="homeLink">
		<a href="main.jsp">回到主页</a>
	</div>
	<center>
		<form action="AddWeightDetails" method="post">
				<div class="weightInfo">
					姓名：<input type="text" name="infoHost" class="inputText"></div>
				<div class="weightInfo">
					食物：<input type="text" name="infoDetails" class="inputText"></div>
				<div class="weightInfo">
					体重：<input type="text" name="infoNum" class="inputText"></div>
				<div class="weightInfo">
					备注：<input type="text" name="infoComment" class="inputText"></div>				
				<input type="submit" value="添加 "><span></span>
		</form>
		</center>


</body>
</html>