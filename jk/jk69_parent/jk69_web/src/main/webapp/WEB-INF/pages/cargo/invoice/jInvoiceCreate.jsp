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
<li id="save"><a href="#" onclick="formSubmit('invoiceAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增发票
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
		
	        <tr>
	            <td class="columnTitle">发票号：</td>
	            <td class="tableContent"><input type="text" name="scNo" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">提单号：</td>
	            <td class="tableContent"><input type="text" name="blNo" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">贸易条款：</td>
	            <td class="tableContent"><input type="text" name="tradeTerms" value=""/></td>
	        </tr>	
		</table>
	</div>
 
 
 	<div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    委托单列表
  </div> 


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">运输</td>
		<td class="tableHeader">货主</td>
		<td class="tableHeader">装期</td>
		<td class="tableHeader">效期</td>
		<td class="tableHeader">是否分批</td>
		<td class="tableHeader">是否转船</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
 
 <c:forEach items="${shippingOrderList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="radio" name="id" value="${o.id}" checked /></td>
		<td>${status.index+1}</td>
		<td>${o.orderType}</td>
		<td>${o.shipper}</td>
		<td>${o.loadingDate}</td>
		<td>${o.limitDate}</td>
		<td>
			<c:if test="${o.isBatch==0 }">否</c:if>
		    <c:if test="${o.isBatch==1 }">是</c:if>
		</td>
		
		<td>
			<c:if test="${o.isTrans==0 }">否</c:if>
		    <c:if test="${o.isTrans==1 }">是</c:if>
		</td>
		<td>
		<input type="hidden" id="state" value="${o.state}" >
		   <c:if test="${o.state==6 }">委托完毕(待出票)</c:if>
		</td>
	</tr>
	</c:forEach>
 
 
 
</form>
</body>
</html>

