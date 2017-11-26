<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp"%>
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
<li id="view"><a href="#" onclick="formSubmit('baseProductAction_toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('baseProductAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('baseProductAction_toupdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('baseProductAction_delete','_self');this.blur();">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    部门列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">编号</td>
		<td class="tableHeader">商品编号</td>
		<td class="tableHeader">图片</td>
		<td class="tableHeader">描述</td>
		<td class="tableHeader">生产厂</td>
		<td class="tableHeader">市场价</td>
		<td class="tableHeader">颜色</td>
		<td class="tableHeader">包装</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">体积</td>
		<td class="tableHeader">备注</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
	<%-- 	<td><input type="checkbox" name="id" value="${o.id}"/></td> --%>
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<%-- <td><a href="productAction_toview?id=${o.id}">${o.deptName}</a></td> --%>
 		<td>${o.productNo}</td>
		<td><img width="40" src="${pageContext.request.contextPath}/images/${o.productImage}"></td> 
		<td>${o.description}</td>
		<td>${o.factoryName}</td>
		<td>${o.price}</td>
		<td>${o.color}</td>
		<td>${o.packing}</td>
		<td>${o.packingUnit}</td>
		<td>${o.qty}</td>
		<td>${o.cbm}</td>
		<td>${o.remark}</td>

	
	

	
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>