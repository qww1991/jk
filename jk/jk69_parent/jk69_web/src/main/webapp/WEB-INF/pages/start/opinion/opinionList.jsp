<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/jquery-1.4.4.js"></script>
	<script>
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
	     function toView(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('opinionAction_toview','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	     function toupdate(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('opinionAction_toupdate','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	     function todelete(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('opinionAction_todelete','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	     //实现更新
	     /* function toUpdate(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('opinionAction_toupdate','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     } */
	</script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="javascript:toView()">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('opinionAction_tocreate','_self');this.blur();">反馈</a></li>
<li id="update"><a href="#" onclick="javascript:toupdate()">已解决</a></li>
<li id="delete"><a href="#" onclick="javascript:todelete()">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
  <img src="${ctx }/skin/default/images/icon/book_open.png"/>
    反馈列表
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
		<td class="tableHeader">收件人</td>
		<!-- <td class="tableHeader">部门</td> -->
		<td class="tableHeader">主题</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
    ${links }
	
	 <c:forEach items="${results }" var="opinion"  varStatus="st">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td><input type="checkbox" name="id" value="${opinion.id }"/></td>
			<td>${st.count}</td>
			<td>${opinion.inputBy }</td>
			<%-- <td>${opinion.createDept }</td> --%>
		
			<td><a href="opinionAction_toview?id=${opinion.id }">${opinion.title}</a></td>
			<td>
			<c:if test="${opinion.state==0 }">未处理</c:if>
		   <c:if test="${opinion.state==1 }">已处理</c:if>
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

