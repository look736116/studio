<%@page import="com.studio.util.Utils"%>
<%@page import="com.studio.entity.RecordInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.studio.server.impl.RoleInfoServerImpl"%>
<%@page import="com.studio.server.RoleInfoServer"%>
<%@page import="com.studio.entity.RoleInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<RoleInfo> roles = null;
	RecordInfo record = null;
	RoleInfoServer ris = new RoleInfoServerImpl();
	roles = (List) request.getAttribute("roles");
	String dateStr = (String) request.getAttribute("dateStr");
	
	String serverName = "全部区服";
	String currentServer = (String) request.getAttribute("serverName");
	if (currentServer != null && currentServer != "") {
		serverName = currentServer;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打图监控</title>

<link href="css/common.css" rel="stylesheet">
<link href="css/findMap.css" rel="stylesheet">
<script src="//libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script src="js/findMap.js"></script>
</head>
<center>
	<div id="headTitle">打图监控</div>
</center>
<body>
	<center>
		<input type="hidden" id="currentServer" value="<%=serverName%>">
		<div id="choiceServer">
			区服选择:&nbsp;&nbsp;<select class="mySelect" name="server" id="mySelect">
				<option value="全部区服" selected >全部区服</option>
				<option value="一梦十年">一梦十年</option>
				<option value="守望江湖">守望江湖</option>
				<option value="在水一方">在水一方</option>
			</select>
		</div>

		<div id="homeLink" class="homeLink">

			<%=dateStr%>&nbsp;&nbsp;<a href="main.jsp">回到主页</a>
		</div>
	</center>
	<center>
		<table border="1">
			<thead>
				<tr>
					<th>序号</th>
					<th>账号</th>					
					<th>门派</th>
					<th>等级</th>
					<th>区服</th>
					<th>角色</th>
					<th>环数</th>
					<th>更新</th>

				</tr>
			</thead>
			<%
				if (roles != null) {
					for (int i = 0; i < roles.size(); i++) {
						String taskNum = "0";
						RoleInfo role = roles.get(i);
						String roleId = role.getRole_id();
						record = ris.getRecordByRoleId(roleId);
						if (record != null) {
							String recordDay = record.getRecordTime().substring(0, 11);
							String currentDay = Utils.getCurrentTime().substring(0, 11);
							if (recordDay.equals(currentDay)) {
								taskNum = record.getRecordNum();
							}
						}
			%>
			<tbody>
				<tr>
					<td><%=i + 1%></td>
					<td><%=role.getRole_account().replace("@changyou.com", "")%></td>
					<td><%=role.getRole_sect()%></td>
					<td><%=role.getRole_grade()%></td>
					<td><%=role.getRole_server()%></td>
					<td><%=role.getRole_name()%></td>					
					<td><%=taskNum%></td>
					<td><input type="button" id="updateButton"
						onclick="location='AddRecord?roleId=<%=role.getRole_id()%>'"
						value='更新'></td>

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