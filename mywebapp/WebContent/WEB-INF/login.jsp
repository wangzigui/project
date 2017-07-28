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
		<h3>当前第${count}次登陆</h3>
		<table>
		
		<tr><td colspan="2"> <h2>登陆</h2></td></tr>
		<tr><td>姓名</td><td><input type="text" name ="user" value ="<%=user %>"></td></tr>
		<tr><td>密码</td><td><input type="password" name ="psw" value ="<%=psw %>"></td></tr>
		<tr><td colspan="2"><input type="checkbox" id = "mima" name="mima" > </td></tr>
		<tr><td colspan="2"><input type="button" id= "loginbtn" name="loginbtn" > </td></tr>
		<tr><td colspan="2"><input type="submit" value ="登陆"> </td></tr>
		</table>
	</form>
	
	<script type="text/javascript" src="js/jquery-2.1.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			 var loginbtn = $("#mima").val();
			 loginbtn = "";

			 alert(loginbtn);
			 $("#loginbtn").click( function(){
				 $("#mima").hide();
				 
/* 				 if(loginbtn.checked){
					 loginbtn = "uu";
				 } */
			 });
		});
	</script>
</body>
</html>