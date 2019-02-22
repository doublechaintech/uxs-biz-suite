
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty site}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Site" style="color: green">${userContext.localeMap['site']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['site.id']}</span> ${site.id}</li>
<li><span>${userContext.localeMap['site.name']}</span> ${site.name}</li>
<li><span>${userContext.localeMap['site.introduction']}</span> ${site.introduction}</li>
<li><span>${userContext.localeMap['site.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${site.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


