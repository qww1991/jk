<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
</head>


<body>
<form name="icform" method="post">

<!-- <div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('roleAction_toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('roleAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('roleAction_toupdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('roleAction_delete','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('roleAction_tomodule','_self');this.blur();" title="分配权限">权限</a></li>
</ul>
  </div>
</div>
</div>
</div> -->
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    <img src="${ctx }/skin/default/images/icon/book_open.png"/>
    任务列表
  </div> 
  </div>
  </div>
  
<div>


<div style="margin: 10px 200px 10px 200px">
${links }
<c:forEach items="${results}" var="o" varStatus="status">
<div style="border-style: solid;border-radius:20px 40px 60px;background-image: url('../images/button.jpg');background-repeat: round;"  onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >


<table  >
	
		
			<tr class="task" >
					<td><input type="hidden" name="id" value="${o.id }"/></td>
			</tr>
			<tr>
				<td >留言日期:<fmt:formatDate value='${o.createTime }' pattern='yyyy-MM-dd' /></td>
			</tr>
			<tr>
				<td style="padding-left: 240px"><a href="${pageContext.request.contextPath}/befor/taskAction_infoList?id=${o.id }" >留言主题:${o.title }</a></td>
			</tr>
			<tr>
				<td style="padding-left: 450px">留言人:${o.answerBy }</td>
			</tr>
		
	
	
	<!-- </tbody> -->
	
</table>


</div>
<div style="height: 20px"></div>
</c:forEach>

</div>

 
 
 
</form>
</body>
</html>