<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	    <title></title>
	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css" media="all"/>
	<script language="javascript" src="${ctx}/js/common.js"></script>
	<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="${ctx}/skin/default/js/toggle.js"></script>
	
		<script type="text/javascript">
			$(function(){
				$("#toRight1").click(function(){
					$("#left option:selected:first").appendTo($("#right"));
				})
				$("#toRight2").click(function(){
					$("#left option:selected").appendTo($("#right"));
				})
				$("#toRight3").click(function(){
					$("#left option").appendTo($("#right"));
				})
				$("#toLeft1").click(function(){
					$("#right option:selected:first").appendTo($("#left"));
				})
				$("#toLeft2").click(function(){
					$("#right option:selected").appendTo($("#left"));
				})
				$("#toLeft3").click(function(){
					$("#right option").appendTo($("#left"));
				})
			})
			function toUpdate(){
				var modules = document.getElementById("right");
				var mdata = "";
				if (modules.length > 6) {
					 alert("模块数量不能超过6个");
					return false;
				}
				for (var int = 0; int < modules.length; int++) {
					if (int < modules.length - 1) {
						mdata += modules.options[int].value + "_";
					} else {
						mdata += modules.options[int].value;
					}
				}
				
				$.post("${ctx}/menuAction_updateCustomModule",
						  {
						    ids:mdata
						  },
						  function(data,status){
						    alert("修改模块成功");
						  });
				}
		</script>
	</head>

	<body>
	<div id="menubar">
	<div id="middleMenubar">
	<div id="innerMenubar">
  	<div id="navMenubar">
	<ul>
		<li id="update"><a href="#" onclick="toUpdate()">保存</a></li>
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
     自定义模块列表
  </div> 
  </div>
  </div>
  
<div>
	
	<h1 align="left">拥有模块列表
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	用户自定义模块列表</h1>
		<table>
			<tr>
				<td>
					<select id="left" multiple="true" style="width:300px" size="30">
					 <c:forEach items="${noCustomList}" var="o">
						<option value="${o.id }">${o.moduleName }</option>
					</c:forEach>
					</select>
				</td>
				<td align="justify">
					<input type="button" style="width:100px;height:30px;" value=">" id="toRight1"><br><br>
					<input type="button" style="width:100px;height:30px;" value=">>" id="toRight2"><br><br>
					<input type="button" style="width:100px;height:30px;" value=">>>" id="toRight3"><br><br><br><br><br><br><br>
					<input type="button" style="width:100px;height:30px;" value="<" id="toLeft1"><br><br>
					<input type="button" style="width:100px;height:30px;" value="<<" id="toLeft2"><br><br>
					<input type="button" style="width:100px;height:30px;" value="<<<" id="toLeft3"><br>
				</td>
				<td>
					<select id="right" multiple="multiple" style="width:300px" size="30">
						<c:forEach items="${addCustomList}" var="o">
							<option value="${o.id }">${o.moduleName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</body>
</html>