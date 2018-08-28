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
<title>添加交易记录</title>
<link href="css/common.css" rel="stylesheet">
<link href="css/addTrade.css" rel="stylesheet">
</head>
<center>
	<div id="headTitle">添加交易记录</div>
</center>
<body>
	<div id="homeLink">
		<a href="main.jsp">回到主页</a>
	</div>

	<center>
		<div>
			<form action="AddTradeDetails" method="post">
				<fieldset>
					<ul>
						<li>区服：<select class="mySelect" name="server">
								<option value="一梦十年">一梦十年</option>
								<option value="守望江湖" selected>守望江湖</option>
								<option value="在水一方">在水一方</option>
						</select>
						</li>			
						
						<li>元宝：<input type="text" name="tradeCurrency" class="inputText">
						</li>
						<li>RMB ：<input type="text" name="tradeMoney" class="inputText">
						</li>						
					</ul>
					<input type="submit" value="添加记录" id="submitButton"><br>
					<span><%=message%></span>
				</fieldset>
			</form>

		</div>
	</center>

</body>
</html>