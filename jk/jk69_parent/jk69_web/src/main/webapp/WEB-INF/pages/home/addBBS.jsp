<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="homeAction_addBBS" method="post">
	<input type="text" name="content"> 
	<s:select name="user_id" list="userList" listKey="id" listValue="userName" headerKey="" headerValue="" >
	</s:select>
	<input type="submit" value="给别人留言">
</form>
</body>
</html>