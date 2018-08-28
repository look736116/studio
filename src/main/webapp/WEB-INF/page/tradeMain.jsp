<%@page import="com.studio.dao.impl.TradeInfoDaoImpl"%>
<%@page import="com.studio.dao.TradeInfoDao"%>
<%@page import="com.studio.entity.TradeInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.studio.util.DataBaseUtils"%>
<%@page import="com.studio.entity.Record"%>
<%@page import="com.studio.server.impl.RoleInfoServerImpl"%>
<%@page import="com.studio.server.RoleInfoServer"%>
<%@page import="com.studio.entity.RoleInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<TradeInfo> trades = null;
	TradeInfo trade = null;
	TradeInfoDao tid = new TradeInfoDaoImpl();
	
	if((List) request.getAttribute("trades")!=null){
		trades =(List) request.getAttribute("trades");
	}else{
		trades =tid.getAllTradeInfo();
	}	
	
	String serverName = "全部区服";
	String currentServer = (String) request.getAttribute("serverName");
	System.out.printf(currentServer+"=====");
	if (currentServer != null && currentServer != "") {
		serverName = currentServer;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易记录</title>

<link href="css/common.css" rel="stylesheet">
<link href="css/tradeMain.css" rel="stylesheet">
<script src="//libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script src="js/tradeMain.js"></script>
</head>
<center>
	<div id="headTitle">交易记录</div>
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
		<a href="/myWeb/AddTrade"><input type="button" value="添加记录"></a>	<a href="main.jsp"><input type="button" value="返回主页"></a>
		</div>
	</center>
	<center>
		<table border="1">
			<thead>
				<tr>
					<th>序号</th>
					<th>区服</th>
					<th>元宝</th>
					<th>RMB</th>
					<th>时间</th>
					<td>备注</td>

				</tr>
			</thead>
			<%
				if (trades != null) {
					for (int i = 0; i < trades.size(); i++) {
						TradeInfo tradeInfo = trades.get(i);
						
			%>
			<tbody>
				<tr>
					<td><%=i + 1%></td>
					<td><%=tradeInfo.getTradeServer() %></td>
					<td><%=tradeInfo.getTradeCurrency() %></td>
					<td><%=tradeInfo.getTradeMoney() %></td>
					<td><%=tradeInfo.getTradeTime() %></td>
					<td></td>					

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