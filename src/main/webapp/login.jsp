<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>
<center>
	<div id ="login">
	 <span id="pageHeader"></span>
	 <center>
		 <div id ="form">
			 <form action="Login"> 
			 <br/>
			 <center> <span id="title">欢迎光临</span></center> <br/><br/>
			 <span>账号：</span><input type="text" id="userName" name ="userName" class="myText"><br/><br/>
			 <span>密码：</span><input type="password" id="password" name = "password"class="myText"><br/><br/>
			 <center><input type="submit" value="登陆" id="submitButton" class ="myButton"></center>
			 </form>
		 </div>
	 </center>
	</div>
</center>

</body>
</html>