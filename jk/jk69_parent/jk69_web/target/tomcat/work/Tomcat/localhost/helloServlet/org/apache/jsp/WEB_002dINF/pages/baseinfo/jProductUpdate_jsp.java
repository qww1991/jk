/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2017-11-20 12:11:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.baseinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jProductUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/pages/baseinfo/../base.jsp", Long.valueOf(1510964483203L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("<head>\r\n");
      out.write("\t<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"icform\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("<div id=\"menubar\">\r\n");
      out.write("<div id=\"middleMenubar\">\r\n");
      out.write("<div id=\"innerMenubar\">\r\n");
      out.write("  <div id=\"navMenubar\">\r\n");
      out.write("<ul>\r\n");
      out.write("<li id=\"save\"><a href=\"#\" onclick=\"formSubmit('baseProductAction_update','_self');this.blur();\">保存</a></li>\r\n");
      out.write("<li id=\"back\"><a href=\"#\" onclick=\"history.go(-1);\">返回</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("   \r\n");
      out.write("  <div class=\"textbox-title\">\r\n");
      out.write("\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/skin/default/images/icon/currency_yen.png\"/>\r\n");
      out.write("   修改产品\r\n");
      out.write("  </div> \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("    <div>\r\n");
      out.write("\t\t<table class=\"commonTable\" cellspacing=\"1\">\r\n");
      out.write("\t        <tr hidden=\"true\">\r\n");
      out.write("\t            <td class=\"columnTitle\">：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"productId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">商品编号：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"productNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">商品图片：</td>\r\n");
      out.write("\t            <td class=\"tableContent\">\r\n");
      out.write("\t           \r\n");
      out.write("\t            <input type=\"file\" name=\"file\" id=\"file\" class = \"file\"/>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr hidden=\"true\">\r\n");
      out.write("\t            <td class=\"columnTitle\">：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"factoryId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${factoryId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">商品描述：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"description\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">生产厂：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"factoryName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${factoryName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">价格：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"price\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">尺寸长：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"sizeLenght\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sizeLenght}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">尺寸宽：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"sizeWidth\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sizeWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\r\n");
      out.write("\t            <td class=\"columnTitle\">尺寸高：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"sizeHeight\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sizeHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">颜色：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"color\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${color}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">包装：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"packing\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packing}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">包装单位：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"packingUnit\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${packingUnit}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\r\n");
      out.write("\t            <td class=\"columnTitle\">集装箱类别20：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"type20\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type20}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">集装箱类别40：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"type40\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type40}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">集装箱类别40HC：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"type40hc\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type40hc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">数量：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"qty\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${qty}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">体积：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"cbm\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cbm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">大箱尺寸长：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"mpsizeLenght\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mpsizeLenght}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">大箱尺寸宽：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"mpsizeWidth\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mpsizeWidth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">大箱尺寸高：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"number\" name=\"mpsizeHeight\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mpsizeHeight}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\r\n");
      out.write("\t            <td class=\"columnTitle\">备注：</td>\r\n");
      out.write("\t            <td class=\"tableContent\"><input type=\"text\" name=\"remark\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${remark}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td class=\"columnTitle\">录入时间：</td>\r\n");
      out.write("\t            <td class=\"tableContent\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" style=\"width:90px;\" name=\"inputTime\"\r\n");
      out.write("\t            \t value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inputTime}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t             \tonclick=\"WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t        </tr>\t\r\n");
      out.write("\t        \r\n");
      out.write("\t        \r\n");
      out.write("\t        \r\n");
      out.write("\t        \r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
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
    // /WEB-INF/pages/baseinfo/../base.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/pages/baseinfo/../base.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/baseinfo/../base.jsp(5,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
