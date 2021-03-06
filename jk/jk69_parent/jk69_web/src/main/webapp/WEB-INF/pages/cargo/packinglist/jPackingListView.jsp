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
   浏览装箱单
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        
	        <tr>
	            <td class="columnTitle">卖方：</td>
	            <td class="tableContent">${seller}</td>
	       
	            <td class="columnTitle">买方：</td>
	            <td class="tableContent">${buyer}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">发票号：</td>
	            <td class="tableContent">${invoiceNo}</td>
	       
	            <td class="columnTitle">发票日期：</td>
	            <td class="tableContent">${invoiceDate}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">唛头：</td>
	            <td class="tableContent">${marks}</td>
	       
	            <td class="columnTitle">描述：</td>
	            <td class="tableContent">${descriptions}</td>
	        </tr>	
	       
	        <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContent">
		       <c:if test="${state==3}">已装箱(未提交)</c:if>
			   <c:if test="${state==4}">装箱完毕(待委托)</c:if>
			   <c:if test="${state==5}">已委托(未提交)</c:if>
			   <c:if test="${state==6}">委托完毕(待出票)</c:if>
			   <c:if test="${state==7}">已出票(未提交)</c:if>
			   <c:if test="${state==8}">出票成功(待进账)</c:if>
			   <c:if test="${state==9}">已进账(未提交)</c:if>
			   <c:if test="${state==10}">进账完毕</c:if>
			    </td>
	        </tr>	
	      
		</table>
	</div>
 
 
</form>
</body>
</html>

