<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script src="../components/jquery-ui/jquery-1.2.6.js" type="text/javascript"></script>
	
</head>
<script type="text/javascript">

		function isOnlyChecked(){
			 var checkBoxArray = document.getElementsByName('id');
				var count=0;
				for(var index=0; index<checkBoxArray.length; index++) {
					if (checkBoxArray[index].checked) {
						count++;
					}	
				}
			//jquery
			//var count = $("[input name='id']:checked").size();
			if(count==1)
				return true;
			else
				return false;
		}
		
		//实现更新
	    function toExportAction(parm){
	    	 if(isOnlyChecked()){
	    		 
	    		 formSubmit(parm,'_self');
	    		 
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
		
		
</script>
<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('exportAction_toview','_self');this.blur();">查看</a></li>
<li id="update"><a href="#" onclick="toExportAction('exportAction_toupdate','_self')">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('exportAction_delete','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="toExportAction('exportAction_submit','_self');this.blur();">提交</a></li>
<li id="new"><a href="#" onclick="toExportAction('exportAction_cancel','_self');this.blur();">取消</a></li>
<li id="work_assign"><a href="#" onclick="toExportAction('exportAction_exportE','_self');this.blur();">电子报运</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    出口报运列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">报运号</td>
		<td class="tableHeader">货物数/附件数</td>
		<td class="tableHeader">信用证号</td>
		<td class="tableHeader">收货人及地址</td>
		<td class="tableHeader">装运港</td>
		<td class="tableHeader">目的港</td>
		<td class="tableHeader">运输方式</td>
		<td class="tableHeader">价格条件</td>
		<td class="tableHeader">制单日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.id}</td>
		<td align="center">
			${o.exportProducts.size()}
			/
			<c:set var="extNumber" value="0"></c:set><!-- 设置一个变量，用来累加，初始值0 -->
			<c:forEach items="${o.exportProducts}" var="ep">
			   <c:if test="${ep.extEproducts.size()!=0 }">
					<c:set var="extNumber" value="${extNumber + ep.extEproducts.size()}"/>
				</c:if>
			</c:forEach>
			${extNumber}
		</td>		
		<td>${o.lcno}</td>
		<td>${o.consignee}</td>
		<td>${o.shipmentPort}</td>
		<td>${o.destinationPort}</td>
		<td>${o.transportMode}</td>
		<td>${o.priceCondition}</td>
		<td><fmt:formatDate value="${o.inputDate }" pattern="yyyy-MM-dd"/></td>
		
		<td >
		   <c:if test="${o.state==0 }">草稿</c:if>
		   <c:if test="${o.state==1 }">已上报(未报运)</c:if>
		   <c:if test="${o.state==2 }">已报运(待装箱)</c:if>
		   <c:if test="${o.state==3 }">已装箱(未提交)</c:if>
		   <c:if test="${o.state==4 }">装箱完毕(待委托)</c:if>
		   <c:if test="${o.state==5 }">已委托(未提交)</c:if>
		   <c:if test="${o.state==6 }">委托完毕(待出票)</c:if>
		   <c:if test="${o.state==7 }">已出票(未提交)</c:if>
		   <c:if test="${o.state==8 }">出票成功(待进账)</c:if>
		   <c:if test="${o.state==9 }">已进账(未提交)</c:if>
		   <c:if test="${o.state==10 }">进账完毕</c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

