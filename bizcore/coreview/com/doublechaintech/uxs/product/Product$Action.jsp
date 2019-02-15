
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty product}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Product" style="color: green">${userContext.localeMap['product']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['product.id']}</span> ${product.id}</li>
<li><span>${userContext.localeMap['product.name']}</span> ${product.name}</li>
<li><span>${userContext.localeMap['product.avarage_score']}</span> ${product.avarageScore}</li>

	
	</ul>
</div>



</c:if>


