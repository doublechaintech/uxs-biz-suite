
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty categoryFilter}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A CategoryFilter" style="color: green">${userContext.localeMap['category_filter']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['category_filter.id']}</span> ${categoryFilter.id}</li>
<li><span>${userContext.localeMap['category_filter.name']}</span> ${categoryFilter.name}</li>
<li><span>${userContext.localeMap['category_filter.internal_id']}</span> ${categoryFilter.internalId}</li>

	
	</ul>
</div>



</c:if>


