<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String message = "";
	if (request.getAttribute("message") != null) {
		message = (String) request.getAttribute("message");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link href="css/common.css" rel="stylesheet">
<link href="css/addRole.css" rel="stylesheet">
</head>
<center>
	<div id="headTitle">角色管理</div>
</center>
<body>
	<div id="homeLink">
		<a href="main.jsp">回到主页</a>
	</div>

	<center>
		<div>
			<form action="AddRoleDetails" method="post">
				<fieldset>
					<ul>
						<li>区服：<select class="mySelect" name="server">
								<option value="一梦十年">一梦十年</option>
								<option value="守望江湖" selected>守望江湖</option>
								<option value="在水一方">在水一方</option>
						</select>
						</li>
						<li>账号：<select class="mySelect" name="accout">
									<option value="a413978842">a413978842</option>
									<option value="980096722">980096722</option>
									<option value="980000">980000</option>
									<option value="jazz0414">jazz0414</option>
									<option value="jmh2014">jmh2014</option>
									<option value="xu7692182">xu7692182</option>
							</select>
						</li>
						<li>名字：<input type="text" name="roleName" class="inputText">
						</li>
						<li>门派：<select class="mySelect" name="sect">
								<option value="唐门">唐门</option>
								<option value="鬼谷">鬼谷</option>
								<option value="星宿">星宿</option>
								<option value="逍遥">逍遥</option>
								<option value="武当 ">武当</option>
								<option value="天龙">天龙</option>
								<option value="天山">天山</option>
								<option value="慕容">慕容</option>
								<option value="丐帮">丐帮</option>
								<option value="少林">少林</option>
								<option value="峨眉">峨眉</option>
						</select>
						</li>
						<li>等级：<input type="text" name="grade" class="inputText"
							value="50">
						</li>
						<li>顺序：<select class="mySelect" name="order" >
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
						</select>
						</li>
					</ul>
					<input type="submit" value="添加角色" id="submitButton"><br>
					<span><%=message%></span>
				</fieldset>
			</form>

		</div>
	</center>

</body>
</html>