<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
      <input type="hidden" name="id" value="${id}"/>
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
	<img src="${ctx }/skin/default/images/icon/info.gif"/>
   浏览厂家信息
  </div> 
  
	

 
    <div>
		<table class="commonTable" cellspacing="1">
	         <tr>
	            <td class="columnTitle">厂家类型：</td>
	            <td class="tableContent">${ctype }</td>
	            <td class="columnTitle">厂家全称：</td>
	            <td class="tableContent">${fullName }</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">厂家简称：</td>
	            <td class="tableContent">${factoryName }</td>
	            <td class="columnTitle">联系人：</td>
	            <td class="tableContent">${contacts }</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">电话：</td>
	            <td class="tableContent">${phone }</td>
	            <td class="columnTitle">手机：</td>
	            <td class="tableContent">${mobile }</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">传真：</td>
	            <td class="tableContent">${fax }</td>
	            <td class="columnTitle">地址：</td>
	            <td class="tableContent">${address }</td>
	        </tr>		
			 <tr>
	            <td class="columnTitle">验货员：</td>
	            <td class="tableContent">${inspector }</td>
	            <td class="columnTitle">说明：</td>
	            <td class="tableContent">${remark }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	            	${state==1?"正常":"停用" } 
	            </td>
	            <td> </td>
	            <td> </td>
	        </tr>		
	        <tr>
		</table>
	</div>
 </form>
 
	
</body>
</html>