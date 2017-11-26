<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background:url(${ctx }/skin/default/images/icon/errorimg.jpg) no-repeat;">
	
	<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
	<ul>
	<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
	
		
	</ul>
	<div style="margin-top: 200px">
		<h1> ${msg}</h1>
	</div>

			
	

</body>
</html>