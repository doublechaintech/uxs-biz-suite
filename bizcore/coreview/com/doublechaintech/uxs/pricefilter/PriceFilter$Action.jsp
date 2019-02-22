
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty priceFilter}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PriceFilter" style="color: green">${userContext.localeMap['price_filter']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['price_filter.id']}</span> ${priceFilter.id}</li>
<li><span>${userContext.localeMap['price_filter.name']}</span> ${priceFilter.name}</li>
<li><span>${userContext.localeMap['price_filter.price_start']}</span> ${priceFilter.priceStart}</li>
<li><span>${userContext.localeMap['price_filter.price_end']}</span> ${priceFilter.priceEnd}</li>

	
	</ul>
</div>



</c:if>


