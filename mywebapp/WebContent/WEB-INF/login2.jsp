<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <%
    	Cookie[] cookies = request.getCookies();
        String user = null;
        String psw  = null;
    	if(null != cookies)
    	{
    		for(Cookie c :cookies){
    			if("user".equals(c.getName()))
    			{
    				user = c.getValue();
    			}
    			if("password".equals(c.getName()))
    			{
    				psw = c.getValue();
    			}
    		}
    	}
    %>
	<form action="login.do">
		<table>
		<tr><td>姓名</td><td><input type="text" name ="user" value ="<%=user %>"></td></tr>
		<tr><td>密码</td><td><input type="password" name ="psw" value ="<%=psw %>"></td></tr>
		<tr><td></td></tr>
		</table>
	</form>
</body>
</html>