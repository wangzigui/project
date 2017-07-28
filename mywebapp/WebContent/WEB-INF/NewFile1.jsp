<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>my website</h1>

<form action="save.do">
<table border="5px">
	<tr ><td colspan="3">增加用户</td></tr>
	<tr><td>用户名</td><td>地址</td><td>年龄</td></tr>
	<tr>
	<td><input type="text" name="name"></td>
	<td><input type="text" name="address"></td>
	<td><input type="text" name="age"></td>
	</tr>
	<tr><td colspan="3"> <input type="submit" value="提交"/></td></tr>
</table> 
</form>
</body>
</html>