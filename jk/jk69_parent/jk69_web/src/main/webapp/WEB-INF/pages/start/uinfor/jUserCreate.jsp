<%@page import="cn.itcast.jk.domain.UserInfo"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
 <script>
            var f1=function(){
            	  alert("保存成功！");
            };
 </script>
 
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<!--  -->
<li id="save"><a href="#" onclick="formSubmit('userInfoAction_update','_self');this.blur();f1();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
<li id="deploy"><a href="#" onclick="formSubmit('userInfoAction_updatep','_self');">修改密码</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
   修改用户
  </div> 
  </div>
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
        	<tr>
	            <td class="columnTitle">登录名：</td>
	            <td class="tableContent" ><input type="text" name="userName" readonly="readonly" value="${userName}"/></td>
	            <td class="columnTitle">所在部门：</td>
	            <td class="tableContent" >
	            	<s:select name="dept.id" list="deptList" 
	            		listKey="id" listValue="deptName"
	            		headerKey="" headerValue=""  disabled="true"
	            	></s:select>
	            </td>
<!-- 	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="state" value="1" checked class="input"/>启用
	            	<input type="radio" name="state" value="0" class="input"/>停用
	            </td> -->
	        </tr>
        	<tr>
	            <td class="columnTitle">真实姓名：</td>
	            <td class="tableContent"><input type="text" name="userinfo.name"  readonly="readonly"  value="${name }"/></td>
	         
	       
	            <td class="columnTitle">入职时间：</td>
	             <td class="tableContent"  readonly="readonly" >
					<input type="text" readonly="readonly" style="width:90px;" name="userinfo.joinDate"
	            	 value="<fmt:formatDate value='${userinfo.joinDate }' pattern='yyyy-MM-dd' />"
	             	/>
				<!-- onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" -->
				</td> 
			</tr>		
	        <tr>
				<td class="columnTitle">薪水：</td>
	            <td class="tableContent"><input readonly="readonly" type="text" name="userinfo.salary" value="${salary }"/></td>
	        

				<td class="columnTitle">性别：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="userinfo.gender" value="1" class="input" ${userinfo.gender==1?'checked':'' }/>男
	            	<input type="radio" name="userinfo.gender" value="0" class="input" ${userinfo.gender==0?'checked':'' }/>女
	            </td>
	        </tr>	
        	<tr>
	            <td class="columnTitle">岗位：</td>
	            <td class="tableContent"><input type="text" name="userinfo.station" value="${station}"/></td>
	            <td class="columnTitle">电话：</td>
	            <td class="tableContent"><input type="text" name="userinfo.telephone" value="${telephone}"/></td>
	        </tr>	
        	<tr>
        	    <td class="columnTitle">邮箱：</td>
	            <td class="tableContent"><input type="text" name="userinfo.email" value="${email }"/></td>
	            <td class="columnTitle">出生年月：</td>
	             <td class="tableContent">
					<input type="text" readonly="readonly" style="width:90px;" name="userinfo.birthday"
	            	 value="<fmt:formatDate value='${userinfo.birthday }' pattern='yyyy-MM-dd' />"
	             	"/>
	             	<!-- onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'}); -->
				</td> 
	        </tr>	
        	
	 
		</table>
		<div align="left" style="padding-left: 18px">
		<tr >
	            <td ><font color="blue">说明：</font></td>
	            <td style="padding-left: 30px">
	            	<textarea name="userinfo.remark" style="height: 50px;width:495px" >${remark}</textarea>
	            </td>
	        </tr>
		
		</div>
		
	        
	</div>
 
 
</form>
</body>
</html>

