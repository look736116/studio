<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
</head>
<body>
<form action="CallWeb" method="post">
<fieldset>
	  <legend>个人信息:</legend>
	班级：<input list="browsers" name="stuClass">
	<datalist id="browsers">
	 	<option value="一一班">
	 	<option value="一二班">
	 	<option value="二一班">
	 	<option value="二二班">
	 	<option value="三一班">
	</datalist><br/><br/>
	用户名：<input type="text" name="stuName" id="stuName" value="请输入用户名"><br/><br/>
	密码：<input type="password" name="stuPassword" id="stuPassword"><br/><br/>
	<!-- label 当点击字时单选框也会被选上 -->
	性别：<input type="radio" name="sex" value="女" id="male"><label for="male">女</label>
		<input type="radio" name="sex" value="男" id="female"> <label for="female">男</label>
		<input type="radio" name="sex" value="保密" id="unknow" checked="checked"><label for="unknow">保密</label><br/><br/>
</fieldset>
<fieldset>
		  <legend>其他信息:</legend>
	兴趣爱好：<input type="checkbox" name="love" value="足球 ">足球
		  <input type="checkbox" name="love" value="篮球 ">篮球
		  <input type="checkbox" name="love" value="排球 ">排球<br/><br/>
	地址：	<select name="address"> 
	  			<optgroup label="河南省"> 
	    			<option value="RuZhou">汝州</option> 
	    			<option value="ZhengZhou">郑州</option> 
	  			</optgroup> 
	  			<optgroup label="陕西省"> 
	    			<option value="XiAn">西安</option> 
	    			<option value="WeiNan">渭南</option> 
	  			</optgroup> 
		</select>
</fieldset>
<input type="submit" value="提交">
</form>

</body>
</html>