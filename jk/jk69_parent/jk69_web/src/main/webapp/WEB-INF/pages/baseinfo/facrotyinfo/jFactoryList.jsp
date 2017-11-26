<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<li id="view"><a href="#" onclick="formSubmit('baseFactoryAction_toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('baseFactoryAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('baseFactoryAction_toupdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('baseFactoryAction_delete','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('baseFactoryAction_printAll','_self');this.blur();">打印</a></li>

</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
  <img src="${ctx }/skin/default/images/icon/info.gif"/>
    购销合同列表
  </div> 
  </div>
  </div>
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家类型</td>
		<td class="tableHeader">厂家全称</td>
		<td class="tableHeader">厂家简称</td>
		<td class="tableHeader">联系人</td>
		<td class="tableHeader">电话</td>
		<td class="tableHeader">手机</td>
		<td class="tableHeader">传真</td>
		<td class="tableHeader">地址</td>
		<td class="tableHeader">验货员(杰信代表)</td>
		<td class="tableHeader">说明 </td>
		<td class="tableHeader">状态</td>		<!-- 状态：1正常0停用(伪删除) -->
		

	</tr>
	</thead>
	<tbody class="tableBody" >
	${links }
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.ctype}</td>
		<td><a href="baseFactoryAction_toview?id=${o.id}">${o.fullName}</a></td>
		<td>
		    ${o.factoryName }
		</td>
		<td>${o.contacts}</td>
		<td>${o.phone}</td>
		<td>${o.mobile}</td>
		<td>${o.fax}</td>
		<td>${o.address}</td>
		<td>${o.inspector}</td>
		<td>${o.remark}</td>
		<td><c:if test="${o.state==0}">停用</c:if>
		<c:if test="${o.state==1}"><font color="green">正常</font></c:if></td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
<form method="post" action="/helloServlet/baseinfo/baseFactoryAction_importFactory" enctype="multipart/form-data">
	<input type="file" name="file">
	<input type="submit" value="upload">
</form>
</body>
</html>

