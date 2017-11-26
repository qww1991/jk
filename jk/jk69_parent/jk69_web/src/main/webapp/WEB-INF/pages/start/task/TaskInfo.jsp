<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<script type="text/javascript">
		window.onload=function(){
			var answer = document.getElementById("e2");
			
			answer.onclick = function(){
				location.href="${pageContext.request.contextPath}/befor/taskAction_answer?id=${id}";
			}
		}
	</script>
</head>


<body>
<form name="icform" method="post">
	<input type="hidden" name="id" value="${id}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="back"><a href="#" onclick="formSubmit('taskAction_forward','_self');this.blur();">转发</a></li>
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
    [${title }]任务详情


  </div> 
  </div>
  </div>
  
<div>

<div style="height: 490px;width:850px;margin:10px 120px 10px 120px;background-color:#72C6A5;border-radius:80px 30px 60px;;background-repeat: round;" >
	 <div style="margin: 25px 100px 15px 100px;padding-top: 20px">
		<table  class="commonTable" cellspacing="1" >
	        <tr class="taskTr">
	            <td class="columnTitle">主题：</td>
	            <td class="tableContent">${title}</td>
	            <td class="columnTitle">难度：</td>
	            <td class="tableContent">
	            	<c:if test="${difficulty==1}">★★★★</c:if>	<!-- 极难 -->
	            	<c:if test="${difficulty==2}">★★★</c:if>	<!-- 比较难 -->
	            	<c:if test="${difficulty==3}">★★</c:if>	<!-- 有难度 -->
	            	<c:if test="${difficulty==4}">★</c:if>		<!-- 一般 -->
	            </td>
	        </tr>		
	        <tr >
	            <td  class="columnTitle">留言人：</td>
	            <td class="tableContent">${answerBy}</td>
	            <td class="columnTitle">留言人电话：</td>
	            <td class="tableContent">${telephone}</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">接收人：</td>
	            <td class="tableContentAuto">
	            	${inputBy }
	            </td>
	            <td class="columnTitle" >留言时间：</td>
	            <td class="tableContentAuto">
	            	<fmt:formatDate value='${createTime }' pattern='yyyy-MM-dd HH:mm:ss' />
	            </td>
	        </tr>		
		</table>
	</div>
	<div style="margin-top: 30px"><font color="#00544A" size="3"  style="font-family:宋体;margin-left: -520px;margin-top: 20px">任务详细内容:</font></div>
	<div>
		<textarea   style="padding:30px 40px 30px 30px;border-style:none;background-image:url('../images/button.jpg');margin-top:15px;height: 80px;width: 550px" readonly="readonly"  >${content }</textarea>
	</div>
	<div >
			${infoList[0].inputBy} 回复  ${infoList[0].getBy} : ${infoList[0].inputInfo}
			<button id="e2" type="button" style="background-image:url('../images/anniu.jpg') ;margin: 50px 0px 50px 350px " >回复</button>
	</div>
</div>
</div>
 
 
 
</div>
</form>
</body>
</html>