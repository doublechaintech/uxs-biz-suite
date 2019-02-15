
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty banner}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Banner" style="color: green">${userContext.localeMap['banner']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['banner.id']}</span> ${banner.id}</li>
<li><span>${userContext.localeMap['banner.name']}</span> ${banner.name}</li>
<li><span>${userContext.localeMap['banner.image_path']}</span> ${banner.imagePath}</li>
<li><span>${userContext.localeMap['banner.last_update']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${banner.lastUpdate}" /></li>

	
	</ul>
</div>



</c:if>


