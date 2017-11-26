<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
      <input type="hidden" name="id" value="${id}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
<li id="save"><a href="#" onclick="formSubmit('opinionAction_save','_self');this.blur();">回复</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/id_card.png"/>
   查看反馈
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">收件人：</td>
	            <td class="tableContent">${inputBy }</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">主题：</td>
	            <td class="tableContent">${title }</td>
	        </tr>		
	           <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContent">
	            <c:if test="${state==0 }">未处理</c:if>
		  		<c:if test="${state==1 }">已处理</c:if>
		  		</td>
	        </tr>	
	          <tr>
	            <td class="columnTitle">难度：</td>
	            <td class="tableContent">
	            <c:if test="${difficulty==1 }">★★★★</c:if>
		  		<c:if test="${difficulty==2 }">★★★</c:if>
		  		<c:if test="${difficulty==3 }">★★</c:if>
		  		<c:if test="${difficulty==4 }">★</c:if>
		  		</td>
	        </tr>		
	         <tr>
	            <td class="columnTitle">反馈日期：</td>
	            
	            <td class="tableContent"><fmt:formatDate value='${createTime }' pattern='yyyy-MM-dd HH:mm:ss' /></td>
	        </tr>	
	         <tr>
	            <td class="columnTitle">反馈内容：</td>
	            <td class="tableContent">${content }</td>
	        </tr>	
     <div>
         <tr>
	            <td class="columnTitle">${infoList[0].inputBy} 回复  ${infoList[0].getBy}  ：</td>
	            <td class="tableContent">${infoList[0].inputInfo}</td>
	        </tr>	
         <tr>
	            <td class="columnTitle">${infoList[1].inputBy} 回复  ${infoList[1].getBy}  ：</td>
	            <td class="tableContent">${infoList[1].inputInfo}</td>
	        </tr>	
         <tr>
	            <td class="columnTitle">${infoList[2].inputBy} 回复  ${infoList[2].getBy}  ：</td>
	            <td class="tableContent">${infoList[2].inputInfo}</td>
	        </tr>	
	        <tr>
	        	<td class="columnTitle">回复内容：</td>
	            <td class="tableContent" colspan="2"><textarea name="strInfo" 
	            	placeholder="   请在此处填写回复内容" style="height:100px;"></textarea>
	            
	        </tr>	
     
     
     </div>
		</table>
	</div>
 </form>
</body>
</html>