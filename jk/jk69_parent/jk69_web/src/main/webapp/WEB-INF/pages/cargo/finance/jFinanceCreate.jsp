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
<li id="save"><a href="#" onclick="formSubmit('financeAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增财务报运单
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">制单人：</td>
	            <td class="tableContent"><input type="text" name="inputBy" value=""/></td>
	        </tr>	
		</table>
	</div>
 
 
 	<div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    发票列表
  </div> 


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">发票号</td>
		<td class="tableHeader">提单号</td>
		<td class="tableHeader">贸易条款</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
 
	 <c:forEach items="${invoiceList}" var="o" varStatus="status">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td><input type="radio" name="id" value="${o.id}" checked /></td>
			<td>${status.index+1}</td>
			<td>${o.scNo}</td>			<!-- 发票号 -->
			<td>${o.blNo}</td>			<!-- 提单号 -->
			<td>${o.tradeTerms}</td>	<!--贸易条款  -->
			<td>
			   <c:if test="${o.state==8 }">出票成功(待进账)</c:if>
			</td>
		</tr>
	</c:forEach>
 
</form>
</body>
</html>

