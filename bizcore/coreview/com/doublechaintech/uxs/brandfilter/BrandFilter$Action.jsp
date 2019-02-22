
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty brandFilter}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A BrandFilter" style="color: green">${userContext.localeMap['brand_filter']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['brand_filter.id']}</span> ${brandFilter.id}</li>
<li><span>${userContext.localeMap['brand_filter.name']}</span> ${brandFilter.name}</li>
<li><span>${userContext.localeMap['brand_filter.internal_id']}</span> ${brandFilter.internalId}</li>

	
	</ul>
</div>



</c:if>


