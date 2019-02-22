
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty newProduct}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A NewProduct" style="color: green">${userContext.localeMap['new_product']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['new_product.id']}</span> ${newProduct.id}</li>
<li><span>${userContext.localeMap['new_product.name']}</span> ${newProduct.name}</li>
<li><span>${userContext.localeMap['new_product.product_cover_image']}</span> ${newProduct.productCoverImage}</li>
<li><span>${userContext.localeMap['new_product.origin']}</span> ${newProduct.origin}</li>
<li><span>${userContext.localeMap['new_product.remark']}</span> ${newProduct.remark}</li>
<li><span>${userContext.localeMap['new_product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${newProduct.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


