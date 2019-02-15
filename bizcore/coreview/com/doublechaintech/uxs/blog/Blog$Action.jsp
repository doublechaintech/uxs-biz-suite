
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty blog}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Blog" style="color: green">${userContext.localeMap['blog']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['blog.id']}</span> ${blog.id}</li>
<li><span>${userContext.localeMap['blog.title']}</span> ${blog.title}</li>
<li><span>${userContext.localeMap['blog.content']}</span> ${blog.content}</li>
<li><span>${userContext.localeMap['blog.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${blog.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


