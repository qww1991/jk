<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>
<script type="text/javascript">


	function isOnlyChecked() {
		var checkBoxArray = document.getElementsByName('id');
		var count = 0;
		for (var index = 0; index < checkBoxArray.length; index++) {
			if (checkBoxArray[index].checked) {
				count++;
			}
		}
		//jquery
		//var count = $("[input name='id']:checked").size();
		if (count == 1)
			return true;
		else
			return false;
	}

	//实现更新
	function toFinanceAction(parm) {
		if (isOnlyChecked()) {

			formSubmit(parm, '_self');

		} else {
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
<li id="view"><a href="#" onclick="formSubmit('financeAction_toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('financeAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="toFinanceAction('financeAction_toupdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('financeAction_delete','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="toFinanceAction('financeAction_submit','_self');this.blur();">提交</a></li>
<li id="new"><a href="#" onclick="toFinanceAction('financeAction_cancel','_self');this.blur();">取消</a></li>

</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    财务报运列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">制单日期</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.inputDate}</td>
		<td>${o.inputBy}</td>
		<td>
		   <c:if test="${o.state==9 }">已进账(未提交)</c:if>
		   <c:if test="${o.state==10 }">进账完毕</c:if><!-- 状态 -->
		   <c:if test="${o.state > 8 }" >
			<input type="hidden" id="state" value="${o.state}" >
		   </c:if>
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

