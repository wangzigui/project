<%@page import="dao.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <h3>当前第${count}次登陆</h3>
	<table border="2px">
	<c:forEach var ="user" items="${users}">
	<tr  height="20px" background="green">
	<td>${user.userId}</td>
	<td>${user.name}</td>
	<td>${user.address}</td>
	<td>${user.age}</td>
	<td><a href="delete.do?userId=${user.userId}" onclick="return confirm('是否确认删除${user.name}信息？')">删除</a></td>
	<td><a href="change.do?userId=${user.userId}" >修改</a></td>
	<td><a href="create.do" >新增</a></td>
	</tr>
<%-- 	<%}%> --%>
	</c:forEach>
	</table>
</body>
</html>