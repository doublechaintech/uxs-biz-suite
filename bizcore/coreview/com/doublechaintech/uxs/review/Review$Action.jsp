
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty review}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Review" style="color: green">${userContext.localeMap['review']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['review.id']}</span> ${review.id}</li>
<li><span>${userContext.localeMap['review.title']}</span> ${review.title}</li>
<li><span>${userContext.localeMap['review.content']}</span> ${review.content}</li>
<li><span>${userContext.localeMap['review.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${review.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


