<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js""></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('baseFactoryAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
   新增厂家信息
  </div> 
  </div>
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
<!-- 	            <td class="columnTitle">厂家类型：</td> -->
<!-- 	            <td class="tableContent"><input type="text" name="ctype" value=""/></td> -->
				<td class="columnTitle">厂家类型：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="ctype" value="货物" checked class="input">货物
	            	<input type="radio" name="ctype" value="附件" class="input">附件
	            </td>
	            <td class="columnTitle">厂家全称：</td>
	            <td class="tableContent"><input type="text" name="fullName" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">厂家简称：</td>
	            <td class="tableContent"><input type="text" name="factoryName" value=""/></td>
	            <td class="columnTitle">联系人：</td>
	            <td class="tableContent"><input type="text" name="contacts" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">电话：</td>
	            <td class="tableContent"><input type="text" name="phone" value=""/></td>
	            <td class="columnTitle">手机：</td>
	            <td class="tableContent"><input type="text" name="mobile" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">传真：</td>
	            <td class="tableContent"><input type="text" name="fax" value=""/></td>
	            <td class="columnTitle">地址：</td>
	            <td class="tableContent"><input type="text" name="address" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">验货员：</td>
	            <td class="tableContent"><input type="text" name="inspector" value=""/></td>
	            <td class="columnTitle">说明：</td>
	            <td class="tableContent"><input type="text" name="remark" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="state" value="1" checked class="input">正常
	            	<input type="radio" name="state" value="0" class="input">停用
	            </td>
	        </tr>		
		</table>
	</div>
 
 
</form>
</body>
</html>

