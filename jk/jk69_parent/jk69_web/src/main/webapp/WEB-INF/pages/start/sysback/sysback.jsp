<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
<!-- 			toModule('home') -->
      <input type="hidden" name="id" value="${id}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('sysbackAction_sendbackmail','_self');this.blur();">发送</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
<%-- 	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/> --%>
	<img width="30" src="${ctx }/skin/default/images/icon/Alert_09.gif"/>
   系统使用反馈
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">反馈给：</td>
	              <td class="tableContent">
	            	<s:select name="userid" list="userList"
 	            		listKey="id" listValue="userName"
 	            		headerKey="" headerValue="--请选择--" 
 	            	></s:select> 
 	            	管理员
	            </td> 
	        </tr>		
	        <tr>
	            <td class="columnTitle">反馈主题：</td>
	            <td class="tableContent"><input type="text" name="subject" value="${subject}" placeholder="     反馈主题"/></td>
	        </tr>	
	        <tr>
	        	<td class="columnTitle">反馈内容：</td>
	            <td class="tableContent"><textarea name="backtext" 
	            	placeholder="   请在此处填写反馈内容，该内容将以邮件形式发送给系统管理员" style="height:250px;"></textarea>
	            
	        </tr>	
	        <tr>
	            <td class="columnTitle">您邮箱地址：</td>
	            <td class="tableContent"><input type="text" name="fromemail" value="${fromemail}" placeholder="  邮箱"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">邮箱密码：</td>
	            <td class="tableContent"><input type="password" name="frompassword"  placeholder="  密码"/></td>
	       </tr>	
	        <tr>
	            <td class="columnTitle"></td>
	            <td class="tableContent"><font color="red" >${msgg}</font></td>
	       </tr>
		</table>
	</div>
 </form>
</body>
</html>