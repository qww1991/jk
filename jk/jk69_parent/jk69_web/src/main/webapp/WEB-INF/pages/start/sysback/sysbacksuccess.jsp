<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="../components/jquery-ui/jquery-1.8.3.js" type="text/javascript"></script>
<%-- 	<meta http-equiv="refresh" content="3;URL=${ctx }/login"> --%>
	<title></title>
</head>
	<script type="text/javascript">
	
	$(function(){
		var t=3;//设定跳转的时间 
		setInterval(refer,1000); //启动1秒定时 
		function refer(){ 
			if(t==0){ 
			toModule('home'); //#设定跳转的链接地址 
		} 
		document.getElementById('show').innerHTML="<font size=\"6\" color=\"blue\" >"+t+"秒后跳转到主页</font>"; // 显示倒计时 
// 		<font size="3" >按确认返回主页</font>
		t--; // 计数器递减 
		} 
	})
	function toModule(moduleName){
			top.leftFrame.location.href = 'homeAction_toleft.action?moduleName=' + moduleName;
			top.main.location.href = 'homeAction_tomain.action?moduleName=' + moduleName;
// 			linkHighlightMenu(this);
		}
	</script>
<body>
<s:debug></s:debug>
<form name="icform" method="post">
      <input type="hidden" name="id" value="${id}"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
	<ul>
		<li id="save"><a href="#" onclick="toModule('home');this.blur();">确认</a></li>
		<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
	</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img width="30" src="${ctx }/skin/default/images/icon/Alert_09.gif"/>
   系统使用反馈
  </div> 

 
	<div style="height: 50" ><font size="5" >系统使用反馈发送成功</font></div>
	<div style="height: 50" ><font size="4" >已将反馈信息以邮件形式发送给系统管理员，并短信通知其尽快处理了。</font></div>
	<div><span id="show" style="height: 100" ></span></div>
	<div><font size="5" style="height: 100" >如果3秒后页面没有跳转,按确认返回主页</font></div>
	
	
 </form>
</body>
</html>