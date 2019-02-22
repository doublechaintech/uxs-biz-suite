
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topRatedProduct}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A TopRatedProduct">${userContext.localeMap['top_rated_product']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./topRatedProductManager/view/${topRatedProduct.id}/"> ${topRatedProduct.id}</a></li>
<li><span>${userContext.localeMap['top_rated_product.name']}</span> ${topRatedProduct.name}</li>
<li><span>${userContext.localeMap['top_rated_product.product_cover_image']}</span> ${topRatedProduct.productCoverImage}</li>
<li><span>${userContext.localeMap['top_rated_product.origin']}</span> ${topRatedProduct.origin}</li>
<li><span>${userContext.localeMap['top_rated_product.remark']}</span> ${topRatedProduct.remark}</li>
<li><span>${userContext.localeMap['top_rated_product.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${topRatedProduct.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




