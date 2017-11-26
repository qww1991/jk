<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="./base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
	<title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>
	<script language="javascript" src="${ctx}/js/common.js"></script> 
<style> 
	.curbody{ CURSOR: url(${ctx}/images/olmsg/shubiao.ani);background:url(${ctx}/images/olmsg/pic738x571.jpg); }
	.msgcontent{ width:218px;overflow:hidden;word-break:break-all;padding:10px;font-size:14px;color:#339966;font-family:Tahoma;line-height:180%; }
	.msgcontent p{ text-indent:0px;}
	.msgcontent ul( margin:0px;}
	.msgbackcontent{ width:218px;overflow:hidden;word-break:break-all;padding:10px;font-size:14px;color:#339966;font-family:Tahoma;line-height:180%; }
	.msgbackcontent p{ text-indent:0px;}
	.msgbackcontent ul( margin:0px;}
	li{ text-indent:0px;margin:0px;list-style:default; }
</style>
	
</head>
<script language="javascript"> 
if(top.location!=main.location){
	top.location = main.location;
}
//-- 控制层移动start of script -->
var Obj='';
var index=10000;//z-index;
var color='';
var str='';
document.onmouseup=MUp
document.onmousemove=MMove
 
function MMove(){
	if(Obj!=''){
		document.all(Obj).style.left=event.x-pX;
		document.all(Obj).style.top=event.y-pY;
	}
}
 
function MUp(){
	if(Obj!=''){
		document.all(Obj).releaseCapture();
		Obj='';
	}
	var srcEle = event.srcElement;
	
	var children = srcEle.children;
	if(children.length>0){
		children[1].value = "1";		//isChange
		children[2].value = event.x-pX;
		children[3].value = event.y-pY;
	}
}
 
function MDown(objtd,id){
	Obj=id
	document.all(Obj).setCapture()
	pX = event.x-document.all(Obj).style.pixelLeft;
	pY = event.y-document.all(Obj).style.pixelTop;
}
 
//-- 控制层移动end of script -->
//获得焦点;
function getFocus(obj) {
    var posX;
    var posY;
    var id=obj.id;
    fwuss = document.getElementById(id);
    posX = event.x - fwuss.offsetLeft;//获得横坐标x
    posY = event.y - fwuss.offsetTop;//获得纵坐标y
    document.onmousemove = mousemove;//调用函数，只要一直按着按钮就能一直调用
	document.onmouseup = function(){
        document.onmousemove = null;//鼠标举起，停止
        fwuss = null;
    }
    function mousemove(ev){
        if(ev==null) ev = window.event;//IE
        fwuss.style.left = (ev.clientX - posX) + "px";
        fwuss.style.top = (ev.clientY - posY) + "px";
    }
}
 
//针对未已阅的、未回复的、工作任务
function msgrevoke( id ){
	if(confirm("完成任务了?")){
		//_Submit("/home/olmsgRevokeAction.do?flag=revoke&id="+id,null,"撤销");
	}
}
 
//需回复的留言
function msgback( id ){
	//_Submit("/home/olmsgUpdateAction.do?flag=back&id="+id,null,"回复");
}

function CPos(x, y)
{
    this.x = x;
    this.y = y;
}
function GetObjPos(ATarget){
    var target = ATarget;
    var pos = new CPos(target.offsetLeft, target.offsetTop);
     
    var target = target.offsetParent;
    while (target)
    {
        pos.x += target.offsetLeft;
        pos.y += target.offsetTop;
         
        target = target.offsetParent
    }
    return pos;
}
 
var obj =  document.getElementById('test')
alert(GetObjPos(obj)['y']) //y坐标
alert(GetObjPos(obj)['x']) //x坐标
     
 
function msgupdate(id){
	var divedit = document.getElementById(id);
	var inputElement = document.createElement("textarea");  
    // 把obj里面的元素以及文本内容赋值给新建的inputElement  
    inputElement.value = divedit.innerHTML;  
    inputElement.style.height = '200px';
    // 用新建的inputElement代替原来的oldDivElement元素  
    divedit.parentNode.replaceChild(inputElement, divedit);  
    // 当inputElement失去焦点时触发下面函数，使得input变成div  
    inputElement.onblur = function() {  
        //把input的值交给原来的div  
        var content = divedit.innerHTML = inputElement.value;  
        //用原来的div重新替换inputElement  
        inputElement.parentNode.replaceChild(divedit, inputElement);
        var divPos=GetObjPos(divedit);
        var left = divPos.x;
        var top = divPos.y;
        var url = "${ctx}/homeAction_updateBBS?content=" + content + "&left=" + left + "&top=" + top + "&id=" + id;
        $.get(url);
    }  
}
 
function msgdel( id ){
	if(confirm("任务完成了?")){
		var url = "${ctx }/homeAction_delBBS?id=" + id;
		window.self.location = url;
        /* $.get(url); */
	}
}
 
function msgstate( id , flag ){
	if(flag=="read"){
		if(!confirm("是否确定已阅此条信息?")){
			return false;
		}
	}else if(flag=="accept"){
		if(!confirm("是否确定接受此任务?")){
			return false;
		}
	}else if(flag=="fail"){
		if(!confirm("是否确定此任务未完成?")){
			return false;
		}
	}else if(flag=="success"){
		if(!confirm("是否确定此任务已完成?")){
			return false;
		}
	}else if(flag=="finished"){
		if(!confirm("是否确定完成?")){
			return false;
		}
	}
	//_Submit("/home/olmsgStateAction.do?flag="+flag+"&delId="+id,null,"已阅");
}
 
function changRowColor(obj){
	//obj.removeAttribute("className");
	//alert(obj.className);
	//obj.setAttribute("bgcolor","#FFECB0");
	//obj.sytle.backgroundColor = "#FFECB0";
}
 
function removeOverRowColor(obj){
	//alert(obj.getAttribute("style"));
}
 
function killErrors() {
	return true;
}
 
window.onerror = killErrors;
</script>

<body class="curbody">
 
<form name="form2">
<!-- 工具栏部分 ToolBar -->
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
 
<li id="new"><a href="${ctx }/homeAction_newBBS">新建</a></li>
 
<li id="stat"><a href="${ctx }/homeAction_BBShistory">历史</a></li>
 
</ul>
    </div>
</div>
</div>
</div>
 
<logic:notEmpty name="olmsgList">
  <c:forEach items="${userBBSList}" var="o">
		<div id='${o.id}' style='position:absolute;left:${o.left}px;top:${o.top}px;z-index:1001; height:164px;background:none;' >
			<table border=0 cellspacing="0" cellpadding="0" width="220">
				<tr>
					<td id='${o.id }' style='cursor:move;' onmousedown='getFocus(this)' background="${ctx}/images/olmsg/${o.backGround1}" height="45">
						<input type="hidden" name="id" class="input" value="${o.id}" />
						&nbsp;
					</td>
				</tr>
				<tr>
					<td style='cursor:move;white-space:nowrap;' width='100%' background="${ctx}/images/olmsg/${o.backGround2}" >
						<div style="float:left;width:130px;padding-left:7px;font-family:Tahoma;color:gray;font-style : oblique;">
							${o.create_time }
						</div>
						<div style="float:right;width:80px;text-align:right;padding-right:7px;">
							<a style='cursor:pointer;' title="编辑" onclick="msgupdate('${o.id}msg${o.user_id}')"><img src="${ctx}/images/olmsg/doc_edit.gif"/></a>
							<a style='cursor:pointer;' title="删除" onclick="msgdel('${o.id}del${o.user_id }')"><img src="${ctx}/images/olmsg/doc_del.gif"/></a>
						</div>
					</td>
				</tr>
				<tr>
					<td background="${ctx}/images/olmsg/${o.backGround2}">
					<div id='${o.id}msg${o.user_id }' class="msgcontent" contenteditable="ture">${o.content }</div>
					</td>
				</tr>
				<tr>
					<td id="tagBPic" background="${ctx}/images/olmsg/${o.backGround3}" height="63">
						<table border="0" width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td width="50" align="center">
								<img border="0" src="${ctx}/images/olmsg/${o.icon}">
								</td>
								<td style="text-align:right;padding-right:8px;" nowrap>
								[备忘]
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
</c:forEach>
</logic:notEmpty>
</form>
</body>
</html>

