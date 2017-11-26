<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>
<script language="javascript" src="${ctx}/js/common.js"></script> 
<ul>
            <c:set var="aaa" value=""/>
            <!-- 遍历当前登录用户的角色列表 -->
			<c:forEach items="${_CURRENT_USER.roles }" var="role">
			       <!-- 遍历每个角色下的模块 -->
			       <c:forEach items="${role.modules }" var="module">
			            <!-- 如果该模块没有输出过，则要进行输出，否则这个模块就不输出 -->
			            <c:if test="${(moduleName eq module.remark) and module.ctype==1  }">
				               <c:if test="${fn:contains(aaa,module.cpermission) eq false }">
				                  <c:set var="aaa" value="${aaa},${module.cpermission }"/>
			                      <li><a href="${ctx}/${module.curl}" onclick="linkHighlighted(this);addClick(this)" target="main" id="aa_1">${module.cpermission }</a></li>
			                 </c:if>  
			            </c:if>
			            
			       </c:forEach>
			</c:forEach>
</ul>


	<script type="text/javascript">
		function addClick(obj) {
			/* var moduleid = "" + obj + ""; */
			var url = "http://${header['host']}${pageContext.request.contextPath}/menuAction_addClickNum?module=" + obj;
	        $.get(url);
		}
	</script>