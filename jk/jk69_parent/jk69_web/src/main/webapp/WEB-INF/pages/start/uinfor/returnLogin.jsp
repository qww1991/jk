<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp" %>
<meta http-equiv="refresh" content="3;URL=${ctx }/login">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="border-style: dotted solid;border-radius:20px;width:450px;height: 260px;margin: 50px 150px 250px 350px ">
		<div style="height: 100px"></div>
		<font style="font-family: 华文细黑;margin-top: 100px">修改成功,3s后自动跳转到登陆页面,请稍等...</font>
	</div>
	<div id="shownum">3</div>
	<script type="text/javascript">
		runCount(10);
		function runCount(t){
		  if(t>0){
		    document.getElementById('shownum').innerHTML = t;
		    t--;
		    setTimeout(function(){runCount(t);},1000);
		  }else{
		    document.getElementById('shownum').innerHTML = '倒计时结束！';
		  }
		}
	</script>
</body>
</html>