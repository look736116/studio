<%@page import="com.studio.server.impl.WeightInfoServerImpl"%>
<%@page import="com.studio.server.WeightInfoServer"%>
<%@page import="com.studio.entity.WeightInfo"%>
<%@page import="com.studio.dao.impl.TradeInfoDaoImpl"%>
<%@page import="com.studio.dao.TradeInfoDao"%>
<%@page import="com.studio.entity.TradeInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.studio.server.impl.RoleInfoServerImpl"%>
<%@page import="com.studio.server.RoleInfoServer"%>
<%@page import="com.studio.entity.RoleInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	WeightInfo weightInfo = null;
	List<WeightInfo> infos = new ArrayList<WeightInfo>();
	WeightInfoServer wis = new WeightInfoServerImpl();

	infos = wis.getAllWeightInfo();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体重记录</title>

<link href="css/common.css" rel="stylesheet">
<link href="css/weightMain.css" rel="stylesheet">
<script src="//libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script src="js/weightMain.js"></script>
</head>
<center>
	<div id="headTitle">体重记录</div>
</center>
<body>
	<center>
		<div id="homeLink" class="homeLink">
			<a href="/myWeb/AddWeight">添加记录</a>
			<a href="main.jsp">返回主页</a>
		</div>
	</center>
	<center>
		<table border="1">
			<thead>
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>时间</th>
					<th>食物</th>
					<th>体重</th>
					<td>备注</td>

				</tr>
			</thead>
			<%
				if (infos != null) {
					for (int i = 0; i < infos.size(); i++) {
						weightInfo = infos.get(i);
			%>
			<tbody>
				<tr>
					<td><%=i + 1%></td>
					<td><%=weightInfo.getInfoHost() %></td>
					<td><%=weightInfo.getInfoTime() %></td>
					<td><%=weightInfo.getInfoDetails() %></td>
					<td><%=weightInfo.getInfoNum() %></td>
					<td><%=weightInfo.getInfoComment() %></td>

				</tr>
			</tbody>
			<%
				}
				}
			%>
		</table>
	</center>

</body>
</html>