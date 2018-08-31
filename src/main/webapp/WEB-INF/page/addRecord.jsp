<%@page import="com.studio.entity.RoleInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	RoleInfo roleInfo = (RoleInfo) request.getAttribute("roleInfo");
	String roleServer = (String)request.getAttribute("roleServer");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打图信息更新</title>
<link href="css/common.css" rel="stylesheet">
<link href="css/addRecord.css" rel="stylesheet">
</head>
<center>
	<div id="headTitle">打图信息更新</div>
</center>
<body>
	<div id="homeLink">
		<a href="main.jsp">回到主页</a>
	</div>
	<center>
		<form action="AddRecordDetails?roleServer=<%=roleServer %>" method="post">
		<input type="hidden" name="roleId" value="<%=roleInfo.getRole_id() %>">			
				<div class="roleInfo">
					区服：<%=roleInfo.getRole_server()%></div>
				<div class="roleInfo">
					账号：<%=roleInfo.getRole_account().replace("@changyou.com", "") %></div>
				<div class="roleInfo">
					名字：<%=roleInfo.getRole_name()%></div>
				<div class="roleInfo">
					门派：<%=roleInfo.getRole_sect()%></div>
				<div class="roleInfo">
					等级：<%=roleInfo.getRole_grade()%></div>
				<div class="roleInfo">
					环数：<input type="text" name="taskNum" id="inputNum">
				</div>
				<input type="submit" value="更新 "><span></span>
		</form>
		</center>


</body>
</html>