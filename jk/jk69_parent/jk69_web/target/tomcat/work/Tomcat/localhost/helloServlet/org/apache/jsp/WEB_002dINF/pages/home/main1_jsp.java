/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-11-20 08:11:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/pages/home/../base.jsp", Long.valueOf(1510964483203L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/default.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/table.css\" media=\"all\"/>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title></title>\r\n");
      out.write("    <link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/css/default.css\" media=\"all\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/components/jquery-ui/jquery-1.2.6.js\"></script>\r\n");
      out.write("\t<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script> \r\n");
      out.write("<style> \r\n");
      out.write("\t.curbody{ CURSOR: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/olmsg/shubiao.ani);background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/olmsg/pic738x571.jpg); }\r\n");
      out.write("\t.msgcontent{ width:218px;overflow:hidden;word-break:break-all;padding:10px;font-size:14px;color:#339966;font-family:Tahoma;line-height:180%; }\r\n");
      out.write("\t.msgcontent p{ text-indent:0px;}\r\n");
      out.write("\t.msgcontent ul( margin:0px;}\r\n");
      out.write("\t.msgbackcontent{ width:218px;overflow:hidden;word-break:break-all;padding:10px;font-size:14px;color:#339966;font-family:Tahoma;line-height:180%; }\r\n");
      out.write("\t.msgbackcontent p{ text-indent:0px;}\r\n");
      out.write("\t.msgbackcontent ul( margin:0px;}\r\n");
      out.write("\tli{ text-indent:0px;margin:0px;list-style:default; }\r\n");
      out.write("</style>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<script language=\"javascript\"> \r\n");
      out.write("if(top.location!=main.location){\r\n");
      out.write("\ttop.location = main.location;\r\n");
      out.write("}\r\n");
      out.write("//-- 控制层移动start of script -->\r\n");
      out.write("var Obj='';\r\n");
      out.write("var index=10000;//z-index;\r\n");
      out.write("var color='';\r\n");
      out.write("var str='';\r\n");
      out.write("document.onmouseup=MUp\r\n");
      out.write("document.onmousemove=MMove\r\n");
      out.write(" \r\n");
      out.write("function MMove(){\r\n");
      out.write("\tif(Obj!=''){\r\n");
      out.write("\t\tdocument.all(Obj).style.left=event.x-pX;\r\n");
      out.write("\t\tdocument.all(Obj).style.top=event.y-pY;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function MUp(){\r\n");
      out.write("\tif(Obj!=''){\r\n");
      out.write("\t\tdocument.all(Obj).releaseCapture();\r\n");
      out.write("\t\tObj='';\r\n");
      out.write("\t}\r\n");
      out.write("\tvar srcEle = event.srcElement;\r\n");
      out.write("\t\r\n");
      out.write("\tvar children = srcEle.children;\r\n");
      out.write("\tif(children.length>0){\r\n");
      out.write("\t\tchildren[1].value = \"1\";\t\t//isChange\r\n");
      out.write("\t\tchildren[2].value = event.x-pX;\r\n");
      out.write("\t\tchildren[3].value = event.y-pY;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function MDown(objtd,id){\r\n");
      out.write("\tObj=id\r\n");
      out.write("\tdocument.all(Obj).setCapture()\r\n");
      out.write("\tpX = event.x-document.all(Obj).style.pixelLeft;\r\n");
      out.write("\tpY = event.y-document.all(Obj).style.pixelTop;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("//-- 控制层移动end of script -->\r\n");
      out.write("//获得焦点;\r\n");
      out.write("function getFocus(obj) {\r\n");
      out.write("    var posX;\r\n");
      out.write("    var posY;\r\n");
      out.write("    var id=obj.id;\r\n");
      out.write("    fwuss = document.getElementById(id);\r\n");
      out.write("        posX = event.x - fwuss.offsetLeft;//获得横坐标x\r\n");
      out.write("        posY = event.y - fwuss.offsetTop;//获得纵坐标y\r\n");
      out.write("        document.onmousemove = mousemove;//调用函数，只要一直按着按钮就能一直调用\r\n");
      out.write("   \t\tdocument.onmouseup = function(){\r\n");
      out.write("        document.onmousemove = null;//鼠标举起，停止\r\n");
      out.write("        fwuss = null;\r\n");
      out.write("    }\r\n");
      out.write("    function mousemove(ev){\r\n");
      out.write("        if(ev==null) ev = window.event;//IE\r\n");
      out.write("        fwuss.style.left = (ev.clientX - posX) + \"px\";\r\n");
      out.write("        fwuss.style.top = (ev.clientY - posY) + \"px\";\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("//针对未已阅的、未回复的、工作任务\r\n");
      out.write("function msgrevoke( id ){\r\n");
      out.write("\tif(confirm(\"是否确定要撤销此条信息?\")){\r\n");
      out.write("\t\t//_Submit(\"/home/olmsgRevokeAction.do?flag=revoke&id=\"+id,null,\"撤销\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("//需回复的留言\r\n");
      out.write("function msgback( id ){\r\n");
      out.write("\t//_Submit(\"/home/olmsgUpdateAction.do?flag=back&id=\"+id,null,\"回复\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function CPos(x, y)\r\n");
      out.write("{\r\n");
      out.write("    this.x = x;\r\n");
      out.write("    this.y = y;\r\n");
      out.write("}\r\n");
      out.write("function GetObjPos(ATarget)\r\n");
      out.write("{\r\n");
      out.write("    var target = ATarget;\r\n");
      out.write("    var pos = new CPos(target.offsetLeft, target.offsetTop);\r\n");
      out.write("     \r\n");
      out.write("    var target = target.offsetParent;\r\n");
      out.write("    while (target)\r\n");
      out.write("    {\r\n");
      out.write("        pos.x += target.offsetLeft;\r\n");
      out.write("        pos.y += target.offsetTop;\r\n");
      out.write("         \r\n");
      out.write("        target = target.offsetParent\r\n");
      out.write("    }\r\n");
      out.write("    return pos;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("var obj =  document.getElementById('test')\r\n");
      out.write("alert(GetObjPos(obj)['y']) //y坐标\r\n");
      out.write("alert(GetObjPos(obj)['x']) //x坐标\r\n");
      out.write("     \r\n");
      out.write(" \r\n");
      out.write("function msgupdate(id){\r\n");
      out.write("\tvar divedit = document.getElementById(id);\r\n");
      out.write("\tvar inputElement = document.createElement(\"input\");  \r\n");
      out.write("    // 把obj里面的元素以及文本内容赋值给新建的inputElement  \r\n");
      out.write("    inputElement.value = divedit.innerHTML;  \r\n");
      out.write("  \r\n");
      out.write("    // 用新建的inputElement代替原来的oldDivElement元素  \r\n");
      out.write("    divedit.parentNode.replaceChild(inputElement, divedit);  \r\n");
      out.write("    // 当inputElement失去焦点时触发下面函数，使得input变成div  \r\n");
      out.write("    inputElement.onblur = function() {  \r\n");
      out.write("        //把input的值交给原来的div  \r\n");
      out.write("        var content = divedit.innerHTML = inputElement.value;  \r\n");
      out.write("        //用原来的div重新替换inputElement  \r\n");
      out.write("        inputElement.parentNode.replaceChild(divedit, inputElement);\r\n");
      out.write("        var divPos=GetObjPos(divedit);\r\n");
      out.write("        var left = divPos.x;\r\n");
      out.write("        var top = divPos.y;\r\n");
      out.write("        var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/homeAction_updateBBS?content=\" + content + \"&left=\" + left + \"&top=\" + top + \"&id=\" + id;\r\n");
      out.write("        $.get(url);\r\n");
      out.write("        /* window.self.location = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/homeAction_updateBBS?content=\" + content + \"&left=\" + left + \"&top=\" + top + \"&id=\" + id;  */\r\n");
      out.write("    }  \r\n");
      out.write("\t/* Submit(\"/home/olmsgUpdateAction.do?flag=\"+flag+\"&id=\"+id,null,\"修改\");\r\n");
      out.write("\tdocument.myForm.submit(); */\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function msgdel( id ){\r\n");
      out.write("\tif(confirm(\"是否确定要删除此条信息?\")){\r\n");
      out.write("\t\tvar url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/homeAction_removeBBS?id=\" + id;\r\n");
      out.write("\t\twindow.self.location = url;\r\n");
      out.write("        /* $.get(url); */\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function msgstate( id , flag ){\r\n");
      out.write("\tif(flag==\"read\"){\r\n");
      out.write("\t\tif(!confirm(\"是否确定已阅此条信息?\")){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else if(flag==\"accept\"){\r\n");
      out.write("\t\tif(!confirm(\"是否确定接受此任务?\")){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else if(flag==\"fail\"){\r\n");
      out.write("\t\tif(!confirm(\"是否确定此任务未完成?\")){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else if(flag==\"success\"){\r\n");
      out.write("\t\tif(!confirm(\"是否确定此任务已完成?\")){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else if(flag==\"finished\"){\r\n");
      out.write("\t\tif(!confirm(\"是否确定完成?\")){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//_Submit(\"/home/olmsgStateAction.do?flag=\"+flag+\"&delId=\"+id,null,\"已阅\");\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function changRowColor(obj){\r\n");
      out.write("\t//obj.removeAttribute(\"className\");\r\n");
      out.write("\t//alert(obj.className);\r\n");
      out.write("\t//obj.setAttribute(\"bgcolor\",\"#FFECB0\");\r\n");
      out.write("\t//obj.sytle.backgroundColor = \"#FFECB0\";\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function removeOverRowColor(obj){\r\n");
      out.write("\t//alert(obj.getAttribute(\"style\"));\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("function killErrors() {\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("window.onerror = killErrors;\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body class=\"curbody\">\r\n");
      out.write(" \r\n");
      out.write("<form name=\"form2\">\r\n");
      out.write("<!-- 工具栏部分 ToolBar -->\r\n");
      out.write("<div id=\"menubar\">\r\n");
      out.write("<div id=\"middleMenubar\">\r\n");
      out.write("<div id=\"innerMenubar\">\r\n");
      out.write("    <div id=\"navMenubar\">\r\n");
      out.write("<ul>\r\n");
      out.write(" \r\n");
      out.write("<li id=\"new\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/homeAction_newBBS\">新建</a></li>\r\n");
      out.write(" \r\n");
      out.write("</ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write("<logic:notEmpty name=\"olmsgList\">\r\n");
      out.write("  ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</logic:notEmpty>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/pages/home/../base.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/pages/home/../base.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/home/../base.jsp(5,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/pages/home/main1.jsp(217,2) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/home/main1.jsp(217,2) '${userBBSList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${userBBSList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/pages/home/main1.jsp(217,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("o");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<div id='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("' style='position:absolute;left:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.left}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("px;top:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.top}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("px;z-index:1001; height:164px;background:none;' onmousedown='getFocus(this)'>\r\n");
          out.write("\t\t\t<table border=0 cellspacing=\"0\" cellpadding=\"0\" width=\"220\">\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td style='cursor:move;' background=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.backGround1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" height=\"45\">\r\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"id\" class=\"input\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" />\r\n");
          out.write("\t\t\t\t\t\t&nbsp;\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td style='cursor:move;white-space:nowrap;' width='100%' background=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.backGround2}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" >\r\n");
          out.write("\t\t\t\t\t\t<div style=\"float:left;width:130px;padding-left:7px;font-family:Tahoma;color:gray;font-style : oblique;\">\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.create_time }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t<div style=\"float:right;width:80px;text-align:right;padding-right:7px;\">\r\n");
          out.write("\t\t\t\t\t\t\t<a style='cursor:pointer;' title=\"编辑\" onclick=\"msgupdate('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('m');
          out.write('s');
          out.write('g');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.user_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("')\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/doc_edit.gif\"/></a>\r\n");
          out.write("\t\t\t\t\t\t\t<a style='cursor:pointer;' title=\"删除\" onclick=\"msgdel('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('d');
          out.write('e');
          out.write('l');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.user_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("')\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/doc_del.gif\"/></a>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td background=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.backGround2}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t<div id='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('m');
          out.write('s');
          out.write('g');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.user_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("' class=\"msgcontent\" contenteditable=\"ture\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</div>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td id=\"tagBPic\" background=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.backGround3}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" height=\"63\">\r\n");
          out.write("\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
          out.write("\t\t\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td width=\"50\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<img border=\"0\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("/images/olmsg/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.icon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td style=\"text-align:right;padding-right:8px;\" nowrap>\r\n");
          out.write("\t\t\t\t\t\t\t\t[历史备忘]\r\n");
          out.write("\t\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t</table>\r\n");
          out.write("\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t</table>\r\n");
          out.write("\t\t</div>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
