<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>

<form name="icform" method="post">
<!-- 			toModule('home') -->
      <input type="hidden" name="id" value="${id}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('taskAction_save','_self');this.blur();">回复</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
<%-- 	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/> --%>
	<img width="30" src="${ctx }/skin/default/images/icon/Alert_09.gif"/>
   [${title }]任务回复
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">回复给：</td>
<!-- 	            <td> -->
	           	
		              <td class="tableContent" ><input type="hidden" name="answerBy" value="${answerBy}" />${answerBy }</td> 
<!-- 	           </td> -->
	             

	            	
	     
	        </tr>		
	
	        <tr>
	            <td class="columnTitle">任务主题：</td>
	            <td class="tableContent"  colspan="2">
	            	${title }
	            </td>
	        </tr>	
<!-- 	         <tr> -->
<!-- 	            <td class="columnTitle">状态：</td> -->
<!-- 	            <td class="tableContentAuto"> -->
<%-- 	              <input type="radio" name="state" class="input" ${state==0?'checked':'' } value="0">停用  --%>
<%-- 	              <input type="radio" name="state" class="input"  ${state==1?'checked':'' } value="1">启用  --%>
<!-- 	            </td> -->
<!-- 	        </tr>	 -->
	        <tr>
	        	<td class="columnTitle">回复内容：</td>
	            <td class="tableContent" colspan="2"><textarea name="strInfo" 
	            	placeholder="   请在此处填写回复内容" style="height:250px;"></textarea>
	            
	        </tr>	
	     
	 
		</table>
	</div>
 </form>
</body>
</html>