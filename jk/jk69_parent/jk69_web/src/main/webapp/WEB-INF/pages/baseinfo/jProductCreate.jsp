<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post" enctype="multipart/form-data">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('baseProductAction_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增商品
  </div> 
    <div>
		<table class="commonTable" cellspacing="1">

	        <tr>
	            <td class="columnTitle">商品编号：</td>
	            <td class="tableContent"><input type="text" name="productNo" value=""/></td>
	
	            <!-- <td class="columnTitle">商品图片：</td>
	            <td class="tableContent"><input type="text" name="productImage" value=""/></td> -->
	       		<td class="columnTitle">商品图片：</td>
	       <td class="tableContent">
	       
	       
	       <input type="file" name="file" id="file"class = "file" />
	       
	       
	       </td>
	       
	        </tr>	
	        <tr>
	            <td class="columnTitle">商品描述：</td>
	            <td class="tableContent"><input type="text" name="description" value=""/></td>
	       	

	       
	            <td class="columnTitle">生产厂：	</td>
	             <td class="tableContent" align="left">
	            
	            <s:select name="factory.id" list="factoryList"
	            		listKey="id" listValue="factoryName"
	            		headerKey="" headerValue="--请选择--"
	            	></s:select>
	            </td>

	        </tr>	
	        
	        <tr hidden="ture">
	            <td class="columnTitle">生产厂Id：</td>
	            <td class="tableContent"><input type="text" name="factoryId" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">价格：</td>
	            <td class="tableContent"><input type="number" name="price" value=""/></td>
	   
	            <td class="columnTitle">尺寸长：</td>
	            <td class="tableContent"><input type="number" name="sizeLenght" value=""/></td>
	        </tr>	
	        <tr>
	             <td class="columnTitle">尺寸宽：</td>
	            <td class="tableContent"><input type="number" name="sizeWidth" value=""/></td>
	    
	            <td class="columnTitle">尺寸高：</td>
	            <td class="tableContent"><input type=number name="sizeHeight" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">颜色：</td>
	            <td class="tableContent"><input type="text" name="color" value=""/></td>
	  
	            <td class="columnTitle">包装：</td>
	            <td class="tableContent"><input type="text" name="packing" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packingUnit" value=""/></td>

	            <td class="columnTitle">集装箱类别20：</td>
	            <td class="tableContent"><input type="number" name="type20" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">集装箱类别40：</td>
	            <td class="tableContent"><input type="number" name="type40" value=""/></td>

	            <td class="columnTitle">集装箱类别40HC：</td>
	            <td class="tableContent"><input type="number" name="type40hc" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">数量：</td>
	            <td class="tableContent"><input type="number" name="qty" value=""/></td>

	            <td class="columnTitle">体积：</td>
	            <td class="tableContent"><input type="number" name="cbm" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">大箱尺寸长：</td>
	            <td class="tableContent"><input type="number" name="mpsizeLenght" value=""/></td>

	            <td class="columnTitle">大箱尺寸宽：</td>
	            <td class="tableContent"><input type="number" name="mpsizeWidth" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">大箱尺寸高：</td>
	            <td class="tableContent"><input type="number" name="mpsizeHeight" value=""/></td>
	
	            <td class="columnTitle">备注：</td>
	            <td class="tableContent"><input type="text" name="remark" value=""/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">录入时间：</td>
	            
	        
	        	<td class="tableContent">
					<input type="text" style="width:90px;" name="inputTime"
	            	 value=""
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        
	        
	        </tr> 
	    	
		</table>
	</div>
 
 
</form>
</body>
</html>

