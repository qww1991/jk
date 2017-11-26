<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
<!-- 	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(function()
		{
		
			$("#pwd").blur(function()
			{
				function showTips(pwds,info){
					// 控制后面的span元素
					document.getElementById(uid+"span").innerHTML = 
								"<font color='gray'>"+info+"</font>";
				}
				
				function checkPassword(pwd,info){
					// 判断密码是否为""
					var pvalue = document.getElementById(npwd).value;
					if(pvalue == ""){
						document.getElementById(pwd+"span").innerHTML = 
											"<font color='red'>"+"</font>";
					}else{
						document.getElementById(pwd+"span").innerHTML ="";
					}
				}
				
	        }) 			
		})
</script> -->
</head>

<body>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('userInfoAction_alterPwd','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
<form name="icform" method="post">
      <input type="hidden" name="id" value="${id}"/>

   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改用户密码
  </div> 
  
    <div>
		<table border="0" align="center" width="60%">
			 <tr>
			<td></td>
			<td>
					
				
					
			</td>
			</tr>
			<tr></tr>
			
	        <tr>
	            <td class="columnTitle">用户名：</td>
	            <td class="columnTitle"><font color="blue" size="4"><b>${userName}</b></font></td>
	            <!-- <td></td> -->
	        </tr>	
	        <tr>
	        	<td class="columnTitle">请输入原密码：</td>
	            <td class="tableContent"><input type="password" style="width:350px;" name="password"  value=""/>
	            <span>
	            <font color="red">
	             <c:if test="${!empty pwdnull}">
						${pwdnull}
				</c:if>
	            <c:if test="${!empty olderror}">
						${olderror}
				</c:if>
	            </font>
					</span>
	            </td>
	          	
	
            </tr>
            <tr>
            	<td class="columnTitle">请输入新密码：</td>
	            <td class="tableContent"><input type="password"  style="width:350px;" name="newpassword" value=""/>
	            <span><font color="red"><c:if test="${!empty newpwdone}">
						${newpwdone}
				</c:if></font>
	          
	            </span>
	            </td>
            </tr>
            <tr>
            	<td class="columnTitle">请确认新密码：</td>
	            <td class="tableContent"><input type="password" style="width:350px;" name="newpassword1" value="" />
	            <span>
	             <font color="red">
	              <c:if test="${!empty deferent}">
						${deferent}
					</c:if>
					 <c:if test="${!empty newpwdtwo}">
						${newpwdtwo}
					</c:if>
	             </font>
	            </span>
	            </td>
            </tr>
  
</body>
</html>