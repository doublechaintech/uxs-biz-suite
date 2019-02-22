
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty brand}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Brand">${userContext.localeMap['brand']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./brandManager/view/${brand.id}/"> ${brand.id}</a></li>
<li><span>${userContext.localeMap['brand.brand_name']}</span> ${brand.brandName}</li>
<li><span>${userContext.localeMap['brand.logo']}</span> ${brand.logo}</li>
<li><span>${userContext.localeMap['brand.remark']}</span> ${brand.remark}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




