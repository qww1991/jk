<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   浏览财务报运单
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">制单日期：</td>
	            <td class="tableContent">${inputDate}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">制单人：</td>
	            <td class="tableContent">${inputBy}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContent">
				    <c:if test="${o.state==9 }">已进账(未提交)</c:if>
		  			<c:if test="${o.state==10 }">进账完毕</c:if><!-- 状态 -->
	            </td>
	        </tr>	
		</table>
	</div>
 
 
</form>
</body>
</html>

