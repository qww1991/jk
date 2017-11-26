<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
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
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
   
  <div class="textbox-title" >
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   商品详情
  </div>
  


    <div >
    
		<table class="commonTable" cellspacing="1" style="width: 200"  colspan ="2" >
	        <tr hidden="true">
	            <td class="columnTitle">：</td>
	            <td class="tableContent">${id}</td>
	        </tr>	
	        	    
	        <tr>
	            <td class="columnTitle">商品编号：</td>
	            <td class="tableContent">${productNo}</td>
	 			
	            <td class="columnTitle">商品图片：</td>
	            <td class="tableContent">${productImage}</td>
	            <td  rowspan="8"><img height="300" width="250" src="${pageContext.request.contextPath}/images/${productImage}"></td>  
	        </tr>	
	        <tr hidden="true">
	            <td class="columnTitle">：</td>
	            <td class="tableContent">${factoryId}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">商品描述：</td>
	            <td class="tableContent">${description}</td>

	            <td class="columnTitle">生产厂：</td>
	            <td class="tableContent">${factoryName}</td>
	            
	        </tr>	
	        <tr>
	            <td class="columnTitle">价格：</td>
	            <td class="tableContent">${price}</td>
	
	            <td class="columnTitle">尺寸长：</td>
	            <td class="tableContent">${sizeLenght}</td>
	           
	        </tr>	
	        <tr>
	            <td class="columnTitle">尺寸宽：</td>
	            <td class="tableContent">${sizeWidth}</td>
	
	            <td class="columnTitle">尺寸高：</td>
	            <td class="tableContent">${sizeHeight}</td>
	           
	        </tr>	
	        <tr>
	            <td class="columnTitle">颜色：</td>
	            <td class="tableContent">${color}</td>

	            <td class="columnTitle">包装：</td>
	            <td class="tableContent">${packing}</td>
	           
	        </tr>	
	        <tr>
	            <td class="columnTitle">包装单位：</td>
	            <td class="tableContent">${packingUnit}</td>

	            <td class="columnTitle">集装箱类别20：</td>
	            <td class="tableContent">${type20}</td>
	           
	        </tr>	
	        <tr>
	            <td class="columnTitle">集装箱类别40：</td>
	            <td class="tableContent">${type40}</td>

	            <td class="columnTitle">集装箱类别40HC：</td>
	            <td class="tableContent">${type40hc}</td>
	            
	        </tr>	
	        <tr>
	            <td class="columnTitle">数量：</td>
	            <td class="tableContent">${qty}</td>

	            <td class="columnTitle">体积：</td>
	            <td class="tableContent">${cbm}</td>
	           
	        </tr>	
	        <tr>
	            <td class="columnTitle">大箱尺寸长：</td>
	            <td class="tableContent">${mpsizeLenght}</td>

	            <td class="columnTitle">大箱尺寸宽：</td>
	            <td class="tableContent">${mpsizeWidth}</td>
	            <td></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">大箱尺寸高：</td>
	            <td class="tableContent">${mpsizeHeight}</td>
	
	            <td class="columnTitle">备注：</td>
	            <td class="tableContent">${remark}</td>
	            <td></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">录入时间：</td>
	            <td class="tableContent">${inputTime}</td>
	            <td></td>
	        </tr>	
<%-- 	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent">${createBy}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent">${createDept}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">：</td>
	            <td class="tableContent">${createTime}</td>
	        </tr>	 --%>
		</table>
	</div>
 
 
</form>
</body>
</html>

