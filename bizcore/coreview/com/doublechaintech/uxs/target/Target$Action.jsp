
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty target}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Target" style="color: green">${userContext.localeMap['target']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['target.id']}</span> ${target.id}</li>
<li><span>${userContext.localeMap['target.name']}</span> ${target.name}</li>
<li><span>${userContext.localeMap['target.location']}</span> ${target.location}</li>
<li><span>${userContext.localeMap['target.last_update']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${target.lastUpdate}" /></li>

	
	</ul>
</div>



</c:if>


