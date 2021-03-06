<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js""></script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('shippingOrderAction_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改委托单
  </div> 
  
 
    <div>
		<table class="commonTable" cellspacing="1">
			
		
	        <tr>
	            <td class="columnTitle">运输方式：</td>
	            <td class="tableContent"><input type="text" name="orderType" value="${orderType}"/></td>
	            
	            <td class="columnTitle">货主：</td>
	            <td class="tableContent"><input type="text" name="shipper" value="${shipper}"/></td>
	        </tr>
	        	
	        <tr>
	            <td class="columnTitle">提单抬头：</td>
	            <td class="tableContent"><input type="text" name="consignee" value="${consignee}"/></td>
	            
	            <td class="columnTitle">正本通知人：</td>
	            <td class="tableContent"><input type="text" name="notifyParty" value="${notifyParty}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">信用证：</td>
	            <td class="tableContent"><input type="text" name="lcNo" value="${lcNo}"/></td>
	            
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent"><input type="text" name="portOfLoading" value="${portOfLoading}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">转船港：</td>
	            <td class="tableContent"><input type="text" name="portOfTrans" value="${portOfTrans}"/></td>
	            
	            <td class="columnTitle">卸货港：</td>
	            <td class="tableContent"><input type="text" name="portOfDischarge" value="${portOfDischarge}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">装期：</td>
	            <td class="tableContent">
		             <input type="text" style="width:200px;" name="loadingDate"
		            	 value="<fmt:formatDate value="${loadingDate}" pattern="yyyy-MM-dd"/>"
		             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	            
	            </td>
	            
	            <td class="columnTitle">效期：</td>
	            <td class="tableContent">
	            	 <input type="text" style="width:200px;" name="limitDate"
		            	 value="<fmt:formatDate value="${limitDate}" pattern="yyyy-MM-dd"/>"
		             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	        </tr>	
	        
	        <tr>
	            <td class="columnTitle">是否分批：</td>
	            <td class="">
	            	<c:if test="${isBatch == '1'}">
	            		<input name="isBatch" type="radio" value="1" checked />是
	            		<input name="isBatch" type="radio" value="0" />否
	            	</c:if>
	            	<c:if test="${isBatch == '0'}">
	            		<input name="isBatch" type="radio" value="1" />是
	            		<input name="isBatch" type="radio" value="0" checked />否
	            	</c:if>
	            </td>
	            
	            <td class="columnTitle">是否转船：</td>
	            <td class="">
	            	<c:if test="${isTrans == '1'}">
	            		<input name="isTrans" type="radio" value="1" checked />是
	            		<input name="isTrans" type="radio" value="0" />否
	            	</c:if>
	            	<c:if test="${isTrans == '0'}">
	            		<input name="isTrans" type="radio" value="1" />是
	            		<input name="isTrans" type="radio" value="0" checked />否
	            	</c:if>
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">份数：</td>
	            <td class="tableContent"><input type="text" name="copyNum" value="${copyNum}"/></td>
	            
	            <td class="columnTitle">扼要说明：</td>
	            <td class="tableContent"><input type="text" name="remark" value="${remark}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">运输要求：</td>
	            <td class="tableContent"><input type="text" name="specialCondition" value="${specialCondition}"/></td>
	            
	            <td class="columnTitle">运费说明：</td>
	            <td class="tableContent"><input type="text" name="freight" value="${freight}"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">复核人：</td>
	            <td class="tableContent"><input type="text" name="checkBy" value="${checkBy}"/></td>
	            
	        </tr>	
		</table>
	</div>
 
 
</form>
</body>
</html>

